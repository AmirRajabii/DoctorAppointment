package com.appointment.system.doctor_appointment.controller;

import com.appointment.system.doctor_appointment.convertor.AppointmentConvertor;
import com.appointment.system.doctor_appointment.model.dto.AppointmentDto;
import com.appointment.system.doctor_appointment.model.dto.TimeRange;
import com.appointment.system.doctor_appointment.model.entity.Appointment;
import com.appointment.system.doctor_appointment.model.entity.Doctor;
import com.appointment.system.doctor_appointment.service.AppointmentService;
import com.appointment.system.doctor_appointment.service.DoctorService;
import com.appointment.system.doctor_appointment.utils.TimeSplitter;
import jakarta.validation.constraints.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Validated
@RestController
@RequestMapping("/api/appointment")
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;

    @Autowired
    DoctorService doctorService;

    @PostMapping("/add-time-range")
    public ResponseEntity<?> addTimeRange(@RequestParam("doctorId") @NotNull Long doctorId,
                                          @RequestParam("startDateTime") @NotNull @Future LocalDateTime startDateTime,
                                          @RequestParam("endDateTime") @NotNull @Future LocalDateTime endDateTime,
                                          @RequestParam("intervalMinutes") @NotNull @Min(5) @Max(120) int intervalMinutes) {

        Optional<Doctor> doctor = doctorService.findById(doctorId);
        if (doctor.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(String.format("Doctor with ID %d not found", doctorId));
        List<TimeRange> timeRangeList = TimeSplitter.timeDivision(startDateTime, endDateTime, intervalMinutes);
        List<AppointmentDto> appointmentDtos = new ArrayList<>();
        timeRangeList.forEach(timeRange -> appointmentDtos.add(
                AppointmentConvertor.appointmentToAppointmentDTO(
                        appointmentService.save(
                                new Appointment(
                                        timeRange.start(),
                                        timeRange.end(),
                                        null,
                                        null,
                                        null,
                                        doctor.get()
                                )
                        )
                )
        ));
        return ResponseEntity.status(HttpStatus.CREATED).body(appointmentDtos);
    }

    @GetMapping("/get-appointment-list")
    public ResponseEntity<?> getAppointmentList(@RequestParam("doctorId") @NotNull Long doctorId) {

        Optional<Doctor> doctor = doctorService.findById(doctorId);
        if (doctor.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(String.format("Doctor with ID %d not found", doctorId));
        return ResponseEntity.ok(appointmentService.findAppointmentsByDoctorId(doctorId)
                .parallelStream()
                .map(AppointmentConvertor::appointmentToAppointmentDTO)
        );
    }

    @GetMapping("/get-open-appointment-list")
    public ResponseEntity<?> getOpenAppointmentList(@RequestParam("doctorId") @NotNull Long doctorId) {

        Optional<Doctor> doctor = doctorService.findById(doctorId);
        if (doctor.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(String.format("Doctor with ID %d not found", doctorId));
        List<Appointment> openAppointments = appointmentService.findOpenAppointmentsByDoctorId(doctorId);
        if (openAppointments.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Open Appointments Found");
        return ResponseEntity.ok(openAppointments.parallelStream().map(AppointmentConvertor::appointmentToAppointmentDTO)
        );
    }

    @DeleteMapping("/delete-appointment")
    public ResponseEntity<String> deleteAppointment(@RequestParam("appointmentId") @NotNull Long appointmentId) {

        Optional<Appointment> appointment = appointmentService.findById(appointmentId);
        if (appointment.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(String.format("Appointment with ID %d not found", appointmentId));
        if (appointment.get().getPatientPhoneNumber() != null)
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("This Appointment Has Been Taken By a Patient");
        appointmentService.delete(appointment.get());
        return ResponseEntity.ok("Appointment Successfully Deleted");
    }

    @PostMapping("/take-appointment")
    public ResponseEntity<?> takeAppointment(@RequestParam("appointmentId") @NotNull Long appointmentId,
                                             @RequestParam("phoneNumber") @NotNull @Pattern(regexp = "^\\d{11}$") String phoneNumber,
                                             @RequestParam("firstName") @NotNull @Size(min = 3, max = 50) String firstName,
                                             @RequestParam("lastName") @NotNull @Size(min = 3, max = 50) String lastName) {

        Optional<Appointment> appointment = appointmentService.findById(appointmentId);
        if (appointment.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(String.format("Appointment with ID %d not found", appointmentId));
        if (appointment.get().getPatientPhoneNumber() != null)
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("This Appointment Has Been Taken By a Patient");
        appointment.get().setPatientFirstName(firstName);
        appointment.get().setPatientLastName(lastName);
        appointment.get().setPatientPhoneNumber(phoneNumber);
        return ResponseEntity.status(HttpStatus.CREATED).body(AppointmentConvertor.appointmentToAppointmentDTO(appointmentService.save(appointment.get())));
    }

    @GetMapping("/get-taken-appointment-list")
    public ResponseEntity<?> getAppointmentList(@RequestParam("phoneNumber") @NotNull @Pattern(regexp = "^\\d{11}$") String phoneNumber) {

        List<Appointment> appointments = appointmentService.findTakenAppointmentsByPhoneNumber(phoneNumber);
        if (appointments.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ArrayList<>());
        return ResponseEntity.ok(appointmentService.findTakenAppointmentsByPhoneNumber(phoneNumber)
                .parallelStream()
                .map(AppointmentConvertor::appointmentToAppointmentDTO)
        );
    }
}

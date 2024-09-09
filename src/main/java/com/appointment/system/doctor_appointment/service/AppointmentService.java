package com.appointment.system.doctor_appointment.service;

import com.appointment.system.doctor_appointment.model.entity.Appointment;
import com.appointment.system.doctor_appointment.repository.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public Appointment save(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    public List<Appointment> findAppointmentsByDoctorId(long id) {
        return appointmentRepository.findAppointmentsByDoctorId(id);
    }

    public List<Appointment> findOpenAppointmentsByDoctorId(long id) {
        return appointmentRepository.findOpenAppointmentsByDoctorId(id);
    }

    public Optional<Appointment> findById(long id) {
        return appointmentRepository.findById(id);
    }

    public void delete(Appointment appointment) {
        appointmentRepository.delete(appointment);
    }

    public List<Appointment> findTakenAppointmentsByPhoneNumber(String PhoneNumber) {
        return appointmentRepository.findTakenAppointmentsByPhoneNumber(PhoneNumber);
    }
}

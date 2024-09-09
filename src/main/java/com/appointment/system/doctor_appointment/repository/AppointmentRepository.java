package com.appointment.system.doctor_appointment.repository;

import com.appointment.system.doctor_appointment.model.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    @Query("SELECT a FROM Appointment a WHERE a.doctor.id = :id")
        List<Appointment> findAppointmentsByDoctorId(long id);

    @Query("SELECT a FROM Appointment a WHERE a.doctor.id = :id and a.patientPhoneNumber is null ")
    List<Appointment> findOpenAppointmentsByDoctorId(long id);

    @Query("SELECT a FROM Appointment a WHERE a.patientPhoneNumber = :phoneNumber")
    List<Appointment> findTakenAppointmentsByPhoneNumber(String phoneNumber);

}

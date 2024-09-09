package com.appointment.system.doctor_appointment.repository;

import com.appointment.system.doctor_appointment.model.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}

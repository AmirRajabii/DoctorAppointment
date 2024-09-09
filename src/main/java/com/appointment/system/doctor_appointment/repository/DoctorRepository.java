package com.appointment.system.doctor_appointment.repository;

import com.appointment.system.doctor_appointment.model.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}

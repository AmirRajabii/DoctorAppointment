package com.appointment.system.doctor_appointment.repository;

import com.appointment.system.doctor_appointment.model.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}

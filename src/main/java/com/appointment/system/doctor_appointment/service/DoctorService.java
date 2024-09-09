package com.appointment.system.doctor_appointment.service;

import com.appointment.system.doctor_appointment.model.entity.Doctor;
import com.appointment.system.doctor_appointment.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public Optional<Doctor> findById(long id) {
        return doctorRepository.findById(id);
    }
}

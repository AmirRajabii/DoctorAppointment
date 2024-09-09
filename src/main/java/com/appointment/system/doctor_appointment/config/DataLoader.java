package com.appointment.system.doctor_appointment.config;

import com.appointment.system.doctor_appointment.model.entity.Doctor;
import com.appointment.system.doctor_appointment.model.enums.Gender;
import com.appointment.system.doctor_appointment.model.enums.UserRole;
import com.appointment.system.doctor_appointment.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public void run(String... args){
        if (doctorRepository.count() == 0) {
            Doctor doctor = new Doctor();
            doctor.setFirstName("Amir");
            doctor.setLastName("Rajabi");
            doctor.setEmail("amir@mail.com");
            doctor.setPhoneNumber("09212880961");
            doctor.setNationalCode("0011223344");
            doctor.setUserRole(UserRole.DOCTOR);
            doctor.setGender(Gender.MALE);
            doctor.setSpecialty("General");
            doctor.setMedicalLicenseNumber("123456");
            doctorRepository.save(doctor);

            System.out.println("Doctor created successfully.");
        }
    }
}
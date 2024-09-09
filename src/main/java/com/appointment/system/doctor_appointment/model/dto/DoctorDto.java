package com.appointment.system.doctor_appointment.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDto {

    private Long id;

    private String firstName;

    private String lastName;

    private String specialty;

    private String medicalLicenseNumber;
}

package com.appointment.system.doctor_appointment.model.dto;

import com.appointment.system.doctor_appointment.model.enums.Gender;
import com.appointment.system.doctor_appointment.model.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long id;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String email;

    private String nationalCode;

    private Gender gender;

    private UserRole userRole;
}

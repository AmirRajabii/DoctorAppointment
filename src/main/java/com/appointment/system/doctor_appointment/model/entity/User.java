package com.appointment.system.doctor_appointment.model.entity;

import com.appointment.system.doctor_appointment.model.enums.Gender;
import com.appointment.system.doctor_appointment.model.enums.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
public abstract class User extends BaseEntity {

    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;

    @Column(name = "PHONE_NUMBER", unique = true, nullable = false, length = 11)
    private String phoneNumber;

    @Column(name = "EMAIL", unique = true)
    private String email;

    @Column(name = "NATIONAL_CODE", unique = true, nullable = false, length = 10)
    private String nationalCode;

    @Column(name = "GENDER", nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "ROLE", nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRole userRole;
}

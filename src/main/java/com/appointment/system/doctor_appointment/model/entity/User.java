package com.appointment.system.doctor_appointment.model.entity;

import com.appointment.system.doctor_appointment.model.enums.Gender;
import com.appointment.system.doctor_appointment.model.enums.UserRole;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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

    @NotNull(message = "First name cannot be null")
    @Size(min = 3, max = 50, message = "First name must be between 3 and 50 characters")
    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    @NotNull(message = "Last name cannot be null")
    @Size(min = 3, max = 50, message = "Last name must be between 3 and 50 characters")
    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;

    @NotNull(message = "Phone number cannot be null")
    @Pattern(regexp = "\\d{11}", message = "Phone number must be 11 digits")
    @Column(name = "PHONE_NUMBER", unique = true, nullable = false, length = 11)
    private String phoneNumber;

    @Email(message = "Email should be valid")
    @Column(name = "EMAIL", unique = true)
    private String email;

    @NotNull(message = "National code cannot be null")
    @Pattern(regexp = "\\d{10}", message = "National code must be exactly 10 digits")
    @Column(name = "NATIONAL_CODE", unique = true, nullable = false, length = 10)
    private String nationalCode;

    @NotNull(message = "Gender cannot be null")
    @Column(name = "GENDER", nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @NotNull(message = "User role cannot be null")
    @Column(name = "ROLE", nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRole userRole;
}

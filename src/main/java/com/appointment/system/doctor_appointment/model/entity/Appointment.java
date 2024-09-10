package com.appointment.system.doctor_appointment.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "APPOINTMENT")
@Entity
public class Appointment extends BaseEntity {

    @NotNull(message = "Start time cannot be null")
    @Column(name = "START_TIME", nullable = false)
    private LocalDateTime startTime;

    @NotNull(message = "End time cannot be null")
    @Column(name = "END_TIME", nullable = false)
    private LocalDateTime endTime;

    @Size(min = 3, max = 50, message = "Patient first name must be between 3 and 50 characters")
    @Column(name = "PATIENT_FIRST_NAME")
    private String patientFirstName;

    @Size(min = 3, max = 50, message = "Patient last name must be between 3 and 50 characters")
    @Column(name = "PATIENT_LAST_NAME")
    private String patientLastName;

    @Pattern(regexp = "\\d{11}", message = "Patient phone number must be 11 digits")
    @Column(name = "PATIENT_PHONE_NUMBER", length = 11)
    private String patientPhoneNumber;

    @NotNull(message = "Doctor cannot be null")
    @ManyToOne
    private Doctor doctor;
}

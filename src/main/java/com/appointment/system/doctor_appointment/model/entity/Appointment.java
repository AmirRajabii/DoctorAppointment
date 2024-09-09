package com.appointment.system.doctor_appointment.model.entity;

import jakarta.persistence.*;
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

    @Column(name = "START_TIME" , nullable = false)
    private LocalDateTime startTime;

    @Column(name = "END_TIME" , nullable = false)
    private LocalDateTime endTime;

    @Column(name = "PATIENT_FIRST_NAME")
    private String patientFirstName;

    @Column(name = "PATIENT_LAST_NAME")
    private String patientLastName;

    @Column(name = "PATIENT_PHONE_NUMBER", length = 11)
    private String patientPhoneNumber;

    @ManyToOne
    private Doctor doctor;
}

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

    @Column(name = "IS_TAKEN" , nullable = false)
    private boolean isTaken;

    @ManyToOne
    private Doctor doctor;

    @ManyToOne
    private Patient patient;
}

package com.appointment.system.doctor_appointment.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "PATIENT")
@Entity
public class Patient extends BaseEntity{

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointments;

    @Column(name = "INSURANCE_NUMBER")
    private String insuranceNumber;
}

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
@Table(name = "DOCTOR")
@Entity
public class Doctor extends BaseEntity {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointments;

    // It could have been an enum, but it's not necessary in the test project right now
    @Column(name = "SPECIALTY", nullable = false)
    private String specialty;

    @Column(name = "MEDICAL_LICENSE_NUMBER", nullable = false, length = 6)
    private String medicalLicenseNumber;

}

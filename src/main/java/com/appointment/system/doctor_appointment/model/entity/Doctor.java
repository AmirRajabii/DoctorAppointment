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
public class Doctor extends User {

    @OneToMany(mappedBy = "doctor")
    private List<Appointment> appointments;

    // It could have been an enum or table, but it's not necessary in the test project right now
    @Column(name = "SPECIALTY", nullable = false)
    private String specialty;

    @Column(name = "MEDICAL_LICENSE_NUMBER", nullable = false, length = 6)
    private String medicalLicenseNumber;

}

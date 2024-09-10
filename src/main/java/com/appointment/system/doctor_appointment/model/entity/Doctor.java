package com.appointment.system.doctor_appointment.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
    @NotNull(message = "Specialty cannot be null")
    @Size(min = 1, max = 50, message = "Specialty must be between 1 and 50 characters")
    @Column(name = "SPECIALTY", nullable = false)
    private String specialty;

    @NotNull(message = "Medical license number cannot be null")
    @Size(min = 1, max = 6, message = "Medical license number must be between 1 and 6 characters")
    @Column(name = "MEDICAL_LICENSE_NUMBER", nullable = false, length = 6)
    private String medicalLicenseNumber;

}

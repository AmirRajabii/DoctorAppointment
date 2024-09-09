package com.appointment.system.doctor_appointment.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDto {

    private Long id;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private String patientFirstName;

    private String patientLastName;

    private String patientPhoneNumber;
}

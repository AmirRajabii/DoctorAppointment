package com.appointment.system.doctor_appointment.convertor;

import com.appointment.system.doctor_appointment.model.dto.AppointmentDto;
import com.appointment.system.doctor_appointment.model.entity.Appointment;

public class AppointmentConvertor {

    public static AppointmentDto appointmentToAppointmentDTO(Appointment appointment) {
        return new AppointmentDto(
                appointment.getId(),
                appointment.getStartTime(),
                appointment.getEndTime(),
                appointment.getPatientFirstName(),
                appointment.getPatientLastName(),
                appointment.getPatientPhoneNumber()
        );
    }

}

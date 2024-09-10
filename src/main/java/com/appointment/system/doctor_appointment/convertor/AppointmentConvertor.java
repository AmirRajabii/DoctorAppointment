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

    public static void setDataForUpdate(String phoneNumber, String firstName, String lastName, Appointment appointment) {
        appointment.setPatientFirstName(firstName);
        appointment.setPatientLastName(lastName);
        appointment.setPatientPhoneNumber(phoneNumber);
    }

}

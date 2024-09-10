package com.appointment.system.doctor_appointment.repository;

import com.appointment.system.doctor_appointment.model.entity.Appointment;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    //    @Query("SELECT a FROM Appointment a WHERE a.doctor.id = :id")
    List<Appointment> findByDoctorId(long id, Sort sort);

    //    @Query("SELECT a FROM Appointment a WHERE a.doctor.id = :id and a.patientPhoneNumber is null ")
    List<Appointment> findByDoctorIdAndPatientPhoneNumberIsNull(long id, Sort sort);

    //    @Query("SELECT a FROM Appointment a WHERE a.patientPhoneNumber = :phoneNumber")
    List<Appointment> findByPatientPhoneNumber(String phoneNumber, Sort sort);

}

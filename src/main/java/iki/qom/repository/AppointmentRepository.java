package iki.qom.repository;

import iki.qom.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.LocalTime;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    @Query("Select Count(a) > 0 from Appointment a " +
            "where a.appointmentDate=:aDate AND a.startTime<:eTime AND a.endTime>:sTime AND a.doctor.id=:dId")
    boolean existsByDateStartTimeEndTimeAndDoctorId(LocalDate aDate, LocalTime sTime, LocalTime eTime, Long dId);
}

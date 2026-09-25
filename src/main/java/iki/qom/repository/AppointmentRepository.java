package iki.qom.repository;

import iki.qom.dto.AppointmentProjectionDto;
import iki.qom.entity.Appointment;
import iki.qom.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    @Query("Select Count(a) > 0 from Appointment a " +
            "where a.appointmentDate=:aDate AND a.startTime<:eTime AND a.endTime>:sTime AND a.doctor.id=:dId")
    boolean existsByDateStartTimeEndTimeAndDoctorId(LocalDate aDate, LocalTime sTime, LocalTime eTime, Long dId);

    @Query("Select new iki.qom.dto.AppointmentProjectionDto(a.appointmentDate,a.startTime,a.endTime,a.status,d.username,p.username)" +
            " from Appointment a " +
            "join a.patient p " +
            "join a.doctor d " +
            "where p=:patient ")
    List<AppointmentProjectionDto> getAllPatientAppointments(User patient);

    @Query("Select new iki.qom.dto.AppointmentProjectionDto(a.appointmentDate,a.startTime,a.endTime,a.status,d.username,p.username)" +
            " from Appointment a " +
            "join a.patient p " +
            "join a.doctor d " +
            "where d=:doctor ")
    List<AppointmentProjectionDto> getAllDoctorAppointments(User doctor);

}

package iki.qom.service;

import iki.qom.dto.AppointmentDto;
import iki.qom.dto.AppointmentProjectionDto;

import java.util.List;

public interface AppointmentService {
    void createAppointment(AppointmentDto appointmentDto);

    List<AppointmentProjectionDto> getAllPatientAppointments();

    List<AppointmentProjectionDto> getAllDoctorAppointments();

}

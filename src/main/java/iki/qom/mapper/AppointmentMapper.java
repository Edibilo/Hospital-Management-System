package iki.qom.mapper;

import iki.qom.dto.AppointmentDto;
import iki.qom.entity.Appointment;

public class AppointmentMapper {

    public static Appointment mapToAppointment(AppointmentDto appointmentDto) {
        Appointment appointment = new Appointment();
        appointment.setAppointmentDate(appointmentDto.getAppointmentDate());
        appointment.setId(appointmentDto.getId());
        appointment.setStatus(appointmentDto.getStatus());
        appointment.setStartTime(appointmentDto.getStartTime());
        appointment.setEndTime(appointmentDto.getEndTime());
        return appointment;
    }

    public static AppointmentDto mapToAppointmentDto(Appointment appointment) {
        AppointmentDto appointmentDto = new AppointmentDto();
        appointmentDto.setAppointmentDate(appointment.getAppointmentDate());
        appointmentDto.setId(appointment.getId());
        appointmentDto.setStatus(appointment.getStatus());
        appointmentDto.setEndTime(appointment.getEndTime());
        appointmentDto.setStartTime(appointment.getStartTime());
        appointmentDto.setDoctorId(appointment.getDoctor().getId());
        appointmentDto.setPatientId(appointment.getPatient().getId());
        return appointmentDto;
    }
}

package iki.qom.service;

import iki.qom.dto.ConsultationDto;
import iki.qom.entity.Appointment;

import java.util.List;

public interface ConsultationService {
    ConsultationDto createConsultation(ConsultationDto consultationDto);
    List<ConsultationDto> getAllConsultationInAppointment(Long appointmentId);
    ConsultationDto getConsultationByAppointmentIdAndConsultationId(Long appointmentId,Long consultationId);
    void deleteConsultation(Long consultationId);
}

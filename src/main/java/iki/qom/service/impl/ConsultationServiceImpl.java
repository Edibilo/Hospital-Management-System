package iki.qom.service.impl;

import iki.qom.dto.ConsultationDto;
import iki.qom.entity.Appointment;
import iki.qom.entity.Consultation;
import iki.qom.mapper.ConsultationMapper;
import iki.qom.repository.AppointmentRepository;
import iki.qom.repository.ConsultationRepository;
import iki.qom.service.ConsultationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConsultationServiceImpl implements ConsultationService {

    private final ConsultationRepository consultationRepository;
    private final AppointmentRepository appointmentRepository;

    public ConsultationServiceImpl(ConsultationRepository consultationRepository,
                                   AppointmentRepository appointmentRepository) {
        this.consultationRepository = consultationRepository;
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public ConsultationDto createConsultation(ConsultationDto consultationDto) {
        Appointment appointment=appointmentRepository.findById(consultationDto.getAppointmentId()).orElseThrow(
                () -> new RuntimeException("Appointment Not Found !")
        );
        Consultation consultation=new Consultation();
        consultation.setTreatmentNotes(consultationDto.getTreatmentNotes());
        consultation.setSymptoms(consultationDto.getSymptoms());
        consultation.setWeight(consultationDto.getWeight());
        consultation.setTemperature(consultationDto.getTemperature());
        consultation.setBloodPressure(consultationDto.getBloodPressure());
        consultation.setDiagnosis(consultationDto.getDiagnosis());
        consultation.setAppointment(appointment);
        Consultation savedConsultation=consultationRepository.save(consultation);
        return ConsultationMapper.mapToConsultationDto(savedConsultation);
    }

    @Override
    public List<ConsultationDto> getAllConsultationInAppointment(Long appointmentId) {
        List<Consultation> consultations=consultationRepository.findConsultationByAppointmentId(appointmentId);
        return consultations.stream().map(ConsultationMapper::mapToConsultationDto).collect(Collectors.toList());
    }

    @Override
    public ConsultationDto getConsultationByAppointmentIdAndConsultationId(Long appointmentId, Long consultationId) {
        Consultation consultation=consultationRepository.findConsultationByAppointmentIdAndId(
                appointmentId,consultationId
        ).orElseThrow(() -> new RuntimeException("Consultation Not Found !"));
        return ConsultationMapper.mapToConsultationDto(consultation);
    }

    @Override
    public void deleteConsultation(Long consultationId) {
        Consultation consultation=consultationRepository.findById(consultationId).orElseThrow(
                () -> new RuntimeException("Consultation Not Found !")
        );
        consultationRepository.delete(consultation);
    }

}



















package iki.qom.mapper;

import iki.qom.dto.ConsultationDto;
import iki.qom.entity.Consultation;

public class ConsultationMapper {

    public static Consultation mapToConsultation(ConsultationDto consultationDto){
        Consultation consultation=new Consultation();
        consultation.setDiagnosis(consultationDto.getDiagnosis());
        consultation.setBloodPressure(consultationDto.getBloodPressure());
        consultation.setId(consultationDto.getId());
        consultation.setTemperature(consultationDto.getTemperature());
        consultation.setSymptoms(consultationDto.getSymptoms());
        consultation.setWeight(consultationDto.getWeight());
        consultation.setTreatmentNotes(consultationDto.getTreatmentNotes());
        return consultation;
    }

    public static ConsultationDto mapToConsultationDto(Consultation consultation){
        ConsultationDto consultationDto=new ConsultationDto();
        consultationDto.setAppointmentId(consultation.getAppointment().getId());
        consultationDto.setDiagnosis(consultation.getDiagnosis());
        consultationDto.setId(consultation.getId());
        consultationDto.setTemperature(consultation.getTemperature());
        consultationDto.setSymptoms(consultation.getSymptoms());
        consultationDto.setBloodPressure(consultation.getBloodPressure());
        consultationDto.setWeight(consultation.getWeight());
        consultationDto.setTreatmentNotes(consultation.getTreatmentNotes());
        consultationDto.setPatientName(consultation.getAppointment().getPatient().getUsername());
        return consultationDto;
    }
}

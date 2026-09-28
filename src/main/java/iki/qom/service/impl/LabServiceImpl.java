package iki.qom.service.impl;

import iki.qom.dto.LabDto;
import iki.qom.entity.Consultation;
import iki.qom.entity.Lab;
import iki.qom.mapper.LabMapper;
import iki.qom.repository.ConsultationRepository;
import iki.qom.repository.LabRepository;
import iki.qom.service.LabService;
import org.springframework.stereotype.Service;

@Service
public class LabServiceImpl implements LabService {

    private final LabRepository labRepository;
    private final ConsultationRepository consultationRepository;

    public LabServiceImpl(LabRepository labRepository, ConsultationRepository consultationRepository) {
        this.labRepository = labRepository;
        this.consultationRepository = consultationRepository;
    }

    @Override
    public LabDto createLab(LabDto labDto) {
        Consultation consultation=consultationRepository.findById(labDto.getConsultationId()).orElseThrow(
                () -> new RuntimeException("Consultation Not Found !")
        );
        Lab lab=new Lab();
        lab.setResult(labDto.getResult());
        lab.setLabTest(labDto.getLabTest());
        lab.setLabStatus(labDto.getLabStatus());
        lab.setConsultation(consultation);
        Lab savedLab=labRepository.save(lab);
        return LabMapper.mapToLabDto(savedLab);
    }
}

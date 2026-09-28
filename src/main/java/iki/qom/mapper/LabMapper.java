package iki.qom.mapper;

import iki.qom.dto.LabDto;
import iki.qom.entity.Lab;

public class LabMapper {

    public static Lab mapToLab(LabDto labDto){
        Lab lab=new Lab();
        lab.setLabStatus(labDto.getLabStatus());
        lab.setLabTest(labDto.getLabTest());
        lab.setId(labDto.getId());
        lab.setResult(labDto.getResult());
        return lab;
    }

    public static LabDto mapToLabDto(Lab lab){
        LabDto labDto=new LabDto();
        labDto.setConsultationId(lab.getConsultation().getId());
        labDto.setId(lab.getId());
        labDto.setLabStatus(lab.getLabStatus());
        labDto.setLabTest(lab.getLabTest());
        labDto.setResult(lab.getResult());
        return labDto;
    }
}

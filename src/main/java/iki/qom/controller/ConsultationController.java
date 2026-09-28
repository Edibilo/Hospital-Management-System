package iki.qom.controller;

import iki.qom.dto.LabDto;
import iki.qom.service.ConsultationService;
import iki.qom.service.LabService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/v1/consultations")
public class ConsultationController {

    private final ConsultationService consultationService;
    private final LabService labService;

    public ConsultationController(ConsultationService consultationService, LabService labService) {
        this.consultationService = consultationService;
        this.labService = labService;
    }

    @GetMapping("{consultationId}/lab")
    public String getLab(@PathVariable Long consultationId, Model model){
        model.addAttribute("lab",new LabDto());
        //model.addAttribute("consultation",consultationService.getConsultationByAppointmentId(consultationId));
        return "get-lab";
    }

    @PostMapping("{consultationId}/lab")
    public String saveLab(@PathVariable Long consultationId,LabDto labDto){
        labDto.setConsultationId(consultationId);
        labService.createLab(labDto);
        return "redirect:/api/v1/consultations";
    }



}

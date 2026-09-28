package iki.qom.controller;

import iki.qom.dto.AppointmentDto;
import iki.qom.dto.ConsultationDto;
import iki.qom.dto.FeedbackDto;
import iki.qom.enumerator.AppointmentStatus;
import iki.qom.service.AppointmentService;
import iki.qom.service.ConsultationService;
import iki.qom.service.FeedbackService;
import iki.qom.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequestMapping("api/v1/appointments")
@Controller
public class AppointmentController {

    private final AppointmentService appointmentService;
    private final UserService userService;
    private final FeedbackService feedbackService;
    private final ConsultationService consultationService;

    public AppointmentController(AppointmentService appointmentService, UserService userService,
                                 FeedbackService feedbackService, ConsultationService consultationService) {
        this.appointmentService = appointmentService;
        this.userService = userService;
        this.feedbackService = feedbackService;
        this.consultationService = consultationService;
    }

    @GetMapping
    public String getAppointment(Model model) {
        model.addAttribute("appointment", new AppointmentDto());
        model.addAttribute("appointmentStatus", AppointmentStatus.values());
        model.addAttribute("doctors", userService.getAllDoctors());
        model.addAttribute("patientAppointments",appointmentService.getAllPatientAppointments());
        model.addAttribute("doctorAppointments",appointmentService.getAllDoctorAppointments());
        return "get-appointment";
    }

    @PostMapping
    public String saveAppointment(@ModelAttribute AppointmentDto appointmentDto, RedirectAttributes redirectAttributes) {
        try{
            appointmentService.createAppointment(appointmentDto);
            redirectAttributes.addFlashAttribute("success","Saved !");
        }catch (Exception exception){
            redirectAttributes.addFlashAttribute("fail",exception.getMessage());
        }
        return "redirect:/api/v1/appointments";
    }

    @GetMapping("status/{appointmentId}/{status}")
    public String updateStatus(Model model,@PathVariable Long appointmentId, @PathVariable AppointmentStatus status){
        appointmentService.updateStatus(appointmentId,status);
        model.addAttribute("doctorAppointments",appointmentService.getAllDoctorAppointments());
        model.addAttribute("appointmentStatus", AppointmentStatus.values());
        return "get-appointment";
    }

    @GetMapping("{appointmentId}/feedback")
    public String getFeedback(@PathVariable Long appointmentId,Model model){
        model.addAttribute("feedback",new FeedbackDto());
        model.addAttribute("appointment",appointmentService.findAppointmentById(appointmentId));
        return "get-feedback";
    }

    @PostMapping("{appointmentId}/feedback")
    public String createFeedback(@PathVariable Long appointmentId,@ModelAttribute FeedbackDto feedbackDto){
        feedbackDto.setAppointmentId(appointmentId);
        feedbackService.createFeedback(feedbackDto);
        return "redirect:/api/v1/appointments";
    }

    @GetMapping("{appointmentId}/consultations")
    public String getConsultation(@PathVariable Long appointmentId,Model model){
        model.addAttribute("consultation",new ConsultationDto());
        model.addAttribute("appointment",appointmentService.findAppointmentById(appointmentId));
        model.addAttribute("consultations",consultationService.getAllConsultationInAppointment(appointmentId));
        return "get-consultation";
    }

    @PostMapping("{appointmentId}/consultations")
    public String createConsultation(@PathVariable Long appointmentId,@ModelAttribute ConsultationDto consultationDto){
        consultationDto.setAppointmentId(appointmentId);
        consultationService.createConsultation(consultationDto);
        return "redirect:/api/v1/appointments";
    }

    @GetMapping("{appointmentId}/consultations/{consultationId}/edit")
    public String editConsultation(@PathVariable Long appointmentId,@PathVariable Long consultationId,Model model){
        model.addAttribute("appointment",appointmentService.findAppointmentById(appointmentId));
        model.addAttribute("consultations",consultationService.getAllConsultationInAppointment(appointmentId));
        model.addAttribute("consultation",consultationService.getConsultationByAppointmentIdAndConsultationId(
                appointmentId,consultationId
        ));
        return "get-consultation";
    }

    @GetMapping("{consultationId}/delete")
    public String deleteConsultation(@PathVariable Long consultationId){
        consultationService.deleteConsultation(consultationId);
        return "redirect:/api/v1/appointments";
    }
}

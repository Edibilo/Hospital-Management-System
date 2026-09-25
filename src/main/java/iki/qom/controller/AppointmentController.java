package iki.qom.controller;

import iki.qom.dto.AppointmentDto;
import iki.qom.enumerator.AppointmentStatus;
import iki.qom.service.AppointmentService;
import iki.qom.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequestMapping("api/v1/appointments")
@Controller
public class AppointmentController {

    private final AppointmentService appointmentService;
    private final UserService userService;

    public AppointmentController(AppointmentService appointmentService, UserService userService) {
        this.appointmentService = appointmentService;
        this.userService = userService;
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
}

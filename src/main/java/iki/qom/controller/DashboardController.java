package iki.qom.controller;

import iki.qom.service.AdminDashboardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("api/v1/dashboards")
@Controller
public class DashboardController {

    private final AdminDashboardService adminDashboardService;


    public DashboardController(AdminDashboardService adminDashboardService) {
        this.adminDashboardService = adminDashboardService;
    }

    @GetMapping()
    public String getAdminDashboards(Model model){
        model.addAttribute("dashboard",adminDashboardService.getAdminDashboard());
        return "get-dashboard";
    }
}

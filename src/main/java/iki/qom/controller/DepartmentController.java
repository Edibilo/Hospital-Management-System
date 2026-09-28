package iki.qom.controller;

import iki.qom.dto.DepartmentDto;
import iki.qom.service.DepartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("api/v1/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public String getDepartment(Model model){
        model.addAttribute("department",new DepartmentDto());
        model.addAttribute("departments",departmentService.getAllDepartments());
        return "get-department";
    }

    @PostMapping
    public String createDepartment(Model model,@ModelAttribute DepartmentDto departmentDto){
        departmentService.createDepartment(departmentDto);
        return "redirect:/api/v1/departments";
    }

    @GetMapping("{departmentId}/edit")
    public String getDepartmentById(@PathVariable Long departmentId, Model model){
        model.addAttribute("department",departmentService.findDepartmentById(departmentId));
        model.addAttribute("departments",departmentService.getAllDepartments());
        return "get-department";
    }

    @GetMapping("{departmentId}/delete")
    public String deleteDepartment(@PathVariable Long departmentId,Model model){
        departmentService.deleteDepartment(departmentId);
        model.addAttribute("departments",departmentService.getAllDepartments());
        return "redirect:/api/v1/departments";
    }
}

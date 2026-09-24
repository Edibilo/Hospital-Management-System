package iki.qom.controller;

import iki.qom.dto.RoleDto;
import iki.qom.service.RoleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequestMapping("api/v1/roles")
@Controller
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    public String getRole(Model model){
        model.addAttribute("role",new RoleDto());
        model.addAttribute("roles",roleService.getAllRoles());
        return "get-role";
    }

    @PostMapping
    public String saveRole(Model model, @ModelAttribute RoleDto roleDto, RedirectAttributes redirectAttributes){
        try{
            model.addAttribute("role",roleService.createRole(roleDto));
            redirectAttributes.addFlashAttribute("success","saved !");
        }catch(Exception exception){
            redirectAttributes.addFlashAttribute("fail", exception.getMessage());
        }
        return "redirect:/api/v1/roles";
    }

    @GetMapping("{roleId}/edit")
    public String editRole(@PathVariable Long roleId, Model model){
        model.addAttribute("role",roleService.findRoleById(roleId));
        model.addAttribute("roles",roleService.getAllRoles());
        return "get-role";
    }

    @GetMapping("{roleId}/delete")
    public String deleteRole(@PathVariable Long roleId,RedirectAttributes redirectAttributes){
        try {
            roleService.deleteRole(roleId);
            redirectAttributes.addFlashAttribute("success","Role Deleted !");
        }catch (Exception exception){
            redirectAttributes.addFlashAttribute("fail","fail");
        }
        return "redirect:/api/v1/roles";
    }

}

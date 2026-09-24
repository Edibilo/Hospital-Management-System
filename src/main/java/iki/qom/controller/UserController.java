package iki.qom.controller;

import iki.qom.enumerator.AccountStatus;
import iki.qom.enumerator.GenderStatus;
import iki.qom.service.RoleService;
import iki.qom.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/v1/users")
public class UserController {

    private final UserService userService;
    private final RoleService roleService;

    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("profile")
    public String myProfile(Model model){
        model.addAttribute("profile",userService.profile());
        return "profile";
    }

    @GetMapping("edit/profile")
    public String editProfile(Model model){
        model.addAttribute("user",userService.findUserById());
        model.addAttribute("gender", GenderStatus.values());
        model.addAttribute("account", AccountStatus.values());
        model.addAttribute("roles",roleService.getAllRoles());
        return "get-register";
    }

    @GetMapping
    public String getAllUsers(Model model){
        model.addAttribute("users",userService.getAllUsers());
        return "get-user";
    }

    @GetMapping("{userId}/edit")
    public String editUser(Model model,@PathVariable Long userId){
        model.addAttribute("user",userService.getByUserId(userId));
        model.addAttribute("gender", GenderStatus.values());
        model.addAttribute("account", AccountStatus.values());
        model.addAttribute("roles",roleService.getAllRoles());
        return "get-register";
    }

}

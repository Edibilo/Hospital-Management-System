package iki.qom.controller;

import iki.qom.dto.UserDto;
import iki.qom.enumerator.AccountStatus;
import iki.qom.enumerator.GenderStatus;
import iki.qom.service.AuthService;
import iki.qom.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Objects;

@Controller
@RequestMapping("api/v1/auth")
public class AuthController {

    private final AuthService authService;
    private final UserService userService;

    public AuthController(AuthService authService, UserService userService) {
        this.authService = authService;
        this.userService = userService;
    }

    @GetMapping("register")
    public String getRegister(Model model){
        model.addAttribute("user",new UserDto());
        model.addAttribute("gender", GenderStatus.values());
        model.addAttribute("account", AccountStatus.values());
        return "get-register";
    }

    @PostMapping("register")
    public String createUser(@ModelAttribute UserDto userDto, RedirectAttributes redirectAttributes,Model model){
        String path;
        try{
            model.addAttribute("user",authService.register(userDto));
            redirectAttributes.addFlashAttribute("success","Saved !");
        }catch (Exception exception){
            redirectAttributes.addFlashAttribute("fail",exception.getMessage());
        }
        if(userDto.getId()==null){
            path="redirect:/api/v1/auth/login";
        }else {
            if(!userService.loggedInUser().getRole().getName().equals("ROLE_ADMIN")){
                path="redirect:/api/v1/users/profile";
            }else {
                path="redirect:/api/v1/users";
            }
        }

        return path;
    }

    @GetMapping("login")
    public String login(){
        return "login";
    }


}

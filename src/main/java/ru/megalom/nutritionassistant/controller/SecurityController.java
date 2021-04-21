package ru.megalom.nutritionassistant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityController {
    //Login form
    @GetMapping("/login")
    public String loginPage(){
        return "security/login";
    }

    //Login form with error
    @GetMapping("/login-error")
    public String loginError(Model model){
        model.addAttribute("loginError",true);
        return "security/login";
    }

    @GetMapping("/access-denied")
    public String accessDenied(){
        return "security/access-denied";
    }
}

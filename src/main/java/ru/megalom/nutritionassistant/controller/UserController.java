package ru.megalom.nutritionassistant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.megalom.nutritionassistant.model.User;
import ru.megalom.nutritionassistant.service.SecurityService;
import ru.megalom.nutritionassistant.service.UserService;
import ru.megalom.nutritionassistant.validator.UserValidator;

@Controller
@RequestMapping("/")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @GetMapping("/registration")
    public String registration(Model model){
        model.addAttribute("userForm",new User());
        return "/security/registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult){
        userValidator.validate(userForm,bindingResult);
        if(bindingResult.hasErrors()){
            return "/security/registration";
        }

        userService.save(userForm);
        securityService.autoLogin(userForm.getUsername(),userForm.getPasswordConfirm());
        return "redirect:/home";
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout){

        if(error!=null)
            model.addAttribute("error","Your username and password is invalid.");
        if(logout!=null){
            model.addAttribute("message","You have been logged out successfully.");
        }
        return "/security/login";
    }



    @GetMapping("/profile")
    public String getUserProfile(){
        return "/user/profile";
    }
}

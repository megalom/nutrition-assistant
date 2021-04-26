package ru.megalom.nutritionassistant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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

import javax.validation.Valid;
import java.util.HashSet;

@Controller
@RequestMapping("/")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    //Registration
    @GetMapping("/registration")
    public String registration(Model model){
        model.addAttribute("userForm",new User());
        return "/security/registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") @Valid User userForm, BindingResult bindingResult, Model model){
        //userValidator.validate(userForm,bindingResult);
        if(bindingResult.hasErrors()){
            return "/security/registration";
        }

//        System.out.println("user registration complete\n"+userForm);
        userService.save(userForm);
        securityService.autoLogin(userForm.getUsername(),userForm.getPasswordConfirm());
        return "redirect:/nutrition";
    }

    //Login
    @GetMapping("/login")
    public String login(Model model, String error, String logout){

        if(error!=null)
            model.addAttribute("error","Your username and password is invalid.");
        if(logout!=null){
            model.addAttribute("message","You have been logged out successfully.");
        }
        return "/security/login";
    }

    //Access Denied
    @GetMapping("/access-denied")
    public String login(Model model){
        Object ud=SecurityContextHolder.getContext().getAuthentication().getDetails();
        System.out.println("access denied");
        if(ud instanceof UserDetails){
            UserDetails userDetails=(UserDetails)ud;
            System.out.println(userDetails.toString());
            System.out.println(userDetails.getAuthorities().toString());
        }
        return "/security/access-denied";
    }

    //View User Profile
    @GetMapping("/profile")
    public String getUserProfile(){
        return "/user/profile";
    }

    @GetMapping("/admin")
    public String getAdminProfile(){
        return "/user/profile";
    }
}

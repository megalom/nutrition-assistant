package ru.megalom.nutritionassistant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/nutrition")
public class NutritionController {
    @GetMapping()
    String nutritionView(){
        return "/nutrition/view";
    }

}

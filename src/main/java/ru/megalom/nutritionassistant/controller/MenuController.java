package ru.megalom.nutritionassistant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.megalom.nutritionassistant.model.*;
import ru.megalom.nutritionassistant.repository.DishRepository;
import ru.megalom.nutritionassistant.repository.UserRepository;
import ru.megalom.nutritionassistant.service.DishService;
import ru.megalom.nutritionassistant.service.EatTypeService;
import ru.megalom.nutritionassistant.service.UserService;
import ru.megalom.nutritionassistant.service.UsersDishesService;

import java.sql.Date;
import java.util.List;

@Controller
@RequestMapping("/nutrition/menus")
public class MenuController {
    @Autowired
    UsersDishesService usersDishesService;

    @Autowired
    DishService dishService;

    @Autowired
    EatTypeService eatTypeService;

    @Autowired
    UserService userService;

    @GetMapping()
    public String index(Model model){
        List<UsersDishes> usersDishes=usersDishesService.findAll();
        model.addAttribute("users_dishes", usersDishes);
        return "/nutrition/menus/index";
    }

    @GetMapping("/addDish")
    public String addDish(Model model){
        List<Dish> dishes = dishService.findAll();
        model.addAttribute("dishes", dishes);
        UsersDishesForm usersDishesForm = new UsersDishesForm();
        usersDishesForm.setEatDate(Date.valueOf("2021-05-19"));
        model.addAttribute("usersDishesForm", usersDishesForm);
        return "/nutrition/menus/add_dish";
    }

    // Добавление блюда в меню
    // Создание новой связи в таблице users_dishes
    @PostMapping("/addDish")
    public String addDish(@ModelAttribute("usersDishesForm") UsersDishesForm usersDishesForm){
        UsersDishes usersDishes = new UsersDishes();
        usersDishes.setId(0);
        usersDishes.setUser(userService.findByUsername("user"));
        usersDishes.setDish(dishService.findById(usersDishesForm.getDishId()));
        usersDishes.setEatType( eatTypeService.findById(usersDishesForm.getEatTypeId()));
        usersDishes.setEatDate (usersDishesForm.getEatDate());
        usersDishes.setWeight(usersDishesForm.getWeight());
        usersDishesService.save(usersDishes);
        return "redirect:/nutrition/menus";
    }

    @GetMapping("/deleteDish")
    public String deleteDishFromMenu(@RequestParam int udId){
        usersDishesService.delete(udId);
        return "redirect:/nutrition/menus";
    }
}

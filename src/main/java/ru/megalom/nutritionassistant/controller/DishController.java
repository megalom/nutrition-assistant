package ru.megalom.nutritionassistant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.megalom.nutritionassistant.model.Dish;
import ru.megalom.nutritionassistant.model.Product;
import ru.megalom.nutritionassistant.service.DishService;

import javax.validation.Valid;

@Controller
@RequestMapping("/nutrition/dishes")
public class DishController {
    @Autowired
    DishService dishService;

    @GetMapping()
    public String getDishes(Model model)
    {
        model.addAttribute("dishes", dishService.findAll());
        return "/nutrition/dishes/index";
    }

    @GetMapping("/new")
    public String newProductForm(Model model){
        Dish dish= new Dish();
        model.addAttribute("dishForm",dish);
        return "/nutrition/dishes/new";
    }

    @GetMapping("/{id}/edit")
    public String updateDishForm(@PathVariable("id") int id, Model model){
        Dish editDish = dishService.findById(id);
        model.addAttribute("editDishForm", editDish);
        return "/nutrition/dishes/edit";
    }

    @PostMapping()
    public String addDish(@ModelAttribute("dishForm") @Valid Dish dish,
                             BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return "/nutrition/dishes/new";

        dishService.save(dish);

        return "redirect:/nutrition/dishes";
    }

    @PostMapping("/{id}/update")
    public String updateDish(@PathVariable("id") int id,
                                @ModelAttribute("editDishForm") @Valid Dish dish,
                                BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return "/nutrition/dishes/edit";
        dishService.save(dish);
        return "redirect:/nutrition/dishes";
    }

    @GetMapping("/{id}/delete")
    public String deleteDish(@PathVariable("id") int id){
        dishService.delete(id);
        return "redirect:/nutrition/dishes";
    }

}

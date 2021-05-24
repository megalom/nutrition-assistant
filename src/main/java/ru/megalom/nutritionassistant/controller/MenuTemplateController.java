package ru.megalom.nutritionassistant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.megalom.nutritionassistant.model.*;
import ru.megalom.nutritionassistant.repository.MenuTemplateRepository;
import ru.megalom.nutritionassistant.service.DishService;
import ru.megalom.nutritionassistant.service.EatTypeService;
import ru.megalom.nutritionassistant.service.MenuTemplateService;
import ru.megalom.nutritionassistant.service.TemplatesDishesService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/nutrition/templates")
public class MenuTemplateController {
    @Autowired
    MenuTemplateService menuTemplateService;

    @Autowired
    TemplatesDishesService templatesDishesService;

    @Autowired
    EatTypeService eatTypeService;

    @Autowired
    DishService dishService;

    // Отображение списка шаблонов меню
    @GetMapping()
    public String getMenuTemplates(Model model)
    {
        model.addAttribute("menus", menuTemplateService.findAll());
        return "/nutrition/templates/index";
    }

    // Отображение формы создания нового шаблона меню
    @GetMapping("/new")
    public String newMenuTemplateForm(Model model){
        MenuTemplate menuTemplate= new MenuTemplate();
        model.addAttribute("menuTemplateForm",menuTemplate);
        return "/nutrition/templates/new";
    }

    // Добавление нового шаблона меню
    @PostMapping()
    public String addDish(@ModelAttribute("menuTemplateForm") @Valid MenuTemplate menuTemplate,
                          BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return "/nutrition/templates/new";

        menuTemplateService.save(menuTemplate);

        return "redirect:/nutrition/templates";
    }

    // Отображение формы редакрирования данных о шаблоне меню
    @GetMapping("/{id}/edit")
    public String updateMenuTemplateForm(@PathVariable("id") int id, Model model){
        MenuTemplate editMenuTemplate = menuTemplateService.findById(id);
        model.addAttribute("editMenuTemplateForm", editMenuTemplate);
        return "/nutrition/templates/edit";
    }

    // Обновление информации о шаблоне меню
    @PostMapping("/{id}/update")
    public String updateMenuTemplate(@PathVariable("id") int id,
                             @ModelAttribute("editMenuTemplateForm") @Valid MenuTemplate menuTemplate,
                             BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return "/nutrition/templates/edit";
        menuTemplateService.save(menuTemplate);
        return "redirect:/nutrition/templates";
    }

    // Удаление шаблона меню
    @GetMapping("/{id}/delete")
    public String deleteMenuTemplate(@PathVariable("id") int id){
        menuTemplateService.delete(id);
        return "redirect:/nutrition/templates";
    }

    // Отображение состава шаблона меню
    @GetMapping("/{id}/composition")
    public String showComposition(@PathVariable("id") int id, Model model){

        MenuTemplate menuTemplate = menuTemplateService.findById(id);
        model.addAttribute("menuTemplate", menuTemplate);
        return "/nutrition/templates/composition";
    }

    // Отображение формы добавления блюда в шаблон меню
    @GetMapping("/{id}/addDish")
    public String showAddDishForm(@PathVariable("id") int id, Model model){

        TemplatesDishesFrom templatesDishesFrom = new TemplatesDishesFrom();
        templatesDishesFrom.setId(0);
        templatesDishesFrom.setTemplateId(id);
        model.addAttribute("dishes",dishService.findAll());
        model.addAttribute("eat_types",eatTypeService.findAll());
        model.addAttribute("templatesDishesFrom", templatesDishesFrom);
        return "/nutrition/templates/add_dish";
    }


    // Добавление нового блюда в шаблон меню
    // Создание новой связи в таблице templates_dishes
    @PostMapping("/addDish")
    public String addDish(@ModelAttribute("templatesDishesFrom") TemplatesDishesFrom templatesDishesFrom){
        TemplatesDishes templatesDishes = new TemplatesDishes();
        templatesDishes.setId(0);
        System.out.println(templatesDishesFrom.getEatTypeId());
        templatesDishes.setEatType(eatTypeService.findById(templatesDishesFrom.getEatTypeId()));
        templatesDishes.setDish(dishService.findById(templatesDishesFrom.getDishId()));
        templatesDishes.setMenuTemplate(menuTemplateService.findById(templatesDishesFrom.getTemplateId()));
        templatesDishes.setWeight(templatesDishesFrom.getWeight());
        templatesDishesService.save(templatesDishes);
        return "redirect:/nutrition/templates/"+templatesDishesFrom.getTemplateId()+"/composition";
    }

    @GetMapping("/{id}/deleteDish")
    public String deleteDishFromTemplate(@RequestParam int tdId, @PathVariable("id") int menuTemplateId){
        templatesDishesService.delete(tdId);
        return "redirect:/nutrition/templates/"+menuTemplateId+"/composition";
    }

}

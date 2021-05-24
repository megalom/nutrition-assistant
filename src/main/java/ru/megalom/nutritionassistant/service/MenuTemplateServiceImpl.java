package ru.megalom.nutritionassistant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.megalom.nutritionassistant.model.Dish;
import ru.megalom.nutritionassistant.model.MenuTemplate;
import ru.megalom.nutritionassistant.model.TemplatesDishes;
import ru.megalom.nutritionassistant.repository.DishRepository;
import ru.megalom.nutritionassistant.repository.MenuTemplateRepository;
import ru.megalom.nutritionassistant.repository.TemplatesDishesRepository;

import java.awt.*;
import java.util.List;
import java.util.Optional;

@Service
public class MenuTemplateServiceImpl implements MenuTemplateService {

    @Autowired
    MenuTemplateRepository menuTemplateRepository;

    @Override
    public List<MenuTemplate> findAll() {
        return menuTemplateRepository.findAll();
    };

    @Override
    public MenuTemplate findById(int id) {
        Optional<MenuTemplate> result=menuTemplateRepository.findById(id);
        MenuTemplate menuTemplate=null;
        if(result.isPresent())
        {
            menuTemplate=result.get();
        }
        else {
            throw new RuntimeException("menu template id not found");
        }
        return menuTemplate;
    }

    @Override
    public void delete(int id) {
        MenuTemplate menuTemplate=menuTemplateRepository.findById(id).
                orElseThrow(()->new IllegalArgumentException("Invalid menu template id:"+id));
        menuTemplateRepository.delete(menuTemplate);
    }

    @Override
    public void save(MenuTemplate menuTemplate) {
        menuTemplateRepository.save(menuTemplate);
    }

    @Override
    public MenuTemplate findByName(String name) {
        return menuTemplateRepository.findByNameIgnoreCase(name);
    }
}

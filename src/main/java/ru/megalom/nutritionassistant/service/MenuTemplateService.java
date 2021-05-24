package ru.megalom.nutritionassistant.service;

import ru.megalom.nutritionassistant.model.Dish;
import ru.megalom.nutritionassistant.model.MenuTemplate;

import java.util.List;

public interface MenuTemplateService {
    List<MenuTemplate> findAll();
    MenuTemplate findById(int id);
    void delete(int id);
    void save(MenuTemplate dish);
    MenuTemplate findByName(String name);
}

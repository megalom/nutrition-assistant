package ru.megalom.nutritionassistant.service;

import ru.megalom.nutritionassistant.model.Dish;
import ru.megalom.nutritionassistant.model.Product;

import java.util.List;

public interface DishService {
    List<Dish> findAll();
    Dish findById(int id);
    void delete(int id);
    void save(Dish dish);
    Dish findByName(String name);
}

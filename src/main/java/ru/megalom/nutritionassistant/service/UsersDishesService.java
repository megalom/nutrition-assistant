package ru.megalom.nutritionassistant.service;

import ru.megalom.nutritionassistant.model.DishesProducts;
import ru.megalom.nutritionassistant.model.UsersDishes;

import java.util.List;

public interface UsersDishesService {
    UsersDishes findById(int id);
    List<UsersDishes> findByUser_Id(int userId);
    List<UsersDishes> findAll();
    void save(UsersDishes usersDishes);
    void delete(int id);
}

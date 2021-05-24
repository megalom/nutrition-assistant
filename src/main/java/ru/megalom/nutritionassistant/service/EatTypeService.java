package ru.megalom.nutritionassistant.service;

import ru.megalom.nutritionassistant.model.Dish;
import ru.megalom.nutritionassistant.model.EatType;

import java.util.List;

public interface EatTypeService {
    List<EatType> findAll();
    EatType findById(int id);
    void delete(int id);
    void save(EatType eatType);
}

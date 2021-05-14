package ru.megalom.nutritionassistant.service;

import ru.megalom.nutritionassistant.model.Dish;
import ru.megalom.nutritionassistant.model.DishesProducts;

import java.util.List;

public interface DishesProductsService {
    DishesProducts findByDishAndProduct(int dishId,int productId);
    DishesProducts findById(int id);
    List<DishesProducts> findByDish_Id(int dishId);
    void save(DishesProducts dishesProducts);
    void delete(DishesProducts dishesProducts);
}

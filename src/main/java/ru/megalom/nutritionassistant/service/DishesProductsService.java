package ru.megalom.nutritionassistant.service;

import ru.megalom.nutritionassistant.model.Dish;
import ru.megalom.nutritionassistant.model.DishesProducts;

import java.util.List;

public interface DishesProductsService {
    DishesProducts findByDishesIdAndProductsId(int dishesId,int productsId);
}

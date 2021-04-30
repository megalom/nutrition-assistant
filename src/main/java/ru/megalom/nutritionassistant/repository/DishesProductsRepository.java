package ru.megalom.nutritionassistant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.megalom.nutritionassistant.model.Dish;
import ru.megalom.nutritionassistant.model.DishesProducts;

public interface DishesProductsRepository extends JpaRepository<DishesProducts,Integer> {
    //DishesProducts findByNameIgnoreCase(String dishName);
    DishesProducts findByDishesIdAndProductsId(int dishesId,int productsId);
}

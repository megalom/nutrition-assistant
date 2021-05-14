package ru.megalom.nutritionassistant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.megalom.nutritionassistant.model.Dish;
import ru.megalom.nutritionassistant.model.DishesProducts;

import java.util.List;

public interface DishesProductsRepository extends JpaRepository<DishesProducts,Integer> {
    //DishesProducts findByNameIgnoreCase(String dishName);
    DishesProducts findByDish_IdAndProduct_Id(int dishId,int productId);
    List<DishesProducts> findByDish_Id(int dishId);

}

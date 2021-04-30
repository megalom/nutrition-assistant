package ru.megalom.nutritionassistant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.megalom.nutritionassistant.model.Dish;
import ru.megalom.nutritionassistant.model.DishesProducts;
import ru.megalom.nutritionassistant.model.Product;

public interface DishRepository extends JpaRepository<Dish,Integer> {
    Dish findByNameIgnoreCase(String dishName);
}

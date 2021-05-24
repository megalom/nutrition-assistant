package ru.megalom.nutritionassistant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.megalom.nutritionassistant.model.DishesProducts;
import ru.megalom.nutritionassistant.model.UsersDishes;

import java.util.List;

public interface UsersDishesRepository extends JpaRepository<UsersDishes,Integer> {
    List<UsersDishes> findByUser_Id(int userId);
}

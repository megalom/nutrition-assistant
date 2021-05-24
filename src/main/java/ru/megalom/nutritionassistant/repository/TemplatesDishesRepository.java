package ru.megalom.nutritionassistant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.megalom.nutritionassistant.model.DishesProducts;
import ru.megalom.nutritionassistant.model.TemplatesDishes;

import java.util.List;

public interface TemplatesDishesRepository extends JpaRepository<TemplatesDishes,Integer> {
    List<TemplatesDishes> findByMenuTemplate_Id(int menuTemplateId);

}

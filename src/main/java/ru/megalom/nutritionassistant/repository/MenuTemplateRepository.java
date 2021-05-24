package ru.megalom.nutritionassistant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.megalom.nutritionassistant.model.Dish;
import ru.megalom.nutritionassistant.model.MenuTemplate;

public interface MenuTemplateRepository extends JpaRepository<MenuTemplate,Integer> {
    MenuTemplate findByNameIgnoreCase(String menuTemplateName);
}

package ru.megalom.nutritionassistant.service;

import ru.megalom.nutritionassistant.model.DishesProducts;
import ru.megalom.nutritionassistant.model.TemplatesDishes;

import java.util.List;

public interface TemplatesDishesService {
    TemplatesDishes findById(int id);
    List<TemplatesDishes> findByMenuTemplate_Id(int templateId);
    void save(TemplatesDishes templatesDishes);
    void delete(int id);
}

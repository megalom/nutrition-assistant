package ru.megalom.nutritionassistant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.megalom.nutritionassistant.model.DishesProducts;
import ru.megalom.nutritionassistant.model.TemplatesDishes;
import ru.megalom.nutritionassistant.repository.DishesProductsRepository;
import ru.megalom.nutritionassistant.repository.TemplatesDishesRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TemplatesDishesServiceImpl implements TemplatesDishesService{

    @Autowired
    TemplatesDishesRepository templatesDishesRepository;

    @Override
    public List<TemplatesDishes> findByMenuTemplate_Id(int menuTemplateId){
        return templatesDishesRepository.findByMenuTemplate_Id(menuTemplateId);
    }

    @Override
    public void save(TemplatesDishes templatesDishes) {
        templatesDishesRepository.save(templatesDishes);
    }

    @Override
    public void delete(int id) {
        templatesDishesRepository.deleteById(id);
    }

    @Override
    public TemplatesDishes findById(int id) {
        Optional<TemplatesDishes> result=templatesDishesRepository.findById(id);
        TemplatesDishes templatesDishes=null;
        if(result.isPresent())
        {
            templatesDishes=result.get();
        }
        else {
            throw new RuntimeException("TemplatesDishes not found by id "+id);
        }
        return templatesDishes;
    }
}

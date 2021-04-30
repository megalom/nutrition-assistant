package ru.megalom.nutritionassistant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.megalom.nutritionassistant.model.Dish;
import ru.megalom.nutritionassistant.model.DishesProducts;
import ru.megalom.nutritionassistant.repository.DishRepository;
import ru.megalom.nutritionassistant.repository.DishesProductsRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DishesProductsServiceImpl implements DishesProductsService{

    @Autowired
    DishesProductsRepository dishRepository;

    @Override
    public DishesProducts findByDishesIdAndProductsId(int dishesId,int productsId){
        return dishRepository.findByDishesIdAndProductsId(dishesId,productsId);
    }
}

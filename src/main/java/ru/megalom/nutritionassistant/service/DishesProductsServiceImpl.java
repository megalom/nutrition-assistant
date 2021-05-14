package ru.megalom.nutritionassistant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.megalom.nutritionassistant.model.Dish;
import ru.megalom.nutritionassistant.model.DishesProducts;
import ru.megalom.nutritionassistant.repository.DishesProductsRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DishesProductsServiceImpl implements DishesProductsService{

    @Autowired
    DishesProductsRepository dishesProductsRepository;

    @Override
    public DishesProducts findByDishAndProduct(int dishId,int productId){
        return dishesProductsRepository.findByDish_IdAndProduct_Id(dishId,productId);
    }

    @Override
    public List<DishesProducts> findByDish_Id(int dishId){
        return dishesProductsRepository.findByDish_Id(dishId);
    }

    @Override
    public void save(DishesProducts dishesProducts) {
        dishesProductsRepository.save(dishesProducts);
    }

    @Override
    public void delete(DishesProducts dishesProducts) {
        dishesProductsRepository.delete(dishesProducts);
    }

    @Override
    public DishesProducts findById(int id) {
        Optional<DishesProducts> result=dishesProductsRepository.findById(id);
        DishesProducts dishesProducts=null;
        if(result.isPresent())
        {
            dishesProducts=result.get();
        }
        else {
            throw new RuntimeException("DishesProducts not found by id "+id);
        }
        return dishesProducts;
    }
}

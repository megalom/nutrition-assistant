package ru.megalom.nutritionassistant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.megalom.nutritionassistant.model.Dish;
import ru.megalom.nutritionassistant.model.Product;
import ru.megalom.nutritionassistant.repository.DishRepository;
import ru.megalom.nutritionassistant.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DishServiceImpl implements DishService{

    @Autowired
    DishRepository dishRepository;

    @Override
    public List<Dish> findAll() {
        return dishRepository.findAll();
    };

    @Override
    public Dish findById(int id) {
        Optional<Dish> result=dishRepository.findById(id);
        Dish dish=null;
        if(result.isPresent())
        {
            dish=result.get();
        }
        else {
            throw new RuntimeException("id not found");
        }
        return dish;
    }

    @Override
    public void delete(int id) {
        Dish dish=dishRepository.findById(id).
                orElseThrow(()->new IllegalArgumentException("Invalid user id:"+id));
        dishRepository.delete(dish);
    }

    @Override
    public void save(Dish dish) {
        dishRepository.save(dish);
    }

    @Override
    public Dish findByName(String name) {
        return dishRepository.findByNameIgnoreCase(name);
    }
}

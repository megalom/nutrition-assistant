package ru.megalom.nutritionassistant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.megalom.nutritionassistant.model.DishesProducts;
import ru.megalom.nutritionassistant.model.UsersDishes;
import ru.megalom.nutritionassistant.repository.UsersDishesRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UsersDishesServiceImpl implements UsersDishesService{
    @Autowired
    UsersDishesRepository usersDishesRepository;

    @Override
    public UsersDishes findById(int id) {
        Optional<UsersDishes> result=usersDishesRepository.findById(id);
        UsersDishes usersDishes=null;
        if(result.isPresent())
        {
            usersDishes=result.get();
        }
        else {
            throw new RuntimeException("UsersDishes not found by id "+id);
        }
        return usersDishes;
    }

    @Override
    public List<UsersDishes> findByUser_Id(int userId) {
        return usersDishesRepository.findByUser_Id(userId);
    }

    @Override
    public List<UsersDishes> findAll() {
        return usersDishesRepository.findAll();
    }

    @Override
    public void save(UsersDishes usersDishes) {
        usersDishesRepository.save(usersDishes);
    }

    @Override
    public void delete(int id) {
        usersDishesRepository.deleteById(id);
    }
}

package ru.megalom.nutritionassistant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.megalom.nutritionassistant.model.Dish;
import ru.megalom.nutritionassistant.model.EatType;
import ru.megalom.nutritionassistant.repository.EatTypeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EatTypeServiceImpl implements EatTypeService{
    @Autowired
    EatTypeRepository eatTypeRepository;

    @Override
    public List<EatType> findAll() {
        return eatTypeRepository.findAll();
    }

    @Override
    public EatType findById(int id) {
        Optional<EatType> result = eatTypeRepository.findById(id);
        EatType eatType = null;
        if(result.isPresent()){
            eatType = result.get();
        }
        else
            throw new RuntimeException("id not found");
        return eatType;
    }

    @Override
    public void delete(int id) {
        eatTypeRepository.deleteById(id);
    }

    @Override
    public void save(EatType eatType) {
        eatTypeRepository.save(eatType);
    }
}

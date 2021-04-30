package ru.megalom.nutritionassistant.validator;

import org.springframework.beans.factory.annotation.Autowired;
import ru.megalom.nutritionassistant.model.Dish;
import ru.megalom.nutritionassistant.model.Product;
import ru.megalom.nutritionassistant.repository.DishRepository;
import ru.megalom.nutritionassistant.repository.ProductRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueDishNameConstraintValidator implements ConstraintValidator<UniqueDishNameConstraint,Object> {

    @Autowired
    DishRepository dishRepository;

    @Override
    public void initialize(UniqueDishNameConstraint constraintAnnotation) {

    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        if(dishRepository==null)
            return true;

        if (o == null) {
            return false;
        }
        if(o instanceof Dish) {
            Dish dish = (Dish) o;
            Dish foundedDish= dishRepository.findByNameIgnoreCase(dish.getName());
            if(foundedDish == null) {
                return true;
            }
            if(foundedDish.getId() == dish.getId())
                return true;
        }
        return false;
    }
}

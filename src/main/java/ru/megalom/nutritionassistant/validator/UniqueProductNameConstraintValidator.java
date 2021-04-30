package ru.megalom.nutritionassistant.validator;

import org.springframework.beans.factory.annotation.Autowired;
import ru.megalom.nutritionassistant.model.Product;
import ru.megalom.nutritionassistant.model.User;
import ru.megalom.nutritionassistant.repository.ProductRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueProductNameConstraintValidator implements ConstraintValidator<UniqueProductNameConstraint,Object> {

    @Autowired
    ProductRepository productRepository;

    @Override
    public void initialize(UniqueProductNameConstraint constraintAnnotation) {

    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        if(productRepository==null)
            return true;

        if (o == null) {
            return false;
        }
        if(o instanceof Product) {
            Product product = (Product) o;
            Product foundedProduct= productRepository.findByNameIgnoreCase(product.getName());
            if(foundedProduct == null) {
                return true;
            }
            if(foundedProduct.getId() == product.getId())
                return true;
        }
        return false;
    }
}

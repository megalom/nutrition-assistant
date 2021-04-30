package ru.megalom.nutritionassistant.model;




///import org.junit.Before;
//import org.junit.Test;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

//import static org.junit.Assert.*;

public class ProductUnitTest {
    private static Validator validator;
    static {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.usingContext().getValidator();
    }

    @Test
    public void testValidators(){
        Product product = new Product();
        product.setId(0);
        product.setName("orange");
        product.setProtein(-1.0f);
        product.setFat(-1.0f);
        product.setNutrition(-1.0f);
        product.setPrice(-1.0f);
        Set<ConstraintViolation<Product>> violationSet = validator.validate(product);
        Assertions.assertTrue(violationSet.size()==4);

    }
}

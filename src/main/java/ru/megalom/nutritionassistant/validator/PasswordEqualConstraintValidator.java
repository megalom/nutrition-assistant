package ru.megalom.nutritionassistant.validator;

import ru.megalom.nutritionassistant.model.User;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Method;

public class PasswordEqualConstraintValidator
        implements ConstraintValidator<PasswordEqualConstraint,Object> {

    @Override
    public void initialize(PasswordEqualConstraint constraintAnnotation) {

    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext constraintValidatorContext) {
        try {
            Method methodGetPassword = obj.getClass().getMethod("getPassword");
            Method methodGetPasswordConfirm = obj.getClass().getMethod("getPasswordConfirm");

            if(methodGetPassword.invoke(obj) == null && methodGetPasswordConfirm.invoke(obj)==null)
                return true;
            if(methodGetPassword.invoke(obj) == null )
                return false;
            return methodGetPassword.invoke(obj).equals(methodGetPasswordConfirm.invoke(obj));

        } catch (NoSuchMethodException ex) {
            ex.printStackTrace();
            return false;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}

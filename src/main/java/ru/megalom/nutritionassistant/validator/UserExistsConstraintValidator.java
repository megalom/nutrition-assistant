package ru.megalom.nutritionassistant.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.megalom.nutritionassistant.model.User;
import ru.megalom.nutritionassistant.repository.UserRepository;
import ru.megalom.nutritionassistant.service.UserService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UserExistsConstraintValidator implements ConstraintValidator<UserExistsConstraint,Object> {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void initialize(UserExistsConstraint constraintAnnotation) {

    }

    @Override
    @Transactional(readOnly = true)
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        if (o == null) {
            return false;
        }
        if(o instanceof User) {
            User user = (User) o;
            User foundedUser= userRepository.findByUsername(user.getUsername().toLowerCase());
           if(foundedUser == null) {
               return true;
           }
        }
        return false;
    }
}

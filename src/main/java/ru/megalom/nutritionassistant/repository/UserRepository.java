package ru.megalom.nutritionassistant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.megalom.nutritionassistant.model.User;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUsername(String username);
}

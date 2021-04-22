package ru.megalom.nutritionassistant.service;

import ru.megalom.nutritionassistant.model.User;

public interface UserService {
    void save(User user);
    User findByUsername(String username);
}

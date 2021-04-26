package ru.megalom.nutritionassistant.service;

import ru.megalom.nutritionassistant.model.Product;
import ru.megalom.nutritionassistant.model.User;

import java.util.List;

public interface ProductService {
    List<Product> findProducts();
    Product findById(int id);
    void delete(int id);
    void save(Product product);
    Product findByName(String name);
}

package ru.megalom.nutritionassistant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.megalom.nutritionassistant.model.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    Product findByName(String productName);
}

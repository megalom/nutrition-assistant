package ru.megalom.nutritionassistant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.megalom.nutritionassistant.model.Product;
import ru.megalom.nutritionassistant.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> findProducts() {
        return productRepository.findAll();
    };

    @Override
    public Product findById(int id) {
        Optional<Product> result=productRepository.findById(id);
        Product product=null;
        if(result.isPresent())
        {
            product=result.get();
        }
        else {
            throw new RuntimeException("id not found");
        }
        return product;
    }

    @Override
    public void delete(int id) {
        productRepository.deleteById(id);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product findByName(String name) {
        return productRepository.findByName(name);
    }
}

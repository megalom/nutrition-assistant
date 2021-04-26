package ru.megalom.nutritionassistant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.megalom.nutritionassistant.model.Product;
import ru.megalom.nutritionassistant.service.ProductService;

@Controller
@RequestMapping("/nutrition/products")
public class ProductsController {
    @Autowired
    ProductService productService;

    @GetMapping()
    public String productsList(Model model){
        model.addAttribute("products",productService.findProducts());
        return "/nutrition/products/products";
    }

    @GetMapping("/new")
    public String newProduct(Model model){
        Product product= new Product();
        model.addAttribute("productForm",product);
        return "/nutrition/products/new";
    }

    @PostMapping()
    public String addProduct(@ModelAttribute("productForm") Product product){
        productService.save(product);
        return "redirect:/nutrition/products";
    }
}

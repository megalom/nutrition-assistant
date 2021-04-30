package ru.megalom.nutritionassistant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.megalom.nutritionassistant.model.Product;
import ru.megalom.nutritionassistant.service.ProductService;

import javax.validation.Valid;

@Controller
@RequestMapping("/nutrition/products")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping()
    public String productsList(Model model){
        model.addAttribute("products",productService.findAll());
        return "/nutrition/products/index";
    }

    @GetMapping("/new")
    public String newProductForm(Model model){
        Product product= new Product();
        model.addAttribute("productForm",product);
        return "/nutrition/products/new";
    }

    @GetMapping("/{id}/edit")
    public String updateProductForm(@PathVariable("id") int id, Model model){
        Product editProduct = productService.findById(id);
        model.addAttribute("editProductForm", editProduct);
        return "/nutrition/products/edit";
    }

    @PostMapping()
    public String addProduct(@ModelAttribute("productForm") @Valid Product product,
                             BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return "/nutrition/products/new";

        productService.save(product);
        return "redirect:/nutrition/products";
    }

    @PostMapping("/{id}/update")
    public String updateProduct(@PathVariable("id") int id,
                                @ModelAttribute("editProductForm") @Valid Product product,
                                BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return "/nutrition/products/edit";
        productService.save(product);
        return "redirect:/nutrition/products";
    }

    @GetMapping("/{id}/delete")
    public String deleteProduct(@PathVariable("id") int id){
        productService.delete(id);
        return "redirect:/nutrition/products";
    }

}

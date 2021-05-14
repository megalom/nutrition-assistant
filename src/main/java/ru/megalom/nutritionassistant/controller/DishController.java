package ru.megalom.nutritionassistant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.megalom.nutritionassistant.model.Dish;
import ru.megalom.nutritionassistant.model.DishesProducts;
import ru.megalom.nutritionassistant.model.DishesProductsForm;
import ru.megalom.nutritionassistant.model.Product;
import ru.megalom.nutritionassistant.service.DishService;
import ru.megalom.nutritionassistant.service.DishesProductsService;
import ru.megalom.nutritionassistant.service.ProductService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/nutrition/dishes")
public class DishController {
    @Autowired
    DishService dishService;
    @Autowired
    ProductService productService;
    @Autowired
    DishesProductsService dishesProductsService;

    // Отображение всех доступных блюд
    @GetMapping()
    public String getDishes(Model model)
    {
        model.addAttribute("dishes", dishService.findAll());
        return "/nutrition/dishes/index";
    }

    // Отображение формы создания нового блюда
    @GetMapping("/new")
    public String newProductForm(Model model){
        Dish dish= new Dish();
        model.addAttribute("dishForm",dish);
        return "/nutrition/dishes/new";
    }

    // Отображение формы редакрирования данных о блюде
    @GetMapping("/{id}/edit")
    public String updateDishForm(@PathVariable("id") int id, Model model){
        Dish editDish = dishService.findById(id);
        model.addAttribute("editDishForm", editDish);
        return "/nutrition/dishes/edit";
    }

    // Добавление нового блюда
    @PostMapping()
    public String addDish(@ModelAttribute("dishForm") @Valid Dish dish,
                             BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return "/nutrition/dishes/new";

        dishService.save(dish);

        return "redirect:/nutrition/dishes";
    }

    // Обновление информации о блюде
    @PostMapping("/{id}/update")
    public String updateDish(@PathVariable("id") int id,
                                @ModelAttribute("editDishForm") @Valid Dish dish,
                                BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return "/nutrition/dishes/edit";
        dishService.save(dish);
        return "redirect:/nutrition/dishes";
    }

    // Удаление блюда
    @GetMapping("/{id}/delete")
    public String deleteDish(@PathVariable("id") int id){
        dishService.delete(id);
        return "redirect:/nutrition/dishes";
    }

    // Отображение формы добавления продукта
    @GetMapping("/{id}/addProduct")
    public String showAddProductForm(@PathVariable("id") int id, Model model){
        DishesProductsForm dishesProductsForm = new DishesProductsForm();
        dishesProductsForm.setId(0);
        dishesProductsForm.setDishId(id);
        List<Product> products = productService.findAll();
        model.addAttribute("products",products);
        model.addAttribute("dishesProductsForm", dishesProductsForm);
        return "/nutrition/dishes/add_product";
    }

    // Добавление нового продукта к блюду
    // Создание новой связи в таблице dishes_products
    @PostMapping("/addProduct")
    public String addProduct(@ModelAttribute("dishesProductsForm") DishesProductsForm dishesProductsForm){
        DishesProducts dishesProducts = new DishesProducts();
        dishesProducts.setId(0);
        dishesProducts.setDish(dishService.findById(dishesProductsForm.getDishId()));
        dishesProducts.setProduct(productService.findById(dishesProductsForm.getProductId()));
        dishesProducts.setWeight(dishesProductsForm.getWeight());
        dishesProductsService.save(dishesProducts);
        return "redirect:/nutrition/dishes/"+dishesProductsForm.getDishId()+"/composition";
    }

    // Отображение состава блюда
    @GetMapping("/{id}/composition")
    public String showComposition(@PathVariable("id") int id, Model model){
        Dish dish = dishService.findById(id);
        model.addAttribute("dish", dish);
        return "/nutrition/dishes/composition";
    }

    @GetMapping("/{id}/deleteProduct")
    public String deleteProductFromDish(@RequestParam int dpId, @PathVariable("id") int dishId){
        DishesProducts dishesProducts=dishesProductsService.findById(dpId);
        dishesProductsService.delete(dishesProducts);
        return "redirect:/nutrition/dishes/"+dishId+"/composition";
    }

}

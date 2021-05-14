package ru.megalom.nutritionassistant.model;

import org.springframework.beans.factory.annotation.Autowired;
import ru.megalom.nutritionassistant.service.DishesProductsService;
import ru.megalom.nutritionassistant.validator.UniqueDishNameConstraint;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Entity
@Table(name="dishes")
@UniqueDishNameConstraint(message = "{Exists.dishForm.NameExists}")
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    int id;

    @NotEmpty(message = "{NotEmpty}")
    @Size(min=2,max=50, message = "{Size.productForm.name}")
    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "dish")
    private Set <DishesProducts> dishesProducts = new HashSet<>();


    public Dish() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<DishesProducts> getDishesProducts() {
        return dishesProducts;
    }

    public void setDishesProducts(Set<DishesProducts> dishesProducts) {
        this.dishesProducts = dishesProducts;
    }

    // возвращает количество белка в 100 г блюда
    public float getProtein(){
        return Calculator.getProteinFromDish(this);
    }

    // возвращает количество жира в 100 г блюда
    public float getFat(){
        return Calculator.getFatFromDish(this);
    }

    // возвращает количество углеводов 100 г блюда
    public float getNutrition(){
        return Calculator.getNutritionFromDish(this);
    }

    public float getCalories(){
        return Calculator.getCaloriesFromDish(this);
    }

    // возвращает цену 100 г блюда
    public float getPrice(){
        return Calculator.getPriceFromDish(this);
    }
}

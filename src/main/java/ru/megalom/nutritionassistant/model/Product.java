package ru.megalom.nutritionassistant.model;

import ru.megalom.nutritionassistant.validator.UniqueProductNameConstraint;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name="products")
@UniqueProductNameConstraint(message = "{Exists.productForm.NameExists}")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @NotEmpty(message = "{NotEmpty}")
    @Size(min=2,max=50, message = "{Size.productForm.name}")
    @Column(name="name")
    private String name;

    @DecimalMin(value = "0.0",message ="{DecimalMin.productFrom.minFloatField}")
    @Column(name="protein")
    private float protein;

    @DecimalMin(value = "0.0",message ="{DecimalMin.productFrom.minFloatField}")
    @Column(name="fat")
    private float fat;

    @DecimalMin(value = "0.0",message ="{DecimalMin.productFrom.minFloatField}")
    @Column(name="nutrition")
    private float nutrition;

    @DecimalMin(value = "0.0",message ="{DecimalMin.productFrom.minFloatField}")
    @Column(name="price")
    private float price;

    @OneToMany(mappedBy = "product")
    private Set <DishesProducts> dishesProducts;

    public Product() {
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

    public float getProtein() {
        return protein;
    }

    public void setProtein(float protein) {
        this.protein = protein;
    }

    public float getFat() {
        return fat;
    }

    public void setFat(float fat) {
        this.fat = fat;
    }

    public float getNutrition() {
        return nutrition;
    }

    public void setNutrition(float nutrition) {
        this.nutrition = nutrition;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Set<DishesProducts> getDishesProducts() {
        return dishesProducts;
    }

    public void setDishesProducts(Set<DishesProducts> dishesProducts) {
        this.dishesProducts = dishesProducts;
    }
}

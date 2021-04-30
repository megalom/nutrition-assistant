package ru.megalom.nutritionassistant.model;

import javax.persistence.*;

@Entity
@Table(name="dishes_products")
public class DishesProducts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="dishes_id")
    private int dishesId;
    @Column(name="products_id")
    private int productsId;
    @Column(name="weight")
    private float weight;

    public DishesProducts() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDishesId() {
        return dishesId;
    }

    public void setDishesId(int dishesId) {
        this.dishesId = dishesId;
    }

    public int getProductsId() {
        return productsId;
    }

    public void setProductsId(int productsId) {
        this.productsId = productsId;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
}

package ru.megalom.nutritionassistant.model;

import org.springframework.beans.factory.annotation.Autowired;
import ru.megalom.nutritionassistant.service.DishesProductsService;
import ru.megalom.nutritionassistant.validator.UniqueDishNameConstraint;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Iterator;
import java.util.Set;

@Entity
@Table(name="dishes")
@SecondaryTable(
        name = "dishes_products",
        pkJoinColumns = {
                @PrimaryKeyJoinColumn(name="id",referencedColumnName="dishes_id")
})
@UniqueDishNameConstraint(message = "{Exists.dishForm.NameExists}")
public class Dish {
    @Autowired
    DishesProductsService dishesProductsService;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    int id;

    @NotEmpty(message = "{NotEmpty}")
    @Size(min=2,max=50, message = "{Size.productForm.name}")
    @Column(name="name")
    private String name;

    @Column(table = "dishes_products",name="weight")
    private float weight;

    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH})
    @JoinTable(name="dishes_products",
            joinColumns = @JoinColumn(name="dishes_id"),
            inverseJoinColumns = @JoinColumn(name="products_id")
    )
    Set<Product> products;


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

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    // возвращает количество белка в 100 г блюда
    public float getProtein(){
        float protein=0.0f;
        Iterator<Product> productIterator= products.iterator();
        while(productIterator.hasNext()){
            Product tmpProduct = productIterator.next();
            DishesProducts dishesProducts=dishesProductsService.findByDishesIdAndProductsId(id,tmpProduct.getId());
            float weight=dishesProducts.getWeight();
            protein+=tmpProduct.getProtein()*0.01f*weight;
        }
        return protein;
    }

    // возвращает количество жира в 100 г блюда
    public float getFat(){
        return 1.0f;
    }

    // возвращает количество углеводов 100 г блюда
    public float getNutrition(){
        return 2.0f;
    }
    //Возвращает количество калорий в 100 г. блюда
    //подсчет калорий из рассчета на каллории в 1г * количество грамм
    public float getCalories(){
        return getFat()*9.29f+getProtein()*4.1f+getNutrition()*4.1f;
    }

    public float getPrice(){
        return 4.0f;
    }
}

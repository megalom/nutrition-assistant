package ru.megalom.nutritionassistant.model;

import javax.persistence.*;

@Entity
@Table(name="templates_dishes")
public class TemplatesDishes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name="dish_id")
    private Dish dish;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name="template_id")
    private MenuTemplate menuTemplate;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name="eat_type_id")
    private EatType eatType;

    @Column(name = "weight")
    private float weight;

    public TemplatesDishes() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public MenuTemplate getMenuTemplate() {
        return menuTemplate;
    }

    public void setMenuTemplate(MenuTemplate menuTemplate) {
        this.menuTemplate = menuTemplate;
    }

    public EatType getEatType() {
        return eatType;
    }

    public void setEatType(EatType eatType) {
        this.eatType = eatType;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getProtein(){
        return Calculator.getProteinFromDish(dish,weight);
    }

    public float getFat(){
        return Calculator.getFatFromDish(dish,weight);
    }

    public float getNutrition(){
        return Calculator.getNutritionFromDish(dish,weight);
    }

    public float getCalories(){
        return Calculator.getCaloriesFromDish(dish,weight);
    }

    public float getPrice(){
        return Calculator.getPriceFromDish(dish,weight);
    }
}

package ru.megalom.nutritionassistant.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="templates")
public class MenuTemplate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "menuTemplate")
    private Set<TemplatesDishes> templatesDishes = new HashSet<>();

    public MenuTemplate() {
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

    public Set<TemplatesDishes> getTemplatesDishes() {
        return templatesDishes;
    }

    public void setTemplatesDishes(Set<TemplatesDishes> templatesDishes) {
        this.templatesDishes = templatesDishes;
    }

    public float getProtein(){
        return Calculator.getProteinFromMenuTemplate(this);
    }
    public float getFat(){
        return Calculator.getFatFromMenuTemplate(this);
    }
    public float getNutrition(){
        return Calculator.getNutritionFromMenuTemplate(this);
    }
    public float getCalories(){
        return Calculator.getCaloriesFromMenuTemplate(this);
    }
    public float getPrice(){
        return Calculator.getPriceFromMenuTemplate(this);
    }
    public float getTotalWeight(){
        return Calculator.getMenuTemplateTotalWeight(this);
    }
}

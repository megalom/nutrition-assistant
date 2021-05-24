package ru.megalom.nutritionassistant.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="eat_type")
public class EatType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="priority")
    private int priority;

    @OneToMany(mappedBy = "eatType")
    private Set<UsersDishes> usersDishes = new HashSet<>();

    @OneToMany(mappedBy = "eatType")
    private Set<TemplatesDishes> menuTempaltes = new HashSet<>();

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

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Set<UsersDishes> getUsersDishes() {
        return usersDishes;
    }

    public Set<TemplatesDishes> getMenuTempaltes() {
        return menuTempaltes;
    }
}

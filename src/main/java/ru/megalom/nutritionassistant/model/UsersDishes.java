package ru.megalom.nutritionassistant.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="users_dishes")
public class UsersDishes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name="eat_type")
    private EatType eatType;

    @Column(name="eat_date")
    private Date eatDate;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name="dish_id")
    private Dish dish;

    @Column(name="weight")
    private float weight;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public EatType getEatType() {
        return eatType;
    }

    public void setEatType(EatType eatType) {
        this.eatType = eatType;
    }

    public Date getEatDate() {
        return eatDate;
    }

    public void setEatDate(Date eatDate) {
        this.eatDate = eatDate;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
}

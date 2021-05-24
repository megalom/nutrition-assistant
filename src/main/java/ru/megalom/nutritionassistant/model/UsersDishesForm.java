package ru.megalom.nutritionassistant.model;

import java.sql.Date;

public class UsersDishesForm {
    private int userId;
    private int eatTypeId;
    private Date eatDate;
    private int dishId;
    private float weight;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getEatTypeId() {
        return eatTypeId;
    }

    public void setEatTypeId(int eatTypeId) {
        this.eatTypeId = eatTypeId;
    }

    public Date getEatDate() {
        return eatDate;
    }

    public void setEatDate(Date eatDate) {
        this.eatDate = eatDate;
    }

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
}

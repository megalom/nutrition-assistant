package ru.megalom.nutritionassistant.model;

public class TemplatesDishesFrom {
    private int id;
    private int dishId;
    private int templateId;
    private int eatTypeId;
    private float weight;

    public TemplatesDishesFrom() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public int getTemplateId() {
        return templateId;
    }

    public void setTemplateId(int templateId) {
        this.templateId = templateId;
    }

    public int getEatTypeId() {
        return eatTypeId;
    }

    public void setEatTypeId(int eatTypeId) {
        this.eatTypeId = eatTypeId;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
}

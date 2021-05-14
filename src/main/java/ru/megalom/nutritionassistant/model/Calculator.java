package ru.megalom.nutritionassistant.model;

import java.util.Iterator;
import java.util.Set;

public class Calculator {

    //Возвращает количество калорий в 100 г. блюда
    //подсчет калорий из рассчета на каллории в 1г * количество грамм
    public static float getCalories(float protein, float fat, float nutrition){
        return fat*9.29f+protein*4.1f+nutrition*4.1f;
    }

    public static float getProteinFromDish(Dish dish){
        float protein = 0;
        Set<DishesProducts> dishesProducts=dish.getDishesProducts();
        Iterator<DishesProducts> dishesProductsIterator = dishesProducts.iterator();
        while (dishesProductsIterator.hasNext()){
            protein+=dishesProductsIterator.next().getProtein();
        }
        return protein;
    }

    public static float getFatFromDish(Dish dish){
        float fat = 0;
        Set<DishesProducts> dishesProducts=dish.getDishesProducts();
        Iterator<DishesProducts> dishesProductsIterator = dishesProducts.iterator();
        while (dishesProductsIterator.hasNext()){
            fat+=dishesProductsIterator.next().getFat();
        }
        return fat;
    }

    public static float getNutritionFromDish(Dish dish){
        float nutrition = 0;
        Set<DishesProducts> dishesProducts=dish.getDishesProducts();
        Iterator<DishesProducts> dishesProductsIterator = dishesProducts.iterator();
        while (dishesProductsIterator.hasNext()){
            nutrition+=dishesProductsIterator.next().getNutrition();
        }
        return nutrition;
    }

    public static float getPriceFromDish(Dish dish){
        float price = 0;
        Set<DishesProducts> dishesProducts=dish.getDishesProducts();
        Iterator<DishesProducts> dishesProductsIterator = dishesProducts.iterator();
        while (dishesProductsIterator.hasNext()){
            price+=dishesProductsIterator.next().getPrice();
        }
        return price;
    }

    public  static float getCaloriesFromDish(Dish dish){
        float calories = 0;
        Set<DishesProducts> dishesProducts=dish.getDishesProducts();
        Iterator<DishesProducts> dishesProductsIterator = dishesProducts.iterator();
        while (dishesProductsIterator.hasNext()){
            calories+=dishesProductsIterator.next().getCalories();
        }
        return calories;
    }

    public static float getCaloriesFromProduct(Product product){
        return getCalories(product.getProtein(),product.getFat(),product.getNutrition());
    }

    public static float getCaloriesFromProduct(Product product,float weight){
        return getCalories(product.getProtein(),product.getFat(),product.getNutrition())*weight*0.01f;
    }

    public static float getProteinFromProduct(Product product,float weight){
        return product.getProtein()*weight*0.01F;
    }

    public static float getFatFromProduct(Product product,float weight){
        return product.getFat()*weight*0.01F;
    }
    public static float getNutritionFromProduct(Product product,float weight){
        return product.getNutrition()*weight*0.01F;
    }
    public static float getPriceFromProduct(Product product,float weight){
        return product.getPrice()*weight*0.01F;
    }
}

package ru.megalom.nutritionassistant.model;

import java.util.Iterator;
import java.util.Set;

public class Calculator {

    //Возвращает количество калорий в 100 г. блюда
    //подсчет калорий из рассчета на каллории в 1г * количество грамм
    public static float calculateCalories(float protein, float fat, float nutrition){
        //return fat*9.29f+protein*4.1f+nutrition*4.1f;
        return fat*9F+protein*4F+nutrition*4F;
    }

    /*
        Рассчет БЖУ и калорий для блюд
     */

    //Вычисление общей массы блюда
    public static float getTotalDishWeight(Dish dish){
        float totalWeight=0;
        Set<DishesProducts> dishesProducts=dish.getDishesProducts();
        Iterator<DishesProducts> dishesProductsIterator = dishesProducts.iterator();
        while (dishesProductsIterator.hasNext()){
            DishesProducts tempDishesProducts=dishesProductsIterator.next();
            totalWeight+=tempDishesProducts.getWeight();
        }
        return totalWeight;

    }

    //Вычисление общей массы меню
    public static float getMenuTemplateTotalWeight(MenuTemplate menuTemplate){
        float totalWeight=0;
        Set<TemplatesDishes> templatesDishes=menuTemplate.getTemplatesDishes();
        Iterator<TemplatesDishes> templatesDishesIterator = templatesDishes.iterator();
        while (templatesDishesIterator.hasNext()){
            TemplatesDishes templatesDishes1=templatesDishesIterator.next();
            totalWeight+=templatesDishes1.getWeight();
        }
        return totalWeight;

    }

    /*  Вычисляет массу компонента(БЖУ) относительно общей массы блюда
        и возвращает реузльтат на 100 грамм блюда.
        Масса компонента в блюде вычисляется по формуле:
        масса = масса компонента в блюде / общую массу блюда * 100

     */
    public static float getComponentMass(
            float totalWeight,
            float componentMass
    ){
        return componentMass/totalWeight*100F;
    }
    /*  Возвращает количество белка в блюде по формуле:
        белок += (количество белка в блюде от данного продукта)/
    */
    public static float getProteinFromDish(Dish dish){
        float protein = 0;
        Set<DishesProducts> dishesProducts=dish.getDishesProducts();
        Iterator<DishesProducts> dishesProductsIterator = dishesProducts.iterator();
        while (dishesProductsIterator.hasNext()){
            DishesProducts tempDishesProducts=dishesProductsIterator.next();
            protein+=getComponentMass(
                    tempDishesProducts.getDish().getTotalWeight(),
                    tempDishesProducts.getProtein());
        }
        return protein;
    }

    public static float getFatFromDish(Dish dish){
        float fat = 0;
        Set<DishesProducts> dishesProducts=dish.getDishesProducts();
        Iterator<DishesProducts> dishesProductsIterator = dishesProducts.iterator();
        while (dishesProductsIterator.hasNext()){
            DishesProducts tempDishesProducts=dishesProductsIterator.next();
            fat+=getComponentMass(
                    tempDishesProducts.getDish().getTotalWeight(),
                    tempDishesProducts.getFat());
        }
        return fat;
    }

    public static float getNutritionFromDish(Dish dish){
        float nutrition = 0;
        Set<DishesProducts> dishesProducts=dish.getDishesProducts();
        Iterator<DishesProducts> dishesProductsIterator = dishesProducts.iterator();
        while (dishesProductsIterator.hasNext()){
            DishesProducts tempDishesProducts=dishesProductsIterator.next();
            nutrition+=getComponentMass(
                    tempDishesProducts.getDish().getTotalWeight(),
                    tempDishesProducts.getNutrition());
        }
        return nutrition;
    }

    public static float getPriceFromDish(Dish dish){
        float price = 0;
        Set<DishesProducts> dishesProducts=dish.getDishesProducts();
        Iterator<DishesProducts> dishesProductsIterator = dishesProducts.iterator();
        while (dishesProductsIterator.hasNext()){
            DishesProducts tempDishesProducts=dishesProductsIterator.next();
            price+=getComponentMass(
                    tempDishesProducts.getDish().getTotalWeight(),
                    tempDishesProducts.getPrice());
        }
        return price;
    }

    public  static float getCaloriesFromDish(Dish dish){
        float calories = 0;
        Set<DishesProducts> dishesProducts=dish.getDishesProducts();
        Iterator<DishesProducts> dishesProductsIterator = dishesProducts.iterator();
        while (dishesProductsIterator.hasNext()){
            DishesProducts tempDishesProducts=dishesProductsIterator.next();
            calories+=getComponentMass(
                    tempDishesProducts.getDish().getTotalWeight(),
                    tempDishesProducts.getCalories());
        }
        return calories;
    }

    /*
        Рассчет БЖУ и калорий для продуктов по формуле:
        БЖУ(от веса) = БЖУ(на 100грамм) * вес продукта * 0.01(либо /100)
     */
    public static float getCaloriesFromProduct(Product product){
        return calculateCalories(product.getProtein(),product.getFat(),product.getNutrition());
    }

    public static float getCaloriesFromProduct(Product product,float weight){
        return calculateCalories(product.getProtein(),product.getFat(),product.getNutrition())*weight*0.01f;
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

    /*
        Рассчет БЖУ блюда в зависимости от веса по формуле
        БЖУ (от веса) = содержание БЖУ на 100гр. * вес блюда * 0.01F ( или /100)
     */

    public static float getCaloriesFromDish(Dish dish,float weight){ return calculateCalories(dish.getProtein(),dish.getFat(),dish.getNutrition())*weight*0.01f; }
    public static float getProteinFromDish(Dish dish,float weight){ return dish.getProtein()*weight*0.01F; }
    public static float getFatFromDish(Dish dish,float weight){
        return dish.getFat()*weight*0.01F;
    }
    public static float getNutritionFromDish(Dish dish,float weight){return dish.getNutrition()*weight*0.01F; }
    public static float getPriceFromDish(Dish dish,float weight){
        return dish.getPrice()*weight*0.01F;
    }


    /*
        Рассчет БЖУ и калорий для шаблона меню по формуле:
        масса БЖУ += масса БЖУ блюда в меню / общую массу всех блюд в меню * 100

     */
    public static float getProteinFromMenuTemplate(MenuTemplate menuTemplate){
        float protein = 0;
        Set<TemplatesDishes> templatesDishes=menuTemplate.getTemplatesDishes();
        Iterator<TemplatesDishes> templatesDishesIterator = templatesDishes.iterator();
        while (templatesDishesIterator.hasNext()){
            TemplatesDishes tempTemplatesDishes=templatesDishesIterator.next();
            protein +=tempTemplatesDishes.getProtein();
        }
        return protein;
    }

    public static float getFatFromMenuTemplate(MenuTemplate menuTemplate){
        float fat = 0;
        Set<TemplatesDishes> templatesDishes=menuTemplate.getTemplatesDishes();
        Iterator<TemplatesDishes> templatesDishesIterator = templatesDishes.iterator();
        while (templatesDishesIterator.hasNext()){
            TemplatesDishes tempTemplatesDishes=templatesDishesIterator.next();
            fat += tempTemplatesDishes.getFat();
        }
        return fat;
    }

    public static float getNutritionFromMenuTemplate(MenuTemplate menuTemplate){
        float nutrition = 0;
        Set<TemplatesDishes> templatesDishes=menuTemplate.getTemplatesDishes();
        Iterator<TemplatesDishes> templatesDishesIterator = templatesDishes.iterator();
        while (templatesDishesIterator.hasNext()){
            TemplatesDishes tempTemplatesDishes=templatesDishesIterator.next();
            nutrition += tempTemplatesDishes.getNutrition();
        }
        return nutrition;
    }

    public static float getPriceFromMenuTemplate(MenuTemplate menuTemplate){
        float price = 0;
        Set<TemplatesDishes> templatesDishes=menuTemplate.getTemplatesDishes();
        Iterator<TemplatesDishes> templatesDishesIterator = templatesDishes.iterator();
        while (templatesDishesIterator.hasNext()){
            TemplatesDishes tempTemplatesDishes=templatesDishesIterator.next();
            price +=tempTemplatesDishes.getPrice();
        }
        return price;
    }

    public static float getCaloriesFromMenuTemplate(MenuTemplate menuTemplate){
        float calories = 0;
        Set<TemplatesDishes> templatesDishes=menuTemplate.getTemplatesDishes();
        Iterator<TemplatesDishes> templatesDishesIterator = templatesDishes.iterator();
        while (templatesDishesIterator.hasNext()){
            TemplatesDishes tempTemplatesDishes=templatesDishesIterator.next();
            calories +=tempTemplatesDishes.getCalories();
        }
        return calories;
    }
}

package ru.megalom.nutritionassistant.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import ru.megalom.nutritionassistant.repository.DishesProductsRepository;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@TestPropertySource(
        locations = "classpath:application-integrationtest.properties")
//@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class DishesProductsRepositoryIntegrationTest {

    @Autowired
    TestEntityManager entityManager;

    @Autowired
    DishesProductsRepository dishesProductsRepository;

    @Test
    public void whenFindByDishesIdAndProductsId_thenReturnDishesProducts(){
        Dish dish = new Dish();
        dish.setId(0);
        dish.setName("Test Dish");


        Product product = new Product();
        product.setId(0);
        product.setName("Cheese");

        DishesProducts testDishesProducts = new DishesProducts();
        testDishesProducts.setId(0);
        testDishesProducts.setDish(dish);
        testDishesProducts.setProduct(product);
        testDishesProducts.setWeight(153);

        entityManager.persistAndFlush(testDishesProducts);

        DishesProducts dishesProducts = dishesProductsRepository.
                findByDish_IdAndProduct_Id(1,1);

        assertThat(dishesProducts.getDish().getName()).isEqualTo(dish.getName());

    }
}

package service.repositories;

import model.FoodDrink;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FoodDrinkRepoTest {

    /*
    KARENA PENGGUNAAN SINGLETON , LAKUKAN TEST SATU PERSATU
    PENGUNAAN SINGLETON DISADARI KELOMPOK KAMI AKAN BURUK UNTUK MELAKUKAN TESTING

     */

    FoodDrinkRepo foodDrinkRepo = FoodDrinkRepo.getInstance();
    FoodDrink fd1,fd2,fd3;

    @Before
    public void setup(){
        fd1 = new FoodDrink();
        fd1.setFoodMenuNumber(1);
        foodDrinkRepo.insertFoodDrink(fd1);
        fd2 = new FoodDrink();
        fd2.setFoodMenuNumber(2);
        foodDrinkRepo.insertFoodDrink(fd2);
        fd3 = new FoodDrink();
        fd3.setFoodMenuNumber(3);
    }

    @Test
    public void insertFoodDrink() {
        foodDrinkRepo.insertFoodDrink(fd3);
        assertEquals(foodDrinkRepo.getAllFoodDrink().size(),3);
    }

    @Test
    public void deleteFoodDrink() {
        foodDrinkRepo.deleteFoodDrink(fd1);
        assertEquals(foodDrinkRepo.getFoodDrinkById(1),null);
    }

    @Test
    public void updateFoodDrink() {
        fd1.setFdMenuItem("a");
        assertEquals(fd1.getFdMenuItem(),"a");
        fd1.setFdMenuItem("b");
        foodDrinkRepo.updateFoodDrink(fd1.getFoodMenuNumber(),fd1);
        assertEquals(foodDrinkRepo.getFoodDrinkById(1).getFdMenuItem(),fd1.getFdMenuItem());
    }

    @Test
    public void getAllFoodDrink() {
        foodDrinkRepo.insertFoodDrink(fd3);
        assertEquals(foodDrinkRepo.getAllFoodDrink().size(),3);
    }

    @Test
    public void getFoodDrinkById() {
        assertEquals(foodDrinkRepo.getFoodDrinkById(1),fd1);
    }
}
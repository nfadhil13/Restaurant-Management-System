package service.dao;

import model.FoodDrink;

import java.util.List;

public interface FoodDrinkDao {

    void insertFoodDrink(FoodDrink foodDrink);
    void deleteFoodDrink(int id);
    void updateFoodDrink(int id , FoodDrink foodDrink);
    List<FoodDrink> getAllFoodDrink();
    FoodDrink getFoodDrinkById(int id);
}

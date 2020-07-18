package service.repositories;

import model.Booking;
import model.FoodDrink;
import service.dao.FoodDrinkDao;

import java.util.ArrayList;
import java.util.List;

public class FoodDrinkRepo implements FoodDrinkDao {
    private static List<FoodDrink> foodDrinkList = new ArrayList<>();
    private static FoodDrinkRepo INSTANCE;

    private FoodDrinkRepo() {
    }

    public static FoodDrinkRepo getInstance(){
        if(INSTANCE==null){
            INSTANCE = new FoodDrinkRepo();
        }
        return INSTANCE;
    }



    @Override
    public void insertFoodDrink(FoodDrink foodDrink) {
        foodDrinkList.add(foodDrink);
    }

    @Override
    public void deleteFoodDrink(int id) {
        foodDrinkList.remove(id);
    }

    @Override
    public void updateFoodDrink(int id, FoodDrink foodDrink) {
        foodDrinkList.add(id,foodDrink);
        foodDrinkList.remove(id+1);
    }

    @Override
    public List<FoodDrink> getAllFoodDrink() {
        return foodDrinkList;
    }

    @Override
    public FoodDrink getFoodDrinkById(int id) {
        return foodDrinkList.get(id);
    }
}

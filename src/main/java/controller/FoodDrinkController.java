package controller;

import model.FoodDrink;
import service.repositories.FoodDrinkRepo;
import view.FoodDrinkView;

public class FoodDrinkController {

    private FoodDrinkRepo repo;
    private FoodDrinkView view;

    public FoodDrinkController(){
        repo = FoodDrinkRepo.getInstance();
        view = new FoodDrinkView();

    }

    public void addFoodDrink(){
        FoodDrink temp = view.addFoodDrink();
        int foodDrinkNumber = 0;
        for(FoodDrink foodDrink : repo.getAllFoodDrink()){
            int number = foodDrink.getFoodMenuNumber();
            if(number > foodDrinkNumber){
                foodDrinkNumber = number;
            }
        }
        temp.setFoodMenuNumber(foodDrinkNumber+1);
        repo.insertFoodDrink(temp);
    }

    public void printFoodDrink(){
        view.printFoodDrink(repo.getAllFoodDrink());
    }
    
//    public FoodDrink getFoodDrinkById(int id) {
//    	return repo.getFoodDrinkById(id);
//    }

    public void deleteFoodDrink(){
        repo.deleteFoodDrink(view.deleteFoodDrink());
    }
}

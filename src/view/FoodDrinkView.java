package view;

import model.FoodDrink;

import java.util.List;
import java.util.Scanner;

public class FoodDrinkView {

    public FoodDrink addFoodDrink(){
        Scanner input = new Scanner(System.in);
        System.out.print("Please Enter Food/Drink Item: "+ " \n ");
        String fdMenuItem = input.nextLine();
        fdMenuItem = input.nextLine();
        System.out.print("Please Enter Price: "+ " \n ");
        double itemPrice= input.nextInt();
        return new FoodDrink(fdMenuItem,itemPrice);
    }

    public void printFoodDrink(List<FoodDrink> foodDrinkList){
        System.out.println("FoodDrink Item Details: \n========================\n");
        for(FoodDrink fdm : foodDrinkList){

            System.out.println("Number: "+ fdm.getFoodMenuNumber() +""+" \n " +
                    "\t" + "Item Name: "+fdm.getFdMenuItem()+" \n " +
                    "\t" + "Item Cost Cost.: "+fdm.getItemPrice());
            //number++;
        }
    }

    public int deleteFoodDrink(){
        System.out.println("Input ID of Food You want to delete");
        return new Scanner(System.in).nextInt();
    }
}

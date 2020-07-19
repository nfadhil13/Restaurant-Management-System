package model;

public class FoodDrink {
    private int foodMenuNumber;
    private String fdMenuItem;
    private double itemPrice;

    public FoodDrink() {
    }

    public FoodDrink(int foodMenuNumber, String fdMenuItem, double itemPrice) {
        this.foodMenuNumber = foodMenuNumber;
        this.fdMenuItem = fdMenuItem;
        this.itemPrice = itemPrice;
    }

    public FoodDrink(String fdMenuItem, double itemPrice) {
        this.fdMenuItem = fdMenuItem;
        this.itemPrice = itemPrice;
    }

    public int getFoodMenuNumber() {
        return foodMenuNumber;
    }

    public void setFoodMenuNumber(int foodMenuNumber) {
        this.foodMenuNumber = foodMenuNumber;
    }

    public String getFdMenuItem() {
        return fdMenuItem;
    }

    public void setFdMenuItem(String fdMenuItem) {
        this.fdMenuItem = fdMenuItem;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }
}

package model;

import java.time.LocalDateTime;

public class Purchase {

    private int purchaseNumber;
    private FoodDrink itemPurchased;
    private int quantity;
    private LocalDateTime purchaseTime;

	public Purchase(FoodDrink itemPurchased, int quantity) {
        this.itemPurchased = itemPurchased;
        this.quantity = quantity;
    }

    public Purchase(int purchaseNumber, FoodDrink itemPurchased, int quantity) {
        this.purchaseNumber = purchaseNumber;
        this.itemPurchased = itemPurchased;
        this.quantity = quantity;
    }

    public int getPurchaseNumber() {
        return purchaseNumber;
    }

    public void setPurchaseNumber(int purchaseNumber) {
        this.purchaseNumber = purchaseNumber;
    }

    public FoodDrink getItemPurchased() {
        return itemPurchased;
    }

    public void setItemPurchased(FoodDrink itemPurchased) {
        this.itemPurchased = itemPurchased;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public LocalDateTime getPurchaseTime() {
		return purchaseTime;
	}

	public void setPurchaseTime(LocalDateTime purchaseTime) {
		this.purchaseTime = purchaseTime;
	}
}

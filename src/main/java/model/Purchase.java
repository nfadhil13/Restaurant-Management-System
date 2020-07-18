package model;

public class Purchase {

    private int purchaseNumber;
    private String itemPurchased;
    private int quantity;


    public Purchase(String itemPurchased, int quantity) {
        this.itemPurchased = itemPurchased;
        this.quantity = quantity;
    }

    public Purchase(int purchaseNumber, String itemPurchased, int quantity) {
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

    public String getItemPurchased() {
        return itemPurchased;
    }

    public void setItemPurchased(String itemPurchased) {
        this.itemPurchased = itemPurchased;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

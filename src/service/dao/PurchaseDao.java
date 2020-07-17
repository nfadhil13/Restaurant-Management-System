package service.dao;



import model.Purchase;

import java.util.List;

public interface PurchaseDao {

    void insertPurchase(Purchase purchase);
    void deletePurchase(int id);
    void updatePurchase(int id , Purchase purchase);
    List<Purchase> getAllPurchase();
    Purchase getPurchaseById(int id);
}

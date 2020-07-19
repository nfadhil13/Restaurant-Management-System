package service.repositories;

import model.Purchase;
import service.dao.PurchaseDao;

import java.util.ArrayList;
import java.util.List;

public class PurchaseRepo implements PurchaseDao {
    private static List<Purchase> purchases = new ArrayList<>();
    private static PurchaseRepo INSTANCE;

    private PurchaseRepo() {

    }

    public static PurchaseRepo getInstance(){
        if(INSTANCE == null){
            INSTANCE = new PurchaseRepo();
        }
        return INSTANCE;
    }

    @Override
    public void insertPurchase(Purchase purchase) {
        purchases.add(purchase);
    }

    @Override
    public void deletePurchase(Purchase purchase) {
        purchases.remove(purchase);
    }

    @Override
    public void updatePurchase(int id, Purchase purchase) {
//        purchases.add(id,purchase);
//        purchases.remove(id+1);
    }

    @Override
    public List<Purchase> getAllPurchase() {
        return purchases;
    }

    @Override
    public Purchase getPurchaseById(int id) {
        for(Purchase purchase : purchases){
            if(purchase.getPurchaseNumber() == id){
                return  purchase;
            }
        }
        return null;
    }
}

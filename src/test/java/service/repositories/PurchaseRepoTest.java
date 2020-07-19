package service.repositories;

import model.Purchase;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PurchaseRepoTest {



    /*
    KARENA PENGGUNAAN SINGLETON , LAKUKAN TEST SATU PERSATU
    PENGUNAAN SINGLETON DISADARI KELOMPOK KAMI AKAN BURUK UNTUK MELAKUKAN TESTING


     */

    private PurchaseRepo repo = PurchaseRepo.getInstance();

    private Purchase p1,p2,p3,p4,newPurchase;


    @Before
    public void setup(){
        p1 = new Purchase();
        p1.setPurchaseNumber(1);
        p2 = new Purchase();
        p2.setPurchaseNumber(2);
        p3 = new Purchase();
        p3.setPurchaseNumber(3);
        p4 = new Purchase();
        p4.setPurchaseNumber(4);
        newPurchase = new Purchase();
        newPurchase.setPurchaseNumber(5);
        repo.insertPurchase(p2);
        repo.insertPurchase(p3);
        repo.insertPurchase(p4);
        repo.insertPurchase(p1);
    }


    @Test
    public void insertPurchase() {
        repo.insertPurchase(newPurchase);
        for(Purchase purchase : repo.getAllPurchase()){
            System.out.println(purchase.getPurchaseNumber());
        }
        assertEquals(repo.getAllPurchase().size() ,5);
        assertEquals(repo.getPurchaseById(5),newPurchase);




    }

    @Test
    public void deletePurchase() {
        repo.deletePurchase(p1);
        assertEquals(repo.getPurchaseById(1),null);
    }

    @Test
    public void updatePurchase() {
        p1.setQuantity(1);
        assertEquals(repo.getPurchaseById(1).getQuantity(),1);
        p1.setQuantity(2);
        repo.updatePurchase(2,p1);
        assertEquals(repo.getPurchaseById(1).getQuantity(),2);
    }

    @Test
    public void getAllPurchase() {
        assertEquals(repo.getAllPurchase().size(),4);
        assertEquals(repo.getPurchaseById(3),p3);
    }

    @Test
    public void getPurchaseById() {
        assertEquals(repo.getPurchaseById(2),p2);
    }
}
package controller;

import model.Booking;
import model.Purchase;
import service.repositories.BookingRepo;
import service.repositories.PurchaseRepo;
import view.BookingPurchaseView;

import java.util.List;

public class BookingPurchaseController {

    private PurchaseRepo purchaseRepo;
    private BookingPurchaseView view;
    private BookingRepo bookingRepo;

    public BookingPurchaseController(){
        this.purchaseRepo = PurchaseRepo.getInstance();
        bookingRepo = BookingRepo.getInstance();
        view = new BookingPurchaseView();
    }

    public void addPurchase(){
        Booking bookingThatPurchase  = bookingRepo.getBookingById(view.addPurchaseGetBookingID());
        Purchase tempPurchase = view.addPurchaseChooseItem();
        int newID =0;
        for(Purchase purchase : purchaseRepo.getAllPurchase()){
            int tempID = purchase.getPurchaseNumber();
            if(tempID>newID){
                newID = tempID;
            }
        }
        tempPurchase.setPurchaseNumber(newID+1);
        bookingThatPurchase.getPurchases().add(tempPurchase);
        purchaseRepo.insertPurchase(tempPurchase);
    }

    public void readAllPurchases(){
        view.printPurchases(bookingRepo.getAllBooking());
    }

    public void deletePurchase(){
        Booking bookingThatPurchase  = bookingRepo.getBookingById(view.deletePurchaseGetBookingId());
        int purchaseId = view.deletePurchaseGetPurchaseID();
        List<Purchase> purchases = bookingThatPurchase.getPurchases();
        boolean found = false;
        for(Purchase purchase : purchases){
            if(purchase.getPurchaseNumber() == purchaseId){
                purchases.remove(purchase);
                found = true;
            }
        }
        if(found){
            view.printMessage("Succes");
        }else{
            view.printMessage("FAIL TO FOUND ITEM");
        }
        bookingThatPurchase.setPurchases(purchases);

    }
}

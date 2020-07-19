package controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import model.Booking;
import model.FoodDrink;
import model.Purchase;
import model.Transaction;
import service.repositories.BookingRepo;
import service.repositories.FoodDrinkRepo;
import service.repositories.PurchaseRepo;
import service.repositories.TransactionRepo;
import view.BookingTransactionView;

public class BookingTransactionController {
	private TransactionRepo transactionRepo;
	private BookingRepo bookingRepo;
	private PurchaseRepo purchaseRepo;
	private FoodDrinkRepo foodDrinkRepo;
	private BookingTransactionView bookingTransactionView;
	
	public BookingTransactionController() {
		this.transactionRepo = TransactionRepo.getInstance();
		this.bookingRepo = BookingRepo.getInstance();
		this.purchaseRepo = PurchaseRepo.getInstance();
		this.foodDrinkRepo = FoodDrinkRepo.getInstance();
		this.bookingTransactionView = new BookingTransactionView();
	}
	
	public void addTransaction(Booking booking) {
		List<Purchase> listPurchase = new ArrayList<Purchase>();
		int newID = 0;
		long totalPayment = 0;
		boolean satisfied = false;
		while(!satisfied) {
//			foodDrinkController.printFoodDrink();
			int option = bookingTransactionView.chooseFood(foodDrinkRepo.getAllFoodDrink());
			if(option==0) {
				satisfied = true;
			}
			else {
				FoodDrink foodDrink = foodDrinkRepo.getFoodDrinkById(option);
				if(foodDrink==null) {
					bookingTransactionView.wrongOption();
				}
				else {
					int quantity = bookingTransactionView.enterQuantity();
					Purchase newPurchase = new Purchase(foodDrink, quantity);
			        for(Purchase purchase : purchaseRepo.getAllPurchase()){
			            int tempID = purchase.getPurchaseNumber();
			            if(tempID>newID){
			                newID = tempID;
			            }
			        }
			        newPurchase.setPurchaseNumber(newID+1);
			        newPurchase.setPurchaseTime(LocalDateTime.now());
			        totalPayment += foodDrink.getItemPrice()*quantity;
			        listPurchase.add(newPurchase);
			        
			        purchaseRepo.insertPurchase(newPurchase);
			        
				}
			}
		}
		newID = 0;
		for(Transaction transactionTemp : transactionRepo.getAllTransaction()){
            int tempID = transactionTemp.getTransactionNumber();
            if(tempID>newID){
                newID = tempID;
            }
        }
		Transaction newTransaction = new Transaction(newID+1, totalPayment,
        		LocalDateTime.now(), booking, listPurchase);
		transactionRepo.insertTransaction(newTransaction);
	}
	
	public void printAllTransactions() {
		bookingTransactionView.printAllTransactions(transactionRepo.getAllTransaction());
	}
}

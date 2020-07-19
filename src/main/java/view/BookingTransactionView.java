package view;

import java.util.List;
import java.util.Scanner;

import model.FoodDrink;
import model.Purchase;
import model.Transaction;

public class BookingTransactionView {
	public int chooseFood(List<FoodDrink> listFood) {
		int i=1;
		Scanner input = new Scanner(System.in);
		System.out.println("Please select the menu");
		System.out.println("-----------------------");
		System.out.println("No" + "\t" + "Food/Drink" + "\t" + "Cost");
		for(FoodDrink fdm : listFood) {
			System.out.println(i + "\t" + fdm.getFdMenuItem() + "\t" + fdm.getItemPrice());
			i++;
		}
		System.out.println("0) Done");
		System.out.print("Option : ");
		int option = input.nextInt();
		return option;
	}
	
	public void wrongOption() {
		System.out.println("There is no menu with that food number");
	}
	
	public int enterQuantity() {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter Quantity : ");
		int option = input.nextInt();
		return option;
	}
	
	public void printAllTransactions(List<Transaction> listTransaction) {
		System.out.println("List of All Transactions");
		for(Transaction transaction : listTransaction) {
			System.out.println("-------------------------------");
			System.out.println("Transaction No : " + transaction.getTransactionNumber());
			System.out.println("Total Payment : " + transaction.getTotalPayment());
			System.out.println("Time of transaction : " + transaction.getTransactionTime());
			System.out.println("Booking Number : " + transaction.getBooking().getBookingNumber());
			for(Purchase purchase : transaction.getPurchases()) {
				System.out.println("   " + "Purchase No : " + purchase.getPurchaseNumber());
				System.out.println("   " + "Food/Drink : " + purchase.getItemPurchased().getFdMenuItem());
				System.out.println("   " + "Quantity : " + purchase.getQuantity());
				System.out.println("   " + "Cost : " + purchase.getItemPurchased().getItemPrice()
						*purchase.getQuantity());
			}
			System.out.println("-------------------------------");
		}
	}
}

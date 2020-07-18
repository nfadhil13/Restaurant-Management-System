package view;

import java.util.Scanner;

public class WelcomeMenuView {
	public int mainMenu() {
		Scanner input = new Scanner(System.in);
		System.out.println("Table Menu");
		System.out.println("---------");
		System.out.println("  1) Add a Table");
		System.out.println("  2) View Table");
		//System.out.println("  3) Delete Table");
		System.out.println("---------");
		System.out.println("Booking Menu");
		System.out.println("---------");
		System.out.println("  4) Add a Booking");
		System.out.println("  5) View Booking");
		System.out.println("  6) Delete Booking");
		System.out.println("---------");
		System.out.println("  7) Add New Food/Drink Order");
		System.out.println("  8) View Food/Drink ordered");
		System.out.println("  9) Delete Food/Drink ordered");
		System.out.println("---------");
		System.out.println("Purchase Menu");
		System.out.println("---------");
		System.out.println("  10) Add a Purchase");
	    System.out.println("  11) View All Purchases");
	    System.out.println("  12) Delete Purchase");
//	    System.out.println("  13) View All Tables & Bookings");
//	    System.out.println("  14) Save to XML");
//	    System.out.println("  15) Reset");
//	    System.out.println(" 16) Check Out!");
		System.out.println("-----------");
		System.out.println("-----------");
		System.out.println("  0) Exit");
		System.out.print("==>> ");
		int option = input.nextInt();
		return option;
	}
	
	public void pressAnyKeyToContinue() {
		Scanner input = new Scanner(System.in);
		// pause the program so that the user can read what we just printed to the
		// terminal window
		System.out.println("\nPress any key to continue...");
		input.nextLine();
		input.nextLine(); // this second read is required - bug in Scanner class; a String read is ignored
							// straight after reading an int.
	}
	
	public void exit() {
		// the user chose option 0, so exit the program
		System.out.println("Exiting... bye");
	}
	
	public void invalidOption(int option) {
		System.out.println("Invalid option entered: " + option);
	}
	
	public int enterBookingId() {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter Booking Id for Purchase: ");
		int bid = input.nextInt();
		return bid;
	}
	
	public void noBookingFound() {
		System.out.println("No Bookings Found!"); //no booking found....
	}
	
	public String chooseItemForPurchase() {
		Scanner input = new Scanner(System.in);
		System.out.print("Choose item for purchase: ");
		String itemPurchased = input.nextLine();
		return itemPurchased;
	}
	
	public int howManyItem() {
		Scanner input = new Scanner(System.in);
		System.out.print("How many item(s): ");
		int quantity= input.nextInt();
		return quantity;
	}
}

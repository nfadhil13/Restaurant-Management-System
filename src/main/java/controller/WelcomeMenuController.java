package controller;

import java.io.Serializable;

import model.Booking;
import model.FoodDrink;
import model.Purchase;
import model.Table;
import view.WelcomeMenuView;


public class WelcomeMenuController implements Serializable {
	public Table headTable=null;
	private int b;
	private int tableNum=0;
    private Booking firstBooking=null;
    private int bookingNum=0;
    private FoodDrink firstFdItem=null;
    private int fdMenuNum=0;
	private Purchase firstPurchase = null;
    private int purchase=0;
    private BookingTableController bookingController;
    private TableController tableController;
    private FoodDrinkController foodDrinkController;
    private WelcomeMenuView welcomeMenuView;
    private BookingPurchaseController bookingPurchaseController;
    private BookingTransactionController bookingTransactionController;


	public WelcomeMenuController() {
		System.out.println("kesini");
		this.bookingController = new BookingTableController();
		this.tableController = new TableController();
		this.foodDrinkController = new FoodDrinkController();
		this.welcomeMenuView = new WelcomeMenuView();
		bookingPurchaseController = new BookingPurchaseController();
		bookingTransactionController = new BookingTransactionController();
	}

	/**
	 * This is the method that controls the loop of the Menu.
	 */
	public void runMenu() {
		int option = welcomeMenuView.mainMenu();
		while (option != 0) {

			switch (option) {
			case 1:
				tableController.addTable();
				break;
			case 2:
				tableController.printTables();
				break;
			/*case 3:
				input.nextLine();
				deleteTable(promptForInt("Enter Table Number to delete"));
				break;*/
			case 4 :
				Booking booking = bookingController.addBooking();
//				int isPurchase = welcomeMenuView.isPurchaseFood();
				if(booking!=null) {
					bookingTransactionController.addTransaction(booking);
				}
				break;
			case 5:
				bookingController.printBookings();
				break;
			case 6:
				bookingController.deleteBooking();
				break;
			case 7:
				foodDrinkController.addFoodDrink();
				break;
			case 8:
				foodDrinkController.printFoodDrink();
				break;
			case 9:
				foodDrinkController.deleteFoodDrink();
				break;
			case 10:
				bookingTransactionController.printAllTransactions();
				break;
//			case 10:
//				bookingPurchaseController.addPurchase();
//				break;
//			case 11:
//				bookingPurchaseController.readAllPurchases();
//				break;
//			case 12:
//				bookingPurchaseController.deletePurchase();
//				break;
//			case 13:
//				viewAllTablesAndBookings();
//				break;
//			case 14:
//				try {
//					save(this);
//				} catch (Exception e) {
//					System.out.println("Error writing to file: " + e);
//				}
//				break;
//			case 15:
//				reset();
//				break;
//			case 16:
//				input.nextLine();
//				checkOut();
//				break;
//			case 17:
//				try {
//					load();
//				} catch (Exception e) {
//					System.out.print("Error reading from file: " + e);
//				}
//				break;


			default:
				welcomeMenuView.invalidOption(option);
				break;
			}

			welcomeMenuView.pressAnyKeyToContinue();

			// display the main menu again
			option = welcomeMenuView.mainMenu();
		}

		welcomeMenuView.exit();
		System.exit(0);
	}

//	//Prompts the user to enter String in order to call the method relevant to delete based on the String entered
//	public String promptForString(String prompt) {
//		System.out.print(prompt+": ");
//		return input.nextLine();
//	}


//
//	/*
//	 * SAVE METHOD FOR THE ENTIRE SYSTEM
//	 */
//
//	public static void save(WelcomeMenuController app) throws Exception {
//
//	}
//
//
//	/*
//	 * SAVE METHOD FOR THE ENTIRE SYSTEM
//	 */
//	@SuppressWarnings("unchecked")
//	public static WelcomeMenuController load() throws Exception { ;
//		return null;
//	}
//


			/*
			 * METHOD TO ADD PURCHASE
			 */
//			public void addPurchase() {
//				//System.out.print("Please Enter your Name: ");
//				int bid = welcomeMenuView.enterBookingId();
//
//				//Find booking to add purchase to
//				Booking thebooking=firstBooking;
//
//
//				if(thebooking==null){
//					welcomeMenuView.noBookingFound();
//					return;
//				}
//				else{
//					while(thebooking.getBookingNumber()!=bid) thebooking=thebooking.next;
//				}
//
//				String itemPurchased = welcomeMenuView.chooseItemForPurchase();
//				int quantity= welcomeMenuView.howManyItem();
//
//				purchase++;
//				Purchase np=new Purchase(purchase,itemPurchased,quantity);
//
//				//head insertion
//				np.next=thebooking.firstPurchase;
//				thebooking.firstPurchase=np;
//			 }


//			/**
//			 * METHOD TO VIEW ADD VIEW PURCHASE
//			 */
//			public void viewAllPurchases() {
//
//				//Purchase pMenu=firstPurchase;
//				Booking thebooking=firstBooking;
//				while(thebooking!=null) {
//
//					Purchase pMenu=thebooking.firstPurchase;
//
//					System.out.println("Booking Details: "+"===================\n " +
//							"\t" + "Booking No.: "+thebooking.bookingNumber +" \n " +
//							"\t" + "Table: "+thebooking.getTableNumberBooked()+" \n " +
//							"\t" + "Customer Name: "+thebooking.getCustomerName());
//
//					while(pMenu!=null){
//								//process Booking here....
//								System.out.println("Purchase Details: "+" \n " +
//								"\t" + "Purchase No.: "+pMenu.getPurchaseNumber() +" \n " +
//								"\t" + "FoodItem being Purchased: "+pMenu.getItemPurchased()+" \n " +
//								"\t" + "Quantity: "+pMenu.getQuantity());
//								pMenu=pMenu.next;
//							}
//					thebooking=thebooking.next;
//				}
//			}

//			/**
//			 * METHOD TO DELETE A PURCHASE
//			 */
//			public void deletePurchases(String itemP, Booking booking) {
////				!!!! *ASK LECTURER IF THE PROBLEM IS THAT IT HAS TO POINT TO AN ID TO DELETE I.E. PROMPT 'ENTER BOOKING ID TO DELETE FOOD ITEM PURCHASED' !!!
//				Purchase temp5=booking.firstPurchase,temp6=null;
//
//				while(temp5!=null && !temp5.itemPurchased.equals(itemP)) {
//					temp6=temp5;
//					temp5 = temp5.next;
//				}
//
//				if(temp5!=null) { //found it
//
//					if(temp6!=null) temp6.next=temp5.next; //not at the head
//					else firstFdItem=firstFdItem.next; //delete the head
//					System.out.println("Item "+itemP+" deleted.");
//				}
//				else {//not found
//					System.out.println("Item "+itemP+" not found.");
//				}
//			}



//			/**
//			 * !!! HERE I CREATE THE METHOD TO LIST ALL TABLES AND ALL BOOKINGS !!!!
//			 */
//			//Method to view Tables added
//			public void viewAllTablesAndBookings() {
//				Table temp=headTable;
//				Booking temp2=firstBooking;
//
//				while(temp!=null && temp2!=null){
//					System.out.print("Table Details: "+" \n " +
//					"\t" + "Table No. "+temp.getTableNumber() +" \n " +
//					"\t" + "No. of Seats "+temp.getNumberOfSeats()+ " \n ");
//					System.out.println("Booking Details:"+" \n " +
//					"\t" + "Booking No.: "+temp2.getbookingNumber() +" \n " +
//					"\t" + "Customer Name: "+temp2.getCustomerName()+" \n " +
//					"\t" + "Number of People Booking: "+temp2.getNumberOfPplBooking()+" \n " +
//					"\t" + "Table Number Booked: "+temp2.getTableNumberBooked()+" \n " +
//					"\t" + "Booking Time: "+temp2.getBookingTime()+" \n " +
//					"\t" + "The Amount of time (in hours) the booking is for: "+temp2.getAmountOfTimeBooking());
//					temp=temp.next;
//					temp2=temp2.next;
//				}
//			}
//


//			/**
//			 * METHOD TO RESET THE SYSTEM
//			 */
//			 public void reset() {
//				  headTable=null;
//				  System.out.println("Reset Successful");
//			 }
}

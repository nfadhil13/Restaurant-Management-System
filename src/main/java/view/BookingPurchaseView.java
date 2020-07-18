package view;

import model.Booking;
import model.Purchase;

import java.util.List;
import java.util.Scanner;

public class BookingPurchaseView {

    public int addPurchaseGetBookingID() {
        Scanner input = new Scanner(System.in);
        System.out.print("Please Enter your BookingId for Purchase: ");
        return  input.nextInt();

    }

    public Purchase addPurchaseChooseItem(){
        Scanner input = new Scanner(System.in);
        System.out.print("Menu Item being purchased: ");
        String itemPurchased = input.nextLine();
        System.out.print("Quantities of Purchase: ");
        int quantity= input.nextInt();
         return new Purchase(itemPurchased, quantity);
    }

    public void printPurchases(List<Booking> bookingList) {
        for(Booking booking : bookingList){
            System.out.println("Booking Details: "+"===================\n " +
                    "\t" + "Booking No.: "+booking.getBookingNumber() +" \n " +
                    "\t" + "Table: "+booking.getTableNumberBooked()+" \n " +
                    "\t" + "Customer Name: "+booking.getCustomerName());

            for(Purchase purchase : booking.getPurchases()){
                //process Booking here....
                System.out.println("Purchase Details: "+" \n " +
                        "\t" + "Purchase No.: "+purchase.getPurchaseNumber() +" \n " +
                        "\t" + "FoodItem being Purchased: "+purchase.getItemPurchased()+" \n " +
                        "\t" + "Quantity: "+purchase.getQuantity());
            }
        }
    }

    public int deletePurchaseGetBookingId(){
        System.out.print("Please Enter your BookingId for deleting Purchase: ");
        return  new Scanner(System.in).nextInt();
    }

    public int deletePurchaseGetPurchaseID(){
        System.out.print("Please Enter your BookingId for deleting Purchase: ");
        return  new Scanner(System.in).nextInt();
    }

    public void printMessage(String message){
        System.out.println(message);
    }
}

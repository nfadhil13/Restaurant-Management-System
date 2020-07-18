package view;

import model.Booking;

import java.util.List;
import java.util.Scanner;

public class BookingView {

    public Booking addBooking() {
        Scanner input = new Scanner(System.in);
        System.out.print("Please Enter your Name: ");
        String customerName = input.nextLine();
        System.out.print("Number of People booking: ");
        int numberOfPplBooking = input.nextInt();
        System.out.print("Table Number being booked: ");
        int tableNumberBooked = input.nextInt();
        System.out.print("Time of Booking: ");
        int bookingTime = input.nextInt();
        System.out.print("The Amount of time (in hours) the booking is for: ");
        int amountOfTimeBooking = input.nextInt();

        return new Booking(customerName, numberOfPplBooking, tableNumberBooked, bookingTime, amountOfTimeBooking);

    }

    public void printBookings(List<Booking> bookingList) {
        for (Booking booking : bookingList) {
            System.out.println("Booking Details: " + " \n " +
                    "\t" + "Booking No.: " + booking.getBookingNumber() + " \n " +
                    "\t" + "Customer Name: " + booking.getCustomerName() + " \n " +
                    "\t" + "Number of People Booking: " + booking.getNumberOfPplBooking() + " \n " +
                    "\t" + "Table Number Booked: " + booking.getTableNumberBooked() + " \n " +
                    "\t" + "Booking Time: " + booking.getBookingTime() + " \n " +
                    "\t" + "The Amount of time (in hours) the booking is for: " + booking.getAmountOfTimeBooking());
        }
    }

    public int deleteBooking(){
        System.out.println("Input booking ID you want to cancel : ");
        return new Scanner(System.in).nextInt();
    }
}

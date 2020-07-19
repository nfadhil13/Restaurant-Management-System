package view;


import app.constant.RestauranConstant;
import model.Booking;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class BookingTableView {

    public Booking addBooking() {
//        Scanner input = new Scanner(System.in);
//        System.out.print("Please Enter your Name: ");
//        String customerName = input.nextLine();
//        System.out.print("Number of People booking: ");
//        int numberOfPplBooking = input.nextInt();
//        System.out.print("Table Number being booked: ");
//        int tableNumberBooked = input.nextInt();
//        System.out.println("Time of Booking: \n" +
//                "1.Today\n" +
//                "2.Tomorrow(D+1)\n" +
//                "3.overmorrow(D+2)\n" +
//                "4.D+3\n" +
//                "(BOOKING IS ONLY AVAILABLE FOR THOESE OPTION)");
//        System.out.print("Choose Your Booking Day :");
//        LocalDateTime bookingTime = LocalDate.now().plusDays(input.nextInt()-1);
//
//        System.out.print("The Amount of time (in hours) the booking is for: ");
//        System.out.println("Amount of Time(in hours) of Booking: \n" +
//                "1.1 Hour\n" +
//                "2.2 Hours\n" +
//                "3.3 Hours\n" +
//                "(BOOKING IS ONLY AVAILABLE FOR MAXIMUM 3 HOURS)");
//        int amountOfTimeBooking = input.nextInt();
//        return new Booking(customerName, numberOfPplBooking, tableNumberBooked, bookingTime, amountOfTimeBooking);
        return  null;
    }

    public int getBookingDayInput(){
        System.out.println("Time of Booking: \n" +
                "1.Tomorrow(D+1)\n" +
                "2.Day after tomorrow(D+2)\n" +
                "3.Three days from now(D+3)\n" +
                "0.cancel \n" +
                "( BOOKING IS ONLY AVAILABLE FOR THESE OPTIONS)");
        System.out.print("\n Choose Your Booking Day :");
        return new Scanner(System.in).nextInt();
    }

    public int getBookingMaxPersonInput(){
        System.out.print("Number of People booking: ");
        return new Scanner(System.in).nextInt();
    }

    public int getBookingHourInput(){
        int no=1;
        System.out.println("No" +"\t" +"TIME");
        for(int i = RestauranConstant.RESTAURANT_START_HOUR ; i<RestauranConstant.RESTAURANT_END_HOUR;i++){
            System.out.println(no + "\t" + i + ".00");
            no ++;
        }
        System.out.println("0.Cancel");
        System.out.println("(ALL BOOKING ARE ONLY FOR ONE HOUR, STARTS FROM BOOKING TIME)");
        System.out.print("Choose Booking Time : ");
        return new Scanner(System.in).nextInt()+RestauranConstant.RESTAURANT_START_HOUR-1;
    }

    public void printErrorMessage(String message){
        System.out.println(message);
    }

    public void printbookings(List<Booking> bookingList) {
        for (Booking booking : bookingList) {
            System.out.println("Booking Details: " + " \n " +
                    "\t" + "Booking No.: " + booking.getBookingNumber() + " \n " +
                    "\t" + "Customer Name: " + booking.getCustomerName() + " \n " +
                    "\t" + "Number of People Booking: " + booking.getNumberOfPplBooking() + " \n " +
                    "\t" + "Table Number Booked: " + booking.getTableBooked().getTableNumber() + " \n " +
                    "\t" + "Booking Time: " + booking.getBookingTime().format(DateTimeFormatter.ofPattern("dd-MMM-yy hh:mm")));
        }
    }

    public int deleteBooking(){
        System.out.println("Input booking ID you want to cancel : ");
        return new Scanner(System.in).nextInt();
    }

    public int chooseAvailableBook(List<Booking> availableBooking) {
        int i = 1;
        System.out.println("Book For " + availableBooking.get(0)
                .getBookingTime().format(DateTimeFormatter.ofPattern("dd-MMM-yy")));
        System.out.println("NO" + "\t" + "TABLE_NUMBER" + "\t" + "TIME" + "\t" + "Maximum Number Of seat");
        for (Booking booking : availableBooking) {
            System.out.println(i + "\t"
                    + booking.getTableBooked().getTableNumber() + "\t" + "\t"
                    + booking.getBookingTime().format(DateTimeFormatter.ofPattern("hh:mm")) + "\t" 
                    + booking.getTableBooked().getNumberOfSeats());
            i++;
        }
        System.out.println("0.cancel");
        System.out.print("Choose Table : ");
        return new Scanner(System.in).nextInt();
    }
    
    public String enterCustomerName() {
    	Scanner input = new Scanner(System.in);
    	System.out.print("Enter the name of the customer : ");
    	return input.nextLine();
    }
}

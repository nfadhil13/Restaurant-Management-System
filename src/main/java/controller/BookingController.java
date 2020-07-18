package controller;

import model.Booking;
import org.aspectj.lang.annotation.Aspect;
import service.repositories.BookingRepo;
import view.BookingView;

public class BookingController {

    private BookingRepo repo;
    private BookingView view;

    public BookingController(){
        repo = BookingRepo.getInstance();
        view = new BookingView();
    }


    public void addBooking(){
        Booking newBooking = view.addBooking();
        int newBookingNumber = 0;
        for(Booking booking : repo.getAllBooking()){
            int temp = booking.getBookingNumber();
            if(temp>newBookingNumber){
                newBookingNumber = temp;
            }
        }
        newBooking.setBookingNumber(newBookingNumber+1);
        repo.insertBooking(newBooking);
    }

    public void printBookings(){
        view.printBookings(repo.getAllBooking());
    }

    public void deleteBooking(){
        repo.deleteBooking(view.deleteBooking());
    }




}

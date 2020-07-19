package service.repositories;

import model.Booking;
import service.dao.BookingDao;

import java.util.ArrayList;
import java.util.List;

public class BookingRepo implements BookingDao {
    private static List<Booking> bookingList = new ArrayList<>();
    private static BookingRepo INSTANCE;

    private BookingRepo() {

    }

    public static BookingRepo getInstance(){
        if(INSTANCE==null){
            INSTANCE = new BookingRepo();
        }
        return INSTANCE;
    }

    @Override
    public void insertBooking(Booking booking) {
        bookingList.add(booking);
    }

    @Override
    public void deleteBooking(Booking booking) {
        bookingList.remove(booking);
    }

    @Override
    public void updateBooking(Booking booking) {
        for(Booking theBooking : bookingList){
            if(theBooking.getBookingNumber() == booking.getBookingNumber()){
                bookingList.remove(theBooking);
                break;
            }
        }
        bookingList.add(booking);
    }

    @Override
    public List<Booking> getAllBooking() {
        return bookingList;
    }

    @Override
    public Booking getBookingById(int id) {
        for(Booking booking : bookingList){
            System.out.println("Booking number :" + booking.getBookingNumber() + "Id : " + id);
            if(booking.getBookingNumber() == id){
                return  booking;
            }
        }
        return null;
    }
}

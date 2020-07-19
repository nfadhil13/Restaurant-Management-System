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
    public void deleteBooking(int id) {
        bookingList.remove(id);
    }

    @Override
    public void updateBooking(int id, Booking booking) {
//        for(Booking tempBooking : bookingList){
//            if(tempBooking.getBookingNumber() == id){
//                bookingList.remove(tempBooking);
//            }
//      }
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

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
        bookingList.add(id,booking);
        bookingList.remove(id+1);
    }

    @Override
    public List<Booking> getAllBooking() {
        return bookingList;
    }

    @Override
    public Booking getBookingById(int id) {
        return bookingList.get(id);
    }
}

package service.dao;

import model.Booking;

import java.util.ArrayList;
import java.util.List;

public interface BookingDao {

    void insertBooking(Booking booking);
    void deleteBooking(Booking booking);
    void updateBooking(Booking booking);
    List<Booking> getAllBooking();
    Booking getBookingById(int id);
}

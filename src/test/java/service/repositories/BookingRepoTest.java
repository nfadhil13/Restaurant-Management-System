package service.repositories;

import model.Booking;
import model.Table;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookingRepoTest {

    BookingRepo bookingRepo;

    Booking booking1,booking2,booking3,booking4,newBook;


    @Before
    public void setup(){
        //tables = Mockito.spy(new ArrayList<Table>());
        bookingRepo = BookingRepo.getInstance();
        booking1 = new Booking();
        booking1.setBookingNumber(1);
        bookingRepo.insertBooking(booking1);
        booking2 = new Booking();
        booking2.setBookingNumber(2);
        bookingRepo.insertBooking(booking2);
        booking3 = new Booking();
        booking3.setBookingNumber(3);
        bookingRepo.insertBooking(booking3);
        booking4= new Booking();
        booking4.setBookingNumber(4);
        bookingRepo.insertBooking(booking4);
        newBook = new Booking();
        newBook.setBookingNumber(5);

    }

    @Test
    public void insertBooking() {
        bookingRepo.insertBooking(newBook);

        assertEquals(bookingRepo.getBookingById(newBook.getBookingNumber()),newBook);
        assertEquals(bookingRepo.getAllBooking().size(),5);

    }

    @Test
    public void deleteBooking() {
        bookingRepo.deleteBooking(newBook);
        assertEquals(bookingRepo.getBookingById(newBook.getBookingNumber()),null);
        assertEquals(bookingRepo.getAllBooking().size(),4);
    }

    @Test
    public void updateBooking() {

        booking1.setNumberOfPplBooking(5);
        assertEquals(booking1.getNumberOfPplBooking(),5);

        booking1.setNumberOfPplBooking(4);
        assertEquals(booking1.getNumberOfPplBooking(),4);


        bookingRepo.updateBooking(booking1);
        assertEquals(bookingRepo.getBookingById(1).getNumberOfPplBooking(),4);
    }

    @Test
    public void getAllBooking() {
        //Error Karena singleton
        assertEquals(bookingRepo.getAllBooking().size(),4);
    }

    @Test
    public void getBookingById() {
        assertEquals(booking1.getBookingNumber(),1);
        assertEquals(bookingRepo.getBookingById(1),booking1);
    }
}
package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Booking {
    private int bookingNumber;
    private String customerName;
    private int numberOfPplBooking;
    private Table tableBooked;
    private LocalDateTime bookingTime;

    public Booking() {
    }

    public Booking(int bookingNumber, String customerName, int numberOfPplBooking, 
    		Table tableNumberBooked, LocalDateTime bookingTime) {
        this.bookingNumber = bookingNumber;
        this.customerName = customerName;
        this.numberOfPplBooking = numberOfPplBooking;
        this.tableBooked = tableNumberBooked;
        this.bookingTime = bookingTime;
    }

    public Booking(String customerName, int numberOfPplBooking, 
    		Table tableNumberBooked, LocalDateTime bookingTime) {
        this.customerName = customerName;
        this.numberOfPplBooking = numberOfPplBooking;
        this.tableBooked = tableNumberBooked;
        this.bookingTime = bookingTime;
    }
    
    public int getBookingNumber() {
        return bookingNumber;
    }

    public void setBookingNumber(int bookingNumber) {
        this.bookingNumber = bookingNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getNumberOfPplBooking() {
        return numberOfPplBooking;
    }

    public void setNumberOfPplBooking(int numberOfPplBooking) {
        this.numberOfPplBooking = numberOfPplBooking;
    }

    public Table getTableBooked() {
        return tableBooked;
    }

    public void setTableBooked(Table tableBooked) {
        this.tableBooked = tableBooked;
    }

    public LocalDateTime getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(LocalDateTime bookingTime) {
        this.bookingTime = bookingTime;
    }
}

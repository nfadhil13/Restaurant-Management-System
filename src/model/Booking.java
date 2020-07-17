package model;

public class Booking {
    private int bookingNumber;
    private String customerName;
    private int numberOfPplBooking;
    private int tableNumberBooked;
    private int bookingTime;
    private int amountOfTimeBooking;

    public Booking(int bookingNumber, String customerName, int numberOfPplBooking, int tableNumberBooked, int bookingTime, int amountOfTimeBooking) {
        this.bookingNumber = bookingNumber;
        this.customerName = customerName;
        this.numberOfPplBooking = numberOfPplBooking;
        this.tableNumberBooked = tableNumberBooked;
        this.bookingTime = bookingTime;
        this.amountOfTimeBooking = amountOfTimeBooking;
    }

    public Booking(String customerName, int numberOfPplBooking, int tableNumberBooked, int bookingTime, int amountOfTimeBooking) {
        this.customerName = customerName;
        this.numberOfPplBooking = numberOfPplBooking;
        this.tableNumberBooked = tableNumberBooked;
        this.bookingTime = bookingTime;
        this.amountOfTimeBooking = amountOfTimeBooking;
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

    public int getTableNumberBooked() {
        return tableNumberBooked;
    }

    public void setTableNumberBooked(int tableNumberBooked) {
        this.tableNumberBooked = tableNumberBooked;
    }

    public int getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(int bookingTime) {
        this.bookingTime = bookingTime;
    }

    public int getAmountOfTimeBooking() {
        return amountOfTimeBooking;
    }

    public void setAmountOfTimeBooking(int amountOfTimeBooking) {
        this.amountOfTimeBooking = amountOfTimeBooking;
    }
}

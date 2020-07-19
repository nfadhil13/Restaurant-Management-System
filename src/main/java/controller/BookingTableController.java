package controller;

import app.constant.RestaurantConstant;
import model.Booking;
import model.Table;
import service.repositories.BookingRepo;
import service.repositories.TableRepo;
import view.BookingTableView;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BookingTableController {

    private BookingRepo bookingRepo;
    private BookingTableView view;
    private TableRepo tableRepo;

    public BookingTableController(){
        bookingRepo = BookingRepo.getInstance();
        view = new BookingTableView();
        tableRepo = TableRepo.getInstance();
    }


    public void addBooking(){
        List<Booking> bookedByDay = new ArrayList<>();
        int choosenDay = view.getBookingDayInput();
        if(choosenDay==0)return;
        LocalDate searchDate = LocalDate.now().plusDays((long)choosenDay);
        int numberOfPeopleBook = view.getBookingMaxPersonInput();
        if(numberOfPeopleBook==0)return;
        for(Booking booking : bookingRepo.getAllBooking()){
            if(booking.getBookingTime().toLocalDate().atStartOfDay().isEqual(searchDate.atStartOfDay())){
                bookedByDay.add(booking);
            }
        }
        List<Booking> availableBooking = new ArrayList<>();
        List<Table> tables =  tableRepo.getAllTable();
        int i = RestaurantConstant.RESTAURANT_START_HOUR;
        for(; i<RestaurantConstant.RESTAURANT_END_HOUR;i++){
            LocalDateTime currentItteratorTime =searchDate.atTime(i,0);
            if(!bookedByDay.isEmpty()){
                for(Booking booking : bookedByDay){
                    if(booking.getBookingTime().isEqual(currentItteratorTime)){
                        for(Table table: tables){
                            if(booking.getTableBooked().getTableNumber() != table.getTableNumber()){
                                Booking tempBooking = new Booking();
                                tempBooking.setBookingTime(currentItteratorTime);
                                tempBooking.setTableBooked(table);
                                availableBooking.add(tempBooking);
                            }
                        }
                        bookedByDay.remove(booking);
                    }else{
                        for(Table table : tables){
                            if(table.getNumberOfSeats()>= numberOfPeopleBook){
                                Booking tempBooking = new Booking();
                                tempBooking.setBookingTime(currentItteratorTime);
                                tempBooking.setTableBooked(table);
                                availableBooking.add(tempBooking);
                            }
                        }
                    }
                }
            }else{
                for(Table table : tables){
                    if(table.getNumberOfSeats()>= numberOfPeopleBook){
                        Booking tempBooking = new Booking();
                        tempBooking.setBookingTime(currentItteratorTime);
                        tempBooking.setTableBooked(table);
                        availableBooking.add(tempBooking);
                    }
                }
            }
        }
        if(!availableBooking.isEmpty()){
            int choosenBooking = view.chooseAvailableBook(availableBooking);
            if(choosenBooking==0){
                return;
            }else{
                bookingRepo.insertBooking(availableBooking.get(choosenBooking));
            }
        }else{
            view.printErrorMessage("NO BOOKING WITH SUCH CONDITION");
        }




    }

    public void printBookings(){
        view.printbookings(bookingRepo.getAllBooking());
    }

    public void deleteBooking(){
        bookingRepo.deleteBooking(view.deleteBooking());
    }





}

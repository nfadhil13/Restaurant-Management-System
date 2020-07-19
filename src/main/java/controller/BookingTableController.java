package controller;

import app.constant.RestauranConstant;
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
        //Membuat List Untuk pembanding booking yang sudah terisi
        List<Booking> bookedByDay = new ArrayList<>();

        //Membuat List untuk menampung booking yang kosong
        List<Booking> availableBookingByDay = new ArrayList<>();

        //Mendapatkan input hari dari view
        int choosenDay = view.getBookingDayInput();

        //Bila input 0 berarti cancel
        if(choosenDay!=0){

            //Melakukan Filter Berdasarkan hari
            LocalDate searchDate = LocalDate.now().plusDays((long)choosenDay);
            bookedByDay = filterBookingByDay(searchDate);

            //Mendapatkan input jumlah kuris yang ingin di booking
            int numberOfPeopleBook = view.getBookingMaxPersonInput();

            //Bila pilihan 0 Berarti Cancle
            if(numberOfPeopleBook!=0){

                //Mendapatkan List Booking yang memungkinkan dalam hari yang telah dipilih
                availableBookingByDay = getAvailableBookInADay(bookedByDay,searchDate,numberOfPeopleBook);

                //Bila null berarti kondisi tidak memenuhi
                if(!availableBookingByDay.isEmpty()){

                    //Mendapatkan input jam yang diinginkan
                    int getBookingHour = view.getBookingHourInput();
                    if(getBookingHour!=0){
                        //Mendapatkan booking yang memungkinkan berdasarkan jam
                        List<Booking> availableBookingByHour =
                                filerBookingByHour(availableBookingByDay,getBookingHour);

                        //Bila ada booking berdasarkan jam maka tampilkan
                        if(!availableBookingByHour.isEmpty()){
                            int choosenBooking = view.chooseAvailableBook(availableBookingByHour);
                            if(choosenBooking!=0)
                                bookingRepo.insertBooking(availableBookingByDay.get(choosenBooking));
                        }else{
                            //Bila tidak ada maka tampilkan alternatif
                            view.printErrorMessage("NO AVAILABLE BOOKING WITH SUCH CONDITION");
                            view.printErrorMessage("THIS IS ONLY AVAILBLE BOOKING IN THIS DAY");
                            int choosenBooking = view.chooseAvailableBook(availableBookingByDay);
                            if(choosenBooking!=0)
                                bookingRepo.insertBooking(availableBookingByDay.get(choosenBooking));
                        }

                    }
                }else{
                    view.printErrorMessage("NO AVAILABLE BOOKING WITH SUCH CONDITION");
                }
            }
        }












    }

    private List<Booking> filerBookingByHour(List<Booking>bookings ,int hour){
        List<Booking> bookedByDay = new ArrayList<>();
        for (Booking booking : bookings) {
            if (booking.getBookingTime().getHour() == hour) {
                bookedByDay.add(booking);
            }
        }
        return bookedByDay;
    }

    private List<Booking> getAvailableBookInADay(List<Booking> bookedByDay , LocalDate searchDate,
                        int numberOfPeopleBook){
        List<Booking> availableBooking = new ArrayList<>();
        List<Table> tables =  tableRepo.getAllTable();
        int i = RestauranConstant.RESTAURANT_START_HOUR;
        for(; i<RestauranConstant.RESTAURANT_END_HOUR;i++){
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
        return availableBooking;
    }


    private List<Booking> filterBookingByDay(LocalDate searchDate){
        List<Booking> bookedByDay = new ArrayList<>();
        for(Booking booking : bookingRepo.getAllBooking()){
            if(booking.getBookingTime().toLocalDate().atStartOfDay().isEqual(searchDate.atStartOfDay())){
                bookedByDay.add(booking);
            }
        }
        return bookedByDay;
    }


    public void printBookings(){
        view.printbookings(bookingRepo.getAllBooking());
    }

    public void deleteBooking(){
        bookingRepo.deleteBooking(view.deleteBooking());
    }





}

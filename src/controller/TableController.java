package controller;

import model.Booking;
import model.Table;
import service.repositories.TableRepo;
import view.BookingView;
import view.TableView;

public class TableController {

    private TableRepo repo;
    private TableView view;

    public TableController(){
        this.view = new TableView();
        this.repo = TableRepo.getInstance();
    }
    public void addTable(){
        int tableNumber = repo.getAllTable().size();
        repo.insertTable(new Table(tableNumber,view.addTable()));
    }

    public void printTables(){
        view.printTable(repo.getAllTable());
    }



}

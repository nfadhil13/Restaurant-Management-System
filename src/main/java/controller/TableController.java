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
        int tableNumber = 0;
        for(Table table : repo.getAllTable()){
            int temp = table.getTableNumber();
            if(temp>tableNumber){
                tableNumber = temp;
            }
        }
        repo.insertTable(new Table(tableNumber+1,view.addTable()));
    }

    public void printTables(){
        view.printTable(repo.getAllTable());
    }



}

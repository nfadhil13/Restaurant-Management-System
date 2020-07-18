package view;

import model.Table;

import java.util.List;
import java.util.Observable;
import java.util.Scanner;

public class TableView {



    public int addTable(){
        Scanner input = new Scanner(System.in);
        System.out.print("Please Enter the number of seats: ");
        return input.nextInt();
    }

    public void printTable(List<Table> tables){
        System.out.print("Table Details"+" \n ");
        for(Table table : tables){
            System.out.print("\t"+"Table No. "+table.getTableNumber()+", Seats "+table.getNumberOfSeats()+ " \n ");
        }
    }


}

package service.repositories;

import model.Table;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

public class TableRepoTest {


    TableRepo tableRepo;

    Table table1,table2,table3,table4,newTable;


    @Before
    public void setup(){
        //tables = Mockito.spy(new ArrayList<Table>());
        tableRepo = TableRepo.getInstance();
        table1 = new Table(1);
        tableRepo.insertTable(table1);
        table2 = new Table(2);
        tableRepo.insertTable(table2);
        table3 = new Table(3);
        tableRepo.insertTable(table3);
        table4 = new Table(4);
        tableRepo.insertTable(table4);
        newTable = new Table(5);
    }


    @Test
    public void insertTable() {

        tableRepo.insertTable(newTable);
        //When
        assertEquals(newTable,tableRepo.getTableById(newTable.getTableNumber()));


    }

    @Test
    public void deleteTable() {
        int oldSize = tableRepo.getAllTable().size();
        tableRepo.deleteTable(table1);
        assertEquals(tableRepo.getAllTable().size(),oldSize-1);
    }

    @Test
    public void updateTable() {

        table1.setNumberOfSeats(10);
        assertEquals(table1.getNumberOfSeats(),10);

        table1.setNumberOfSeats(12);
        assertEquals(table1.getNumberOfSeats(),12);


    }

    @Test
    public void getAllTable() {
        int oldSize = tableRepo.getAllTable().size();
        tableRepo.getAllTable();
        assertEquals(tableRepo.getAllTable().size(),oldSize-1);
    }

    @Test
    public void getTableById() {
        assertEquals(table1.getTableNumber(),1);
        assertEquals(tableRepo.getTableById(1),table1);
    }
}
package service.dao;


import model.Table;

import java.util.List;

public interface TableDao {
    void insertTable(Table table);
    void deleteTable(int id);
    void updateTable(int id , Table table);
    List<Table> getAllTable();
    Table getTableById(int id);
}

package service.dao;


import model.Table;

import java.util.List;

public interface TableDao {
    void insertTable(Table table);
    void deleteTable(Table table);
    void updateTable(Table table);
    List<Table> getAllTable();
    Table getTableById(int id);
}

package service.repositories;

import model.Table;
import service.dao.TableDao;

import java.util.ArrayList;
import java.util.List;

public class TableRepo implements TableDao {

    private static List<Table> tables = new ArrayList<>();
    private static TableRepo INSTANCE;

//    TableRepo.successCallBack callback;
//
//    public TableRepo(TableRepo.successCallBack callBack){
//        this.callback = callBack;
//    }

    public static TableRepo getInstance(){
        if(INSTANCE == null){
            INSTANCE = new TableRepo();
        }
        return  INSTANCE;
    }

    private TableRepo() {
    }

    @Override
    public void insertTable(Table table) {
        tables.add(table);
//        callback.addSuccess(table);
    }

    @Override
    public void deleteTable(Table table) {
        tables.remove(table);
    }

    @Override
    public void updateTable(Table table) {
        for(Table tempTable : tables){
            if(table.getTableNumber() == table.getTableNumber()){
                tables.remove(table);
                break;
            }
        }
        tables.add(table);

    }

    @Override
    public List<Table> getAllTable() {
        return tables;
    }

    @Override
    public Table getTableById(int id) {
        for(Table table : tables){
            if(table.getTableNumber() == id){
                return  table;
            }
        }
        return null;
    }



//    public interface successCallBack{
//        void addSuccess(Table table);
//    }
}

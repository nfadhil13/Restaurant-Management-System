package service.repositories;

import model.Table;
import service.dao.TableDao;

import javax.security.auth.callback.Callback;
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

    public TableRepo() {
    }

    @Override
    public void insertTable(Table table) {
        tables.add(table);
//        callback.addSuccess(table);
    }

    @Override
    public void deleteTable(int id) {
        tables.remove(id);
    }

    @Override
    public void updateTable(int id, Table table) {
        tables.add(id,table);
        tables.remove(id+1);
    }

    @Override
    public List<Table> getAllTable() {
        return tables;
    }

    @Override
    public Table getTableById(int id) {
        return tables.get(id);
    }



//    public interface successCallBack{
//        void addSuccess(Table table);
//    }
}

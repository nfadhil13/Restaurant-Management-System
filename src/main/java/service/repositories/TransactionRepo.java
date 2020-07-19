package service.repositories;

import java.util.ArrayList;
import java.util.List;

import model.FoodDrink;
import model.Transaction;
import service.dao.TransactionDao;

public class TransactionRepo implements TransactionDao{
	private static List<Transaction> transactionList = new ArrayList<>();
    private static TransactionRepo INSTANCE;
    
    public TransactionRepo() {
    	
    }
    
    public static TransactionRepo getInstance(){
        if(INSTANCE==null){
            INSTANCE = new TransactionRepo();
        }
        return INSTANCE;
    }
    
	@Override
	public void insertTransaction(Transaction transaction) {
		transactionList.add(transaction);
	}
	@Override
	public void deleteTransaction(int id) {
		transactionList.remove(id);
	}
	@Override
	public void updateTransaction(Transaction transaction) {
		int i=0;
		for(Transaction tempTransaction : transactionList){
            if(tempTransaction.getTransactionNumber() == transaction.getTransactionNumber()){
                transactionList.remove(i);
                transactionList.add(transaction);
            }
            i++;
        }
	}
	@Override
	public List<Transaction> getAllTransaction() {
		return transactionList;
	}
	@Override
	public Transaction getTransactionById(int id) {
		for(Transaction transaction : transactionList){
            if(transaction.getTransactionNumber() == id){
                return transaction;
            }
        }
		return null;
	}
}

package service.dao;

import java.util.List;

import model.Transaction;

public interface TransactionDao {
	void insertTransaction(Transaction transaction);
	void deleteTransaction(int id);
	void updateTransaction(Transaction transaction);
	List<Transaction> getAllTransaction();
	Transaction getTransactionById(int id);
}

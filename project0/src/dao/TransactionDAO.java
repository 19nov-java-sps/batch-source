package dao;

import java.sql.*;
import java.util.List;

import model.Transaction;

public interface TransactionDAO {
	public List<Transaction> getAllTransactions();
	public Transaction getTransactionById(int id);
	public Transaction getTransactionById(Connection connection, int id); 
	public int createTransaction(Transaction transaction);
	public int updateTransaction(Transaction transaction);
	public int deleteTransaction(Transaction transaction);
	int deleteTransactionById(int id);
}

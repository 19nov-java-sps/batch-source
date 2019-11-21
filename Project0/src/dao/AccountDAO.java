package dao;

import java.sql.*;
import java.util.List;

import model.Account;
import model.User;

public interface AccountDAO {
	public List<Account> getAllAccounts();
	public Account getAccountById(int id);
	public Account getAccountById(Connection connection, int id);
	public int createAccount(Account account, User user);
	public int updateAccount(Account account);
	public int deleteAccount(Account account);
	int deleteAccountById(int id);
	int getNextAccountId();
}

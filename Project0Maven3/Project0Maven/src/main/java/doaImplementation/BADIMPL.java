package doaImplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.BAD;
import model.AccountOwner;
import model.BankAccount;
import util.ConnectionUtil;

public class BADIMPL implements BAD 
{

	@Override
	public List<BankAccount> listBankAccount() {
		String sql = "Select * from BankAccount";
		List<BankAccount> listBankAccount = new ArrayList<>();
		
		try (Connection connection = ConnectionUtil.getConnection();
				Statement s = connection.createStatement();
				ResultSet rs = s.executeQuery(sql))
				{
					while (rs.next()) 
					{
						int idAccount = rs.getInt("idAccount");
						String userName = rs.getString("userName");
						int accountNumber = rs.getInt("accountNumber");
						int accountBalance = rs.getInt("accountBalance");
						
						BankAccount bankAccount1 = new BankAccount(idAccount, userName, accountNumber, accountBalance);
						listBankAccount.add(bankAccount1);
					}
				}
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		return listBankAccount;
	}

	@Override
	public int deposit(BankAccount accountX , int depositAmount) {
		String sql = " update BankAccount set accountBalance = ? where userName=?";
		int newBalance = 0;
		
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql))
				{
					ps.setInt(1, accountX.getAccountBalance() + depositAmount);
					ps.setString(2, accountX.getUserName());
					newBalance = ps.executeUpdate();
					System.out.println("your new balance is: $" + accountX.getAccountBalance() );
				}
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		return newBalance;
		
	}

	@Override
	public int withdraw(BankAccount accountX, int withdrawAmount) {
		String sql = " update BankAccount set accountBalance = ? where userName=?";
		int newBalance = 0;
		
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql))
				{
					ps.setInt(1, accountX.getAccountBalance() - withdrawAmount);
					ps.setString(2, accountX.getUserName());
					newBalance = ps.executeUpdate();
					System.out.println("your new balance is: $" + accountX.getAccountBalance() );

				}
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		return newBalance;
	}

	@Override
	public BankAccount checkBalance(String userName) {
		String sql = "select * from BankAccount where accountBalance = ?";
		BankAccount balanceAvaliable = null;
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql))
				{
					ps.setString(1, userName);
					ResultSet rs = ps.executeQuery();
					while (rs.next()) 
					{
						int idAccount = rs.getInt("idAccount");
						String userName = rs.getString("userName");
						int accountNumber = rs.getInt("accountNumber");
						int accountBalance = rs.getInt("accountBalance");
						
						balanceAvaliable = new BankAccount(idAccount, userName, accountNumber, accountBalance);
					}
				}
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		return balanceAvaliable;
		
		
	}

	@Override
	public int createBankAccount(BankAccount bankAccount) {
		String sql = "insert into BankAccount (idAccount, userName, accountNumber, accountBalance) values(?,?,?,?)";
		int bankAccountCreated = 0;
		
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql))
				{
						ps.setInt(1, bankAccount.getIdAccount());
						ps.setString(2, bankAccount.getUserName());
						ps.setInt(3, bankAccount.getAccountNumber());
						ps.setInt(4, bankAccount.getAccountBalance());
						
						bankAccountCreated = ps.executeUpdate();
				}
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		return bankAccountCreated;
	}
}

package dao;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Account;
import model.User;

import util.ConnectionUtil;

public class AccountDAOImplementation implements AccountDAO {

  @Override
  public List<Account> getAllAccounts() {
    List<Account> accountList = new ArrayList<>();
    String sql = "SELECT * FROM BANKACCOUNT";

    try (Connection con = ConnectionUtil.getConnection();
         Statement s    = con.createStatement();
         ResultSet rs   = s.executeQuery(sql);) {
      Account a = new Account();
      while (rs.next()) {
        int id = rs.getInt("bankaccount_ID");
        BigDecimal balance = rs.getBigDecimal("bankaccount_balance");
        String type = rs.getString("checking_or_savings");
        String jointOrSingle = rs.getString("single_or_joint");
        a.setId(id);
        a.setBalance(balance);
        a.setType(type);
        a.setJoint(jointOrSingle.equals("joint"));
        accountList.add(a);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (IOException e) {

      e.printStackTrace();
    }

    return accountList;
  }

  @Override
  public int getNextAccountId() {
    int accountId = -1;

    if (getAllAccounts().size() == 0) {
      return 0;
    }

    String sql = "select max(bankaccount_id) as max_acct_id from bankaccount";
    try (Connection con = ConnectionUtil.getConnection();
    Statement s = con.createStatement();
    ResultSet rs = s.executeQuery(sql);) {
      if (rs.next()) {
        accountId = rs.getInt("max_acct_id");
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return accountId + 1;
  }

  @Override
  public Account getAccountById(int id) {
    Account a = null;
    String sql = "select * from bankaccount where bankaccount_ID = ?";

    ResultSet rs = null;
    try (Connection con       = ConnectionUtil.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {
      ps.setInt(1, id);
      rs = ps.executeQuery();

      while (rs.next()) {
        int accountId = rs.getInt("bankaccount_ID");
        BigDecimal balance = rs.getBigDecimal("bankaccount_balance");
        String type = rs.getString("checking_or_savings");
        boolean isJoint = rs.getString("single_or_joint").equals("joint");

        a = new Account(accountId, balance, type, isJoint);
      }

    } catch (SQLException e) {

      e.printStackTrace();
    } catch (IOException e) {

      e.printStackTrace();
    }
    return a;
  }

  @Override
  public Account getAccountById(Connection con, int id) {
    Account a = null;
    String sql = "select * from bankaccount where bankaccount_ID = ?";

    ResultSet rs = null;
    try (PreparedStatement ps = con.prepareStatement(sql)) {
      ps.setInt(1, id);
      rs = ps.executeQuery();

      while (rs.next()) {
        int accountId = rs.getInt("bankaccount_ID");
        BigDecimal balance = rs.getBigDecimal("bankaccount_balance");
        String type = rs.getString("checking_or_savings");
        boolean isJoint = rs.getString("single_or_joint").equals("joint");

        a = new Account(accountId, balance, type, isJoint);
      }

    } catch (SQLException e) {

      e.printStackTrace();
    }
    return a;
  }

  @Override
  public int createAccount(Account account, User user) {
    int accountsCreated = 0;
    String sql = "insert into bankaccount (bankaccount_id, bankaccount_balance, checking_or_savings, single_or_joint) values (?, ?, ?, ?)";
    try (Connection con = ConnectionUtil.getConnection();
    PreparedStatement ps = con.prepareStatement(sql); ) {
      ps.setInt(1, getNextAccountId());
      ps.setBigDecimal(2, account.getBalance());
      ps.setString(3, account.getType());
      String isJoint = account.isJoint() ? "joint" : "single";
      ps.setString(4, isJoint);
      ps.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

    String sql2 = "insert into bankuser_bankaccount (bank_username, bankaccount_id) values (?, ?)";
    try (Connection con = ConnectionUtil.getConnection();
    PreparedStatement ps = con.prepareStatement(sql2); ) {
      ps.setInt(1, account.getId());
      ps.setString(2, user.getUsername());
      ps.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return accountsCreated;
  }

  @Override
  public int updateAccount(Account account) {
    int usersUpdated = 0;
    String sql = "update bankaccount "
    + "set bankaccount_id = ?, "
    + "bankaccount_balance = ?, "
    + "checking_or_savings = ?, "
    + "single_or_joint = ? ";

    try (Connection con = ConnectionUtil.getConnection();
    PreparedStatement ps = con.prepareStatement(sql);) {
      con.setAutoCommit(false);
      ps.setInt(1, account.getId());
      ps.setBigDecimal(2, account.getBalance());
      ps.setString(3, account.getType());
      String isJoint = account.isJoint() ? "joint" : "single";
      ps.setString(4, isJoint);

      usersUpdated = ps.executeUpdate();
      con.commit();
    } catch (SQLException e) {

      e.printStackTrace();
    } catch (IOException e) {

      e.printStackTrace();
    }
    return usersUpdated;
  }

  @Override
  public int deleteAccount(Account account) {
    int rowsDeleted = 0;
    String sql = "delete from bankaccount where bankaccount_ID = ?";
    try (Connection con = ConnectionUtil.getConnection();
    PreparedStatement ps = con.prepareStatement(sql); ) {
      ps.setInt(1, account.getId());
      ps.executeUpdate();
    } catch (SQLException e) {

      e.printStackTrace();
    } catch (IOException e) {

      e.printStackTrace();
    }
    return rowsDeleted;
  }

  @Override
  public int deleteAccountById(int id) {
    int rowsDeleted = 0;
    String sql = "delete from bankaccount where bankaccount_ID = ?";
    try (Connection con = ConnectionUtil.getConnection();
    PreparedStatement ps = con.prepareStatement(sql); ) {
      ps.setInt(1, id);
      ps.executeUpdate();
    } catch (SQLException e) {

      e.printStackTrace();
    } catch (IOException e) {

      e.printStackTrace();
    }
    return rowsDeleted;
  }

}

//package dao;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
//import model.AccountOwner;
//import util.ConnectionUtil;
//
//public class AccountOwnerDao  extends AccountOwnerDaoAbstrat<AccountOwner> {
//
////	private static final  String insert = "insert into AccountOwner (id_Accountowner,firstName,lastName,phoneNumber) "
////			+ "values(?, ?, ?, ?)";
//	
//	@Override
//	public AccountOwner createAccountOwner (AccountOwner owner) {
//			String sql = "insert into AccountOwner (idAccountOwner,userName,userEmail,phoneNumber) values (?,?,?, ?)";
//			int AccountOwnerCreated = 0;
//			
//			try(Connection c = ConnectionUtil.getConnection();
//				PreparedStatement ps = c.prepareStatement(sql)){
//				ps.setInt(1, owner.getIdAccountOwner());
//				ps.setString(2, owner.getUserName());
//				ps.setString(3, owner.getUserEmail());
//				ps.setInt(4, owner.getPhoneNumber());
//				ps.execute();
//				return null;
//				
////				AccountOwnerCreated = ps.executeUpdate();
//				
//			} catch (SQLException e) {
//				e.printStackTrace();
////				throw new RuntimeException(e);
//				}
//			return owner;
//			
////			return AccountOwnerCreated ;
////			return AccountOwnerCreated;
//		}
//
////	@Override
////	public int getIdAccountOwner() {
////		// TODO Auto-generated method stub
////		return 0;
////	}
////	private String getFirstName() {
////		// TODO Auto-generated method stub
////		return null;
////	}
////	private String getLasstName() {
////		// TODO Auto-generated method stub
////		return null;
////	}
//
////	private Object getPhoneNumber() {
////		// TODO Auto-generated method stub
////		return null;
////	}
//
////	private Object getId_Accountowner() {
////		// TODO Auto-generated method stub
////		return null;
////	}
//
////	@Override
////	public void createAccountOwner() {
////		String sql = "insert into AccountOwnert (id_Accountowner,firstName,lastName,phoneNumber) values (?,?,?, ?)";
//////		int AccountOwnerCreated = 0;
////		
////		try(Connection c = ConnectionUtil.getConnection();
////			PreparedStatement ps = c.prepareStatement(sql)){
////			ps.setInt(1, (int) getId_Accountowner());
////			ps.setString(2, getFirstName());
////			ps.setString(3, getFirstName());
////			ps.setInt(4, (int) getPhoneNumber());
////			
//			
////			AccountOwnerCreated = ps.executeUpdate();
//			
////		} catch (SQLException e) {
////			e.printStackTrace();
////		}
////		
////		
////		return;
////	}
////	}
//
//}

package driver;


import interaction.Program;
import util.ConnectionUtil;

public class Driver 
{
	
	/*
	 * Creating a new Maven Project:
	 * 1. Go to the File tab (or Right Click in the Package Explorer) and 
	 * 		select "New" -> "Maven Project"
	 * 2. Within the setup wizard, check the "Create a Simple Project (no 
	 * 		archetype selection)" and click "Next"
	 * 3. Provide an identifier for the "GroupId" and "ArtifactId" 
	 * 		such as "com.revature" and "JDBCDemo" and click "Finish"
	 * 
	 * --- configure your project object model ---
	 * 4. Update your Maven Project - Right click on the project folder in 
	 * 		the "Package Explorer" -> "Maven" -> "Update Project"
	 */
	
	public static void main(String[] args)

	{
		Program program = new Program();
		program.start();
		

		//testing connection:
//		try 
//			{
//				String driverName = ConnectionUtil.getConnection().getMetaData().getDriverName();
//				System.out.println(driverName);
//				System.out.println("successfull connected");	
//
//				AccountOwnerDao owner = new AccountOwnerDao();
//				AccountOwner owner1 = new AccountOwner();
//				owner1.setIdAccountOwner(5);
//				owner1.setUserName("bilal");
//				owner1.setUserEmail("sekou@gmail.com");
//				owner1.setPhoneNumber(646925);
//				owner.createAccountOwner(owner1);
//				System.out.println("AccountOwner successfull created");
//			} 
//		catch (SQLException e) 
//			{
//				e.printStackTrace();
//			}		
//		try 
//		{
//			String driverName = ConnectionUtil.getConnection().getMetaData().getDriverName();
//			System.out.println(driverName);
//			System.out.println("successfull connected");	
//			
//			//idAccount,userName,accountNumber,accountBalance
//			BankAccountDao newaccount = new BankAccountDao();
//			BankAccount account1 = new BankAccount();
//			account1.setIdAccount(1);
//			account1.setUserName("Sekou");
//			account1.setAccountNumber(1);
//			account1.setAccountBalance(200);
//			newaccount.createBankAccount(account1);
//			System.out.println("account successfull created");
//		} 
//	catch (SQLException e) 
//		{
//			e.printStackTrace();
//		}	
	}
}
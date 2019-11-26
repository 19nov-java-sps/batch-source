//package interaction;
//
//public class Trash {
//
//	package interaction;
//
//	import java.util.Scanner;
//
//	public class UserInput 
//
//	{
//		static private String userName  = "Sekou";
//		static private String password = "Revature";
//		
//		
//		static Scanner scanner = new Scanner(System.in);
//		//******	get username and password
//		public static void main(String[] args)
//		{
//			System.out.println("Please enter your username: ");
//			String userName1 = scanner.nextLine();
//			if (userName == userName1 )
//			{
//				System.out.println("Please enter your password: ");
//				String password1 = scanner.nextLine();
//				if (password == password1)
//				{
//					System.out.println("welcom to your account");
//					
//					//if userName and password are correct 
//					System.out.println("what would you like to do ?");
//					System.out.println("for deposit enter 1: ");
//					System.out.println("for withdraw enter 2: ");
//					System.out.println("for check balance enter 3: ")
//					int choice = scanner.nextInt();
//					
//					int operation = choice;
//					switch (operation) {
//					  case 1:
//					    System.out.println("You would like to make a deposit.");
//					    int depositAmount = scanner.nextInt();
//					    if (depositAmount <= 0) 
//							{
//								System.out.println("sorry " +userName+ " you can not deposit negative or zero amount");
//								System.out.println();
//							}
//					    else 
//							{
//								accountBalance = accountBalance + depositAmount;
//								System.out.println(userName + " you add $" + depositAmount + " to your account: " + accountNumber );
//								System.out.println(userName +  " your account balance amount is: $" + accountBalance);
//								System.out.println();
//							}
//					    break;
//					  case 2:
//					    System.out.println("You would like to withdraw.");
//					    int withdrawAmount = scanner.nextInt();
//					    if ( withdrawAmount > accountBalance) 
//							{
//								System.out.println("sorry "+ userName +" you can not withdraw more than your balance");
//								System.out.println(userName + " your balance amount is: " + accountBalance);
//								System.out.println();
//							}
//						else 
//							{
//								accountBalance = accountBalance - withdrawAmount ;
//								System.out.println(userName + " your withdraw amount is: $" + withdrawAmount);
//								System.out.println(userName() + " your account balance amount is: $" + accountBalance);
//								System.out.println();
//							}
//					    break;
//					  case 3:
//						    {System.out.println( " your account balance amount is: $" + accountBalance);}
//						    break;
//					  default:
//					    System.out.println("sorry you should enter 1, 2 or 3");
//	}}}}}
//		
//}

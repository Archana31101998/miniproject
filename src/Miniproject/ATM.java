package Miniproject;
import java.util.Scanner;
import com.mysql.jdbc.Statement;
import java.sql.*;
public class ATM {
	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/karaikal","root","Archana@1998");
			Statement ss=(Statement) con.createStatement();
			
			Scanner sc=new Scanner(System.in);
			System.out.println("*************Welcome to SBI ATM****************");
			System.out.println("Enter your four digit ATM Pin number:");
			int pin=sc.nextInt();
			ResultSet rs=ss.executeQuery("select * from atm.list where acc_no="+pin);
			String name=null;
			int count=0;
			int balance = 0;
			while(rs.next()) {
				name=rs.getString(3);
				balance=rs.getInt(4);
				count++;
			}
			
			int choice;
			int amount=0;
			int take_amount=0;
		
		
			
			if(count>0) {
				System.out.println("Hello " +name);
				while(true) {
					System.out.println("");
					System.out.println("Press 1 to Check Balance");
					System.out.println("Press 2 to Deposit money");
					System.out.println("Press 3 to Withdraw Money");
					System.out.println("Press 4 to Print the Receipt");
					System.out.println("Press 5 to Exit");
					
					System.out.println();
					System.out.println("Enter the choice: ");
					choice=sc.nextInt();
					switch(choice)
					{
					case 1:
						System.out.println("Your balance is: "+balance);
						break;
					case 2:
					    System.out.println("Enter the Deposit Amount: ");
					    amount=sc.nextInt();
					    balance=balance+amount;
				//	    int bal=ss.executeUpdate("UPDATE list SET balance=" +balance+ "WHERE acc_no="+pin);
					    int bal=ss.executeUpdate("UPDATE list SET balance="+ balance +"WHERE acc_no="+pin );
					    System.out.println("Successfully deposited and your current balance"+balance);
					    break;
					case 3:
						System.out.println("Enter the Withdraw Amount: ");
						take_amount=sc.nextInt();
						if(take_amount>balance) {
							System.out.println("Your balance is insufficient");
						}else {
							
					    balance=balance-take_amount;
					    int sub=ss.executeUpdate("UPDATE atm.list SET balance="+balance+"where acc_no="+pin);
					    System.out.println("successfully deposited and your current balance"+balance);
						}
						break;
					case 4:
						System.out.println("*****Thanks for coming*****");
						System.out.println("Your Current Balance is: "+balance);
						System.out.println("Amount Added:"+amount);
						System.out.println("Amount Taken:"+take_amount);
					    break;
					}
					if(choice==5) {
						break;
					}
				}
				
			}
			else {
				System.out.println("You Entered the Wrong Pin");
			}
		}
catch(Exception e) {
	System.out.println(e);
}
	}

		
	}



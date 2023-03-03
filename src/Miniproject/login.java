package Miniproject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

import com.mysql.jdbc.Statement;

public class login {
	
	public static void main(String[] args) {
	              Scanner ip=new Scanner(System.in);System.out.println();
	        try 
	        {
		    Class.forName("com.mysql.jdbc.Driver");
		    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root","Archana@1998");
		    Statement ss=(Statement) con.createStatement();
			System.out.println("enter the four digit pin number");
			String pin=ip.next();
			String SQL="Select *from atm.login where pin='"+ pin + "'";
			ResultSet rs=ss.executeQuery(SQL);
			      if(rs.next())
			          System.out.println("********WELCOME you are logged in********");
				 else 
     				    System.out.println("Invalid Username!");		    
					}
	         catch (Exception se) {
		          System.out.println(se);
	    }
}
}



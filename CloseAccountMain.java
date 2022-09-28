package com.infinite.project;

import java.sql.SQLException;
import java.util.Scanner;

public class CloseAccountMain {
  public static void main(String[] args) {
	BankDAO dao=new BankDAO();
	Bank bank=new Bank();
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter Account number");
	int accountNo=sc.nextInt();
	try {
		System.out.println(dao.closeAccount(accountNo));
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	  
}
}

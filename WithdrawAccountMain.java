package com.infinite.project;

import java.sql.SQLException;
import java.util.Scanner;

public class WithdrawAccountMain {
   public static void main(String[] args) {
	BankDAO dao=new BankDAO();
	int accountNo;
	double withdrawAmount;
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter Account Number");
	accountNo=sc.nextInt();
	System.out.println("Enter Withdraw Amount");
	withdrawAmount=sc.nextDouble();
	try {
		System.out.println(dao.withdrawAccount(accountNo, withdrawAmount));
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}

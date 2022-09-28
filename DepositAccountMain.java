package com.infinite.project;

import java.sql.SQLException;
import java.util.Scanner;

public class DepositAccountMain {
    public static void main(String[] args) {
		int accountNo;
		double depositAmount;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Accounr number");
		accountNo=sc.nextInt();
		System.out.println("Enter Deposite Amount");
		depositAmount=sc.nextDouble();
		BankDAO dao=new BankDAO();
		try {
			System.out.println(dao.depositeAccount(accountNo, depositAmount));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

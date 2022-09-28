package com.infinite.project;

import java.sql.SQLException;
import java.util.Scanner;

public class BankAccountSearch {
    public static void main(String[] args) {
		BankDAO dao=new BankDAO();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Account Number");
		int accountNo=sc.nextInt();
		 try {
			Bank bank=dao.searchAccount(accountNo);
			if(bank!=null){
				System.out.println(bank);
			}else{
				System.out.println("Record not found");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

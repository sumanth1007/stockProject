package com.infinite.project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BankDAO {
       
	Connection con;
	PreparedStatement ps;
	
	public int generateAccountNo() throws ClassNotFoundException, SQLException{
		con=ConnectionHelper.getConnection();
		String sql="select case when max(accountNo) is null then 1 else max(accountNo)+1 end accno from Bank";
		ps=con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		rs.next();
		int accno=rs.getInt("accno");
		return accno;
	}
	public String withdrawAccount(int accountNo,double withdrawAmount) throws ClassNotFoundException, SQLException{
		Bank bank=searchAccount(accountNo);
		if(bank!=null){
			con=ConnectionHelper.getConnection();
			double balance=bank.getAmount();
			if(balance-withdrawAmount>=1000){
			 String sql="update bank set Amount=Amount-? where AccountNo=?";
			 ps=con.prepareStatement(sql);
			 ps.setDouble(1, withdrawAmount);
			 ps.setInt(2, accountNo);
			
			 ps.executeUpdate();
			 sql="insert into Trans(AccountNo,TransAmount,Transtype) values(?,?,?)";
			 ps=con.prepareStatement(sql);
			 ps.setInt(1, accountNo);
			 ps.setDouble(2, withdrawAmount);
			 ps.setString(3, "D");
			 ps.executeUpdate();
			 return "Amount Debited....";
			 
			}else{
				return "Insufficient Funds.....";
			}
			
		}return "Record not found......";
	}
	 public String depositeAccount(int accountNo, double depositeAmount) throws ClassNotFoundException, SQLException{
		 Bank bank=searchAccount(accountNo);
		 if(bank!=null){
			 con=ConnectionHelper.getConnection();
			 String sql="update bank set Amount=Amount+? where AccountNo=?";
			 ps=con.prepareStatement(sql);
			 ps.setDouble(1, depositeAmount);
			 ps.setInt(2, accountNo);
			 ps.executeUpdate();
			 sql="insert into Trans(AccountNo,TransAmount,Transtype) values(?,?,?)";
			 ps=con.prepareStatement(sql);
			 ps.setInt(1, accountNo);
			 ps.setDouble(2, depositeAmount);
			 ps.setString(3, "C");
			 ps.executeUpdate();
			 return "Amount Credited";
		 }return "Record not Found";
	 }
	public String closeAccount(int accountNo) throws ClassNotFoundException, SQLException{
		Bank bank=new Bank();
		if(bank!=null){
			String sql="update bank set status='inactive' where accountno=?";
			con=ConnectionHelper.getConnection();
			ps=con.prepareStatement(sql);
			ps.setInt(1, accountNo);
			ps.executeUpdate();
			return "Account closed";
		}return "record not found";
	}
	 public Bank searchAccount(int accountno) throws ClassNotFoundException, SQLException{
		 con=ConnectionHelper.getConnection();
		 String sql="select * from bank where accountno=?";
		 ps=con.prepareStatement(sql);
		 ps.setInt(1, accountno);
		 ResultSet rs=ps.executeQuery();
		 Bank bank=null;
		 if(rs.next()){
			 bank=new Bank();
			 bank.setAccountno(rs.getInt("accountNo"));
			 bank.setFirstName(rs.getString("firstName"));
			 bank.setLastName(rs.getString("lastName"));
			 bank.setCity(rs.getString("city"));
			 bank.setState(rs.getString("state"));
			 bank.setAmount(rs.getInt("amount"));
			 bank.setCheqFacil(rs.getString("cheqFacil"));
			 bank.setAccountType(rs.getString("accountType"));
			 
		 }return bank;
	 }
	public String createAccount(Bank bank) throws ClassNotFoundException, SQLException{
		int accountNo=generateAccountNo();
		bank.setAccountno(accountNo);
		String sql="insert into Bank(AccountNo,FirstName,LastName,city,state,Amount,CheqFacil,AccountType)values(?,?,?,?,?,?,?,?)";
		con=ConnectionHelper.getConnection();
		ps=con.prepareStatement(sql);
		
		ps.setInt(1, accountNo);
		ps.setString(2, bank.getFirstName());
		ps.setString(3, bank.getLastName());
		ps.setString(4, bank.getCity());
		ps.setString(5, bank.getState());
		ps.setInt(6, bank.getAmount());
		ps.setString(7, bank.getCheqFacil());
		ps.setString(8, bank.getAccountType());
		ps.executeUpdate();
		return "Account Created...";
	}
	
}

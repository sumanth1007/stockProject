package com.infinite.project;

public class Bank {

	  private int accountno;
	  private String firstName;
	  private String lastName;
	  private String city;
	  private String state;
	  private int amount;
	  private String cheqFacil;
	  private String status;
	  private String accountType;
	@Override
	public String toString() {
		return "Bank [accountno=" + accountno + ", firstName=" + firstName + ", lastName=" + lastName + ", city=" + city
				+ ", state=" + state + ", amount=" + amount + ", cheqFacil=" + cheqFacil + ", status=" + status
				+ ", accountType=" + accountType + "]";
	}
	public Bank(int accountno, String firstName, String lastName, String city, String state, int amount,
			String cheqFacil, String status, String accountType) {
	
		this.accountno = accountno;
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
		this.state = state;
		this.amount = amount;
		this.cheqFacil = cheqFacil;
		this.status = status;
		this.accountType = accountType;
	}
	public Bank() {
		
	}
	public int getAccountno() {
		return accountno;
	}
	public void setAccountno(int accountno) {
		this.accountno = accountno;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getCheqFacil() {
		return cheqFacil;
	}
	public void setCheqFacil(String cheqFacil) {
		this.cheqFacil = cheqFacil;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	  
}

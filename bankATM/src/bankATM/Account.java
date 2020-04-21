package bankATM;

import java.time.*;
import java.util.*;

public abstract class Account implements ServiceFee {
	
	private String id;
	private double balance;
	private boolean status;
	private LocalDateTime createdOn;
	private double serviceFee = 1; // for every instance where a bank account is opened/closed 
	private ArrayList<Transaction> transactions = new ArrayList<Transaction>();

	public Account() {
		this.setId(UUID.randomUUID().toString());
		this.setCreatedOn(LocalDateTime.now());
	}

	public String getId() {
		return id;
	}

	private void setId(String id) {
		this.id = id;
	}

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}
	

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public void deposit(double amount) {
		//TODO
	}
	
	public String toString() {
		return "id: " + id + " Balance: " + balance;
	}
	
	@Override
	public double getServiceFee() {
		return serviceFee;
	}
	
	@Override
	public void setServiceFee(double serviceFee) {
		this.serviceFee = serviceFee;
	}

	@Override
	public void deductServiceFee(double serviceFee) {
		// TODO Auto-generated method stub
		
	}
}
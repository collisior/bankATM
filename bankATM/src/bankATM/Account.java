package bankATM;

import java.time.*;
import java.util.*;

public abstract class Account {
	private String id;
	private double balance;
	private boolean status;
	private LocalDateTime createdOn;
	private ArrayList<Transaction> transactions = new ArrayList<Transaction>();

	Account() {
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
	
	
}
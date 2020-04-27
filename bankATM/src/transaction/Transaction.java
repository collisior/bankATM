package transaction;

import java.sql.Date;

import bankATM.*;
import account.*;

public abstract class Transaction implements ServiceFee {
	
	private String id;
	private Account account;
	private Client client;
	private Date created;
	private Money amount;
	private String status;

	Transaction(String id, Account account, Money amount, Money serviceFee, Date created, String status) {
		setId(id);
		setCreated(created);
		setAmount(amount);
		setAccount(account);
		setClient(account.getClient());
		setServiceFee(serviceFee);
		setStatus(status);
	}


	public String getId() {
		return id;
	}

	private void setId(String id) {
		this.id = id;
	}
	
	public Date getCreated() {
		return created;
	}

	private void setCreated(Date created) {
		this.created = created;
	}
	
	public Money getAmount() {
		return amount;
	}

	public void setAmount(Money amount) {
		this.amount = amount;
	}

	public String toString() {
		return "Transaction: " + id + " \nAmount: " + amount + " \nDate: " + created;  
	}


	public Account getAccount() {
		return account;
	}


	public void setAccount(Account account) {
		this.account = account;
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	
}
package transaction;

import java.sql.Date;

import bankATM.*;
import account.*;

public abstract class Transaction implements ServiceFee {
	
	private String id;
	protected Account account;
	private Client client;
	private Money amount;
	private Status status;
	private Type type;
	private Date created;

	Transaction(String id, Account account, Money amount, Date created, Status status) {
		setId(id);
		setCreated(created);
		setAmount(amount);
		setAccount(account);
		setClient(account.getClient());
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
		return "Transaction: " + getType() + " \nAmount: " + amount + " \nDate: " + created;  
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


	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
		this.status = status;
	}


	public Type getType() {
		return type;
	}


	public void setType(Type type) {
		this.type = type;
	}
	
}
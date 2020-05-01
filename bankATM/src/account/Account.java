package account;

import java.sql.Date;

import bankATM.*;

public abstract class Account implements OpenClose {
	
	private String id;
	private Client client;
	private Status status;
	private Type type;
	private Money balance;
	private Date created;

	protected Account(String id, Client client, Status status, Money balance, Date created) {
		setId(id);
		setClient(client);
		setStatus(status);
		setBalance(balance);
		setCreated(created);
	}

	public String getId() {
		return id;
	}

	private void setId(String id) {
		this.id = id;
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

	public Money getBalance() {
		return balance;
	}

	public void setBalance(Money balance) {
		this.balance = balance;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}
	
	public String toString() {
		return "id: " + id + " Balance: " + balance;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
}
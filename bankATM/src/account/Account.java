package account;

import java.sql.Date;

import bankATM.Client;
import bankATM.Money;

public abstract class Account {
	
	private String id;
	private Client client;
	private String status;
	private String type;
	private Money balance;
	private Date created;

	public Account(String id, Client client, String status, Money balance, Date created) {
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
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
}
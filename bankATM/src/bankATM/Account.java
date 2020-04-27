package bankATM;

import java.sql.Date;

public abstract class Account {
	
	private String id;
	private Client client;
	private boolean status;
	private Money balance;
	private Date created;

	public Account(String id, Client client, boolean status, Money balance, Date created) {
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

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
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
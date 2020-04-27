package transaction;

import java.sql.Date;

import bankATM.Money;
import bankATM.ServiceFee;

public abstract class Transaction implements ServiceFee {
	
	private String id;
	private Date created;
	private Money amount;

	Transaction(String id, Date created, Money amount) {
		setId(id);
		setCreated(created);
		setAmount(amount);
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
	
}
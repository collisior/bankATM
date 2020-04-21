package bankATM;

import java.time.*;
import java.util.*;

public abstract class Transaction {
	
	private String id;
	private LocalDateTime createdOn;
	private double amount;

	Transaction() {
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

	private void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
}
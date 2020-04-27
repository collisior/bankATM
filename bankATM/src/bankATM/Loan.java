package bankATM;

import java.util.*;

public class Loan implements Interest {
	
	private String id;
	private Client client;
	private Money amount;
	private Date requested;
	private Date approved;
	private double interest;
	private String status;
	
	Loan(String id, Client client, Money amount, Date requested, double interest) {
		this.setId(id);
		this.setClient(client);
		this.setAmount(amount);
		this.setInterest(interest);
		this.setRequested(requested);
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	public Money getAmount() {
		return amount;
	}

	public void setAmount(Money amount) {
		this.amount = amount;
	}

	public Date getRequested() {
		return requested;
	}

	public void setRequested(Date requested) {
		this.requested = requested;
	}

	public Date getApproved() {
		return approved;
	}

	public void setApproved(Date approved) {
		this.approved = approved;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public double getInterest() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setInterest(double interest) {
		this.interest = interest;
		
	}
	

}

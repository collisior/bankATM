package bankATM;

import java.util.*;

import account.*;

public class Loan implements Interest {
	
	private String id;
	private Account account;
	private Money amount;
	private Date requested;
	private Date approved;
	private float interest;
	private Status status;
	
	public Loan(String id, Account account, Money amount, Date requested, float interest) {
		this.setId(id);
		this.setAccount(account);
		this.setAmount(amount);
		this.setInterest(interest);
		this.setRequested(requested);
		this.setStatus(Status.Requested);
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
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
		setStatus(Status.Approved);
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public float getInterest() {
		return interest;
	}

	@Override
	public void setInterest(float interest) {
		this.interest = interest;
	}
	

}

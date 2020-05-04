package bankATM;

import java.sql.Date;
import java.sql.SQLException;
import java.util.*;

import account.*;
import database.*;

/*
 *  Note: Loan amount is negative.
 */
public class Loan implements Interest {

	private String id;
	private Account account;
	private Money amount;
	private Date requested;
	private Date approved;
	private float interest;
	private Status status;

	// Constructor for loan
	public Loan(String id, Account account, Money amount, Date requested, float interest) {
		this.setId(id);
		this.setAccount(account);
		this.setAmount(amount);
		this.setInterest(interest);
		this.setRequested(requested);
		this.setStatus(Status.Requested);
	}

	// Constructing and Creating new Loan (Adding to DBs)
	public Loan(Account account, Money amount, Date requested, float interest) {
		this(getNewId(), account, amount, getNewDate(), interest);
		if (amount.getValue() < -1000) { // Approve loans without request if amount < 1000
			this.setStatus(Status.Approved);
			this.setApproved(requested);
		}
		addToDB(); // request from Manager
	}

	public void addToDB() {
		DBLoans dbObj = new DBLoans();
		try {
			dbObj.create(this);
		} catch (SQLException e) {
			System.out.println("Couldn't add this Loan to DB.");
			e.printStackTrace();
		}
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	private static String getNewId() {
		return UUID.randomUUID().toString();
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
		this.amount = new Money(-1 * amount.getValue(), amount.getCurrency());
	}

	public Date getRequested() {
		return requested;
	}

	public void setRequested(Date requested) {
		this.requested = requested;
	}

	private static Date getNewDate() {
		return new Date(System.currentTimeMillis());
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

	public boolean payLoan(Money amount) throws SQLException {
		if (amount.getValue() > 0 && amount.getValue() <= getAmount().getValue()) {
			this.setAmount(getAmount().add(amount));
			updateDB();
			return true;
		}
		return false;
	}

	public void updateDB() throws SQLException {
		DBLoans dbObj = new DBLoans();
		dbObj.update(this);
	}

}

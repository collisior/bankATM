package account;

import java.sql.Date;
import java.sql.SQLException;

import bankATM.*;
import database.*;
import transaction.Transaction;
import transaction.Transfer;

public class SavingsAccount extends Account implements Interest {

	private float interest = 0;

	public SavingsAccount(String id, Client client, Status status, Money balance, Date created) {
		super(id, client, status, balance, created);
		setType(Type.SavingsAccount);
	}

	public SavingsAccount(Client client) {
		super(client);
		setType(Type.SavingsAccount);
		updateDB();

	}

	@Override
	public float getInterest() {
		// TODO Auto-generated method stub
		return interest;
	}

	@Override
	public void setInterest(float interest) {
		this.interest = interest;
	}

	@Override
	public void open(Client client) throws SQLException {
		DBAccount dbObj = new DBAccount();
		dbObj.create(this);
	}

	@Override
	public void close(Client client) throws SQLException {
		DBAccount dbObj = new DBAccount();
		dbObj.delete(this);
	}

}
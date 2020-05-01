package account;

import java.sql.Date;
import java.sql.SQLException;

import bankATM.*;
import database.DBAccount;

public class DepositAccount extends Account {

	public DepositAccount(String id, Client client, Status status, Money balance, Date created) {
		super(id, client, status, balance, created);
		setType(Type.DepositAccount);
	}

	@Override
	public void open(Client client) throws SQLException {
		DBAccount dbObj = new DBAccount();
		dbObj.create(this);
	}

	/*
	 * Deposit Account cannot be closed
	 */
	@Override
	public void close(Client client) throws SQLException {
		DBAccount dbObj = new DBAccount();
		dbObj.delete(this);
	}
	
	
	
}
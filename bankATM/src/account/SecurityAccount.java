package account;

import java.sql.Date;
import java.sql.SQLException;

import bankATM.*;
import database.*;

public class SecurityAccount extends Account {

	public SecurityAccount(String id, Client client, Status status, Money balance, Date created) {
		super(id, client, status, balance, created);
		setType(Type.SecurityAccount);
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
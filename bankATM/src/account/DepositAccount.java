package account;

import java.sql.Date;

import bankATM.Client;
import bankATM.Money;
import bankATM.Type;

public class DepositAccount extends Account {

	public DepositAccount(String id, Client client, String status, Money balance, Date created) {
		super(id, client, status, balance, created);
		setType(Type.DepositAccount);
	}
}
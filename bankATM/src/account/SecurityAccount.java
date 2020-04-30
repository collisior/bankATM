package account;

import java.sql.Date;

import bankATM.Client;
import bankATM.Money;
import bankATM.Type;

public class SecurityAccount extends Account {

	public SecurityAccount(String id, Client client, String status, Money balance, Date created) {
		super(id, client, status, balance, created);
		setType(Type.SecurityAccount);
	}
	
}
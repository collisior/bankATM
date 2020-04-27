package account;

import java.sql.Date;

import bankATM.Client;
import bankATM.Money;

public class CheckingAccount extends Account {

	public CheckingAccount(String id, Client client, String status, Money balance, Date created) {
		super(id, client, status, balance, created);
	}
	
	

}
package bankATM;

import java.sql.Date;

public class CheckingAccount extends Account {

	CheckingAccount(String id, Client client, boolean status, Money balance, Date created) {
		super(id, client, status, balance, created);
	}
	
	

}
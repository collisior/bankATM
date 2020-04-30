package account;

import java.sql.Date;

import bankATM.*;
import manager.*;

public class CheckingAccount extends Account implements ServiceFee {

	public CheckingAccount(String id, Client client, String status, Money balance, Date created) {
		super(id, client, status, balance, created);
		setType(Type.CheckingAccount);
	}

	@Override
	public Money getServiceFee() {
		// TODO Auto-generated method stub
		return new Money((float) 1, Currency.USD);
	}

	@Override
	public void setServiceFee(Money serviceFee) {
		// TODO Auto-generated method stub
		
	}
	
}
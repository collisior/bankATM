package account;

import java.sql.Date;

import bankATM.Client;
import bankATM.Interest;
import bankATM.Money;

public class SavingsAccount extends Account implements Interest {

	private float interest = 0;

	public SavingsAccount(String id, Client client, String status, Money balance, Date created) {
		super(id, client, status, balance, created);
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

}
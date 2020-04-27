package bankATM;

import java.sql.Date;

public class SavingsAccount extends Account implements Interest {

	private double interest = 0;

	SavingsAccount(String id, Client client, boolean status, Money balance, Date created) {
		super(id, client, status, balance, created);
	}

	@Override
	public double getInterest() {
		// TODO Auto-generated method stub
		return interest;
	}

	@Override
	public void setInterest(double interest) {
		this.interest = interest;
	}

}
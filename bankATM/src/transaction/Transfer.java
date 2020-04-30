package transaction;

import java.sql.Date;

import account.Account;
import account.CheckingAccount;
import bankATM.*;

public class Transfer extends Transaction implements ServiceFee {
	
	private Account destination;
	
	public Transfer(String id, Account account, Money amount, Date created, Status status, Account destination) {
		super(id, account, amount, created, status);
		setDestination(destination);
		setType(Type.Transfer);
	}
	@Override
	public Money getServiceFee() {
		if (account instanceof CheckingAccount) {
			return ((CheckingAccount) account).getServiceFee();
		}
		return null;
	}

	@Override
	public void setServiceFee(Money serviceFee) {
	}

	public Account getDestination() {
		return destination;
	}

	public void setDestination(Account destination) {
		this.destination = destination;
	}

}

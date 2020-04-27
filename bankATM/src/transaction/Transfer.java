package transaction;

import java.sql.Date;

import account.Account;
import bankATM.*;

public class Transfer extends Transaction implements ServiceFee {
	
	private Money serviceFee;
	private Account destination;
	
	public Transfer(String id, Account account, Money amount, Money serviceFee, Date created, String status, Account destination) {
		super(id, account, amount, serviceFee, created, status);
		setDestination(destination);
	}

	@Override
	public Money getServiceFee() {
		return serviceFee;
	}

	@Override
	public void setServiceFee(Money serviceFee) {
		this.serviceFee = serviceFee;
	}

	public Account getDestination() {
		return destination;
	}

	public void setDestination(Account destination) {
		this.destination = destination;
	}

}

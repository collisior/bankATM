package transaction;

import java.sql.Date;

import account.*;
import bankATM.*;

public class Deposit extends Transaction {
	
	private Money serviceFee;
	
	public Deposit(String id, Account account, Money amount, Money serviceFee, Date created, String status) {
		super(id, account, amount, serviceFee, created, status);
	}

	@Override
	public Money getServiceFee() {
		return serviceFee;
	}

	@Override
	public void setServiceFee(Money serviceFee) {
		this.serviceFee = serviceFee;
	}
}

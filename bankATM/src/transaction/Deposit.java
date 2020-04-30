package transaction;

import java.sql.Date;

import account.*;
import bankATM.*;

public class Deposit extends Transaction {
		
	public Deposit(String id, Account account, Money amount, Date created, Status status) {
		super(id, account, amount, created, status);
		setType(Type.Deposit);
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
}

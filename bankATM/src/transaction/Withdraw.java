package transaction;

import java.sql.Date;

import account.*;
import bankATM.*;

public class Withdraw extends Transaction implements ServiceFee {

	public Withdraw(String id, Account account, Money amount, Date created, Status status) {
		super(id, account, amount, created, status);
		setType(Type.Withdraw);
	}

	@Override
	public Money getServiceFee() {
		Money serviceFee  = new Money ((float) 1, Currency.USD);
		if (account instanceof CheckingAccount) {
			return serviceFee.add(((CheckingAccount) account).getServiceFee());
		}
		return serviceFee;
	}

	@Override
	public void setServiceFee(Money serviceFee) {
	}
}

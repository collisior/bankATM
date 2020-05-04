package transaction;

import java.sql.Date;
import java.sql.SQLException;

import account.*;
import bankATM.*;

public class Withdraw extends Transaction implements ServiceFee {

	public Withdraw(String id, Account account, Money amount, Date created, Status status) {
		super(id, account, amount, created, status);
		setType(Type.Withdraw);
	}

	// Constructor with no id, created Date, adding to DB
	public Withdraw(Account account, Money amount, Status status) {
		super(account, amount, status);
		setType(Type.Withdraw);
	}

	@Override
	public Money getServiceFee() {
		Money serviceFee = null;
		try {
			serviceFee = account.getClient().getBank().getWithdrawFee();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (account instanceof CheckingAccount) {
			try {
				serviceFee = serviceFee.add(account.getClient().getBank().getCheckingAccountFee());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return serviceFee;
	}

	@Override
	public void setServiceFee(Money serviceFee) {
	}
}

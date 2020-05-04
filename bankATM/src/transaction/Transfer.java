package transaction;

import java.sql.Date;
import java.sql.SQLException;

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

	// Constructor with no id, created Date, adding to DB
	public Transfer(Account account, Money amount, Account destination, Status status) {
		super(account, amount, status);
		setDestination(destination);
		setType(Type.Transfer);
	}
	

	@Override
	public Money getServiceFee() {
		Money serviceFee = null;
		try {
			serviceFee = ((Client) account.getClient()).getBank().getTransferFee();
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

	public Account getDestination() {
		return destination;
	}

	public void setDestination(Account destination) {
		this.destination = destination;
	}

	public String getInfo() {
		String info = getType() + ": from " + getAccount() + " to " + getDestination() + " "+ getAmount() + " ("
				+ getCreated() + ")";
		return info;
	}

}

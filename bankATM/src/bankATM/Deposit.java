package bankATM;

import java.sql.Date;

public class Deposit extends Transaction {
	
	private Money serviceFee;
	
	public Deposit(String id, Date created, Money amount) {
		super(id, created, amount);
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

package bankATM;

import java.sql.Date;

public class Withdraw extends Transaction implements ServiceFee {
	
	private Money serviceFee;
	
	public Withdraw(String id, Date created, Money amount) {
		super(id, created, amount);
	}

	@Override
	public Money getServiceFee() {
		// TODO Auto-generated method stub
		return serviceFee;
	}

	@Override
	public void setServiceFee(Money serviceFee) {
		this.serviceFee = serviceFee;
		
	}
}

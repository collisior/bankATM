package bankATM;

import java.sql.Date;

public class Transfer extends Transaction implements ServiceFee {
	
	private Money serviceFee;
	
	public Transfer(String id, Date created, Money amount) {
		super(id, created, amount);
	}

	@Override
	public Money getServiceFee() {
		return serviceFee;
	}

	@Override
	public void setServiceFee(Money serviceFee) {
		// TODO Auto-generated method stub
		
	}

}

package bankATM;

public class Withdraw extends Transaction implements ServiceFee {
	
	private double serviceFee;
	
	public Withdraw() {
		super();
	}

	@Override
	public double getServiceFee() {
		// TODO Auto-generated method stub
		return serviceFee;
	}

	@Override
	public void setServiceFee(double serviceFee) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deductServiceFee(double serviceFee) {
		// TODO Auto-generated method stub
		
	}

}

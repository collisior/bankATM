package bankATM;

public class Transfer extends Transaction implements ServiceFee {
	
	private double serviceFee;
	
	public Transfer() {
		super();
	}
	
	@Override
	public double getServiceFee() {
		return serviceFee;
	}
	
	@Override
	public void setServiceFee(double serviceFee) {
		this.serviceFee = serviceFee;
	}

	@Override
	public void deductServiceFee(double serviceFee) {
		// TODO Auto-generated method stub
		
	}
}

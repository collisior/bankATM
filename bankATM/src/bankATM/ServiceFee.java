package bankATM;

public interface ServiceFee {
	
	public abstract double getServiceFee();

	public abstract void setServiceFee(double serviceFee);
	
	public abstract void deductServiceFee(double serviceFee);
}

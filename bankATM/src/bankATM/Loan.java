package bankATM;

public class Loan implements Interest {
	
	private double amount;
	private double interest;
	
	Loan(double amount) {
		this.setAmount(amount);
		this.setInterest();
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public double getInterest() {
		return interest;
	}
	
	@Override
	public void setInterest() {
		/*
		 * TODO: calculate interest based on amount
		 */
		this.interest = amount * 0.01;
	}

}

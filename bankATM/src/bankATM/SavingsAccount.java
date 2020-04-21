package bankATM;


public class SavingsAccount extends Account implements Interest {

	private double interest = 0;
	
	SavingsAccount() {
		super();
	}

	@Override
	public double getInterest() {
		// TODO Auto-generated method stub
		return interest;
	}

	@Override
	public void setInterest() {
		/*
		 * TODO: handle “high balance” interest earnings
		 */
		if(getBalance() > 10000) {
			this.interest = 0.01;
		}
	}

}
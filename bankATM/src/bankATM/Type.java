package bankATM;

public enum Type {
	//Transaction type
	Withdraw("Withdraw"), 
	Deposit("Deposit"), 
	Transfer("Transfer"), 
	InterestEarned("Interest Earned"),
	LoanPayment("Loan Payment"),
	StockOperation("Stock Operation"),
	
	//Stock type
	PurchasedStock("Purchased Stock"),
	SoldStock("Sold Stock"), 
	
	//Account type
	SavingsAccount("Savings Account"), 
	LoansAccount("Loans Account"),
	CheckingAccount("Checking Account"),
	DepositAccount("Deposit Account"), 
	SecurityAccount("Security Account");

	public String str;

	Type(String str) {
		this.str = str;
	}

	public boolean equals(Type other) {
		if (this == other) {
			return true;
		}
		return false;
	}

	public boolean equals(String other) {
		if (str.toString().equals(other)) {
			return true;
		}
		return false;
	}

	public String toString() {
		return str;
	}

}

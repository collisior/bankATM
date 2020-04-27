package bankATM;

public class Constant {

	public enum Status {
		Pending("Pending"), 
		Sold("Sold"), 
		Purchased("Purchased"), 
		Realized("Realized"), 
		Unrealized("Unrealized");

		public String s;

		Status(String s) {
			this.s = s;
		}

		public boolean equals(Status other) {
			if (this == other) {
				return true;
			}
			return false;
		}
		
		public boolean equals(String other) {
			if (s.toString().equals(other)) {
				return true;
			}
			return false;
		}

		public String toString() {
			return s;
		}
	}

	public enum Type {
		Withdraw("Withdraw"), 
		Deposit("Deposit"), 
		Transfer("Transfer"), 
		Savings("Savings"), 
		Checking("Checking"),
		Security("Security");

		public String s;

		Type(String s) {
			this.s = s;
		}

		public boolean equals(Type other) {
			if (this == other) {
				return true;
			}
			return false;
		}
		
		public boolean equals(String other) {
			if (s.toString().equals(other)) {
				return true;
			}
			return false;
		}
		public String toString() {
			return s;
		}
	}

}

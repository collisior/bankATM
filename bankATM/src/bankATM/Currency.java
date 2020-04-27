package bankATM;

public enum Currency {

	USD("USD", 1.0), 
	EUR("EUR", 0.87),
	GBP("GBP", 0.75), 
	JPY("JPY", 102.68);

	private final String string;
	private final double rate;

	Currency(String string, double rate) {
		this.string = string;
		this.rate = rate;
	}

	public double getRate() {
		return rate;
	}

	public String toString() {
		return string;
	}
}

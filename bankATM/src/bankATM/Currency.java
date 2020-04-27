package bankATM;

public enum Currency {

	USD("USD", (float) 1.0000), 
	EUR("EUR", (float) 0.87),
	GBP("GBP", (float) 0.75), 
	JPY("JPY", (float) 102.68);

	public String string;
	public float rate;

	Currency(String string, float rate) {
		this.string = string;
		this.rate = rate;
	}

	public float getRate() {
		return rate;
	}

	public String toString() {
		return string;
	}
}

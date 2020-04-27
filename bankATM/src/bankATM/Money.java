package bankATM;

public class Money {

	private double value; // USD
	private Currency currency;

	Money(double value, Currency currency) {
		this.setValue(value);
		this.setCurrency(currency);
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public double getConversion(Currency otherCurrency) {
		return value * otherCurrency.getRate();
	}
	
	public String toString() {
		return "" + value * currency.getRate() + currency;
	}
}

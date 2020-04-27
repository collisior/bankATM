package bankATM;

public class Money {

	private float value; // USD
	private Currency currency;

	public Money(float value, Currency currency) {
		this.setValue(value);
		this.setCurrency(currency);
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public float getConversion(Currency otherCurrency) {
		return value * otherCurrency.getRate();
	}
	
	public String toString() {
		float total = value * currency.getRate() ;
		 
		return "" + String.format("%.02f", total) + " " +currency;
	}
}

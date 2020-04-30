package transaction;

import java.sql.Date;

import account.Account;
import bankATM.*;

public class StockOperation extends Transaction implements ServiceFee {
	
	private Stock stock;
	
	public StockOperation(String id, Account account, Money amount, Date created, Status status) {
		super(id, account, amount, created, status);
		setType(getType());
	}
	public Type getType() {
		return Type.StockOperation;
	}

	@Override
	public Money getServiceFee() {
		return null;
	}

	@Override
	public void setServiceFee(Money serviceFee) {
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

}

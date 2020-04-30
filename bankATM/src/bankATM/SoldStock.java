package bankATM;

import java.sql.Date;
import account.*;

public class SoldStock {

	private String id;
	private Stock stock;
	private Account account;
	private Money purchasedPrice;
	private Money soldPrice;
	private int quantity;
	private Status status;
	private Type type;
	private Date created;

	public SoldStock(String id, Stock stock, Account account, Money purchasedPrice, Money soldPrice, int quantity,
			Date created) {
		setId(id);
		setStock(stock);
		setAccount(account);
		setPurchasedPrice(purchasedPrice);
		setSoldPrice(soldPrice);
		setQuantity(quantity);
		setType(Type.SoldStock);
		setStatus(getStatus());
	}

	public String getId() {
		return id;
	}

	private void setId(String id) {
		this.id = id;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public Money getPurchasedPrice() {
		return purchasedPrice;
	}

	public void setPurchasedPrice(Money purchasedPrice) {
		this.purchasedPrice = purchasedPrice;
	}

	public Money getSoldPrice() {
		return soldPrice;
	}

	public void setSoldPrice(Money soldPrice) {
		this.soldPrice = soldPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Status getStatus() {
		if (purchasedPrice.compareTo(soldPrice) <= 0) {
			return status.Realized;
		}
		return status.Unrealized;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}

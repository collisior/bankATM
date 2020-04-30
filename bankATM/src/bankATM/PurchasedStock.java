package bankATM;

import java.sql.Date;

import account.*;

public class PurchasedStock {
	
	private String id;
	private Stock stock;
	private Account account;
	private Money purchasedPrice;
	private int quantity;
	private Type type;
	private Date created;
	
	public PurchasedStock(String id, Stock stock, Account account, Money purchasedPrice, int quantity, Date created) {
		setId(id);
		setStock(stock);
		setAccount(account);
		setPurchasedPrice(purchasedPrice);
		setQuantity(quantity);
		setType(Type.PurchasedStock);
		setCreated(created);
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
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

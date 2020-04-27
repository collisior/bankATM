package bankATM;

import java.sql.Date;

public class Stock {
	private String id;
	private String name;
	private Money price;
	private int quantity;
	private String status;
	private Date created;
	
	Stock(String id, String name, Money price, int quantity, String status, Date created) {
		setId(id);
		setName(name);
		setPrice(price);
		setQuantity(quantity);
		setStatus(status);
	}

	public String getId() {
		return id;
	}
	
	private void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Money getPrice() {
		return price;
	}

	public void setPrice(Money price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}
	
	
}

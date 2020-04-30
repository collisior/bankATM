package bankATM;

import java.sql.Date;

public class Stock {
	
	private String id;
	private String name;
	private Money price;
	private int quantity;
	private Status status;
	private Date created;
	
	public Stock(String id, String name, Money price, int quantity, Date created, Status status) {
		setId(id);
		setName(name);
		setPrice(price);
		setQuantity(quantity);
		setCreated(created);
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

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}
	
	public String toString() {
		return name;
	}
}

package bankATM;

public interface StockController {
	
	public abstract void addStock(Stock stock);
	
	public abstract void setStatus(Stock stock);
	
	public abstract void setPrice(Stock stock, Money price);
	
	public abstract void setQuantity(Stock stock, int quantity);
	
}

package bankATM;

import java.util.*;

public class Manager implements AccountController, LoanController, StockController, ServiceFeeController, InterestController {

	private String id;
	private Person person;
	private String email;
	private String password;
	
	Manager(Person person, String email, String password) {
		this.setId();
		this.setPerson(person);
		this.setEmail(email);
		this.setPassword(password);
	}
	

	public String getId() {
		return id;
	}
	
	private void setId() {
		this.id = UUID.randomUUID().toString();
	}
	
	public void setPerson(Person person) {
		this.person = person;
	}

	public Person getPerson() {
		return person;
	}
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}


	@Override
	public void setSavingsInterest(double interest) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setLoanInterest(double interest) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public boolean setWithdrawServiceFee(Money fee) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean setTranserServiceFee(Money fee) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean setDepositServiceFee(Money fee) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void addStock(Stock stock) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setStatus(Stock stock) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setPrice(Stock stock, Money price) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setQuantity(Stock stock, int quantity) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public boolean issueLoan(Client client) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean openAccount(Client client, Account account) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean closeAccount(Account account) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void collectMoneyFrom(Client client) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void collectMoneyFromAll() {
		// TODO Auto-generated method stub
		
	}
	
}

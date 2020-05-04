package manager;

import java.sql.SQLException;
import java.sql.Date;
import java.util.*;

import account.*;
import bankATM.*;
import database.*;

public class Manager
		implements AccountController, LoanController, StockController, ServiceFeeController, InterestController {

	private String id;
	private Person person;
	private String email;
	private String password;
	private Bank bank;

	public Manager(String id, Person person, String email, String password) throws SQLException {
		this.setId(id);
		this.setPerson(person);
		this.setEmail(email);
		this.setPassword(password);
		setBank();
	}

	public String getId() {
		return id;
	}

	private void setId(String id) {
		this.id = id;
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
	public void setWithdrawServiceFee(Money fee) {
		bank.setWithdrawFee(fee);

	}

	@Override
	public void setTranserServiceFee(Money fee) {
		bank.setTransferFee(fee);
		;
	}

	@Override
	public void setDepositServiceFee(Money fee) {
		bank.setDepositFee(fee);
	}

	@Override
	public void setCloseAccountFee(Money fee) {
		bank.setCloseAccountFee(fee);
	}

	@Override
	public void setOpenAccountFee(Money fee) {
		bank.setOpenAccountFee(fee);
	}

	@Override
	public void addStock(Stock stock) {
		if(!stock.getName().isEmpty() && stock.getQuantity() > 0) {
			stock.addToDB();
		} else {
			System.out.println("Invalid Stock created.");
		}
	}

	@Override
	public void setStatus(Stock stock, Status status) {
		stock.setStatus(Status.Closed);
		stock.updateDB();
	}

	@Override
	public void setPrice(Stock stock, Money price) {
		stock.setPrice(price);
		stock.updateDB();
	}

	@Override
	public void setQuantity(Stock stock, int quantity) {
		stock.setQuantity(quantity);
		stock.updateDB();
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

	@Override
	public void setSavingsInterest(float interest) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setLoanInterest(float interest) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean approveLoan(Account account) {

		return false;
	}

	@Override
	public Loan issueLoan(Account account) {
		// TODO Auto-generated method stub
		return null;
	}

	public String toString() {
		return "Manager: " + person;
	}

	public void setBank() throws SQLException {
		DBBank bankObj = new DBBank();
		this.bank = bankObj.retrieveById("testBank");
	}

	public void updateBank(){
		DBBank bankObj = new DBBank();
		try {
			bankObj.update(bank);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

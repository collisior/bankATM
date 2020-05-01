package bankATM;

import java.sql.Date;
import java.sql.SQLException;

import account.*;
import java.util.*;
import database.*;

public class Client {

	private String id;
	private Person person;
	private Date created;
	private String email;
	private String password;

	public Client(String id, Person person, Date created, String email, String password) {
		this.setId(id);
		this.setPerson(person);
		this.setCreated(created);
		this.setEmail(email);
		this.setPassword(password);
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

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
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

	/*
	 * Creates Deposit Account. Must be used once when new Client signs up.
	 */
	public void openDepositAccount() throws SQLException {
		String newid = UUID.randomUUID().toString();
		Date created = new Date(System.currentTimeMillis());
		DepositAccount depositAccount = new DepositAccount(newid, this, Status.Open, new Money(0, Currency.USD),
				created);
		depositAccount.open(this);
	}

	/*
	 * Returns this Client's list all accounts from DB
	 */
	public ArrayList<Account> getAllAccounts() throws SQLException {
		DBAccount dbObj = new DBAccount();
		ArrayList<Account> accounts = new ArrayList<Account>();
		accounts = dbObj.retrieveClientAccounts(this);

		if (accounts.isEmpty()) {
			System.out.println("No accounts found associated with this Client.");
			return null;
		}
		return accounts;
	}
	
	/*
	 * Returns this Client's List of Specified Type Accounts
	 * (Checking/Savings/Deposit/Security/Security/Loans)
	 */
	public ArrayList<Account> getAccountsOfType(Type type) throws SQLException {
		ArrayList<Account> accounts = new ArrayList<Account>();
		for (Account account : getAllAccounts()) {
			if (account.getType().equals(type)) {
				accounts.add(account);
			}
		}
		if (accounts.isEmpty()) {
			System.out.println("No " + type + " accounts found associated with this Client.");
			return null;
		}
		return accounts;
	}

	public String toString() {
		return person + ", email: " + email;
	}

}

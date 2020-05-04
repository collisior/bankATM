package bankATM;

import java.sql.Date;
import java.sql.SQLException;

import account.*;
import java.util.*;
import database.*;
import transaction.*;

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
	 * Creates Deposit Account. Must be used once when new Client signs up. Client
	 * has only one deposit account.
	 */
	public void openDepositAccount() throws SQLException {
		if (getAccountsOfType(Type.DepositAccount) == null) {
			String newid = UUID.randomUUID().toString();
			Date created = new Date(System.currentTimeMillis());
			DepositAccount depositAccount = new DepositAccount(newid, this, Status.Open, new Money(0, Currency.USD),
					created);
			depositAccount.open(this);
		} else {
			System.out.println("Client already have Deposit Account! No new needed!");
		}
	}

	/*
	 * Creates Checking Account. Client can have up to ? Checking accounts. Default:
	 * 1 Checking Account.
	 */
	public boolean openCheckingAccount() throws SQLException {
		DBBank bankObj = new DBBank();
		Bank bank = bankObj.retrieveById("testBank");
		Money serviceFee = bank.getOpenAccountFee();

		// TODO: Ask Bank the number of Checking accounts this client ALLOWED to have
		if (getAccountsOfType(Type.CheckingAccount) == null) {
			CheckingAccount checkingAccount = new CheckingAccount(this);

		} else {
			System.out.println("Client already have Checking Account.");
			return false;
		}
		payBank(getDepositAccount(), serviceFee);
		return true;
	}

	/*
	 * Creates Savings Account. Client can have up to ? Savings accounts. Default: 1
	 * Savings Account.
	 */
	public boolean openSavingsAccount() throws SQLException {
		DBBank bankObj = new DBBank();
		Bank bank = bankObj.retrieveById("testBank");
		Money serviceFee = bank.getOpenAccountFee();

		// TODO: Ask Bank the number of Savings accounts this client ALLOWED to have
		if (getAccountsOfType(Type.SavingsAccount) == null) {
			SavingsAccount savingsAccount = new SavingsAccount(this);
		} else {
			System.out.println("Client already have Savings Account.");
			return false;
		}
		payBank(getDepositAccount(), serviceFee);
		return true;
	}

	/*
	 * Creates Security Account. Client can have up to ? Security accounts. Default:
	 * 1 Security Account.
	 */
	public boolean openSecurityAccount() throws SQLException {
		Money serviceFee = getBank().getOpenAccountFee();
		// TODO: Ask Bank the number of Savings accounts this client ALLOWED to have
		if (getAccountsOfType(Type.SecurityAccount) == null) {
			SecurityAccount securityAccount = new SecurityAccount(this);
		} else {
			System.out.println("Client already have Security Account. Can have only 1 Security Account");
			return false;
		}
		payBank(getDepositAccount(), serviceFee);
		return true;
	}

	/*
	 * Creates Loans Account. Client can have up to ? Loans accounts. Default: 1
	 * Loans Account.
	 */
	public boolean openLoansAccount() throws SQLException {
		// TODO: Ask Bank the number of Savings accounts this client ALLOWED to have
		if (getAccountsOfType(Type.LoansAccount) == null) {
			LoansAccount loansAccount = new LoansAccount(this, new Money(0, Currency.USD));
		} else {
			System.out.println("Client already have Loans Account. Can have only 1 Loans Account.");
			return false;
		}
		return true;
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

	/*
	 * Returns this Client's Deposit Account
	 */
	public Account getDepositAccount() throws SQLException {
		Account depositAccount = getAccountsOfType(Type.DepositAccount).get(0);
		return depositAccount;
	}

	/*
	 * Returns this Client's Loans Account
	 */
	public Account getLoansAccount() throws SQLException {
		Account loansAccount = null;
		ArrayList<Account> loansAccounts = getAccountsOfType(Type.LoansAccount);
		if (loansAccounts.isEmpty()) {
			openLoansAccount();
			loansAccount = getAccountsOfType(Type.LoansAccount).get(0);
		}
		return loansAccount;
	}

	/*
	 * Close Account. Client can close account if balance >= 0 (remaining balance is
	 * moved to Deposit Account).
	 */
	public boolean closeAccount(Account account) throws SQLException {
		Money serviceFee = getBank().getCloseAccountFee();
		Account depositAccount = getDepositAccount();
		if (account.getBalance().compareTo(serviceFee) < 0) {
			System.out.println("Not enough balance to pay Close-Account fees.");
			return false;
		}
		if (account.getType().equals(Type.DepositAccount)) {
			System.out.println("Client can't close Deposit Account.");
		} else if (account.getType().equals(Type.CheckingAccount) || account.getType().equals(Type.SavingsAccount)) {

			Money amount = account.getBalance();
			Transfer transfer = account.transfer(amount.subtract(serviceFee), depositAccount);
			if (transfer != null) {
				account.close(this);
			}
		}
		payBank(depositAccount, serviceFee);
		return true;
	}

	public ArrayList<Transaction> getTransactions() throws SQLException {
		DBTransaction dbObj = new DBTransaction();
		ArrayList<Transaction> transactions = new ArrayList<Transaction>();
		transactions = dbObj.retrieveTransactions(this);

		if (transactions.isEmpty()) {
			System.out.println("No transaction found associated with this Client.");
			return null;
		}
		return transactions;
	}

	public void requestLoan(Money amount) throws SQLException {
		Account account = getLoansAccount();

	}

	/*
	 * Pay fees/loans to bank from given account
	 */
	public void payBank(Account account, Money amount) throws SQLException {
		DBBank bankObj = new DBBank();
		Bank bank = bankObj.retrieveById("testBank");
		account.setBalance(account.getBalance().subtract(amount));
		bank.addToBalance(amount);
		bankObj.update(bank);
	}

	public String toString() {
		return person + ", email: " + email;
	}

	public void updateDB() throws SQLException {
		DBClient dbObj = new DBClient();
		dbObj.update(this);
	}

	public Bank getBank() throws SQLException {
		DBBank bankObj = new DBBank();
		return bankObj.retrieveById("testBank");
	}

}

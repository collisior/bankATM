package database;

import java.sql.*;
import java.util.UUID;

import account.Account;
import account.CheckingAccount;
import bankATM.*;
import transaction.*;

public class DBTransaction implements CRUDInterface<Transaction> {

	Connection conn = DataBaseConnection.getConnection();

	String tableName = "Transactions";

	public static void main(String[] args) throws SQLException {
		DBTransaction testObj = new DBTransaction();
		String id = UUID.randomUUID().toString();
		Date date = new Date(2001, 12, 1);
		Person testPerson = new Person(id, "testName", "testLast", date, "000-test-phone", "testCity", "testCountry");
		id = UUID.randomUUID().toString();
		Client testClient = new Client(id, testPerson, date, "testEmail", "testPassword");
		id = UUID.randomUUID().toString();
		Account testAcc = new CheckingAccount(id, testClient, "stausTest", new Money(120, Currency.USD), date);
		id = UUID.randomUUID().toString();
		Transaction testTransaction = new Withdraw(id, testAcc, new Money(121, Currency.USD),
				new Money(121, Currency.USD), date, "testStatus");

		testObj.create(testTransaction);
		testObj.delete(testTransaction);
	}

	/*
	 * Insert Person into database table Person.
	 */
	@Override
	public void create(Transaction transaction) throws SQLException {
		String sql = "INSERT INTO " + tableName
				+ " (id, account_id, client_id, amount, service_fee, destination_account_id, created, status, type) VALUES (?, ?, ?, ?, ?, ?, ?)";

		PreparedStatement statement = conn.prepareStatement(sql);

		statement.setString(1, transaction.getId());
		statement.setString(2, transaction.getAccount().getId());
		statement.setString(3, transaction.getAccount().getClient().getId());
		statement.setFloat(4, transaction.getAmount().getValue());
		if (transaction instanceof Transfer) {
			statement.setString(5, ((Transfer) transaction).getDestination().getId());
		}
		statement.setDate(6, transaction.getCreated());
		statement.setString(7, transaction.getStatus());

		int rowsInserted = statement.executeUpdate();

		if (rowsInserted > 0) {
			System.out.println("A new Transaction was created successfully!");
		}
	}

	// Withdraw(String id, Account account, Money amount, Money serviceFee, Date
	// created, String status)
	// super(id, account, amount, serviceFee, created, status);

	@Override
	public Transaction retrieve(Transaction transaction) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Transaction retrieveById(String id) throws SQLException {
		DBAccount dbAccObj = new DBAccount();
		Transaction transaction = null;
		PreparedStatement statement = conn.prepareStatement(
				"SELECT id, account_id, client_id, amount, service_fee, destination_account_id, created, status, type FROM "
						+ tableName);
		ResultSet resultSet = statement.executeQuery();

		while (resultSet.next()) {

			if (resultSet.getString("id").equals(id)) {
				Account account = dbAccObj.retrieveById(resultSet.getString("account_id"));
				Money amount = new Money(resultSet.getFloat("amount"), Currency.USD);
				Money serviceFee = new Money(resultSet.getFloat("amount"), Currency.USD);
				Account destination = dbAccObj.retrieveById(resultSet.getString("destination_account_id"));
				Date created = resultSet.getDate("created");
				String status = resultSet.getString("status");
				String type = resultSet.getString("type");
				
				if (type.equals("withdraw")) {
					transaction = new Withdraw(id, account, amount, serviceFee, created, status);
				} else if (type.equals("transfer")) {
					transaction = new Transfer(id, account, amount, serviceFee, created, status, destination);
				} else if (type.equals("deposit")) {
					transaction = new Deposit(id, account, amount, serviceFee, created, status);
				}
			}
		}
		if (transaction == null) {
			System.out.println("No transaction with id: " + id);
		} else {
			System.out.println("A transaction fetched successfully! Person: " + transaction);
		}
		return transaction;
	}

	@Override
	public void delete(Transaction transaction) throws SQLException {
		String sql = "DELETE FROM " + tableName + " WHERE id = '" + transaction.getId() + "'";
		Statement stmt;
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			System.out.println("Transaction: " + transaction.getId() + " deleted successfully from db");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteById(String id) throws SQLException {
		String sql = "DELETE FROM " + tableName + " WHERE id = '" + id + "';";
		Statement stmt;
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			System.out.println("Transaction: " + id + " deleted successfully from db");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Transaction transaction) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateById(String id) throws SQLException {
		// TODO Auto-generated method stub

	}
}

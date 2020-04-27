package database;

import java.sql.*;
import java.util.UUID;

import account.*;
import bankATM.*;

public class DBAccount implements CRUDInterface<Account> {

	Connection conn = DataBaseConnection.getConnection();

	String tableName = "Accounts";

	/*
	 * Account(String id, Client client, boolean status, Money balance, Date
	 * created)
	 */
	public static void main(String[] args) throws SQLException {
		DBAccount testObj = new DBAccount();
		String id = UUID.randomUUID().toString();
		Date date = new Date(2001, 12, 1);
		Person testPerson = new Person(id, "testName", "testLast", date, "000-test-phone", "testCity", "testCountry");

		Client testClient = new Client(id, testPerson, date, "testEmail", "testPassword");

		id = UUID.randomUUID().toString();
		Account testAcc = new CheckingAccount(id, testClient, "stausTest", new Money(120, Currency.USD), date);

		testObj.create(testAcc);
		testObj.delete(testAcc);
	}

	/*
	 * Insert Account into database table Accounts.
	 */

	@Override
	public void create(Account account) throws SQLException {
		String sql = "INSERT INTO " + tableName + " (id, client_id, status, type, balance, created) VALUES (?, ?, ?, ?, ?)";

		PreparedStatement statement = conn.prepareStatement(sql);

		statement.setString(1, account.getId());
		statement.setString(2, account.getClient().getId());
		statement.setString(3, account.getStatus());
		statement.setString(4, account.getClass().getName());
		statement.setFloat(5, account.getBalance().getValue());
		statement.setDate(4, account.getCreated());
		
		int rowsInserted = statement.executeUpdate();

		if (rowsInserted > 0) {
			System.out.println("A new Client was created successfully!");
		}

	}

	@Override
	public Account retrieve(Account t) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account retrieveById(String id) throws SQLException {
		DBClient dbClientObj = new DBClient();

		Account account = null;
		PreparedStatement statement = conn
				.prepareStatement("SELECT id, client_id, status, type, balance, created from " + tableName);
		ResultSet resultSet = statement.executeQuery();

		while (resultSet.next()) {

			if (resultSet.getString("id").equals(id)) {
				Client client = dbClientObj.retrieveById(resultSet.getString("client_id"));
				String status = resultSet.getString("status");
				String type = resultSet.getString("type");
				Money balance = new Money(resultSet.getFloat("balance"), Currency.USD);
				Date created = resultSet.getDate("created");
				
				if(type.equals("account.CheckingAccount")) {
					account = new CheckingAccount(id, client, status, balance, created);
				} else if (type.equals("account.SavingsAccount")) {
					account = new SavingsAccount(id, client, status, balance, created);
				}
			}
		}
		if (account == null) {
			System.out.println("No account with id: " + id);
		} else {
			System.out.println("Account fetched successfully! account: " + account);
		}
		return account;
	}

	@Override
	public void delete(Account account) throws SQLException {
		String sql = "DELETE FROM " + tableName + " WHERE id = '" + account.getId() + "'";
		Statement stmt;
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			System.out.println("Account: " + account.getId() + " deleted successfully from db");
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
			System.out.println("Account: " + id + " deleted successfully from db");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Account t) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateById(String id) throws SQLException {
		// TODO Auto-generated method stub
		
	}
}
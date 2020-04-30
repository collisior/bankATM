package database;

import java.sql.*;
import java.util.UUID;

import account.*;
import bankATM.*;

public class DBStocks implements CRUDInterface<Stock> {

	Connection conn = DataBaseConnection.getConnection();

	String tableName = "Stocks";
	String columns = " (id, name, price, quantity, status, created) ";

	/*
	 * Account(String id, Client client, boolean status, Money balance, Date
	 * created)
	 */
	public static void main(String[] args) throws SQLException {
		DBStocks testObj = new DBStocks();
		String id = UUID.randomUUID().toString();
		Date date = new Date(2001, 12, 1);
		Person testPerson = new Person(id, "testName", "testLast", date, "000-test-phone", "testCity", "testCountry");

		Client testClient = new Client(id, testPerson, date, "testEmail", "testPassword");

		id = UUID.randomUUID().toString();
		Account testAcc = new CheckingAccount(id, testClient, "stausTest", new Money(120, Currency.USD), date);
		
		Stock tesStock = new Stock(id, testAcc.getId(), new Money(2222, Currency.USD), 5, date, null);
		
		testObj.create(tesStock);
		testObj.delete(tesStock);
	}

	/*
	 * Insert Account into database table Accounts.
	 */

	@Override
	public void create(Stock stock) throws SQLException {
		String sql = "INSERT INTO " + tableName + columns + " VALUES (?, ?, ?, ?, ?, ?)";

		PreparedStatement statement = conn.prepareStatement(sql);

		statement.setString(1, stock.getId());
		statement.setString(2, stock.getName());
		statement.setFloat(3, stock.getPrice().getValue());
		statement.setInt(4, stock.getQuantity());
		statement.setString(5, stock.getStatus().str);
		statement.setDate(6, stock.getCreated());

		int rowsInserted = statement.executeUpdate();

		if (rowsInserted > 0) {
			System.out.println("A new Stock was created successfully!" );
		}

	}

	@Override
	public Stock retrieve(Stock stock) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Stock retrieveById(String id) throws SQLException {
		DBClient dbClientObj = new DBClient();

		Stock stock = null;
		PreparedStatement statement = conn.prepareStatement("SELECT " + columns + " FROM " + tableName);
		ResultSet resultSet = statement.executeQuery();

		while (resultSet.next()) {

			if (resultSet.getString("id").equals(id)) {
				String name = resultSet.getString("name");
				Money price = new Money(resultSet.getFloat("price"), Currency.USD);;
				int quantity = resultSet.getInt("quantity");
				Date created = resultSet.getDate("created");
				Status status = null;
				if(Status.Open.equals(resultSet.getString("status"))) {
					status = Status.Open;
				} else {
					status = Status.Closed;
				}
				
				stock = new Stock(id, name, price, quantity, created, status);
			}
		}
		if (stock == null) {
			System.out.println("No Stock with id: " + id);
		} else {
			System.out.println("Stock fetched successfully! account: " + stock);
		}
		return stock;
	}

	@Override
	public void delete(Stock stock) throws SQLException {
		String sql = "DELETE FROM " + tableName + " WHERE id = '" + stock.getId() + "'";
		Statement stmt;
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			System.out.println("Stock: " + stock.getId() + " deleted successfully from db");
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
			System.out.println("Stock: " + id + " deleted successfully from db");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Stock stock) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateById(String id) throws SQLException {
		// TODO Auto-generated method stub

	}
}
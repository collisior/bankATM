package database;

import java.sql.*;
import java.util.UUID;

import bankATM.*;

public class DBClient implements CRUDInterface<Client> {

	Connection conn = DataBaseConnection.getConnection();

	String tableName = "Clients";
	/*
	 * Client(String id, Person person, Date created, String email, String password)
	 */
	public static void main(String[] args) throws SQLException {
		DBClient testObj = new DBClient();
		String id = UUID.randomUUID().toString();
		Date date = new Date(2001, 12, 1);
		Person testPerson = new Person(id, "testName", "testLast", date, "000-test-phone", "testCity", "testCountry");

		id = UUID.randomUUID().toString();
		Client testClient = new Client(id, testPerson, date, "testEmail", "testPassword");

		testObj.create(testClient);
		testObj.delete(testClient);
	}

	/*
	 * Insert Account into database table Accounts.
	 */
	@Override
	public void create(Client client) throws SQLException {

		String sql = "INSERT INTO " + tableName + " (id, email, password, created, person_id) VALUES (?, ?, ?, ?, ?)";

		PreparedStatement statement = conn.prepareStatement(sql);

		statement.setString(1, client.getId());
		statement.setString(2, client.getEmail());
		statement.setString(3, client.getPassword());
		statement.setDate(4, client.getCreated());
		statement.setString(5, client.getPerson().getId());

		int rowsInserted = statement.executeUpdate();

		if (rowsInserted > 0) {
			System.out.println("A new Client was created successfully!");
		}

	}

	@Override
	public Client retrieve(Client client) throws SQLException {
		
		return client;
	}

	@Override
	public Client retrieveById(String id) throws SQLException {
		DBPerson dbPersonObj = new DBPerson();
		
		Client client = null;
		PreparedStatement statement = conn
				.prepareStatement("SELECT id, email, password, created, person_id from " + tableName);
		ResultSet resultSet = statement.executeQuery();

		while (resultSet.next()) {

			if (resultSet.getString("id").equals(id)) {
				Person person = dbPersonObj.retrieveById(resultSet.getString("person_id"));
				Date created = resultSet.getDate("created");
				String email = resultSet.getString("email");
				String password = resultSet.getString("password");

				client = new Client(id, person, created, email, password);
			}
		}
		if (client == null) {
			System.out.println("No person with id: " + id);
		} else {
			System.out.println("A client fetched successfully! Client: " + client);
		}
		return client;
	}

	@Override
	public void delete(Client client) throws SQLException {
		String sql = "DELETE FROM " + tableName + " WHERE id = '" + client.getId() + "'";
		Statement stmt;
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			System.out.println("Client: " + client.getId() + " deleted successfully from db");
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
			System.out.println("Client: " + id + " deleted successfully from db");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Client t) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateById(String id) throws SQLException {
		// TODO Auto-generated method stub

	}
}
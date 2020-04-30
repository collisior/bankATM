package database;

import java.sql.*;
import java.util.UUID;

import bankATM.*;
import manager.*;

public class DBManager implements CRUDInterface<Manager> {

	Connection conn = DataBaseConnection.getConnection();

	String tableName = "Managers";
	String columns = " id, person_id, email, password ";

	/*
	 * Client(String id, Person person, Date created, String email, String password)
	 */
	public static void main(String[] args) throws SQLException {
		DBManager testObj = new DBManager();
		String id = UUID.randomUUID().toString();
		Date date = new Date(2001, 12, 1);
		Person testPerson = new Person(id, "testName", "testLast", date, "000-test-phone", "testCity", "testCountry");

		id = UUID.randomUUID().toString();
		Manager testmanager = new Manager(id, testPerson, "testEmail", "testPassword");

		testObj.create(testmanager);
		testObj.retrieveById(id);
		testObj.delete(testmanager);
	}

	/*
	 * Insert Account into database table Accounts.
	 */
	@Override
	public void create(Manager manager) throws SQLException {
		String sql = "INSERT INTO " + tableName + columns + " VALUES (?, ?, ?, ?)";

		PreparedStatement statement = conn.prepareStatement(sql);

		statement.setString(1, manager.getId());
		statement.setString(2, manager.getPerson().getId());
		statement.setString(3, manager.getEmail());
		statement.setString(4, manager.getPassword());

		int rowsInserted = statement.executeUpdate();

		if (rowsInserted > 0) {
			System.out.println("A new Manager was created successfully!");
		}

	}

	@Override
	public Manager retrieve(Manager manager) throws SQLException {

		return manager;
	}

	@Override
	public Manager retrieveById(String id) throws SQLException {
		DBPerson dbPersonObj = new DBPerson();

		Manager manager = null;
		PreparedStatement statement = conn.prepareStatement("SELECT " + columns + " FROM " + tableName+ " WHERE id = '" + id + "';");
		ResultSet resultSet = statement.executeQuery();

		while (resultSet.next()) {

			if (resultSet.getString("id").equals(id)) {
				Person person = dbPersonObj.retrieveById(resultSet.getString("person_id"));
				String email = resultSet.getString("email");
				String password = resultSet.getString("password");

				manager = new Manager(id, person, email, password);
			}
		}
		if (manager == null) {
			System.out.println("No manager with id: " + id);
		} else {
			System.out.println("A manager fetched successfully! Client: " + manager);
		}
		return manager;
	}

	@Override
	public void delete(Manager manager) throws SQLException {
		String sql = "DELETE FROM " + tableName + " WHERE id = '" + manager.getId() + "'";
		Statement stmt;
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			System.out.println("Client: " + manager.getId() + " deleted successfully from db");
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
	public void update(Manager manager) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateById(String id) throws SQLException {
		// TODO Auto-generated method stub

	}


}
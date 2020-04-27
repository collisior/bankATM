package database;

import java.sql.*;
import java.util.UUID;

import bankATM.*;

public class dbPerson {

	static Connection con = DataBaseConnection.getConnection();

	static String tableName = "Person";

	public static void main(String[] args) throws SQLException {
		String id = UUID.randomUUID().toString();
		Date date = new Date(2001, 12, 1);
		Person testPerson = new Person(id, "testName", "testLast", date, "000-test-phone", "testCity", "testCountry");
		createPerson(testPerson);
		deletePerson(testPerson);
	}

	/*
	 * Insert Person into database table Person.
	 */
	public static void createPerson(Person person) throws SQLException {

		String sql = "INSERT INTO " + tableName
				+ " (id, first_name, last_name, birth_date, phone, city, country) VALUES (?, ?, ?, ?, ?, ?, ?)";

		PreparedStatement statement = con.prepareStatement(sql);

		statement.setString(1, person.getId());
		statement.setString(2, person.getFirstName());
		statement.setString(3, person.getLastName());
		statement.setDate(4, person.getBirthDate());
		statement.setString(5, person.getPhone());
		statement.setString(6, person.getCity());
		statement.setString(7, person.getCountry());

		int rowsInserted = statement.executeUpdate();

		if (rowsInserted > 0) {
			System.out.println("A new Person was created successfully!");
		}

	}

	public static Person getPersonById(String id) throws SQLException {
		Person person = null;
		PreparedStatement statement = con.prepareStatement("SELECT id, name, email from " + tableName);
		ResultSet resultSet = statement.executeQuery();

		while (resultSet.next()) {

			if (resultSet.getString("id").equals(id)) {
				String firstName = resultSet.getString("first_name");
				String lastName = resultSet.getString("last_name");
				Date birthDate = resultSet.getDate("birth_date");
				String phone = resultSet.getString("phone");
				String city = resultSet.getString("city");
				String country = resultSet.getString("country");

				person = new Person(id, firstName, lastName, birthDate, phone, city, country);
			}
		}
		if (person == null) {
			System.out.println("No person with id: " + id);
		} else {
			System.out.println("A person fetched successfully! Person: " + person);
		}
		return person;
	}

	public static void deletePersonById(String id) throws SQLException {
		String sql = "DELETE FROM " + tableName + " WHERE id = '" + id + "';";
		Statement stmt;
		try {
			stmt = con.createStatement();
			stmt.executeUpdate(sql);
			System.out.println("Person: " + id + " deleted successfully from db");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void deletePerson(Person person) throws SQLException {
		String sql = "DELETE FROM " + tableName + " WHERE id = '" + person.getId() + "'";
		Statement stmt;
		try {
			stmt = con.createStatement();
			stmt.executeUpdate(sql);
			System.out.println("Person: " + person.getId() + " deleted successfully from db");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

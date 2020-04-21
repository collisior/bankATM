package bankATM;

import java.util.*;

public class Person {
	private String firstName;
	private String lastName;
	private Date birthdayDate;
	private String address;
	private String phone;
	private String email; //also used as username

	Person(String firstName, String lastName, Date birthdayDate, String address, String phone, String email) {
		setFirstName(firstName);
		setLastName(lastName);
		setBirthdayDate(birthdayDate);
		setAddress(address);
		setPhone(phone);
		setEmail(email);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthdayDate() {
		return birthdayDate;
	}

	public void setBirthdayDate(Date birthdayDate) {
		this.birthdayDate = birthdayDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String toString() {
		return firstName + " " + lastName;
	}

}
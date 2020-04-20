package bankATM;

import java.util.*;
import java.time.*;

public class Customer {
	private Person person;
	private LocalDateTime createdOn;
	private String uuid;
	private String password;
	
	Customer(String firstName, String lastName, Date birthdayDate, String address, String phone, String email) {
		this.setPerson(new Person(firstName, lastName, birthdayDate, address, phone, email));
		this.setCreatedOn(LocalDateTime.now());
		this.setUuid(UUID.randomUUID().toString());
		/* 
		 * TODO:
		 * setPassword
		 */
	}
	
	public void setPerson(Person person) {
		this.person = person;
	}

	public Person getPerson() {
		return person;
	}
	
	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	private void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	public String getUuid() {
		return uuid;
	}

	private void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
}

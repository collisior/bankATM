package bankATM;

import java.sql.Date;

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

}

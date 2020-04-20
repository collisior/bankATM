package bankATM;

import java.time.*;
import java.util.*;

public class Transaction {
	
	private String id;
	private LocalDateTime createdOn;

	Transaction() {
		this.setId(UUID.randomUUID().toString());
		this.setCreatedOn(LocalDateTime.now());
	}

	public String getId() {
		return id;
	}

	private void setId(String id) {
		this.id = id;
	}

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	private void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}
	
}
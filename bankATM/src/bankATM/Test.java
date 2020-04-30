package bankATM;

import java.sql.*;
import java.util.UUID;

import account.*;
import database.*;
import manager.*;
import transaction.*;

public class Test {

	public String getId() {
		return UUID.randomUUID().toString();
	}

	public Date getDate() {
		Date date = new Date(2001, 12, 1);
		return date;
	}

	public Bank createBank() {
		Money checkingAccountFee = new Money(2222, Currency.USD);
		Money withdrawFee = new Money(2222, Currency.USD);
		float savingsInterest = (float) 0.1;
		float loansInterest = (float) 0.05;
		Money balance = new Money(2222, Currency.USD);
		Date currentDate = getDate();
		return new Bank("BANK ATM", checkingAccountFee, withdrawFee, savingsInterest, loansInterest, balance,
				currentDate);
	}

	public void generateTestObjects() {

		DBBank testObjDBBank = new DBBank();
		DBManager testObjDBManager = new DBManager();
		DBPerson testObjDBPerson = new DBPerson();
		DBClient testObjDBClient = new DBClient();
		DBAccount testObjDBAccount = new DBAccount();
		DBStocks testObjDBStocks = new DBStocks();
		DBSoldStocks testObjDBSoldStocks = new DBSoldStocks();
		DBPurchasedStocks testObjDBPurchasedStocks = new DBPurchasedStocks();
		DBTransaction testObjDBTransaction = new DBTransaction();

		String id = UUID.randomUUID().toString();

		Bank testBank = new Bank("testBank", new Money(2222, Currency.USD), new Money(2222, Currency.USD), (float) 1,
				(float) 2, new Money(2222, Currency.USD), getDate());

		Bank bank = createBank();
		Person personManager = new Person(getId(), "Camilla", "Satte", new Date(1998, 7, 1), "1234456789", "Boston",
				"US");
		Person personClient = new Person(getId(), "ManagerName", "ManagerLastName", new Date(1998, 7, 1), "1234456789",
				"Boston", "US");
		
//		Account account = new Deposit(  );
	}

	public static void main(String[] args) {

	}
}

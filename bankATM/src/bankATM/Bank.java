package bankATM;

import java.sql.Date;

import manager.*;

public class Bank {

	private String name;
	private Money checkingAccountFee;
	private Money withdrawFee;
	private float savingsInterest;
	private float loansInterest;
	private Money balance;
	private Date currentDate;

	public Bank(String name, Money checkingAccountFee, Money withdrawFee, float savingsInterest, float loansInterest,
			Money balance, Date currentDate) {
		setName(name);
		setCheckingAccountFee(checkingAccountFee);
		setWithdrawFee(withdrawFee);
		setSavingsInterest(savingsInterest);
		setLoansInterest(loansInterest);
		setBalance(balance);
		setCurrentDate(currentDate);
	}

	public String toString() {
		return null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Money getCheckingAccountFee() {
		return checkingAccountFee;
	}

	public void setCheckingAccountFee(Money checkingAccountFee) {
		this.checkingAccountFee = checkingAccountFee;
	}

	public Money getWithdrawFee() {
		return withdrawFee;
	}

	public void setWithdrawFee(Money withdrawFee) {
		this.withdrawFee = withdrawFee;
	}

	public float getSavingsInterest() {
		return savingsInterest;
	}

	public void setSavingsInterest(float savingsInterest) {
		this.savingsInterest = savingsInterest;
	}

	public float getLoansInterest() {
		return loansInterest;
	}

	public void setLoansInterest(float loansInterest) {
		this.loansInterest = loansInterest;
	}

	public Money getBalance() {
		return balance;
	}

	public void setBalance(Money balance) {
		this.balance = balance;
	}

	public Date getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}
}

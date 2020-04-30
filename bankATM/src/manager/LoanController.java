package manager;

import bankATM.*;
import account.*;

public interface LoanController {
	
	public abstract boolean approveLoan(Account account);
	
	public abstract Loan issueLoan(Account account);
	
}

package manager;

import account.Account;
import bankATM.Client;

public interface AccountController {
	
	public abstract boolean openAccount(Client client, Account account);
	
	public abstract boolean closeAccount(Account account);
	
	public abstract void collectMoneyFrom(Client client);
	
	public abstract void collectMoneyFromAll();
	
}

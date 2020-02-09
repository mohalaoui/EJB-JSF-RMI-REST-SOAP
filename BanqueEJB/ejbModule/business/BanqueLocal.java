package business;

import java.util.List;

import javax.ejb.Local;

import business.entities.Account;

@Local
public interface BanqueLocal {
	
	public Account addAccount(Account account);
	public Account getAccount(Long code);
	public List<Account> listAccount();
	public void debit(Long code, double amount);
	public void credit(Long code, double amount); 
	public void transfer(Long accountToDebit, Long accountReceiver, double amount);

}

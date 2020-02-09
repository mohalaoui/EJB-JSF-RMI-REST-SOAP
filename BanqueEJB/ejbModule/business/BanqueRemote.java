package business;

import java.util.List;

import javax.ejb.Remote;

import business.entities.Account;

@Remote
public interface BanqueRemote {
	
	public Account addAccount(Account account);
	public Account getAccount(Long code);
	public List<Account> listAccount();
	public void debit(Long code, double amount);
	public void credit(Long code, double amount); 
	public void transfer(Long accountToDebit, Long accountReceiver, double amount);

}

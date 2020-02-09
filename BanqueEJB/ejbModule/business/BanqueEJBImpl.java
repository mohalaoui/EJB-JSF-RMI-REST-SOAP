package business;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import business.entities.Account;

@Stateless(name = "banqueImpl")
public class BanqueEJBImpl implements BanqueLocal, BanqueRemote {
	
	@PersistenceContext(unitName = "BanqueEJB")
	EntityManager em;

	@Override
	public Account addAccount(Account account) {
		em.persist(account);
		return account;
	}

	@Override
	public Account getAccount(Long code) {
		Account account = em.find(Account.class, code);
		if(code==null)
			throw new RuntimeException("account not found");
		return account;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Account> listAccount() {
		Query req = em.createQuery("select c from Account c");
		return req.getResultList();
	}

	@Override
	public void debit(Long code, double amount) {
		Account account = getAccount(code);
		if(account.getSolde()<amount) throw new RuntimeException("insufficient solde");
		account.setSolde(account.getSolde()-amount);
		
	}

	@Override
	public void credit(Long code, double amount) {
		Account account = getAccount(code);
		account.setSolde(account.getSolde()+amount);
		
	}

	@Override
	public void transfer(Long AccountToDebit, Long AccountReceiver, double amount) {
		debit(AccountToDebit, amount);
		credit(AccountReceiver, amount);
		
	}

}

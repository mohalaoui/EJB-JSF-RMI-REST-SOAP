package service.soap;

import java.util.List;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import business.BanqueLocal;
import business.entities.Account;

@WebService
public class BanqueSOAPService {
	
	@EJB
	private BanqueLocal banqueEJBService;
	
	@WebMethod
	public void debit(@WebParam(name = "code") Long code, @WebParam(name = "amount") double amount) {
		banqueEJBService.debit(code, amount);
		
		
	}

	@WebMethod
	public void credit(@WebParam(name = "code") Long code, @WebParam(name = "amount") double amount) {
		banqueEJBService.credit(code, amount);
		
	}

	@WebMethod
	public void transfer(@WebParam(name = "accountFrom") Long accountToDebit,@WebParam(name = "accountTo") Long accountReceiver, @WebParam(name = "amount")double amount) {
		banqueEJBService.transfer(accountToDebit, accountReceiver, amount);
		
	}

	@WebMethod
	public Account addAccount(@WebParam(name = "account") Account account) {
		return banqueEJBService.addAccount(account);
	}

	@WebMethod
	public Account getAccount(@WebParam(name = "code")Long code) {
		return banqueEJBService.getAccount(code);
	}

	@WebMethod
	public List<Account> listAccount() {
		return banqueEJBService.listAccount();
	}

}

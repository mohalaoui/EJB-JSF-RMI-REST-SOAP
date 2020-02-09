package service.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import business.BanqueLocal;
import business.entities.Account;

@Stateless
@Path("/")
public class BanqueRestService {
	
	@EJB
	private BanqueLocal banqueEJBService;
	
	@PUT
	@Path("/accounts/debit")
	@Produces(MediaType.APPLICATION_JSON)
	public void debit(@FormParam("code") Long code, @FormParam("amount") double amount) {
		banqueEJBService.debit(code, amount);
	}

	@PUT
	@Path("/accounts/credit")
	@Produces(MediaType.APPLICATION_JSON)
	public void credit(@FormParam("code") Long code, @FormParam("amount") double amount) {
		banqueEJBService.credit(code, amount);
		
	}

	@PUT
	@Path("/accounts/transfer")
	@Produces(MediaType.APPLICATION_JSON)
	public void transfer(@FormParam("accountFrom") Long accountToDebit,@FormParam("accountTo") Long accountReceiver, @FormParam("amount")double amount) {
		banqueEJBService.transfer(accountToDebit, accountReceiver, amount);
		
	}

	@POST
	@Path("/accounts/account")
	@Produces(MediaType.APPLICATION_JSON)
	public Account addAccount(Account account) {
		return banqueEJBService.addAccount(account);
	}

	@GET
	@Path("/account/{code}")
	@Produces(MediaType.APPLICATION_JSON)
	public Account getAccount(@PathParam("code")Long code) {
		return banqueEJBService.getAccount(code);
	}

	@GET
	@Path("/accounts")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Account> listAccount() {
		return banqueEJBService.listAccount();
	}
}

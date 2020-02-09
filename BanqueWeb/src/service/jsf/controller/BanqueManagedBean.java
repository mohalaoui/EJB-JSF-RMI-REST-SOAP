package service.jsf.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import business.BanqueLocal;
import business.entities.Account;

@ManagedBean(name="banqueMB")
@RequestScoped
public class BanqueManagedBean {
	
	@EJB
	private BanqueLocal banqueService;
	private Long code1;
	private Long code2;
	private double amount;
	
	public String credit() {
		banqueService.credit(code1, amount);
		return "success";
	}

	public String debit() {
		banqueService.debit(code1, amount);
		return "success";
	}
	
	public String transfer() {
		banqueService.transfer(code1, code2, amount);
		return "success";
	}
	
	public String addAccount() {
		banqueService.addAccount(new Account());
		return "success";
	}
	
	public List<Account> getListAccounts(){
		return banqueService.listAccount();
	}

	public Long getCode1() {
		return code1;
	}

	public void setCode1(Long code1) {
		this.code1 = code1;
	}

	public Long getCode2() {
		return code2;
	}

	public void setCode2(Long code2) {
		this.code2 = code2;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
}

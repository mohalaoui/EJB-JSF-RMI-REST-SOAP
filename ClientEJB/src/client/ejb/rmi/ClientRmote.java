package client.ejb.rmi;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import business.BanqueRemote;
import business.entities.Account;

public class ClientRmote {

	public static void main(String[] args) {
		try {
			Context context = new InitialContext();
			BanqueRemote proxy = (BanqueRemote) context.lookup("ejb:/BanqueEAR/BanqueEJB/banqueImpl!business.BanqueRemote");
			
			proxy.addAccount(new Account());
			proxy.addAccount(new Account());
			
			proxy.credit(1L, 300);
			System.out.println(proxy.getAccount(1L).getSolde());
			proxy.transfer(1L, 2L, 200);
			System.out.println("after transfer "+proxy.getAccount(1L).getSolde());
			System.out.println(proxy.getAccount(2L).getSolde());
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

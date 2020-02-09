package business.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Entity implementation class for Entity: account
 *
 */
@Entity

public class Account implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long code;
	private double solde;
	private LocalDateTime dateCreation = LocalDateTime.now();
	private static final long serialVersionUID = 1L;

	public Account() {
		super();
	}   
	public Long getCode() {
		return this.code;
	}

	public void setCode(Long code) {
		this.code = code;
	}   
	public double getSolde() {
		return this.solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}   
	public LocalDateTime getDateCreation() {
		return this.dateCreation;
	}

	public void setDateCreation(LocalDateTime dateCreation) {
		this.dateCreation = dateCreation;
	}
   
}

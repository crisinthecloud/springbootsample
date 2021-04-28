package es.cga.sbsample.model.modelsbsample;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DtoClient {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	  
	private String firstname;
	private String lastname;
	private BigDecimal credit;
	  
	public String getFirstname() {
		return firstname;
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public void setFirstname(String firstName) {
		this.firstname = firstName;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public void setLastname(String lastName) {
		this.lastname = lastName;
	}

	public BigDecimal getCredit() {
		return credit;
	}

	public void setCredit(BigDecimal credit) {
		this.credit = credit;
	}

}

package es.cga.sbsample.model.modelsbsample;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class DtoAccount {
	
	public DtoClient getDtoClient() {
		return dtoClient;
	}

	public void setDtoClient(DtoClient dtoClient) {
		this.dtoClient = dtoClient;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private BigDecimal amount;
	
	@ManyToOne
	private DtoClient dtoClient;

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

}

package es.cga.sbsample.srv.srvaccount.service.createaccount.in;

import java.math.BigDecimal;

public class Client {

	private String name;
	private String surname;
	
	//financial numbers never are float, double
	private BigDecimal credit;

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public BigDecimal getCredit() {
		return credit;
	}

	public void setCredit(BigDecimal credit) {
		this.credit = credit;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

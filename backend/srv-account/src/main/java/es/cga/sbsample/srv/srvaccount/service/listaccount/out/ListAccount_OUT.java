package es.cga.sbsample.srv.srvaccount.service.listaccount.out;

import java.util.List;

import es.cga.sbsample.model.modelsbsample.DtoAccount;

public class ListAccount_OUT {
	
	private List<DtoAccount> accounts;

	public List<DtoAccount> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<DtoAccount> accounts) {
		this.accounts = accounts;
	}

}

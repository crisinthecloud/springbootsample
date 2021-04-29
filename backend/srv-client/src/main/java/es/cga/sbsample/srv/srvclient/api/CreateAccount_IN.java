package es.cga.sbsample.srv.srvclient.api;

import es.cga.sbsample.model.modelsbsample.DtoAccount;

/**
 * API Object to access srv-account.CreateAccount.
 * @author cris
 *
 */
public class CreateAccount_IN {
	
	private DtoAccount dtoAccount;

	public DtoAccount getDtoAccount() {
		return dtoAccount;
	}

	public void setDtoAccount(DtoAccount dtoAccount) {
		this.dtoAccount = dtoAccount;
	}

}

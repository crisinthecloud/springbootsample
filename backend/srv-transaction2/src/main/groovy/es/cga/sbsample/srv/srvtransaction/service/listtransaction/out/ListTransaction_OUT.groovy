package es.cga.sbsample.srv.srvtransaction.service.listtransaction.out;

import java.util.List;

import es.cga.sbsample.model.modelsbsample.DtoTransaction;

public class ListTransaction_OUT {
	
	private List<DtoTransaction> transactions;

	public List<DtoTransaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<DtoTransaction> transactios) {
		this.transactions = transactios;
	}

}

package es.cga.sbsample.srv.srvclient.service.listclient.out;

import java.util.List;

import es.cga.sbsample.model.modelsbsample.DtoClient;

public class ListClient_OUT {
	
	private List<DtoClient> clients;

	public List<DtoClient> getClients() {
		return clients;
	}

	public void setClients(List<DtoClient> clients) {
		this.clients = clients;
	}

}

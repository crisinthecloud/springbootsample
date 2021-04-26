package es.cga.sbsample.srv.srvclient.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;


import es.cga.sbsample.srv.srvclient.service.createclient.CreateClientCommand;
import es.cga.sbsample.srv.srvclient.service.createclient.in.CreateClient_IN;
import es.cga.sbsample.srv.srvclient.service.createclient.out.CreateClient_OUT;
import es.cga.sbsample.srv.srvclient.service.listclient.ListClientCommand;
import es.cga.sbsample.srv.srvclient.service.listclient.out.ListClient_OUT;
import es.cga.sbsample.util.utilsbsample.AppException;
import es.cga.sbsample.util.utilsbsample.AppMetadata;


@Validated
//Transactional(propagation = Propagation.REQUIRED, rollbackFor = TE_Excepcion.class)
@Service
public class ClientService {

	@Autowired
    private CreateClientCommand createClientCommand;

	@Autowired
    private ListClientCommand listClientCommand;

	public ListClient_OUT listClient(AppMetadata metadata) throws AppException {
		return listClientCommand.execute(metadata);
	}

	public CreateClient_OUT createClient(CreateClient_IN in) {
		return createClientCommand.execute(in);
	}

	
/* ===== Rest of the RESTFull AP
    @Autowired
    private DeleteClientCommand deleteClientCommand;

    @Autowired
    private GetClientCommand getClientCommand;

    @Autowired
    private UpdateClientCommand updateArtifactSWCommand;
*/
	
	
	
}

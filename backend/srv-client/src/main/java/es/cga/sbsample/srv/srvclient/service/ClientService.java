package es.cga.sbsample.srv.srvclient.service;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

/**
 * Service for the entity. This service is based on the 
 * Command pattern. Every operation has its own command 
 * to serve it. Each comand isolates in a package all
 * classes involved in that command.
 * @author cris
 *
 */
@Validated
//Transactional(propagation = Propagation.REQUIRED, rollbackFor = TE_Excepcion.class)
@Service
public class ClientService {

	@Autowired
    private CreateClientCommand createClientCommand;

	@Autowired
	private ListClientCommand listClientCommand;
	
	//Sample variable externalized via command line argument / properties
	@Value(value = "${es.cga.username:myusername}")
	private String username;

	
	/**
	 * This method runs after creating beans and injecting values to Spring properties.
	 * You can use this kind of methods to check configuration at runtime. <br>
	 * 
	 * This method test a property defined in source code <br>
	 * - if no command line argument --es.cga.username=newusername, default
	 *   value myusername will be used.<br>
	 *   -if run with <code>java -Dspring.profiles.active=dev -jar .\target\srv-client-1.0.0-SNAPSHOT.jar --es.cga.username=newuser</code>,
	 *    the newuser value will be used.<br>
	 *   - you can also add this property to the application.yml or application-dev.yml 
	 *   properties file. In this case, properties will be inside the jar file. Then you change propeties selecting the right Spring Boot profile.
	 */
	@PostConstruct
	public void init() {
		System.out.println("###############");
		System.out.println("### Spring boot environment configured and properties loaded.");
		System.out.println("### sample property user: " + username);
		
	}
	
	
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

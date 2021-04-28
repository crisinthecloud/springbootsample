package es.cga.sbsample.srv.srvclient.service.createclient;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.cga.sbsample.model.modelsbsample.DtoClient;
import es.cga.sbsample.repository.DtoClientRepository;
import es.cga.sbsample.srv.srvclient.service.createclient.in.CreateClient_IN;
import es.cga.sbsample.srv.srvclient.service.createclient.out.CreateClient_OUT;
import es.cga.sbsample.srv.srvclient.service.listclient.ListClientMapper;

@Component
public class CreateClientCommand {
	
    private static final Logger logger = LoggerFactory.getLogger(CreateClientCommand.class);

    @Autowired
    private DtoClientRepository dtoClientRepository;
    
    @Autowired
    private CreateClientMapper mapper;

	public CreateClient_OUT execute(CreateClient_IN in) {
		logger.debug("=== Create Client");
		
		DtoClient dtoClient = mapper.toDtoClient(in.getClient());
		
		dtoClientRepository.save(dtoClient);
		
		if (dtoClient.getCredit().compareTo(BigDecimal.ZERO) > 0) {
			//create an account and a transaction
			logger.debug("=== Create an account");
		}
		
		return null;
	}

}

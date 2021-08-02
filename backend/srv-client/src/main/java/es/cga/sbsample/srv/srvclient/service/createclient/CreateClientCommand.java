package es.cga.sbsample.srv.srvclient.service.createclient;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import es.cga.sbsample.model.modelsbsample.DtoAccount;
import es.cga.sbsample.model.modelsbsample.DtoClient;
import es.cga.sbsample.repository.DtoClientRepository;
import es.cga.sbsample.srv.srvclient.api.CreateAccount_IN;
import es.cga.sbsample.srv.srvclient.api.CreateAccount_OUT;
import es.cga.sbsample.srv.srvclient.service.createclient.in.Client;
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
    

    @Value("${es.cga.srv-account.createurl:http://localhost:9092/resources/accounts}")
    private String createAccountResourceUrl;
    
	public CreateClient_OUT execute(CreateClient_IN in) {
		logger.debug("=== Create Client {}", mapper.hashCode());
				
		DtoClient dtoClient = mapper.toDtoClient(in.getClient());
		
		dtoClient = dtoClientRepository.save(dtoClient);
		logger.debug("=== new client {}", dtoClient.getId());
		
		if (dtoClient.getCredit().compareTo(BigDecimal.ZERO) > 0) {
			//create an account and a transaction
			logger.debug("=== Create an account");
			
			RestTemplate restTemplate = new RestTemplate();
			
			//. Prepara arguments for request
			CreateAccount_IN createAccountIn = new CreateAccount_IN();
			DtoAccount dtoAccount = new DtoAccount();
			dtoAccount.setAmount(in.getClient().getCredit());
			dtoAccount.setDtoClient(dtoClient);
			createAccountIn.setDtoAccount(dtoAccount);
			
			HttpEntity<CreateAccount_IN> request = new HttpEntity<>(createAccountIn);
			logger.debug("url:[{}]}", createAccountResourceUrl);
			//TODO move to a utility method that throws AppException on error
			ResponseEntity<CreateAccount_OUT> response = restTemplate.exchange(createAccountResourceUrl,
					HttpMethod.POST, 
					request, 
					CreateAccount_OUT.class);
			logger.debug("=== response status {}", response.getStatusCode());
			
		}
		CreateClient_OUT out = new CreateClient_OUT();
		out.setId(dtoClient.getId());
		return out;
	}

}

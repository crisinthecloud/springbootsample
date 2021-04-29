package es.cga.sbsample.srv.srvaccount.service.createaccount;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

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
import es.cga.sbsample.model.modelsbsample.DtoTransaction;
import es.cga.sbsample.repository.DtoAccountRepository;
import es.cga.sbsample.repository.DtoClientRepository;
import es.cga.sbsample.srv.srvaccount.api.CreateTransaction_IN;
import es.cga.sbsample.srv.srvaccount.service.createaccount.in.CreateAccount_IN;
import es.cga.sbsample.srv.srvaccount.service.createaccount.out.CreateAccount_OUT;
import es.cga.sbsample.util.utilsbsample.AppException;
import es.cga.sbsample.util.utilsbsample.Validation;

@Component
public class CreateAccountCommand {
	
    private static final Logger logger = LoggerFactory.getLogger(CreateAccountCommand.class);

    @Autowired
    private DtoAccountRepository dtoAccountRepository;
    
    @Autowired
    private DtoClientRepository dtoClientRepository;
        
    @Autowired
    private CreateAccountMapper mapper;

    @Value("${es.cga.srv-account.createurl:http://localhost:9093/resources/transactions}")
    String createTransactionResourceUrl;
    
	public CreateAccount_OUT execute(CreateAccount_IN in) throws AppException {
		logger.debug("=== Create Account");
		
		//. Recovers arguments
		DtoAccount dtoAccount = in.getDtoAccount();		
		
		//. Do validation and other logic
		// "in" must be validates. Usually with AOP validation.
		Long idClient = in.getDtoAccount().getDtoClient().getId();
		Validation.notNullArgument(in, "client id mus not be empty");
		
		
		//TODO This code is always the same: given an entity and a repository
		// retrieve it or create a new one. This must go in a utility class DaoUtils
		logger.debug("=== Get the client");
		Optional<DtoClient> optionalDto = dtoClientRepository.findById(idClient);
		DtoClient dtoClient = null;
		if (optionalDto.isPresent()) {
			dtoClient = optionalDto.get();
			logger.debug("=== client exists {}", idClient);
		} else {
			dtoClient = dtoClientRepository.save(in.getDtoAccount().getDtoClient());
			logger.debug("=== new client  {}", idClient);
		}
		
		logger.debug("=== add the client");
		dtoAccount.setDtoClient(dtoClient);
		
		dtoAccountRepository.save(dtoAccount);
		
		if (dtoAccount.getAmount().compareTo(BigDecimal.ZERO) > 0) {
			logger.debug("=== Create a transaction");
			
			RestTemplate restTemplate = new RestTemplate();
			
			//. Prepara arguments for request
			CreateTransaction_IN createTransactionIn = new CreateTransaction_IN(); 
			DtoTransaction dtoTransaction = new DtoTransaction();
			dtoTransaction.setAmount(dtoAccount.getAmount());
			dtoTransaction.setDtoAccount(dtoAccount);
			dtoTransaction.setDate(new Date());
			dtoTransaction.setType("IN");
			createTransactionIn.setDtoTransaction(dtoTransaction);
			
			HttpEntity<CreateTransaction_IN> request = new HttpEntity<>(createTransactionIn);
			logger.debug("url:[{}]}", createTransactionResourceUrl);
			//TODO move to a utility method that throws AppException on error
			ResponseEntity<CreateAccount_OUT> response = restTemplate.exchange(createTransactionResourceUrl,
					HttpMethod.POST, 
					request, 
					CreateAccount_OUT.class);
			logger.debug("=== response status {}", response.getStatusCode());
			
		}
		
		logger.debug("=== CreteAccount end");
		
		return null;
	}

}

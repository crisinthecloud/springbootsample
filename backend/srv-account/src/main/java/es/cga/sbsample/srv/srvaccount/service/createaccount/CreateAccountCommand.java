package es.cga.sbsample.srv.srvaccount.service.createaccount;

import java.math.BigDecimal;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.cga.sbsample.model.modelsbsample.DtoAccount;
import es.cga.sbsample.model.modelsbsample.DtoClient;
import es.cga.sbsample.repository.DtoAccountRepository;
import es.cga.sbsample.repository.DtoClientRepository;
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
		}
		
		logger.debug("=== CreteAccount end");
		
		return null;
	}

}

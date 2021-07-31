package es.cga.sbsample.srv.srvtransaction.service.createtransaction;

import java.math.BigDecimal;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.cga.sbsample.model.modelsbsample.DtoAccount;
import es.cga.sbsample.model.modelsbsample.DtoClient;
import es.cga.sbsample.model.modelsbsample.DtoTransaction;
import es.cga.sbsample.repository.DtoAccountRepository;
import es.cga.sbsample.repository.DtoClientRepository;
import es.cga.sbsample.repository.DtoTransactionRepository;
import es.cga.sbsample.srv.srvtransaction.service.createtransaction.in.CreateTransaction_IN;
import es.cga.sbsample.srv.srvtransaction.service.createtransaction.out.CreateTransaction_OUT;
import es.cga.sbsample.util.utilsbsample.AppException;
import es.cga.sbsample.util.utilsbsample.Validation;

@Component
public class CreateTransactionCommand {
	
    private static final Logger logger = LoggerFactory.getLogger(CreateTransactionCommand.class);

    @Autowired
    private DtoTransactionRepository dtoTransactionRepository;
    
    @Autowired
    private DtoClientRepository dtoClientRepository;
      
    @Autowired
    private DtoAccountRepository dtoAccountRepository;
      
    @Autowired
    private CreateTransactionMapper mapper;

    /**
     * Exxecutes the command.
     * @param in
     * @return
     * @throws AppException
     */
	public CreateTransaction_OUT execute(CreateTransaction_IN in) throws AppException {
		logger.debug("=== Create Transaction");
		
		//. Recovers arguments
		DtoTransaction dtoTransaction = in.getDtoTransaction();		
		
		//. Do validation and other logic
		// "in" must be validates. Usually with AOP validation.
		Long idAccount = in.getDtoTransaction().getDtoAccount().getId();
		Validation.notNullArgument(idAccount, "Accpimt id mus not be empty");
		
		Long idClient = in.getDtoTransaction().getDtoAccount().getDtoClient().getId();
		Validation.notNullArgument(idClient, "client id mus not be empty");
		
		
		//TODO This code is always the same: given an entity and a repository
		// retrieve it or create a new one. This must go in a utility class DaoUtils
		logger.debug("=== Get the client");
		Optional<DtoClient> optionalDto = dtoClientRepository.findById(idClient);
		DtoClient dtoClient = null;
		if (optionalDto.isPresent()) {
			dtoClient = optionalDto.get();
			logger.debug("=== client exists {}", idClient);
		} else {
			dtoClient = dtoClientRepository.save(in.getDtoTransaction().getDtoAccount().getDtoClient());
			logger.debug("=== new client  {}", idClient);
		}
		
		//Replaces the in.transaction.account.client for the dto
		//connected to the DB
		in.getDtoTransaction().getDtoAccount().setDtoClient(dtoClient);
		
		//TODO This code is always the same: given an entity and a repository
		// retrieve it or create a new one. This must go in a utility class DaoUtils
		logger.debug("=== Get the account");
		Optional<DtoAccount> optionalDtoAccount = dtoAccountRepository.findById(idClient);
		final DtoAccount dtoAccount;
		if (optionalDtoAccount.isPresent()) {
			dtoAccount = optionalDtoAccount.get();
			logger.debug("=== account exists {}", idAccount);
		} else {
			dtoAccount = dtoAccountRepository.save(in.getDtoTransaction().getDtoAccount());
			logger.debug("=== new account  {}", idAccount);
		}
		
		//Replaces the in.transaction.account for the dto
		//connected to the DB
		in.getDtoTransaction().setDtoAccount(dtoAccount);
		
		//TODO do the transaction stuff
		
		dtoTransactionRepository.save(dtoTransaction);
		
		logger.debug("=== CreteTransaction end");
		
		return null;
	}

}

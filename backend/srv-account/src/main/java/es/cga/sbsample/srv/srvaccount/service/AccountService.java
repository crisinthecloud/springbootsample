package es.cga.sbsample.srv.srvaccount.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import es.cga.sbsample.srv.srvaccount.service.createaccount.CreateAccountCommand;
import es.cga.sbsample.srv.srvaccount.service.createaccount.in.CreateAccount_IN;
import es.cga.sbsample.srv.srvaccount.service.createaccount.out.CreateAccount_OUT;
import es.cga.sbsample.srv.srvaccount.service.listaccount.ListAccountCommand;
import es.cga.sbsample.srv.srvaccount.service.listaccount.out.ListAccount_OUT;
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
public class AccountService {

	@Autowired
    private CreateAccountCommand createAccountCommand;

	@Autowired
    private ListAccountCommand listAccountCommand;

	public ListAccount_OUT listAccount(AppMetadata metadata) throws AppException {
		return listAccountCommand.execute(metadata);
	}

	public CreateAccount_OUT createAccount(CreateAccount_IN in) throws AppException {
		return createAccountCommand.execute(in);
	}

	
/* ===== Rest of the RESTFull AP
    @Autowired
    private DeleteAccountCommand deleteAccountCommand;

    @Autowired
    private GetAccountCommand getAccountCommand;

    @Autowired
    private UpdateAccountCommand updateArtifactSWCommand;
*/
	
	
	
}

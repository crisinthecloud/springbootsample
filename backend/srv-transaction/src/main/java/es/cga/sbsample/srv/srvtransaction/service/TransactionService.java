package es.cga.sbsample.srv.srvtransaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import es.cga.sbsample.srv.srvtransaction.service.createtransaction.CreateTransactionCommand;
import es.cga.sbsample.srv.srvtransaction.service.createtransaction.in.CreateTransaction_IN;
import es.cga.sbsample.srv.srvtransaction.service.createtransaction.out.CreateTransaction_OUT;
import es.cga.sbsample.srv.srvtransaction.service.listtransaction.ListTransactionCommand;
import es.cga.sbsample.srv.srvtransaction.service.listtransaction.out.ListTransaction_OUT;
import es.cga.sbsample.util.utilsbsample.AppException;
import es.cga.sbsample.util.utilsbsample.AppMetadata;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
/**
 * Service for the entity. This service is based on the 
 * Command pattern. Every operation has its own command 
 * to serve it. Each comand isolates in a package all
 * classes involved in that command.
 * @author cris
 *
 */
@Validated
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = AppException.class)
@Service
public class TransactionService {

	@Autowired
    private CreateTransactionCommand createTransactionCommand;

	@Autowired
    private ListTransactionCommand listTransactionCommand;

	public ListTransaction_OUT listTransaction(AppMetadata metadata) throws AppException {
		return listTransactionCommand.execute(metadata);
	}

	public CreateTransaction_OUT createTransaction(CreateTransaction_IN in) throws AppException {
		return createTransactionCommand.execute(in);
	}

	
/* ===== Rest of the RESTFull AP
    @Autowired
    private DeleteTransactionCommand deleteTransactionCommand;

    @Autowired
    private GetTransactionCommand getTransactionCommand;

    @Autowired
    private UpdateTransactionCommand updateTransactionCommand;
*/
	
	
	
}

package es.cga.sbsample.srv.srvtransaction.service.listtransaction;

import es.cga.sbsample.util.utilsbsample.OrderEnum;

/**
 * Possible ordenation criterias for the LisAccount operation.
 * @author cris
 *
 */
public enum ListTransactionOrder implements OrderEnum {
	
	//TODO Will have properties to support Spirng Data Sort
	NAME_ASC,
	SURNAME_ASC;

}

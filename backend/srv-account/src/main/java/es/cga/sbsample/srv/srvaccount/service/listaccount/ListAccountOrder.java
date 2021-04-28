package es.cga.sbsample.srv.srvaccount.service.listaccount;

import es.cga.sbsample.util.utilsbsample.OrderEnum;

/**
 * Possible ordenation criterias for the LisAccount operation.
 * @author cris
 *
 */
public enum ListAccountOrder implements OrderEnum {
	
	NAME,
	SURNAME;

}

package es.cga.sbsample.util.utilsbsample;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Order;


public class MetadataUtils {

	/**
	 * Get a filter EQ criteria from the "filters" parameter, that represents a 
	 * list of filters in the form filters=filter1.eq.value,filter2.op.value,...
	 * @param metadata
	 * @param string
	 * @return
	 */
	public static String getFilterEqValue(AppMetadata metadata, String string) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Get pagination data from the parameters of the request.
	 * @param metadata
	 * @return
	 */
	public static Pageable getPageable(AppMetadata metadata) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Obtains the ordering datra from the request method arguments.
	 * @param metadata
	 * @param orderEnumType
	 * @return
	 */
	public static Order getOrder(AppMetadata metadata, Class<? extends OrderEnum> orderEnumType) {
		// TODO Auto-generated method stub
		return null;
	}

}

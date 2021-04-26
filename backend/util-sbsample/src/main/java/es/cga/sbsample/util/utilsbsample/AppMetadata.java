package es.cga.sbsample.util.utilsbsample;


/** Applicaton or Request metadata. This class
 * stores values injected by the framework.
 * @author cris
 *
 */
public class AppMetadata {

	/** User ID of the request. Injected by the authentication Service */
	private String userId;

	
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}

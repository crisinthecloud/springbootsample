package es.cga.sbsample.util.utilsbsample;


/** Applicaton or Request metadata. This class
 * stores values injected by the framework.
 * @author cris
 *
 */
public class AppMetadata {

	public static class Filter {
		private String name;
		private String op;
		private String value;
		
		public String getOp() {
			return op;
		}
		public void setOp(String op) {
			this.op = op;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
		
		
	}
	
	/** User ID of the request. Injected by the authentication Service */
	private String userId;

	private Filter[] filters;
	
	public static AppMetadata get(String filters) {
		AppMetadata metadata = new AppMetadata();
		// TODO code to parse filters from filtername.op.value to 
		// Filters[]
		return metadata;
	}

	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	
	public Filter[] getFilters() {
		return filters;
	}

	public void setFilters(Filter[] filters) {
		this.filters = filters;
	}
}

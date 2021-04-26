package es.cga.sbsample.util.utilsbsample;

/**
 * General Application exception. 
 * Every Exception catched or uncatched must be represented as
 * this exception, to give a good response through standar REST response.
 * @author cris
 *
 */
public class AppException extends Exception {
	private static final long serialVersionUID = 1L;
	
	private AppExceptionType type;
	
	private String msg;
	
	private Throwable cause;
	
	public AppException(AppExceptionType type, String msg) {
		this.type = type;
		this.msg = msg;
	}

	public AppException(AppExceptionType type, String msg, Throwable cause) {
		this.type = type;
		this.msg = msg;
		this.cause = cause;
	}
	
	public String getMsg() {
		return msg;
	}

	public Throwable getE() {
		return cause;
	}

	public AppExceptionType getType() {
		return type;
	}

	public Throwable getCause() {
		return cause;
	}


}

package es.cga.sbsample.util.utilsbsample;

/**
 * Common application validations.
 * @author cris
 *
 */
public class Validation {

	/**
	 * Validates an argument. If null, throws an AppException.
	 * @param o
	 * @param msg
	 * @throws AppException
	 */
	public static void notNullArgument(Object o, String msg) throws AppException {
		if (o == null) {
			throw new AppException(AppExceptionType.BAD_ARGUMENTS,  msg);
		}
	}
}

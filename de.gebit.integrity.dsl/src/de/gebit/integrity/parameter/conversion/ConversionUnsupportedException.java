/**
 * 
 */
package de.gebit.integrity.parameter.conversion;

/**
 * Thrown if a certain requested conversion is not supported, because no matching {@link TargetedConversion} was found.
 * 
 * 
 * @author Rene Schneider
 * 
 */
public class ConversionUnsupportedException extends ConversionException {

	/**
	 * Serial Version.
	 */
	private static final long serialVersionUID = 666385391912314000L;

	/**
	 * Instantiates a new conversion unsupported exception.
	 * 
	 * @param aSourceType
	 *            the a source type
	 * @param aTargetType
	 *            the a target type
	 * @param aMessage
	 *            the a message
	 * @param aCause
	 *            the a cause
	 */
	public ConversionUnsupportedException(Class<?> aSourceType, Class<?> aTargetType, String aMessage, Throwable aCause) {
		super(aSourceType, aTargetType, aMessage, aCause);
	}

	/**
	 * Instantiates a new conversion unsupported exception.
	 * 
	 * @param aSourceType
	 *            the a source type
	 * @param aTargetType
	 *            the a target type
	 * @param aMessage
	 *            the a message
	 */
	public ConversionUnsupportedException(Class<?> aSourceType, Class<?> aTargetType, String aMessage) {
		super(aSourceType, aTargetType, aMessage);
	}

	@Override
	public String getMessage() {
		return "Unsupported conversion: " + super.getMessage();
	}

}

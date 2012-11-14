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
public class ConversionFailedException extends ConversionException {

	/**
	 * Serial Version.
	 */
	private static final long serialVersionUID = 2394358953404897646L;

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
	public ConversionFailedException(Class<?> aSourceType, Class<?> aTargetType, String aMessage, Throwable aCause) {
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
	public ConversionFailedException(Class<?> aSourceType, Class<?> aTargetType, String aMessage) {
		super(aSourceType, aTargetType, aMessage);
	}

	@Override
	public String getMessage() {
		return "Conversion from '" + getSourceType().getName() + "' to '" + getTargetType().getName() + "' failed"
				+ (super.getMessage() != null ? ": " + super.getMessage() : "");
	}

}

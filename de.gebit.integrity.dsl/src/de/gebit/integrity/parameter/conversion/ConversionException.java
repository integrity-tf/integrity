/**
 * 
 */
package de.gebit.integrity.parameter.conversion;

/**
 * Base class for conversion-related exceptions.
 * 
 * @author Rene Schneider
 * 
 */
public class ConversionException extends RuntimeException {

	/**
	 * Serial Version.
	 */
	private static final long serialVersionUID = -8763737012577729584L;

	/** The source type. */
	private Class<?> sourceType;

	/** The target type. */
	private Class<?> targetType;

	/**
	 * Instantiates a new conversion exception.
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
	public ConversionException(Class<?> aSourceType, Class<?> aTargetType, String aMessage, Throwable aCause) {
		super(aMessage, aCause);
		sourceType = aSourceType;
		targetType = aTargetType;
	}

	/**
	 * Instantiates a new conversion exception.
	 * 
	 * @param aSourceType
	 *            the a source type
	 * @param aTargetType
	 *            the a target type
	 * @param aMessage
	 *            the a message
	 */
	public ConversionException(Class<?> aSourceType, Class<?> aTargetType, String aMessage) {
		super(aMessage);
		sourceType = aSourceType;
		targetType = aTargetType;
	}

	public Class<?> getSourceType() {
		return sourceType;
	}

	public Class<?> getTargetType() {
		return targetType;
	}

	@Override
	public String getMessage() {
		return "Failed to convert from '" + sourceType.getName() + "' to '" + targetType.getName() + "': "
				+ super.getMessage();
	}

}

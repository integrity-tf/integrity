/**
 * 
 */
package de.gebit.integrity.parameter.conversion;

/**
 * A {@link UntargetedConversion} defines a transformation from one type into any unspecified other type. If one of
 * these is defined for a type, it is always used.
 * 
 * @param <FROM>
 * @author Rene Schneider
 * 
 */
public interface UntargetedConversion<FROM extends Object> extends Conversion {

	/**
	 * Performs the conversion.
	 * 
	 * @param aSource
	 *            the source object to convert
	 * @param aTargetType
	 *            the given target type for the conversion
	 * @return the converted object
	 */
	Object convert(FROM aSource, Class<?> aTargetType);

}

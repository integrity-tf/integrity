/**
 * A default Integrity conversion. 
 */
package de.gebit.integrity.parameter.conversion.conversions.java.other;

import de.gebit.integrity.parameter.conversion.TargetedConversion;

/**
 * A default Integrity conversion. 
 * 
 * @author Rene Schneider
 * 
 */
public class ObjectToString implements TargetedConversion<Object, String> {

	@Override
	public String convert(Object aSource) {
		return aSource.toString();
	}

	@Override
	public int getPriority() {
		return Integer.MIN_VALUE;
	}

}

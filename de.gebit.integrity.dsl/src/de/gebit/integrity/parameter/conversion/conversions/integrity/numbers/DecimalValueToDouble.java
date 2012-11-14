/**
 * A default Integrity conversion. 
 */
package de.gebit.integrity.parameter.conversion.conversions.integrity.numbers;

import de.gebit.integrity.dsl.DecimalValue;
import de.gebit.integrity.parameter.conversion.TargetedConversion;

/**
 * A default Integrity conversion. 
 * 
 * @author Rene Schneider
 * 
 */
public class DecimalValueToDouble implements TargetedConversion<DecimalValue, Double> {

	@Override
	public Double convert(DecimalValue aSource) {
		return aSource.getDecimalValue().doubleValue();
	}

	@Override
	public int getPriority() {
		return 0;
	}

}

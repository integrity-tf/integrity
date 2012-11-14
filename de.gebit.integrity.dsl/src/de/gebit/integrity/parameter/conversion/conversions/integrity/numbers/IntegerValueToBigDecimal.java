/**
 * A default Integrity conversion. 
 */
package de.gebit.integrity.parameter.conversion.conversions.integrity.numbers;

import java.math.BigDecimal;

import de.gebit.integrity.dsl.IntegerValue;
import de.gebit.integrity.parameter.conversion.TargetedConversion;

/**
 * A default Integrity conversion. 
 * 
 * @author Rene Schneider
 * 
 */
public class IntegerValueToBigDecimal implements TargetedConversion<IntegerValue, BigDecimal> {

	@Override
	public BigDecimal convert(IntegerValue aSource) {
		return new BigDecimal(aSource.getIntegerValue(), 0);
	}

	@Override
	public int getPriority() {
		return Integer.MIN_VALUE;
	}

}

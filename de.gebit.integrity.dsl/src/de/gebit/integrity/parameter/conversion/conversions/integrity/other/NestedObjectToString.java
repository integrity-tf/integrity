/**
 * A default Integrity conversion. 
 */
package de.gebit.integrity.parameter.conversion.conversions.integrity.other;

import java.util.Map;

import com.google.inject.Inject;

import de.gebit.integrity.dsl.KeyValuePair;
import de.gebit.integrity.dsl.NestedObject;
import de.gebit.integrity.operations.OperationWrapper.UnexecutableException;
import de.gebit.integrity.parameter.conversion.ConversionFailedException;
import de.gebit.integrity.parameter.conversion.TargetedConversion;
import de.gebit.integrity.parameter.conversion.UnresolvableVariableHandling;
import de.gebit.integrity.parameter.conversion.ValueConverter;

/**
 * A default Integrity conversion.
 * 
 * @author Rene Schneider
 * 
 */
public class NestedObjectToString implements TargetedConversion<NestedObject, String> {

	/**
	 * The value converter used for recursive conversion and resolution of inner nested objects.
	 */
	@Inject
	private ValueConverter valueConverter;

	@Override
	public String convert(NestedObject aSource, UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy)
			throws ConversionFailedException {
		StringBuilder tempBuilder = new StringBuilder();
		for (KeyValuePair tempAttribute : aSource.getAttributes()) {
			Object tempConvertedValue;
			try {
				tempConvertedValue = valueConverter.convertEncapsulatedValueCollectionToParamType(String.class,
						tempAttribute.getValue(), anUnresolvableVariableHandlingPolicy);
			} catch (ClassNotFoundException exc) {
				throw new ConversionFailedException(NestedObject.class, Map.class, null, exc);
			} catch (UnexecutableException exc) {
				throw new ConversionFailedException(NestedObject.class, Map.class, null, exc);
			} catch (InstantiationException exc) {
				throw new ConversionFailedException(NestedObject.class, Map.class, null, exc);
			}

			if (tempBuilder.length() > 0) {
				tempBuilder.append(", ");
			}
			tempBuilder.append(tempAttribute.getIdentifier() + "=" + tempConvertedValue);
		}

		return "{" + tempBuilder.toString() + "}";
	}

	@Override
	public int getPriority() {
		return Integer.MIN_VALUE;
	}

}

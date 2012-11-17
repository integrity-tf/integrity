/**
 * A default Integrity conversion. 
 */
package de.gebit.integrity.parameter.conversion.conversions.integrity.other;

import java.lang.reflect.Array;
import java.util.Map;

import com.google.inject.Inject;

import de.gebit.integrity.dsl.KeyValuePair;
import de.gebit.integrity.dsl.NestedObject;
import de.gebit.integrity.operations.OperationWrapper.UnexecutableException;
import de.gebit.integrity.parameter.conversion.Conversion;
import de.gebit.integrity.parameter.conversion.ConversionFailedException;
import de.gebit.integrity.parameter.conversion.UnresolvableVariableHandling;
import de.gebit.integrity.parameter.conversion.ValueConverter;

/**
 * A default Integrity conversion.
 * 
 * @author Rene Schneider
 * 
 */
public class NestedObjectToString implements Conversion<NestedObject, String> {

	/**
	 * The value converter used for recursive conversion and resolution of inner nested objects.
	 */
	@Inject
	private ValueConverter valueConverter;

	@Override
	public String convert(NestedObject aSource, Class<? extends String> aTargetType,
			UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy) throws ConversionFailedException {
		StringBuilder tempBuilder = new StringBuilder();
		for (KeyValuePair tempAttribute : aSource.getAttributes()) {
			Object tempConvertedValue;
			try {
				tempConvertedValue = valueConverter.convertValue(String[].class, tempAttribute.getValue(),
						anUnresolvableVariableHandlingPolicy);
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

			StringBuilder tempConvertedValueStringBuilder = new StringBuilder();

			if (tempConvertedValue == null) {
				tempConvertedValueStringBuilder.append("null");
			} else {
				int tempArrayLength = Array.getLength(tempConvertedValue);
				if (tempArrayLength > 1) {
					tempConvertedValueStringBuilder.append("[");
				}
				for (int i = 0; i < tempArrayLength; i++) {
					if (i > 0) {
						tempConvertedValueStringBuilder.append(", ");
					}
					Object tempSingleArrayValue = Array.get(tempConvertedValue, i);
					tempConvertedValueStringBuilder.append(tempSingleArrayValue != null ? tempSingleArrayValue
							.toString() : "null");
				}
				if (tempArrayLength > 1) {
					tempConvertedValueStringBuilder.append("]");
				}
			}

			tempBuilder.append(tempAttribute.getIdentifier() + "=" + tempConvertedValueStringBuilder.toString());
		}

		return "{" + tempBuilder.toString() + "}";
	}

	@Override
	public int getPriority() {
		return Integer.MIN_VALUE;
	}

}

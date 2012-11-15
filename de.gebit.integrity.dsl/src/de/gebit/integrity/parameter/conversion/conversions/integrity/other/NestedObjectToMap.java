/**
 * A default Integrity conversion. 
 */
package de.gebit.integrity.parameter.conversion.conversions.integrity.other;

import java.util.HashMap;
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
public class NestedObjectToMap implements TargetedConversion<NestedObject, Map> {

	@Inject
	private ValueConverter valueConverter;

	@Override
	public Map convert(NestedObject aSource, UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy)
			throws ConversionFailedException {
		Map<String, Object> tempKeyValueMap = new HashMap<String, Object>();
		for (KeyValuePair tempAttribute : aSource.getAttributes()) {
			Object tempConvertedValue;
			try {
				tempConvertedValue = valueConverter.convertEncapsulatedValueCollectionToParamType(null,
						tempAttribute.getValue(), anUnresolvableVariableHandlingPolicy);
			} catch (ClassNotFoundException exc) {
				throw new ConversionFailedException(NestedObject.class, Map.class, null, exc);
			} catch (UnexecutableException exc) {
				throw new ConversionFailedException(NestedObject.class, Map.class, null, exc);
			} catch (InstantiationException exc) {
				throw new ConversionFailedException(NestedObject.class, Map.class, null, exc);
			}

			tempKeyValueMap.put(tempAttribute.getIdentifier(), tempConvertedValue);
		}

		return tempKeyValueMap;
	}

	@Override
	public int getPriority() {
		return 0;
	}

}

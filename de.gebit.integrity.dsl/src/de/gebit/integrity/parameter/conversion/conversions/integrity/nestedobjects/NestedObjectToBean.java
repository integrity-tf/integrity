/**
 * A default Integrity conversion. 
 */
package de.gebit.integrity.parameter.conversion.conversions.integrity.nestedobjects;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;

import de.gebit.integrity.dsl.KeyValuePair;
import de.gebit.integrity.dsl.NestedObject;
import de.gebit.integrity.operations.CustomOperationWrapper.UnexecutableException;
import de.gebit.integrity.parameter.conversion.Conversion;
import de.gebit.integrity.parameter.conversion.ConversionFailedException;
import de.gebit.integrity.parameter.conversion.UnresolvableVariableHandling;
import de.gebit.integrity.utils.ParameterUtil.UnresolvableVariableException;

/**
 * A default Integrity conversion.
 * 
 * @author Rene Schneider
 * 
 */
@de.gebit.integrity.parameter.conversion.Conversion.Priority(Integer.MIN_VALUE)
public class NestedObjectToBean extends Conversion<NestedObject, Object> {

	@Override
	public Object convert(NestedObject aSource, Class<? extends Object> aTargetType,
			UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy) throws ConversionFailedException {

		if (aTargetType == null) {
			throw new ConversionFailedException(aSource.getClass(), aTargetType,
					"Cannot convert nested object to non-Map object if the target type is not specified!");
		}

		try {
			Object tempTargetInstance = aTargetType.newInstance();

			for (KeyValuePair tempAttribute : aSource.getAttributes()) {
				Method tempWriteMethod = new PropertyDescriptor(tempAttribute.getIdentifier(), aTargetType)
						.getWriteMethod();
				if (tempWriteMethod == null || tempWriteMethod.getParameterTypes().length != 1) {
					throw new ConversionFailedException(aSource.getClass(), aTargetType,
							"No accessible standards-compliant setter found for '" + tempAttribute.getIdentifier()
									+ "'");
				}

				Class<?> tempTargetType = tempWriteMethod.getParameterTypes()[0];
				Class<?> tempParameterizedType = null;

				// See whether we can find a generic type parameter for the given target class
				Class<?> tempClassInFocus = aTargetType;
				while (tempClassInFocus != null) {
					try {
						Field tempField = tempClassInFocus.getDeclaredField(tempAttribute.getIdentifier());
						Type tempGenericType = tempField.getGenericType();
						if (tempGenericType instanceof ParameterizedType) {
							Type tempInnerType = ((ParameterizedType) tempGenericType).getActualTypeArguments()[0];
							if (tempInnerType instanceof WildcardType) {
								if (((WildcardType) tempInnerType).getUpperBounds() == null) {
									tempParameterizedType = null;
								} else {
									Type tempUpperBound = ((WildcardType) tempInnerType).getUpperBounds()[0];
									if (tempUpperBound instanceof ParameterizedType) {
										tempParameterizedType = (Class<?>) ((ParameterizedType) tempUpperBound)
												.getRawType();
									} else {
										tempParameterizedType = (Class<?>) tempUpperBound;
									}
								}
								// lower bounds not currently supported!

							} else {
								if (tempInnerType instanceof ParameterizedType) {
									tempParameterizedType = (Class<?>) ((ParameterizedType) tempInnerType).getRawType();
								} else {
									tempParameterizedType = (Class<?>) tempInnerType;
								}
							}
						}
						break;
					} catch (SecurityException exc) {
						// don't care, just continue
					} catch (NoSuchFieldException exc) {
						// don't care, just continue
					}
					tempClassInFocus = tempClassInFocus.getSuperclass();
				}

				Object tempConvertedValue = convertValueRecursive(tempTargetType, tempParameterizedType,
						tempAttribute.getValue(), anUnresolvableVariableHandlingPolicy);
				tempWriteMethod.invoke(tempTargetInstance, new Object[] { tempConvertedValue });
			}

			return tempTargetInstance;
		} catch (InstantiationException exc) {
			throw new ConversionFailedException(aSource.getClass(), aTargetType, null, exc);
		} catch (IllegalAccessException exc) {
			throw new ConversionFailedException(aSource.getClass(), aTargetType, null, exc);
		} catch (UnresolvableVariableException exc) {
			throw new ConversionFailedException(aSource.getClass(), aTargetType, null, exc);
		} catch (ClassNotFoundException exc) {
			throw new ConversionFailedException(aSource.getClass(), aTargetType, null, exc);
		} catch (UnexecutableException exc) {
			throw new ConversionFailedException(aSource.getClass(), aTargetType, null, exc);
		} catch (IntrospectionException exc) {
			throw new ConversionFailedException(aSource.getClass(), aTargetType, null, exc);
		} catch (IllegalArgumentException exc) {
			throw new ConversionFailedException(aSource.getClass(), aTargetType, null, exc);
		} catch (InvocationTargetException exc) {
			throw new ConversionFailedException(aSource.getClass(), aTargetType, null, exc);
		}
	}
}

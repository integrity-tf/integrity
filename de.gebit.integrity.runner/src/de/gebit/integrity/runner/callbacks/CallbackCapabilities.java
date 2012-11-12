/**
 * 
 */
package de.gebit.integrity.runner.callbacks;

import java.util.Map;

import de.gebit.integrity.dsl.VariableEntity;
import de.gebit.integrity.parameter.conversion.ValueConverter;
import de.gebit.integrity.parameter.resolving.ParameterResolver;

/**
 * A capability object which bundles all the capability providers available for use in callbacks.
 * 
 * @author Rene Schneider
 * 
 */
public class CallbackCapabilities {

	/**
	 * The value converter, responsible for conversion of values between test scripts and Java.
	 */
	private ValueConverter valueConverter;

	/**
	 * The parameter resolver, which can be used to resolve parameters and variables.
	 */
	private ParameterResolver parameterResolver;

	/**
	 * The map in which variable values are stored.
	 */
	private Map<VariableEntity, Object> variableMap;

	/**
	 * The classloader to use in the callbacks.
	 */
	private ClassLoader classLoader;

	/**
	 * Creates a new instance.
	 * 
	 * @param aConverter
	 *            the value converter
	 * @param aResolver
	 *            the parameter resolver
	 */
	public CallbackCapabilities(ValueConverter aConverter, ParameterResolver aResolver,
			Map<VariableEntity, Object> aVariableMap, ClassLoader aClassLoader) {
		valueConverter = aConverter;
		parameterResolver = aResolver;
		variableMap = aVariableMap;
		classLoader = aClassLoader;
	}

	public ValueConverter getValueConverter() {
		return valueConverter;
	}

	public ParameterResolver getParameterResolver() {
		return parameterResolver;
	}

	public Map<VariableEntity, Object> getVariableMap() {
		return variableMap;
	}

	public ClassLoader getClassLoader() {
		return classLoader;
	}

}

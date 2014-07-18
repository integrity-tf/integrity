/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.parameter.conversion;

import java.util.HashMap;
import java.util.Map;

import de.gebit.integrity.comparator.ComparisonResult;

/**
 * A conversion context is a container for contextual information required to perform a value conversion.<br>
 * <br>
 * This class is intended to be used in a Builder-style pattern.
 * 
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class ConversionContext implements Cloneable {

	/**
	 * Whether the default conversion applied to Java Bean classes (
	 * {@link de.gebit.integrity.parameter.conversion.conversions.java.other.ObjectToMap}) shall be skipped in the
	 * conversion search and no conversion at all shall be done instead.
	 */
	protected boolean skipBeanToMapDefaultConversion;

	/**
	 * The way in which unresolvable variables shall be treated.
	 */
	protected UnresolvableVariableHandling unresolvableVariableHandlingPolicy = UnresolvableVariableHandling.RESOLVE_TO_NULL_VALUE;

	/**
	 * In case of a value being converted which belongs to a comparison that has been executed, the result of said
	 * comparison can be provided.
	 */
	protected ComparisonResult comparisonResult;

	/**
	 * Map to contain arbitrary information.
	 */
	protected Map<String, Object> properties = new HashMap<String, Object>();

	/**
	 * Creates an instance with the default initial values. SHOULD NEVER BE CALLED DIRECTLY!!! Use a Guice-injected
	 * Provider instead to create an instance!
	 */
	public ConversionContext() {
		// defaults are used
	}

	/**
	 * Enable skipping of the bean-to-map default conversion (
	 * {@link de.gebit.integrity.parameter.conversion.conversions.java.other.ObjectToMap}).
	 * 
	 * @see #skipBeanToMapDefaultConversion
	 */
	public ConversionContext skipBeanToMapDefaultConversion() {
		skipBeanToMapDefaultConversion = true;
		return this;
	}

	/**
	 * Enables a certain {@link UnresolvableVariableHandling} policy instead of the default.
	 * 
	 * @param aPolicy
	 *            the policy to use
	 */
	public ConversionContext withUnresolvableVariableHandlingPolicy(UnresolvableVariableHandling aPolicy) {
		unresolvableVariableHandlingPolicy = aPolicy;
		return this;
	}

	/**
	 * Adds the provided comparison result.
	 * 
	 * @param aComparisonResult
	 *            the comparison result to add
	 */
	public ConversionContext withComparisonResult(ComparisonResult aComparisonResult) {
		comparisonResult = aComparisonResult;
		return this;
	}

	/**
	 * Adds the provided property.
	 * 
	 * @param aKey
	 *            the key
	 * @param anObject
	 *            the object
	 */
	public ConversionContext withProperty(String aKey, Object anObject) {
		properties.put(aKey, anObject);
		return this;
	}

	public boolean getSkipBeanToMapDefaultConversion() {
		return skipBeanToMapDefaultConversion;
	}

	public UnresolvableVariableHandling getUnresolvableVariableHandlingPolicy() {
		return unresolvableVariableHandlingPolicy;
	}

	public ComparisonResult getComparisonResult() {
		return comparisonResult;
	}

	/**
	 * Returns the property matching the key, or null if none was set.
	 * 
	 * @param aKey
	 *            the key
	 * @return the property or null
	 */
	public Object getProperty(String aKey) {
		return properties.get(aKey);
	}

}

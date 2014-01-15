/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.parameter.conversion;

/**
 * 
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class ConversionContext implements Cloneable {

	private boolean skipBeanToMapDefaultConversion;

	private UnresolvableVariableHandling unresolvableVariableHandlingPolicy = UnresolvableVariableHandling.RESOLVE_TO_NULL_VALUE;

	public ConversionContext() {
		// defaults are used
	}

	public ConversionContext skipBeanToMapDefaultConversion() {
		skipBeanToMapDefaultConversion = true;
		return this;
	}

	public ConversionContext withUnresolvableVariableHandlingPolicy(UnresolvableVariableHandling aPolicy) {
		unresolvableVariableHandlingPolicy = aPolicy;
		return this;
	}

	public boolean getSkipBeanToMapDefaultConversion() {
		return skipBeanToMapDefaultConversion;
	}

	public UnresolvableVariableHandling getUnresolvableVariableHandlingPolicy() {
		return unresolvableVariableHandlingPolicy;
	}

	/**
	 * This method creates a default conversion context in case none is provided, and returns the provided context
	 * otherwise.
	 * 
	 * @param aContext
	 *            the context to safeguard
	 * @return a context (guaranteed not to return null)
	 */
	public static ConversionContext safeguardConversionContext(ConversionContext aContext) {
		if (aContext == null) {
			return new ConversionContext();
		} else {
			return aContext;
		}
	}

}

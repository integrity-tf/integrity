/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.fixtures;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This annotation has to be added to each fixture parameter.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
public @interface FixtureParameter {

	/**
	 * The name of the parameter. Required, because the parameter names used in the method signature aren't available at
	 * runtime, thus they cannot be used as any kind of default.
	 * 
	 * @return
	 */
	String name();

	/**
	 * Whether the parameter must be provided or is optional. By default parameters are optional (= non-mandatory, so
	 * mandatory = false).
	 * <p>
	 * Note that there is a significant difference between making a parameter mandatory and allowing or disallowing the
	 * null value - just because a parameter is mandatory it may still be null, because by providing a null value
	 * explicitly in the test script, the "mandatory" part is satisfied. Please see {@link #nullable()} as well if you
	 * also want to ensure a parameter may never be null.
	 * <p>
	 * If an optional parameter is not provided in the test script, the method will be called with "null" for the
	 * specific parameter. Since primitive types cannot be null, using a primitive type for a method parameter
	 * automatically makes the parameter mandatory (even if you set mandatory=false in this annotation, it will be
	 * ignored in that case).
	 * 
	 * @return
	 */
	boolean mandatory() default false;

	/**
	 * Whether a parameter may be the value "null" at the time the fixture method is invoked. By default, parameters are
	 * nullable. If a fixture parameter is marked as non-nullable, a null value will lead to an
	 * {@link IllegalArgumentException} at runtime, and directly providing null values within test scripts will lead to
	 * errors at compile time.
	 * <p>
	 * In case of multiple parameter values (= an array is provided to the fixture), setting the parameter to
	 * non-nullable will cause an exception if at least one of the provided values is null, regardless of whether other
	 * provided values are non-null.
	 * <p>
	 * Note that there is a significant difference between allowing or disallowing null as a value vs. making a
	 * parameter mandatory! Please see {@link #mandatory()} as well.
	 * <p>
	 * If the type used for a parameter is a primitive type which cannot be null, the respective parameter is
	 * automatically non-nullable, regardless of this setting.
	 * 
	 * @return
	 */
	boolean nullable() default true;

}

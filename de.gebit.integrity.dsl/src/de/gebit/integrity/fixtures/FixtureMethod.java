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
 * This annotation must be added to all methods to be denoted as fixture methods. Fixtures are the primary way for
 * Integrity test scripts to interact with the System Under Test. Fixture classes implement fixture methods for this
 * purpose, which are then referenced in test scripts. <br>
 * <br>
 * The way to implement a fixture method is to take any POJO class and implement a method of any desired name. This
 * method must be decorated with the {@link FixtureMethod} annotation to be called by Integrity. Parameters may be
 * created by simply adding standard Java parameters to the method in question, annotated with a
 * {@link FixtureParameter} annotation. Integrity will take care of the necessary conversions of user-provided data into
 * the parameter data types, but the parameters may only use one of the following supported types:<br>
 * <br>
 * <ul>
 * <li>String</li>
 * <li>Byte</li>
 * <li>Short</li>
 * <li>Integer</li>
 * <li>Long</li>
 * <li>BigInteger</li>
 * <li>Float</li>
 * <li>Double</li>
 * <li>BigDecimal</li>
 * <li>an Enumeration</li>
 * <li>and the array variants of these types</li>
 * </ul>
 * <br>
 * The method may return either nothing at all, a value of one of the supported types, or an instance of a custom class
 * that acts as a container for multiple named result values. The first two cases are suited for use in test and call
 * statements, while the latter is suitable for test statements with named results.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface FixtureMethod {

	/**
	 * The description for the method. This text is intended to be a human-readable description of
	 * "what the fixture does". It is highly suggested to provide such a description, since it's one of the main
	 * mechanisms used by Integrity to create human-readable test results.<br>
	 * <br>
	 * You may use placeholder values in the description string enclosed in dollar signs, like this: $parameter$. These
	 * will be replaced by the matching parameter values at runtime.<br>
	 * Placeholders can also be conditional (printed only when a parameter is provided or not) like this:<br>
	 * {parameter?...and $parameter$} - this whole block would not appear if "parameter" is not provided, but if it is,
	 * it would be replaced by the text "...and [value of parameter]". By specifying a ^ in front of the parameter name
	 * the meaning is reversed: the block will appear if the parameter is NOT specified ({^parameter?not specified}).<br>
	 * <br>
	 * For fixture methods which are suitable in both 'call' and 'test' scenarios, you can define separate description
	 * texts via {@link #descriptionCall()} and {@link #descriptionTest()}. If such a specific text is defined, it does
	 * automatically override this generic description text.
	 * 
	 * @return
	 */
	String description() default "";

	/**
	 * The description for the method, to be used if the method is included via 'testdef'.
	 * 
	 * @see #description()
	 * @return
	 */
	String descriptionTest() default "";

	/**
	 * The description for the method, to be used if the method is included via 'calldef'.
	 * 
	 * @see #description()
	 * @return
	 */
	String descriptionCall() default "";

}

/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.tests.fixtures.basic.javaconstants;

import java.math.BigDecimal;

/**
 * A class with some constant values, implementing an interface with constant values.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
// SUPPRESS CHECKSTYLE LONG Javadoc
public class ClassWithConstants implements InterfaceWithConstants {

	public static final Float FLOAT_CONSTANT = 42.3f;

	public static final Double DOUBLE_CONSTANT = 42.3d;

	public static final BigDecimal BIGDECIMAL_CONSTANT = new BigDecimal("42.3");

}

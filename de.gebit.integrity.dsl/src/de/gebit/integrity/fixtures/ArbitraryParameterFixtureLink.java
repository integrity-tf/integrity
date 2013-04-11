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
 * This annotation is used to link an {@link ArbitraryParameterEnumerator} to an implementation of
 * {@link ArbitraryParameterFixture}, for which it will provide the arbitrary parameter suggestions within Eclipse.
 * 
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ArbitraryParameterFixtureLink {

	/**
	 * The class that this {@link ArbitraryParameterEnumerator} is linked to.
	 * 
	 * @return
	 */
	Class<? extends ArbitraryParameterFixture> value();

}
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
 * A fixture factory can be used to customize fixture instance creation. This interface links
 * {@link FixtureInstanceFactory}s to their respective Fixture classes.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface FixtureFactory {

	/**
	 * The factory class. This class has to have a no-arg constructor and will be instantiated exactly once.
	 * 
	 * @return
	 */
	Class<? extends FixtureInstanceFactory<?>> value();

}

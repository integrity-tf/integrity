/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider (GEBIT Solutions GmbH) and others.
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
	 * Whether the parameter must be provided or is optional.
	 * 
	 * @return
	 */
	boolean optional() default false;

}

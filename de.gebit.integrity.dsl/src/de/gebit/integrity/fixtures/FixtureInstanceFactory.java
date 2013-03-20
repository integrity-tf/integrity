/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider (GEBIT Solutions GmbH) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.fixtures;

/**
 * Fixture Factories can be used to customize fixture instantiation. You may annotate any fixture class with the
 * {@link FixtureFactory} annotation to link an instance factory to it. This factory has to have a no-arg constructor
 * and will be instantiated exactly once.
 * 
 * 
 * @param <C>
 *            the fixture class created by this factory
 * @author Rene Schneider - initial API and implementation
 * 
 */
public interface FixtureInstanceFactory<C> {

	/**
	 * Returns a fresh instance of the fixture. This fixture is expected to be "clean" in terms of state.
	 * 
	 * @return a fixture instance
	 */
	C retrieveInstance();

	/**
	 * Called after an instance retrieved from {@link #retrieveInstance()} is no longer required. Integrity guarantees
	 * that there will be no more calls to the instance in question after it has been passed to this method.
	 * 
	 * @param anInstance
	 *            the instance to be released
	 */
	void releaseInstance(C anInstance);

}

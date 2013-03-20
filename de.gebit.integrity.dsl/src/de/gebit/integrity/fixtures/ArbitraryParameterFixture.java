/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider (GEBIT Solutions GmbH) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.fixtures;

/**
 * Interface for fixtures that allow for arbitrary, non-predetermined parameters to be specified. Fixtures that want to
 * use the arbitrary parameter system must implement this interface class, and they must implement
 * {@link #defineArbitraryParameters(String, java.util.Map)} and {@link #defineArbitraryResults(String, java.util.Map)},
 * though they don't necessarily have to return any parameter definitions or results (for example they might choose to
 * only support parameters, not results).<br>
 * <br>
 * Fixture methods with arbitrary parameters generally look like normal fixture methods and may contain fixed parameters
 * as well, but they are required to add a single {@link java.util.Map}<String, Object> parameter, which will be used to
 * supply the arbitrary parameters. That map doesn't have to have an attached {@link FixtureParameter} annotation like
 * fixed parameters.<br>
 * <br>
 * Usually, arbitrary parameter fixture classes are used in conjunction with an {@link ArbitraryParameterEnumerator} for
 * each. The enumerator class gets linked to its fixture class and is responsible for providing information about valid
 * parameters for content assist during test script editing, while the fixture class provides information about valid
 * parameters for type conversion purposes at runtime.
 * 
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public abstract interface ArbitraryParameterFixture {

}

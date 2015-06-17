/*******************************************************************************
 * Copyright (c) 2015 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.fixtures;

import java.util.Set;

/**
 * A fixture implementing this interface is notified by Integrity in advance of calling a fixture method, thereby
 * telling the fixture instance about the (named) results that will be checked after the upcoming fixture method call
 * has returned its result.<br>
 * <br>
 * This knowledge is usually not required by a fixture - it is simply intended to deliver all available result data,
 * even though the test script author might not use all possible (named) results during a test invocation. Surplus data
 * is then ignored. For simplicity, behaving like this should be the default way to go. But in some cases it can be
 * beneficial to know about the actually-used named results in advance, in order to only return results that are being
 * checked. This could be used for example for performance optimizations in cases in which a truly huge number of
 * possible named results are to be compiled (or if compiling the results generally is an expensive task).
 * 
 *
 * @author Rene Schneider - initial API and implementation
 *
 */
public interface ResultAwareFixture {

	/**
	 * Called by the Integrity Test Runner right before a fixture method is called in order to announce the methods'
	 * name as well as the extent to which the results returned by the fixture method will be checked later. For 'call'
	 * invocations, this will always state that neither the default result flag nor a single named result set are to be
	 * checked (but the announce method will be called nevertheless for 'call' invocations as well!). For 'test' or
	 * 'tabletest' invocations, the availability of an expected default result (the implicit 'true' default result also
	 * counts here) and/or the availability of any named results are communicated accordingly.
	 * 
	 * @param aMethodName
	 *            The name of the fixture method to be invoked next
	 * @param aDefaultResultFlag
	 *            Whether the default result is checked
	 * @param aNamedResultSet
	 *            Any named results that are being checked (is never null; always supplies at least an empty set)
	 */
	void announceCheckedResults(String aMethodName, boolean aDefaultResultFlag, Set<String> aNamedResultSet);

}

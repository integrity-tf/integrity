/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.tests.fixtures.basic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import de.gebit.integrity.fixtures.FixtureMethod;
import de.gebit.integrity.fixtures.FixtureParameter;
import de.gebit.integrity.fixtures.ResultAwareFixture;

/**
 * A simple test fixture which does nothing (except echoing some input).
 * 
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
// SUPPRESS CHECKSTYLE LONG Javadoc
public class ResultAwareNoOpFixture implements ResultAwareFixture {

	@FixtureMethod(description = "Echo the string '$string$'")
	public String echoString(@FixtureParameter(name = "string") String aStringToEcho) {
		return aStringToEcho;
	}

	@Override
	public void announceCheckedResults(String aMethodName, boolean aDefaultResultFlag, Set<String> aNamedResultSet) {
		if (aDefaultResultFlag) {
			aNamedResultSet.add("DEFAULT");
		}
		announcedResults.put(aMethodName, aNamedResultSet);
	}

	private static final Map<String, Set<String>> announcedResults = new HashMap<>();

	public static String[] getAnnouncedResults(String aMethodName) {
		Set<String> tempSet = announcedResults.get(aMethodName);

		if (tempSet == null) {
			return null;
		} else {
			String[] tempResult = tempSet.toArray(new String[tempSet.size()]);
			Arrays.sort(tempResult);
			return tempResult;
		}
	}

}

/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.tests.fixtures.basic;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import de.gebit.integrity.fixtures.ArbitraryParameterFixture;
import de.gebit.integrity.fixtures.FixtureMethod;
import de.gebit.integrity.fixtures.FixtureParameter;

//SUPPRESS CHECKSTYLE LONG Javadoc
public class ArbitraryParamEchoFixture implements ArbitraryParameterFixture {

	@FixtureMethod(description = "echoes the values: $fixparam$, $testparam1$, $testparam2${testparam 3?, $testparam 3$}")
	public ResultClass echo(@FixtureParameter(name = "fixparam") Integer aFixParam, Map<String, Object> someMoreParams) {
		ResultClass tempResultObject = new ResultClass();
		tempResultObject.setFixedresult(aFixParam);

		Map<String, Object> tempMap = new HashMap<String, Object>();
		tempMap.put("testresult1", someMoreParams.get("testparam1"));
		tempMap.put("testresult2", someMoreParams.get("testparam2"));
		if (someMoreParams.get("testparam 3") != null) {
			tempMap.put("testresult 3", someMoreParams.get("testparam 3"));
		}

		tempResultObject.setArbitraryResults(tempMap);

		return tempResultObject;
	}

	@FixtureMethod(description = "echoes all arbitrary parameter names and their types")
	public String[] echoTypes(Map<String, Object> someParams) {
		String[] tempResult = new String[someParams.size()];

		int i = 0;
		for (Entry<String, Object> tempEntry : someParams.entrySet()) {
			tempResult[i] = tempEntry.getKey() + "|" + tempEntry.getValue().getClass().getName();
			i++;
		}

		return tempResult;
	}

	public class ResultClass {

		private Integer fixedresult;

		private Map<String, Object> arbitraryResults;

		public Integer getFixedresult() {
			return fixedresult;
		}

		public void setFixedresult(Integer fixedresult) {
			this.fixedresult = fixedresult;
		}

		public Map<String, Object> getArbitraryResults() {
			return arbitraryResults;
		}

		public void setArbitraryResults(Map<String, Object> arbitraryResults) {
			this.arbitraryResults = arbitraryResults;
		}

	}

}

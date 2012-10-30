package de.gebit.integrity.tests.fixtures.basic;

import java.util.HashMap;
import java.util.Map;

import de.gebit.integrity.fixtures.ArbitraryParameterFixture;
import de.gebit.integrity.fixtures.FixtureMethod;
import de.gebit.integrity.fixtures.FixtureParameter;

//SUPPRESS CHECKSTYLE LONG Javadoc
public class ArbitraryParamEchoFixture implements ArbitraryParameterFixture {

	@Override
	public Map<String, Class<?>> defineArbitraryParameters(String aFixtureName,
			Map<String, Object> someFixedParameters) {
		Map<String, Class<?>> tempMap = new HashMap<String, Class<?>>();
		tempMap.put("param1", Integer.class);
		tempMap.put("param2", String.class);
		return tempMap;
	}

	@Override
	public Map<String, Class<?>> defineArbitraryResults(String aFixtureName,
			Map<String, Object> someFixedParameters) {
		Map<String, Class<?>> tempMap = new HashMap<String, Class<?>>();
		tempMap.put("result1", Integer.class);
		tempMap.put("result2", String.class);
		return tempMap;
	}

	@FixtureMethod(description = "echoes the values: $fixparam$, $testparam1$, $testparam2$")
	public ResultClass echo(
			@FixtureParameter(name = "fixparam") Integer aFixParam,
			Map<String, Object> someMoreParams) {
		ResultClass tempResultObject = new ResultClass();
		tempResultObject.setFixedresult(aFixParam);

		Map<String, Object> tempMap = new HashMap<String, Object>();
		tempMap.put("testresult1", someMoreParams.get("testparam1"));
		tempMap.put("testresult2", someMoreParams.get("testparam2"));

		tempResultObject.setArbitraryResults(tempMap);

		return tempResultObject;
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

package de.gebit.integrity.experiments.fixtures;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import de.gebit.integrity.fixtures.ArbitraryParameterFixture;
import de.gebit.integrity.fixtures.FixtureMethod;
import de.gebit.integrity.fixtures.FixtureParameter;

public class ArbitraryParamFixture extends ArbitraryParameterFixture {

	@Override
	public List<ArbitraryParameterDefinition> defineArbitraryParameters(String aFixtureName,
			Map<String, Object> someFixedParameters, boolean aCalledInEclipseFlag) {
		List<ArbitraryParameterDefinition> tempList = new LinkedList<ArbitraryParameterFixture.ArbitraryParameterDefinition>();
		tempList.add(new ArbitraryParameterDefinition("testparam1", Integer.class, "This is the first parameter."));
		tempList.add(new ArbitraryParameterDefinition("testparam2", String.class, "This is the second parameter."));
		return tempList;
	}

	@Override
	public List<ArbitraryParameterDefinition> defineArbitraryResults(String aFixtureName,
			Map<String, Object> someFixedParameters, boolean aCalledInEclipseFlag) {
		List<ArbitraryParameterDefinition> tempList = new LinkedList<ArbitraryParameterFixture.ArbitraryParameterDefinition>();
		tempList.add(new ArbitraryParameterDefinition("testresult1", Integer.class, "This is the first result."));
		tempList.add(new ArbitraryParameterDefinition("testresult2", String.class, "This is the second result."));
		return tempList;
	}

	@FixtureMethod(description = "addition of $fixparam$ and $testparam1$")
	public ResultClass addition(@FixtureParameter(name = "fixparam") Integer aFixParam,
			Map<String, Object> someMoreParams) {
		int tempResult = (aFixParam + (Integer) someMoreParams.get("testparam1"));
		ResultClass tempResultObject = new ResultClass();
		tempResultObject.setFixedresult(tempResult);

		Map<String, Object> tempMap = new HashMap<String, Object>();
		tempMap.put("testresult1", someMoreParams.get("testparam2"));
		tempMap.put("testresult2", 100);

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

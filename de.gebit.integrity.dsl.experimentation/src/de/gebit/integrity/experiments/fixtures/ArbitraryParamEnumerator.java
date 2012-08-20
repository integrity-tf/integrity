package de.gebit.integrity.experiments.fixtures;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import de.gebit.integrity.fixtures.ArbitraryParameterEnumerator;
import de.gebit.integrity.fixtures.ArbitraryParameterFixtureLink;

@ArbitraryParameterFixtureLink(ArbitraryParamFixture.class)
public class ArbitraryParamEnumerator implements ArbitraryParameterEnumerator {

	private static String stored;

	@Override
	public List<ArbitraryParameterDefinition> defineArbitraryParameters(String aFixtureName,
			Map<String, Object> someFixedParameters) {
		if (stored == null) {
			System.out.println("NOT STORED");
			stored = "STORED";
		} else {
			System.out.println(stored);
		}
		List<ArbitraryParameterDefinition> tempList = new LinkedList<ArbitraryParameterDefinition>();
		tempList.add(new ArbitraryParameterDefinition("testparam1", Integer.class, "This is the first parameter."));
		tempList.add(new ArbitraryParameterDefinition("testparam2", String.class, "This is the second parameter."));
		return tempList;
	}

	@Override
	public List<ArbitraryParameterDefinition> defineArbitraryResults(String aFixtureName,
			Map<String, Object> someFixedParameters) {
		List<ArbitraryParameterDefinition> tempList = new LinkedList<ArbitraryParameterDefinition>();
		tempList.add(new ArbitraryParameterDefinition("testresult1", Integer.class, "This is the first result."));
		tempList.add(new ArbitraryParameterDefinition("testresult2", String.class, "This is the second result."));
		return tempList;
	}

}

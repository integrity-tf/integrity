package de.gebit.integrity.experiments.fixtures;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import de.gebit.integrity.fixtures.ArbitraryParameterEnumerator;
import de.gebit.integrity.fixtures.ArbitraryParameterFixtureLink;

@ArbitraryParameterFixtureLink(ArbitraryParamFixture.class)
public class ArbitraryParamEnumerator implements ArbitraryParameterEnumerator {

	private static String stored;

	@Override
	public List<ArbitraryParameterDefinition> defineArbitraryParameters(
			String aFixtureName, Map<String, Object> someFixedParameters,
			List<String> aParameterPath) {
		if (aParameterPath != null) {
			System.out.println(Arrays.toString(aParameterPath.toArray()));
		}

		List<ArbitraryParameterDefinition> tempList = new LinkedList<ArbitraryParameterDefinition>();
		tempList.add(new ArbitraryParameterDefinition("testparam1",
				"This is the first parameter."));
		tempList.add(new ArbitraryParameterDefinition("testparam2",
				"This is the second parameter."));

		ArbitraryParameterDefinition tempDefinition = new ArbitraryParameterDefinition(
				"testparam3", "This is the third parameter.");
		ArbitraryParameterDefinition tempSubDefinition = new ArbitraryParameterDefinition(
				"testparam31", "This is a sub parameter.");
		ArbitraryParameterDefinition tempSubSubDefinition = new ArbitraryParameterDefinition(
				"testparam311", "This is a sub sub parameter.");

		tempDefinition.addSubdefinition(tempSubDefinition);
		tempSubDefinition.addSubdefinition(tempSubSubDefinition);
		tempDefinition.setNestedObjectParam(true);
		tempList.add(tempDefinition);

		return tempList;
	}

	@Override
	public List<ArbitraryParameterDefinition> defineArbitraryResults(
			String aFixtureName, Map<String, Object> someFixedParameters,
			List<String> aParameterPath) {
		List<ArbitraryParameterDefinition> tempList = new LinkedList<ArbitraryParameterDefinition>();
		tempList.add(new ArbitraryParameterDefinition("testresult1",
				"This is the first result."));
		tempList.add(new ArbitraryParameterDefinition("testresult2",
				"This is the second result."));

		ArbitraryParameterDefinition tempDefinition = new ArbitraryParameterDefinition(
				null, null);
		ArbitraryParameterDefinition tempSubDefinition = new ArbitraryParameterDefinition(
				"testresult31", "This is a sub parameter.");
		ArbitraryParameterDefinition tempSubSubDefinition = new ArbitraryParameterDefinition(
				"testresult311", "This is a sub sub parameter.");

		tempDefinition.addSubdefinition(tempSubDefinition);
		tempSubDefinition.addSubdefinition(tempSubSubDefinition);
		tempList.add(tempDefinition);

		return tempList;
	}

}

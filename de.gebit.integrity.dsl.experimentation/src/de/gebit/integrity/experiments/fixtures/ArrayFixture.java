package de.gebit.integrity.experiments.fixtures;

import de.gebit.integrity.fixtures.Fixture;
import de.gebit.integrity.fixtures.FixtureMethod;
import de.gebit.integrity.fixtures.FixtureParameter;

public class ArrayFixture extends Fixture {
	
	@FixtureMethod(description = "Counts an array of strings: $strings$")
	public int receiveArrayAndReturnSize(@FixtureParameter(name = "strings") String[] someStrings) {
		return someStrings.length;
	}
	
	@FixtureMethod(description = "Echoes an array of strings: $strings$")
	public String[] echoStringArray(@FixtureParameter(name = "strings") String[] someStrings) {
		return someStrings;
	}

}

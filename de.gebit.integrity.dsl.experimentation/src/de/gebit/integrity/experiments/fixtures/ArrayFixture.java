package de.gebit.integrity.experiments.fixtures;

import de.gebit.integrity.experiments.fixtures.ArrayFixture.ArrayFixtureFactory;
import de.gebit.integrity.fixtures.FixtureFactory;
import de.gebit.integrity.fixtures.FixtureInstanceFactory;
import de.gebit.integrity.fixtures.FixtureMethod;
import de.gebit.integrity.fixtures.FixtureParameter;

@FixtureFactory(ArrayFixtureFactory.class)
public class ArrayFixture {

	@FixtureMethod(description = "Counts an array of strings: $strings$")
	public int receiveArrayAndReturnSize(
			@FixtureParameter(name = "strings") String[] someStrings) {
		return someStrings.length;
	}

	@FixtureMethod(description = "Echoes an array of strings: $strings$")
	public String[] echoStringArray(
			@FixtureParameter(name = "strings") String[] someStrings) {
		return someStrings;
	}

	@FixtureMethod(description = "Counts an array of enums: $enum$")
	public int receiveEnumArrayAndReturnSize(
			@FixtureParameter(name = "enum") Enum[] someValues) {
		return someValues.length;
	}

	public static class ArrayFixtureFactory implements
			FixtureInstanceFactory<ArrayFixture> {

		@Override
		public ArrayFixture retrieveInstance() {
			System.out.println("### CREATED ARRAY FIXTURE ###");
			return new ArrayFixture();
		}

		@Override
		public void releaseInstance(ArrayFixture anInstance) {
			System.out.println("### RELEASED ARRAY FIXTURE ###");
		}

	}

	public enum Enum {

		VALUE1,

		VALUE2;

	}

}

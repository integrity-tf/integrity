package de.integrity.experiments.fixtures;

import de.integrity.fixtures.AbstractFixture;
import de.integrity.fixtures.FixtureMethod;
import de.integrity.fixtures.FixtureParameter;

public class AdditionFixture extends AbstractFixture {

	/**
	 * Adds two integer numbers and returns the result.
	 * 
	 * @param aSummand1
	 *            the first number
	 * @param aSummand2
	 *            the second number
	 * @return the sum of both inputs
	 */
	@FixtureMethod(description = "addition of $summand1$ and $summand2$")
	public Integer addition(@FixtureParameter(name = "summand1") Integer aSummand1,
			@FixtureParameter(name = "summand2") Integer aSummand2) {
		return new Integer(aSummand1 + aSummand2);
	}

	/**
	 * Creates a random number in a given interval.
	 * 
	 * @param aMin
	 *            the minimum
	 * @param aMax
	 *            the maximum
	 * @return a random number
	 */
	@FixtureMethod(description = "generates random number between $min$ and $max$")
	public Integer randomNumber(@FixtureParameter(name = "min") Integer aMin,
			@FixtureParameter(name = "max") Integer aMax) {
		return new Integer((int) (Math.random() * (aMax - aMin) + aMin));
	}

	@FixtureMethod(description = "echoes $echo$")
	public TestEnum returnValue(@FixtureParameter(name = "echo") TestEnum anInput) {
		throw new RuntimeException("An exception!");
		//return anInput;
	}

	@FixtureMethod(description = "this test always succeeds :-)")
	public boolean returnTrue() {
		return true;
	}

}

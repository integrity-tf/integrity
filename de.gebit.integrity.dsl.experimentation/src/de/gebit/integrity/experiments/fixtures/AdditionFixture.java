package de.gebit.integrity.experiments.fixtures;

import de.gebit.integrity.fixtures.FixtureMethod;
import de.gebit.integrity.fixtures.FixtureParameter;

public class AdditionFixture {

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
		pause();
		if (aSummand1 + aSummand2 == 50) {
			throw new RuntimeException("An exception!");
		}
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
		pause();
		return new Integer((int) (Math.random() * (aMax - aMin) + aMin));
	}

	@FixtureMethod(description = "echoes $echo$")
	public Integer returnValue(@FixtureParameter(name = "echo") Integer anInput) {
		pause();
		// throw new RuntimeException("An exception!");
		return anInput;
	}

	@FixtureMethod(description = "this test always succeeds :-)")
	public boolean returnTrue() {
		pause();
		return true;
	}

	@FixtureMethod(description = "this test always fails :-(")
	public boolean returnFalse() {
		pause();
		return false;
	}

	@FixtureMethod(description = "This always throws an exception. We're so doomed!")
	public boolean throwException() {
		throw new RuntimeException("Holy shit!");
	}

	@FixtureMethod(description = "returns some named results")
	public NamedResultContainer multiResultFixture(@FixtureParameter(name = "param") String aParam) {
		return new NamedResultContainer(aParam, 100);
	}

	private void pause() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException exc) {
			exc.printStackTrace();
		}
	}

	public static class NamedResultContainer {

		private String firstNamedResult;

		private Integer secondNamedResult;

		public NamedResultContainer(String aFirstNamedResult, Integer aSecondNamedResult) {
			firstNamedResult = aFirstNamedResult;
			secondNamedResult = aSecondNamedResult;
		}

		public String getFirstNamedResult() {
			return firstNamedResult;
		}

		public Integer getSecondNamedResult() {
			return secondNamedResult;
		}

	}

}

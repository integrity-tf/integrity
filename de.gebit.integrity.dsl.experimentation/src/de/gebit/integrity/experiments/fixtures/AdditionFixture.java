package de.gebit.integrity.experiments.fixtures;

import java.util.Date;

import com.google.inject.Inject;

import de.gebit.integrity.exceptions.AbortExecutionException;
import de.gebit.integrity.fixtures.FinalizationTestFixture;
import de.gebit.integrity.fixtures.FixtureMethod;
import de.gebit.integrity.fixtures.FixtureParameter;
import de.gebit.integrity.fixtures.logging.FixtureLogLevel;
import de.gebit.integrity.fixtures.logging.FixtureLogger;

public class AdditionFixture implements FinalizationTestFixture {

	public static final String STRING_CONST = "Hello World!";

	public static final Integer INT_CONST = 123;

	public int integer = 123;

	@Inject
	private FixtureLogger logger;

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

	@Override
	public String performFinalizationTest() {
		return "blah";
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
	public Integer randomNumber(@FixtureParameter(name = "min", mandatory = true) Integer aMin,
			@FixtureParameter(name = "max") int aMax) {
		pause();
		return new Integer((int) (Math.random() * (aMax - aMin) + aMin));
	}

	@FixtureMethod(description = "echoes $echo$")
	public Integer returnInteger(@FixtureParameter(name = "echo") Integer anInput) {
		pause();
		// throw new RuntimeException("An exception!");
		return anInput;
	}

	@FixtureMethod(description = "echoes $echo$")
	public String returnString(@FixtureParameter(name = "echo") String anInput) {
		pause();
		// throw new RuntimeException(anInput);

		return anInput;
	}

	private void logStuff() {
		if (Math.random() > 0.5) {
			int tempTargetLogLines = (int) (Math.random() * 10);
			int tempTargetConsoleLines = (int) (Math.random() * 10);
			int tempLogLines = 0;
			int tempConsoleLines = 0;

			while (tempLogLines < tempTargetLogLines || tempConsoleLines < tempTargetConsoleLines) {
				if (Math.random() > 0.5) {
					if (tempLogLines < tempTargetLogLines) {
						tempLogLines++;
						logger.log(
								FixtureLogLevel.values()[(int) Math
										.floor(Math.random() * (double) FixtureLogLevel.values().length)],
								"This is fixture log message {} of {}, written at {}", tempLogLines, tempTargetLogLines,
								System.currentTimeMillis());
					}
				} else if (Math.random() < 0.1) {
					logger.log(FixtureLogLevel.ERROR, "This is a test exception: {}", "blah",
							new RuntimeException("blahblub"));
				} else {
					if (tempConsoleLines < tempTargetConsoleLines) {
						tempConsoleLines++;
						System.out.println("This is console log message " + tempConsoleLines + " of "
								+ tempTargetConsoleLines + ", written at " + System.currentTimeMillis());
					}
				}

				try {
					Thread.sleep((long) (Math.random() * 10));
				} catch (InterruptedException exc) {
					// ignored
				}
			}
		}
	}

	@FixtureMethod(description = "echoes $echo$")
	public Object returnValue(@FixtureParameter(name = "echo") Object anInput) {
		// throw new RuntimeException("An exception!");
		logStuff();
		return anInput;
	}

	@FixtureMethod(description = "echoes $echo$ and ignores $param1$, $param2$ and $param3$")
	public Object returnValues(@FixtureParameter(name = "echo") Object anInput,
			@FixtureParameter(name = "param1") Object anIgnoredInput1,
			@FixtureParameter(name = "param2") Object anIgnoredInput2,
			@FixtureParameter(name = "param3") Object anIgnoredInput3) {
		// throw new RuntimeException("An exception!");
		return anInput;
	}

	@FixtureMethod(description = "echoes $echo$")
	public Date returnDate(@FixtureParameter(name = "echo") Date anInput) {
		pause();
		// throw new RuntimeException("An exception!");
		return anInput;
	}

	@FixtureMethod(description = "waits for $seconds$ seconds")
	public void wait(@FixtureParameter(name = "seconds") int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException exc) {
			// TODO Auto-generated catch block
			exc.printStackTrace();
		}
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

	@FixtureMethod(description = "this test always returns null")
	public Object returnNull() {
		pause();
		return null;
	}

	@FixtureMethod(description = "this test always returns nulls")
	public String[] returnNullArray(@FixtureParameter(name = "entries") Integer aNumberOfNulls) {
		pause();
		return new String[aNumberOfNulls];
	}

	@FixtureMethod(description = "This always throws an exception. We're so doomed!")
	public boolean throwException() {
		System.out.println("Wow!");
		throw new RuntimeException("Holy shit!");
	}

	@FixtureMethod(description = "This always throws an abort exception. We're slightly less doomed.")
	public boolean throwAbortException() {
		System.out.println("Foo!");
		throw new AbortExecutionException("Holy shit!");
	}

	@FixtureMethod(description = "returns some named results")
	public NamedResultContainer multiResultFixture(@FixtureParameter(name = "param") String aParam) {
		return new NamedResultContainer(aParam, 100);
	}

	@FixtureMethod()
	public TestEnum returnFixedEnum() {
		return TestEnum.VALUE_ONE;
	}

	@FixtureMethod()
	public TestEnum returnEnum(@FixtureParameter(name = "enum") TestEnum anEnum) {
		return anEnum;
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

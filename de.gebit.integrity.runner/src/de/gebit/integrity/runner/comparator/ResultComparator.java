/**
 * 
 */
package de.gebit.integrity.runner.comparator;

import de.gebit.integrity.dsl.MethodReference;
import de.gebit.integrity.dsl.ValueOrEnumValueOrOperationCollection;
import de.gebit.integrity.fixtures.FixtureWrapper;
import de.gebit.integrity.operations.OperationWrapper.UnexecutableException;

/**
 * The result comparator is used to compare a result object returned by a fixture instance with a given expected result
 * (from the test script).
 * 
 * @author Rene Schneider
 * 
 */
public interface ResultComparator {

	/**
	 * Compares the expected result with the actual result obtained from a test fixture.
	 * 
	 * @param aFixtureResult
	 *            the test fixture result
	 * @param anExpectedResult
	 *            the expected result as specified in the test script
	 * @param aFixtureInstance
	 *            the fixture instance that was used
	 * @param aFixtureMethod
	 *            the fixture method that was called
	 * @return true if the comparison was successful, false if the results are not considered equal
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws UnexecutableException
	 */
	boolean compareResult(Object aFixtureResult, ValueOrEnumValueOrOperationCollection anExpectedResult,
			FixtureWrapper<?> aFixtureInstance, MethodReference aFixtureMethod) throws ClassNotFoundException,
			UnexecutableException, InstantiationException;

}

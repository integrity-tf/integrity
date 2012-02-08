/**
 * 
 */
package de.gebit.integrity.fixtures;

/**
 * A custom comparator fixture overrides the default "equals" comparator that is used to compare actual and expected
 * results.
 * 
 * @author Rene Schneider
 * 
 */
public interface CustomComparatorFixture {

	/**
	 * Compares an expected result with an actual result obtained by calling the respective fixture method. In order to
	 * differentiate between different fixture methods, the method name is also provided.
	 * 
	 * @param anExpectedResult
	 *            the result expected by the test script
	 * @param aFixtureResult
	 *            the actual result obtained by calling the fixture
	 * @param aMethodName
	 *            the fixture method name
	 * @return true if both results are considered to match, false otherwise
	 */
	public boolean compareResults(Object anExpectedResult, Object aFixtureResult, String aMethodName);

}

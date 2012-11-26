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
	 *            the (converted) result expected by the test script
	 * @param aFixtureResult
	 *            the actual result obtained by calling the fixture
	 * @param aMethodName
	 *            the fixture method name
	 * @param aPropertyName
	 *            the name of the result property to be compared (null if it's the default result)
	 * @return true if both results are considered to match, false otherwise
	 */
	boolean compareResults(Object anExpectedResult, Object aFixtureResult, String aMethodName, String aPropertyName);

}

/**
 * 
 */
package de.gebit.integrity.operations;


/**
 * Implement this interface in order to create operation classes. An operation is expected to take zero, one or two
 * parameters (which can be arrays, thus containing multiple values) and return a value (can be an array as well).
 * Operations MUST be side-effect free, since there is no guarantee that a given operation statement leads to any
 * specific number of calls to the underlying operation class.<br />
 * <br/>
 * When an operation is to be executed, its class is instantiated using the default constructor, which must be present
 * and accessible. The resulting instance is used only for a single invocation of the {@link #execute(Object, Object)}
 * method.<br/>
 * <br/>
 * The parameter types supported are similar to those supported for {@link de.gebit.integrity.fixtures.FixtureMethod}
 * parameters, minus enumerations. The same is true for result value types. Integrity will perform autoconversion from
 * values given in test scripts into the types expected by a given operation class.
 * 
 * @param <PREFIXPARAM>
 *            the type of the prefix parameter
 * @param <POSTFIXPARAM>
 *            the type of the postfix parameter
 * @param <RESULT>
 *            the result type
 * @author Rene Schneider
 * 
 */
public interface Operation<PREFIXPARAM extends Object, POSTFIXPARAM extends Object, RESULT extends Object> {

	/**
	 * Executes the operation logic.
	 * 
	 * @param aPrefixParameter
	 *            the prefix parameter, or null if none was given
	 * @param aPostfixParameter
	 *            the postfix parameter, or null if none was given
	 * @return the result value
	 */
	RESULT execute(PREFIXPARAM aPrefixParameter, POSTFIXPARAM aPostfixParameter);

}

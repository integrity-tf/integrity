/**
 * 
 */
package de.gebit.integrity.parameter.conversion;

/**
 * This enum offers various ways in which unresolvable variables are to be handled during conversions.
 * 
 * @author Rene Schneider
 * 
 */
public enum UnresolvableVariableHandling {

	/**
	 * Throw an exception.
	 */
	EXCEPTION,

	/**
	 * Resolve to null (the value, not the string 'null').
	 */
	RESOLVE_TO_NULL_VALUE,

	/**
	 * Resolve to the string 'null'.
	 */
	RESOLVE_TO_NULL_STRING,

	/**
	 * Resolve to a string with the name of the variable.
	 */
	RESOLVE_TO_NAME_STRING,

	/**
	 * Resolve to the string '???'.
	 */
	RESOLVE_TO_QUESTIONMARK_STRING,

	/**
	 * Keep the variable reference as-is.
	 */
	KEEP_UNRESOLVED;

}

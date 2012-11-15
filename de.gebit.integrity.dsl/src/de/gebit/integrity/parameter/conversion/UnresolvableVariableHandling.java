/**
 * 
 */
package de.gebit.integrity.parameter.conversion;

/**
 * 
 * 
 * @author Rene Schneider
 * 
 */
public enum UnresolvableVariableHandling {

	EXCEPTION,

	RESOLVE_TO_NULL_VALUE,

	RESOLVE_TO_NULL_STRING,

	RESOLVE_TO_NAME_STRING,

	RESOLVE_TO_QUESTIONMARK_STRING;

}

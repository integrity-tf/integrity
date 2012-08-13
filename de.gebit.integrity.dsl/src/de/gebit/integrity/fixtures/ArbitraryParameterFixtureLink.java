/**
 * 
 */
package de.gebit.integrity.fixtures;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This annotation is used to link an {@link ArbitraryParameterEnumerator} to an implementation of
 * {@link ArbitraryParameterFixture}, for which it will provide the arbitrary parameter suggestions within Eclipse.
 * 
 * 
 * @author Rene Schneider
 * 
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ArbitraryParameterFixtureLink {

	/**
	 * The class that this {@link ArbitraryParameterEnumerator} is linked to.
	 * 
	 * @return
	 */
	Class<? extends ArbitraryParameterFixture> value();

}
package de.gebit.integrity.fixtures;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This annotation must be added to all methods to be denoted as fixture methods.
 * 
 * @author Rene Schneider (rene.schneider@gebit.de)
 * 
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface FixtureMethod {

	/**
	 * The name of the method. This value is optional; if it is not provided, the name of the method itself will be used
	 * as fixture method name.
	 * 
	 * @return
	 */
	String name() default "";

	/**
	 * The description for the method. This text is intended to be a human-readable description of
	 * "what the fixture does". It is highly suggested to provide such a description, since it's one of the main
	 * mechanisms used by Integrity to create human-readable test results.<br>
	 * <br>
	 * You may use placeholder values in the description string enclosed in dolar signs, like this: $parameter$. These
	 * will be replaced by the matching parameter values at runtime.
	 * 
	 * @return
	 */
	String description() default "";

}

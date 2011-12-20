package de.gebit.integrity.fixtures;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This annotation has to be added to each fixture parameter.
 * 
 * @author Rene Schneider (rene.schneider@gebit.de)
 * 
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
public @interface FixtureParameter {

	/**
	 * The name of the parameter. Required, because the parameter names used in the method signature aren't available at
	 * runtime, thus they cannot be used as any kind of default.
	 * 
	 * @return
	 */
	String name();

	/**
	 * Whether the parameter must be provided or is optional.
	 * 
	 * @return
	 */
	boolean optional() default false;

}

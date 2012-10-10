package de.gebit.integrity.fixtures;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This annotation must be added to all methods to be denoted as fixture methods. Fixtures are the primary way for
 * Integrity test scripts to interact with the System Under Test. Fixture classes implement fixture methods for this
 * purpose, which are then referenced in test scripts. <br>
 * <br>
 * The way to implement a fixture method is to take any POJO class and implement a method of any desired name. This
 * method must be decorated with the {@link FixtureMethod} annotation to be called by Integrity. Parameters may be
 * created by simply adding standard Java parameters to the method in question, annotated with a
 * {@link FixtureParameter} annotation. Integrity will take care of the necessary conversions of user-provided data into
 * the parameter data types, but the parameters may only use one of the following supported types:<br>
 * <br>
 * <ul>
 * <li>String</li>
 * <li>Byte</li>
 * <li>Short</li>
 * <li>Integer</li>
 * <li>Long</li>
 * <li>BigInteger</li>
 * <li>Float</li>
 * <li>Double</li>
 * <li>BigDecimal</li>
 * <li>an Enumeration</li>
 * <li>and the array variants of these types</li>
 * </ul>
 * <br>
 * The method may return either nothing at all, a value of one of the supported types, or an instance of a custom class
 * that acts as a container for multiple named result values. The first two cases are suited for use in test and call
 * statements, while the latter is suitable for test statements with named results.
 * 
 * @author Rene Schneider
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
	 * You may use placeholder values in the description string enclosed in dollar signs, like this: $parameter$. These
	 * will be replaced by the matching parameter values at runtime.
	 * 
	 * @return
	 */
	String description() default "";

}

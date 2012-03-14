package de.gebit.integrity.fixtures;

import java.util.Map;

/**
 * Interface for fixtures that allow for arbitrary, non-predetermined parameters to be specified. Fixtures that want to
 * use the arbitrary parameter system must implement this interface class, and they must implement
 * {@link #defineArbitraryParameters(String, Map)} and {@link #defineArbitraryResults(String, Map)}, though they don't
 * necessarily have to return any parameter definitions or results (for example they might choose to only support
 * parameters, not results).<br>
 * <br>
 * Fixture methods with arbitrary parameters generally look like normal fixture methods and may contain fixed parameters
 * as well, but they are required to add a single {@link Map}<String, Object> parameter, which will be used to supply
 * the arbitrary parameters. That map doesn't have to have an attached {@link FixtureParameter} annotation like fixed
 * parameters.<br>
 * <br>
 * Usually, arbitrary parameter fixture classes are used in conjunction with an {@link ArbitraryParameterEnumerator} for
 * each. The enumerator class gets linked to its fixture class and is responsible for providing information about valid
 * parameters for content assist during test script editing, while the fixture class provides information about valid
 * parameters for type conversion purposes at runtime.
 * 
 * 
 * @author Rene Schneider
 * 
 */
public abstract interface ArbitraryParameterFixture {

	/**
	 * Returns a list of valid parameters that will be added to the fixed parameter to any of the fixture methods in
	 * this fixture class. <br \>
	 * <br \>
	 * This method will be called by the Integrity Test Runner in order to determine the types into which to convert
	 * values found in test scripts. There's a very similar other method,
	 * {@link ArbitraryParameterEnumerator#defineArbitraryParameters(String, Map)}, which is called in Eclipse for
	 * content assist purposes. <br \>
	 * <br \>
	 * The idea behind the arbitrary parameter mechanism is for this method to compute all available arbitrary params
	 * with respect to the fixed parameters and the method being called. Note that this information is not used to
	 * actually limit the parameters that may be entered by the user, but only for providing autocompletion and content
	 * assist as well as automatic conversion of values. The user may still enter a parameter of any name, which will
	 * then be passed to the fixture method without any value conversion.
	 * 
	 * @param aFixtureMethodName
	 *            The name of the fixture method being called or entered
	 * @param someFixedParameters
	 *            A map of fixed parameters and values
	 * @return A list with definitions of arbitrary parameters.
	 */
	Map<String, Class<?>> defineArbitraryParameters(String aFixtureMethodName, Map<String, Object> someFixedParameters);

	/**
	 * Returns a list of valid result names. This basically works like
	 * {@link #defineArbitraryParameters(String, Map, boolean)}, but is used to determine named result identifiers.
	 * 
	 * @param aFixtureMethodName
	 * @param someFixedParameters
	 * @return
	 */
	Map<String, Class<?>> defineArbitraryResults(String aFixtureMethodName, Map<String, Object> someFixedParameters);

}

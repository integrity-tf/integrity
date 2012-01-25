package de.gebit.integrity.fixtures;

import java.util.List;
import java.util.Map;

/**
 * Abstract base class for fixtures that allow for arbitrary, non-predetermined parameters to be specified. Fixtures
 * that want to use the arbitrary parameter system must extend this base fixture class, and they must implement
 * {@link #defineArbitraryParameters(String, Map, EclipseResourceProvider)}, though they don't necessarily have to
 * return any parameter definitions.<br>
 * <br>
 * Fixture methods with arbitrary parameters generally look like normal fixture methods and may contain fixed parameters
 * as well, but they are required to add a single {@link Map}<String, Object> parameter, which will be used to supply
 * the arbitrary parameters. That map doesn't have to have an attached {@link FixtureParameter} annotation like fixed
 * parameters.
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
	 * This method will be called by both the Integrity Test Runner as well as the editor inside Eclipse, thus it is
	 * very important that it is equally executable with the same result in both of these cases. It will get the name of
	 * the fixture method in question, all fixed parameters that have been defined (yet, in case of the method being
	 * called in Eclipse), and a resource provider if called inside Eclipse. <br \>
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
	 * @param aCalledInEclipseFlag
	 *            Whether the method is being called inside Eclipse
	 * @return A list with definitions of arbitrary parameters.
	 */
	List<ArbitraryParameterDefinition> defineArbitraryParameters(String aFixtureMethodName,
			Map<String, Object> someFixedParameters, boolean aCalledInEclipseFlag);

	/**
	 * Returns a list of valid result names. This basically works like
	 * {@link #defineArbitraryParameters(String, Map, boolean)}, but is used to determine named result identifiers.
	 * 
	 * @param aFixtureMethodName
	 * @param someFixedParameters
	 * @param aCalledInEclipseFlag
	 * @return
	 */
	List<ArbitraryParameterDefinition> defineArbitraryResults(String aFixtureMethodName,
			Map<String, Object> someFixedParameters, boolean aCalledInEclipseFlag);

	/**
	 * A container for the definition of one arbitrary parameter.
	 * 
	 * @author Rene Schneider
	 * 
	 */
	public class ArbitraryParameterDefinition {

		/**
		 * The name of the parameter.
		 */
		private String name;

		/**
		 * The target data type. While running a test, Integrity will provide automatic conversion of the value given by
		 * the user to the provided type, throwing an exception if that conversion is not possible.
		 */
		private Class<?> type;

		/**
		 * The description which will appear next to the parameter name in the content assist window. This value is
		 * optional and won't be used when
		 * {@link ArbitraryParameterFixture#defineArbitraryParameters(String, Map, boolean)} was called during test
		 * execution.
		 */
		private String description;

		/**
		 * Creates a new instance.
		 * 
		 * @param aName
		 *            The parameter name
		 * @param aType
		 *            The target data type
		 * @param aDescription
		 *            The description for content assist
		 */
		public ArbitraryParameterDefinition(String aName, Class<?> aType, String aDescription) {
			name = aName;
			type = aType;
			description = aDescription;
		}

		public String getName() {
			return name;
		}

		public Class<?> getType() {
			return type;
		}

		public String getDescription() {
			return description;
		}

	}

}

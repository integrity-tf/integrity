/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider (GEBIT Solutions GmbH) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.fixtures;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Implementations of this class are used to provide an enumeration of all available arbitrary parameters for a fixture
 * class in Eclipse while test scripts are being edited. You must link implementations to their respective fixture
 * classes using {@link ArbitraryParameterFixtureLink}.<br>
 * <br>
 * Instances of this class must be instantiable using the default no-arg constructor. They will be instantiated inside
 * the Eclipse JVM.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public interface ArbitraryParameterEnumerator {

	/**
	 * Returns a list of valid parameters that will be added to the fixed parameter to any of the fixture methods in the
	 * fixture class that this enumerator is connected to. <br \>
	 * <br \>
	 * This method will be called by the editor inside Eclipse; it is the counterpart of
	 * {@link ArbitraryParameterFixture#defineArbitraryParameters(String, Map)}, thus it is expected to return the same
	 * parameters. The name of the fixture method in question is provided, as well as all fixed parameters that have
	 * been defined yet. <br \>
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
	 * @param aNestedObjectPath
	 *            A path to the current position in a nested object (null if not in a nested object; this can be used to
	 *            optimize the amount of information to return)
	 * @return A list with definitions of arbitrary parameters.
	 */
	List<ArbitraryParameterDefinition> defineArbitraryParameters(String aFixtureMethodName,
			Map<String, Object> someFixedParameters, List<String> aNestedObjectPath);

	/**
	 * Returns a list of valid result names. This basically works like
	 * {@link #defineArbitraryParameters(String, Map, boolean)}, but is used to determine named result identifiers.
	 * 
	 * @param aFixtureMethodName
	 * @param someFixedParameters
	 * @param aNestedObjectPath
	 * @return
	 */
	List<ArbitraryParameterDefinition> defineArbitraryResults(String aFixtureMethodName,
			Map<String, Object> someFixedParameters, List<String> aNestedObjectPath);

	/**
	 * A container for the definition of one arbitrary parameter.
	 * 
	 * @author Rene Schneider - initial API and implementation
	 * 
	 */
	public class ArbitraryParameterDefinition {

		/**
		 * The name of the parameter.
		 */
		private String name;

		/**
		 * The description which will appear next to the parameter name in the content assist window. This value is
		 * optional and won't be used when
		 * {@link ArbitraryParameterFixture#defineArbitraryParameters(String, Map, boolean)} was called during test
		 * execution.
		 */
		private String description;

		/**
		 * What to add after the parameter. Optional - if not present, a default is used (usually a colon in case of
		 * parameters and an equals sign in case of results). This is ignored in case of tabletests and inside nested
		 * objects!
		 */
		private ArbitraryParameterSuffix suffix;

		/**
		 * Whether this is a parameter that shall contain a nested object. If this is set, the required brackets are
		 * autocreated.
		 */
		private boolean nestedObjectParam;

		/**
		 * Subdefinitions in case of nested objects/parameters.
		 */
		private List<ArbitraryParameterDefinition> subdefinitions = new ArrayList<ArbitraryParameterDefinition>();

		/**
		 * Creates a new instance.
		 * 
		 * @param aName
		 *            The parameter name
		 * @param aDescription
		 *            The description for content assist
		 */
		public ArbitraryParameterDefinition(String aName, String aDescription) {
			name = aName;
			description = aDescription;
		}

		/**
		 * Creates a new instance.
		 * 
		 * @param aName
		 *            The parameter name
		 * @param aDescription
		 *            The description for content assist
		 * @param aSuffix
		 *            What to add after the parameter.
		 * @param anIsNestedObjectParamFlag
		 *            Whether this is a parameter that will contain a nested object.
		 */
		public ArbitraryParameterDefinition(String aName, String aDescription, ArbitraryParameterSuffix aSuffix,
				boolean anIsNestedObjectParamFlag) {
			name = aName;
			description = aDescription;
			suffix = aSuffix;
			nestedObjectParam = anIsNestedObjectParamFlag;
		}

		public String getName() {
			return name;
		}

		public String getDescription() {
			return description;
		}

		public ArbitraryParameterSuffix getSuffix() {
			return suffix;
		}

		public boolean isNestedObjectParam() {
			return nestedObjectParam;
		}

		public void setName(String aName) {
			this.name = aName;
		}

		public void setDescription(String aDescription) {
			this.description = aDescription;
		}

		public void setSuffix(ArbitraryParameterSuffix aSuffix) {
			this.suffix = aSuffix;
		}

		public void setNestedObjectParam(boolean aNestedObjectParam) {
			this.nestedObjectParam = aNestedObjectParam;
		}

		/**
		 * Adds a subdefinition.
		 * 
		 * @param aSubdefinition
		 *            the subdefinition to add
		 */
		public void addSubdefinition(ArbitraryParameterDefinition aSubdefinition) {
			subdefinitions.add(aSubdefinition);
		}

		public List<ArbitraryParameterDefinition> getSubdefinitions() {
			return subdefinitions;
		}

		/**
		 * Checks whether this definition has any subdefinitions.
		 * 
		 * @return true if subdefinitions are present
		 */
		public boolean hasSubdefinitions() {
			return subdefinitions.size() > 0;
		}

		/**
		 * Searches a subdefinition by name.
		 * 
		 * @param aName
		 *            the name to search for
		 * @return the subdefinition or null if not found
		 */
		public ArbitraryParameterDefinition getSubdefinitionByName(String aName) {
			for (ArbitraryParameterDefinition tempSubdefinition : subdefinitions) {
				if (aName.equals(tempSubdefinition.getName())) {
					return tempSubdefinition;
				}
			}
			return null;
		}

		/**
		 * Resolves a path of subdefinitions starting with the current definition (which must be the root of the path!).
		 * 
		 * @param aPath
		 *            the path to follow
		 * @return the subdefinition at the end of the path, or null if none was found
		 */
		public ArbitraryParameterDefinition getSubdefinitionByPath(List<String> aPath) {
			ArbitraryParameterDefinition tempDefinitionInFocus = null;
			for (String tempPathPart : aPath) {
				if (tempDefinitionInFocus == null) {
					if ((getName() == null && tempPathPart == null) || tempPathPart.equals(getName())) {
						tempDefinitionInFocus = this;
					} else {
						return null;
					}
				} else {
					tempDefinitionInFocus = tempDefinitionInFocus.getSubdefinitionByName(tempPathPart);
					if (tempDefinitionInFocus == null) {
						return null;
					}
				}
			}

			return tempDefinitionInFocus;
		}

	}

	/**
	 * The suffix types that may follow a parameter name in a suggestion.
	 * 
	 * 
	 * @author Rene Schneider - initial API and implementation
	 * 
	 */
	public enum ArbitraryParameterSuffix {

		/**
		 * A colon.
		 */
		COLON(": "),

		/**
		 * An equals sign.
		 */
		EQUALS(" = "),

		/**
		 * A space.
		 */
		SPACE(" ");

		/**
		 * Textual representation of the suffix.
		 */
		private String text;

		private ArbitraryParameterSuffix(String aText) {
			text = aText;
		}

		public String getText() {
			return text;
		}

	}

}

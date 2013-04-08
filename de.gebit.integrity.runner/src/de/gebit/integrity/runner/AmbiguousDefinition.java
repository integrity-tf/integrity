/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.runner;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

/**
 * Represents an ambiguous definition in a test model. This may refer to ambiguous suites, variables, etc. - these are
 * differentiated by the type string.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class AmbiguousDefinition {

	/**
	 * The qualified name of the definition.
	 */
	private String qualifiedName;

	/**
	 * The type of the definition.
	 */
	private String type;

	/**
	 * All definitions which resolve to the same qualified name and type.
	 */
	private List<EObject> definitions = new ArrayList<EObject>(0);

	/**
	 * Creates a new instance.
	 * 
	 * @param aQualifiedName
	 *            the qualified name
	 * @param aType
	 *            the type of the definition
	 * @param aFirstDefinition
	 *            the first definition to add
	 */
	public AmbiguousDefinition(String aQualifiedName, String aType, EObject aFirstDefinition) {
		qualifiedName = aQualifiedName;
		type = aType;
		definitions.add(aFirstDefinition);
	}

	/**
	 * Adds another definition.
	 * 
	 * @param aDefinition
	 *            the definition to add
	 */
	public void addDefinition(EObject aDefinition) {
		definitions.add(aDefinition);
	}

	public List<EObject> getDefinitions() {
		return definitions;
	}

	public String getType() {
		return type;
	}

	public String getQualifiedName() {
		return qualifiedName;
	}

	/**
	 * Calculates a key string by which this definition is identified.
	 * 
	 * @return the key
	 */
	public String getKey() {
		return qualifiedName + "|" + type;
	}

	@Override
	public int hashCode() {
		return getKey().hashCode();
	}

	@Override
	public boolean equals(Object anObject) {
		if (!(anObject instanceof AmbiguousDefinition)) {
			return false;
		}

		AmbiguousDefinition tempOtherObject = (AmbiguousDefinition) anObject;

		return getKey().equals(tempOtherObject.getKey());
	}

}

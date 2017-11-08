/*******************************************************************************
 * Copyright (c) 2017 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.docgen;

import java.util.ArrayList;

import de.gebit.integrity.dsl.ConstantDefinition;
import de.gebit.integrity.dsl.SuiteDefinition;

/**
 * Represents an Integrity package with all content relevant for documentation generation.
 *
 * @author Rene Schneider - initial API and implementation
 *
 */
public class IntegrityPackage {

	/**
	 * The name of the package.
	 */
	private String name;

	/**
	 * The suites contained within the package.
	 */
	private ArrayList<SuiteDefinition> suites = new ArrayList<>();

	/**
	 * The constants within the package.
	 */
	private ArrayList<ConstantDefinition> constants = new ArrayList<ConstantDefinition>();

	/**
	 * Constructor.
	 * 
	 * @param aName
	 */
	public IntegrityPackage(String aName) {
		name = aName;
	}

	public String getName() {
		return name;
	}

	public ArrayList<SuiteDefinition> getSuites() {
		return suites;
	}

	public ArrayList<ConstantDefinition> getConstants() {
		return constants;
	}

	public boolean isEmpty() {
		return suites.isEmpty() && constants.isEmpty();
	}

	/**
	 * Adds the provided entity.
	 * 
	 * @param aSuite
	 */
	public void add(SuiteDefinition aSuite) {
		if (!suites.contains(aSuite)) {
			suites.add(aSuite);
		}
	}

	/**
	 * Adds the provided entity.
	 * 
	 * @param aConstant
	 */
	public void add(ConstantDefinition aConstant) {
		if (!constants.contains(aConstant)) {
			constants.add(aConstant);
		}
	}

}

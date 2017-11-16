/*******************************************************************************
 * Copyright (c) 2017 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.docgen;

import java.util.Collection;
import java.util.Comparator;
import java.util.TreeSet;

import org.eclipse.emf.ecore.EObject;

import de.gebit.integrity.dsl.CallDefinition;
import de.gebit.integrity.dsl.ConstantDefinition;
import de.gebit.integrity.dsl.SuiteDefinition;
import de.gebit.integrity.dsl.TestDefinition;

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
	private Collection<SuiteDefinition> suites = new TreeSet<>(new Comparator<SuiteDefinition>() {

		@Override
		public int compare(SuiteDefinition aFirst, SuiteDefinition aSecond) {
			return aFirst.getName().compareTo(aSecond.getName());
		}
	});

	/**
	 * The constants within the package.
	 */
	private Collection<ConstantDefinition> constants = new TreeSet<ConstantDefinition>(
			new Comparator<ConstantDefinition>() {

				@Override
				public int compare(ConstantDefinition aFirst, ConstantDefinition aSecond) {
					return aFirst.getName().getName().compareTo(aSecond.getName().getName());
				}
			});

	/***
	 * Call fixture definitions within the package.
	 */
	private Collection<CallDefinition> calls = new TreeSet<CallDefinition>(new Comparator<CallDefinition>() {

		@Override
		public int compare(CallDefinition aFirst, CallDefinition aSecond) {
			return aFirst.getName().compareTo(aSecond.getName());
		}
	});

	/**
	 * Test fixture definitions within the package.
	 */
	private Collection<TestDefinition> tests = new TreeSet<TestDefinition>(new Comparator<TestDefinition>() {

		@Override
		public int compare(TestDefinition aFirst, TestDefinition aSecond) {
			return aFirst.getName().compareTo(aSecond.getName());
		}
	});

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

	public Collection<SuiteDefinition> getSuites() {
		return suites;
	}

	public Collection<ConstantDefinition> getConstants() {
		return constants;
	}

	public Collection<CallDefinition> getCalls() {
		return calls;
	}

	public Collection<TestDefinition> getTests() {
		return tests;
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

	/**
	 * Adds the provided entity.
	 * 
	 * @param aCall
	 */
	public void add(CallDefinition aCall) {
		if (!calls.contains(aCall)) {
			calls.add(aCall);
		}
	}

	/**
	 * Adds the provided entity.
	 * 
	 * @param aTest
	 */
	public void add(TestDefinition aTest) {
		if (!tests.contains(aTest)) {
			tests.add(aTest);
		}
	}

	/**
	 * Adds the provided entity. This dispatches the add to the appropriate method.
	 * 
	 * @param anEntity
	 */
	public void add(EObject anEntity) {
		if (anEntity instanceof SuiteDefinition) {
			add((SuiteDefinition) anEntity);
		} else if (anEntity instanceof ConstantDefinition) {
			add((ConstantDefinition) anEntity);
		} else if (anEntity instanceof CallDefinition) {
			add((CallDefinition) anEntity);
		} else if (anEntity instanceof TestDefinition) {
			add((TestDefinition) anEntity);
		} else {
			throw new IllegalArgumentException("Unknown entity type: " + anEntity.getClass().getName());
		}
	}

}

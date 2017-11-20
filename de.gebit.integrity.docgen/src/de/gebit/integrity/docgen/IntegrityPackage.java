/*******************************************************************************
 * Copyright (c) 2017 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.docgen;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import org.eclipse.emf.ecore.EObject;

import de.gebit.integrity.dsl.CallDefinition;
import de.gebit.integrity.dsl.ConstantDefinition;
import de.gebit.integrity.dsl.SuiteDefinition;
import de.gebit.integrity.dsl.TestDefinition;
import de.gebit.integrity.dsl.VariantDefinition;
import de.gebit.integrity.dsl.VariantValue;

/**
 * Represents an Integrity package with all content relevant for documentation generation.
 *
 * @author Rene Schneider - initial API and implementation
 *
 */
public class IntegrityPackage implements Comparable<IntegrityPackage> {

	/**
	 * The name of the package.
	 */
	protected String name;

	/**
	 * The suites contained within the package.
	 */
	protected Collection<SuiteDefinition> suites = new TreeSet<>(new Comparator<SuiteDefinition>() {

		@Override
		public int compare(SuiteDefinition aFirst, SuiteDefinition aSecond) {
			return aFirst.getName().compareTo(aSecond.getName());
		}
	});

	/**
	 * The constants within the package.
	 */
	protected Collection<ConstantDefinition> constants = new TreeSet<ConstantDefinition>(
			new Comparator<ConstantDefinition>() {

				@Override
				public int compare(ConstantDefinition aFirst, ConstantDefinition aSecond) {
					return aFirst.getName().getName().compareTo(aSecond.getName().getName());
				}
			});

	/***
	 * Call fixture definitions within the package.
	 */
	protected Collection<CallDefinition> calls = new TreeSet<CallDefinition>(new Comparator<CallDefinition>() {

		@Override
		public int compare(CallDefinition aFirst, CallDefinition aSecond) {
			return aFirst.getName().compareTo(aSecond.getName());
		}
	});

	/**
	 * Test fixture definitions within the package.
	 */
	protected Collection<TestDefinition> tests = new TreeSet<TestDefinition>(new Comparator<TestDefinition>() {

		@Override
		public int compare(TestDefinition aFirst, TestDefinition aSecond) {
			return aFirst.getName().compareTo(aSecond.getName());
		}
	});

	/**
	 * Variant definitions within the package.
	 */
	protected Collection<VariantDefinition> variants = new TreeSet<VariantDefinition>(
			new Comparator<VariantDefinition>() {

				@Override
				public int compare(VariantDefinition aFirst, VariantDefinition aSecond) {
					return aFirst.getName().compareTo(aSecond.getName());
				}
			});

	/**
	 * Maps each {@link VariantDefinition} to a collection of constants influenced by the variant.
	 */
	protected Map<VariantDefinition, List<ConstantDefinition>> variantToConstantMap = new HashMap<>();

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

	public Collection<VariantDefinition> getVariants() {
		return variants;
	}

	/**
	 * Finds all constants that are influenced by the given variant.
	 * 
	 * @param aVariant
	 * @return
	 */
	public Collection<ConstantDefinition> getConstantsInfluencedByVariant(VariantDefinition aVariant) {
		return variantToConstantMap.get(aVariant);
	}

	public boolean isEmpty() {
		return suites.isEmpty() && constants.isEmpty() && calls.isEmpty() && tests.isEmpty() && variants.isEmpty();
	}

	/**
	 * Adds the provided entity. This dispatches the add to the appropriate method.
	 * 
	 * @param anEntity
	 */
	public void add(EObject anEntity) {
		if (anEntity instanceof SuiteDefinition) {
			suites.add((SuiteDefinition) anEntity);
		} else if (anEntity instanceof ConstantDefinition) {
			constants.add((ConstantDefinition) anEntity);
		} else if (anEntity instanceof CallDefinition) {
			calls.add((CallDefinition) anEntity);
		} else if (anEntity instanceof TestDefinition) {
			tests.add((TestDefinition) anEntity);
		} else if (anEntity instanceof VariantDefinition) {
			variants.add((VariantDefinition) anEntity);
		} else {
			throw new IllegalArgumentException("Unknown entity type: " + anEntity.getClass().getName());
		}
	}

	/**
	 * Is called when all {@link IntegrityPackage} objects have been filled with their respective entities, in order to
	 * be able to perform cross-package linking jobs.
	 * 
	 * @param somePackages
	 *            all the packages (including our own!)
	 */
	public void postProcess(Collection<IntegrityPackage> somePackages) {
		// Find constants influenced by all variants defined in this package
		for (VariantDefinition tempVariant : variants) {
			variantToConstantMap.put(tempVariant, new ArrayList<>());
		}

		if (variantToConstantMap.size() > 0) {
			for (IntegrityPackage tempOtherPackage : somePackages) {
				for (ConstantDefinition tempConstant : tempOtherPackage.getConstants()) {
					for (VariantValue tempVariantValue : tempConstant.getVariantValues()) {
						for (VariantDefinition tempVariant : tempVariantValue.getNames()) {
							List<ConstantDefinition> tempList = variantToConstantMap.get(tempVariant);
							if (tempList != null) {
								tempList.add(tempConstant);
							}
						}
					}
				}
			}
		}

		for (List<ConstantDefinition> tempList : variantToConstantMap.values()) {
			Collections.sort(tempList, new Comparator<ConstantDefinition>() {

				@Override
				public int compare(ConstantDefinition aFirst, ConstantDefinition aSecond) {
					return aFirst.getName().getName().compareTo(aSecond.getName().getName());
				}
			});
		}
	}

	@Override
	public int compareTo(IntegrityPackage anOther) {
		return name.compareTo(anOther.name);
	}

}

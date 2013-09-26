/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.runner.modelcheck;

import java.util.HashSet;
import java.util.Set;

import com.google.inject.Inject;

import de.gebit.integrity.dsl.Call;
import de.gebit.integrity.dsl.MethodReference;
import de.gebit.integrity.dsl.TableTest;
import de.gebit.integrity.dsl.Test;
import de.gebit.integrity.modelsource.ModelSourceExplorer;
import de.gebit.integrity.modelsource.ModelSourceInformationElement;
import de.gebit.integrity.runner.classloading.IntegrityClassLoader;
import de.gebit.integrity.runner.exceptions.MethodNotFoundException;
import de.gebit.integrity.runner.exceptions.ModelRuntimeLinkException;

/**
 * Default implementation of a {@link ModelChecker}.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class DefaultModelChecker implements ModelChecker {

	/**
	 * The classloader to use for class resolving.
	 */
	@Inject
	protected IntegrityClassLoader classLoader;

	/**
	 * The model source explorer.
	 */
	@Inject
	protected ModelSourceExplorer modelSourceExplorer;

	@Override
	public void check(Test aTest) throws ModelRuntimeLinkException {
		if (aTest.getDefinition() == null) {
			throw new ModelRuntimeLinkException("Failed to resolve test definition for test statement '"
					+ aTest.toString() + "'", aTest);
		} else if (aTest.getDefinition().getFixtureMethod() == null
				|| aTest.getDefinition().getFixtureMethod().getMethod() == null) {
			throw new ModelRuntimeLinkException("Failed to resolve test fixture for test definition '"
					+ aTest.getDefinition().getName() + "' (" + aTest.getDefinition() + ")", aTest);
		}

		tryFixtureMethodResolve(aTest.getDefinition().getFixtureMethod());
	}

	@Override
	public void check(Call aCall) throws ModelRuntimeLinkException {
		if (aCall.getDefinition() == null) {
			throw new ModelRuntimeLinkException("Failed to resolve call definition for call statement '"
					+ aCall.toString() + "'", aCall);
		} else if (aCall.getDefinition().getFixtureMethod() == null
				|| aCall.getDefinition().getFixtureMethod().getMethod() == null) {
			throw new ModelRuntimeLinkException("Failed to resolve call fixture for call definition '"
					+ aCall.getDefinition().getName() + "' (" + aCall.getDefinition() + ")", aCall);
		}

		tryFixtureMethodResolve(aCall.getDefinition().getFixtureMethod());
	}

	@Override
	public void check(TableTest aTableTest) throws ModelRuntimeLinkException {
		if (aTableTest.getDefinition() == null) {
			throw new ModelRuntimeLinkException("Failed to resolve test definition for tabletest statement '"
					+ aTableTest.toString() + "'", aTableTest);
		} else if (aTableTest.getDefinition().getFixtureMethod() == null
				|| aTableTest.getDefinition().getFixtureMethod().getMethod() == null) {
			throw new ModelRuntimeLinkException("Failed to resolve test fixture for test definition '"
					+ aTableTest.getDefinition().getName() + "' (" + aTableTest.getDefinition() + ")", aTableTest);
		}

		tryFixtureMethodResolve(aTableTest.getDefinition().getFixtureMethod());
	}

	/**
	 * Used to keep track on which methods a class loading has already been attempted. Subsequent loadings are assumed
	 * to deliver the same result and thus omittable.
	 */
	private Set<MethodReference> resolvedMethods = new HashSet<MethodReference>();

	private void tryFixtureMethodResolve(MethodReference aMethodReference) {
		if (resolvedMethods.contains(aMethodReference)) {
			return;
		}
		resolvedMethods.add(aMethodReference);

		try {
			classLoader.loadMethod(aMethodReference);
		} catch (ClassNotFoundException exc) {
			ModelSourceInformationElement tempSourceInfo = modelSourceExplorer
					.determineSourceInformation(aMethodReference);
			String tempClassName = tempSourceInfo.getSnippet().split("#")[0].trim();
			throw new ModelRuntimeLinkException("Failed to resolve fixture class '" + tempClassName
					+ "' referenced at " + tempSourceInfo, aMethodReference, exc);
		} catch (MethodNotFoundException exc) {
			ModelSourceInformationElement tempSourceInfo = modelSourceExplorer
					.determineSourceInformation(aMethodReference);
			throw new ModelRuntimeLinkException("Failed to resolve fixture method '" + exc.getMessage()
					+ "' referenced at " + tempSourceInfo, aMethodReference, exc);
		}
	}

}

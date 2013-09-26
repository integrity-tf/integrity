/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.runner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.inject.Inject;
import com.google.inject.Injector;

import de.gebit.integrity.dsl.CallDefinition;
import de.gebit.integrity.dsl.ConstantDefinition;
import de.gebit.integrity.dsl.ConstantEntity;
import de.gebit.integrity.dsl.ForkDefinition;
import de.gebit.integrity.dsl.Model;
import de.gebit.integrity.dsl.PackageDefinition;
import de.gebit.integrity.dsl.SuiteDefinition;
import de.gebit.integrity.dsl.TestDefinition;
import de.gebit.integrity.dsl.VariableDefinition;
import de.gebit.integrity.dsl.VariableEntity;
import de.gebit.integrity.dsl.VariableOrConstantEntity;
import de.gebit.integrity.dsl.VariantDefinition;
import de.gebit.integrity.modelsource.ModelSourceExplorer;
import de.gebit.integrity.runner.callbacks.TestRunnerCallback;
import de.gebit.integrity.runner.exceptions.ModelAmbiguousException;
import de.gebit.integrity.runner.exceptions.ModelLinkException;
import de.gebit.integrity.runner.exceptions.ModelLoadException;
import de.gebit.integrity.runner.exceptions.ModelParseException;
import de.gebit.integrity.runner.providers.TestResourceProvider;
import de.gebit.integrity.utils.IntegrityDSLUtil;

/**
 * The test model. There's not much more to say ;-)
 * 
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class TestModel {

	/**
	 * All models. Every file is a model of itself (though they are all linked, of course).
	 */
	protected List<Model> models;

	/**
	 * Suite names -> Suites.
	 */
	protected Map<String, SuiteDefinition> suiteMap = new HashMap<String, SuiteDefinition>();

	/**
	 * Variant names -> Variants.
	 */
	protected Map<String, VariantDefinition> variantMap = new HashMap<String, VariantDefinition>();

	/**
	 * Fork names -> Forks.
	 */
	protected Map<String, ForkDefinition> forkMap = new HashMap<String, ForkDefinition>();

	/**
	 * Call names -> Calls.
	 */
	protected Map<String, CallDefinition> callMap = new HashMap<String, CallDefinition>();

	/**
	 * Test names -> Tests.
	 */
	protected Map<String, TestDefinition> testMap = new HashMap<String, TestDefinition>();

	/**
	 * Variable/constant names -> Entities.
	 */
	protected Map<String, VariableOrConstantEntity> variableAndConstantMap = new HashMap<String, VariableOrConstantEntity>();

	/**
	 * Ambiguous definitions which are found during variable/suite/etc. indexing are collected here.
	 */
	protected Set<AmbiguousDefinition> ambiguousDefinitions = new HashSet<AmbiguousDefinition>();

	/**
	 * The Google Guice Injector.
	 */
	@Inject
	protected Injector injector;

	/**
	 * The model source explorer.
	 */
	@Inject
	protected ModelSourceExplorer modelSourceExplorer;

	/**
	 * Creates a new model from a bunch of single models (files).
	 * 
	 * @param someModels
	 *            the models
	 */
	protected TestModel(List<Model> someModels) {
		models = someModels;

		Map<String, AmbiguousDefinition> tempDuplicateMap = new HashMap<String, AmbiguousDefinition>();

		// Scan all models for suite definitions and variants and put them into the maps for fast access.
		// Also search for duplicate definitions! Test Models with duplicate definitions are technically fine, but
		// they may very likely result in strange behavior during execution, as the definition that is actually used
		// when for example a variable with multiple definitions is accessed is not predictable.
		for (Model tempModel : models) {
			TreeIterator<EObject> tempIter = tempModel.eAllContents();
			while (tempIter.hasNext()) {
				EObject tempObject = tempIter.next();
				String tempFullyQualifiedName = null;
				String tempType;

				if (tempObject instanceof SuiteDefinition) {
					SuiteDefinition tempSuite = (SuiteDefinition) tempObject;
					tempFullyQualifiedName = IntegrityDSLUtil.getQualifiedSuiteName(tempSuite);
					suiteMap.put(tempFullyQualifiedName, tempSuite);
					tempType = "suite";
				} else if (tempObject instanceof VariantDefinition) {
					VariantDefinition tempVariant = (VariantDefinition) tempObject;
					tempFullyQualifiedName = IntegrityDSLUtil.getQualifiedVariantName(tempVariant);
					variantMap.put(tempFullyQualifiedName, tempVariant);
					tempType = "variant";
				} else if (tempObject instanceof ForkDefinition) {
					ForkDefinition tempFork = (ForkDefinition) tempObject;
					tempFullyQualifiedName = IntegrityDSLUtil.getQualifiedForkName(tempFork);
					forkMap.put(tempFullyQualifiedName, tempFork);
					tempType = "fork";
				} else if (tempObject instanceof CallDefinition) {
					CallDefinition tempCall = (CallDefinition) tempObject;
					tempFullyQualifiedName = IntegrityDSLUtil.getQualifiedCallName(tempCall);
					callMap.put(tempFullyQualifiedName, tempCall);
					tempType = "call";
				} else if (tempObject instanceof TestDefinition) {
					TestDefinition tempTest = (TestDefinition) tempObject;
					tempFullyQualifiedName = IntegrityDSLUtil.getQualifiedTestName(tempTest);
					testMap.put(tempFullyQualifiedName, tempTest);
					tempType = "test";
				} else if (tempObject instanceof VariableDefinition) {
					VariableEntity tempEntity = ((VariableDefinition) tempObject).getName();
					tempFullyQualifiedName = IntegrityDSLUtil.getQualifiedVariableEntityName(tempEntity, true);
					variableAndConstantMap.put(tempFullyQualifiedName, tempEntity);
					tempType = "variable/constant";
				} else if (tempObject instanceof ConstantDefinition) {
					ConstantEntity tempEntity = ((ConstantDefinition) tempObject).getName();
					tempFullyQualifiedName = IntegrityDSLUtil.getQualifiedVariableEntityName(tempEntity, true);
					variableAndConstantMap.put(tempFullyQualifiedName, tempEntity);
					tempType = "variable/constant";
				} else {
					continue;
				}

				AmbiguousDefinition tempDuplicateDefinition = new AmbiguousDefinition(tempFullyQualifiedName, tempType,
						tempObject);
				AmbiguousDefinition tempExistingDuplicate = tempDuplicateMap.get(tempDuplicateDefinition.getKey());
				if (tempExistingDuplicate != null) {
					tempExistingDuplicate.addDefinition(tempObject);
					ambiguousDefinitions.add(tempExistingDuplicate);
				} else {
					tempDuplicateMap.put(tempDuplicateDefinition.getKey(), tempDuplicateDefinition);
				}
			}
		}
	}

	public List<Model> getModels() {
		return models;
	}

	public Map<String, SuiteDefinition> getSuiteMap() {
		return suiteMap;
	}

	public Set<AmbiguousDefinition> getDuplicateDefinitions() {
		return ambiguousDefinitions;
	}

	/**
	 * Resolves a fully qualified suite name to the actual suite definition.
	 * 
	 * @param aFullyQualifiedSuiteName
	 *            the suite name
	 * @return the suite, or null if none was found
	 */
	public SuiteDefinition getSuiteByName(String aFullyQualifiedSuiteName) {
		return suiteMap.get(aFullyQualifiedSuiteName);
	}

	/**
	 * Resolves a fully qualified variant name to the actual variant definition.
	 * 
	 * @param aFullyQualifiedVariantName
	 *            the variant name
	 * @return the variant, or null if none was found
	 */
	public VariantDefinition getVariantByName(String aFullyQualifiedVariantName) {
		return variantMap.get(aFullyQualifiedVariantName);
	}

	/**
	 * Resolves a fully qualified fork name to the actual fork definition.
	 * 
	 * @param aFullyQualifiedForkName
	 *            the fork name
	 * @return the fork, or null if none was found
	 */
	public VariantDefinition getForkByName(String aFullyQualifiedForkName) {
		return variantMap.get(aFullyQualifiedForkName);
	}

	/**
	 * Resolves a fully qualified variable/constant name to the actual entity.
	 * 
	 * @param aFullyQualifiedName
	 *            the name to resolve
	 * @return the entity, or null if none was found
	 */
	public VariableOrConstantEntity getVariableOrConstantByName(String aFullyQualifiedName) {
		return variableAndConstantMap.get(aFullyQualifiedName);
	}

	/**
	 * Iterates through the whole model and searches for variable definitions hosted in packages (global variables).
	 * 
	 * @return a set of variable definitions (sorted by fully qualified name)
	 */
	public TreeSet<VariableDefinition> getVariableDefinitionsInPackages() {
		TreeSet<VariableDefinition> tempResultSet = new TreeSet<VariableDefinition>(
				new Comparator<VariableDefinition>() {

					@Override
					public int compare(VariableDefinition aFirst, VariableDefinition aSecond) {
						String tempFirstName = IntegrityDSLUtil.getQualifiedVariableEntityName(aFirst.getName(), false);
						String tempSecondName = IntegrityDSLUtil.getQualifiedVariableEntityName(aSecond.getName(),
								false);

						return tempFirstName.compareTo(tempSecondName);
					}
				});

		for (Model tempModel : models) {
			TreeIterator<EObject> tempIter = tempModel.eAllContents();
			while (tempIter.hasNext()) {
				EObject tempObject = tempIter.next();
				if (tempObject instanceof VariableDefinition) {
					if (tempObject.eContainer() instanceof PackageDefinition) {
						tempResultSet.add((VariableDefinition) tempObject);
					}
				}
			}
		}

		return tempResultSet;
	}

	/**
	 * Iterates through the whole model and searches for constant definitions.
	 * 
	 * @return a set of constant definitions (sorted by fully qualified name)
	 */
	public TreeSet<ConstantDefinition> getConstantDefinitionsInPackages() {
		TreeSet<ConstantDefinition> tempResultSet = new TreeSet<ConstantDefinition>(
				new Comparator<ConstantDefinition>() {

					@Override
					public int compare(ConstantDefinition aFirst, ConstantDefinition aSecond) {
						String tempFirstName = IntegrityDSLUtil.getQualifiedVariableEntityName(aFirst.getName(), false);
						String tempSecondName = IntegrityDSLUtil.getQualifiedVariableEntityName(aSecond.getName(),
								false);

						return tempFirstName.compareTo(tempSecondName);
					}
				});

		for (Model tempModel : models) {
			TreeIterator<EObject> tempIter = tempModel.eAllContents();
			while (tempIter.hasNext()) {
				EObject tempObject = tempIter.next();
				if (tempObject instanceof ConstantDefinition) {
					if (tempObject.eContainer() instanceof PackageDefinition) {
						tempResultSet.add((ConstantDefinition) tempObject);
					}
				}
			}
		}

		return tempResultSet;
	}

	/**
	 * Loads a {@link TestModel} from a given {@link TestResourceProvider}. During this process, the files provided by
	 * the resource provider are parsed, the resulting models are linked and stored in the {@link TestModel} container.<br>
	 * <br>
	 * Errors, like unresolved symbols, will cause an exception. If a model is returned by this method, you can be sure
	 * that everything was linked fine and the model can be executed by the {@link TestRunner}.
	 * 
	 * @param aResourceProvider
	 *            the resource provider to use for loading the model
	 * @param aResolveAllFlag
	 *            whether the model should be resolved after loading (this helps finding linking errors immediately, but
	 *            can take some time)
	 * @param aSetupClass
	 *            the setup class to use for EMF setup and Guice initialization (if null, the default class is used)
	 * @return the test model ready for execution
	 * @throws ModelLoadException
	 *             if any errors occur during loading (syntax errors or unresolvable references)
	 */
	public static TestModel loadTestModel(TestResourceProvider aResourceProvider, boolean aResolveAllFlag,
			Class<? extends IntegrityDSLSetup> aSetupClass) throws ModelLoadException {
		Class<? extends IntegrityDSLSetup> tempSetupClass = aSetupClass;
		if (tempSetupClass == null) {
			tempSetupClass = IntegrityDSLSetup.class;
		}

		IntegrityDSLSetup tempSetup;
		try {
			tempSetup = tempSetupClass.newInstance();
		} catch (InstantiationException exc) {
			throw new IllegalArgumentException("Provided setup class '" + tempSetupClass
					+ "' could not be instantiated.", exc);
		} catch (IllegalAccessException exc) {
			throw new IllegalArgumentException("Provided setup class '" + tempSetupClass
					+ "' could not be instantiated.", exc);
		}
		if (aResourceProvider.getClassLoader() != null) {
			tempSetup.setClassLoader(aResourceProvider.getClassLoader());
		}
		Injector tempInjector = tempSetup.createInjectorAndDoEMFRegistration();

		XtextResourceSet tempResourceSet = tempInjector.getInstance(XtextResourceSet.class);
		IResourceFactory tempResourceFactory = tempInjector.getInstance(IResourceFactory.class);
		ArrayList<Diagnostic> tempErrors = new ArrayList<Diagnostic>();
		List<Model> tempModels = new LinkedList<Model>();

		for (String tempResourceName : aResourceProvider.getResourceNames()) {
			URI tempUri = URI.createPlatformResourceURI(tempResourceName, true);
			XtextResource tempResource = (XtextResource) tempResourceFactory.createResource(tempUri);
			tempResourceSet.getResources().add(tempResource);
			try {
				tempResource.load(aResourceProvider.openResource(tempResourceName), null);
			} catch (IOException exc) {
				throw new ModelLoadException("Encountered an I/O problem during model parsing.", exc);
			}

			System.out.println("Loaded Integrity Model File '" + tempResourceName + "': "
					+ tempResource.getErrors().size() + " errors.");
			tempErrors.addAll(tempResource.getErrors());

			Model tempModel = (Model) tempResource.getParseResult().getRootASTElement();
			if (tempModel != null) {
				// may be null in case of an empty file
				tempModels.add(tempModel);
			}
		}

		if (!tempErrors.isEmpty()) {
			throw new ModelParseException("Encountered " + tempErrors.size() + " errors while parsing test model.",
					tempErrors);
		}

		// Full resolving has been made optional because for some not-yet-known reason, resolveAll takes a huge amount
		// of time since the change to XText 2.2.
		if (aResolveAllFlag) {
			System.out.print("Resolving the test model...");
			EcoreUtil.resolveAll(tempResourceSet);
			System.out.println("done!");

			Set<EObject> tempUnresolvedProxies = findUnresolvedProxies(tempResourceSet);
			if (tempUnresolvedProxies.size() > 0) {
				throw new ModelLinkException("Encountered " + tempUnresolvedProxies.size()
						+ " unresolvable references while linking test model.", tempUnresolvedProxies);
			}
		}

		TestModel tempModel = new TestModel(tempModels);
		tempInjector.injectMembers(tempModel);
		if (tempModel.getDuplicateDefinitions().size() > 0) {
			throw new ModelAmbiguousException("Encountered " + tempModel.getDuplicateDefinitions().size()
					+ " ambiguous definitions in the test model.", tempModel.getDuplicateDefinitions());
		}
		return tempModel;
	}

	/**
	 * Searches for all unresolved proxy objects in the given resource set.
	 * 
	 * @param aResourceSet
	 * 
	 * @return all proxy objects that are not resolvable
	 */
	protected static Set<EObject> findUnresolvedProxies(ResourceSet aResourceSet) {
		Set<EObject> tempUnresolvedProxies = new java.util.LinkedHashSet<org.eclipse.emf.ecore.EObject>();

		for (Resource tempResource : aResourceSet.getResources()) {
			tempUnresolvedProxies.addAll(findUnresolvedProxies(tempResource));
		}
		return tempUnresolvedProxies;
	}

	/**
	 * Searches for all unresolved proxy objects in the given resource.
	 * 
	 * @param aResource
	 * 
	 * @return all proxy objects that are not resolvable
	 */
	protected static Set<EObject> findUnresolvedProxies(Resource aResource) {
		Set<EObject> tempUnresolvedProxies = new java.util.LinkedHashSet<org.eclipse.emf.ecore.EObject>();

		for (Iterator<EObject> tempIterator = EcoreUtil.getAllContents(aResource, true); tempIterator.hasNext();) {
			InternalEObject tempNextElement = (InternalEObject) tempIterator.next();
			if (tempNextElement.eIsProxy()) {
				tempUnresolvedProxies.add(tempNextElement);
			}
			for (EObject tempElement : tempNextElement.eCrossReferences()) {
				tempElement = EcoreUtil.resolve(tempElement, aResource);
				if (tempElement.eIsProxy()) {
					tempUnresolvedProxies.add(tempElement);
				}
			}
		}
		return tempUnresolvedProxies;
	}

	/**
	 * Initializes a fresh test runner instance, based on this test model.
	 * 
	 * @param aCallback
	 *            the callback to use to report test results
	 * @param someParameterizedConstants
	 *            Maps fully qualified constant names (must be those with the "parameterized" keyword) to their desired
	 *            value. This way, test execution can be parameterized from outside.
	 * @param aRemotingPort
	 *            the port on which the remoting server should listen, or null if remoting should be disabled
	 * @param aRemotingBindHost
	 *            the host name (or IP) to which the remoting server should bind
	 * @param aRandomSeed
	 *            the seed for the {@link de.gebit.integrity.runner.operations.RandomNumberOperation;} (optional;
	 *            randomly determined if not given).
	 * @param someCommandLineArguments
	 *            all command line arguments as given to the original Java programs' main routine (required for
	 *            forking!)
	 * @return the initialized test runner instance
	 * @throws IOException
	 *             if the remoting server startup fails
	 */
	public TestRunner initializeTestRunner(TestRunnerCallback aCallback,
			Map<String, String> someParameterizedConstants, Integer aRemotingPort, String aRemotingBindHost,
			Long aRandomSeed, String[] someCommandLineArguments) throws IOException {
		TestRunner tempRunner = injector.getInstance(TestRunner.class);

		((DefaultTestRunner) tempRunner).initialize(this, someParameterizedConstants, aCallback, aRemotingPort,
				aRemotingBindHost, aRandomSeed, someCommandLineArguments);

		return tempRunner;
	}

}

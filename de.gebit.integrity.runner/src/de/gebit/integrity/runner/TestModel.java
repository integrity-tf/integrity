package de.gebit.integrity.runner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
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

import com.google.inject.Injector;

import de.gebit.integrity.dsl.Call;
import de.gebit.integrity.dsl.ConstantDefinition;
import de.gebit.integrity.dsl.ConstantEntity;
import de.gebit.integrity.dsl.Model;
import de.gebit.integrity.dsl.PackageDefinition;
import de.gebit.integrity.dsl.SuiteDefinition;
import de.gebit.integrity.dsl.TableTest;
import de.gebit.integrity.dsl.Test;
import de.gebit.integrity.dsl.VariableDefinition;
import de.gebit.integrity.dsl.VariableEntity;
import de.gebit.integrity.dsl.VariableOrConstantEntity;
import de.gebit.integrity.dsl.VariantDefinition;
import de.gebit.integrity.runner.callbacks.TestRunnerCallback;
import de.gebit.integrity.runner.exceptions.ModelLinkException;
import de.gebit.integrity.runner.exceptions.ModelLoadException;
import de.gebit.integrity.runner.exceptions.ModelParseException;
import de.gebit.integrity.runner.exceptions.ModelRuntimeLinkException;
import de.gebit.integrity.runner.providers.TestResourceProvider;
import de.gebit.integrity.utils.IntegrityDSLUtil;

/**
 * The test model. There's not much more to say ;-)
 * 
 * 
 * @author Rene Schneider
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
	protected Map<String, SuiteDefinition> suiteMap;

	/**
	 * Variant names -> Variants.
	 */
	protected Map<String, VariantDefinition> variantMap;

	/**
	 * Variable/constant names -> Entities.
	 */
	protected Map<String, VariableOrConstantEntity> variableAndConstantMap;

	/**
	 * The Google Guice Injector.
	 */
	protected Injector injector;

	/**
	 * The classloader to use.
	 */
	protected ClassLoader classLoader;

	/**
	 * Creates a new model from a bunch of single models (files).
	 * 
	 * @param someModels
	 *            the models
	 * @param anInjector
	 *            the Google Guice Injector
	 * @param aClassLoader
	 *            the classloader to use
	 */
	protected TestModel(List<Model> someModels, Injector anInjector, ClassLoader aClassLoader) {
		models = someModels;
		injector = anInjector;
		classLoader = aClassLoader;
		suiteMap = new HashMap<String, SuiteDefinition>();
		variantMap = new HashMap<String, VariantDefinition>();
		variableAndConstantMap = new HashMap<String, VariableOrConstantEntity>();

		// scan all models for suite definitions and variants and put them into the maps for fast access
		for (Model tempModel : models) {
			TreeIterator<EObject> tempIter = tempModel.eAllContents();
			while (tempIter.hasNext()) {
				EObject tempObject = tempIter.next();
				if (tempObject instanceof SuiteDefinition) {
					SuiteDefinition tempSuite = (SuiteDefinition) tempObject;
					String tempSuiteName = tempSuite.getName();
					if (tempSuite.eContainer() instanceof PackageDefinition) {
						tempSuiteName = ((PackageDefinition) tempSuite.eContainer()).getName() + "." + tempSuiteName;
					}
					suiteMap.put(tempSuiteName, tempSuite);
				} else if (tempObject instanceof VariantDefinition) {
					VariantDefinition tempVariant = (VariantDefinition) tempObject;
					String tempVariantName = tempVariant.getName();
					if (tempVariant.eContainer() instanceof PackageDefinition) {
						tempVariantName = ((PackageDefinition) tempVariant.eContainer()).getName() + "."
								+ tempVariantName;
					}
					variantMap.put(tempVariantName, tempVariant);
				} else if (tempObject instanceof VariableDefinition) {
					VariableEntity tempEntity = ((VariableDefinition) tempObject).getName();
					String tempEntityName = tempEntity.getName();
					if (tempObject.eContainer() instanceof PackageDefinition) {
						tempEntityName = ((PackageDefinition) tempObject.eContainer()).getName() + "." + tempEntityName;
					}
					variableAndConstantMap.put(tempEntityName, tempEntity);
				} else if (tempObject instanceof ConstantDefinition) {
					ConstantEntity tempEntity = ((ConstantDefinition) tempObject).getName();
					String tempEntityName = tempEntity.getName();
					if (tempObject.eContainer() instanceof PackageDefinition) {
						tempEntityName = ((PackageDefinition) tempObject.eContainer()).getName() + "." + tempEntityName;
					}
					variableAndConstantMap.put(tempEntityName, tempEntity);
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
	 * @return the test model ready for execution
	 * @throws ModelLoadException
	 *             if any errors occur during loading (syntax errors or unresolvable references)
	 */
	public static TestModel loadTestModel(TestResourceProvider aResourceProvider, boolean aResolveAllFlag)
			throws ModelLoadException {
		Injector tempInjector = new IntegrityDSLSetup(aResourceProvider.getClassLoader())
				.createInjectorAndDoEMFRegistration();

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

		return new TestModel(tempModels, tempInjector, aResourceProvider.getClassLoader());
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

	public Injector getInjector() {
		return injector;
	}

	public ClassLoader getClassLoader() {
		return classLoader;
	}

	/**
	 * Checks if key references of the given {@link Test} are available and properly linked.
	 * 
	 * @param aTest
	 *            the test to check
	 * @throws ModelRuntimeLinkException
	 *             in case of an error. Nothing happens if everything is fine.
	 */
	public static void ensureModelPartConsistency(Test aTest) throws ModelRuntimeLinkException {
		if (aTest.getDefinition() == null) {
			throw new ModelRuntimeLinkException("Failed to resolve test definition for test statement '"
					+ aTest.toString() + "'", aTest);
		} else if (aTest.getDefinition().getFixtureMethod() == null
				|| aTest.getDefinition().getFixtureMethod().getMethod() == null) {
			throw new ModelRuntimeLinkException("Failed to resolve test fixture for test definition '"
					+ aTest.getDefinition().getName() + "' (" + aTest.getDefinition() + ")", aTest);
		}
	}

	/**
	 * Checks if key references of the given {@link Call} are available and properly linked.
	 * 
	 * @param aCall
	 *            the call to check
	 * @throws ModelRuntimeLinkException
	 *             in case of an error. Nothing happens if everything is fine.
	 */
	public static void ensureModelPartConsistency(Call aCall) throws ModelRuntimeLinkException {
		if (aCall.getDefinition() == null) {
			throw new ModelRuntimeLinkException("Failed to resolve call definition for call statement '"
					+ aCall.toString() + "'", aCall);
		} else if (aCall.getDefinition().getFixtureMethod() == null
				|| aCall.getDefinition().getFixtureMethod().getMethod() == null) {
			throw new ModelRuntimeLinkException("Failed to resolve call fixture for call definition '"
					+ aCall.getDefinition().getName() + "' (" + aCall.getDefinition() + ")", aCall);
		}
	}

	/**
	 * Checks if key references of the given {@link TableTest} are available and properly linked.
	 * 
	 * @param aTest
	 *            the test to check
	 * @throws ModelRuntimeLinkException
	 *             in case of an error. Nothing happens if everything is fine.
	 */
	public static void ensureModelPartConsistency(TableTest aTest) throws ModelRuntimeLinkException {
		if (aTest.getDefinition() == null) {
			throw new ModelRuntimeLinkException("Failed to resolve test definition for tabletest statement '"
					+ aTest.toString() + "'", aTest);
		} else if (aTest.getDefinition().getFixtureMethod() == null
				|| aTest.getDefinition().getFixtureMethod().getMethod() == null) {
			throw new ModelRuntimeLinkException("Failed to resolve test fixture for test definition '"
					+ aTest.getDefinition().getName() + "' (" + aTest.getDefinition() + ")", aTest);
		}
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
	 * @param someCommandLineArguments
	 *            all command line arguments as given to the original Java programs' main routine (required for
	 *            forking!)
	 * @return the initialized test runner instance
	 * @throws IOException
	 *             if the remoting server startup fails
	 */
	public TestRunner initializeTestRunner(TestRunnerCallback aCallback,
			Map<String, String> someParameterizedConstants, Integer aRemotingPort, String aRemotingBindHost,
			String[] someCommandLineArguments) throws IOException {
		TestRunner tempRunner = injector.getInstance(TestRunner.class);

		((DefaultTestRunner) tempRunner).initialize(this, someParameterizedConstants, aCallback, aRemotingPort,
				aRemotingBindHost, someCommandLineArguments);

		return tempRunner;
	}
}

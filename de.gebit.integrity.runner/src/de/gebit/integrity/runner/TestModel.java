package de.gebit.integrity.runner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.linking.impl.ImportedNamesAdapter;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.inject.Injector;

import de.gebit.integrity.DSLStandaloneSetup;
import de.gebit.integrity.dsl.ConstantDefinition;
import de.gebit.integrity.dsl.Model;
import de.gebit.integrity.dsl.PackageDefinition;
import de.gebit.integrity.dsl.SuiteDefinition;
import de.gebit.integrity.dsl.VariableDefinition;
import de.gebit.integrity.runner.exceptions.ModelLinkException;
import de.gebit.integrity.runner.exceptions.ModelLoadException;
import de.gebit.integrity.runner.exceptions.ModelParseException;
import de.gebit.integrity.runner.providers.TestResourceProvider;

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

		// scan all models for suite definitions and put them into the map for
		// fast access
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
	 * Iterates through the whole model and searches for variable definitions hosted in packages (global variables).
	 * 
	 * @return a set of variable definitions
	 */
	public Set<VariableDefinition> getVariableDefinitionsInPackages() {
		Set<VariableDefinition> tempResultSet = new HashSet<VariableDefinition>();

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
	 * @return a set of constant definitions
	 */
	public Set<ConstantDefinition> getConstantDefinitionsInPackages() {
		Set<ConstantDefinition> tempResultSet = new HashSet<ConstantDefinition>();

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
		Injector tempInjector = new DSLStandaloneSetup(aResourceProvider.getClassLoader())
				.createInjectorAndDoEMFRegistration();

		XtextResourceSet tempResourceSet = tempInjector.getInstance(XtextResourceSet.class);
		IResourceFactory tempResourceFactory = tempInjector.getInstance(IResourceFactory.class);
		ArrayList<Diagnostic> tempErrors = new ArrayList<Diagnostic>();
		List<Model> tempModels = new LinkedList<Model>();

		// This logger will print out quite some info messages that we can safely ignore, thus we'll prevent that
		Logger tempAdapterLogger = Logger.getLogger(ImportedNamesAdapter.class);
		if (tempAdapterLogger.getLevel() == null) {
			// only set log level if there hasn't been any level set before
			tempAdapterLogger.setLevel(Level.WARN);
		}

		for (String tempResourceName : aResourceProvider.getResourceNames()) {
			URI tempUri = URI.createPlatformResourceURI(tempResourceName, true);
			XtextResource tempResource = (XtextResource) tempResourceFactory.createResource(tempUri);
			tempResourceSet.getResources().add(tempResource);
			try {
				tempResource.load(aResourceProvider.openResource(tempResourceName), null);
			} catch (IOException exc) {
				throw new ModelLoadException("Encountered an I/O problem during model parsing.", exc);
			}

			System.out.println("Loaded test resource '" + tempResourceName + "': " + tempResource.getErrors().size()
					+ " errors.");
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
			// EcoreUtil.resolveAll(tempResourceSet);
			EValidator tempValidator = tempInjector.getInstance(EValidator.class);
			for (Resource tempResource : tempResourceSet.getResources()) {
				for (EObject tempObject : tempResource.getContents()) {
					tempValidator.validate(tempObject, null, null);
				}
			}
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

}

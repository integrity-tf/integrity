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

import de.gebit.integrity.DSLStandaloneSetup;
import de.gebit.integrity.dsl.Model;
import de.gebit.integrity.dsl.PackageDefinition;
import de.gebit.integrity.dsl.SuiteDefinition;
import de.gebit.integrity.dsl.VariableDefinition;
import de.gebit.integrity.runner.exceptions.ModelLinkException;
import de.gebit.integrity.runner.exceptions.ModelLoadException;
import de.gebit.integrity.runner.exceptions.ModelParseException;
import de.gebit.integrity.runner.providers.TestResourceProvider;

public class TestModel {

	protected List<Model> models;

	protected Map<String, SuiteDefinition> suiteMap;

	protected Injector injector;

	protected ClassLoader classLoader;

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

	public SuiteDefinition getSuiteByName(String aFullyQualifiedSuiteName) {
		return suiteMap.get(aFullyQualifiedSuiteName);
	}

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

	public static TestModel loadTestModel(TestResourceProvider aResourceProvider) throws ModelLoadException {
		Injector injector = new DSLStandaloneSetup(aResourceProvider.getClassLoader())
				.createInjectorAndDoEMFRegistration();

		XtextResourceSet resourceSet = injector.getInstance(XtextResourceSet.class);
		IResourceFactory resourceFactory = injector.getInstance(IResourceFactory.class);
		ArrayList<Diagnostic> tempErrors = new ArrayList<Diagnostic>();
		List<Model> tempModels = new LinkedList<Model>();

		for (String tempResourceName : aResourceProvider.getResourceNames()) {
			URI uri = URI.createPlatformResourceURI(tempResourceName, true);
			XtextResource resource = (XtextResource) resourceFactory.createResource(uri);
			resourceSet.getResources().add(resource);
			try {
				resource.load(aResourceProvider.openResource(tempResourceName), null);
			} catch (IOException e) {
				throw new ModelLoadException("Encountered an I/O problem during model parsing.", e);
			}

			System.out.println("Loaded test resource '" + tempResourceName + "': " + resource.getErrors().size()
					+ " errors.");
			tempErrors.addAll(resource.getErrors());

			tempModels.add((Model) resource.getParseResult().getRootASTElement());
		}

		EcoreUtil.resolveAll(resourceSet);

		if (!tempErrors.isEmpty()) {
			throw new ModelParseException("Encountered " + tempErrors.size() + " errors while parsing test model.",
					tempErrors);
		}

		Set<EObject> tempUnresolvedProxies = findUnresolvedProxies(resourceSet);
		if (tempUnresolvedProxies.size() > 0) {
			throw new ModelLinkException("Encountered " + tempUnresolvedProxies.size()
					+ " unresolvable references while linking test model.", tempUnresolvedProxies);
		}

		return new TestModel(tempModels, injector, aResourceProvider.getClassLoader());
	}

	/**
	 * Searches for all unresolved proxy objects in the given resource set.
	 * 
	 * @param resourceSet
	 * 
	 * @return all proxy objects that are not resolvable
	 */
	protected static Set<EObject> findUnresolvedProxies(ResourceSet resourceSet) {
		Set<EObject> unresolvedProxies = new java.util.LinkedHashSet<org.eclipse.emf.ecore.EObject>();

		for (Resource resource : resourceSet.getResources()) {
			unresolvedProxies.addAll(findUnresolvedProxies(resource));
		}
		return unresolvedProxies;
	}

	/**
	 * Searches for all unresolved proxy objects in the given resource.
	 * 
	 * @param resource
	 * 
	 * @return all proxy objects that are not resolvable
	 */
	protected static Set<EObject> findUnresolvedProxies(Resource resource) {
		Set<EObject> unresolvedProxies = new java.util.LinkedHashSet<org.eclipse.emf.ecore.EObject>();

		for (Iterator<EObject> elementIt = EcoreUtil.getAllContents(resource, true); elementIt.hasNext();) {
			InternalEObject nextElement = (InternalEObject) elementIt.next();
			if (nextElement.eIsProxy()) {
				unresolvedProxies.add(nextElement);
			}
			for (EObject crElement : nextElement.eCrossReferences()) {
				crElement = EcoreUtil.resolve(crElement, resource);
				if (crElement.eIsProxy()) {
					unresolvedProxies.add(crElement);
				}
			}
		}
		return unresolvedProxies;
	}

	public Injector getInjector() {
		return injector;
	}

	public ClassLoader getClassLoader() {
		return classLoader;
	}

}

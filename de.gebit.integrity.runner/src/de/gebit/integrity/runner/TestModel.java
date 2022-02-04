/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.runner;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Singleton;

import de.gebit.integrity.dsl.CallDefinition;
import de.gebit.integrity.dsl.ConstantDefinition;
import de.gebit.integrity.dsl.ConstantEntity;
import de.gebit.integrity.dsl.ForkDefinition;
import de.gebit.integrity.dsl.Model;
import de.gebit.integrity.dsl.PackageDefinition;
import de.gebit.integrity.dsl.SuiteDefinition;
import de.gebit.integrity.dsl.SuiteParameterDefinition;
import de.gebit.integrity.dsl.SuiteReturnDefinition;
import de.gebit.integrity.dsl.TestDefinition;
import de.gebit.integrity.dsl.VariableDefinition;
import de.gebit.integrity.dsl.VariableEntity;
import de.gebit.integrity.dsl.VariableOrConstantEntity;
import de.gebit.integrity.dsl.VariantDefinition;
import de.gebit.integrity.modelsource.ModelSourceExplorer;
import de.gebit.integrity.providers.TestResource;
import de.gebit.integrity.providers.TestResourceProvider;
import de.gebit.integrity.runner.callbacks.TestRunnerCallback;
import de.gebit.integrity.runner.exceptions.ModelAmbiguousException;
import de.gebit.integrity.runner.exceptions.ModelLoadException;
import de.gebit.integrity.runner.exceptions.ModelParseException;
import de.gebit.integrity.runner.logging.TestRunnerPerformanceLogger;
import de.gebit.integrity.runner.providers.InMemoryTestResourceProvider;
import de.gebit.integrity.utils.DateUtil;
import de.gebit.integrity.utils.IntegrityDSLUtil;

/**
 * The test model. There's not much more to say ;-)
 * 
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
@Singleton
public class TestModel {

	/**
	 * All models. Every file is a model of itself (though they are all linked, of course).
	 */
	protected List<Model> models = new ArrayList<Model>();

	/**
	 * Suite names -> Suites.
	 */
	protected Map<String, SuiteDefinition> suiteMap = new ConcurrentHashMap<String, SuiteDefinition>();

	/**
	 * Variant names -> Variants.
	 */
	protected Map<String, VariantDefinition> variantMap = new ConcurrentHashMap<String, VariantDefinition>();

	/**
	 * Fork names -> Forks.
	 */
	protected Map<String, ForkDefinition> forkMap = new ConcurrentHashMap<String, ForkDefinition>();

	/**
	 * Call names -> Calls.
	 */
	protected Map<String, CallDefinition> callMap = new ConcurrentHashMap<String, CallDefinition>();

	/**
	 * Test names -> Tests.
	 */
	protected Map<String, TestDefinition> testMap = new ConcurrentHashMap<String, TestDefinition>();

	/**
	 * Variable/constant names -> Entities.
	 */
	protected Map<String, VariableOrConstantEntity> variableAndConstantMap = new ConcurrentHashMap<>();

	/**
	 * The reverse of {@link #variableAndConstantMap}.
	 */
	protected Map<VariableOrConstantEntity, String> variableAndConstantReverseMap = new ConcurrentHashMap<>();

	/**
	 * Ambiguous definitions which are found during variable/suite/etc. indexing are collected here.
	 */
	protected Set<AmbiguousDefinition> ambiguousDefinitions
			= Collections.newSetFromMap(new ConcurrentHashMap<AmbiguousDefinition, Boolean>());

	/**
	 * This map is used to find duplicates which then end up in {@link #ambiguousDefinitions}.
	 */
	protected Map<String, AmbiguousDefinition> duplicateMap = new ConcurrentHashMap<String, AmbiguousDefinition>();

	/**
	 * Stores an ordered list of global constant definitions. This is intended as a cache - if it's null, it must be
	 * recreated.
	 */
	protected TreeSet<ConstantDefinition> constantDefinitionsInPackages;

	/**
	 * Stores an ordered list of global variable definitions. This is intended as a cache - if it's null, it must be
	 * recreated.
	 */
	protected TreeSet<VariableDefinition> variableDefinitionsInPackages;

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
	 * The performance logger.
	 */
	@Inject
	protected TestRunnerPerformanceLogger performanceLogger;

	/**
	 * All successfully loaded resources, in the order in which they were loaded.
	 */
	protected Queue<TestResource> loadedResources = new ConcurrentLinkedQueue<TestResource>();

	/**
	 * All resource providers that this model has been filled from.
	 */
	protected List<TestResourceProvider> loadedResourceProviders = new ArrayList<>();

	/**
	 * This list stores copies of the {@link #loadedResourceProviders} which refer to resources which have been fully
	 * loaded in memory. It is intended as a cache to avoid repeated duplication of the same
	 * {@link TestResourceProvider}s. If it is null, the cache is empty and must be recreated. If not, it can be used.
	 */
	protected List<InMemoryTestResourceProvider> inMemoryResourceProviders;

	/**
	 * Set this system property to turn on verbose script loading. This makes Integrity list all scripts that it loads,
	 * regardless of the number of scripts being loaded. If this is turned off, only a summary is printed if more than
	 * {@link #MAX_SCRIPT_COUNT_AUTO_VERBOSE_LOADING} scripts are being loaded.
	 */
	public static final String PRINT_ALL_LOADED_SCRIPTS_PROPERTY = "integrity.runner.loading.verbose";

	/**
	 * The maximum number of scripts which are always loaded in "verbose" mode.
	 */
	protected static final int MAX_SCRIPT_COUNT_AUTO_VERBOSE_LOADING = 50;

	/**
	 * Whether to load scripts in a verbose fashion (=printing every load).
	 */
	protected final boolean verboseScriptLoading
			= Boolean.parseBoolean(System.getProperty(PRINT_ALL_LOADED_SCRIPTS_PROPERTY, "false"));

	/**
	 * The system property that allows to override the number of threads used to do some time-critical sections in the
	 * test runner, such as defining constants and variables.
	 */
	protected static final String MULTITHREADED_SECTIONS_THREAD_COUNT_PROPERTY = "integrity.runner.threadcount";

	/**
	 * The maximum of multithreaded threads if default determination is used. This is not taken into account if a custom
	 * number of threads is set via {@link #MULTITHREADED_SECTIONS_THREAD_COUNT_PROPERTY}.
	 */
	protected static final int MULTITHREADED_SECTIONS_THREAD_COUNT_DEFAULT_MAX = 16;

	/**
	 * Returns the number of threads to use during multithreaded sections, such as defining constants and variables.
	 * This public method is located here for practical reasons - the test model and test runner both need this
	 * information, but the model needs it first, so I've placed it here.
	 */
	public int getMultithreadedSectionsThreadCount() {
		return System.getProperty(MULTITHREADED_SECTIONS_THREAD_COUNT_PROPERTY) != null
				? Integer.parseInt(System.getProperty(MULTITHREADED_SECTIONS_THREAD_COUNT_PROPERTY))
				: getMultithreadedSectionsThreadCountDefault();
	}

	/**
	 * Returns the default number of threads to use during multithreaded sections, such as defining constants and
	 * variables.
	 */
	protected int getMultithreadedSectionsThreadCountDefault() {
		int tempCount = Runtime.getRuntime().availableProcessors();

		return (tempCount < MULTITHREADED_SECTIONS_THREAD_COUNT_DEFAULT_MAX) ? tempCount
				: MULTITHREADED_SECTIONS_THREAD_COUNT_DEFAULT_MAX;
	}

	/**
	 * Adds all given Integrity script files to the test model.
	 * 
	 * @param someModels
	 *            the models to add
	 */
	public void addIntegrityScriptModels(List<Model> someModels) {
		for (Model tempModel : someModels) {
			addIntegrityScriptModel(tempModel);
		}
	}

	/**
	 * Adds a given Integrity script file to the test model.
	 * 
	 * @param aModel
	 *            the model to add
	 */
	public void addIntegrityScriptModel(Model aModel) {
		// Scan all models for suite definitions and variants and put them into the maps for fast access.
		// Also search for duplicate definitions! Test Models with duplicate definitions are technically fine, but
		// they may very likely result in strange behavior during execution, as the definition that is actually used
		// when for example a variable with multiple definitions is accessed is not predictable.
		TreeIterator<EObject> tempIter = aModel.eAllContents();
		while (tempIter.hasNext()) {
			EObject tempObject = tempIter.next();
			String tempFullyQualifiedName = null;
			String tempType;

			if (tempObject instanceof SuiteDefinition) {
				SuiteDefinition tempSuite = (SuiteDefinition) tempObject;
				tempFullyQualifiedName = IntegrityDSLUtil.getQualifiedSuiteName(tempSuite);
				suiteMap.put(tempFullyQualifiedName, tempSuite);
				tempType = "suite";
			} else if (tempObject instanceof SuiteParameterDefinition) {
				// Suite params are technically variable definitions
				SuiteParameterDefinition tempDefinition = (SuiteParameterDefinition) tempObject;
				VariableEntity tempEntity = tempDefinition.getName();
				tempFullyQualifiedName = IntegrityDSLUtil.getQualifiedVariableEntityName(tempEntity, true);
				variableAndConstantMap.put(tempFullyQualifiedName, tempEntity);
				variableAndConstantReverseMap.put(tempEntity, tempFullyQualifiedName);
				tempType = "suiteparam";
			} else if (tempObject instanceof SuiteReturnDefinition) {
				// Suite returns are technically also variable definitions
				SuiteReturnDefinition tempDefinition = (SuiteReturnDefinition) tempObject;
				VariableEntity tempEntity = tempDefinition.getName();
				tempFullyQualifiedName = IntegrityDSLUtil.getQualifiedVariableEntityName(tempEntity, true);
				variableAndConstantMap.put(tempFullyQualifiedName, tempEntity);
				variableAndConstantReverseMap.put(tempEntity, tempFullyQualifiedName);
				tempType = "suiteparam";
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
				variableAndConstantReverseMap.put(tempEntity, tempFullyQualifiedName);
				tempType = "variable/constant";
			} else if (tempObject instanceof ConstantDefinition) {
				ConstantEntity tempEntity = ((ConstantDefinition) tempObject).getName();
				tempFullyQualifiedName = IntegrityDSLUtil.getQualifiedVariableEntityName(tempEntity, true);
				variableAndConstantMap.put(tempFullyQualifiedName, tempEntity);
				variableAndConstantReverseMap.put(tempEntity, tempFullyQualifiedName);
				tempType = "variable/constant";
			} else {
				continue;
			}

			AmbiguousDefinition tempDuplicateDefinition
					= new AmbiguousDefinition(tempFullyQualifiedName, tempType, tempObject);
			AmbiguousDefinition tempExistingDuplicate = duplicateMap.get(tempDuplicateDefinition.getKey());
			if (tempExistingDuplicate != null) {
				tempExistingDuplicate.addDefinition(tempObject);
				ambiguousDefinitions.add(tempExistingDuplicate);
			} else {
				duplicateMap.put(tempDuplicateDefinition.getKey(), tempDuplicateDefinition);
			}
		}

		// Synchronizing this manually here because it's much faster. We know this list will not be modified except in
		// this place, so using a fully synced list would be bad performance-wise for later accesses.
		synchronized (models) {
			models.add(aModel);
		}
	}

	/**
	 * Reads all Integrity scripts from the provided resource provider and initializes this test model with them. This
	 * is an "additive" operation, meaning that it is possible to call this method on a model multiple times and inject
	 * more and more scripts.<br>
	 * <br>
	 * For each successfully loaded resource provider, a reference to the provider is stored in the model as well. The
	 * same is done for each successfully loaded resource (see {@link TestResource}). These references may later be
	 * retrieved by {@link #getLoadedResourceProviders()} and {@link #getLoadedResources()}.
	 * 
	 * @param aResourceProvider
	 *            the resource provider to use for loading
	 * @param aPerformModelValidationFlag
	 *            whether model validation is to be done
	 * @return any errors that happened while loading or validating
	 * @throws ModelLoadException
	 */
	public List<Diagnostic> readIntegrityScriptFiles(final TestResourceProvider aResourceProvider,
			boolean aPerformModelValidationFlag) throws ModelLoadException {
		final XtextResourceSet tempResourceSet = injector.getInstance(XtextResourceSet.class);
		final IResourceFactory tempResourceFactory = injector.getInstance(IResourceFactory.class);
		final ArrayList<Diagnostic> tempErrors = new ArrayList<Diagnostic>();

		performanceLogger.executeAndLog(TestRunnerPerformanceLogger.PERFORMANCE_LOG_CATEGORY_INIT, "Load Scripts",
				new TestRunnerPerformanceLogger.RunnableWithException<ModelLoadException>() {

					@Override
					public void run() throws ModelLoadException {
						TestResource[] tempAllResources = aResourceProvider.getResourceNames();

						int tempNumberOfThreads = getMultithreadedSectionsThreadCount();
						if (tempNumberOfThreads > tempAllResources.length) {
							tempNumberOfThreads = tempAllResources.length;
						}
						if (tempNumberOfThreads == 0) {
							tempNumberOfThreads = 1;
						}

						System.out.println("Now loading " + tempAllResources.length + " test script(s) using "
								+ tempNumberOfThreads + " threads...");
						long tempStart = System.nanoTime();

						ExecutorService tempExecutor
								= Executors.newFixedThreadPool(tempNumberOfThreads, new ThreadFactory() {

									private int count;

									@Override
									public Thread newThread(Runnable aRunnable) {
										count++;
										return new Thread(aRunnable, "Integrity Resource Loader Thread #" + count);
									}
								});
						List<Future<List<Diagnostic>>> tempFutures = new ArrayList<>(tempAllResources.length);
						for (final TestResource tempResourceName : tempAllResources) {
							tempFutures.add(tempExecutor.submit(new Callable<List<Diagnostic>>() {

								@Override
								public List<Diagnostic> call() throws Exception {
									return loadSingleResource(aResourceProvider, tempResourceName, tempResourceSet,
											tempResourceFactory, verboseScriptLoading);
								}

							}));
						}

						tempExecutor.shutdown();
						try {
							// Practically we want to wait forever, but since that's not possible...
							tempExecutor.awaitTermination(1, TimeUnit.DAYS);
						} catch (InterruptedException exc) {
							throw new ModelLoadException("Was interrupted while waiting for scripts to load", exc);
						}

						for (Future<List<Diagnostic>> tempFuture : tempFutures) {
							try {
								tempErrors.addAll(tempFuture.get());
							} catch (InterruptedException exc) {
								throw new ModelLoadException("Was interrupted while waiting for scripts to load", exc);
							} catch (ExecutionException exc) {
								// Execution exceptions contain most likely model load exceptions. We rethrow the first
								// one that we find.
								if (exc.getCause() instanceof ModelLoadException) {
									throw (ModelLoadException) exc.getCause();
								} else {
									// Anything else is thrown as a runtime exception. Should not happen too often
									// though...
									throw new RuntimeException(exc.getCause());
								}
							}
						}

						System.out.println("Finished loading " + tempAllResources.length + " test script(s) with "
								+ tempErrors.size() + " error(s) in "
								+ DateUtil.convertNanosecondTimespanToHumanReadableFormat(System.nanoTime() - tempStart,
										false, false));
					}

				});

		if (tempErrors.size() == 0 && aPerformModelValidationFlag) {
			performanceLogger.executeAndLog(TestRunnerPerformanceLogger.PERFORMANCE_LOG_CATEGORY_INIT,
					"Validate Scripts", new TestRunnerPerformanceLogger.RunnableWithException<ModelLoadException>() {

						@Override
						public void run() throws ModelLoadException {
							int tempNumberOfThreads = getMultithreadedSectionsThreadCount();
							if (tempNumberOfThreads > models.size()) {
								tempNumberOfThreads = models.size();
							}

							System.out.println("Now validating " + models.size() + " test script(s)...");
							long tempStart = System.nanoTime();

							// Validation is not multi-thread-safe, so we need to perform this in a single-threaded way.
							// Still using an executor here because maybe this will become thread-safe some time in the
							// future...
							ExecutorService tempExecutor = Executors.newFixedThreadPool(1, new ThreadFactory() {

								@Override
								public Thread newThread(Runnable aRunnable) {
									return new Thread(aRunnable, "Integrity Validation Thread");
								}
							});
							List<Future<List<Diagnostic>>> tempFutures = new ArrayList<>(models.size());
							for (final Model tempModel : models) {
								tempFutures.add(tempExecutor.submit(new Callable<List<Diagnostic>>() {

									@Override
									public List<Diagnostic> call() throws Exception {
										return customValidateSingleModel(tempModel);
									}

								}));
							}

							tempExecutor.shutdown();
							try {
								// Practically we want to wait forever, but since that's not possible...
								tempExecutor.awaitTermination(1, TimeUnit.DAYS);
							} catch (InterruptedException exc) {
								throw new ModelLoadException("Was interrupted while waiting for scripts to validate",
										exc);
							}

							for (Future<List<Diagnostic>> tempFuture : tempFutures) {
								try {
									tempErrors.addAll(tempFuture.get());
								} catch (InterruptedException exc) {
									throw new ModelLoadException(
											"Was interrupted while waiting for scripts to validate", exc);
								} catch (ExecutionException exc) {
									throw new RuntimeException(exc.getCause());
								}
							}

							System.out.println(
									"Finished validating " + models.size() + " test script(s) with " + tempErrors.size()
											+ " error(s) in " + DateUtil.convertNanosecondTimespanToHumanReadableFormat(
													System.nanoTime() - tempStart, false, false));
						}

					});
		}

		loadedResourceProviders.add(aResourceProvider);
		inMemoryResourceProviders = null;
		constantDefinitionsInPackages = null;
		variableDefinitionsInPackages = null;

		return tempErrors;
	}

	/**
	 * This sync object is used to synchronize access to {@link org.eclipse.xtext.resource.XtextResourceFactory},
	 * {@link XtextResource} and {@link XtextResourceSet}. I'm not sure if those are parallelizable, so better be safe
	 * than sorry.
	 */
	protected Object resourceLoadingSyncObject = new Object();

	/**
	 * Used to synchronize potential printouts - printing to stdout with multiple threads can quickly lead to chaos.
	 */
	protected Object statusOutputSyncObject = new Object();

	/**
	 * Loads a single {@link TestResource} from the given {@link TestResourceProvider}. This method is deliberately
	 * designed to be thread-safe and shall be invoked in parallel for parallelized script loading.
	 * 
	 * @param aResourceProvider
	 *            the resource provider to load from
	 * @param aResourceName
	 *            the resource to load
	 * @param aResourceSet
	 *            the resource set to add the resource to
	 * @param aResourceFactory
	 *            the resource factory to use
	 * @param aVerboseFlag
	 *            whether to make verbose output
	 * @return a list of errors
	 * @throws ModelLoadException
	 */
	protected List<Diagnostic> loadSingleResource(TestResourceProvider aResourceProvider, TestResource aResourceName,
			XtextResourceSet aResourceSet, IResourceFactory aResourceFactory, boolean aVerboseFlag)
			throws ModelLoadException {
		XtextResource tempResource;

		try {
			InputStream tempStream;
			synchronized (resourceLoadingSyncObject) {
				URI tempUri = aResourceName.createPlatformResourceURI();
				tempResource = (XtextResource) aResourceFactory.createResource(tempUri);
				aResourceSet.getResources().add(tempResource);

				tempStream = aResourceProvider.openResource(aResourceName);
			}
			try {
				tempResource.load(tempStream, null);
			} finally {
				synchronized (aResourceProvider) {
					aResourceProvider.closeResource(aResourceName, tempStream);
				}
			}
		} catch (IOException exc) {
			throw new ModelLoadException("Encountered an I/O problem during model parsing.", exc);
		}

		synchronized (statusOutputSyncObject) {
			boolean tempPrintLine = (aVerboseFlag || tempResource.getErrors().size() > 0);
			if (tempPrintLine) {
				@SuppressWarnings("resource")
				PrintStream tempOut = (tempResource.getErrors().size() > 0 ? System.err : System.out);
				tempOut.println("Loaded Integrity Model File '" + aResourceName + "': "
						+ tempResource.getErrors().size() + " errors.");
			}
		}

		Model tempModel = (Model) tempResource.getParseResult().getRootASTElement();
		if (tempModel != null) {
			// may be null in case of an empty file
			addIntegrityScriptModel(tempModel);
		}

		loadedResources.add(aResourceName);

		return tempResource.getErrors().stream().map(tempError -> new Diagnostic(tempError))
				.collect(Collectors.toList());
	}

	/**
	 * Performs validation of a single model. THIS IS NOT THREAD-SAFE, as the model is being lazy-resolved during
	 * validation, which may trigger modifications to other models' internal structures.
	 * 
	 * @param aModel
	 *            the model to validate
	 * @return a list of validation errors (only errors are reported)
	 */
	protected List<Diagnostic> customValidateSingleModel(Model aModel) {
		org.eclipse.emf.common.util.Diagnostic tempDiagnostic = Diagnostician.INSTANCE.validate(aModel);
		List<org.eclipse.emf.common.util.Diagnostic> tempDiagnostics = new ArrayList<>();
		if (tempDiagnostic.getChildren() != null && tempDiagnostic.getChildren().size() > 0) {
			tempDiagnostics.addAll(tempDiagnostic.getChildren());
		} else {
			tempDiagnostics.add(tempDiagnostic);
		}

		List<Diagnostic> tempResults = new ArrayList<>();
		for (org.eclipse.emf.common.util.Diagnostic tempCandidate : tempDiagnostics) {
			if (((tempCandidate.getSeverity() & org.eclipse.emf.common.util.Diagnostic.ERROR) != 0)) {
				tempResults.add(new Diagnostic(tempCandidate, modelSourceExplorer));
			}
		}

		return tempResults;
	}

	public Injector getInjector() {
		return injector;
	}

	public List<Model> getModels() {
		return models;
	}

	public List<TestResource> getLoadedResources() {
		return new ArrayList<>(loadedResources);
	}

	public List<TestResourceProvider> getLoadedResourceProviders() {
		return new ArrayList<>(loadedResourceProviders);
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
	 * Returns all suites in the test model.
	 * 
	 * @return all suites
	 */
	public Collection<SuiteDefinition> getAllSuites() {
		return suiteMap.values();
	}

	/**
	 * Resolves a fully qualified variant name to the actual variant definition.
	 * 
	 * @param aFullyQualifiedVariantName
	 *            the variant name
	 * @return the variant, or null if none was found
	 */
	public VariantDefinition getVariantByName(String aFullyQualifiedVariantName) {
		if (aFullyQualifiedVariantName == null) {
			return null;
		}
		return variantMap.get(aFullyQualifiedVariantName);
	}

	public Collection<VariantDefinition> getAllVariants() {
		return variantMap.values();
	}

	/**
	 * Resolves a fully qualified fork name to the actual fork definition.
	 * 
	 * @param aFullyQualifiedForkName
	 *            the fork name
	 * @return the fork, or null if none was found
	 */
	public ForkDefinition getForkByName(String aFullyQualifiedForkName) {
		return forkMap.get(aFullyQualifiedForkName);
	}

	/**
	 * Returns all forks in the test model.
	 * 
	 * @return all forks
	 */
	public Collection<ForkDefinition> getAllForks() {
		return forkMap.values();
	}

	/**
	 * Resolves a fully qualified call name to the actual call definition.
	 * 
	 * @param aFullyQualifiedCallName
	 *            the call name
	 * @return the call definition, or null if none was found
	 */
	public CallDefinition getCallByName(String aFullyQualifiedCallName) {
		return callMap.get(aFullyQualifiedCallName);
	}

	/**
	 * Returns all calls in the test model.
	 * 
	 * @return all calls
	 */
	public Collection<CallDefinition> getAllCalls() {
		return callMap.values();
	}

	/**
	 * Resolves a fully qualified test name to the actual test definition.
	 * 
	 * @param aFullyQualifiedTestName
	 *            the call name
	 * @return the test definition, or null if none was found
	 */
	public TestDefinition getTestByName(String aFullyQualifiedTestName) {
		return testMap.get(aFullyQualifiedTestName);
	}

	/**
	 * Returns all tests in the test model.
	 * 
	 * @return all tests
	 */
	public Collection<TestDefinition> getAllTests() {
		return testMap.values();
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
	 * Returns the fully-qualified name of a variable/constant entity. The stuff returned by this equals
	 * {@link IntegrityDSLUtil#getQualifiedVariableEntityName(VariableOrConstantEntity, boolean)} with the boolean value
	 * set to true.
	 * 
	 * @param anEntity
	 *            the entity to resolve
	 * @return the name, or null if none was found
	 */
	public String getFullyQualifiedVariableOrConstantName(VariableOrConstantEntity anEntity) {
		return variableAndConstantReverseMap.get(anEntity);
	}

	/**
	 * Iterates through the whole model and searches for variable definitions hosted in packages (global variables).
	 * 
	 * @return a set of variable definitions (sorted by fully qualified name)
	 */
	public TreeSet<VariableDefinition> getVariableDefinitionsInPackages() {
		if (variableDefinitionsInPackages == null) {
			variableDefinitionsInPackages = new TreeSet<VariableDefinition>(new Comparator<VariableDefinition>() {

				@Override
				public int compare(VariableDefinition aFirst, VariableDefinition aSecond) {
					String tempFirstName = getFullyQualifiedVariableOrConstantName(aFirst.getName());
					String tempSecondName = getFullyQualifiedVariableOrConstantName(aSecond.getName());

					return tempFirstName.compareTo(tempSecondName);
				}
			});

			for (Model tempModel : models) {
				TreeIterator<EObject> tempIter = tempModel.eAllContents();
				while (tempIter.hasNext()) {
					EObject tempObject = tempIter.next();
					if (tempObject instanceof VariableDefinition) {
						if (tempObject.eContainer() instanceof PackageDefinition) {
							variableDefinitionsInPackages.add((VariableDefinition) tempObject);
						}
					}
				}
			}
		}

		return variableDefinitionsInPackages;
	}

	/**
	 * Iterates through the whole model and searches for constant definitions.
	 * 
	 * @return a set of constant definitions (sorted by fully qualified name)
	 */
	public TreeSet<ConstantDefinition> getConstantDefinitionsInPackages() {
		if (constantDefinitionsInPackages == null) {
			constantDefinitionsInPackages = new TreeSet<ConstantDefinition>(new Comparator<ConstantDefinition>() {

				@Override
				public int compare(ConstantDefinition aFirst, ConstantDefinition aSecond) {
					String tempFirstName = getFullyQualifiedVariableOrConstantName(aFirst.getName());
					String tempSecondName = getFullyQualifiedVariableOrConstantName(aSecond.getName());

					return tempFirstName.compareTo(tempSecondName);
				}
			});

			for (Model tempModel : models) {
				TreeIterator<EObject> tempIter = tempModel.eAllContents();
				while (tempIter.hasNext()) {
					EObject tempObject = tempIter.next();
					if (tempObject instanceof ConstantDefinition) {
						if (tempObject.eContainer() instanceof PackageDefinition) {
							constantDefinitionsInPackages.add((ConstantDefinition) tempObject);
						}
					}
				}
			}
		}

		return constantDefinitionsInPackages;
	}

	/**
	 * Loads a {@link TestModel} from a given {@link TestResourceProvider}. During this process, the files provided by
	 * the resource provider are parsed, the resulting models are linked and stored in the {@link TestModel}
	 * container.<br>
	 * <br>
	 * Errors, like unresolved symbols, will cause an exception. If a model is returned by this method, you can be sure
	 * that everything was linked fine and the model can be executed by the {@link TestRunner}.
	 * 
	 * @param aResourceProvider
	 *            The resource provider to use for loading the test scripts for the model.
	 * @param aSkipModelChecksFlag
	 *            if true, the test runner will skip the model consistency checks it would otherwise perform during the
	 *            dry run
	 * @param aPerformModelValidationFlag
	 *            if true, the test runner will perform extensive model validation
	 * @param aSetupClass
	 *            the setup class to use for EMF setup and Guice initialization (if null, the default class is used)
	 * @return the test model ready for execution
	 * @throws ModelLoadException
	 *             if any errors occur during loading (syntax errors or unresolvable references)
	 */
	public static TestModel loadTestModel(TestResourceProvider aResourceProvider, boolean aSkipModelChecksFlag,
			boolean aPerformModelValidationFlag, Class<? extends IntegrityDSLSetup> aSetupClass)
			throws ModelLoadException {
		TestModel tempModel
				= instantiateTestModel(aResourceProvider.getClassLoader(), aSetupClass, aSkipModelChecksFlag);
		List<Diagnostic> tempErrors
				= tempModel.readIntegrityScriptFiles(aResourceProvider, aPerformModelValidationFlag);
		if (!tempErrors.isEmpty()) {
			throw new ModelParseException("Encountered " + tempErrors.size() + " errors while parsing test model.",
					tempErrors);
		}

		if (tempModel.getDuplicateDefinitions().size() > 0) {
			throw new ModelAmbiguousException("Encountered " + tempModel.getDuplicateDefinitions().size()
					+ " ambiguous definitions in the test model.", tempModel.getDuplicateDefinitions());
		}

		return tempModel;
	}

	/**
	 * Instantiates a TestModel using the provided setup class.
	 * 
	 * @param aClassLoader
	 *            the class loader to use for Integrity stuff
	 * @param aSetupClass
	 *            the setup class to use for EMF setup and Guice initialization (if null, the default class is used)
	 * @param aSkipModelChecksFlag
	 *            if true, the test runner will skip the model consistency checks it would otherwise perform during the
	 *            dry run
	 * @return the new (but still empty) test model
	 */
	public static TestModel instantiateTestModel(ClassLoader aClassLoader,
			Class<? extends IntegrityDSLSetup> aSetupClass, boolean aSkipModelChecksFlag) {
		Class<? extends IntegrityDSLSetup> tempSetupClass = aSetupClass;
		if (tempSetupClass == null) {
			tempSetupClass = IntegrityDSLSetup.class;
		}

		IntegrityDSLSetup tempSetup;
		try {
			tempSetup = tempSetupClass.newInstance();
		} catch (InstantiationException exc) {
			throw new IllegalArgumentException(
					"Provided setup class '" + tempSetupClass + "' could not be instantiated.", exc);
		} catch (IllegalAccessException exc) {
			throw new IllegalArgumentException(
					"Provided setup class '" + tempSetupClass + "' could not be instantiated.", exc);
		}

		if (aClassLoader != null) {
			tempSetup.setClassLoader(aClassLoader);
		}
		tempSetup.setDisableModelChecks(aSkipModelChecksFlag);

		Injector tempInjector = tempSetup.createInjectorAndDoEMFRegistration();

		return tempInjector.getInstance(TestModel.class);
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
	 *            the seed for the {@link de.gebit.integrity.runner.operations.RandomNumberOperation} (optional;
	 *            randomly determined if not given).
	 * @param someCommandLineArguments
	 *            all command line arguments as given to the original Java programs' main routine (required for
	 *            forking!)
	 * @return the initialized test runner instance
	 * @throws IOException
	 *             if the remoting server startup fails
	 */
	public TestRunner initializeTestRunner(TestRunnerCallback aCallback, Map<String, String> someParameterizedConstants,
			String aResultLocale, Integer aRemotingPort, String aRemotingBindHost, Long aRandomSeed,
			String[] someCommandLineArguments) throws IOException {
		TestRunner tempRunner = injector.getInstance(TestRunner.class);

		tempRunner.initialize(this, someParameterizedConstants, aCallback, aResultLocale, aRemotingPort,
				aRemotingBindHost, aRandomSeed, someCommandLineArguments);

		return tempRunner;
	}

	/**
	 * Returns a list of duplicates of all resource providers ever used to load test scripts into this
	 * {@link TestModel}. These duplicates are instances of {@link InMemoryTestResourceProvider}, meaning they contain
	 * the whole script data inside their instances, so nothing has to be loaded from the file system or other sources
	 * anymore. They also are transferable via Serialization, so they can be used to initialize Forks, which is their
	 * primary use!
	 * 
	 * @return duplicates of the used resource providers
	 * @throws IOException
	 *             in case of errors during duplication
	 */
	public List<InMemoryTestResourceProvider> getInMemoryResourceProviders() throws IOException {
		if (inMemoryResourceProviders == null) {
			inMemoryResourceProviders = new ArrayList<>(loadedResourceProviders.size());

			for (TestResourceProvider tempResourceProvider : loadedResourceProviders) {
				if (tempResourceProvider instanceof InMemoryTestResourceProvider) {
					inMemoryResourceProviders.add((InMemoryTestResourceProvider) tempResourceProvider);
				} else {
					inMemoryResourceProviders.add(new InMemoryTestResourceProvider(tempResourceProvider, "MASTER::"));
				}
			}
		}

		return inMemoryResourceProviders;
	}

}

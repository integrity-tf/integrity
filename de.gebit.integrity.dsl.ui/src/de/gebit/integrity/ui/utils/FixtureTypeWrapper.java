/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.ui.utils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.IAnnotation;
import org.eclipse.jdt.core.IField;
import org.eclipse.jdt.core.ILocalVariable;
import org.eclipse.jdt.core.IMemberValuePair;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.ToolFactory;
import org.eclipse.jdt.core.search.IJavaSearchConstants;
import org.eclipse.jdt.core.search.IJavaSearchScope;
import org.eclipse.jdt.core.search.SearchEngine;
import org.eclipse.jdt.core.search.SearchMatch;
import org.eclipse.jdt.core.search.SearchParticipant;
import org.eclipse.jdt.core.search.SearchPattern;
import org.eclipse.jdt.core.search.SearchRequestor;
import org.eclipse.jdt.core.util.IAnnotationComponent;
import org.eclipse.jdt.core.util.IAnnotationComponentValue;
import org.eclipse.jdt.core.util.IClassFileAttribute;
import org.eclipse.jdt.core.util.IClassFileReader;
import org.eclipse.jdt.core.util.IRuntimeInvisibleAnnotationsAttribute;

import de.gebit.integrity.dsl.ResultName;
import de.gebit.integrity.dsl.ValueOrEnumValueOrOperationCollection;
import de.gebit.integrity.fixtures.ArbitraryParameterEnumerator;
import de.gebit.integrity.fixtures.ArbitraryParameterEnumerator.ArbitraryParameterDefinition;
import de.gebit.integrity.fixtures.ArbitraryParameterFixture;
import de.gebit.integrity.fixtures.ArbitraryParameterFixtureLink;
import de.gebit.integrity.fixtures.CustomProposalFixture;
import de.gebit.integrity.fixtures.CustomProposalProvider;
import de.gebit.integrity.fixtures.CustomProposalProvider.CustomProposalFixtureLink;
import de.gebit.integrity.fixtures.FixtureParameter;
import de.gebit.integrity.operations.UnexecutableException;
import de.gebit.integrity.parameter.conversion.ConversionException;
import de.gebit.integrity.parameter.conversion.UnresolvableVariableHandling;
import de.gebit.integrity.parameter.conversion.ValueConverter;
import de.gebit.integrity.ui.utils.IntegrityDSLUIUtil.ResolvedTypeName;
import de.gebit.integrity.utils.IntegrityDSLUtil;
import de.gebit.integrity.utils.ParameterUtil.UnresolvableVariableException;

/**
 * Wrapper used in a similar fashion as the {@link de.gebit.integrity.fixtures.FixtureWrapper}. It encapsulates an IType
 * object and provides methods required when accessing the type during autocompletion etc.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class FixtureTypeWrapper {

	/**
	 * The currently used Classloading Util.
	 */
	private static ClassLoadingUtil classLoadingUtil = new ClassLoadingUtil();

	/**
	 * The encapsulated type.
	 */
	private IType fixtureType;

	/**
	 * The value converter to use.
	 */
	private ValueConverter valueConverter;

	/**
	 * Creates a new instance.
	 * 
	 * @param aFixtureType
	 *            the type to encapsulate
	 */
	public FixtureTypeWrapper(IType aFixtureType, ValueConverter aValueConverter) {
		fixtureType = aFixtureType;
		valueConverter = aValueConverter;
	}

	/**
	 * Finds a method with a specific name in the encapsulated type.
	 * 
	 * @param aMethodName
	 *            the method name to find
	 * @return the method if found, null if not
	 * @throws JavaModelException
	 */
	protected IMethod findMethod(String aMethodName) throws JavaModelException {
		for (IMethod tempPossibleMethod : fixtureType.getMethods()) {
			if (aMethodName.equals(tempPossibleMethod.getElementName())) {
				return tempPossibleMethod;
			}
		}

		return null;
	}

	/**
	 * Replaces all values in the given parameter map with converted versions that match the types that are expected by
	 * the given fixture method.
	 * 
	 * @param aFixtureMethodName
	 *            the method name
	 * @param aParameterMap
	 *            the parameter map
	 * @param aParameterPath
	 *            the path inside a nested object, if applicable
	 * @param anIncludeArbitraryParametersFlag
	 *            whether arbitrary parameters shall be included
	 * @throws JavaModelException
	 * @throws UnexecutableException
	 * @throws UnresolvableVariableException
	 */
	public void convertParameterValuesToFixtureDefinedTypes(String aFixtureMethodName,
			Map<String, Object> aParameterMap, List<String> aParameterPath, boolean anIncludeArbitraryParametersFlag)
			throws JavaModelException, UnresolvableVariableException, UnexecutableException {
		IMethod tempMethod = findMethod(aFixtureMethodName);

		Map<String, Object> tempFixedParamsMap = new HashMap<String, Object>();
		for (ILocalVariable tempParam : tempMethod.getParameters()) {
			ResolvedTypeName tempParamTypeName = IntegrityDSLUIUtil.getResolvedTypeName(tempParam.getTypeSignature(),
					fixtureType);
			if (tempParamTypeName == null) {
				continue;
			}

			if (tempParamTypeName.getRawType().startsWith(Map.class.getName())) {
				// ignore the arbitrary parameter parameter
			} else {
				IAnnotation tempAnnotation = null;
				for (IAnnotation tempAnnotationCandidate : tempParam.getAnnotations()) {
					String tempCandidateName = tempAnnotationCandidate.getElementName();
					if (FixtureParameter.class.getName().equals(tempCandidateName)
							|| FixtureParameter.class.getSimpleName().equals(tempCandidateName)) {
						tempAnnotation = tempAnnotationCandidate;
						break;
					}
				}

				if (tempAnnotation != null) {
					String tempName = null;
					for (IMemberValuePair tempPair : tempAnnotation.getMemberValuePairs()) {
						if ("name".equals(tempPair.getMemberName())) {
							tempName = (String) tempPair.getValue();
						}
					}

					if (tempName != null) {
						Object tempValue = aParameterMap.get(tempName);
						if (tempValue != null) {
							Class<?> tempExpectedType;
							try {
								tempExpectedType = getClass().getClassLoader()
										.loadClass(tempParamTypeName.getRawType());
							} catch (ClassNotFoundException exc) {
								// we'll skip this param
								continue;
							}

							Object tempConvertedValue;
							if (tempValue instanceof Object[]) {
								if (!tempExpectedType.isArray()) {
									throw new IllegalArgumentException("The parameter '" + tempName + "' of method '"
											+ aFixtureMethodName + "' in fixture '"
											+ fixtureType.getFullyQualifiedName()
											+ "' is not an array type, thus you cannot put multiple values into it!");
								}
								Object tempConvertedValueArray = Array.newInstance(tempExpectedType.getComponentType(),
										((Object[]) tempValue).length);
								for (int k = 0; k < ((Object[]) tempValue).length; k++) {
									Object tempSingleValue = ((Object[]) tempValue)[k];
									Array.set(tempConvertedValueArray, k, valueConverter.convertValue(
											tempExpectedType.getComponentType(), tempSingleValue,
											UnresolvableVariableHandling.RESOLVE_TO_NULL_VALUE));
								}
								tempConvertedValue = tempConvertedValueArray;
							} else {
								// if the expected type is an array, we don't want to convert to that array, but to
								// the
								// component type, of course
								Class<?> tempConversionTargetType = tempExpectedType.isArray() ? tempExpectedType
										.getComponentType() : tempExpectedType;
								tempConvertedValue = valueConverter.convertValue(tempConversionTargetType, tempValue,
										UnresolvableVariableHandling.RESOLVE_TO_NULL_VALUE);
								if (tempExpectedType.isArray()) {
									// ...and if the expected type is an array, now we create one
									Object tempNewArray = Array.newInstance(tempExpectedType.getComponentType(), 1);
									Array.set(tempNewArray, 0, tempConvertedValue);
									tempConvertedValue = tempNewArray;
								}
							}
							aParameterMap.put(tempName, tempConvertedValue);
							tempFixedParamsMap.put(tempName, tempConvertedValue);
						}
					}
				}
			}
		}

		if (anIncludeArbitraryParametersFlag && isArbitraryParameterFixtureClass()) {
			ArbitraryParameterEnumerator tempArbitraryParameterEnumerator = instantiateArbitraryParameterEnumerator();

			List<ArbitraryParameterDefinition> tempArbitraryParameters = tempArbitraryParameterEnumerator
					.defineArbitraryParameters(aFixtureMethodName, tempFixedParamsMap, aParameterPath);
			if (tempArbitraryParameters != null) {
				for (ArbitraryParameterDefinition tempArbitraryParameter : tempArbitraryParameters) {
					String tempName = tempArbitraryParameter.getName();
					Object tempValue = aParameterMap.remove(tempName);
					if (tempValue != null) {
						Object tempConvertedValue;
						tempConvertedValue = valueConverter.convertValue(null, tempValue,
								UnresolvableVariableHandling.RESOLVE_TO_NULL_VALUE);
						aParameterMap.put(tempName, tempConvertedValue);
					}
				}
			}
		}
	}

	/**
	 * Converts a given result value (collection) to a fixture-method-defined result type. This won't do any variable
	 * replacement, since it's designed to be used inside Eclipse!
	 * 
	 * @param aFixtureMethodName
	 *            the method name
	 * @param aResultName
	 *            the name of the result (may be null if the default result is meant)
	 * @param aValue
	 *            the value to convert
	 * @return the converted value
	 * @throws JavaModelException
	 */
	public Object convertResultValueToFixtureDefinedType(String aFixtureMethodName, ResultName aResultName,
			ValueOrEnumValueOrOperationCollection aValue) throws JavaModelException {
		IMethod tempMethod = findMethod(aFixtureMethodName);
		if (tempMethod == null) {
			return aValue;
		}

		// TODO this doesn't seem to be able to work with arrays?! Check that!

		ResolvedTypeName tempTargetTypeName = null;
		if (aResultName == null) {
			// it's the default result type
			tempTargetTypeName = IntegrityDSLUIUtil.getResolvedTypeName(tempMethod.getReturnType(),
					tempMethod.getDeclaringType());
		} else {
			// must be a named result, we'll thus have to explore the container type
			String tempResultNameString = IntegrityDSLUtil.getExpectedResultNameStringFromTestResultName(aResultName);

			ResolvedTypeName tempContainerTypeName = IntegrityDSLUIUtil.getResolvedTypeName(tempMethod.getReturnType(),
					tempMethod.getDeclaringType());
			if (tempContainerTypeName != null) {
				IType tempContainerType = IntegrityDSLUIUtil.findTypeByName(tempContainerTypeName.getRawType());
				if (tempContainerType != null) {
					IField tempResultField = IntegrityDSLUIUtil
							.findFieldByName(tempContainerType, tempResultNameString);
					if (tempResultField != null) {
						tempTargetTypeName = IntegrityDSLUIUtil.getResolvedTypeName(tempResultField.getTypeSignature(),
								tempContainerType);
					}
				}
			}
		}

		if (tempTargetTypeName != null) {
			try {
				Class<?> tempTargetType = getClass().getClassLoader().loadClass(tempTargetTypeName.getRawType());
				return valueConverter.convertValue(tempTargetType, aValue, UnresolvableVariableHandling.EXCEPTION);
			} catch (ClassNotFoundException exc) {
				// skip this one; cannot convert
			} catch (UnexecutableException exc) {
				// skip this one; cannot convert
			} catch (ConversionException exc) {
				// skip this one; cannot convert
			}
		}

		return aValue;
	}

	/**
	 * Checks whether the encapsulated type is an arbitrary parameter fixture class.
	 * 
	 * @return
	 */
	public boolean isArbitraryParameterFixtureClass() {
		try {
			for (IType tempInterface : fixtureType.newSupertypeHierarchy(null).getAllSuperInterfaces(fixtureType)) {
				if (ArbitraryParameterFixture.class.getName().equals(tempInterface.getFullyQualifiedName())) {
					return true;
				}
			}
		} catch (JavaModelException exc) {
			exc.printStackTrace();
		}
		return false;
	}

	/**
	 * Determines the {@link ArbitraryParameterEnumerator} class to use for the encapsulated fixture type and
	 * instantiates it.
	 * 
	 * @return the enumerator or null if the class isn't an arbitrary fixture class or if there is no matching
	 *         enumerator class found in the workspace
	 */
	public ArbitraryParameterEnumerator instantiateArbitraryParameterEnumerator() {
		if (!isArbitraryParameterFixtureClass()) {
			return null;
		}
		LinkedProviderFinder<ArbitraryParameterEnumerator> tempFinder = new LinkedProviderFinder<ArbitraryParameterEnumerator>(
				ArbitraryParameterFixtureLink.class);
		try {
			Class<? extends ArbitraryParameterEnumerator> tempClass = tempFinder.findProviderForFixtureType(fixtureType
					.getFullyQualifiedName());
			if (tempClass != null) {
				return tempClass.newInstance();
			}
		} catch (ClassNotFoundException exc) {
			exc.printStackTrace();
		} catch (InstantiationException exc) {
			exc.printStackTrace();
		} catch (IllegalAccessException exc) {
			exc.printStackTrace();
		}

		return null;
	}

	/**
	 * Checks whether the encapsulated type is a custom proposal fixture class.
	 * 
	 * @return
	 */
	public boolean isCustomProposalFixtureClass() {
		try {
			for (IType tempInterface : fixtureType.newSupertypeHierarchy(null).getAllSuperInterfaces(fixtureType)) {
				if (CustomProposalFixture.class.getName().equals(tempInterface.getFullyQualifiedName())) {
					return true;
				}
			}
		} catch (JavaModelException exc) {
			exc.printStackTrace();
		}
		return false;
	}

	/**
	 * Determines the {@link CustomProposalProvider} class to use for the encapsulated fixture type and instantiates it.
	 * 
	 * @return the custom proposal provider
	 */
	public CustomProposalProvider instantiateCustomProposalProvider() {
		if (!isCustomProposalFixtureClass()) {
			return null;
		}
		LinkedProviderFinder<CustomProposalProvider> tempFinder = new LinkedProviderFinder<CustomProposalProvider>(
				CustomProposalFixtureLink.class);
		try {
			Class<? extends CustomProposalProvider> tempClass = tempFinder.findProviderForFixtureType(fixtureType
					.getFullyQualifiedName());
			if (tempClass != null) {
				return tempClass.newInstance();
			}
		} catch (ClassNotFoundException exc) {
			exc.printStackTrace();
		} catch (InstantiationException exc) {
			exc.printStackTrace();
		} catch (IllegalAccessException exc) {
			exc.printStackTrace();
		}

		return null;
	}

	/**
	 * Finds providers linked to fixtures using link annotations. This class is able to deal with both relevant
	 * situations: having the source code in the workspace, and having no source but just the classes inside jars in the
	 * classpath.
	 * 
	 * 
	 * @author Rene Schneider - initial API and implementation
	 * 
	 * @param <Provider>
	 */
	private final class LinkedProviderFinder<Provider> {

		/**
		 * The link annotation class.
		 */
		private Class<? extends Annotation> linkAnnotationClass;

		private LinkedProviderFinder(Class<? extends Annotation> aLinkAnnotationClass) {
			linkAnnotationClass = aLinkAnnotationClass;
		}

		/**
		 * The search result.
		 */
		private IType searchResult;

		@SuppressWarnings("unchecked")
		private Class<? extends Provider> findProviderForFixtureType(final String aFullyQualifiedName)
				throws ClassNotFoundException, InstantiationException, IllegalAccessException {

			SearchPattern tempInheritPattern = SearchPattern.createPattern(
					linkAnnotationClass.getName().replace('$', '.'), IJavaSearchConstants.ANNOTATION_TYPE,
					IJavaSearchConstants.REFERENCES | IJavaSearchConstants.ANNOTATION_TYPE_REFERENCE,
					SearchPattern.R_EXACT_MATCH | SearchPattern.R_CASE_SENSITIVE);
			IJavaSearchScope tempScope = SearchEngine.createWorkspaceScope();
			SearchRequestor tempRequestor = new SearchRequestor() {

				@Override
				public void acceptSearchMatch(SearchMatch aMatch) throws CoreException {
					IType tempType = (IType) aMatch.getElement();

					List<String> tempLinkedClassNames = new ArrayList<String>();

					if (tempType.isBinary()) {
						// It seems to be impossible to get values from annotations in binary types using the JDT Java
						// model :-( thus an alternative way is implemented here using the ClassFileReader.
						IClassFileReader tempReader = ToolFactory.createDefaultClassFileReader(tempType.getClassFile(),
								IClassFileReader.CLASSFILE_ATTRIBUTES);
						for (IClassFileAttribute tempAttribute : tempReader.getAttributes()) {
							if (tempAttribute instanceof IRuntimeInvisibleAnnotationsAttribute) {
								for (org.eclipse.jdt.core.util.IAnnotation tempAnnotation : ((IRuntimeInvisibleAnnotationsAttribute) tempAttribute)
										.getAnnotations()) {
									ResolvedTypeName tempAnnotationName = IntegrityDSLUIUtil.getResolvedTypeName(
											new String(tempAnnotation.getTypeName()), tempType);
									// Resolved type names have no $ in them in case of inner classes because of the
									// behavior of the org.eclipse.jdt.core.Signature.toString() method, so we need to
									// replace them in the class name as well for matching.
									if (linkAnnotationClass.getName().replace('$', '.')
											.equals(tempAnnotationName.getRawType())) {
										// This is the right annotation, and it only has one component
										IAnnotationComponent tempComponent = tempAnnotation.getComponents()[0];
										IAnnotationComponentValue tempComponentValue = tempComponent
												.getComponentValue();
										if (tempComponentValue.getTag() == IAnnotationComponentValue.ARRAY_TAG) {
											// Multiple values may be stored here...
											for (IAnnotationComponentValue tempInnerValue : tempComponentValue
													.getAnnotationComponentValues()) {
												if (tempInnerValue.getTag() == IAnnotationComponentValue.CLASS_TAG) {
													ResolvedTypeName tempResolvedLinkedClassName = IntegrityDSLUIUtil
															.getResolvedTypeName(new String(tempInnerValue
																	.getClassInfo().getUtf8Value()), tempType);
													tempLinkedClassNames.add(tempResolvedLinkedClassName.getRawType());
												}
											}
										} else if (tempComponentValue.getTag() == IAnnotationComponentValue.CLASS_TAG) {
											ResolvedTypeName tempResolvedLinkedClassName = IntegrityDSLUIUtil
													.getResolvedTypeName(new String(tempComponentValue.getClassInfo()
															.getUtf8Value()), tempType);
											tempLinkedClassNames.add(tempResolvedLinkedClassName.getRawType());
										}
									}
								}
							}
						}
					} else {
						// For source types, we can use the JDT model to resolve the annotation which is much easier :-)

						// This will find the annotation if it's referred by its short name (using an import)...
						IAnnotation tempAnnotation = tempType.getAnnotation(linkAnnotationClass.getSimpleName());
						if (tempAnnotation == null || !tempAnnotation.exists()) {
							// ...and this will find it if it's referred by its fully qualified name
							tempAnnotation = tempType.getAnnotation(linkAnnotationClass.getName());
						}

						if (tempAnnotation != null && tempAnnotation.exists()) {
							try {
								IMemberValuePair[] tempPairs = tempAnnotation.getMemberValuePairs();
								if (tempPairs.length == 1) {
									if (tempPairs[0].getValue().getClass().isArray()) {
										Object[] tempObjects = (Object[]) tempPairs[0].getValue();
										for (int i = 0; i < tempObjects.length; i++) {
											tempLinkedClassNames.add((String) tempObjects[i]);
										}
									} else {
										tempLinkedClassNames.add((String) tempPairs[0].getValue());
									}
								}
							} catch (JavaModelException exc) {
								exc.printStackTrace();
							}
						}
					}

					// Now we'll see if we have a match
					String tempNormalizedFullyQualifiedName = aFullyQualifiedName.replace('$', '.');
					outer: for (String tempLinkedClassName : tempLinkedClassNames) {
						if (tempNormalizedFullyQualifiedName.equals(tempLinkedClassName.replace('$', '.'))) {
							// this is a match
							searchResult = tempType;
							break outer;
						} else {
							// no match, but that could be because the linked class name is not fully
							// qualified
							if (aFullyQualifiedName.endsWith(tempLinkedClassName)) {
								// okay, we have to check that
								String[][] tempPossibleMatches = tempType.resolveType(tempLinkedClassName);
								for (String[] tempMatch : tempPossibleMatches) {
									// we can ignore the default package here as that case would have
									// already
									// matched before
									String tempFullMatch = tempMatch[0] + "." + tempMatch[1];
									if (aFullyQualifiedName.equals(tempFullMatch)) {
										// yeah, a match
										searchResult = tempType;
										break outer;
									}
								}
							}
						}
					}
				}
			};

			SearchEngine tempSearchEngine = new SearchEngine();
			try {
				tempSearchEngine.search(tempInheritPattern,
						new SearchParticipant[] { SearchEngine.getDefaultSearchParticipant() }, tempScope,
						tempRequestor, null);
			} catch (CoreException exc) {
				exc.printStackTrace();
			}

			// at this point the search should have found a result and stored it, otherwise we can stop here
			if (searchResult == null) {
				return null;
			}

			return (Class<? extends Provider>) classLoadingUtil.loadClassFromWorkspace(
					searchResult.getFullyQualifiedName(), searchResult.getJavaProject());
		}
	}

}

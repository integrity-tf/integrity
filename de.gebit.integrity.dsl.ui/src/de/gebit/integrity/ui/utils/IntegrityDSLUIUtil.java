/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.ui.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.Flags;
import org.eclipse.jdt.core.IField;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.ITypeHierarchy;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.Signature;
import org.eclipse.jdt.core.search.IJavaSearchConstants;
import org.eclipse.jdt.core.search.IJavaSearchScope;
import org.eclipse.jdt.core.search.SearchEngine;
import org.eclipse.jdt.core.search.SearchMatch;
import org.eclipse.jdt.core.search.SearchParticipant;
import org.eclipse.jdt.core.search.SearchPattern;
import org.eclipse.jdt.core.search.SearchRequestor;

/**
 * Utility class providing various helper functions. This one performs Eclipse JDT stuff.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public final class IntegrityDSLUIUtil {

	private IntegrityDSLUIUtil() {
		// private constructor
	}

	/**
	 * Determines the fully qualified class name from a type signature and a type where that type signature is declared.
	 * 
	 * @param aTypeSignature
	 *            the type signature
	 * @param aDeclaringType
	 *            the type in which the type signature was found
	 * @return the fully qualified class name, packaged up with generics parameter information
	 * @throws JavaModelException
	 */
	public static ResolvedTypeName getResolvedTypeName(String aTypeSignature, IType aDeclaringType)
			throws JavaModelException {
		int tempArrayCount = Signature.getArrayCount(aTypeSignature);
		char tempType = aTypeSignature.charAt(tempArrayCount);
		if (tempType == Signature.C_UNRESOLVED) {
			String tempName = "";
			int tempBracketOpenPosition = aTypeSignature.indexOf(Signature.C_GENERIC_START, tempArrayCount + 1);
			if (tempBracketOpenPosition > 0) {
				tempName = aTypeSignature.substring(tempArrayCount + 1, tempBracketOpenPosition);
			} else {
				int tempSemicolonPosition = aTypeSignature.indexOf(Signature.C_SEMICOLON, tempArrayCount + 1);
				if (tempSemicolonPosition == -1) {
					throw new IllegalArgumentException();
				}
				tempName = aTypeSignature.substring(tempArrayCount + 1, tempSemicolonPosition);
			}
			String[][] tempResolvedNames = aDeclaringType.resolveType(tempName);
			if (tempResolvedNames != null && tempResolvedNames.length > 0) {
				StringBuffer tempBuffer = new StringBuffer();
				if (tempResolvedNames[0][0] != null && tempResolvedNames[0][0].length() > 0) {
					tempBuffer.append(tempResolvedNames[0][0]);
				}
				if (tempResolvedNames[0][1] != null && tempResolvedNames[0][1].length() > 0) {
					if (tempBuffer.length() > 0) {
						tempBuffer.append('.');
					}
					tempBuffer.append(tempResolvedNames[0][1]);
				}
				String tempRawTypeName = tempBuffer.toString();

				// Now on to the generic parameters
				if (tempBracketOpenPosition > 0) {
					int tempBracketClosePosition = aTypeSignature.lastIndexOf(Signature.C_GENERIC_END);
					if (tempBracketClosePosition == -1) {
						throw new IllegalArgumentException();
					}

					String tempParameterNamesSignature = aTypeSignature.substring(tempBracketOpenPosition + 1,
							tempBracketClosePosition);

					// This one must be splitted now
					List<String> tempParameterNameSignatures = new ArrayList<String>();
					int tempGenericStackSize = 0;
					int tempStart = 0;
					for (int i = 0; i < tempParameterNamesSignature.length(); i++) {
						char tempChar = tempParameterNamesSignature.charAt(i);
						if (tempChar == Signature.C_GENERIC_START) {
							tempGenericStackSize++;
						} else if (tempChar == Signature.C_GENERIC_END) {
							tempGenericStackSize--;
						} else if (tempChar == Signature.C_SEMICOLON) {
							if (tempGenericStackSize == 0) {
								// this is a valid splitting point
								tempParameterNameSignatures
										.add(tempParameterNamesSignature.substring(tempStart, i + 1));
								tempStart = i + 1;
							}
						}
					}

					ResolvedTypeName[] tempGenericParameterTypes = new ResolvedTypeName[tempParameterNameSignatures
							.size()];
					for (int i = 0; i < tempParameterNameSignatures.size(); i++) {
						tempGenericParameterTypes[i] = getResolvedTypeName(tempParameterNameSignatures.get(i),
								aDeclaringType);
					}

					return new ResolvedTypeName(tempRawTypeName, tempGenericParameterTypes);
				} else {
					return new ResolvedTypeName(tempRawTypeName);
				}
			}
			return null;
		} else {
			return new ResolvedTypeName(Signature.toString(aTypeSignature.substring(tempArrayCount)).replace('/', '.'));
		}
	}

	/**
	 * Holds a resolved type name, as returned by {@link IntegrityDSLUIUtil#getResolvedTypeName(String, IType)}.
	 * 
	 * 
	 * @author Rene Schneider - initial API and implementation
	 * 
	 */
	public static class ResolvedTypeName {
		/**
		 * The raw type name.
		 */
		private String rawType;

		/**
		 * The generic parameters, if present.
		 */
		private ResolvedTypeName[] genericParameterTypes;

		/**
		 * Creates a new instance.
		 * 
		 * @param aRawType
		 */
		public ResolvedTypeName(String aRawType) {
			rawType = aRawType;
		}

		/**
		 * Creates a new instance.
		 * 
		 * @param aRawType
		 * @param someGenericParameterTypes
		 */
		public ResolvedTypeName(String aRawType, ResolvedTypeName[] someGenericParameterTypes) {
			rawType = aRawType;
			genericParameterTypes = someGenericParameterTypes;
		}

		public String getRawType() {
			return rawType;
		}

		public ResolvedTypeName[] getGenericParameterTypes() {
			return genericParameterTypes;
		}

	}

	/**
	 * Finds an {@link IType} by its corresponding fully qualified name.
	 * 
	 * @param aFullyQualifiedClassName
	 *            the fully qualified name
	 * @return the type or null if not found
	 */
	public static IType findTypeByName(String aFullyQualifiedClassName) {
		if (aFullyQualifiedClassName == null) {
			return null;
		}

		return new TypeFinder().findTypeByName(aFullyQualifiedClassName);
	}

	/**
	 * Finds an {@link IField} by its name in a given {@link IType}.
	 * 
	 * @param aType
	 *            the type to search in
	 * @param aFieldName
	 *            the field name
	 * @return the field or null if not found
	 * @throws JavaModelException
	 */
	public static IField findFieldByName(IType aType, String aFieldName) throws JavaModelException {
		ITypeHierarchy tempTypeHierarchy = aType.newSupertypeHierarchy(null);
		IType tempTypeInFocus = aType;

		// try to locate field by its original name
		while (tempTypeInFocus != null) {
			IField tempField = tempTypeInFocus.getField(aFieldName);
			if (tempField != null && tempField.exists()) {
				return tempField;
			} else {
				tempTypeInFocus = tempTypeHierarchy.getSuperclass(tempTypeInFocus);
			}
		}

		// if not locatable - try find with custom prefix
		tempTypeInFocus = aType;
		for (String tempPrefix : CUSTOM_PREFIX_LIST) {
			String tempNameWithPrefix = tempPrefix + aFieldName.substring(0, 1).toUpperCase() + aFieldName.substring(1);

			while (tempTypeInFocus != null) {
				IField tempField = tempTypeInFocus.getField(tempNameWithPrefix);
				if (tempField != null && tempField.exists()) {
					return tempField;
				} else {
					tempTypeInFocus = tempTypeHierarchy.getSuperclass(tempTypeInFocus);
				}
			}
		}

		return null;
	}

	/**
	 * List of potential prefixes that may be placed before the "actual" field name (the one visible from the outside by
	 * looking at the accessor names) in order to form the internally used field name.
	 */
	private static final String[] CUSTOM_PREFIX_LIST = new String[] { "Local" };

	/**
	 * Finds all {@link IField}s in a given {@link IType} (including fields defined in supertypes!).
	 * 
	 * @param aType
	 *            the type to search in
	 * @param aFilterSetterlessPrivateFields
	 *            whether setterless private fields shall be filtered out
	 * @return all fields
	 * @throws JavaModelException
	 */
	public static List<FieldDescription> getAllFields(IType aType, boolean aFilterSetterlessPrivateFields)
			throws JavaModelException {
		ITypeHierarchy tempTypeHierarchy = aType.newSupertypeHierarchy(null);
		IType tempTypeInFocus = aType;

		List<FieldDescription> tempResults = new ArrayList<FieldDescription>();
		while (tempTypeInFocus != null) {
			Set<String> tempSetterMethodNames = null;

			for (IField tempField : tempTypeInFocus.getFields()) {
				FieldDescription tempFieldDescription = new FieldDescription(tempField.getElementName(),
						JavadocUtil.getFieldJavadoc(tempField));

				if (aFilterSetterlessPrivateFields) {
					boolean tempIsReachable = false;
					if (Flags.isPublic(tempField.getFlags())) {
						tempIsReachable = true;
					} else {
						// We are doing the bean introspection by ourself because we don't want to load the class, which
						// would be necessary for using the java.bean.* stuff.
						if (tempSetterMethodNames == null) {
							tempSetterMethodNames = new HashSet<String>();
							for (IMethod tempMethod : tempTypeInFocus.getMethods()) {
								String tempMethodName = tempMethod.getElementName();
								if (tempMethodName.startsWith("set")) {
									tempSetterMethodNames.add(tempMethodName);
								}
							}
						}

						String tempSetterMethodNameSuffix = tempField.getElementName().substring(0, 1).toUpperCase()
								+ tempField.getElementName().substring(1);

						// first check for the default setter name
						if (tempSetterMethodNames.contains("set" + tempSetterMethodNameSuffix)) {
							tempIsReachable = true;
						} else {
							// The field may be prefixed (eg. "localText" as field name with "setText" and "getText" as
							// accessors)
							for (String tempCustomPrefix : CUSTOM_PREFIX_LIST) {
								String tempCapitalizedCustomPrefix = tempCustomPrefix.substring(0, 1).toUpperCase()
										+ tempCustomPrefix.substring(1);
								if (tempSetterMethodNameSuffix.startsWith(tempCapitalizedCustomPrefix)
										&& tempCustomPrefix.length() < tempSetterMethodNameSuffix.length()) {
									// Okay, this prefix may be a match. But we still need to see if there's a matching
									// setter WITHOUT the prefix.
									String tempUnprefixedFieldName = tempSetterMethodNameSuffix
											.substring(tempCustomPrefix.length());

									if (tempSetterMethodNames.contains("set" + tempUnprefixedFieldName)) {
										// Good, there is. We will use the field name without the prefix to refer to the
										// field, as that's the name under which this field is visible to the outside
										// world via the accessors.
										tempIsReachable = true;
										tempFieldDescription.setFieldName(tempUnprefixedFieldName.substring(0, 1)
												.toLowerCase() + tempUnprefixedFieldName.substring(1));
										break;
									}
								}
							}
						}
					}

					if (!tempIsReachable) {
						continue;
					}
				}
				tempResults.add(tempFieldDescription);
			}

			tempTypeInFocus = tempTypeHierarchy.getSuperclass(tempTypeInFocus);
		}

		return tempResults;
	}

	/**
	 * Finds providers linked to fixtures using link annotations.
	 * 
	 * 
	 * @author Rene Schneider - initial API and implementation
	 * 
	 * @param <Provider>
	 */
	private static final class TypeFinder {

		/**
		 * The search result.
		 */
		private IType searchResult;

		private IType findTypeByName(final String aFullyQualifiedName) {
			SearchPattern tempInheritPattern = SearchPattern.createPattern(aFullyQualifiedName.replace('$', '.'),
					IJavaSearchConstants.TYPE, IJavaSearchConstants.DECLARATIONS, SearchPattern.R_EXACT_MATCH
							| SearchPattern.R_CASE_SENSITIVE);
			IJavaSearchScope tempScope = SearchEngine.createWorkspaceScope();
			SearchRequestor tempRequestor = new SearchRequestor() {

				@Override
				public void acceptSearchMatch(SearchMatch aMatch) throws CoreException {
					searchResult = (IType) aMatch.getElement();
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

			return searchResult;
		}
	}

	/**
	 * Encapsulates data about a field in a Java Bean Type.
	 * 
	 * 
	 * @author Rene Schneider - initial API and implementation
	 * 
	 */
	public static class FieldDescription {

		/**
		 * The name of the field.
		 */
		private String fieldName;

		/**
		 * The JavaDoc comment for the field.
		 */
		private String javaDoc;

		/**
		 * Creates a new instance.
		 * 
		 * @param aFieldname
		 *            the name of the field
		 * @param aFieldJavadoc
		 *            the javadoc comment of the field
		 */
		public FieldDescription(String aFieldname, String aFieldJavadoc) {
			fieldName = aFieldname;
			javaDoc = aFieldJavadoc;
		}

		public String getJavaDoc() {
			return javaDoc;
		}

		public void setJavaDoc(String aJavaDoc) {
			this.javaDoc = aJavaDoc;
		}

		public String getFieldName() {
			return fieldName;
		}

		public void setFieldName(String aFieldName) {
			this.fieldName = aFieldName;
		}

	}

}

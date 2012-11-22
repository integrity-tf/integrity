/**
 * 
 */
package de.gebit.integrity.ui.utils;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.IField;
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
 * @author Rene Schneider
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
	 * @return the fully qualified class name
	 * @throws JavaModelException
	 */
	public static String getResolvedTypeName(String aTypeSignature, IType aDeclaringType) throws JavaModelException {
		int tempArrayCount = Signature.getArrayCount(aTypeSignature);
		char tempType = aTypeSignature.charAt(tempArrayCount);
		if (tempType == Signature.C_UNRESOLVED) {
			String tempName = "";
			int tempBracket = aTypeSignature.indexOf(Signature.C_GENERIC_START, tempArrayCount + 1);
			if (tempBracket > 0) {
				tempName = aTypeSignature.substring(tempArrayCount + 1, tempBracket);
			} else {
				int tempSemi = aTypeSignature.indexOf(Signature.C_SEMICOLON, tempArrayCount + 1);
				if (tempSemi == -1) {
					throw new IllegalArgumentException();
				}
				tempName = aTypeSignature.substring(tempArrayCount + 1, tempSemi);
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
				return tempBuffer.toString();
			}
			return null;
		} else {
			return Signature.toString(aTypeSignature.substring(tempArrayCount));
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

		while (tempTypeInFocus != null) {
			IField tempField = tempTypeInFocus.getField(aFieldName);
			if (tempField != null) {
				return tempField;
			} else {
				tempTypeInFocus = tempTypeHierarchy.getSuperclass(tempTypeInFocus);
			}
		}

		return null;
	}

	/**
	 * Finds providers linked to fixtures using link annotations.
	 * 
	 * 
	 * @author Rene Schneider
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

}

/**
 * 
 */
package de.gebit.integrity.ui.utils;

import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.Signature;

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

}

/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.utils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.eclipse.xtext.common.types.JvmArrayType;
import org.eclipse.xtext.common.types.JvmEnumerationLiteral;
import org.eclipse.xtext.common.types.JvmEnumerationType;
import org.eclipse.xtext.common.types.JvmType;

/**
 * Util containing some helper methods dealing with Java types.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public final class JavaTypeUtil {

	private JavaTypeUtil() {
		// private constructor
	}

	/**
	 * Searches a class and attempts to find a generic superinterface of a certain type. The result can be used to
	 * acquire the generic parameters of a class.
	 * 
	 * @param aType
	 *            the type to inspect
	 * @param aGenericInterfaceClass
	 *            the generic interface to search for (may be null, in which case the first generic superinterface that
	 *            is found is returned)
	 * @return the {@link ParameterizedType}, if found, otherwise null
	 */
	public static ParameterizedType findGenericInterfaceOrSuperType(Type aType, Class<?> aGenericInterfaceClass) {
		if (aType instanceof ParameterizedType) {
			if (aGenericInterfaceClass == null
					|| ((ParameterizedType) aType).getRawType().equals(aGenericInterfaceClass)) {
				return (ParameterizedType) aType;
			}
		}

		if (aType instanceof Class) {
			for (Type tempInterface : ((Class<?>) aType).getGenericInterfaces()) {
				ParameterizedType tempType = findGenericInterfaceOrSuperType(tempInterface, aGenericInterfaceClass);
				if (tempType != null) {
					return tempType;
				}
			}

			Type tempGenericSupertype = ((Class<?>) aType).getGenericSuperclass();
			if (tempGenericSupertype != null) {
				ParameterizedType tempType = findGenericInterfaceOrSuperType(tempGenericSupertype,
						aGenericInterfaceClass);
				if (tempType != null) {
					return tempType;
				}
			}

			Class<?> tempSuperclass = ((Class<?>) aType).getSuperclass();
			if (tempSuperclass != null) {
				return findGenericInterfaceOrSuperType(tempSuperclass, aGenericInterfaceClass);
			}
		}

		return null;
	}

	/**
	 * Determines the readable java type name for the provided qualified name. Returns short (non-fully-qualified) names
	 * for all the common Java types and fully qualified names for everything else.
	 * 
	 * @param aQualifiedTypeName
	 *            the type to investigate
	 * @return the name
	 */
	public static String getReadableJavaTypeName(String aQualifiedTypeName) {
		int tempArrayPartStart = aQualifiedTypeName.indexOf("[");
		String tempArrayPart = "";
		String tempTypePart = aQualifiedTypeName;
		if (tempArrayPartStart >= 0) {
			tempArrayPart = aQualifiedTypeName.substring(tempArrayPartStart);
			tempTypePart = aQualifiedTypeName.substring(0, tempArrayPartStart);
		}

		if (tempTypePart.startsWith("java.lang.") || tempTypePart.startsWith("java.math.")
				|| tempTypePart.startsWith("java.util.")) {
			tempTypePart = tempTypePart.substring(10);
		}
		if (tempTypePart.startsWith("java.sql.")) {
			tempTypePart = tempTypePart.substring(9);
		}

		if (!tempTypePart.contains(".")) {
			switch (tempTypePart) {
			case "int":
				tempTypePart = "Integer";
				break;
			case "byte":
				tempTypePart = "Byte";
				break;
			case "short":
				tempTypePart = "Short";
				break;
			case "long":
				tempTypePart = "Long";
				break;
			case "char":
				tempTypePart = "Character";
				break;
			case "float":
				tempTypePart = "Float";
				break;
			case "double":
				tempTypePart = "Double";
				break;
			case "boolean":
				tempTypePart = "Boolean";
				break;
			default:
				break;
			}
		}

		return tempTypePart + tempArrayPart;
	}

	/**
	 * Determines the readable java type name for the provided {@link JvmType}. Returns short (non-fully-qualified)
	 * names for all the common Java types and fully qualified names for everything else.
	 * 
	 * @param aType
	 *            the type to investigate
	 * @return the name
	 */
	public static String getReadableJavaTypeName(JvmType aType) {
		String tempQualifiedName = aType.getQualifiedName();

		return getReadableJavaTypeName(tempQualifiedName);
	}

	/**
	 * Resolves a {@link JvmType} to its basic class name (= without array indicators, even if the {@link JvmType} is an
	 * {@link JvmArrayType}).
	 * 
	 * @param aType
	 *            the type to resolve
	 * @return the fully-qualified class name of the type
	 */
	public static String getBasicClassNameFromJvmType(JvmType aType) {
		return getBasicTypeFromJvmType(aType).getQualifiedName();
	}

	/**
	 * Returns the underlying basic {@link JvmType} for the provided {@link JvmType}. This strips out
	 * {@link JvmArrayType}s and resolves them to the component type.
	 * 
	 * @param aType
	 *            the type to resolve
	 * @return the basic type
	 */
	public static JvmType getBasicTypeFromJvmType(JvmType aType) {
		JvmType tempType = aType;

		while (tempType instanceof JvmArrayType) {
			// might be an array of enums! We need to extract the raw type then.
			JvmArrayType tempArrayType = (JvmArrayType) tempType;
			tempType = tempArrayType.getComponentType();
		}

		return tempType;
	}

	/**
	 * Returns a list of all valid enumeration literals that are defined in the given type.
	 * 
	 * @param aType
	 *            the type
	 * @return the enumeration literals, or none if the type reference doesn't refer to an enum type
	 */
	public static List<JvmEnumerationLiteral> getAllEnumLiteralsFromJvmType(JvmType aType) {
		JvmType tempType = getBasicTypeFromJvmType(aType);

		if (tempType instanceof JvmEnumerationType) {
			JvmEnumerationType tempEnumType = (JvmEnumerationType) tempType;
			return tempEnumType.getLiterals();
		}

		return null;
	}

}

/**
 * 
 */
package de.gebit.integrity.utils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Util containing some helper methods dealing with Java types.
 * 
 * @author Rene Schneider
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
	 *            the generic interface to search for
	 * @return the {@link ParameterizedType}, if found, otherwise null
	 */
	public static ParameterizedType findGenericInterfaceOrSuperType(Type aType, Class<?> aGenericInterfaceClass) {
		if (aType instanceof ParameterizedType) {
			if (((ParameterizedType) aType).getRawType().equals(aGenericInterfaceClass)) {
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

}

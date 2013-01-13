/**
 * 
 */
package de.gebit.integrity.utils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 
 * 
 * @author Slartibartfast
 * 
 */
public final class JavaTypeUtil {

	private JavaTypeUtil() {
		// private constructor
	}

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

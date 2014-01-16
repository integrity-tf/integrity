/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.parameter.conversion.conversions.integrity.javaconstants;

import java.lang.reflect.Field;

import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmType;

import com.google.inject.Inject;

import de.gebit.integrity.dsl.JavaConstantValue;
import de.gebit.integrity.operations.UnexecutableException;
import de.gebit.integrity.parameter.conversion.Conversion;
import de.gebit.integrity.parameter.conversion.ConversionContext;
import de.gebit.integrity.parameter.conversion.ConversionFailedException;
import de.gebit.integrity.utils.ParameterUtil.UnresolvableVariableException;

/**
 * Abstract base class for {@link JavaConstantValue} conversions.
 * 
 * @param <T>
 *            target type
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public abstract class AbstractJavaConstantConversion<T> extends Conversion<JavaConstantValue, T> {

	/**
	 * Classloader to use.
	 */
	@Inject
	protected ClassLoader classLoader;

	/**
	 * Converts a Java Constant Value to anything.
	 * 
	 * @param aSource
	 *            the value to convert
	 * @param aTargetType
	 *            the target type
	 * @param aConversionContext
	 *            the conversion context
	 * @return the conversion result
	 * @throws ConversionFailedException
	 */
	protected Object performConversion(JavaConstantValue aSource, Class<? extends Object> aTargetType,
			ConversionContext aConversionContext) throws ConversionFailedException {
		JvmType tempConstantOwner = aSource.getConstant().getType();
		if (tempConstantOwner == null) {
			throw new ConversionFailedException(JavaConstantValue.class, aTargetType,
					"Java class for Java constant not defined");
		}

		String tempClassName = tempConstantOwner.getQualifiedName();
		if (tempClassName == null) {
			throw new ConversionFailedException(JavaConstantValue.class, aTargetType,
					"Java class name for Java constant not determinable");
		}

		JvmField tempConstantField = aSource.getConstant().getConstant();
		if (tempConstantField == null) {
			throw new ConversionFailedException(JavaConstantValue.class, aTargetType,
					"Java field for Java constant in class '" + tempClassName + "' not defined");
		}

		String tempFieldName = tempConstantField.getSimpleName();
		if (tempFieldName == null) {
			throw new ConversionFailedException(JavaConstantValue.class, aTargetType,
					"Java field name for Java constant in class '" + tempClassName + "' not determinable");
		}

		try {
			Class<?> tempClass = classLoader.loadClass(tempClassName);
			Field tempField = tempClass.getField(tempFieldName);

			Object tempStaticValue = tempField.get(null);

			if (aTargetType != null) {
				// Specific target type requested: perform another conversion
				return convertValueRecursive(aTargetType, null, tempStaticValue, aConversionContext);
			} else {
				// Default conversion: just return the object as-is
				return tempStaticValue;
			}
		} catch (ClassNotFoundException exc) {
			throw new ConversionFailedException(JavaConstantValue.class, aTargetType, "Java class '"
					+ tempConstantOwner.getQualifiedName() + "' failed to load", exc);
		} catch (SecurityException exc) {
			throw new ConversionFailedException(JavaConstantValue.class, aTargetType, "Static field '"
					+ tempConstantField.getSimpleName() + " in Java class '" + tempConstantOwner.getQualifiedName()
					+ "' not accessible", exc);
		} catch (NoSuchFieldException exc) {
			throw new ConversionFailedException(JavaConstantValue.class, aTargetType, "Static field '"
					+ tempConstantField.getSimpleName() + " in Java class '" + tempConstantOwner.getQualifiedName()
					+ "' not found", exc);
		} catch (IllegalArgumentException exc) {
			throw new ConversionFailedException(JavaConstantValue.class, aTargetType, "Static field '"
					+ tempConstantField.getSimpleName() + " in Java class '" + tempConstantOwner.getQualifiedName()
					+ "' not readable", exc);
		} catch (IllegalAccessException exc) {
			throw new ConversionFailedException(JavaConstantValue.class, aTargetType, "Static field '"
					+ tempConstantField.getSimpleName() + " in Java class '" + tempConstantOwner.getQualifiedName()
					+ "' not accessible", exc);
		} catch (UnresolvableVariableException exc) {
			throw new ConversionFailedException(JavaConstantValue.class, aTargetType, exc.getMessage(), exc);
		} catch (UnexecutableException exc) {
			throw new ConversionFailedException(JavaConstantValue.class, aTargetType, exc.getMessage(), exc);
		} catch (InstantiationException exc) {
			throw new ConversionFailedException(JavaConstantValue.class, aTargetType, exc.getMessage(), exc);
		}

	}
}

package de.gebit.integrity.utils;

import org.eclipse.xtext.common.types.JvmAnnotationReference;

/**
 * Instances of this class are used as containers to link a parameter name (logical name used within Integrity scripts),
 * the matching Java parameter name and a reference to the annotation attached to the parameter.
 * 
 * @author Rene Schneider (rene.schneider@gebit.de)
 * 
 */
public class ParamAnnotationTuple {

	/**
	 * The name of the parameter, as used in Integrity test scripts.
	 */
	private String paramName;

	/**
	 * The actual name of the parameter in the Java method signature (if applicable and available).
	 */
	private String javaParamName;

	/**
	 * The reference to the {@link de.gebit.integrity.fixtures.FixtureParameter} annotation attached to the parameter.
	 */
	private JvmAnnotationReference annotation;

	/**
	 * Creates a new instance.
	 * 
	 * @param aParamName
	 * @param anAnnotation
	 */
	public ParamAnnotationTuple(String aParamName, JvmAnnotationReference anAnnotation) {
		super();
		paramName = aParamName;
		annotation = anAnnotation;
	}

	/**
	 * Creates a new instance.
	 * 
	 * @param aParamName
	 * @param aJavaParamName
	 * @param anAnnotation
	 */
	public ParamAnnotationTuple(String aParamName, String aJavaParamName, JvmAnnotationReference anAnnotation) {
		super();
		paramName = aParamName;
		javaParamName = aJavaParamName;
		annotation = anAnnotation;
	}

	public String getParamName() {
		return paramName;
	}

	public String getJavaParamName() {
		return javaParamName;
	}

	public JvmAnnotationReference getAnnotation() {
		return annotation;
	}

}

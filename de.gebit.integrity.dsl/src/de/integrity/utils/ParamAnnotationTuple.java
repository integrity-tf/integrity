package de.integrity.utils;

import org.eclipse.xtext.common.types.JvmAnnotationReference;

public class ParamAnnotationTuple {

	private String paramName;

	private String javaParamName;

	private JvmAnnotationReference annotation;

	public ParamAnnotationTuple(String aParamName, JvmAnnotationReference anAnnotation) {
		super();
		paramName = aParamName;
		annotation = anAnnotation;
	}

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

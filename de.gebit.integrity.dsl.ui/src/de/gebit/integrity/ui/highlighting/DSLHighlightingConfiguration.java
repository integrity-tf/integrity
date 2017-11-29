/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.ui.highlighting;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfigurationAcceptor;
import org.eclipse.xtext.ui.editor.utils.TextStyle;

/**
 * Custom highlighting configuration.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class DSLHighlightingConfiguration extends DefaultHighlightingConfiguration {

	/**
	 * The ID for visible comments.
	 */
	public static final String VISIBLE_COMMENT_ID = "visiblecomment";

	/**
	 * The ID for visible title comments.
	 */
	public static final String VISIBLE_TITLE_COMMENT_ID = "visibletitlecomment";

	/**
	 * The ID for IntegrityDoc comments.
	 */
	public static final String DOCUMENTATION_COMMENT_ID = "documentationcomment";

	/**
	 * The ID for visible dividers.
	 */
	public static final String VISIBLE_DIVIDER_ID = "visibledivider";

	/**
	 * The ID for constant, predefined values (like "true" or "false").
	 */
	public static final String CONSTANT_VALUE_ID = "constantvalue";

	/**
	 * The ID for parameters.
	 */
	public static final String PARAMETER_NAME_ID = "parameter";

	/**
	 * The ID for parameters.
	 */
	public static final String RESULT_NAME_ID = "result";

	/**
	 * The ID for package prefixes.
	 */
	public static final String PACKAGE_PREFIX_ID = "package";

	/**
	 * The ID for constant, predefined values (like "true" or "false") used as a test result.
	 */
	public static final String RESULT_CONSTANT_VALUE_ID = "resultconstantvalue";

	/**
	 * The ID for constant, predefined values (like "true" or "false") used as a parameter.
	 */
	public static final String PARAMETER_CONSTANT_VALUE_ID = "parameterconstantvalue";

	/**
	 * The ID for numbers used as a test result.
	 */
	public static final String RESULT_NUMBER_ID = "resultnumber";

	/**
	 * The ID for numbers used as a parameter.
	 */
	public static final String PARAMETER_NUMBER_ID = "parameternumber";

	/**
	 * The ID for strings used as a test result.
	 */
	public static final String RESULT_STRING_ID = "resultstring";

	/**
	 * The ID for strings used as a parameter.
	 */
	public static final String PARAMETER_STRING_ID = "parameterstring";

	/**
	 * The ID for variables used as a test result.
	 */
	public static final String VARIABLE_VALUE_ID = "variablevalue";

	/**
	 * The ID for variables used as a test result.
	 */
	public static final String RESULT_VARIABLE_VALUE_ID = "resultvariablevalue";

	/**
	 * The ID for variables used as a parameter.
	 */
	public static final String PARAMETER_VARIABLE_VALUE_ID = "parametervariablevalue";

	/**
	 * The ID for date/time used as a test result.
	 */
	public static final String RESULT_DATE_TIME_ID = "resultdatetime";

	/**
	 * The ID for date/time used as a parameter.
	 */
	public static final String PARAMETER_DATE_TIME_ID = "parameterdatetime";

	/**
	 * The ID for Java classes.
	 */
	public static final String JAVA_CLASS_ID = "javaclass";

	/**
	 * The ID for Java classes (highlighted parts).
	 */
	public static final String JAVA_CLASS_HIGHLIGHT_ID = "javaclasshighlight";

	/**
	 * The ID for Java method names (highlighted parts).
	 */
	public static final String JAVA_METHOD_HIGHLIGHT_ID = "javamethodhighlight";

	/**
	 * The ID for operations used as a test result.
	 */
	public static final String RESULT_OPERATION_ID = "resultoperation";

	/**
	 * The ID for operations used as a parameter.
	 */
	public static final String PARAMETER_OPERATION_ID = "parameteroperation";

	/**
	 * The ID for the operation identifier used as a result.
	 */
	public static final String RESULT_OPERATION_IDENTIFIER_ID = "resultoperationid";

	/**
	 * The ID for the operation identifier used as a parameter.
	 */
	public static final String PARAMETER_OPERATION_IDENTIFIER_ID = "parameteroperationid";

	/**
	 * The ID for nested objects used as a test result.
	 */
	public static final String RESULT_NESTED_OBJECT_ID = "resultnestedobject";

	/**
	 * The ID for nested objects used as a parameter.
	 */
	public static final String PARAMETER_NESTED_OBJECT_ID = "parameternestedobject";

	/**
	 * The ID for nested object keys used as a test result.
	 */
	public static final String RESULT_NESTED_OBJECT_KEY_ID = "resultnestedobjectkey";

	/**
	 * The ID for nested object keys used as a parameter.
	 */
	public static final String PARAMETER_NESTED_OBJECT_KEY_ID = "parameternestedobjectkey";

	/**
	 * The ID for nested object keys.
	 */
	public static final String NESTED_OBJECT_KEY_ID = "nestedobjectkey";

	/**
	 * Configures highlighting styles for the IDs.
	 */
	public void configure(IHighlightingConfigurationAcceptor anAcceptor) {
		super.configure(anAcceptor);
		anAcceptor.acceptDefaultHighlighting(VISIBLE_COMMENT_ID, "Visible Comments", visibleCommentTextStyle());
		anAcceptor.acceptDefaultHighlighting(VISIBLE_TITLE_COMMENT_ID, "Title Comments",
				visibleTitleCommentTextStyle());
		anAcceptor.acceptDefaultHighlighting(DOCUMENTATION_COMMENT_ID, "Documentation Comments",
				documentationCommentTextStyle());
		anAcceptor.acceptDefaultHighlighting(VISIBLE_DIVIDER_ID, "Visible Divider", visibleDividerTextStyle());
		anAcceptor.acceptDefaultHighlighting(PARAMETER_NAME_ID, "Parameter Name", parameterNameTextStyle());
		anAcceptor.acceptDefaultHighlighting(RESULT_NAME_ID, "Result Name", resultNameTextStyle());
		anAcceptor.acceptDefaultHighlighting(PACKAGE_PREFIX_ID, "Package Prefix", packageTextStyle());
		anAcceptor.acceptDefaultHighlighting(CONSTANT_VALUE_ID, "Constant Values", constantValueTextStyle());
		anAcceptor.acceptDefaultHighlighting(RESULT_CONSTANT_VALUE_ID, "Constant Values (Test Result)",
				resultConstantValueTextStyle());
		anAcceptor.acceptDefaultHighlighting(PARAMETER_CONSTANT_VALUE_ID, "Constant Values (Parameters)",
				parameterConstantValueTextStyle());
		anAcceptor.acceptDefaultHighlighting(VARIABLE_VALUE_ID, "Variable", variableValueTextStyle());
		anAcceptor.acceptDefaultHighlighting(RESULT_VARIABLE_VALUE_ID, "Variables (Test Result)",
				resultVariableValueTextStyle());
		anAcceptor.acceptDefaultHighlighting(PARAMETER_VARIABLE_VALUE_ID, "Variables (Parameters)",
				parameterVariableValueTextStyle());
		anAcceptor.acceptDefaultHighlighting(RESULT_NUMBER_ID, "Numbers (Test Result)", resultNumberTextStyle());
		anAcceptor.acceptDefaultHighlighting(PARAMETER_NUMBER_ID, "Numbers (Parameters)", parameterNumberTextStyle());
		anAcceptor.acceptDefaultHighlighting(RESULT_STRING_ID, "Strings (Test Result)", resultStringTextStyle());
		anAcceptor.acceptDefaultHighlighting(PARAMETER_STRING_ID, "Strings (Parameters)", parameterStringTextStyle());
		anAcceptor.acceptDefaultHighlighting(RESULT_DATE_TIME_ID, "Date/Time (Test Result)", resultDateTimeTextStyle());
		anAcceptor.acceptDefaultHighlighting(PARAMETER_DATE_TIME_ID, "Date/Time (Parameters)",
				parameterDateTimeTextStyle());
		anAcceptor.acceptDefaultHighlighting(RESULT_OPERATION_ID, "Operations (Test Result)",
				resultOperationTextStyle());
		anAcceptor.acceptDefaultHighlighting(PARAMETER_OPERATION_ID, "Operations (Parameters)",
				parameterOperationTextStyle());
		anAcceptor.acceptDefaultHighlighting(RESULT_OPERATION_IDENTIFIER_ID, "Operation Identifier (Test Results)",
				resultOperationIdentifierTextStyle());
		anAcceptor.acceptDefaultHighlighting(PARAMETER_OPERATION_IDENTIFIER_ID, "Operation Identifier (Parameters)",
				parameterOperationIdentifierTextStyle());
		anAcceptor.acceptDefaultHighlighting(RESULT_NESTED_OBJECT_ID, "Nested Objects (Test Result)",
				resultNestedObjectTextStyle());
		anAcceptor.acceptDefaultHighlighting(PARAMETER_NESTED_OBJECT_ID, "Nested Objects (Parameters)",
				parameterNestedObjectTextStyle());
		anAcceptor.acceptDefaultHighlighting(NESTED_OBJECT_KEY_ID, "Nested Object Key", nestedObjectKeyTextStyle());
		anAcceptor.acceptDefaultHighlighting(RESULT_NESTED_OBJECT_KEY_ID, "Nested Object Key (Test Result)",
				resultNestedObjectKeyTextStyle());
		anAcceptor.acceptDefaultHighlighting(PARAMETER_NESTED_OBJECT_KEY_ID, "Nested Object Key (Parameters)",
				parameterNestedObjectKeyTextStyle());
		anAcceptor.acceptDefaultHighlighting(JAVA_CLASS_ID, "Java Classes", javaClassTextStyle());
		anAcceptor.acceptDefaultHighlighting(JAVA_CLASS_HIGHLIGHT_ID, "Java Classes (Highlight Parts)",
				javaClassHighlightTextStyle());
		anAcceptor.acceptDefaultHighlighting(JAVA_METHOD_HIGHLIGHT_ID, "Java Methods (Highlight Parts)",
				javaMethodHighlightTextStyle());
	}

	@Override
	public TextStyle stringTextStyle() {
		TextStyle tempTextStyle = defaultTextStyle().copy();
		tempTextStyle.setColor(new RGB(0, 0, 0));
		return tempTextStyle;
	}

	/**
	 * Creates a text style to use for visible comments.
	 * 
	 * @return the style
	 */
	public TextStyle visibleCommentTextStyle() {
		TextStyle tempTextStyle = defaultTextStyle().copy();
		tempTextStyle.setColor(new RGB(14, 70, 0));
		tempTextStyle.setStyle(tempTextStyle.getStyle() | SWT.ITALIC | SWT.BOLD);
		return tempTextStyle;
	}

	/**
	 * Creates a text style to use for visible title comments.
	 * 
	 * @return the style
	 */
	public TextStyle visibleTitleCommentTextStyle() {
		TextStyle tempTextStyle = defaultTextStyle().copy();
		tempTextStyle.setColor(new RGB(14, 70, 0));
		int tempUnderlineStyle = (1 << 30); // This constant is not present in the SWT class.
		tempTextStyle.setStyle(tempTextStyle.getStyle() | SWT.ITALIC | SWT.BOLD | tempUnderlineStyle);
		return tempTextStyle;
	}

	/**
	 * Creates a text style to use for documentation comments.
	 * 
	 * @return the style
	 */
	public TextStyle documentationCommentTextStyle() {
		TextStyle tempTextStyle = defaultTextStyle().copy();
		tempTextStyle.setColor(new RGB(75, 97, 189));
		return tempTextStyle;
	}

	/**
	 * Creates a text style to use for visible dividers.
	 * 
	 * @return the style
	 */
	public TextStyle visibleDividerTextStyle() {
		TextStyle tempTextStyle = defaultTextStyle().copy();
		tempTextStyle.setColor(new RGB(14, 70, 0));
		tempTextStyle.setStyle(tempTextStyle.getStyle() | SWT.BOLD);
		return tempTextStyle;
	}

	/**
	 * Creates a text style to use for parameters.
	 * 
	 * @return the style
	 */
	public TextStyle parameterNameTextStyle() {
		TextStyle tempTextStyle = defaultTextStyle().copy();
		tempTextStyle.setColor(new RGB(150, 0, 0));
		tempTextStyle.setStyle(tempTextStyle.getStyle() | SWT.BOLD);
		return tempTextStyle;
	}

	/**
	 * Creates a text style to use for parameters.
	 * 
	 * @return the style
	 */
	public TextStyle resultNameTextStyle() {
		TextStyle tempTextStyle = defaultTextStyle().copy();
		tempTextStyle.setColor(new RGB(42, 0, 255));
		tempTextStyle.setStyle(tempTextStyle.getStyle() | SWT.BOLD);
		return tempTextStyle;
	}

	/**
	 * Creates a text style to use for packages.
	 * 
	 * @return the style
	 */
	public TextStyle packageTextStyle() {
		TextStyle tempTextStyle = defaultTextStyle().copy();
		tempTextStyle.setColor(new RGB(128, 128, 128));
		tempTextStyle.setStyle(tempTextStyle.getStyle());
		return tempTextStyle;
	}

	// 42,0,255

	@Override
	public TextStyle numberTextStyle() {
		TextStyle tempTextStyle = defaultTextStyle().copy();
		tempTextStyle.setColor(new RGB(0, 0, 0));
		return tempTextStyle;
	}

	/**
	 * Creates a text style to use for numbers used as test results.
	 * 
	 * @return
	 */
	public TextStyle resultNumberTextStyle() {
		TextStyle tempTextStyle = defaultTextStyle().copy();
		tempTextStyle.setColor(new RGB(42, 0, 255));
		return tempTextStyle;
	}

	/**
	 * Creates a text style to use for numbers used as test or call parameters.
	 * 
	 * @return
	 */
	public TextStyle parameterNumberTextStyle() {
		TextStyle tempTextStyle = defaultTextStyle().copy();
		tempTextStyle.setColor(new RGB(150, 0, 0));
		return tempTextStyle;
	}

	/**
	 * Creates a text style to use for strings used as test results.
	 * 
	 * @return
	 */
	public TextStyle resultStringTextStyle() {
		TextStyle tempTextStyle = defaultTextStyle().copy();
		tempTextStyle.setColor(new RGB(42, 0, 255));
		return tempTextStyle;
	}

	/**
	 * Creates a text style to use for strings used as parameters.
	 * 
	 * @return
	 */
	public TextStyle parameterStringTextStyle() {
		TextStyle tempTextStyle = defaultTextStyle().copy();
		tempTextStyle.setColor(new RGB(150, 0, 0));
		return tempTextStyle;
	}

	/**
	 * Creates a text style to use for strings used as test results.
	 * 
	 * @return
	 */
	public TextStyle resultDateTimeTextStyle() {
		TextStyle tempTextStyle = defaultTextStyle().copy();
		tempTextStyle.setColor(new RGB(42, 0, 255));
		return tempTextStyle;
	}

	/**
	 * Creates a text style to use for strings used as parameters.
	 * 
	 * @return
	 */
	public TextStyle parameterDateTimeTextStyle() {
		TextStyle tempTextStyle = defaultTextStyle().copy();
		tempTextStyle.setColor(new RGB(150, 0, 0));
		return tempTextStyle;
	}

	/**
	 * Creates a text style to use for constant values.
	 * 
	 * @return
	 */
	public TextStyle constantValueTextStyle() {
		TextStyle tempTextStyle = defaultTextStyle().copy();
		tempTextStyle.setColor(new RGB(0, 0, 0));
		return tempTextStyle;
	}

	/**
	 * Creates a text style to use for constant values used as test results.
	 * 
	 * @return
	 */
	public TextStyle resultConstantValueTextStyle() {
		TextStyle tempTextStyle = defaultTextStyle().copy();
		tempTextStyle.setColor(new RGB(42, 0, 255));
		return tempTextStyle;
	}

	/**
	 * Creates a text style to use for constant values used as parameters.
	 * 
	 * @return
	 */
	public TextStyle parameterConstantValueTextStyle() {
		TextStyle tempTextStyle = defaultTextStyle().copy();
		tempTextStyle.setColor(new RGB(150, 0, 0));
		tempTextStyle.setStyle(tempTextStyle.getStyle() | SWT.BOLD);
		return tempTextStyle;
	}

	/**
	 * Creates a text style to use for variable values.
	 * 
	 * @return
	 */
	public TextStyle variableValueTextStyle() {
		TextStyle tempTextStyle = defaultTextStyle().copy();
		tempTextStyle.setColor(new RGB(0, 0, 0));
		return tempTextStyle;
	}

	/**
	 * Creates a text style to use for variables used as test results.
	 * 
	 * @return
	 */
	public TextStyle resultVariableValueTextStyle() {
		TextStyle tempTextStyle = defaultTextStyle().copy();
		tempTextStyle.setColor(new RGB(42, 0, 255));
		return tempTextStyle;
	}

	/**
	 * Creates a text style to use for variables used as parameters.
	 * 
	 * @return
	 */
	public TextStyle parameterVariableValueTextStyle() {
		TextStyle tempTextStyle = defaultTextStyle().copy();
		tempTextStyle.setColor(new RGB(150, 0, 0));
		return tempTextStyle;
	}

	/**
	 * Creates a text style used for Java classes.
	 * 
	 * @return
	 */
	public TextStyle javaClassTextStyle() {
		TextStyle tempTextStyle = defaultTextStyle().copy();
		tempTextStyle.setColor(new RGB(128, 64, 0));
		return tempTextStyle;
	}

	/**
	 * Creates a text style used for Java classes (highlighted parts).
	 * 
	 * @return
	 */
	public TextStyle javaClassHighlightTextStyle() {
		TextStyle tempTextStyle = defaultTextStyle().copy();
		tempTextStyle.setColor(new RGB(128, 64, 0));
		tempTextStyle.setStyle(tempTextStyle.getStyle() | SWT.BOLD);
		return tempTextStyle;
	}

	/**
	 * Creates a text style used for Java classes (highlighted parts).
	 * 
	 * @return
	 */
	public TextStyle javaMethodHighlightTextStyle() {
		TextStyle tempTextStyle = defaultTextStyle().copy();
		tempTextStyle.setColor(new RGB(128, 64, 0));
		tempTextStyle.setStyle(tempTextStyle.getStyle() | SWT.BOLD | SWT.ITALIC);
		return tempTextStyle;
	}

	/**
	 * Creates a text style to use for operations used as test results.
	 * 
	 * @return
	 */
	public TextStyle resultOperationTextStyle() {
		TextStyle tempTextStyle = defaultTextStyle().copy();
		tempTextStyle.setColor(new RGB(42, 0, 255));
		return tempTextStyle;
	}

	/**
	 * Creates a text style to use for operations used as parameters.
	 * 
	 * @return
	 */
	public TextStyle parameterOperationTextStyle() {
		TextStyle tempTextStyle = defaultTextStyle().copy();
		tempTextStyle.setColor(new RGB(150, 0, 0));
		return tempTextStyle;
	}

	/**
	 * Creates a text style to use for operation identifiers used as test results.
	 * 
	 * @return
	 */
	public TextStyle resultOperationIdentifierTextStyle() {
		TextStyle tempTextStyle = defaultTextStyle().copy();
		tempTextStyle.setColor(new RGB(42, 0, 255));
		tempTextStyle.setStyle(tempTextStyle.getStyle() | SWT.BOLD);
		return tempTextStyle;
	}

	/**
	 * Creates a text style to use for operation identifiers used as parameters.
	 * 
	 * @return
	 */
	public TextStyle parameterOperationIdentifierTextStyle() {
		TextStyle tempTextStyle = defaultTextStyle().copy();
		tempTextStyle.setColor(new RGB(150, 0, 0));
		tempTextStyle.setStyle(tempTextStyle.getStyle() | SWT.BOLD);
		return tempTextStyle;
	}

	/**
	 * Creates a text style to use for nested objects used as test results.
	 * 
	 * @return
	 */
	public TextStyle resultNestedObjectTextStyle() {
		TextStyle tempTextStyle = defaultTextStyle().copy();
		tempTextStyle.setColor(new RGB(42, 0, 255));
		return tempTextStyle;
	}

	/**
	 * Creates a text style to use for nested objects used as parameters.
	 * 
	 * @return
	 */
	public TextStyle parameterNestedObjectTextStyle() {
		TextStyle tempTextStyle = defaultTextStyle().copy();
		tempTextStyle.setColor(new RGB(150, 0, 0));
		return tempTextStyle;
	}

	/**
	 * Creates a text style to use for nested objects used as test results.
	 * 
	 * @return
	 */
	public TextStyle resultNestedObjectKeyTextStyle() {
		TextStyle tempTextStyle = defaultTextStyle().copy();
		tempTextStyle.setColor(new RGB(42, 0, 255));
		tempTextStyle.setStyle(tempTextStyle.getStyle() | SWT.BOLD);
		return tempTextStyle;
	}

	/**
	 * Creates a text style to use for nested objects used as parameters.
	 * 
	 * @return
	 */
	public TextStyle parameterNestedObjectKeyTextStyle() {
		TextStyle tempTextStyle = defaultTextStyle().copy();
		tempTextStyle.setColor(new RGB(150, 0, 0));
		tempTextStyle.setStyle(tempTextStyle.getStyle() | SWT.BOLD);
		return tempTextStyle;
	}

	/**
	 * Creates a text style to use for nested objects used neither as parameter nor result.
	 * 
	 * @return
	 */
	public TextStyle nestedObjectKeyTextStyle() {
		TextStyle tempTextStyle = defaultTextStyle().copy();
		tempTextStyle.setColor(new RGB(0, 0, 0));
		tempTextStyle.setStyle(tempTextStyle.getStyle() | SWT.BOLD);
		return tempTextStyle;
	}
}

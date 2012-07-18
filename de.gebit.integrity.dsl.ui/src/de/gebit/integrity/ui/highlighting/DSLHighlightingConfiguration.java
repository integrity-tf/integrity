/**
 * 
 */
package de.gebit.integrity.ui.highlighting;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfigurationAcceptor;
import org.eclipse.xtext.ui.editor.utils.TextStyle;

/**
 * Custom highlighting configuration.
 * 
 * @author Rene Schneider
 * 
 */
public class DSLHighlightingConfiguration extends DefaultHighlightingConfiguration {

	/**
	 * The ID for visible comments.
	 */
	public static final String VISIBLE_COMMENT_ID = "visiblecomment";

	/**
	 * The ID for constant, predefined values (like "true" or "false").
	 */
	public static final String CONSTANT_VALUE_ID = "constantvalue";

	/**
	 * The ID for parameters.
	 */
	public static final String PARAMETER_ID = "parameter";

	/**
	 * The ID for package prefixes.
	 */
	public static final String PACKAGE_PREFIX_ID = "package";

	/**
	 * The ID for constant, predefined values (like "true" or "false") used as a test result.
	 */
	public static final String RESULT_CONSTANT_VALUE_ID = "resultconstantvalue";

	/**
	 * The ID for numbers used as a test result.
	 */
	public static final String RESULT_NUMBER_ID = "resultnumber";

	/**
	 * The ID for strings used as a test result.
	 */
	public static final String RESULT_STRING_ID = "resultstring";

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
	 * Configures highlighting styles for the IDs.
	 */
	public void configure(IHighlightingConfigurationAcceptor anAcceptor) {
		super.configure(anAcceptor);
		anAcceptor.acceptDefaultHighlighting(VISIBLE_COMMENT_ID, "Visible Comment", visibleCommentTextStyle());
		anAcceptor.acceptDefaultHighlighting(PARAMETER_ID, "Parameter", parameterTextStyle());
		anAcceptor.acceptDefaultHighlighting(PACKAGE_PREFIX_ID, "Package Prefix", packageTextStyle());
		anAcceptor.acceptDefaultHighlighting(CONSTANT_VALUE_ID, "Constant Values", constantValueTextStyle());
		anAcceptor.acceptDefaultHighlighting(RESULT_CONSTANT_VALUE_ID, "Constant Values (Test Result)",
				resultConstantValueTextStyle());
		anAcceptor.acceptDefaultHighlighting(RESULT_NUMBER_ID, "Numbers (Test Result)", resultNumberTextStyle());
		anAcceptor.acceptDefaultHighlighting(RESULT_STRING_ID, "Strings (Test Result)", resultStringTextStyle());
		anAcceptor.acceptDefaultHighlighting(JAVA_CLASS_ID, "Java Classes", javaClassTextStyle());
		anAcceptor.acceptDefaultHighlighting(JAVA_CLASS_HIGHLIGHT_ID, "Java Classes (Highlight Parts)",
				javaClassHighlightTextStyle());
		anAcceptor.acceptDefaultHighlighting(JAVA_METHOD_HIGHLIGHT_ID, "Java Methods (Highlight Parts)",
				javaMethodHighlightTextStyle());
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
	 * Creates a text style to use for parameters.
	 * 
	 * @return the style
	 */
	public TextStyle parameterTextStyle() {
		TextStyle tempTextStyle = defaultTextStyle().copy();
		tempTextStyle.setColor(new RGB(150, 0, 0));
		tempTextStyle.setStyle(tempTextStyle.getStyle());
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

	@Override
	public TextStyle numberTextStyle() {
		TextStyle tempTextStyle = defaultTextStyle().copy();
		tempTextStyle.setColor(new RGB(42, 0, 255));
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
		tempTextStyle.setStyle(tempTextStyle.getStyle() | SWT.BOLD);
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
		tempTextStyle.setStyle(tempTextStyle.getStyle() | SWT.BOLD);
		return tempTextStyle;
	}

	/**
	 * Creates a text style to use for constant values.
	 * 
	 * @return
	 */
	public TextStyle constantValueTextStyle() {
		TextStyle tempTextStyle = defaultTextStyle().copy();
		tempTextStyle.setColor(new RGB(42, 0, 255));
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
		tempTextStyle.setStyle(tempTextStyle.getStyle() | SWT.BOLD);
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
}

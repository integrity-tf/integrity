/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.runner.callbacks.xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xml.type.internal.DataValue.Base64;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.util.Pair;
import org.jdom.Attribute;
import org.jdom.CDATA;
import org.jdom.Content;
import org.jdom.DocType;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.IllegalDataException;
import org.jdom.JDOMException;
import org.jdom.ProcessingInstruction;
import org.jdom.Text;
import org.jdom.Verifier;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.jdom.transform.JDOMSource;

import com.google.inject.Inject;

import de.gebit.integrity.dsl.Call;
import de.gebit.integrity.dsl.ConstantEntity;
import de.gebit.integrity.dsl.ForkDefinition;
import de.gebit.integrity.dsl.MethodReference;
import de.gebit.integrity.dsl.Suite;
import de.gebit.integrity.dsl.SuiteDefinition;
import de.gebit.integrity.dsl.SuiteReturn;
import de.gebit.integrity.dsl.SuiteStatement;
import de.gebit.integrity.dsl.SuiteStatementWithResult;
import de.gebit.integrity.dsl.TableTest;
import de.gebit.integrity.dsl.TableTestRow;
import de.gebit.integrity.dsl.Test;
import de.gebit.integrity.dsl.TimeSet;
import de.gebit.integrity.dsl.ValueOrEnumValueOrOperationCollection;
import de.gebit.integrity.dsl.VariableAssignment;
import de.gebit.integrity.dsl.VariableEntity;
import de.gebit.integrity.dsl.VariableOrConstantEntity;
import de.gebit.integrity.dsl.VariantDefinition;
import de.gebit.integrity.dsl.VisibleComment;
import de.gebit.integrity.dsl.VisibleDivider;
import de.gebit.integrity.dsl.VisibleMultiLineTitleComment;
import de.gebit.integrity.dsl.VisibleSingleLineTitleComment;
import de.gebit.integrity.exceptions.MethodNotFoundException;
import de.gebit.integrity.fixtures.ExtendedResultFixture.ExtendedResult;
import de.gebit.integrity.fixtures.ExtendedResultFixture.ExtendedResultHTML;
import de.gebit.integrity.fixtures.ExtendedResultFixture.ExtendedResultImage;
import de.gebit.integrity.fixtures.ExtendedResultFixture.ExtendedResultText;
import de.gebit.integrity.operations.UnexecutableException;
import de.gebit.integrity.parameter.conversion.ConversionContext;
import de.gebit.integrity.parameter.conversion.UnresolvableVariable;
import de.gebit.integrity.parameter.conversion.UnresolvableVariableHandling;
import de.gebit.integrity.parameter.resolving.ParameterResolver;
import de.gebit.integrity.parameter.resolving.TableTestParameterResolveMethod;
import de.gebit.integrity.parameter.variables.VariableManager;
import de.gebit.integrity.remoting.transport.enums.TestRunnerCallbackMethods;
import de.gebit.integrity.runner.IntegrityRunnerModule;
import de.gebit.integrity.runner.TestModel;
import de.gebit.integrity.runner.callbacks.AbstractTestRunnerCallback;
import de.gebit.integrity.runner.callbacks.SuiteSkipReason;
import de.gebit.integrity.runner.callbacks.TestFormatter;
import de.gebit.integrity.runner.console.intercept.ConsoleInterceptionAggregator;
import de.gebit.integrity.runner.console.intercept.Intercept;
import de.gebit.integrity.runner.console.intercept.InterceptedLine;
import de.gebit.integrity.runner.results.SuiteResult;
import de.gebit.integrity.runner.results.SuiteSummaryResult;
import de.gebit.integrity.runner.results.call.CallResult;
import de.gebit.integrity.runner.results.call.CallResult.UpdatedVariable;
import de.gebit.integrity.runner.results.test.TestComparisonFailureResult;
import de.gebit.integrity.runner.results.test.TestComparisonResult;
import de.gebit.integrity.runner.results.test.TestComparisonSuccessResult;
import de.gebit.integrity.runner.results.test.TestExceptionSubResult;
import de.gebit.integrity.runner.results.test.TestExecutedSubResult;
import de.gebit.integrity.runner.results.test.TestResult;
import de.gebit.integrity.runner.results.test.TestSubResult;
import de.gebit.integrity.utils.DateUtil;
import de.gebit.integrity.utils.IntegrityDSLUtil;
import de.gebit.integrity.utils.VersionUtil;

/**
 * Test runner callback which writes to an XML result file. This runner may optionally add an XHTML transform to the
 * file which allows to render the results in a nice, readable layout in any good browser.
 * 
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class XmlWriterTestCallback extends AbstractTestRunnerCallback {

	/**
	 * The XML document that will be created.
	 */
	protected Document document;

	/**
	 * The file in which to serialize the document.
	 */
	protected File outputFile;

	/**
	 * The title of the result document.
	 */
	protected String title;

	/**
	 * The timestamp of execution start.
	 */
	protected long executionStartTime;

	/**
	 * Counter used to generate unique IDs for a lot of XML elements.
	 */
	protected long idCounter;

	/**
	 * How the XML -> XHTML transform shall be handled.
	 */
	protected TransformHandling transformHandling;

	/**
	 * Whether the next title comment is to be treated as a suite title.
	 */
	protected boolean nextTitleCommentIsSuiteTitle;

	/**
	 * The classloader to use.
	 */
	@Inject
	protected ClassLoader classLoader;

	/**
	 * The parameter resolver to use.
	 */
	@Inject
	protected ParameterResolver parameterResolver;

	/**
	 * The variable manager to use.
	 */
	@Inject
	protected VariableManager variableManager;

	/**
	 * The test formatter to use.
	 */
	@Inject
	protected TestFormatter testFormatter;

	/**
	 * The interception service used to intercept console output.
	 */
	@Inject
	protected ConsoleInterceptionAggregator consoleInterceptor;

	/**
	 * Whether console output shall be captured.
	 */
	protected boolean captureConsoleOutput;

	/**
	 * The stack of elements.
	 */
	protected Stack<Element> currentElement = new Stack<Element>();

	/**
	 * In case of an abortion, the message is stored here to be used later.
	 */
	protected String abortMessage;

	/**
	 * This flag stores the information whether the root suite (= first suite we enter) has already been entered.
	 */
	protected boolean rootSuiteWasStarted;

	/**
	 * This prefix is used to mark temporary attributes (these are to be stripped before elements are serialized for the
	 * final result).
	 */
	protected static final String TEMPORARY_ATTRIBUTE_PREFIX = "TEMP_";

	/** The Constant ROOT_ELEMENT. */
	protected static final String ROOT_ELEMENT = "integrity";

	/** The Constant TEST_RUN_NAME_ATTRIBUTE. */
	protected static final String TEST_RUN_NAME_ATTRIBUTE = "name";

	/** The Constant TEST_RUN_TIMESTAMP. */
	protected static final String TEST_RUN_TIMESTAMP = "timestamp";

	/** The Constant TEST_RUN_TIMESTAMP_ISO8601. */
	protected static final String TEST_RUN_TIMESTAMP_ISO8601 = "isotimestamp";

	/** The Constant TEST_RUN_DURATION. */
	protected static final String TEST_RUN_DURATION = "duration";

	/** The Constant TEST_RUN_ABORT_MESSAGE_ATTRIBUTE. */
	protected static final String TEST_RUN_ABORT_MESSAGE_ATTRIBUTE = "abortMessage";

	/** The Constant VARIANT_ELEMENT. */
	protected static final String VARIANT_ELEMENT = "variant";

	/** The Constant VARIANT_NAME_ATTRIBUTE. */
	protected static final String VARIANT_NAME_ATTRIBUTE = "name";

	/** The Constant VARIANT_DESCRIPTION_ATTRIBUTE. */
	protected static final String VARIANT_DESCRIPTION_ATTRIBUTE = "description";

	/** The Constant SUITE_ELEMENT. */
	protected static final String SUITE_ELEMENT = "suite";

	/** The Constant SUITE_NAME_ATTRIBUTE. */
	protected static final String SUITE_NAME_ATTRIBUTE = "name";

	/** The Constant SUITE_TITLE_ATTRIBUTE. */
	protected static final String SUITE_TITLE_ATTRIBUTE = "title";

	/** The Constant SUITE_DISPLAY_ATTRIBUTE. */
	protected static final String SUITE_DISPLAY_ATTRIBUTE = "display";

	/** The Constant SUITE_DISPLAY_VALUE_INLINE. */
	protected static final String SUITE_DISPLAY_VALUE_INLINE = "inline";

	/** The Constant VARIABLE_DEFINITION_COLLECTION_ELEMENT. */
	protected static final String VARIABLE_DEFINITION_COLLECTION_ELEMENT = "variables";

	/** The Constant RETURN_VARIABLE_ASSIGNMENT_COLLECTION_ELEMENT. */
	protected static final String RETURN_VARIABLE_ASSIGNMENT_COLLECTION_ELEMENT = "returns";

	/** The Constant STATEMENT_COLLECTION_ELEMENT. */
	protected static final String STATEMENT_COLLECTION_ELEMENT = "statements";

	/** The Constant SETUP_COLLECTION_ELEMENT. */
	protected static final String SETUP_COLLECTION_ELEMENT = "setup";

	/** The Constant TEARDOWN_COLLECTION_ELEMENT. */
	protected static final String TEARDOWN_COLLECTION_ELEMENT = "teardown";

	/** The Constant TEST_ELEMENT. */
	protected static final String TEST_ELEMENT = "test";

	/** The Constant TABLETEST_ELEMENT. */
	protected static final String TABLETEST_ELEMENT = "tabletest";

	/** The Constant CALL_ELEMENT. */
	protected static final String CALL_ELEMENT = "call";

	/** The Constant RESULT_ELEMENT. */
	protected static final String RESULT_ELEMENT = "result";

	/** The Constant RESULT_COLLECTION_ELEMENT. */
	protected static final String RESULT_COLLECTION_ELEMENT = "results";

	/** The Constant EXTENDED_RESULT_ELEMENT_TYPE_ATTRIBUTE. */
	protected static final String EXTENDED_RESULT_ELEMENT_TITLE_ATTRIBUTE = "title";

	/** The Constant EXTENDED_RESULT_TEXT_ELEMENT. */
	protected static final String EXTENDED_RESULT_TEXT_ELEMENT = "extResultText";

	/** The Constant EXTENDED_RESULT_IMAGE_ELEMENT. */
	protected static final String EXTENDED_RESULT_IMAGE_ELEMENT = "extResultImage";

	/** The Constant EXTENDED_RESULT_HTML_ELEMENT. */
	protected static final String EXTENDED_RESULT_HTML_ELEMENT = "extResultHTML";

	/** The Constant EXTENDED_RESULT_IMAGE_ELEMENT_TYPE_ATTRIBUTE. */
	protected static final String EXTENDED_RESULT_IMAGE_ELEMENT_TYPE_ATTRIBUTE = "type";

	/** The Constant EXTENDED_RESULT_IMAGE_ELEMENT_WIDTH_ATTRIBUTE. */
	protected static final String EXTENDED_RESULT_IMAGE_ELEMENT_WIDTH_ATTRIBUTE = "width";

	/** The Constant EXTENDED_RESULT_IMAGE_ELEMENT_HEIGHT_ATTRIBUTE. */
	protected static final String EXTENDED_RESULT_IMAGE_ELEMENT_HEIGHT_ATTRIBUTE = "height";

	/** The Constant EXTENDED_RESULT_COLLECTION_ELEMENT. */
	protected static final String EXTENDED_RESULT_COLLECTION_ELEMENT = "extResults";

	/** The Constant VARIABLE_UPDATE_ELEMENT. */
	protected static final String VARIABLE_UPDATE_ELEMENT = "variableUpdate";

	/** The Constant VARIABLE_UPDATE_PARAMETER_NAME_ATTRIBUTE. */
	protected static final String VARIABLE_UPDATE_PARAMETER_NAME_ATTRIBUTE = "parameter";

	/** The Constant COMPARISON_ELEMENT. */
	protected static final String COMPARISON_ELEMENT = "comparison";

	/** The Constant COMPARISON_COLLECTION_ELEMENT. */
	protected static final String COMPARISON_COLLECTION_ELEMENT = "comparisons";

	/** The Constant COMPARISON_NAME_ATTRIBUTE. */
	protected static final String COMPARISON_NAME_ATTRIBUTE = "name";

	/** The Constant VARIABLE_NAME_ATTRIBUTE. */
	protected static final String VARIABLE_NAME_ATTRIBUTE = "name";

	/** The Constant VARIABLE_NAME_ATTRIBUTE. */
	protected static final String VARIABLE_TARGET_ATTRIBUTE = "target";

	/** The Constant VARIABLE_ELEMENT. */
	protected static final String VARIABLE_ELEMENT = "variable";

	/** The Constant VARIABLE_ASSIGNMENT_ELEMENT. */
	protected static final String VARIABLE_ASSIGNMENT_ELEMENT = "variableAssign";

	/** The Constant TIME_SET_ELEMENT. */
	protected static final String TIME_SET_ELEMENT = "timeSet";

	/** The Constant TIME_SET_TIMES_COLLECTION_ELEMENT. */
	protected static final String TIME_SET_TIMES_COLLECTION_ELEMENT = "times";

	/** The Constant TIME_SET_TIMES_ELEMENT. */
	protected static final String TIME_SET_TIMES_ELEMENT = "time";

	/** The Constant TIME_SET_TIMES_ELEMENT_FORK_ATTRIBUTE. */
	protected static final String TIME_SET_TIMES_ELEMENT_FORK_ATTRIBUTE = "fork";

	/** The Constant TIME_START_ATTRIBUTE. */
	protected static final String TIME_START_ATTRIBUTE = "time";

	/** The Constant TIME_PROGRESSION_FACTOR_ATTRIBUTE. */
	protected static final String TIME_PROGRESSION_FACTOR_ATTRIBUTE = "progressionFactor";

	/** The Constant TIME_FORK_ATTRIBUTE. */
	protected static final String TIME_FORK_ATTRIBUTE = "forks";

	/** The Constant TIME_TEXT_ATTRIBUTE. */
	protected static final String TIME_TEXT_ATTRIBUTE = "text";

	/** The Constant COMMENT_ELEMENT. */
	protected static final String COMMENT_ELEMENT = "comment";

	/** The Constant COMMENT_TEXT_ATTRIBUTE. */
	protected static final String COMMENT_TEXT_ATTRIBUTE = "text";

	/** The Constant COMMENT_TYPE_ATTRIBUTE. */
	protected static final String COMMENT_TYPE_ATTRIBUTE = "type";

	/** The Constant COMMENT_TYPE_SUITETITLE. */
	protected static final String COMMENT_TYPE_SUITETITLE = "suitetitle";

	/** The Constant COMMENT_TYPE_TITLE. */
	protected static final String COMMENT_TYPE_TITLE = "title";

	/** The Constant DIVIDER_ELEMENT. */
	protected static final String DIVIDER_ELEMENT = "divider";

	/** The Constant DIVIDER_TEXT_ATTRIBUTE. */
	protected static final String DIVIDER_TEXT_ATTRIBUTE = "text";

	/** The Constant PARAMETER_COLLECTION_ELEMENT. */
	protected static final String PARAMETER_COLLECTION_ELEMENT = "parameters";

	/** The Constant PARAMETER_ELEMENT. */
	protected static final String PARAMETER_ELEMENT = "parameter";

	/** The Constant PARAMETER_NAME_ATTRIBUTE. */
	protected static final String PARAMETER_NAME_ATTRIBUTE = "name";

	/** The Constant PARAMETER_VALUE_ATTRIBUTE. */
	protected static final String PARAMETER_VALUE_ATTRIBUTE = "value";

	/** The Constant VARIABLE_VALUE_ATTRIBUTE. */
	protected static final String VARIABLE_VALUE_ATTRIBUTE = "value";

	/** The Constant RESULT_EXPECTED_VALUE_ATTRIBUTE. */
	protected static final String RESULT_EXPECTED_VALUE_ATTRIBUTE = "expectedValue";

	/** The Constant RESULT_REAL_VALUE_ATTRIBUTE. */
	protected static final String RESULT_REAL_VALUE_ATTRIBUTE = "value";

	/** The Constant RESULT_TYPE_ATTRIBUTE. */
	protected static final String RESULT_TYPE_ATTRIBUTE = "type";

	/** The Constant RESULT_TYPE_SUCCESS. */
	protected static final String RESULT_TYPE_SUCCESS = "success";

	/** The Constant RESULT_TYPE_FAILURE. */
	protected static final String RESULT_TYPE_FAILURE = "failure";

	/** The Constant RESULT_TYPE_EXCEPTION. */
	protected static final String RESULT_TYPE_EXCEPTION = "exception";

	/** The Constant RESULT_EXCEPTION_MESSAGE_ATTRIBUTE. */
	protected static final String RESULT_EXCEPTION_MESSAGE_ATTRIBUTE = "exceptionMessage";

	/** The Constant RESULT_EXCEPTION_TRACE_ATTRIBUTE. */
	protected static final String RESULT_EXCEPTION_TRACE_ATTRIBUTE = "exceptionTrace";

	/** The Constant EXECUTION_DURATION_ATTRIBUTE. */
	protected static final String EXECUTION_DURATION_ATTRIBUTE = "duration";

	/** The Constant SUCCESS_COUNT_ATTRIBUTE. */
	protected static final String SUCCESS_COUNT_ATTRIBUTE = "successCount";

	/** The Constant FAILURE_COUNT_ATTRIBUTE. */
	protected static final String FAILURE_COUNT_ATTRIBUTE = "failureCount";

	/** The Constant EXCEPTION_COUNT_ATTRIBUTE. */
	protected static final String EXCEPTION_COUNT_ATTRIBUTE = "exceptionCount";

	/** The Constant TEST_EXCEPTION_COUNT_ATTRIBUTE. */
	protected static final String TEST_EXCEPTION_COUNT_ATTRIBUTE = "testExceptionCount";

	/** The Constant CALL_EXCEPTION_COUNT_ATTRIBUTE. */
	protected static final String CALL_EXCEPTION_COUNT_ATTRIBUTE = "callExceptionCount";

	/** The Constant FIXTURE_DESCRIPTION_ATTRIBUTE. */
	protected static final String FIXTURE_DESCRIPTION_ATTRIBUTE = "description";

	/** The Constant TEST_NAME_ELEMENT. */
	protected static final String TEST_NAME_ELEMENT = "name";

	/** The Constant CALL_NAME_ELEMENT. */
	protected static final String CALL_NAME_ELEMENT = "name";

	/** The Constant FIXTURE_METHOD_ATTRIBUTE. */
	protected static final String FIXTURE_METHOD_ATTRIBUTE = "fixture";

	/** The Constant FORK_NAME_ATTRIBUTE. */
	protected static final String FORK_NAME_ATTRIBUTE = "forkName";

	/** The Constant FORK_DESCRIPTION_ATTRIBUTE. */
	protected static final String FORK_DESCRIPTION_ATTRIBUTE = "forkDescription";

	/** The Constant ID_ATTRIBUTE. */
	protected static final String ID_ATTRIBUTE = "id";

	/** The constant LINE_NUMBER_ATTRIBUTE. */
	protected static final String LINE_NUMBER_ATTRIBUTE = "line";

	/** The constant VERSION_ATTRIBUTE. */
	protected static final String VERSION_ATTRIBUTE = "version";

	/** The Constant CONSOLE_ELEMENT. */
	protected static final String CONSOLE_ELEMENT = "console";

	/** The Constant CONSOLE_LINECOUNT_ATTRIBUTE. */
	protected static final String CONSOLE_LINECOUNT_ATTRIBUTE = "lines";

	/** The Constant CONSOLE_TRUNCATED_ATTRIBUTE. */
	protected static final String CONSOLE_TRUNCATED_ATTRIBUTE = "truncated";

	/** The Constant CONSOLE_TEMP_STARTTIME_ATTRIBUTE. */
	protected static final String CONSOLE_TEMP_STARTTIME_ATTRIBUTE = TEMPORARY_ATTRIBUTE_PREFIX + "starttime";

	/** The Constant CONSOLE_TEMP_ENDTIME_ATTRIBUTE. */
	protected static final String CONSOLE_TEMP_ENDTIME_ATTRIBUTE = TEMPORARY_ATTRIBUTE_PREFIX + "endtime";

	/** The Constant CONSOLE_LINE_STDOUT_ELEMENT. */
	protected static final String CONSOLE_LINE_STDOUT_ELEMENT = "out";

	/** The Constant CONSOLE_LINE_STDERR_ELEMENT. */
	protected static final String CONSOLE_LINE_STDERR_ELEMENT = "err";

	/** The Constant CONSOLE_LINE_TEXT_ATTRIBUTE. */
	protected static final String CONSOLE_LINE_TEXT_ATTRIBUTE = "text";

	/** The Constant CONSOLE_LINE_TEMP_TIME_ATTRIBUTE. */
	protected static final String CONSOLE_LINE_TEMP_TIME_ATTRIBUTE = TEMPORARY_ATTRIBUTE_PREFIX + "time";

	/** The Constant CONSOLE_LINE_SOURCE_ATTRIBUTE. */
	protected static final String CONSOLE_LINE_SOURCE_ATTRIBUTE = "source";

	/**
	 * Maximum number of lines of console output that is added to a single test/call.
	 */
	protected static final int MAX_CONSOLE_LINES = 10000;

	/**
	 * Maximum size of a single console line.
	 */
	protected static final int MAX_CONSOLE_LINE_SIZE = 1000;

	/**
	 * Default stack size for the XSLT transform thread.
	 */
	protected static final int TRANSFORM_THREAD_STACK_SIZE_DEFAULT = 10 * 1024 * 1024;

	/**
	 * System property name for overriding transform thread stack size.
	 */
	protected static final String SYSPARAM_TRANSFORM_THREAD_STACK_SIZE = "integrity.xmlwriter.transform.stacksize";

	/**
	 * The time format used to format execution times.
	 */
	protected static final DecimalFormat EXECUTION_TIME_FORMAT = new DecimalFormat("0.000");

	/**
	 * The generally used date format (coarse-grained date/time).
	 */
	protected static final DateFormat DATE_FORMAT = new SimpleDateFormat();

	/**
	 * The generally used timestamp format (fine-grained date/time).
	 */
	protected static final DateFormat TIMESTAMP_FORMAT = DateFormat.getDateTimeInstance(DateFormat.SHORT,
			DateFormat.MEDIUM);

	static {
		if (TIMESTAMP_FORMAT instanceof SimpleDateFormat) {
			// This allows the use of the default, locale-specific date formats, but with integration of millisecond
			// precision. This little hack wouldn't be necessary if Java would allow to specify that I want milliseconds
			// to be added when retrieving the date format in the first place.
			SimpleDateFormat tempTimestampFormat = (SimpleDateFormat) TIMESTAMP_FORMAT;
			String tempPattern = tempTimestampFormat.toPattern();
			if (!tempPattern.contains("SSSS")) {
				tempPattern = tempPattern.replace("ss", "ss.SSSS");
			}
			tempTimestampFormat.applyPattern(tempPattern);
		}
	}

	/**
	 * The ISO-standardized date format (this is mostly added to the XML to allow for easy transformation into a
	 * JUnit-compatible result XML.
	 */
	protected static final SimpleDateFormat ISO_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

	static {
		EXECUTION_TIME_FORMAT.setDecimalFormatSymbols(DecimalFormatSymbols.getInstance(Locale.ENGLISH));
	}

	/**
	 * System property name to enable XML Writer Stack Trace output.
	 */
	protected static final String SYSPARAM_ENABLE_TRACE_OUTPUT = "integrity.xmlwriter.trace";

	/**
	 * Whether stack tracing is enabled. See the {@link #stackPeek()}, {@link #stackPop()} and
	 * {@link #stackPush(Element)} method for details.
	 */
	protected boolean isTracingEnabled = Boolean.getBoolean(SYSPARAM_ENABLE_TRACE_OUTPUT);

	/**
	 * System property name to override XSLT resource.
	 */
	protected static final String SYSPARAM_XSLT_RESOURCE = "integrity.xmlwriter.xsltpath";

	/**
	 * The name of the XSLT script resource.
	 */
	protected static final String XSLT_RESOURCE_NAME = System.getProperty(SYSPARAM_XSLT_RESOURCE,
			"resource/xhtml.xslt");

	/**
	 * The XSLT transformer factory property.
	 */
	protected static final String XSLT_TRANSFORMER_FACTORY_PROPERTY = "javax.xml.transform.TransformerFactory";

	/**
	 * Creates a new instance.
	 * 
	 * @param aClassLoader
	 *            the classloader to use
	 * @param anOutputFile
	 *            the file to write the result into
	 * @param aTitle
	 *            the title of the result
	 * @param aTransformHandling
	 *            how the XML -> XHTML transform shall be handled
	 * @param aCaptureConsoleFlag
	 *            whether stdout and stderr shall be captured
	 * 
	 */
	public XmlWriterTestCallback(ClassLoader aClassLoader, File anOutputFile, String aTitle,
			TransformHandling aTransformHandling, boolean aCaptureConsoleFlag) {
		classLoader = aClassLoader;
		outputFile = anOutputFile;
		title = aTitle;
		transformHandling = aTransformHandling != null ? aTransformHandling : TransformHandling.EXECUTE_TRANSFORM;
		captureConsoleOutput = aCaptureConsoleFlag;
	}

	/**
	 * Gets the xslt stream.
	 * 
	 * @return the xslt stream
	 */
	protected InputStream getXsltStream() {
		InputStream tempResult = getClass().getClassLoader().getResourceAsStream(XSLT_RESOURCE_NAME);
		if (tempResult == null) {
			tempResult = classLoader.getResourceAsStream(XSLT_RESOURCE_NAME);
		}
		if (tempResult == null) {
			try {
				tempResult = new FileInputStream(new File(XSLT_RESOURCE_NAME));
			} catch (FileNotFoundException exc) {
				// ignored; will be handled below
			}
		}

		if (tempResult == null) {
			throw new IllegalStateException("Could not load XSLT resource '" + XSLT_RESOURCE_NAME
					+ "', neither from JARs nor from the file system!");
		}

		return tempResult;
	}

	/**
	 * On execution start.
	 * 
	 * @param aModel
	 *            the a model
	 * @param aVariant
	 *            the a variant
	 */
	@Override
	public void onExecutionStart(TestModel aModel, VariantDefinition aVariant) {
		if (captureConsoleOutput) {
			consoleInterceptor.startIntercept();
		}

		Element tempRootElement = new Element(ROOT_ELEMENT);

		if (aVariant != null) {
			Element tempVariantElement = new Element(VARIANT_ELEMENT);
			setAttributeGuarded(tempVariantElement, VARIANT_NAME_ATTRIBUTE, aVariant.getName());
			if (aVariant.getDescription() != null) {
				setAttributeGuarded(tempVariantElement, VARIANT_DESCRIPTION_ATTRIBUTE, aVariant.getDescription());
			}
			tempRootElement.addContent(tempVariantElement);
		}

		tempRootElement.addContent(new Element(VARIABLE_DEFINITION_COLLECTION_ELEMENT));
		setAttributeGuarded(tempRootElement, TEST_RUN_NAME_ATTRIBUTE, title);
		setAttributeGuarded(tempRootElement, TEST_RUN_TIMESTAMP, DATE_FORMAT.format(new Date()));
		setAttributeGuarded(tempRootElement, TEST_RUN_TIMESTAMP_ISO8601, ISO_DATE_FORMAT.format(new Date()));
		addVersion(tempRootElement);
		document = new Document(tempRootElement);
		stackPush(tempRootElement);
		rootSuiteWasStarted = false;

		if (!isFork()) {
			if (transformHandling == TransformHandling.EMBED_TRANSFORM) {
				try {
					Document tempTransform = new SAXBuilder().build(getXsltStream());
					tempRootElement.addContent(0, tempTransform.getRootElement().detach());

					DocType tempDocType = new DocType("doc");
					tempDocType.setInternalSubset("<!ATTLIST xsl:stylesheet\nid ID #REQUIRED>");
					document.setDocType(tempDocType);

					HashMap<String, String> tempProcessingInstructionMap = new HashMap<String, String>(2);
					tempProcessingInstructionMap.put("type", "text/xsl");
					tempProcessingInstructionMap.put("href", "#xhtmltransform");
					ProcessingInstruction tempProcessingInstruction = new ProcessingInstruction("xml-stylesheet",
							tempProcessingInstructionMap);
					document.addContent(0, tempProcessingInstruction);
				} catch (JDOMException exc) {
					exc.printStackTrace();
				} catch (IOException exc) {
					exc.printStackTrace();
				}
			}
		}

		executionStartTime = System.nanoTime();
	}

	/**
	 * On suite start.
	 * 
	 * @param aSuite
	 *            the a suite
	 */
	@Override
	public void onSuiteStart(Suite aSuite) {
		Element tempSuiteElement = new Element(SUITE_ELEMENT);
		addId(tempSuiteElement);
		addLineNumber(tempSuiteElement, aSuite);
		setAttributeGuarded(tempSuiteElement, SUITE_NAME_ATTRIBUTE,
				IntegrityDSLUtil.getQualifiedSuiteName(aSuite.getDefinition()));
		if (rootSuiteWasStarted && (aSuite.getInlined() != null || aSuite.getDefinition().getInlined() != null)) {
			// Inlining the root suite will not work, so we ignore that if it happens.
			setAttributeGuarded(tempSuiteElement, SUITE_DISPLAY_ATTRIBUTE, SUITE_DISPLAY_VALUE_INLINE);
		}
		rootSuiteWasStarted = true;

		addCurrentTime(tempSuiteElement);

		tempSuiteElement.addContent(new Element(SETUP_COLLECTION_ELEMENT));
		tempSuiteElement.addContent(new Element(VARIABLE_DEFINITION_COLLECTION_ELEMENT));
		tempSuiteElement.addContent(new Element(STATEMENT_COLLECTION_ELEMENT));
		tempSuiteElement.addContent(new Element(RETURN_VARIABLE_ASSIGNMENT_COLLECTION_ELEMENT));
		tempSuiteElement.addContent(new Element(TEARDOWN_COLLECTION_ELEMENT));

		if (getForkInExecution() != null) {
			setAttributeGuarded(tempSuiteElement, FORK_NAME_ATTRIBUTE, getForkInExecution().getName());
			if (getForkInExecution().getDescription() != null) {
				setAttributeGuarded(tempSuiteElement, FORK_DESCRIPTION_ATTRIBUTE,
						getForkInExecution().getDescription());
			}
		}

		// The XML output has a notion of a "suite title", which is a freely choosable title given to a suite. This
		// title is derived from the first title comment in a suite. But since those comments can be used for multiple
		// purposes, a special logic is applied to determine whether the first title in a suite shall be treated as
		// suite title. If one of the following circumstances is met, this is the case:
		// 1. The first statement in a suite is a title comment, and it is the only title comment in the suite.
		// 2. The first statement is a title comment, directly followed by another title comment.
		// In both of these cases, the first comment is assumed to be a suite title. In all other cases the logic
		// assumes that the title comments are just simple titles used to structure a suite internally.
		boolean tempFirstStatementWasTitleComment = false;
		boolean tempSecondStatementWasTitleComment = false;
		int tempTitleCommentCount = 0;
		int tempStatementCount = 0;
		for (SuiteStatement tempStatement : aSuite.getDefinition().getStatements()) {
			tempStatementCount++;
			if ((tempStatement instanceof VisibleSingleLineTitleComment)
					|| (tempStatement instanceof VisibleMultiLineTitleComment)) {
				tempTitleCommentCount++;
				if (tempStatementCount == 1) {
					tempFirstStatementWasTitleComment = true;
				} else if (tempStatementCount == 2) {
					tempSecondStatementWasTitleComment = true;
				}
			}
		}
		if ((tempFirstStatementWasTitleComment && tempTitleCommentCount == 1)
				|| (tempFirstStatementWasTitleComment && tempSecondStatementWasTitleComment)) {
			nextTitleCommentIsSuiteTitle = true;
		}

		if (!isDryRun()) {
			if (isFork()) {
				sendElementsToMaster(TestRunnerCallbackMethods.SUITE_START, tempSuiteElement);
			}
			internalOnSuiteStart(tempSuiteElement);
		}
	}

	/**
	 * Internal version of {@link #onSuiteStart(Suite)}.
	 * 
	 * @param aSuiteElement
	 *            the a suite element
	 */
	protected void internalOnSuiteStart(Element aSuiteElement) {
		Element tempParentStatementElement = stackPeek().getChild(STATEMENT_COLLECTION_ELEMENT);
		if (tempParentStatementElement == null) {
			stackPeek().addContent(aSuiteElement);
		} else {
			tempParentStatementElement.addContent(aSuiteElement);
		}

		stackPush(aSuiteElement);
	}

	/**
	 * On setup start.
	 * 
	 * @param aSetupSuite
	 *            the a setup suite
	 */
	@Override
	public void onSetupStart(SuiteDefinition aSetupSuite) {
		Element tempSetupElement = new Element(SUITE_ELEMENT);
		addId(tempSetupElement);
		addLineNumber(tempSetupElement, aSetupSuite);
		setAttributeGuarded(tempSetupElement, SUITE_NAME_ATTRIBUTE,
				IntegrityDSLUtil.getQualifiedSuiteName(aSetupSuite));
		// Setup/Teardown suites are always considered to be inlined, since they are purely functional
		setAttributeGuarded(tempSetupElement, SUITE_DISPLAY_ATTRIBUTE, SUITE_DISPLAY_VALUE_INLINE);

		addCurrentTime(tempSetupElement);

		tempSetupElement.addContent(new Element(SETUP_COLLECTION_ELEMENT));
		tempSetupElement.addContent(new Element(VARIABLE_DEFINITION_COLLECTION_ELEMENT));
		tempSetupElement.addContent(new Element(STATEMENT_COLLECTION_ELEMENT));

		if (!isDryRun()) {
			if (isFork()) {
				sendElementsToMaster(TestRunnerCallbackMethods.SETUP_START, tempSetupElement);
			}
			internalOnSetupStart(tempSetupElement);
		}
	}

	/**
	 * Internal version of {@link #onSetupStart(SuiteDefinition)}.
	 * 
	 * @param aSetupElement
	 *            the a setup element
	 */
	protected void internalOnSetupStart(Element aSetupElement) {
		stackPeek().getChild(SETUP_COLLECTION_ELEMENT).addContent(aSetupElement);
		stackPush(aSetupElement);
	}

	/**
	 * On setup finish.
	 * 
	 * @param aSetupSuite
	 *            the a setup suite
	 * @param aResult
	 *            the a result
	 */
	@Override
	public void onSetupFinish(SuiteDefinition aSetupSuite, SuiteResult aResult) {
		Element tempSuiteResultElement = new Element(RESULT_ELEMENT);
		addSuiteSummaryResultToElement(tempSuiteResultElement, aResult);

		if (!isDryRun()) {
			if (isFork()) {
				sendElementsToMaster(TestRunnerCallbackMethods.SETUP_FINISH, tempSuiteResultElement);
			}
			internalOnSetupFinish(tempSuiteResultElement);
		}
	}

	/**
	 * Adds the given suite summary result totals to the given result element as attributes.
	 * 
	 * @param anElement
	 *            the XML element
	 * @param aResult
	 *            the result object
	 */
	protected void addSuiteSummaryResultToElement(Element anElement, SuiteSummaryResult aResult) {
		if (aResult != null) {
			setAttributeGuarded(anElement, EXECUTION_DURATION_ATTRIBUTE, nanoTimeToString(aResult.getExecutionTime()));
			setAttributeGuarded(anElement, SUCCESS_COUNT_ATTRIBUTE, Integer.toString(aResult.getTestSuccessCount()));
			setAttributeGuarded(anElement, FAILURE_COUNT_ATTRIBUTE, Integer.toString(aResult.getTestFailCount()));
			setAttributeGuarded(anElement, EXCEPTION_COUNT_ATTRIBUTE, Integer.toString(aResult.getExceptionCount()));
			setAttributeGuarded(anElement, TEST_EXCEPTION_COUNT_ATTRIBUTE,
					Integer.toString(aResult.getTestExceptionCount()));
			setAttributeGuarded(anElement, CALL_EXCEPTION_COUNT_ATTRIBUTE,
					Integer.toString(aResult.getCallExceptionCount()));
		}
	}

	/**
	 * Internal version of {@link #onSetupFinish(SuiteDefinition, SuiteResult)}.
	 * 
	 * @param aSuiteResultElement
	 *            the a suite result element
	 */
	protected void internalOnSetupFinish(Element aSuiteResultElement) {
		stackPop().addContent(aSuiteResultElement);
	}

	/**
	 * On test start.
	 * 
	 * @param aTest
	 *            the a test
	 */
	@Override
	public void onTestStart(Test aTest) {
		addConsoleOutput(null); // clear the console interceptor

		Element tempTestElement = new Element(TEST_ELEMENT);
		addId(tempTestElement);
		addLineNumber(tempTestElement, aTest);
		setAttributeGuarded(tempTestElement, TEST_NAME_ELEMENT, aTest.getDefinition().getName());
		try {
			setAttributeGuarded(tempTestElement, FIXTURE_DESCRIPTION_ATTRIBUTE,
					testFormatter.testToHumanReadableString(aTest, null));
		} catch (ClassNotFoundException exc) {
			setAttributeGuarded(tempTestElement, FIXTURE_DESCRIPTION_ATTRIBUTE, exc.getMessage());
			exc.printStackTrace();
		} catch (UnexecutableException exc) {
			setAttributeGuarded(tempTestElement, FIXTURE_DESCRIPTION_ATTRIBUTE, exc.getMessage());
			exc.printStackTrace();
		} catch (InstantiationException exc) {
			setAttributeGuarded(tempTestElement, FIXTURE_DESCRIPTION_ATTRIBUTE, exc.getMessage());
			exc.printStackTrace();
		} catch (MethodNotFoundException exc) {
			setAttributeGuarded(tempTestElement, FIXTURE_DESCRIPTION_ATTRIBUTE, exc.getMessage());
			exc.printStackTrace();
		}
		setAttributeGuarded(tempTestElement, FIXTURE_METHOD_ATTRIBUTE,
				IntegrityDSLUtil.getQualifiedNameOfFixtureMethod(aTest.getDefinition().getFixtureMethod()));

		addCurrentTime(tempTestElement);

		if (!isDryRun()) {
			if (isFork()) {
				sendElementsToMaster(TestRunnerCallbackMethods.TEST_START, tempTestElement);
			}
			internalOnTestStart(tempTestElement);
		}
	}

	/**
	 * Internal version of {@link #onTestStart(Test)}.
	 * 
	 * @param aTestElement
	 *            the a test element
	 */
	protected void internalOnTestStart(Element aTestElement) {
		Element tempCollectionElement = stackPeek().getChild(STATEMENT_COLLECTION_ELEMENT);
		tempCollectionElement.addContent(aTestElement);
		stackPush(aTestElement);
	}

	/**
	 * On table test start.
	 * 
	 * @param aTest
	 *            the a test
	 */
	@Override
	public void onTableTestStart(TableTest aTest) {
		addConsoleOutput(null); // clear the console interceptor

		Element tempTestElement = new Element(TABLETEST_ELEMENT);
		addId(tempTestElement);
		addLineNumber(tempTestElement, aTest);
		setAttributeGuarded(tempTestElement, TEST_NAME_ELEMENT, aTest.getDefinition().getName());
		try {
			setAttributeGuarded(tempTestElement, FIXTURE_DESCRIPTION_ATTRIBUTE,
					testFormatter.tableTestToHumanReadableString(aTest,
							new ConversionContext().withUnresolvableVariableHandlingPolicy(
									UnresolvableVariableHandling.RESOLVE_TO_UNRESOLVABLE_OBJECT)));
		} catch (ClassNotFoundException exc) {
			setAttributeGuarded(tempTestElement, FIXTURE_DESCRIPTION_ATTRIBUTE, exc.getMessage());
			exc.printStackTrace();
		} catch (UnexecutableException exc) {
			setAttributeGuarded(tempTestElement, FIXTURE_DESCRIPTION_ATTRIBUTE, exc.getMessage());
			exc.printStackTrace();
		} catch (InstantiationException exc) {
			setAttributeGuarded(tempTestElement, FIXTURE_DESCRIPTION_ATTRIBUTE, exc.getMessage());
			exc.printStackTrace();
		} catch (MethodNotFoundException exc) {
			setAttributeGuarded(tempTestElement, FIXTURE_DESCRIPTION_ATTRIBUTE, exc.getMessage());
			exc.printStackTrace();
		}
		setAttributeGuarded(tempTestElement, FIXTURE_METHOD_ATTRIBUTE,
				IntegrityDSLUtil.getQualifiedNameOfFixtureMethod(aTest.getDefinition().getFixtureMethod()));

		addCurrentTime(tempTestElement);

		try {
			Map<String, Object> tempParameterMap = parameterResolver.createParameterMap(aTest, null,
					TableTestParameterResolveMethod.ONLY_COMMON, true,
					UnresolvableVariableHandling.RESOLVE_TO_NULL_VALUE);

			Element tempParameterCollectionElement = new Element(PARAMETER_COLLECTION_ELEMENT);
			for (Entry<String, Object> tempEntry : tempParameterMap.entrySet()) {
				Element tempParameterElement = new Element(PARAMETER_ELEMENT);
				setAttributeGuarded(tempParameterElement, PARAMETER_NAME_ATTRIBUTE, tempEntry.getKey());
				setAttributeGuarded(tempParameterElement, PARAMETER_VALUE_ATTRIBUTE, valueConverter
						.convertValueToFormattedString(tempEntry.getValue(), false, null).toFormattedString());
				tempParameterCollectionElement.addContent(tempParameterElement);
			}
			tempTestElement.addContent(tempParameterCollectionElement);
		} catch (InstantiationException exc) {
			exc.printStackTrace();
		} catch (ClassNotFoundException exc) {
			exc.printStackTrace();
		} catch (UnexecutableException exc) {
			exc.printStackTrace();
		}

		if (!isDryRun()) {
			if (isFork()) {
				sendElementsToMaster(TestRunnerCallbackMethods.TABLE_TEST_START, tempTestElement);
			}
			internalOnTableTestStart(tempTestElement);
		}
	}

	/**
	 * Internal version of {@link #onTableTestStart(TableTest)}.
	 * 
	 * @param aTestElement
	 *            the a test element
	 */
	protected void internalOnTableTestStart(Element aTestElement) {
		Element tempCollectionElement = stackPeek().getChild(STATEMENT_COLLECTION_ELEMENT);
		tempCollectionElement.addContent(aTestElement);
		stackPush(aTestElement);

		Element tempResultCollectionElement = new Element(RESULT_COLLECTION_ELEMENT);
		stackPush(tempResultCollectionElement);
	}

	/**
	 * On test finish.
	 * 
	 * @param aTest
	 *            the a test
	 * @param aResult
	 *            the a result
	 */
	@Override
	public void onTestFinish(Test aTest, TestResult aResult) {
		Element tempResultCollectionElement = new Element(RESULT_COLLECTION_ELEMENT);
		if (aResult.getExecutionTime() != null) {
			setAttributeGuarded(tempResultCollectionElement, EXECUTION_DURATION_ATTRIBUTE,
					nanoTimeToString(aResult.getExecutionTime()));
		}
		setAttributeGuarded(tempResultCollectionElement, SUCCESS_COUNT_ATTRIBUTE,
				Integer.toString(aResult.getSubTestSuccessCount()));
		setAttributeGuarded(tempResultCollectionElement, FAILURE_COUNT_ATTRIBUTE,
				Integer.toString(aResult.getSubTestFailCount()));
		setAttributeGuarded(tempResultCollectionElement, EXCEPTION_COUNT_ATTRIBUTE,
				Integer.toString(aResult.getSubTestExceptionCount()));

		Map<String, Object> tempParameterMap = new HashMap<String, Object>();
		try {
			tempParameterMap = parameterResolver.createParameterMap(aTest, true,
					UnresolvableVariableHandling.RESOLVE_TO_NULL_VALUE);
		} catch (InstantiationException exc) {
			exc.printStackTrace();
		} catch (ClassNotFoundException exc) {
			exc.printStackTrace();
		} catch (UnexecutableException exc) {
			exc.printStackTrace();
		}

		onAnyKindOfSubTestFinish(aTest.getDefinition().getFixtureMethod(), aTest, tempResultCollectionElement,
				aResult.getSubResults().get(0), tempParameterMap, tempParameterMap);

		if (!isDryRun()) {
			Element tempExtendedResultElement = createExtendedResultElement(aResult.getExtendedResults());
			if (isFork()) {
				addConsoleOutput(tempResultCollectionElement);
				sendElementsToMaster(TestRunnerCallbackMethods.TEST_FINISH, tempResultCollectionElement,
						tempExtendedResultElement);
			}
			internalOnTestFinish(tempResultCollectionElement, tempExtendedResultElement);
		}
	}

	/**
	 * Internal version of {@link #onTestFinish(Test, TestResult)}.
	 * 
	 * @param aResultCollectionElement
	 *            the a result collection element
	 */
	protected void internalOnTestFinish(Element aResultCollectionElement, Element anExtendedResultElement) {
		addConsoleOutput(aResultCollectionElement);
		Element tempTestElement = stackPop();
		tempTestElement.addContent(aResultCollectionElement);
		if (anExtendedResultElement != null) {
			tempTestElement.addContent(anExtendedResultElement);
		}
	}

	/**
	 * Creates an extended result element.
	 * 
	 * @param someExtendedResults
	 *            the results to add
	 */
	protected Element createExtendedResultElement(List<ExtendedResult> someExtendedResults) {
		if (someExtendedResults != null && someExtendedResults.size() > 0) {
			Element tempExtendedResultCollection = new Element(EXTENDED_RESULT_COLLECTION_ELEMENT);
			for (ExtendedResult tempExtendedResult : someExtendedResults) {
				Element tempResultElement = null;

				if (tempExtendedResult instanceof ExtendedResultText) {
					tempResultElement = new Element(EXTENDED_RESULT_TEXT_ELEMENT);
					tempResultElement.addContent(new CDATA(((ExtendedResultText) tempExtendedResult).getText()));
				} else if (tempExtendedResult instanceof ExtendedResultImage) {
					tempResultElement = new Element(EXTENDED_RESULT_IMAGE_ELEMENT);
					tempResultElement.addContent(
							new Text(Base64.encode(((ExtendedResultImage) tempExtendedResult).getEncodedImage())));
					setAttributeGuarded(tempResultElement, EXTENDED_RESULT_IMAGE_ELEMENT_TYPE_ATTRIBUTE,
							((ExtendedResultImage) tempExtendedResult).getType().getMimeType());
					setAttributeGuarded(tempResultElement, EXTENDED_RESULT_IMAGE_ELEMENT_WIDTH_ATTRIBUTE,
							Integer.toString(((ExtendedResultImage) tempExtendedResult).getWidth()));
					setAttributeGuarded(tempResultElement, EXTENDED_RESULT_IMAGE_ELEMENT_HEIGHT_ATTRIBUTE,
							Integer.toString(((ExtendedResultImage) tempExtendedResult).getHeight()));
				} else if (tempExtendedResult instanceof ExtendedResultHTML) {
					tempResultElement = new Element(EXTENDED_RESULT_HTML_ELEMENT);
					tempResultElement.addContent(new CDATA(((ExtendedResultHTML) tempExtendedResult).getHypertext()));
				}

				if (tempResultElement != null) {
					if (tempExtendedResult.getTitle() != null) {
						setAttributeGuarded(tempResultElement, EXTENDED_RESULT_ELEMENT_TITLE_ATTRIBUTE,
								tempExtendedResult.getTitle());
					}
					tempExtendedResultCollection.addContent(tempResultElement);
				}
			}
			return tempExtendedResultCollection;
		}

		return null;
	}

	/**
	 * On table test row start.
	 * 
	 * @param aTableTest
	 *            the a table test
	 * @param aRow
	 *            the a row
	 */
	@Override
	public void onTableTestRowStart(TableTest aTableTest, TableTestRow aRow) {
		// nothing to do here
	}

	/**
	 * On table test row finish.
	 * 
	 * @param aTableTest
	 *            the a table test
	 * @param aRow
	 *            the a row
	 * @param aSubResult
	 *            the a sub result
	 */
	@Override
	public void onTableTestRowFinish(TableTest aTableTest, TableTestRow aRow, TestSubResult aSubResult) {
		if (!isDryRun()) {
			Map<String, Object> tempParameterMapForText = new HashMap<String, Object>();
			Map<String, Object> tempParameterMap = new HashMap<String, Object>();
			try {
				// The parameters to be displayed in the result table shall only include the line-individual ones
				tempParameterMap = parameterResolver.createParameterMap(aTableTest, aRow,
						TableTestParameterResolveMethod.ONLY_INDIVIDUAL, true,
						UnresolvableVariableHandling.RESOLVE_TO_NULL_VALUE);

				// For the textual test result description, we need all values, including the common ones
				tempParameterMapForText = parameterResolver.createParameterMap(aTableTest, aRow,
						TableTestParameterResolveMethod.COMBINED, true,
						UnresolvableVariableHandling.RESOLVE_TO_NULL_VALUE);
			} catch (InstantiationException exc) {
				exc.printStackTrace();
			} catch (ClassNotFoundException exc) {
				exc.printStackTrace();
			} catch (UnexecutableException exc) {
				exc.printStackTrace();
			}

			onAnyKindOfSubTestFinish(aTableTest.getDefinition().getFixtureMethod(), aTableTest, stackPeek(), aSubResult,
					tempParameterMapForText, tempParameterMap);
		}
	}

	/**
	 * On table test finish.
	 * 
	 * @param aTableTest
	 *            the a table test
	 * @param aResult
	 *            the a result
	 */
	@Override
	public void onTableTestFinish(TableTest aTableTest, TestResult aResult) {
		Element tempResultCollectionElement = stackPeek();
		if (aResult.getExecutionTime() != null) {
			setAttributeGuarded(tempResultCollectionElement, EXECUTION_DURATION_ATTRIBUTE,
					nanoTimeToString(aResult.getExecutionTime()));
		}
		setAttributeGuarded(tempResultCollectionElement, SUCCESS_COUNT_ATTRIBUTE,
				Integer.toString(aResult.getSubTestSuccessCount()));
		setAttributeGuarded(tempResultCollectionElement, FAILURE_COUNT_ATTRIBUTE,
				Integer.toString(aResult.getSubTestFailCount()));
		setAttributeGuarded(tempResultCollectionElement, EXCEPTION_COUNT_ATTRIBUTE,
				Integer.toString(aResult.getSubTestExceptionCount()));

		if (!isDryRun()) {
			Element tempExtendedResultElement = createExtendedResultElement(aResult.getExtendedResults());
			if (isFork()) {
				addConsoleOutput(tempResultCollectionElement);
				sendElementsToMaster(TestRunnerCallbackMethods.TABLE_TEST_FINISH, tempResultCollectionElement,
						tempExtendedResultElement);
			}
			internalOnTableTestFinish(tempResultCollectionElement, tempExtendedResultElement);
		}
	}

	/**
	 * Internal version of {@link #onTableTestFinish(TableTest, TestResult)}.
	 * 
	 * @param aResultCollectionElement
	 *            the a result collection element
	 * @param anExtendedResultElement
	 *            the extended result element
	 */
	protected void internalOnTableTestFinish(Element aResultCollectionElement, Element anExtendedResultElement) {
		stackPop(); // remove result collection element from stack first
		addConsoleOutput(aResultCollectionElement);
		Element tempTestElement = stackPop();
		if (anExtendedResultElement != null) {
			tempTestElement.addContent(anExtendedResultElement);
		}
		tempTestElement.addContent(aResultCollectionElement);
	}

	/**
	 * Used to write sub-test results.
	 * 
	 * @param aMethod
	 *            the method executed
	 * @param aStatement
	 *            the statement currently being executed
	 * @param aResultCollectionElement
	 *            the result element
	 * @param aSubResult
	 *            the sub-result to write
	 * @param aParameterMapForText
	 *            the parameters to be used for text string generation
	 * @param aParameterMap
	 *            the parameters
	 */
	protected void onAnyKindOfSubTestFinish(MethodReference aMethod, SuiteStatementWithResult aStatement,
			Element aResultCollectionElement, TestSubResult aSubResult, Map<String, Object> aParameterMapForText,
			Map<String, Object> aParameterMap) {
		Element tempTestResultElement = new Element(RESULT_ELEMENT);

		if (aSubResult.getExecutionTime() != null) {
			setAttributeGuarded(tempTestResultElement, EXECUTION_DURATION_ATTRIBUTE,
					nanoTimeToString(aSubResult.getExecutionTime()));
		}

		Element tempParameterCollectionElement = new Element(PARAMETER_COLLECTION_ELEMENT);
		for (Entry<String, Object> tempEntry : aParameterMap.entrySet()) {
			Element tempParameterElement = new Element(PARAMETER_ELEMENT);
			setAttributeGuarded(tempParameterElement, PARAMETER_NAME_ATTRIBUTE, tempEntry.getKey());
			setAttributeGuarded(tempParameterElement, PARAMETER_VALUE_ATTRIBUTE, valueConverter
					.convertValueToFormattedString(tempEntry.getValue(), false, null).toFormattedString());
			tempParameterCollectionElement.addContent(tempParameterElement);
		}
		tempTestResultElement.addContent(tempParameterCollectionElement);

		try {
			setAttributeGuarded(tempTestResultElement, FIXTURE_DESCRIPTION_ATTRIBUTE,
					testFormatter.fixtureMethodToHumanReadableString(aMethod, aStatement, aParameterMapForText, null));
		} catch (ClassNotFoundException exc) {
			setAttributeGuarded(tempTestResultElement, FIXTURE_DESCRIPTION_ATTRIBUTE, exc.getMessage());
			exc.printStackTrace();
		} catch (MethodNotFoundException exc) {
			setAttributeGuarded(tempTestResultElement, FIXTURE_DESCRIPTION_ATTRIBUTE, exc.getMessage());
			exc.printStackTrace();
		}

		if (aSubResult instanceof TestExceptionSubResult) {
			setAttributeGuarded(tempTestResultElement, RESULT_TYPE_ATTRIBUTE, RESULT_TYPE_EXCEPTION);
			String tempMessage = ((TestExceptionSubResult) aSubResult).getException().getMessage();
			if (tempMessage != null) {
				setAttributeGuarded(tempTestResultElement, RESULT_EXCEPTION_MESSAGE_ATTRIBUTE, tempMessage);
			}
			setAttributeGuarded(tempTestResultElement, RESULT_EXCEPTION_TRACE_ATTRIBUTE,
					stackTraceToString(((TestExceptionSubResult) aSubResult).getException()));
		} else if (aSubResult instanceof TestExecutedSubResult) {
			if (aSubResult.wereAllComparisonsSuccessful()) {
				setAttributeGuarded(tempTestResultElement, RESULT_TYPE_ATTRIBUTE, RESULT_TYPE_SUCCESS);
			} else {
				setAttributeGuarded(tempTestResultElement, RESULT_TYPE_ATTRIBUTE, RESULT_TYPE_FAILURE);
			}

			Element tempComparisonCollectionElement = new Element(COMPARISON_COLLECTION_ELEMENT);
			for (Entry<String, TestComparisonResult> tempEntry : aSubResult.getComparisonResults().entrySet()) {
				Element tempComparisonResultElement = new Element(COMPARISON_ELEMENT);

				if (tempEntry.getKey().length() > 0) {
					setAttributeGuarded(tempComparisonResultElement, COMPARISON_NAME_ATTRIBUTE, tempEntry.getKey());
				}

				// Either there is an expected value, or if there isn't, "true" is the default
				ValueOrEnumValueOrOperationCollection tempExpectedValue = tempEntry.getValue().getExpectedValue();

				boolean tempExpectedIsNestedObject = containsNestedObject(tempExpectedValue);

				setAttributeGuarded(tempComparisonResultElement, RESULT_EXPECTED_VALUE_ATTRIBUTE, valueConverter
						.convertValueToFormattedString((tempExpectedValue == null ? true : tempExpectedValue), false,
								new ConversionContext().withComparisonResult(tempEntry.getValue().getResult()))
						.toFormattedString());
				if (tempEntry.getValue().getActualValue() != null) {
					setAttributeGuarded(tempComparisonResultElement, RESULT_REAL_VALUE_ATTRIBUTE,
							convertResultValueToFormattedStringGuarded(tempEntry.getValue().getActualValue(),
									aSubResult, tempExpectedIsNestedObject,
									new ConversionContext().withComparisonResult(tempEntry.getValue().getResult()))
											.toFormattedString());
				}

				if (tempEntry.getValue() instanceof TestComparisonSuccessResult) {
					setAttributeGuarded(tempComparisonResultElement, RESULT_TYPE_ATTRIBUTE, RESULT_TYPE_SUCCESS);
				} else if (tempEntry.getValue() instanceof TestComparisonFailureResult) {
					setAttributeGuarded(tempComparisonResultElement, RESULT_TYPE_ATTRIBUTE, RESULT_TYPE_FAILURE);
				}

				tempComparisonCollectionElement.addContent(tempComparisonResultElement);
			}
			tempTestResultElement.addContent(tempComparisonCollectionElement);
		}

		aResultCollectionElement.addContent(tempTestResultElement);
	}

	/**
	 * On call start.
	 * 
	 * @param aCall
	 *            the a call
	 */
	@Override
	public void onCallStart(Call aCall) {
		addConsoleOutput(null); // clear the console interceptor

		Element tempCallElement = new Element(CALL_ELEMENT);
		addId(tempCallElement);
		addLineNumber(tempCallElement, aCall);
		setAttributeGuarded(tempCallElement, CALL_NAME_ELEMENT, aCall.getDefinition().getName());
		try {
			setAttributeGuarded(tempCallElement, FIXTURE_DESCRIPTION_ATTRIBUTE,
					testFormatter.callToHumanReadableString(aCall, null));
		} catch (ClassNotFoundException exc) {
			setAttributeGuarded(tempCallElement, FIXTURE_DESCRIPTION_ATTRIBUTE, exc.getMessage());
			exc.printStackTrace();
		} catch (UnexecutableException exc) {
			setAttributeGuarded(tempCallElement, FIXTURE_DESCRIPTION_ATTRIBUTE, exc.getMessage());
			exc.printStackTrace();
		} catch (InstantiationException exc) {
			setAttributeGuarded(tempCallElement, FIXTURE_DESCRIPTION_ATTRIBUTE, exc.getMessage());
			exc.printStackTrace();
		} catch (MethodNotFoundException exc) {
			setAttributeGuarded(tempCallElement, FIXTURE_DESCRIPTION_ATTRIBUTE, exc.getMessage());
			exc.printStackTrace();
		}
		setAttributeGuarded(tempCallElement, FIXTURE_METHOD_ATTRIBUTE,
				IntegrityDSLUtil.getQualifiedNameOfFixtureMethod(aCall.getDefinition().getFixtureMethod()));

		addCurrentTime(tempCallElement);

		Map<String, Object> tempParameterMap = null;
		try {
			tempParameterMap = parameterResolver.createParameterMap(aCall, true,
					UnresolvableVariableHandling.RESOLVE_TO_NULL_VALUE);
		} catch (ClassNotFoundException exc) {
			exc.printStackTrace();
		} catch (UnexecutableException exc) {
			exc.printStackTrace();
		} catch (InstantiationException exc) {
			exc.printStackTrace();
		}

		Element tempParameterCollectionElement = new Element(PARAMETER_COLLECTION_ELEMENT);
		if (tempParameterMap != null) {
			for (Entry<String, Object> tempParameter : tempParameterMap.entrySet()) {
				Element tempParameterElement = new Element(PARAMETER_ELEMENT);
				setAttributeGuarded(tempParameterElement, PARAMETER_NAME_ATTRIBUTE, tempParameter.getKey());
				setAttributeGuarded(tempParameterElement, PARAMETER_VALUE_ATTRIBUTE, valueConverter
						.convertValueToFormattedString(tempParameter.getValue(), false, null).toFormattedString());

				tempParameterCollectionElement.addContent(tempParameterElement);
			}
		}
		tempCallElement.addContent(tempParameterCollectionElement);

		if (!isDryRun()) {
			if (isFork()) {
				sendElementsToMaster(TestRunnerCallbackMethods.CALL_START, tempCallElement);
			}
			internalOnCallStart(tempCallElement);
		}
	}

	/**
	 * Internal version of {@link #onCallStart(Call)}.
	 * 
	 * @param aCallElement
	 *            the a call element
	 */
	protected void internalOnCallStart(Element aCallElement) {
		Element tempCollectionElement = stackPeek().getChild(STATEMENT_COLLECTION_ELEMENT);
		tempCollectionElement.addContent(aCallElement);
		stackPush(aCallElement);
	}

	/**
	 * On call finish.
	 * 
	 * @param aCall
	 *            the a call
	 * @param aResult
	 *            the a result
	 */
	@Override
	public void onCallFinish(Call aCall, CallResult aResult) {
		Element tempCallResultElement = null;
		if (aResult != null) {
			tempCallResultElement = new Element(RESULT_ELEMENT);
			if (aResult.getExecutionTime() != null) {
				setAttributeGuarded(tempCallResultElement, EXECUTION_DURATION_ATTRIBUTE,
						nanoTimeToString(aResult.getExecutionTime()));
			}

			if (aResult instanceof de.gebit.integrity.runner.results.call.SuccessResult) {
				setAttributeGuarded(tempCallResultElement, RESULT_TYPE_ATTRIBUTE, RESULT_TYPE_SUCCESS);
				de.gebit.integrity.runner.results.call.SuccessResult tempResult = (de.gebit.integrity.runner.results.call.SuccessResult) aResult;
				for (UpdatedVariable tempUpdatedVariable : tempResult.getUpdatedVariables()) {
					Element tempVariableUpdateElement = new Element(VARIABLE_UPDATE_ELEMENT);
					setAttributeGuarded(tempVariableUpdateElement, VARIABLE_NAME_ATTRIBUTE,
							tempUpdatedVariable.getTargetVariable().getName());
					if (tempUpdatedVariable.getParameterName() != null) {
						setAttributeGuarded(tempVariableUpdateElement, VARIABLE_UPDATE_PARAMETER_NAME_ATTRIBUTE,
								tempUpdatedVariable.getParameterName());
					}
					setAttributeGuarded(tempVariableUpdateElement, VARIABLE_VALUE_ATTRIBUTE,
							convertResultValueToFormattedStringGuarded(tempUpdatedVariable.getValue(), aResult, false,
									null).toFormattedString());
					tempCallResultElement.addContent(tempVariableUpdateElement);
				}
			} else if (aResult instanceof de.gebit.integrity.runner.results.call.ExceptionResult) {
				setAttributeGuarded(tempCallResultElement, RESULT_TYPE_ATTRIBUTE, RESULT_TYPE_EXCEPTION);
				String tempExceptionMessage = ((de.gebit.integrity.runner.results.call.ExceptionResult) aResult)
						.getException().getMessage();
				setAttributeGuarded(tempCallResultElement, RESULT_EXCEPTION_MESSAGE_ATTRIBUTE,
						tempExceptionMessage != null ? tempExceptionMessage : "null");
				setAttributeGuarded(tempCallResultElement, RESULT_EXCEPTION_TRACE_ATTRIBUTE, stackTraceToString(
						((de.gebit.integrity.runner.results.call.ExceptionResult) aResult).getException()));
			}
		}

		if (!isDryRun()) {
			Element tempExtendedResultElement = createExtendedResultElement(aResult.getExtendedResults());
			if (isFork()) {
				addConsoleOutput(tempCallResultElement);
				sendElementsToMaster(TestRunnerCallbackMethods.CALL_FINISH, tempCallResultElement,
						tempExtendedResultElement);
			}
			internalOnCallFinish(tempCallResultElement, tempExtendedResultElement);
		}
	}

	/**
	 * Internal version of {@link #onCallFinish(Call, CallResult)}.
	 * 
	 * @param aCallResultElement
	 *            the a call result element
	 * @param anExtendedResultElement
	 *            the extended result element
	 */
	protected void internalOnCallFinish(Element aCallResultElement, Element anExtendedResultElement) {
		if (aCallResultElement != null) {
			addConsoleOutput(aCallResultElement);
			stackPeek().addContent(aCallResultElement);
		}
		if (anExtendedResultElement != null) {
			stackPeek().addContent(anExtendedResultElement);
		}

		stackPop();
	}

	/**
	 * On tear down start.
	 * 
	 * @param aTearDownSuite
	 *            the a tear down suite
	 */
	@Override
	public void onTearDownStart(SuiteDefinition aTearDownSuite) {
		Element tempTearDownElement = new Element(SUITE_ELEMENT);
		addId(tempTearDownElement);
		addLineNumber(tempTearDownElement, aTearDownSuite);
		setAttributeGuarded(tempTearDownElement, SUITE_NAME_ATTRIBUTE,
				IntegrityDSLUtil.getQualifiedSuiteName(aTearDownSuite));
		// Setup/Teardown suites are always considered to be inlined, since they are purely functional
		setAttributeGuarded(tempTearDownElement, SUITE_DISPLAY_ATTRIBUTE, SUITE_DISPLAY_VALUE_INLINE);

		addCurrentTime(tempTearDownElement);

		tempTearDownElement.addContent(new Element(VARIABLE_DEFINITION_COLLECTION_ELEMENT));
		tempTearDownElement.addContent(new Element(STATEMENT_COLLECTION_ELEMENT));

		if (!isDryRun()) {
			if (isFork()) {
				sendElementsToMaster(TestRunnerCallbackMethods.TEAR_DOWN_START, tempTearDownElement);
			}
			internalOnTearDownStart(tempTearDownElement);
		}
	}

	/**
	 * Internal version of {@link #onTearDownStart(SuiteDefinition)}.
	 * 
	 * @param aTearDownElement
	 *            the a tear down element
	 */
	protected void internalOnTearDownStart(Element aTearDownElement) {
		stackPeek().getChild(TEARDOWN_COLLECTION_ELEMENT).addContent(aTearDownElement);
		stackPush(aTearDownElement);
	}

	/**
	 * On tear down finish.
	 * 
	 * @param aTearDownSuite
	 *            the a tear down suite
	 * @param aResult
	 *            the a result
	 */
	@Override
	public void onTearDownFinish(SuiteDefinition aTearDownSuite, SuiteResult aResult) {
		Element tempSuiteResultElement = new Element(RESULT_ELEMENT);
		addSuiteSummaryResultToElement(tempSuiteResultElement, aResult);

		if (!isDryRun()) {
			if (isFork()) {
				sendElementsToMaster(TestRunnerCallbackMethods.TEAR_DOWN_FINISH, tempSuiteResultElement);
			}
			internalOnTearDownFinish(tempSuiteResultElement);
		}
	}

	/**
	 * Internal version of {@link #onTearDownFinish(SuiteDefinition, SuiteResult)}.
	 * 
	 * @param aSuiteResultElement
	 *            the a suite result element
	 */
	protected void internalOnTearDownFinish(Element aSuiteResultElement) {
		stackPop().addContent(aSuiteResultElement);
	}

	/**
	 * On suite finish.
	 * 
	 * @param aSuite
	 *            the a suite
	 * @param aResult
	 *            the a result
	 */
	@Override
	public void onSuiteFinish(Suite aSuite, SuiteSummaryResult aResult) {
		Element tempSuiteResultElement = new Element(RESULT_ELEMENT);
		addSuiteSummaryResultToElement(tempSuiteResultElement, aResult);

		if (!isDryRun()) {
			if (isFork()) {
				sendElementsToMaster(TestRunnerCallbackMethods.SUITE_FINISH, tempSuiteResultElement);
			}
			internalOnSuiteFinish(tempSuiteResultElement);
		}
	}

	/**
	 * Internal version of {@link #onSuiteFinish(Suite, SuiteResult)}.
	 * 
	 * @param aSuiteResultElement
	 *            the a suite result element
	 */
	protected void internalOnSuiteFinish(Element aSuiteResultElement) {
		stackPop().addContent(aSuiteResultElement);
	}

	/**
	 * On execution finish.
	 * 
	 * @param aModel
	 *            the a model
	 * @param aResult
	 *            the a result
	 */
	@Override
	public void onExecutionFinish(TestModel aModel, SuiteSummaryResult aResult) {
		if (captureConsoleOutput) {
			consoleInterceptor.stopIntercept();
		}

		Element tempElement = stackPop();
		setAttributeGuarded(tempElement, TEST_RUN_DURATION, nanoTimeToString(System.nanoTime() - executionStartTime));
		if (abortMessage != null) {
			setAttributeGuarded(tempElement, TEST_RUN_ABORT_MESSAGE_ATTRIBUTE, abortMessage);
		}

		if (!isFork()) {
			long tempStart = System.nanoTime();
			stripTemporaryAttributes(document.getRootElement());

			final FileOutputStream tempOutputStream;
			try {
				tempOutputStream = new FileOutputStream(outputFile);
			} catch (FileNotFoundException exc) {
				exc.printStackTrace();
				return;
			}

			try {
				if (transformHandling == TransformHandling.EXECUTE_TRANSFORM) {
					System.out.print("Transforming Integrity Result XML to HTML...");
					// Transform the XML to XHTML and output that (this actually contains a copy of the original XML
					// result tree in an invisible element!)
					Thread tempThread = new Thread(Thread.currentThread().getThreadGroup(), new Runnable() {

						@Override
						public void run() {
							transformResult(tempOutputStream);
						}
					}, "Integrity XSLT Transform Thread", determineTransformThreadStackSize());
					tempThread.start();
					while (tempThread.isAlive()) {
						try {
							tempThread.join();
						} catch (InterruptedException exc) {
							// ignored
						}
					}
				} else {
					// Output the XML (with XSLT inlined or not)
					System.out.print("Writing Result XML to '" + outputFile.getAbsolutePath() + "'...");
					XMLOutputter tempSerializer = new XMLOutputter(Format.getPrettyFormat());
					tempSerializer.output(document, tempOutputStream);
				}
				long tempTime = System.nanoTime() - tempStart;

				System.out.println("done in " + ((double) (tempTime / 1000000) / 1000.0) + " seconds!");
			} catch (IOException exc) {
				exc.printStackTrace();
			} finally {
				try {
					tempOutputStream.close();
				} catch (IOException exc) {
					// ignore
				}
			}
		}
	}

	/**
	 * Determines the stack size used for the XSLT transform thread. XSLT transformation can require large stack sizes,
	 * since XSLT is a functional language and relies heavily on recursion.
	 * 
	 * @return
	 */
	protected int determineTransformThreadStackSize() {
		String tempStackSize = System.getProperty(SYSPARAM_TRANSFORM_THREAD_STACK_SIZE);
		if (tempStackSize != null) {
			try {
				return Integer.parseInt(tempStackSize);
			} catch (NumberFormatException exc) {
				exc.printStackTrace();
			}
		}

		return TRANSFORM_THREAD_STACK_SIZE_DEFAULT;
	}

	/**
	 * Performs the XSLT transformation and writes the result HTML file into the provided target stream.
	 * 
	 * @param aTargetStream
	 */
	protected void transformResult(FileOutputStream aTargetStream) {
		try {
			/*
			 * Explicitly specify the bundled, patched Saxon XSLT transformer. There is a problem with the XML source
			 * data that is copied to the transformed HTML result (into the "xmldata" element): since the output method
			 * for the serializer is set to HTML, Saxon assumes it is okay to not escape the < char in attributes, which
			 * is no problem for HTML, but strict XML requires those to be replaced by their corresponding entities. I
			 * could solve this by outputting strict XML, but that renders the output unrenderable by browsers :-( well,
			 * for some reason I don't fully understand at least, I'm no browser developer. To solve this, I have
			 * patched the HTMLEmitter inside the bundled Saxon XSLT transformer to escape this character as well, which
			 * seems to work just fine with browsers as well as XML parsers (which should then only parse until the end
			 * of the xmldata element - afterwards there's a lot of non-well-formed XML, which actually is HTML,
			 * coming). The mentioned patch is provided in the file com.icl.saxon.output.HTMLEmitter.diff.
			 */
			TransformerFactory tempTransformerFactory = TransformerFactory
					.newInstance("com.icl.saxon.TransformerFactoryImpl", getClass().getClassLoader());

			Transformer tempTransformer = tempTransformerFactory.newTransformer(new StreamSource(getXsltStream()));
			tempTransformer.setOutputProperty(OutputKeys.METHOD, "html");
			tempTransformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

			Source tempSource = new JDOMSource(document);

			StreamResult tempResult = new StreamResult(aTargetStream);

			tempTransformer.transform(tempSource, tempResult);
		} catch (TransformerConfigurationException exc) {
			exc.printStackTrace();
		} catch (TransformerException exc) {
			exc.printStackTrace();
		}
	}

	/**
	 * On variable definition.
	 * 
	 * @param aDefinition
	 *            the a definition
	 * @param aSuite
	 *            the a suite
	 * @param anInitialValue
	 *            the an initial value
	 */
	@Override
	public void onVariableDefinition(VariableEntity aDefinition, SuiteDefinition aSuite, Object anInitialValue) {
		onVariableDefinitionInternal(aDefinition, aSuite, anInitialValue);
	}

	/**
	 * On constant definition.
	 * 
	 * @param aDefinition
	 *            the a definition
	 * @param aSuite
	 *            the a suite
	 * @param aValue
	 *            the a value
	 * @param aParameterizedFlag
	 *            the a parameterized flag
	 */
	@Override
	public void onConstantDefinition(ConstantEntity aDefinition, SuiteDefinition aSuite, Object aValue,
			boolean aParameterizedFlag) {
		// constants are handled like variables (for now...)
		onVariableDefinitionInternal(aDefinition, aSuite, aValue);
	}

	@Override
	public void onVariableAssignment(VariableAssignment anAssignment, VariableEntity aDefinition,
			SuiteDefinition aSuite, Object aValue) {
		Element tempVariableAssignmentElement = new Element(VARIABLE_ASSIGNMENT_ELEMENT);

		addId(tempVariableAssignmentElement);
		addLineNumber(tempVariableAssignmentElement, anAssignment);
		addCurrentTime(tempVariableAssignmentElement);

		setAttributeGuarded(tempVariableAssignmentElement, FIXTURE_DESCRIPTION_ATTRIBUTE,
				testFormatter.variableAssignmentToHumanReadableString(anAssignment, null));
		setAttributeGuarded(tempVariableAssignmentElement, VARIABLE_NAME_ATTRIBUTE,
				IntegrityDSLUtil.getQualifiedVariableEntityName(aDefinition, false));
		setAttributeGuarded(tempVariableAssignmentElement, VARIABLE_VALUE_ATTRIBUTE,
				valueConverter
						.convertValueToFormattedString(aValue, false,
								new ConversionContext().withUnresolvableVariableHandlingPolicy(
										UnresolvableVariableHandling.RESOLVE_TO_UNRESOLVABLE_OBJECT))
						.toFormattedString());

		if (!isDryRun()) {
			if (isFork()) {
				sendElementsToMaster(TestRunnerCallbackMethods.VARIABLE_ASSIGNMENT, tempVariableAssignmentElement);
			}
			internalOnVariableAssignment(tempVariableAssignmentElement);
		}
	}

	/**
	 * Internal version of {@link #onVariableAssignment(VariableEntity, SuiteDefinition, Object)}.
	 * 
	 * @param aVariableElement
	 */
	protected void internalOnVariableAssignment(Element aVariableAssignmentElement) {
		Element tempCollectionElement = stackPeek().getChild(STATEMENT_COLLECTION_ELEMENT);
		tempCollectionElement.addContent(aVariableAssignmentElement);
	}

	@Override
	public void onReturnVariableAssignment(SuiteReturn aReturn, VariableEntity aSource, VariableEntity aTarget,
			Suite aSuite, Object aValue) {
		Element tempVariableElement = new Element(VARIABLE_ELEMENT);
		setAttributeGuarded(tempVariableElement, VARIABLE_NAME_ATTRIBUTE,
				IntegrityDSLUtil.getQualifiedVariableEntityName(aSource, false));
		setAttributeGuarded(tempVariableElement, VARIABLE_TARGET_ATTRIBUTE,
				IntegrityDSLUtil.getQualifiedVariableEntityName(aTarget, false));
		setAttributeGuarded(tempVariableElement, VARIABLE_VALUE_ATTRIBUTE,
				valueConverter.convertValueToFormattedString(aValue, false, null).toFormattedString());

		if (!isDryRun()) {
			if (isFork()) {
				sendElementsToMaster(TestRunnerCallbackMethods.RETURN_ASSIGNMENT, tempVariableElement);
			}
			internalOnReturnVariableAssignment(tempVariableElement);
		}
	}

	@Override
	public void onTimeSetStart(TimeSet aTimeSet, SuiteDefinition aSuite, List<ForkDefinition> someForks) {
		String tempStartTime = valueConverter.convertValueToString(aTimeSet.getStartTime(), false,
				new ConversionContext()
						.withUnresolvableVariableHandlingPolicy(UnresolvableVariableHandling.RESOLVE_TO_NULL_VALUE));
		String tempProgressionFactor = null;
		if (aTimeSet.getProgressionMode() != null) {
			BigDecimal tempFactor = DateUtil.convertTimeSetProgressionFactor(aTimeSet, valueConverter,
					new ConversionContext().withUnresolvableVariableHandlingPolicy(
							UnresolvableVariableHandling.RESOLVE_TO_NULL_VALUE));
			if (tempFactor != null) {
				tempProgressionFactor = tempFactor.toPlainString();
			} else {
				tempProgressionFactor = UnresolvableVariable.getInstance().toString();
			}
		}

		String tempForkNames = null;
		if (someForks.size() > 1 || (someForks.size() == 1 && someForks.get(0) != null)) {
			tempForkNames = someForks.stream().map((aFork) -> (aFork != null ? aFork.getName() : "master"))
					.collect(Collectors.joining(","));
		}

		Element tempTimeSetElement = new Element(TIME_SET_ELEMENT);

		addId(tempTimeSetElement);
		addLineNumber(tempTimeSetElement, aTimeSet);
		addCurrentTime(tempTimeSetElement);

		setAttributeGuarded(tempTimeSetElement, TIME_TEXT_ATTRIBUTE,
				testFormatter.timeSetToHumanReadableString(aTimeSet, someForks));
		if (tempStartTime != null) {
			setAttributeGuarded(tempTimeSetElement, TIME_START_ATTRIBUTE, tempStartTime);
		}
		if (tempProgressionFactor != null) {
			setAttributeGuarded(tempTimeSetElement, TIME_PROGRESSION_FACTOR_ATTRIBUTE, tempProgressionFactor);
		}
		if (tempForkNames != null) {
			setAttributeGuarded(tempTimeSetElement, TIME_FORK_ATTRIBUTE, tempForkNames);
		}

		if (!isDryRun()) {
			if (isFork()) {
				sendElementsToMaster(TestRunnerCallbackMethods.TIME_SET_START, tempTimeSetElement);
			}
			internalOnTimeSetStart(tempTimeSetElement);
		}
	}

	@Override
	public void onTimeSetFinish(TimeSet aTimeSet, SuiteDefinition aSuite, List<ForkDefinition> someForks,
			Map<String, Pair<ZonedDateTime, Double>> someCurrentDateTimes, String anErrorMessage,
			String anExceptionStackTrace) {
		// This new element is actually only used as a container to transport arguments to be merged with the
		// already-existing time set element
		Element tempTimeSetElement = new Element(TIME_SET_ELEMENT);
		List<Element> tempNewElements = new ArrayList<Element>();
		tempNewElements.add(tempTimeSetElement);

		if (anErrorMessage != null) {
			setAttributeGuarded(tempTimeSetElement, RESULT_EXCEPTION_MESSAGE_ATTRIBUTE, anErrorMessage);
			setAttributeGuarded(tempTimeSetElement, RESULT_EXCEPTION_TRACE_ATTRIBUTE, anExceptionStackTrace);
		} else {
			String tempExtendedResultString = testFormatter
					.testTimeInfoSetToHumanReadableString(someCurrentDateTimes.entrySet());

			Element tempExtendedResultCollection = new Element(EXTENDED_RESULT_COLLECTION_ELEMENT);
			Element tempResultElement = new Element(EXTENDED_RESULT_TEXT_ELEMENT);
			tempResultElement.addContent(new CDATA(tempExtendedResultString));
			tempExtendedResultCollection.addContent(tempResultElement);
			tempTimeSetElement.addContent(tempExtendedResultCollection);

			tempNewElements.add(tempExtendedResultCollection);
			tempNewElements.add(tempResultElement);
		}

		if (!isDryRun()) {
			if (isFork()) {
				sendElementsToMaster(TestRunnerCallbackMethods.TIME_SET_FINISH,
						tempNewElements.toArray(new Element[tempNewElements.size()]));
			}
			internalOnTimeSetFinish(tempTimeSetElement);
		}
	}

	/**
	 * Internal version of {@link #onTimeSetStart(TimeSet, SuiteDefinition, List)}.
	 * 
	 * @param aTimeSetElement
	 */
	protected void internalOnTimeSetStart(Element aTimeSetElement) {
		Element tempCollectionElement = stackPeek().getChild(STATEMENT_COLLECTION_ELEMENT);
		tempCollectionElement.addContent(aTimeSetElement);
		stackPush(aTimeSetElement);
	}

	/**
	 * Internal version of {@link #onTimeSetFinish(TimeSet, SuiteDefinition, List, String, String)}.
	 * 
	 * @param aTimeSetElement
	 */
	@SuppressWarnings("unchecked")
	protected void internalOnTimeSetFinish(Element aTimeSetElement) {
		Element tempActualTimeSetElement = stackPop();

		// Merge the attributes of the two elements...
		for (Object tempAttribute : aTimeSetElement.getAttributes()) {
			setAttributeGuarded(tempActualTimeSetElement, ((Attribute) tempAttribute).getName(),
					((Attribute) tempAttribute).getValue());
		}
		// ...and the sub-elements
		for (Element tempChild : new ArrayList<Element>(aTimeSetElement.getChildren())) {
			tempActualTimeSetElement.addContent(tempChild.detach());
		}
	}

	/**
	 * Internal version of {@link #onReturnVariableAssignment(SuiteReturn, Suite, Object)}.
	 * 
	 * @param aReturnAssignmentElement
	 */
	protected void internalOnReturnVariableAssignment(Element aReturnAssignmentElement) {
		Element tempCollectionElement = stackPeek().getChild(RETURN_VARIABLE_ASSIGNMENT_COLLECTION_ELEMENT);
		tempCollectionElement.addContent(aReturnAssignmentElement);
	}

	@Override
	public void onAbortExecution(String anAbortExecutionMessage, String anAbortExecutionStackTrace) {
		abortMessage = anAbortExecutionMessage;
	}

	/**
	 * On variable definition internal.
	 * 
	 * @param aDefinition
	 *            the a definition
	 * @param aSuite
	 *            the a suite
	 * @param anInitialValue
	 *            the an initial value
	 */
	private void onVariableDefinitionInternal(VariableOrConstantEntity aDefinition, SuiteDefinition aSuite,
			Object anInitialValue) {
		Element tempVariableElement = new Element(VARIABLE_ELEMENT);
		setAttributeGuarded(tempVariableElement, VARIABLE_NAME_ATTRIBUTE,
				IntegrityDSLUtil.getQualifiedVariableEntityName(aDefinition, false));
		if (anInitialValue != null) {
			setAttributeGuarded(tempVariableElement, VARIABLE_VALUE_ATTRIBUTE,
					valueConverter.convertValueToFormattedString(anInitialValue, false, null).toFormattedString());
		}

		if (!isDryRun()) {
			boolean tempGlobalFlag = (aSuite == null);
			if (isFork()) {
				// This is a really ugly hack. We use the fact that a second element is transmitted to communicate the
				// one-bit information about whether this was a global definition or a local one.
				if (tempGlobalFlag) {
					sendElementsToMaster(TestRunnerCallbackMethods.VARIABLE_DEFINITION, tempVariableElement,
							tempVariableElement);
				} else {
					sendElementsToMaster(TestRunnerCallbackMethods.VARIABLE_DEFINITION, tempVariableElement);
				}
			}
			internalOnVariableDefinition(tempVariableElement, tempGlobalFlag);
		}
	}

	/**
	 * Internal version of {@link #onVariableDefinition(VariableEntity, SuiteDefinition, Object)}.
	 * 
	 * @param aVariableElement
	 *            the a variable element
	 */
	protected void internalOnVariableDefinition(Element aVariableElement, boolean aGlobalFlag) {
		Element tempCollectionElement;
		if (aGlobalFlag) {
			tempCollectionElement = document.getRootElement().getChild(VARIABLE_DEFINITION_COLLECTION_ELEMENT);
		} else {
			tempCollectionElement = stackPeek().getChild(VARIABLE_DEFINITION_COLLECTION_ELEMENT);
		}
		tempCollectionElement.addContent(aVariableElement);
	}

	/**
	 * The pattern for URL detection.
	 */
	protected static final Pattern URL_PATTERN = Pattern.compile("(.*?)((?:(?:\\w+://)|(?:\\./))\\S+)(.*)");

	/**
	 * The pattern for Markdown-style URL detection.
	 */
	protected static final Pattern MARKDOWN_URL_PATTERN = Pattern
			.compile("(.*?)\\[(.*?)\\]\\(((?:(?:\\w+://)|(?:\\./)).+?)\\)(.*)");

	/**
	 * Parses a comment into a list of {@link Content} elements. This takes care of URLs embedded in the comment.
	 * 
	 * @param aCommment
	 *            the a commment
	 * @return the list
	 */
	protected List<Content> parseComment(String aCommment) {
		List<Content> tempList = new ArrayList<Content>();
		tempList.add(new Text(aCommment));

		outer: while (true) {
			int i;
			for (i = 0; i < tempList.size(); i++) {
				Content tempElement = tempList.get(i);
				if (tempElement instanceof Text) {
					List<Content> tempInnerList = detectMarkdownURLs(((Text) tempElement).getText());
					if (tempInnerList.size() > 1) {
						tempList.remove(i);
						tempList.addAll(i, tempInnerList);
						break;
					}

					tempInnerList = detectSimpleURLs(((Text) tempElement).getText());
					if (tempInnerList.size() > 1
							|| (tempInnerList.size() == 1 && !(tempInnerList.get(0) instanceof Text))) {
						tempList.remove(i);
						tempList.addAll(i, tempInnerList);
						break;
					}
				}
			}
			if (i >= tempList.size()) {
				break outer;
			}
		}

		return tempList;
	}

	/**
	 * Finds simple URLs in the given text and parses all into XML elements.
	 * 
	 * @param aText
	 *            the text to parse
	 * @return a list of XML elements, with the URLs converted to anchor tags
	 */
	protected List<Content> detectSimpleURLs(String aText) {
		List<Content> tempElementList = new ArrayList<Content>();

		String tempTextLeft = aText;
		Matcher tempMatcher = URL_PATTERN.matcher(tempTextLeft);
		while (tempMatcher.matches()) {
			String tempPrefix = tempMatcher.group(1);
			String tempUrl = tempMatcher.group(2);
			String tempSuffix = tempMatcher.group(3);

			if (tempPrefix != null && tempPrefix.length() > 0) {
				tempElementList.add(new Text(tempPrefix));
			}

			Element tempAnchorElement = new Element("a");
			setAttributeGuarded(tempAnchorElement, "href", tempUrl);
			tempAnchorElement.setText(tempUrl);
			tempElementList.add(tempAnchorElement);

			tempTextLeft = tempSuffix;
			tempMatcher = URL_PATTERN.matcher(tempTextLeft);
		}

		if (tempTextLeft != null && tempTextLeft.length() > 0) {
			tempElementList.add(new Text(tempTextLeft));
		}

		return tempElementList;
	}

	/**
	 * Finds Markdown-style URLs in the given text and parses all into XML elements.
	 * 
	 * @param aText
	 *            the text to parse
	 * @return a list of XML elements, with the URLs converted to anchor tags
	 */
	protected List<Content> detectMarkdownURLs(String aText) {
		List<Content> tempElementList = new ArrayList<Content>();

		String tempTextLeft = aText;
		Matcher tempMatcher = MARKDOWN_URL_PATTERN.matcher(tempTextLeft);
		while (tempMatcher.matches()) {
			String tempPrefix = tempMatcher.group(1);
			String tempName = tempMatcher.group(2);
			String tempUrl = tempMatcher.group(3);
			String tempSuffix = tempMatcher.group(4);

			if (tempPrefix != null && tempPrefix.length() > 0) {
				tempElementList.add(new Text(tempPrefix));
			}

			Element tempAnchorElement = new Element("a");
			setAttributeGuarded(tempAnchorElement, "href", tempUrl);
			tempAnchorElement.setText(tempName);
			tempElementList.add(tempAnchorElement);

			tempTextLeft = tempSuffix;
			tempMatcher = URL_PATTERN.matcher(tempTextLeft);
		}

		if (tempTextLeft != null && tempTextLeft.length() > 0) {
			tempElementList.add(new Text(tempTextLeft));
		}

		return tempElementList;
	}

	/**
	 * On visible comment.
	 * 
	 * @param aCommentText
	 *            the a comment text
	 * @param anIsTitle
	 *            the an is title
	 * @param aCommentElement
	 *            the a comment element
	 */
	@Override
	public void onVisibleComment(String aCommentText, boolean anIsTitle, VisibleComment aCommentElement) {
		Element tempCommentElement = new Element(COMMENT_ELEMENT);
		addId(tempCommentElement);
		addLineNumber(tempCommentElement, aCommentElement);
		tempCommentElement.addContent(parseComment(aCommentText));

		if (anIsTitle) {
			setAttributeGuarded(tempCommentElement, COMMENT_TYPE_ATTRIBUTE,
					nextTitleCommentIsSuiteTitle ? COMMENT_TYPE_SUITETITLE : COMMENT_TYPE_TITLE);
			nextTitleCommentIsSuiteTitle = false;
		}

		if (!isDryRun()) {
			if (isFork()) {
				sendElementsToMaster(TestRunnerCallbackMethods.VISIBLE_COMMENT, tempCommentElement);
			}
			internalOnVisibleComment(tempCommentElement);
		}
	}

	/**
	 * On visible divider.
	 * 
	 * @param aDividerText
	 *            the a divider text
	 * @param aDividerElement
	 *            the a divider element
	 */
	@Override
	public void onVisibleDivider(String aDividerText, VisibleDivider aDividerElement) {
		Element tempCommentElement = new Element(DIVIDER_ELEMENT);
		addId(tempCommentElement);
		addLineNumber(tempCommentElement, aDividerElement);
		setAttributeGuarded(tempCommentElement, DIVIDER_TEXT_ATTRIBUTE, aDividerText);

		if (!isDryRun()) {
			if (isFork()) {
				sendElementsToMaster(TestRunnerCallbackMethods.VISIBLE_DIVIDER, tempCommentElement);
			}
			internalOnVisibleDivider(tempCommentElement);
		}
	}

	/**
	 * Internal version of {@link #onVisibleComment(String)}.
	 * 
	 * @param aCommentElement
	 *            the a comment element
	 */
	protected void internalOnVisibleComment(Element aCommentElement) {
		Element tempCollectionElement = stackPeek().getChild(STATEMENT_COLLECTION_ELEMENT);
		tempCollectionElement.addContent(aCommentElement);

		if (COMMENT_TYPE_SUITETITLE.equals(aCommentElement.getAttributeValue(COMMENT_TYPE_ATTRIBUTE))) {
			Element tempSuiteElement = stackFind(SUITE_ELEMENT);
			setAttributeGuarded(tempSuiteElement, SUITE_TITLE_ATTRIBUTE,
					new XMLOutputter().outputString(aCommentElement.getContent()));
		}
	}

	/**
	 * Internal version of {@link #onVisibleDivider(String)}.
	 * 
	 * @param aDividerElement
	 *            the divider element
	 */
	protected void internalOnVisibleDivider(Element aDividerElement) {
		Element tempCollectionElement = stackPeek().getChild(STATEMENT_COLLECTION_ELEMENT);
		tempCollectionElement.addContent(aDividerElement);
	}

	/**
	 * Formats a stack trace into a single string with line-breaks.
	 * 
	 * @param anException
	 *            the exception from which to get the stack trace
	 * @return the stack trace as a string
	 */
	protected static String stackTraceToString(Throwable anException) {
		String tempResult = null;
		StringWriter tempStringWriter = null;
		PrintWriter tempPrintWriter = null;
		try {
			tempStringWriter = new StringWriter();
			tempPrintWriter = new PrintWriter(tempStringWriter);
			anException.printStackTrace(tempPrintWriter);
			tempResult = tempStringWriter.toString();
		} finally {
			try {
				if (tempPrintWriter != null) {
					tempPrintWriter.close();
				}
				if (tempStringWriter != null) {
					tempStringWriter.close();
				}
			} catch (IOException exc) {
				// nothing to do, since this cannot happen
			}
		}
		return tempResult;
	}

	/**
	 * Converts a nanosecond time value into a string, according to {@link #EXECUTION_TIME_FORMAT}.
	 * 
	 * @param aNanosecondValue
	 *            the time
	 * @return the formatted string
	 */
	protected static String nanoTimeToString(long aNanosecondValue) {
		return EXECUTION_TIME_FORMAT.format(((double) aNanosecondValue) / 1000000.0);
	}

	/**
	 * Sends an XML element to the master {@link XmlWriterTestCallback}.
	 * 
	 * @param aMethod
	 *            the method from which this is called
	 * @param someElements
	 *            the elements to send
	 */
	protected void sendElementsToMaster(TestRunnerCallbackMethods aMethod, Element... someElements) {
		// System.out.println("FORK OUT: " + aMethod);
		Serializable[] tempClones = null;

		if (someElements != null) {
			tempClones = new Serializable[someElements.length];
			for (int i = 0; i < someElements.length; i++) {
				if (someElements[i] != null) {
					tempClones[i] = (Serializable) someElements[i].clone();
				}
			}
		}
		sendToMaster(aMethod, tempClones);
	}

	/**
	 * On message from fork.
	 * 
	 * @param aMethod
	 *            the a method
	 * @param someObjects
	 *            the some objects
	 */
	@Override
	public void onMessageFromFork(TestRunnerCallbackMethods aMethod, Serializable... someObjects) {
		Element tempFirstElement = (Element) someObjects[0]; // one element will always be provided
		// System.out.println("FORK IN: " + aMethod);

		// dispatch message to matching internal... method
		switch (aMethod) {
		case SUITE_START:
			internalOnSuiteStart(tempFirstElement);
			break;
		case SETUP_START:
			internalOnSetupStart(tempFirstElement);
			break;
		case SETUP_FINISH:
			internalOnSetupFinish(tempFirstElement);
			break;
		case TEST_START:
			internalOnTestStart(tempFirstElement);
			break;
		case TABLE_TEST_START:
			internalOnTableTestStart(tempFirstElement);
			break;
		case TEST_FINISH:
			internalOnTestFinish(tempFirstElement, (Element) someObjects[1]);
			break;
		case TABLE_TEST_FINISH:
			internalOnTableTestFinish(tempFirstElement, (Element) someObjects[1]);
			break;
		case CALL_START:
			internalOnCallStart(tempFirstElement);
			break;
		case CALL_FINISH:
			internalOnCallFinish(tempFirstElement, (Element) someObjects[1]);
			break;
		case TEAR_DOWN_START:
			internalOnTearDownStart(tempFirstElement);
			break;
		case TEAR_DOWN_FINISH:
			internalOnTearDownFinish(tempFirstElement);
			break;
		case SUITE_FINISH:
			internalOnSuiteFinish(tempFirstElement);
			break;
		case VARIABLE_DEFINITION:
			internalOnVariableDefinition(tempFirstElement, someObjects.length > 1);
			break;
		case VARIABLE_ASSIGNMENT:
			internalOnVariableAssignment(tempFirstElement);
			break;
		case RETURN_ASSIGNMENT:
			internalOnReturnVariableAssignment(tempFirstElement);
			break;
		case TIME_SET_START:
			internalOnTimeSetStart(tempFirstElement);
			break;
		case TIME_SET_FINISH:
			internalOnTimeSetFinish(tempFirstElement);
			break;
		case VISIBLE_COMMENT:
			internalOnVisibleComment(tempFirstElement);
			break;
		case VISIBLE_DIVIDER:
			internalOnVisibleDivider(tempFirstElement);
			break;
		default:
			return;
		}
	}

	/**
	 * On callback processing start.
	 */
	@Override
	public void onCallbackProcessingStart() {
		if (captureConsoleOutput) {
			consoleInterceptor.pauseIntercept();
		}
	}

	/**
	 * On callback processing end.
	 */
	@Override
	public void onCallbackProcessingEnd() {
		if (captureConsoleOutput) {
			consoleInterceptor.resumeIntercept();
		}
	}

	/**
	 * Adds the console output. Can also be called without an element. In that case, it just retrieves the current
	 * intercept job from the interceptor. Since that automatically starts a new interception job, it is used as a means
	 * to reset the interception at the start of a call or test.<br>
	 * <br>
	 * This method is able to deal with elements which already contain console output. In such a case, the existing
	 * elements' {@link #CONSOLE_TEMP_STARTTIME_ATTRIBUTE} and {@link #CONSOLE_TEMP_ENDTIME_ATTRIBUTE} as well as the
	 * existing lines' {@link #CONSOLE_LINE_TEMP_TIME_ATTRIBUTE} attributes are used to merge newly added lines with the
	 * existing lines. This mechanism is designed to allow merging of console data from forks with data collected on the
	 * master.
	 * 
	 * @param anElement
	 *            the element, or null if the interception result is not to be added to an element
	 */
	@SuppressWarnings("unchecked")
	void addConsoleOutput(Element anElement) {
		if (captureConsoleOutput) {
			Intercept tempIntercept = consoleInterceptor.retrieveIntercept();

			if (anElement != null) {
				long tempLowerTimeBound;
				long tempUpperTimeBound;
				int tempLineCount;
				int tempTruncatedCount;
				boolean tempMerged;

				Element tempLineElements = anElement.getChild(CONSOLE_ELEMENT);
				if (tempLineElements == null) {
					tempLineElements = new Element(CONSOLE_ELEMENT);
					anElement.addContent(tempLineElements);
					tempMerged = false;
					tempLineCount = 0;
					tempTruncatedCount = 0;
					tempLowerTimeBound = tempIntercept.getStartTimestamp();
					setAttributeGuarded(tempLineElements, CONSOLE_TEMP_STARTTIME_ATTRIBUTE,
							Long.toString(tempLowerTimeBound));
					tempUpperTimeBound = tempIntercept.getEndTimestamp();
					setAttributeGuarded(tempLineElements, CONSOLE_TEMP_ENDTIME_ATTRIBUTE,
							Long.toString(tempUpperTimeBound));
				} else {
					tempMerged = true;
					tempLineCount = Integer.parseInt(tempLineElements.getAttributeValue(CONSOLE_LINECOUNT_ATTRIBUTE));
					tempTruncatedCount = Integer
							.parseInt(tempLineElements.getAttributeValue(CONSOLE_TRUNCATED_ATTRIBUTE));
					tempLowerTimeBound = Long
							.parseLong(tempLineElements.getAttributeValue(CONSOLE_TEMP_STARTTIME_ATTRIBUTE));
					tempUpperTimeBound = Long
							.parseLong(tempLineElements.getAttributeValue(CONSOLE_TEMP_ENDTIME_ATTRIBUTE));
				}

				int tempEarliestPossiblePosition = 0;
				for (int i = 0; i < tempIntercept.getLines().size(); i++) {
					InterceptedLine tempLine = tempIntercept.getLines().get(i);

					// First check if we do even need to add this line
					if (tempLowerTimeBound > tempLine.getTimestamp()) {
						// This line is older than our timeframe of interest and thus skipped
						continue;
					}
					if (tempUpperTimeBound < tempLine.getTimestamp()) {
						// This line is newer than our timeframe of interest. The following lines will be even newer,
						// so at this point we can abort processing
						break;
					}

					if (tempLineCount >= MAX_CONSOLE_LINES) {
						tempTruncatedCount++;
						continue;
					}

					// Okay, the line needs to be added
					Element tempLineElement = new Element(
							tempLine.isStdErr() ? CONSOLE_LINE_STDERR_ELEMENT : CONSOLE_LINE_STDOUT_ELEMENT);

					String tempText = tempLine.getText();
					tempText.replace("\t", "    ");
					if (tempText.length() > MAX_CONSOLE_LINE_SIZE) {
						tempText = tempText.substring(0, MAX_CONSOLE_LINE_SIZE) + "... ("
								+ (tempText.length() - MAX_CONSOLE_LINE_SIZE) + " CHARS TRUNCATED)";
					}

					// This time attribute does not actually go into the final result! It's just used to merge fork
					// and master lines on the master after receiving test/call results from a fork.
					setAttributeGuarded(tempLineElement, CONSOLE_LINE_TEMP_TIME_ATTRIBUTE,
							Long.toString(tempLine.getTimestamp()));
					if (isFork()) {
						// At the moment, there is only one valid value for the source attribute: "fork" denotes a line
						// that was created on a fork. If no source is given, the line came from the master.
						setAttributeGuarded(tempLineElement, CONSOLE_LINE_SOURCE_ATTRIBUTE, "fork");
					}

					try {
						setAttributeGuarded(tempLineElement, CONSOLE_LINE_TEXT_ATTRIBUTE, tempText);
					} catch (IllegalDataException exc) {
						exc.printStackTrace();
						setAttributeGuarded(tempLineElement, CONSOLE_LINE_TEXT_ATTRIBUTE,
								"LINE TRUNCATED: IllegalDataException");
					}

					if (tempMerged) {
						// We need to find the right position to add this element in. The mechanism used here should be
						// a bit faster than any generic sorting, but it is based on the assumption that all existing
						// data is already well-ordered, and any new data is also well-ordered, so they just need to
						// be merged.
						while (tempEarliestPossiblePosition < tempLineElements.getChildren().size()) {
							Element tempChild = (Element) tempLineElements.getChildren()
									.get(tempEarliestPossiblePosition);
							if (Long.parseLong(tempChild.getAttributeValue(CONSOLE_LINE_TEMP_TIME_ATTRIBUTE)) > tempLine
									.getTimestamp()) {
								// The new line is to be added right before the current earliest possible position
								break;
							} else {
								tempEarliestPossiblePosition++;
							}
						}
						tempLineElements.getChildren().add(tempEarliestPossiblePosition, tempLineElement);
						tempEarliestPossiblePosition++;
					} else {
						// This is simple: just add it at the end!
						tempLineElements.addContent(tempLineElement);
					}

					tempLineCount++;
				}

				setAttributeGuarded(tempLineElements, CONSOLE_LINECOUNT_ATTRIBUTE, Integer.toString(tempLineCount));
				setAttributeGuarded(tempLineElements, CONSOLE_TRUNCATED_ATTRIBUTE,
						Integer.toString(tempTruncatedCount));

				if (!isFork() && tempLineCount == 0) {
					// If we're on the master, we can scrap console elements without any lines. Forks need to keep these
					// to be sent to the master, since the master might have some lines to be merged into these empty
					// elements.
					anElement.removeContent(tempLineElements);
				}
			}
		}
	}

	/**
	 * Adds the ID attribute to the element and increments the ID counter for the next element.
	 * 
	 * @param anElement
	 *            the element to add an ID to
	 */
	protected void addId(Element anElement) {
		setAttributeGuarded(anElement, ID_ATTRIBUTE, Long.toString(idCounter));
		idCounter++;
	}

	/**
	 * Adds the version number of the test runner bundle to the given element.
	 * 
	 * @param anElement
	 *            the element to add the version to
	 */
	protected void addVersion(Element anElement) {
		String tempVersion = VersionUtil.getBundleVersionString(IntegrityRunnerModule.class);
		if (tempVersion != null) {
			setAttributeGuarded(anElement, VERSION_ATTRIBUTE, tempVersion);
		}
	}

	/**
	 * Adds the line number to the element where the given {@link EObject} starts.
	 * 
	 * @param anElement
	 *            the element to add the number
	 * @param anObject
	 *            the object to find
	 */
	protected void addLineNumber(Element anElement, EObject anObject) {
		ICompositeNode tempNode = NodeModelUtils.getNode(anObject);
		if (tempNode != null) {
			int tempLine = tempNode.getStartLine();
			setAttributeGuarded(anElement, LINE_NUMBER_ATTRIBUTE, Integer.toString(tempLine));
		}
	}

	/**
	 * Adds a timestamp based on the current time to the provided element.
	 * 
	 * @param anElement
	 *            the element to add the timestamp to
	 */
	protected void addCurrentTime(Element anElement) {
		setAttributeGuarded(anElement, TEST_RUN_TIMESTAMP, TIMESTAMP_FORMAT.format(new Date()));
	}

	/**
	 * Strips any temporary attributes (recognized by the prefix {@link #TEMPORARY_ATTRIBUTE_PREFIX}) from an element
	 * hierarchy.
	 * 
	 * @param anElement
	 *            the an element
	 */
	protected void stripTemporaryAttributes(Element anElement) {
		@SuppressWarnings("unchecked")
		Iterator<Attribute> tempAttributeIterator = anElement.getAttributes().iterator();

		// Strip the temporary attributes from the current element...
		while (tempAttributeIterator.hasNext()) {
			if (tempAttributeIterator.next().getName().startsWith(TEMPORARY_ATTRIBUTE_PREFIX)) {
				tempAttributeIterator.remove();
			}
		}

		// ...then recurse down the element tree
		for (Object tempContent : anElement.getContent()) {
			if (tempContent instanceof Element) {
				stripTemporaryAttributes((Element) tempContent);
			}
		}
	}

	/**
	 * Pops an element from the stack.
	 * 
	 * @return the element
	 */
	protected Element stackPop() {
		Element tempElement = currentElement.pop();
		if (isTracingEnabled) {
			System.out.println("--> XMLWRITER STACK POP: " + getStringForElement(tempElement) + " FROM "
					+ Thread.currentThread().getName());
		}
		return tempElement;
	}

	/**
	 * Pushes an element on the stack.
	 * 
	 * @param anElement
	 *            the an element
	 */
	protected void stackPush(Element anElement) {
		if (isTracingEnabled) {
			System.out.println("--> XMLWRITER STACK PUSH: " + getStringForElement(anElement) + " FROM "
					+ Thread.currentThread().getName());
		}
		currentElement.push(anElement);
	}

	/**
	 * Peeks onto the stack.
	 * 
	 * @return the element
	 */
	protected Element stackPeek() {
		Element tempElement = currentElement.peek();
		if (isTracingEnabled) {
			System.out.println("--> XMLWRITER STACK PEEK: " + getStringForElement(tempElement) + " FROM "
					+ Thread.currentThread().getName());
		}
		return tempElement;
	}

	/**
	 * <<<<<<< HEAD ======= Converts the provided element into a string with the element name and all its attributes.
	 * This is for debug purposes only, NOT for writing actual XML content!
	 * 
	 * @param anElement
	 *            the element to stringify
	 * @return the string representation of the element
	 */
	protected String getStringForElement(Element anElement) {
		if (anElement == null) {
			return "null";
		}

		StringBuilder tempBuilder = new StringBuilder();
		tempBuilder.append("<");
		tempBuilder.append(anElement.getName());
		tempBuilder.append(" ");
		@SuppressWarnings("unchecked")
		Iterator<Attribute> tempAttributeIterator = anElement.getAttributes().iterator();

		while (tempAttributeIterator.hasNext()) {
			Attribute tempAttribute = tempAttributeIterator.next();
			tempBuilder.append(" ");
			tempBuilder.append(tempAttribute.getName());
			tempBuilder.append("=\"");
			tempBuilder.append(tempAttribute.getValue());
			tempBuilder.append("\"");
		}

		tempBuilder.append(">");
		return tempBuilder.toString();
	}

	/**
	 * >>>>>>> v0.15.x_bugfix Finds a given element in the stack. The first (topmost) element is returned. The stack is
	 * not altered.
	 * 
	 * @param anElementName
	 *            the name of the element to find
	 * @return the element or null if none was found
	 */
	protected Element stackFind(String anElementName) {
		for (int i = currentElement.size() - 1; i >= 0; i--) {
			Element tempElement = currentElement.get(i);
			if (anElementName.equals(tempElement.getName())) {
				return tempElement;
			}
		}

		return null;
	}

	@Override
	public void onSuiteSkipped(Suite aSuite, SuiteSkipReason aReason) {
		// Doing nothing here.
	}

	@Override
	public void onSetupSkipped(SuiteDefinition aSetupSuite, SuiteSkipReason aReason) {
		// Doing nothing here.
	}

	@Override
	public void onTearDownSkipped(SuiteDefinition aTearDownSuite, SuiteSkipReason aReason) {
		// Doing nothing here.
	}

	/**
	 * Sets the given attribute to the given value in the element. In case of illegal values (containing chars that are
	 * illegal in XML) the illegal chars are replaced with question marks.
	 * 
	 * @param anElement
	 *            the element to set the attribute on
	 * @param anAttributeName
	 *            the attributes name
	 * @param aValue
	 *            the value to set
	 */
	protected void setAttributeGuarded(Element anElement, String anAttributeName, String aValue) {
		// XML Attribute values may contain some illegal characters that would be rejected by JDOM. We catch those and
		// perform replacement of these illegal chars if necessary.
		// This fixes issue #156: Illegal XML characters are not escaped when adding console output
		try {
			anElement.setAttribute(anAttributeName, aValue);
		} catch (IllegalDataException exc) {
			try {
				anElement.setAttribute(anAttributeName, cleanXMLAttributeValue(aValue));
			} catch (IllegalDataException exc2) {
				// This should never happen, as we cleaned up the string before. But just in case - if it happens, set
				// the error message into the attribute.
				anElement.setAttribute(anAttributeName, exc.getMessage());
			}
		}
	}

	/**
	 * Cleans a given attribute values from characters that are illegal in XML attributes.
	 * 
	 * @param aValue
	 *            the string to clean up
	 * @return the cleaned string
	 */
	protected String cleanXMLAttributeValue(String aValue) {
		// The code here is basically a duplicate of the Verifier.checkCharacterData method from JDOM. It replaces
		// illegal characters with legal ones instead of generating error messages.
		StringBuilder tempCleanString = new StringBuilder();

		for (int i = 0, tempLength = aValue.length(); i < tempLength; i++) {

			int tempChar = aValue.charAt(i);

			// Check if high part of a surrogate pair
			if (Verifier.isHighSurrogate((char) tempChar)) {
				// Check if next char is the low-surrogate
				i++;
				if (i < tempLength) {
					char tempLow = aValue.charAt(i);
					if (!Verifier.isLowSurrogate(tempLow)) {
						return "Illegal Surrogate Pair";
					}
					// It's a good pair, calculate the true value of
					// the character to then fall thru to isXMLCharacter
					tempChar = Verifier.decodeSurrogatePair((char) tempChar, tempLow);
				} else {
					return "Surrogate Pair Truncated";
				}
			}

			if (!Verifier.isXMLCharacter(tempChar)) {
				// Illegal characters are replaced with a question mark
				tempChar = (char) '?';
			}

			tempCleanString.append((char) tempChar);
		}

		return tempCleanString.toString();
	}

}

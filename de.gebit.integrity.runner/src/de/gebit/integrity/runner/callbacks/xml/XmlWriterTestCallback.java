package de.gebit.integrity.runner.callbacks.xml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.jdom.Content;
import org.jdom.DocType;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.ProcessingInstruction;
import org.jdom.Text;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.jdom.transform.JDOMSource;

import com.google.inject.Inject;

import de.gebit.integrity.dsl.Call;
import de.gebit.integrity.dsl.ConstantEntity;
import de.gebit.integrity.dsl.MethodReference;
import de.gebit.integrity.dsl.Parameter;
import de.gebit.integrity.dsl.Suite;
import de.gebit.integrity.dsl.SuiteDefinition;
import de.gebit.integrity.dsl.TableTest;
import de.gebit.integrity.dsl.TableTestRow;
import de.gebit.integrity.dsl.Test;
import de.gebit.integrity.dsl.ValueOrEnumValueOrOperationCollection;
import de.gebit.integrity.dsl.VariableEntity;
import de.gebit.integrity.dsl.VariableOrConstantEntity;
import de.gebit.integrity.dsl.VariantDefinition;
import de.gebit.integrity.dsl.VisibleComment;
import de.gebit.integrity.dsl.VisibleDivider;
import de.gebit.integrity.operations.UnexecutableException;
import de.gebit.integrity.parameter.conversion.UnresolvableVariableHandling;
import de.gebit.integrity.parameter.resolving.ParameterResolver;
import de.gebit.integrity.parameter.variables.VariableManager;
import de.gebit.integrity.remoting.transport.enums.TestRunnerCallbackMethods;
import de.gebit.integrity.runner.TestModel;
import de.gebit.integrity.runner.callbacks.AbstractTestRunnerCallback;
import de.gebit.integrity.runner.callbacks.TestFormatter;
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
import de.gebit.integrity.utils.IntegrityDSLUtil;

/**
 * Test runner callback which writes to an XML result file. This runner may optionally add an XHTML transform to the
 * file which allows to render the results in a nice, readable layout in any good browser.
 * 
 * 
 * @author Rene Schneider
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
	 * The stack of elements.
	 */
	protected Stack<Element> currentElement = new Stack<Element>();

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

	/** The Constant VARIABLE_DEFINITION_COLLECTION_ELEMENT. */
	protected static final String VARIABLE_DEFINITION_COLLECTION_ELEMENT = "variables";

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

	/** The Constant VARIABLE_ELEMENT. */
	protected static final String VARIABLE_ELEMENT = "variable";

	/** The Constant COMMENT_ELEMENT. */
	protected static final String COMMENT_ELEMENT = "comment";

	/** The Constant COMMENT_TEXT_ATTRIBUTE. */
	protected static final String COMMENT_TEXT_ATTRIBUTE = "text";

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

	/**
	 * The time format used to format execution times.
	 */
	protected static final DecimalFormat EXECUTION_TIME_FORMAT = new DecimalFormat("0.000");

	/**
	 * The generally used date format.
	 */
	protected static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat();

	/**
	 * The ISO-standardized date format (this is mostly added to the XML to allow for easy transformation into a
	 * JUnit-compatible result XML.
	 */
	protected static final SimpleDateFormat ISO_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

	static {
		EXECUTION_TIME_FORMAT.setDecimalFormatSymbols(DecimalFormatSymbols.getInstance(Locale.ENGLISH));
	}

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
	 * 
	 */
	public XmlWriterTestCallback(ClassLoader aClassLoader, File anOutputFile, String aTitle,
			TransformHandling aTransformHandling) {
		classLoader = aClassLoader;
		outputFile = anOutputFile;
		title = aTitle;
		transformHandling = aTransformHandling != null ? aTransformHandling : TransformHandling.EXECUTE_TRANSFORM;
	}

	private InputStream getXsltStream() {
		return getClass().getClassLoader().getResourceAsStream("resource/xhtml.xslt");
	}

	@Override
	public void onExecutionStart(TestModel aModel, VariantDefinition aVariant) {
		Element tempRootElement = new Element(ROOT_ELEMENT);

		if (aVariant != null) {
			Element tempVariantElement = new Element(VARIANT_ELEMENT);
			tempVariantElement.setAttribute(VARIANT_NAME_ATTRIBUTE, aVariant.getName());
			if (aVariant.getDescription() != null) {
				tempVariantElement.setAttribute(VARIANT_DESCRIPTION_ATTRIBUTE, aVariant.getDescription());
			}
			tempRootElement.addContent(tempVariantElement);
		}

		tempRootElement.addContent(new Element(VARIABLE_DEFINITION_COLLECTION_ELEMENT));
		tempRootElement.setAttribute(TEST_RUN_NAME_ATTRIBUTE, title);
		tempRootElement.setAttribute(TEST_RUN_TIMESTAMP, DATE_FORMAT.format(new Date()));
		tempRootElement.setAttribute(TEST_RUN_TIMESTAMP_ISO8601, ISO_DATE_FORMAT.format(new Date()));
		document = new Document(tempRootElement);
		currentElement.push(tempRootElement);

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

	@Override
	public void onSuiteStart(Suite aSuite) {
		Element tempSuiteElement = new Element(SUITE_ELEMENT);
		addId(tempSuiteElement);
		addLineNumber(tempSuiteElement, aSuite);
		tempSuiteElement.setAttribute(SUITE_NAME_ATTRIBUTE,
				IntegrityDSLUtil.getQualifiedSuiteName(aSuite.getDefinition()));
		tempSuiteElement.addContent(new Element(SETUP_COLLECTION_ELEMENT));
		tempSuiteElement.addContent(new Element(VARIABLE_DEFINITION_COLLECTION_ELEMENT));
		tempSuiteElement.addContent(new Element(STATEMENT_COLLECTION_ELEMENT));
		tempSuiteElement.addContent(new Element(TEARDOWN_COLLECTION_ELEMENT));

		if (getForkInExecution() != null) {
			tempSuiteElement.setAttribute(FORK_NAME_ATTRIBUTE, getForkInExecution().getName());
			if (getForkInExecution().getDescription() != null) {
				tempSuiteElement.setAttribute(FORK_DESCRIPTION_ATTRIBUTE, getForkInExecution().getDescription());
			}
		}

		if (!isDryRun()) {
			if (isFork()) {
				sendElementToMaster(TestRunnerCallbackMethods.SUITE_START, tempSuiteElement);
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
		Element tempParentStatementElement = currentElement.peek().getChild(STATEMENT_COLLECTION_ELEMENT);
		if (tempParentStatementElement == null) {
			currentElement.peek().addContent(aSuiteElement);
		} else {
			tempParentStatementElement.addContent(aSuiteElement);
		}

		currentElement.push(aSuiteElement);
	}

	@Override
	public void onSetupStart(SuiteDefinition aSetupSuite) {
		Element tempSetupElement = new Element(SUITE_ELEMENT);
		addId(tempSetupElement);
		addLineNumber(tempSetupElement, aSetupSuite);
		tempSetupElement.setAttribute(SUITE_NAME_ATTRIBUTE, IntegrityDSLUtil.getQualifiedSuiteName(aSetupSuite));
		tempSetupElement.addContent(new Element(VARIABLE_DEFINITION_COLLECTION_ELEMENT));
		tempSetupElement.addContent(new Element(STATEMENT_COLLECTION_ELEMENT));

		if (!isDryRun()) {
			if (isFork()) {
				sendElementToMaster(TestRunnerCallbackMethods.SETUP_START, tempSetupElement);
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
		currentElement.peek().getChild(SETUP_COLLECTION_ELEMENT).addContent(aSetupElement);
		currentElement.push(aSetupElement);
	}

	@Override
	public void onSetupFinish(SuiteDefinition aSetupSuite, SuiteResult aResult) {
		Element tempSuiteResultElement = new Element(RESULT_ELEMENT);
		if (aResult != null) {
			tempSuiteResultElement.setAttribute(EXECUTION_DURATION_ATTRIBUTE,
					nanoTimeToString(aResult.getExecutionTime()));
			tempSuiteResultElement.setAttribute(SUCCESS_COUNT_ATTRIBUTE,
					Integer.toString(aResult.getTestSuccessCount()));
			tempSuiteResultElement.setAttribute(FAILURE_COUNT_ATTRIBUTE, Integer.toString(aResult.getTestFailCount()));
			tempSuiteResultElement.setAttribute(EXCEPTION_COUNT_ATTRIBUTE,
					Integer.toString(aResult.getTestExceptionCount()));
		}

		if (!isDryRun()) {
			if (isFork()) {
				sendElementToMaster(TestRunnerCallbackMethods.SETUP_FINISH, tempSuiteResultElement);
			}
			internalOnSetupFinish(tempSuiteResultElement);
		}
	}

	/**
	 * Internal version of {@link #onSetupFinish(SuiteDefinition, SuiteResult)}.
	 * 
	 * @param aSuiteResultElement
	 *            the a suite result element
	 */
	protected void internalOnSetupFinish(Element aSuiteResultElement) {
		currentElement.pop().addContent(aSuiteResultElement);
	}

	@Override
	public void onTestStart(Test aTest) {
		Element tempTestElement = new Element(TEST_ELEMENT);
		addId(tempTestElement);
		addLineNumber(tempTestElement, aTest);
		tempTestElement.setAttribute(TEST_NAME_ELEMENT, aTest.getDefinition().getName());
		try {
			tempTestElement
					.setAttribute(FIXTURE_DESCRIPTION_ATTRIBUTE, testFormatter.testToHumanReadableString(aTest,
							UnresolvableVariableHandling.RESOLVE_TO_NULL_STRING));
		} catch (ClassNotFoundException exc) {
			tempTestElement.setAttribute(FIXTURE_DESCRIPTION_ATTRIBUTE, exc.getMessage());
			exc.printStackTrace();
		} catch (UnexecutableException exc) {
			tempTestElement.setAttribute(FIXTURE_DESCRIPTION_ATTRIBUTE, exc.getMessage());
			exc.printStackTrace();
		} catch (InstantiationException exc) {
			tempTestElement.setAttribute(FIXTURE_DESCRIPTION_ATTRIBUTE, exc.getMessage());
			exc.printStackTrace();
		}
		tempTestElement.setAttribute(FIXTURE_METHOD_ATTRIBUTE,
				IntegrityDSLUtil.getQualifiedNameOfFixtureMethod(aTest.getDefinition().getFixtureMethod()));

		if (!isDryRun()) {
			if (isFork()) {
				sendElementToMaster(TestRunnerCallbackMethods.TEST_START, tempTestElement);
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
		Element tempCollectionElement = currentElement.peek().getChild(STATEMENT_COLLECTION_ELEMENT);
		tempCollectionElement.addContent(aTestElement);
		currentElement.push(aTestElement);
	}

	@Override
	public void onTableTestStart(TableTest aTest) {
		Element tempTestElement = new Element(TABLETEST_ELEMENT);
		addId(tempTestElement);
		addLineNumber(tempTestElement, aTest);
		tempTestElement.setAttribute(TEST_NAME_ELEMENT, aTest.getDefinition().getName());
		try {
			tempTestElement.setAttribute(FIXTURE_DESCRIPTION_ATTRIBUTE, testFormatter.tableTestToHumanReadableString(
					aTest, UnresolvableVariableHandling.RESOLVE_TO_QUESTIONMARK_STRING));
		} catch (ClassNotFoundException exc) {
			tempTestElement.setAttribute(FIXTURE_DESCRIPTION_ATTRIBUTE, exc.getMessage());
			exc.printStackTrace();
		} catch (UnexecutableException exc) {
			tempTestElement.setAttribute(FIXTURE_DESCRIPTION_ATTRIBUTE, exc.getMessage());
			exc.printStackTrace();
		} catch (InstantiationException exc) {
			tempTestElement.setAttribute(FIXTURE_DESCRIPTION_ATTRIBUTE, exc.getMessage());
			exc.printStackTrace();
		}
		tempTestElement.setAttribute(FIXTURE_METHOD_ATTRIBUTE,
				IntegrityDSLUtil.getQualifiedNameOfFixtureMethod(aTest.getDefinition().getFixtureMethod()));

		if (!isDryRun()) {
			if (isFork()) {
				sendElementToMaster(TestRunnerCallbackMethods.TABLE_TEST_START, tempTestElement);
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
		Element tempCollectionElement = currentElement.peek().getChild(STATEMENT_COLLECTION_ELEMENT);
		tempCollectionElement.addContent(aTestElement);
		currentElement.push(aTestElement);

		Element tempResultCollectionElement = new Element(RESULT_COLLECTION_ELEMENT);
		currentElement.push(tempResultCollectionElement);
	}

	@Override
	public void onTestFinish(Test aTest, TestResult aResult) {
		Element tempResultCollectionElement = new Element(RESULT_COLLECTION_ELEMENT);
		if (aResult.getExecutionTime() != null) {
			tempResultCollectionElement.setAttribute(EXECUTION_DURATION_ATTRIBUTE,
					nanoTimeToString(aResult.getExecutionTime()));
		}
		tempResultCollectionElement.setAttribute(SUCCESS_COUNT_ATTRIBUTE,
				Integer.toString(aResult.getSubTestSuccessCount()));
		tempResultCollectionElement.setAttribute(FAILURE_COUNT_ATTRIBUTE,
				Integer.toString(aResult.getSubTestFailCount()));
		tempResultCollectionElement.setAttribute(EXCEPTION_COUNT_ATTRIBUTE,
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

		onAnyKindOfSubTestFinish(aTest.getDefinition().getFixtureMethod(), tempResultCollectionElement, aResult
				.getSubResults().get(0), tempParameterMap);

		if (!isDryRun()) {
			if (isFork()) {
				sendElementToMaster(TestRunnerCallbackMethods.TEST_FINISH, tempResultCollectionElement);
			}
			internalOnTestFinish(tempResultCollectionElement);
		}
	}

	/**
	 * Internal version of {@link #onTestFinish(Test, TestResult)}.
	 * 
	 * @param aResultCollectionElement
	 *            the a result collection element
	 */
	protected void internalOnTestFinish(Element aResultCollectionElement) {
		currentElement.pop().addContent(aResultCollectionElement);
	}

	@Override
	public void onTableTestRowStart(TableTest aTableTest, TableTestRow aRow) {
		// nothing to do here
	}

	@Override
	public void onTableTestRowFinish(TableTest aTableTest, TableTestRow aRow, TestSubResult aSubResult) {
		if (!isDryRun()) {
			Map<String, Object> tempParameterMap = new HashMap<String, Object>();
			try {
				tempParameterMap = parameterResolver.createParameterMap(aTableTest, aRow, true,
						UnresolvableVariableHandling.RESOLVE_TO_NULL_VALUE);
			} catch (InstantiationException exc) {
				exc.printStackTrace();
			} catch (ClassNotFoundException exc) {
				exc.printStackTrace();
			} catch (UnexecutableException exc) {
				exc.printStackTrace();
			}

			onAnyKindOfSubTestFinish(aTableTest.getDefinition().getFixtureMethod(), currentElement.peek(), aSubResult,
					tempParameterMap);
		}
	}

	@Override
	public void onTableTestFinish(TableTest aTableTest, TestResult aResult) {
		if (!isDryRun()) {
			Element tempResultCollectionElement = currentElement.pop();
			tempResultCollectionElement.setAttribute(EXECUTION_DURATION_ATTRIBUTE,
					nanoTimeToString(aResult.getExecutionTime()));
			tempResultCollectionElement.setAttribute(SUCCESS_COUNT_ATTRIBUTE,
					Integer.toString(aResult.getSubTestSuccessCount()));
			tempResultCollectionElement.setAttribute(FAILURE_COUNT_ATTRIBUTE,
					Integer.toString(aResult.getSubTestFailCount()));
			tempResultCollectionElement.setAttribute(EXCEPTION_COUNT_ATTRIBUTE,
					Integer.toString(aResult.getSubTestExceptionCount()));

			if (isFork()) {
				sendElementToMaster(TestRunnerCallbackMethods.TABLE_TEST_FINISH, tempResultCollectionElement);
			}
			internalOnTableTestFinish(tempResultCollectionElement);
		}
	}

	/**
	 * Internal version of {@link #onTableTestFinish(TableTest, TestResult)}.
	 * 
	 * @param aResultCollectionElement
	 *            the a result collection element
	 */
	protected void internalOnTableTestFinish(Element aResultCollectionElement) {
		currentElement.pop().addContent(aResultCollectionElement);
	}

	/**
	 * Used to write sub-test results.
	 * 
	 * @param aMethod
	 *            the method executed
	 * @param aResultCollectionElement
	 *            the result element
	 * @param aSubResult
	 *            the sub-result to write
	 * @param aParameterMap
	 *            the parameters
	 */
	protected void onAnyKindOfSubTestFinish(MethodReference aMethod, Element aResultCollectionElement,
			TestSubResult aSubResult, Map<String, Object> aParameterMap) {
		Element tempTestResultElement = new Element(RESULT_ELEMENT);

		if (aSubResult.getExecutionTime() != null) {
			tempTestResultElement.setAttribute(EXECUTION_DURATION_ATTRIBUTE,
					nanoTimeToString(aSubResult.getExecutionTime()));
		}

		Element tempParameterCollectionElement = new Element(PARAMETER_COLLECTION_ELEMENT);
		for (Entry<String, Object> tempEntry : aParameterMap.entrySet()) {
			Element tempParameterElement = new Element(PARAMETER_ELEMENT);
			tempParameterElement.setAttribute(PARAMETER_NAME_ATTRIBUTE, tempEntry.getKey());
			tempParameterElement.setAttribute(PARAMETER_VALUE_ATTRIBUTE, valueConverter.convertValueToString(
					tempEntry.getValue(), false, UnresolvableVariableHandling.RESOLVE_TO_NULL_STRING));
			tempParameterCollectionElement.addContent(tempParameterElement);
		}
		tempTestResultElement.addContent(tempParameterCollectionElement);

		try {
			tempTestResultElement.setAttribute(FIXTURE_DESCRIPTION_ATTRIBUTE, testFormatter
					.fixtureMethodToHumanReadableString(aMethod, aParameterMap,
							UnresolvableVariableHandling.RESOLVE_TO_NULL_STRING));
		} catch (ClassNotFoundException exc) {
			tempTestResultElement.setAttribute(FIXTURE_DESCRIPTION_ATTRIBUTE, exc.getMessage());
			exc.printStackTrace();
		}

		if (aSubResult instanceof TestExceptionSubResult) {
			tempTestResultElement.setAttribute(RESULT_TYPE_ATTRIBUTE, RESULT_TYPE_EXCEPTION);
			String tempMessage = ((TestExceptionSubResult) aSubResult).getException().getMessage();
			if (tempMessage != null) {
				tempTestResultElement.setAttribute(RESULT_EXCEPTION_MESSAGE_ATTRIBUTE, tempMessage);
			}
			tempTestResultElement.setAttribute(RESULT_EXCEPTION_TRACE_ATTRIBUTE,
					stackTraceToString(((TestExceptionSubResult) aSubResult).getException()));
		} else if (aSubResult instanceof TestExecutedSubResult) {
			if (aSubResult.wereAllComparisonsSuccessful()) {
				tempTestResultElement.setAttribute(RESULT_TYPE_ATTRIBUTE, RESULT_TYPE_SUCCESS);
			} else {
				tempTestResultElement.setAttribute(RESULT_TYPE_ATTRIBUTE, RESULT_TYPE_FAILURE);
			}

			Element tempComparisonCollectionElement = new Element(COMPARISON_COLLECTION_ELEMENT);
			for (Entry<String, TestComparisonResult> tempEntry : aSubResult.getComparisonResults().entrySet()) {
				Element tempComparisonResultElement = new Element(COMPARISON_ELEMENT);

				if (tempEntry.getKey().length() > 0) {
					tempComparisonResultElement.setAttribute(COMPARISON_NAME_ATTRIBUTE, tempEntry.getKey());
				}

				// Either there is an expected value, or if there isn't, "true" is the default
				ValueOrEnumValueOrOperationCollection tempExpectedValue = tempEntry.getValue().getExpectedValue();

				boolean tempExpectedIsNestedObject = containsNestedObject(tempExpectedValue);

				tempComparisonResultElement.setAttribute(RESULT_EXPECTED_VALUE_ATTRIBUTE, valueConverter
						.convertValueToString((tempExpectedValue == null ? true : tempExpectedValue), false,
								UnresolvableVariableHandling.RESOLVE_TO_NULL_STRING));
				if (tempEntry.getValue().getResult() != null) {
					tempComparisonResultElement.setAttribute(
							RESULT_REAL_VALUE_ATTRIBUTE,
							convertResultValueToStringGuarded(tempEntry.getValue().getResult(), aSubResult,
									tempExpectedIsNestedObject, UnresolvableVariableHandling.RESOLVE_TO_NULL_STRING));
				}

				if (tempEntry.getValue() instanceof TestComparisonSuccessResult) {
					tempComparisonResultElement.setAttribute(RESULT_TYPE_ATTRIBUTE, RESULT_TYPE_SUCCESS);
				} else if (tempEntry.getValue() instanceof TestComparisonFailureResult) {
					tempComparisonResultElement.setAttribute(RESULT_TYPE_ATTRIBUTE, RESULT_TYPE_FAILURE);
				}

				tempComparisonCollectionElement.addContent(tempComparisonResultElement);
			}
			tempTestResultElement.addContent(tempComparisonCollectionElement);
		}

		aResultCollectionElement.addContent(tempTestResultElement);
	}

	@Override
	public void onCallStart(Call aCall) {
		Element tempCallElement = new Element(CALL_ELEMENT);
		addId(tempCallElement);
		addLineNumber(tempCallElement, aCall);
		tempCallElement.setAttribute(CALL_NAME_ELEMENT, aCall.getDefinition().getName());
		try {
			tempCallElement
					.setAttribute(FIXTURE_DESCRIPTION_ATTRIBUTE, testFormatter.callToHumanReadableString(aCall,
							UnresolvableVariableHandling.RESOLVE_TO_NULL_STRING));
		} catch (ClassNotFoundException exc) {
			tempCallElement.setAttribute(FIXTURE_DESCRIPTION_ATTRIBUTE, exc.getMessage());
			exc.printStackTrace();
		} catch (UnexecutableException exc) {
			tempCallElement.setAttribute(FIXTURE_DESCRIPTION_ATTRIBUTE, exc.getMessage());
			exc.printStackTrace();
		} catch (InstantiationException exc) {
			tempCallElement.setAttribute(FIXTURE_DESCRIPTION_ATTRIBUTE, exc.getMessage());
			exc.printStackTrace();
		}
		tempCallElement.setAttribute(FIXTURE_METHOD_ATTRIBUTE,
				IntegrityDSLUtil.getQualifiedNameOfFixtureMethod(aCall.getDefinition().getFixtureMethod()));

		Element tempParameterCollectionElement = new Element(PARAMETER_COLLECTION_ELEMENT);
		for (Parameter tempParameter : aCall.getParameters()) {
			Element tempParameterElement = new Element(PARAMETER_ELEMENT);
			tempParameterElement.setAttribute(PARAMETER_NAME_ATTRIBUTE,
					IntegrityDSLUtil.getParamNameStringFromParameterName(tempParameter.getName()));
			tempParameterElement.setAttribute(PARAMETER_VALUE_ATTRIBUTE, valueConverter.convertValueToString(
					tempParameter.getValue(), false, UnresolvableVariableHandling.RESOLVE_TO_NULL_STRING));

			tempParameterCollectionElement.addContent(tempParameterElement);
		}
		tempCallElement.addContent(tempParameterCollectionElement);

		if (!isDryRun()) {
			if (isFork()) {
				sendElementToMaster(TestRunnerCallbackMethods.CALL_START, tempCallElement);
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
		Element tempCollectionElement = currentElement.peek().getChild(STATEMENT_COLLECTION_ELEMENT);
		tempCollectionElement.addContent(aCallElement);
		currentElement.push(aCallElement);
	}

	@Override
	public void onCallFinish(Call aCall, CallResult aResult) {
		Element tempCallResultElement = null;
		if (aResult != null) {
			tempCallResultElement = new Element(RESULT_ELEMENT);
			if (aResult.getExecutionTime() != null) {
				tempCallResultElement.setAttribute(EXECUTION_DURATION_ATTRIBUTE,
						nanoTimeToString(aResult.getExecutionTime()));
			}

			if (aResult instanceof de.gebit.integrity.runner.results.call.SuccessResult) {
				tempCallResultElement.setAttribute(RESULT_TYPE_ATTRIBUTE, RESULT_TYPE_SUCCESS);
				de.gebit.integrity.runner.results.call.SuccessResult tempResult = (de.gebit.integrity.runner.results.call.SuccessResult) aResult;
				for (UpdatedVariable tempUpdatedVariable : tempResult.getUpdatedVariables()) {
					Element tempVariableUpdateElement = new Element(VARIABLE_UPDATE_ELEMENT);
					tempVariableUpdateElement.setAttribute(VARIABLE_NAME_ATTRIBUTE, tempUpdatedVariable
							.getTargetVariable().getName());
					if (tempUpdatedVariable.getParameterName() != null) {
						tempVariableUpdateElement.setAttribute(VARIABLE_UPDATE_PARAMETER_NAME_ATTRIBUTE,
								tempUpdatedVariable.getParameterName());
					}
					tempVariableUpdateElement.setAttribute(
							VARIABLE_VALUE_ATTRIBUTE,
							convertResultValueToStringGuarded(tempUpdatedVariable.getValue(), aResult, false,
									UnresolvableVariableHandling.RESOLVE_TO_NULL_STRING));
					tempCallResultElement.addContent(tempVariableUpdateElement);
				}
			} else if (aResult instanceof de.gebit.integrity.runner.results.call.ExceptionResult) {
				tempCallResultElement.setAttribute(RESULT_TYPE_ATTRIBUTE, RESULT_TYPE_EXCEPTION);
				String tempExceptionMessage = ((de.gebit.integrity.runner.results.call.ExceptionResult) aResult)
						.getException().getMessage();
				tempCallResultElement.setAttribute(RESULT_EXCEPTION_MESSAGE_ATTRIBUTE,
						tempExceptionMessage != null ? tempExceptionMessage : "null");
				tempCallResultElement.setAttribute(RESULT_EXCEPTION_TRACE_ATTRIBUTE,
						stackTraceToString(((de.gebit.integrity.runner.results.call.ExceptionResult) aResult)
								.getException()));
			}
		}

		if (!isDryRun()) {
			if (isFork()) {
				sendElementToMaster(TestRunnerCallbackMethods.CALL_FINISH, tempCallResultElement);
			}
			internalOnCallFinish(tempCallResultElement);
		}
	}

	/**
	 * Internal version of {@link #onCallFinish(Call, CallResult)}.
	 * 
	 * @param aCallResultElement
	 *            the a call result element
	 */
	protected void internalOnCallFinish(Element aCallResultElement) {
		if (aCallResultElement != null) {
			currentElement.peek().addContent(aCallResultElement);
		}

		currentElement.pop();
	}

	@Override
	public void onTearDownStart(SuiteDefinition aTearDownSuite) {
		Element tempTearDownElement = new Element(SUITE_ELEMENT);
		addId(tempTearDownElement);
		addLineNumber(tempTearDownElement, aTearDownSuite);
		tempTearDownElement.setAttribute(SUITE_NAME_ATTRIBUTE, IntegrityDSLUtil.getQualifiedSuiteName(aTearDownSuite));
		tempTearDownElement.addContent(new Element(VARIABLE_DEFINITION_COLLECTION_ELEMENT));
		tempTearDownElement.addContent(new Element(STATEMENT_COLLECTION_ELEMENT));

		if (!isDryRun()) {
			if (isFork()) {
				sendElementToMaster(TestRunnerCallbackMethods.TEAR_DOWN_START, tempTearDownElement);
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
		currentElement.peek().getChild(TEARDOWN_COLLECTION_ELEMENT).addContent(aTearDownElement);
		currentElement.push(aTearDownElement);
	}

	@Override
	public void onTearDownFinish(SuiteDefinition aTearDownSuite, SuiteResult aResult) {
		Element tempSuiteResultElement = new Element(RESULT_ELEMENT);
		if (aResult != null) {
			tempSuiteResultElement.setAttribute(EXECUTION_DURATION_ATTRIBUTE,
					nanoTimeToString(aResult.getExecutionTime()));
			tempSuiteResultElement.setAttribute(SUCCESS_COUNT_ATTRIBUTE,
					Integer.toString(aResult.getTestSuccessCount()));
			tempSuiteResultElement.setAttribute(FAILURE_COUNT_ATTRIBUTE, Integer.toString(aResult.getTestFailCount()));
			tempSuiteResultElement.setAttribute(EXCEPTION_COUNT_ATTRIBUTE,
					Integer.toString(aResult.getTestExceptionCount()));
		}

		if (!isDryRun()) {
			if (isFork()) {
				sendElementToMaster(TestRunnerCallbackMethods.TEAR_DOWN_FINISH, tempSuiteResultElement);
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
		currentElement.pop().addContent(aSuiteResultElement);
	}

	@Override
	public void onSuiteFinish(Suite aSuite, SuiteSummaryResult aResult) {
		Element tempSuiteResultElement = new Element(RESULT_ELEMENT);
		if (aResult != null) {
			tempSuiteResultElement.setAttribute(EXECUTION_DURATION_ATTRIBUTE,
					nanoTimeToString(aResult.getExecutionTime()));
			tempSuiteResultElement.setAttribute(SUCCESS_COUNT_ATTRIBUTE,
					Integer.toString(aResult.getTestSuccessCount()));
			tempSuiteResultElement.setAttribute(FAILURE_COUNT_ATTRIBUTE, Integer.toString(aResult.getTestFailCount()));
			tempSuiteResultElement.setAttribute(EXCEPTION_COUNT_ATTRIBUTE,
					Integer.toString(aResult.getTestExceptionCount()));
		}

		if (!isDryRun()) {
			if (isFork()) {
				sendElementToMaster(TestRunnerCallbackMethods.SUITE_FINISH, tempSuiteResultElement);
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
		currentElement.pop().addContent(aSuiteResultElement);
	}

	@Override
	public void onExecutionFinish(TestModel aModel, SuiteSummaryResult aResult) {
		currentElement.pop().setAttribute(TEST_RUN_DURATION, nanoTimeToString(System.nanoTime() - executionStartTime));

		if (!isFork()) {
			FileOutputStream tempOutputStream;
			try {
				tempOutputStream = new FileOutputStream(outputFile);
			} catch (FileNotFoundException exc) {
				exc.printStackTrace();
				return;
			}

			try {
				if (transformHandling == TransformHandling.EXECUTE_TRANSFORM) {
					// Transform the XML to XHTML and output that (this actually contains a copy of the original XML
					// result tree in an invisible element!)
					try {
						if (System.getProperty("javax.xml.transform.TransformerFactory") == null) {
							// Explicitly specify the JRE-bundled XSLT transformer if nothing else was specified via the
							// system property, so we at least know for sure what to expect
							System.setProperty("javax.xml.transform.TransformerFactory",
									"com.sun.org.apache.xalan.internal.xsltc.trax.TransformerFactoryImpl");
						}
						TransformerFactory tempTransformerFactory = TransformerFactory.newInstance();

						Transformer tempTransformer = tempTransformerFactory.newTransformer(new StreamSource(
								getXsltStream()));
						tempTransformer.setOutputProperty(OutputKeys.METHOD, "html");
						tempTransformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

						Source tempSource = new JDOMSource(document);

						/*
						 * There is a problem with the XML source data that is copied to the transformed HTML result
						 * (into the "xmldata" element): since the output method for the serializer is set to HTML, it
						 * seems to inevitably output '<' and '>' in attributes as characters, which is no problem for
						 * HTML, but strict XML requires those to be replaced by their corresponding entities. I could
						 * solve this by outputting strict XML, but that renders the output unrenderable by browsers :-(
						 * well, for some reason I don't fully understand at least, I'm no browser developer. To solve
						 * this, the following very ugly hack replaces the characters by their entities in all attribute
						 * values inside the xmldata section on a character stream level. That makes the xmldata content
						 * valid XML and thus conveniently parseable for example by a SAX parser (just be sure to stop
						 * the parsing when reaching the end of that section, because the HTML afterwards definitely
						 * doesn't parse as XML!), while keeping viewability on all browsers. It should not have any
						 * negative side-effects, apart from being disgusting and everything, but well, this can still
						 * be replaced by a more elegant solution if someone comes up with one.
						 */
						StreamResult tempResult = new StreamResult(new FilterOutputStream(tempOutputStream) {

							private static final String TAG_START = "<xmldata";

							private static final String TAG_END = "</xmldata>";

							private static final char TRIGGER_TAG = '<';

							private static final char TRIGGER_ATTRIBUTE = '"';

							private boolean insideXmlPart;

							private boolean insideAttribute;

							private boolean pastXmlPart;

							private StringBuilder buffer = new StringBuilder();

							@Override
							public void write(int aByte) throws IOException {
								char tempChar = (char) aByte;

								if (!pastXmlPart) {
									if (!insideAttribute) {
										if (tempChar == TRIGGER_TAG) {
											buffer.setLength(0);
											buffer.append(tempChar);
										} else if (insideXmlPart && tempChar == TRIGGER_ATTRIBUTE) {
											insideAttribute = true;
										} else {
											buffer.append(tempChar);
											if (insideXmlPart) {
												if (TAG_END.equals(buffer.toString())) {
													insideXmlPart = false;
													pastXmlPart = true;
													buffer.setLength(0);
												}
											} else {
												if (TAG_START.equals(buffer.toString())) {
													insideXmlPart = true;
													buffer.setLength(0);
												}
											}
										}
									} else {
										if (insideXmlPart) {
											if (tempChar == TRIGGER_ATTRIBUTE) {
												insideAttribute = false;
											} else {
												if (tempChar == '<') {
													super.write("&lt;".getBytes("UTF-8"));
													return;
												} else if (tempChar == '>') {
													super.write("&gt;".getBytes("UTF-8"));
													return;
												}
											}
										}
									}
								}

								super.write(aByte);
							}
						});

						tempTransformer.transform(tempSource, tempResult);
					} catch (TransformerConfigurationException exc) {
						exc.printStackTrace();
					} catch (TransformerException exc) {
						exc.printStackTrace();
					}
				} else {
					// Output the XML (with XSLT inlined or not)
					XMLOutputter tempSerializer = new XMLOutputter(Format.getPrettyFormat());
					tempSerializer.output(document, tempOutputStream);
				}
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

	@Override
	public void onVariableDefinition(VariableEntity aDefinition, SuiteDefinition aSuite, Object anInitialValue) {
		onVariableDefinitionInternal(aDefinition, aSuite, anInitialValue);
	}

	@Override
	public void onConstantDefinition(ConstantEntity aDefinition, SuiteDefinition aSuite, Object aValue,
			boolean aParameterizedFlag) {
		// constants are handled like variables (for now...)
		onVariableDefinitionInternal(aDefinition, aSuite, aValue);
	}

	private void onVariableDefinitionInternal(VariableOrConstantEntity aDefinition, SuiteDefinition aSuite,
			Object anInitialValue) {
		Element tempVariableElement = new Element(VARIABLE_ELEMENT);
		tempVariableElement.setAttribute(VARIABLE_NAME_ATTRIBUTE,
				IntegrityDSLUtil.getQualifiedVariableEntityName(aDefinition, false));
		if (anInitialValue != null) {
			tempVariableElement.setAttribute(VARIABLE_VALUE_ATTRIBUTE, valueConverter.convertValueToString(
					anInitialValue, false, UnresolvableVariableHandling.RESOLVE_TO_NULL_STRING));
		}

		if (!isDryRun()) {
			if (isFork()) {
				sendElementToMaster(TestRunnerCallbackMethods.VARIABLE_DEFINITION, tempVariableElement);
			}
			internalOnVariableDefinition(tempVariableElement);
		}
	}

	/**
	 * Internal version of {@link #onVariableDefinition(VariableEntity, SuiteDefinition, Object)}.
	 * 
	 * @param aVariableElement
	 *            the a variable element
	 */
	protected void internalOnVariableDefinition(Element aVariableElement) {
		Element tempCollectionElement = currentElement.peek().getChild(VARIABLE_DEFINITION_COLLECTION_ELEMENT);
		tempCollectionElement.addContent(aVariableElement);
	}

	/**
	 * The pattern for URL detection.
	 */
	protected static final Pattern URL_PATTERN = Pattern.compile("(.*?)(\\w+://\\S+)(.*)");

	/**
	 * Parses a comment into a list of {@link Content} elements. This takes care of URLs embedded in the comment.
	 */
	protected List<Content> parseComment(String aCommment) {
		List<Content> tempList = new ArrayList<Content>();

		String tempTextLeft = aCommment;
		Matcher tempMatcher = URL_PATTERN.matcher(tempTextLeft);
		while (tempMatcher.matches()) {
			String tempPrefix = tempMatcher.group(1);
			String tempUrl = tempMatcher.group(2);
			String tempSuffix = tempMatcher.group(3);

			if (tempPrefix != null && tempPrefix.length() > 0) {
				tempList.add(new Text(tempPrefix));
			}

			Element tempAnchorElement = new Element("a");
			tempAnchorElement.setAttribute("href", tempUrl);
			tempAnchorElement.setText(tempUrl);
			tempList.add(tempAnchorElement);

			tempTextLeft = tempSuffix;
			tempMatcher = URL_PATTERN.matcher(tempTextLeft);
		}

		if (tempTextLeft != null && tempTextLeft.length() > 0) {
			tempList.add(new Text(tempTextLeft));
		}

		return tempList;
	}

	@Override
	public void onVisibleComment(String aCommentText, VisibleComment aCommentElement) {
		Element tempCommentElement = new Element(COMMENT_ELEMENT);
		addId(tempCommentElement);
		addLineNumber(tempCommentElement, aCommentElement);
		tempCommentElement.addContent(parseComment(aCommentText));

		if (!isDryRun()) {
			if (isFork()) {
				sendElementToMaster(TestRunnerCallbackMethods.VISIBLE_COMMENT, tempCommentElement);
			}
			internalOnVisibleComment(tempCommentElement);
		}
	}

	@Override
	public void onVisibleDivider(String aDividerText, VisibleDivider aDividerElement) {
		Element tempCommentElement = new Element(DIVIDER_ELEMENT);
		addId(tempCommentElement);
		addLineNumber(tempCommentElement, aDividerElement);
		tempCommentElement.setAttribute(DIVIDER_TEXT_ATTRIBUTE, aDividerText);

		if (!isDryRun()) {
			if (isFork()) {
				sendElementToMaster(TestRunnerCallbackMethods.VISIBLE_DIVIDER, tempCommentElement);
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
		Element tempCollectionElement = currentElement.peek().getChild(STATEMENT_COLLECTION_ELEMENT);
		tempCollectionElement.addContent(aCommentElement);
	}

	/**
	 * Internal version of {@link #onVisibleDivider(String)}.
	 * 
	 * @param aDividerElement
	 *            the divider element
	 */
	protected void internalOnVisibleDivider(Element aDividerElement) {
		Element tempCollectionElement = currentElement.peek().getChild(STATEMENT_COLLECTION_ELEMENT);
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
	 * @param anElement
	 *            the element to send
	 */
	protected void sendElementToMaster(TestRunnerCallbackMethods aMethod, Element anElement) {
		sendToMaster(aMethod, (Serializable) anElement.clone());
	}

	@Override
	public void onMessageFromFork(TestRunnerCallbackMethods aMethod, Serializable... someObjects) {
		Element tempElement = (Element) someObjects[0];

		// dispatch message to matching internal... method
		switch (aMethod) {
		case SUITE_START:
			internalOnSuiteStart(tempElement);
			break;
		case SETUP_START:
			internalOnSetupStart(tempElement);
			break;
		case SETUP_FINISH:
			internalOnSetupFinish(tempElement);
			break;
		case TEST_START:
			internalOnTestStart(tempElement);
			break;
		case TABLE_TEST_START:
			internalOnTableTestStart(tempElement);
			break;
		case TEST_FINISH:
			internalOnTableTestFinish(tempElement);
			break;
		case TABLE_TEST_FINISH:
			internalOnTableTestFinish(tempElement);
			break;
		case CALL_START:
			internalOnCallStart(tempElement);
			break;
		case CALL_FINISH:
			internalOnCallFinish(tempElement);
			break;
		case TEAR_DOWN_START:
			internalOnTearDownStart(tempElement);
			break;
		case TEAR_DOWN_FINISH:
			internalOnTearDownFinish(tempElement);
			break;
		case SUITE_FINISH:
			internalOnSuiteFinish(tempElement);
			break;
		case VARIABLE_DEFINITION:
			internalOnVariableDefinition(tempElement);
			break;
		case VISIBLE_COMMENT:
			internalOnVisibleComment(tempElement);
			break;
		case VISIBLE_DIVIDER:
			internalOnVisibleDivider(tempElement);
			break;
		default:
			return;
		}
	}

	/**
	 * Adds the ID attribute to the element and increments the ID counter for the next element.
	 * 
	 * @param anElement
	 *            the element to add an ID to
	 */
	protected void addId(Element anElement) {
		anElement.setAttribute(ID_ATTRIBUTE, Long.toString(idCounter));
		idCounter++;
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
			anElement.setAttribute(LINE_NUMBER_ATTRIBUTE, Integer.toString(tempLine));
		}
	}
}

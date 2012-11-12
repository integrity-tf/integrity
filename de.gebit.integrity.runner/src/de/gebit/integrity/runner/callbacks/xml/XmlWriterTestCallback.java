package de.gebit.integrity.runner.callbacks.xml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;

import org.jdom.DocType;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.ProcessingInstruction;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import de.gebit.integrity.dsl.Call;
import de.gebit.integrity.dsl.MethodReference;
import de.gebit.integrity.dsl.Parameter;
import de.gebit.integrity.dsl.Suite;
import de.gebit.integrity.dsl.SuiteDefinition;
import de.gebit.integrity.dsl.TableTest;
import de.gebit.integrity.dsl.TableTestRow;
import de.gebit.integrity.dsl.Test;
import de.gebit.integrity.dsl.ValueOrEnumValueOrOperationCollection;
import de.gebit.integrity.dsl.VariableEntity;
import de.gebit.integrity.dsl.VariantDefinition;
import de.gebit.integrity.operations.OperationWrapper.UnexecutableException;
import de.gebit.integrity.remoting.transport.enums.TestRunnerCallbackMethods;
import de.gebit.integrity.runner.TestModel;
import de.gebit.integrity.runner.callbacks.CallbackCapabilities;
import de.gebit.integrity.runner.callbacks.TestFormatter;
import de.gebit.integrity.runner.callbacks.TestRunnerCallback;
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
public class XmlWriterTestCallback extends TestRunnerCallback {

	/**
	 * The classloader to use.
	 */
	private ClassLoader classLoader;

	/**
	 * The test formatter to use when creating test/call descriptions.
	 */
	private TestFormatter formatter;

	/**
	 * The capability object.
	 */
	private CallbackCapabilities capabilities;

	/**
	 * The XML document that will be created.
	 */
	private Document document;

	/**
	 * The file in which to serialize the document.
	 */
	private File outputFile;

	/**
	 * The title of the result document.
	 */
	private String title;

	/**
	 * The timestamp of execution start.
	 */
	private long executionStartTime;

	/**
	 * Counter used to generate unique IDs for a lot of XML elements.
	 */
	private long idCounter;

	/**
	 * Whether the XSLT transformation script that transforms the XML result data into a viewable XHTML document shall
	 * be embedded into the result.
	 */
	private boolean embedXhtmlTransform;

	/**
	 * The stack of elements.
	 */
	private Stack<Element> currentElement = new Stack<Element>();

	/** The Constant ROOT_ELEMENT. */
	private static final String ROOT_ELEMENT = "integrity";

	/** The Constant TEST_RUN_NAME_ATTRIBUTE. */
	private static final String TEST_RUN_NAME_ATTRIBUTE = "name";

	/** The Constant TEST_RUN_TIMESTAMP. */
	private static final String TEST_RUN_TIMESTAMP = "timestamp";

	/** The Constant TEST_RUN_TIMESTAMP_ISO8601. */
	private static final String TEST_RUN_TIMESTAMP_ISO8601 = "isotimestamp";

	/** The Constant TEST_RUN_DURATION. */
	private static final String TEST_RUN_DURATION = "duration";

	/** The Constant VARIANT_ELEMENT. */
	private static final String VARIANT_ELEMENT = "variant";

	/** The Constant VARIANT_NAME_ATTRIBUTE. */
	private static final String VARIANT_NAME_ATTRIBUTE = "name";

	/** The Constant VARIANT_DESCRIPTION_ATTRIBUTE. */
	private static final String VARIANT_DESCRIPTION_ATTRIBUTE = "description";

	/** The Constant SUITE_ELEMENT. */
	private static final String SUITE_ELEMENT = "suite";

	/** The Constant SUITE_NAME_ATTRIBUTE. */
	private static final String SUITE_NAME_ATTRIBUTE = "name";

	/** The Constant VARIABLE_DEFINITION_COLLECTION_ELEMENT. */
	private static final String VARIABLE_DEFINITION_COLLECTION_ELEMENT = "variables";

	/** The Constant STATEMENT_COLLECTION_ELEMENT. */
	private static final String STATEMENT_COLLECTION_ELEMENT = "statements";

	/** The Constant SETUP_COLLECTION_ELEMENT. */
	private static final String SETUP_COLLECTION_ELEMENT = "setup";

	/** The Constant TEARDOWN_COLLECTION_ELEMENT. */
	private static final String TEARDOWN_COLLECTION_ELEMENT = "teardown";

	/** The Constant TEST_ELEMENT. */
	private static final String TEST_ELEMENT = "test";

	/** The Constant TABLETEST_ELEMENT. */
	private static final String TABLETEST_ELEMENT = "tabletest";

	/** The Constant CALL_ELEMENT. */
	private static final String CALL_ELEMENT = "call";

	/** The Constant RESULT_ELEMENT. */
	private static final String RESULT_ELEMENT = "result";

	/** The Constant RESULT_COLLECTION_ELEMENT. */
	private static final String RESULT_COLLECTION_ELEMENT = "results";

	/** The Constant VARIABLE_UPDATE_ELEMENT. */
	private static final String VARIABLE_UPDATE_ELEMENT = "variableUpdate";

	/** The Constant VARIABLE_UPDATE_PARAMETER_NAME_ATTRIBUTE. */
	private static final String VARIABLE_UPDATE_PARAMETER_NAME_ATTRIBUTE = "parameter";

	/** The Constant COMPARISON_ELEMENT. */
	private static final String COMPARISON_ELEMENT = "comparison";

	/** The Constant COMPARISON_COLLECTION_ELEMENT. */
	private static final String COMPARISON_COLLECTION_ELEMENT = "comparisons";

	/** The Constant COMPARISON_NAME_ATTRIBUTE. */
	private static final String COMPARISON_NAME_ATTRIBUTE = "name";

	/** The Constant VARIABLE_NAME_ATTRIBUTE. */
	private static final String VARIABLE_NAME_ATTRIBUTE = "name";

	/** The Constant VARIABLE_ELEMENT. */
	private static final String VARIABLE_ELEMENT = "variable";

	/** The Constant COMMENT_ELEMENT. */
	private static final String COMMENT_ELEMENT = "comment";

	/** The Constant COMMENT_TEXT_ATTRIBUTE. */
	private static final String COMMENT_TEXT_ATTRIBUTE = "text";

	/** The Constant DIVIDER_ELEMENT. */
	private static final String DIVIDER_ELEMENT = "divider";

	/** The Constant DIVIDER_TEXT_ATTRIBUTE. */
	private static final String DIVIDER_TEXT_ATTRIBUTE = "text";

	/** The Constant PARAMETER_COLLECTION_ELEMENT. */
	private static final String PARAMETER_COLLECTION_ELEMENT = "parameters";

	/** The Constant PARAMETER_ELEMENT. */
	private static final String PARAMETER_ELEMENT = "parameter";

	/** The Constant PARAMETER_NAME_ATTRIBUTE. */
	private static final String PARAMETER_NAME_ATTRIBUTE = "name";

	/** The Constant PARAMETER_VALUE_ATTRIBUTE. */
	private static final String PARAMETER_VALUE_ATTRIBUTE = "value";

	/** The Constant VARIABLE_VALUE_ATTRIBUTE. */
	private static final String VARIABLE_VALUE_ATTRIBUTE = "value";

	/** The Constant RESULT_EXPECTED_VALUE_ATTRIBUTE. */
	private static final String RESULT_EXPECTED_VALUE_ATTRIBUTE = "expectedValue";

	/** The Constant RESULT_REAL_VALUE_ATTRIBUTE. */
	private static final String RESULT_REAL_VALUE_ATTRIBUTE = "value";

	/** The Constant RESULT_TYPE_ATTRIBUTE. */
	private static final String RESULT_TYPE_ATTRIBUTE = "type";

	/** The Constant RESULT_TYPE_SUCCESS. */
	private static final String RESULT_TYPE_SUCCESS = "success";

	/** The Constant RESULT_TYPE_FAILURE. */
	private static final String RESULT_TYPE_FAILURE = "failure";

	/** The Constant RESULT_TYPE_EXCEPTION. */
	private static final String RESULT_TYPE_EXCEPTION = "exception";

	/** The Constant RESULT_EXCEPTION_MESSAGE_ATTRIBUTE. */
	private static final String RESULT_EXCEPTION_MESSAGE_ATTRIBUTE = "exceptionMessage";

	/** The Constant RESULT_EXCEPTION_TRACE_ATTRIBUTE. */
	private static final String RESULT_EXCEPTION_TRACE_ATTRIBUTE = "exceptionTrace";

	/** The Constant EXECUTION_DURATION_ATTRIBUTE. */
	private static final String EXECUTION_DURATION_ATTRIBUTE = "duration";

	/** The Constant SUCCESS_COUNT_ATTRIBUTE. */
	private static final String SUCCESS_COUNT_ATTRIBUTE = "successCount";

	/** The Constant FAILURE_COUNT_ATTRIBUTE. */
	private static final String FAILURE_COUNT_ATTRIBUTE = "failureCount";

	/** The Constant EXCEPTION_COUNT_ATTRIBUTE. */
	private static final String EXCEPTION_COUNT_ATTRIBUTE = "exceptionCount";

	/** The Constant FIXTURE_DESCRIPTION_ATTRIBUTE. */
	private static final String FIXTURE_DESCRIPTION_ATTRIBUTE = "description";

	/** The Constant TEST_NAME_ELEMENT. */
	private static final String TEST_NAME_ELEMENT = "name";

	/** The Constant CALL_NAME_ELEMENT. */
	private static final String CALL_NAME_ELEMENT = "name";

	/** The Constant FIXTURE_METHOD_ATTRIBUTE. */
	private static final String FIXTURE_METHOD_ATTRIBUTE = "fixture";

	/** The Constant FORK_NAME_ATTRIBUTE. */
	private static final String FORK_NAME_ATTRIBUTE = "forkName";

	/** The Constant FORK_DESCRIPTION_ATTRIBUTE. */
	private static final String FORK_DESCRIPTION_ATTRIBUTE = "forkDescription";

	/** The Constant ID_ATTRIBUTE. */
	private static final String ID_ATTRIBUTE = "id";

	/**
	 * The time format used to format execution times.
	 */
	private static final DecimalFormat EXECUTION_TIME_FORMAT = new DecimalFormat("0.000");

	/**
	 * The generally used date format.
	 */
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat();

	/**
	 * The ISO-standardized date format (this is mostly added to the XML to allow for easy transformation into a
	 * JUnit-compatible result XML.
	 */
	private static final SimpleDateFormat ISO_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

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
	 * @param anEmbedXhtmlTransformFlag
	 *            whether an XSLT script which transforms the raw result data into viewable XHTML shall be included
	 */
	public XmlWriterTestCallback(ClassLoader aClassLoader, File anOutputFile, String aTitle,
			boolean anEmbedXhtmlTransformFlag) {
		classLoader = aClassLoader;
		outputFile = anOutputFile;
		title = aTitle;
		embedXhtmlTransform = anEmbedXhtmlTransformFlag;
	}

	/**
	 * On execution start.
	 * 
	 * @param aModel
	 *            the a model
	 * @param aVariant
	 *            the a variant
	 * @param aVariableMap
	 *            the a variable map
	 */
	@Override
	public void onExecutionStart(TestModel aModel, VariantDefinition aVariant, CallbackCapabilities aCapabilityObject) {
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

		if (!isFork() && embedXhtmlTransform) {
			try {
				Document tempTransform = new SAXBuilder().build(getClass().getClassLoader().getResourceAsStream(
						"resource/xhtml.xslt"));
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

		capabilities = aCapabilityObject;
		formatter = new TestFormatter(classLoader, capabilities);
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

	/**
	 * On test start.
	 * 
	 * @param aTest
	 *            the a test
	 */
	@Override
	public void onTestStart(Test aTest) {
		Element tempTestElement = new Element(TEST_ELEMENT);
		addId(tempTestElement);
		tempTestElement.setAttribute(TEST_NAME_ELEMENT, aTest.getDefinition().getName());
		try {
			tempTestElement.setAttribute(FIXTURE_DESCRIPTION_ATTRIBUTE,
					formatter.testToHumanReadableString(aTest, capabilities.getVariableMap()));
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

	/**
	 * On table test start.
	 * 
	 * @param aTest
	 *            the a test
	 */
	@Override
	public void onTableTestStart(TableTest aTest) {
		Element tempTestElement = new Element(TABLETEST_ELEMENT);
		addId(tempTestElement);
		tempTestElement.setAttribute(TEST_NAME_ELEMENT, aTest.getDefinition().getName());
		try {
			tempTestElement.setAttribute(FIXTURE_DESCRIPTION_ATTRIBUTE,
					formatter.tableTestToHumanReadableString(aTest, capabilities.getVariableMap()));
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
			tempParameterMap = capabilities.getParameterResolver().createParameterMap(aTest,
					capabilities.getVariableMap(), classLoader, capabilities.getValueConverter(), true, false);
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
			Map<String, Object> tempParameterMap = new HashMap<String, Object>();
			try {
				tempParameterMap = capabilities.getParameterResolver().createParameterMap(aTableTest, aRow,
						capabilities.getVariableMap(), classLoader, capabilities.getValueConverter(), true, false);
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
			tempParameterElement.setAttribute(PARAMETER_VALUE_ATTRIBUTE, capabilities.getValueConverter()
					.convertValueToString(tempEntry.getValue(), capabilities.getVariableMap(), classLoader, false));
			tempParameterCollectionElement.addContent(tempParameterElement);
		}
		tempTestResultElement.addContent(tempParameterCollectionElement);

		try {
			tempTestResultElement.setAttribute(FIXTURE_DESCRIPTION_ATTRIBUTE,
					formatter.fixtureMethodToHumanReadableString(aMethod, aParameterMap, true));
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
				tempComparisonResultElement.setAttribute(
						RESULT_EXPECTED_VALUE_ATTRIBUTE,
						capabilities.getValueConverter().convertValueToString(
								(tempExpectedValue == null ? true : tempExpectedValue), capabilities.getVariableMap(),
								classLoader, false));
				if (tempEntry.getValue().getResult() != null) {
					tempComparisonResultElement.setAttribute(
							RESULT_REAL_VALUE_ATTRIBUTE,
							capabilities.getValueConverter().convertValueToString(tempEntry.getValue().getResult(),
									capabilities.getVariableMap(), classLoader, false));
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

	/**
	 * On call start.
	 * 
	 * @param aCall
	 *            the a call
	 */
	@Override
	public void onCallStart(Call aCall) {
		Element tempCallElement = new Element(CALL_ELEMENT);
		addId(tempCallElement);
		tempCallElement.setAttribute(CALL_NAME_ELEMENT, aCall.getDefinition().getName());
		try {
			tempCallElement.setAttribute(FIXTURE_DESCRIPTION_ATTRIBUTE,
					formatter.callToHumanReadableString(aCall, capabilities.getVariableMap()));
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
			tempParameterElement.setAttribute(PARAMETER_VALUE_ATTRIBUTE, capabilities.getValueConverter()
					.convertValueToString(tempParameter.getValue(), capabilities.getVariableMap(), classLoader, false));

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
							capabilities.getValueConverter().convertValueToString(tempUpdatedVariable.getValue(),
									capabilities.getVariableMap(), classLoader, false));
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
		currentElement.pop().setAttribute(TEST_RUN_DURATION, nanoTimeToString(System.nanoTime() - executionStartTime));

		FileOutputStream tempOutputStream;
		try {
			tempOutputStream = new FileOutputStream(outputFile);
		} catch (FileNotFoundException exc) {
			exc.printStackTrace();
			return;
		}
		XMLOutputter tempSerializer = new XMLOutputter(Format.getPrettyFormat());
		try {
			tempSerializer.output(document, tempOutputStream);
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
		Element tempVariableElement = new Element(VARIABLE_ELEMENT);
		tempVariableElement.setAttribute(VARIABLE_NAME_ATTRIBUTE,
				IntegrityDSLUtil.getQualifiedVariableEntityName(aDefinition, false));
		if (anInitialValue != null) {
			tempVariableElement.setAttribute(VARIABLE_VALUE_ATTRIBUTE, capabilities.getValueConverter()
					.convertValueToString(anInitialValue, capabilities.getVariableMap(), classLoader, false));
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
	 * On visible comment.
	 * 
	 * @param aCommentText
	 *            the a comment text
	 */
	@Override
	public void onVisibleComment(String aCommentText) {
		Element tempCommentElement = new Element(COMMENT_ELEMENT);
		addId(tempCommentElement);
		tempCommentElement.setAttribute(COMMENT_TEXT_ATTRIBUTE, aCommentText);

		if (!isDryRun()) {
			if (isFork()) {
				sendElementToMaster(TestRunnerCallbackMethods.VISIBLE_COMMENT, tempCommentElement);
			}
			internalOnVisibleComment(tempCommentElement);
		}
	}

	@Override
	public void onVisibleDivider(String aDividerText) {
		Element tempCommentElement = new Element(DIVIDER_ELEMENT);
		addId(tempCommentElement);
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
}

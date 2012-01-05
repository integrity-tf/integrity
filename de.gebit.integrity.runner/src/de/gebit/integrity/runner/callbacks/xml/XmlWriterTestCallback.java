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
import de.gebit.integrity.dsl.VariableEntity;
import de.gebit.integrity.remoting.transport.enums.TestRunnerCallbackMethods;
import de.gebit.integrity.runner.TestModel;
import de.gebit.integrity.runner.callbacks.TestRunnerCallback;
import de.gebit.integrity.runner.results.SuiteResult;
import de.gebit.integrity.runner.results.call.CallResult;
import de.gebit.integrity.runner.results.test.TestComparisonFailureResult;
import de.gebit.integrity.runner.results.test.TestComparisonResult;
import de.gebit.integrity.runner.results.test.TestComparisonSuccessResult;
import de.gebit.integrity.runner.results.test.TestExceptionSubResult;
import de.gebit.integrity.runner.results.test.TestExecutedSubResult;
import de.gebit.integrity.runner.results.test.TestResult;
import de.gebit.integrity.runner.results.test.TestSubResult;
import de.gebit.integrity.utils.IntegrityDSLUtil;
import de.gebit.integrity.utils.ParameterUtil;
import de.gebit.integrity.utils.TestFormatter;

/**
 * Test runner callback which writes to an XML result file. This runner may optionally add an XHTML transform to the
 * file which allows to render the results in a nice, readable layout in any good browser.
 * 
 * 
 * @author Rene Schneider
 * 
 */
public class XmlWriterTestCallback extends TestRunnerCallback {

	private ClassLoader classLoader;

	private TestFormatter formatter;

	private Map<VariableEntity, Object> variableStorage;

	private Document document;

	private File outputFile;

	private String title;

	private long executionStartTime;

	private boolean embedXhtmlTransform;

	private Stack<Element> currentElement = new Stack<Element>();

	private static final String ROOT_ELEMENT = "integrity";

	private static final String TEST_RUN_NAME_ATTRIBUTE = "name";

	private static final String TEST_RUN_TIMESTAMP = "timestamp";

	private static final String TEST_RUN_DURATION = "duration";

	private static final String SUITE_ELEMENT = "suite";

	private static final String SUITE_NAME_ATTRIBUTE = "name";

	private static final String VARIABLE_DEFINITION_COLLECTION_ELEMENT = "variables";

	private static final String STATEMENT_COLLECTION_ELEMENT = "statements";

	private static final String SETUP_COLLECTION_ELEMENT = "setup";

	private static final String TEARDOWN_COLLECTION_ELEMENT = "teardown";

	private static final String TEST_ELEMENT = "test";

	private static final String TABLETEST_ELEMENT = "tabletest";

	private static final String CALL_ELEMENT = "call";

	private static final String RESULT_ELEMENT = "result";

	private static final String RESULT_COLLECTION_ELEMENT = "results";

	private static final String COMPARISON_ELEMENT = "comparison";

	private static final String COMPARISON_COLLECTION_ELEMENT = "comparisons";

	private static final String COMPARISON_NAME_ATTRIBUTE = "name";

	private static final String VARIABLE_NAME_ATTRIBUTE = "name";

	private static final String VARIABLE_ELEMENT = "variable";

	private static final String PARAMETER_COLLECTION_ELEMENT = "parameters";

	private static final String PARAMETER_ELEMENT = "parameter";

	private static final String PARAMETER_NAME_ATTRIBUTE = "name";

	private static final String PARAMETER_VALUE_ATTRIBUTE = "value";

	private static final String VARIABLE_VALUE_ATTRIBUTE = "value";

	private static final String RESULT_EXPECTED_VALUE_ATTRIBUTE = "expectedValue";

	private static final String RESULT_REAL_VALUE_ATTRIBUTE = "value";

	private static final String RESULT_TYPE_ATTRIBUTE = "type";

	private static final String RESULT_TYPE_SUCCESS = "success";

	private static final String RESULT_TYPE_FAILURE = "failure";

	private static final String RESULT_TYPE_EXCEPTION = "exception";

	private static final String RESULT_EXCEPTION_MESSAGE_ATTRIBUTE = "exceptionMessage";

	private static final String RESULT_EXCEPTION_TRACE_ATTRIBUTE = "exceptionTrace";

	private static final String EXECUTION_DURATION_ATTRIBUTE = "duration";

	private static final String SUCCESS_COUNT_ATTRIBUTE = "successCount";

	private static final String FAILURE_COUNT_ATTRIBUTE = "failureCount";

	private static final String EXCEPTION_COUNT_ATTRIBUTE = "exceptionCount";

	private static final String FIXTURE_DESCRIPTION_ATTRIBUTE = "description";

	private static final String TEST_NAME_ELEMENT = "name";

	private static final String CALL_NAME_ELEMENT = "name";

	private static final String FIXTURE_METHOD_ATTRIBUTE = "fixture";

	private static final DecimalFormat EXECUTION_TIME_FORMAT = new DecimalFormat("0.000");

	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat();

	static {
		EXECUTION_TIME_FORMAT.setDecimalFormatSymbols(DecimalFormatSymbols.getInstance(Locale.ENGLISH));
	}

	public XmlWriterTestCallback(ClassLoader aClassLoader, File anOutputFile, String aTitle,
			boolean anEmbedXhtmlTransformFlag) {
		classLoader = aClassLoader;
		formatter = new TestFormatter(classLoader);
		outputFile = anOutputFile;
		title = aTitle;
		embedXhtmlTransform = anEmbedXhtmlTransformFlag;
	}

	@Override
	public void onExecutionStart(TestModel aModel, Map<VariableEntity, Object> aVariableMap) {
		Element tempRootElement = new Element(ROOT_ELEMENT);
		tempRootElement.addContent(new Element(VARIABLE_DEFINITION_COLLECTION_ELEMENT));
		tempRootElement.setAttribute(TEST_RUN_NAME_ATTRIBUTE, title);
		tempRootElement.setAttribute(TEST_RUN_TIMESTAMP, DATE_FORMAT.format(new Date()));
		document = new Document(tempRootElement);
		currentElement.push(tempRootElement);

		if (!isFork() && embedXhtmlTransform) {
			try {
				Document tempTransform = new SAXBuilder().build(getClass().getClassLoader().getResourceAsStream(
						"static/xhtml.xslt"));
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

		variableStorage = aVariableMap;
		executionStartTime = System.nanoTime();
	}

	@Override
	public void onSuiteStart(Suite aSuite) {
		Element tempSuiteElement = new Element(SUITE_ELEMENT);
		tempSuiteElement.setAttribute(SUITE_NAME_ATTRIBUTE,
				IntegrityDSLUtil.getQualifiedSuiteName(aSuite.getDefinition()));
		tempSuiteElement.addContent(new Element(SETUP_COLLECTION_ELEMENT));
		tempSuiteElement.addContent(new Element(VARIABLE_DEFINITION_COLLECTION_ELEMENT));
		tempSuiteElement.addContent(new Element(STATEMENT_COLLECTION_ELEMENT));
		tempSuiteElement.addContent(new Element(TEARDOWN_COLLECTION_ELEMENT));

		if (!isDryRun()) {
			if (isFork()) {
				sendElementToMaster(TestRunnerCallbackMethods.SUITE_START, tempSuiteElement);
			}
			internalOnSuiteStart(tempSuiteElement);
		}
	}

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

	protected void internalOnSetupStart(Element aSetupElement) {
		currentElement.peek().getChild(SETUP_COLLECTION_ELEMENT).addContent(aSetupElement);
		currentElement.push(aSetupElement);
	}

	@Override
	public void onSetupFinish(SuiteDefinition aSetupSuite, SuiteResult aResult) {
		Element tempSuiteResultElement = new Element(RESULT_ELEMENT);
		tempSuiteResultElement.setAttribute(EXECUTION_DURATION_ATTRIBUTE, nanoTimeToString(aResult.getExecutionTime()));
		tempSuiteResultElement.setAttribute(SUCCESS_COUNT_ATTRIBUTE, Integer.toString(aResult.getTestSuccessCount()));
		tempSuiteResultElement.setAttribute(FAILURE_COUNT_ATTRIBUTE, Integer.toString(aResult.getTestFailCount()));
		tempSuiteResultElement.setAttribute(EXCEPTION_COUNT_ATTRIBUTE,
				Integer.toString(aResult.getTestExceptionCount()));

		if (!isDryRun()) {
			if (isFork()) {
				sendElementToMaster(TestRunnerCallbackMethods.SETUP_FINISH, tempSuiteResultElement);
			}
			internalOnSetupFinish(tempSuiteResultElement);
		}
	}

	protected void internalOnSetupFinish(Element aSuiteResultElement) {
		currentElement.pop().addContent(aSuiteResultElement);
	}

	@Override
	public void onTestStart(Test aTest) {
		Element tempTestElement = new Element(TEST_ELEMENT);
		tempTestElement.setAttribute(TEST_NAME_ELEMENT, aTest.getDefinition().getName());
		try {
			tempTestElement.setAttribute(FIXTURE_DESCRIPTION_ATTRIBUTE,
					formatter.testToHumanReadableString(aTest, variableStorage));
		} catch (ClassNotFoundException exc) {
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

	protected void internalOnTestStart(Element aTestElement) {
		Element tempCollectionElement = currentElement.peek().getChild(STATEMENT_COLLECTION_ELEMENT);
		tempCollectionElement.addContent(aTestElement);
		currentElement.push(aTestElement);
	}

	@Override
	public void onTableTestStart(TableTest aTest) {
		Element tempTestElement = new Element(TABLETEST_ELEMENT);
		tempTestElement.setAttribute(TEST_NAME_ELEMENT, aTest.getDefinition().getName());
		try {
			tempTestElement.setAttribute(FIXTURE_DESCRIPTION_ATTRIBUTE,
					formatter.tableTestToHumanReadableString(aTest, variableStorage));
		} catch (ClassNotFoundException exc) {
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

		onAnyKindOfSubTestFinish(aTest.getDefinition().getFixtureMethod(), tempResultCollectionElement, aResult
				.getSubResults().get(0), IntegrityDSLUtil.createParameterMap(aTest, variableStorage, true));

		if (!isDryRun()) {
			if (isFork()) {
				sendElementToMaster(TestRunnerCallbackMethods.TEST_FINISH, tempResultCollectionElement);
			}
			internalOnTestFinish(tempResultCollectionElement);
		}
	}

	protected void internalOnTestFinish(Element aResultCollectionElement) {
		currentElement.pop().addContent(aResultCollectionElement);
	}

	@Override
	public void onTableTestRowStart(TableTest aTableTest, TableTestRow aRow) {
		// nothing to do here
	}

	@Override
	public void onTableTestRowFinish(TableTest aTableTest, TableTestRow aRow, TestSubResult aSubResult) {
		onAnyKindOfSubTestFinish(aTableTest.getDefinition().getFixtureMethod(), currentElement.peek(), aSubResult,
				IntegrityDSLUtil.createParameterMap(aTableTest, aRow, variableStorage, true));
	}

	@Override
	public void onTableTestFinish(TableTest aTableTest, TestResult aResult) {
		Element tempResultCollectionElement = currentElement.pop();
		tempResultCollectionElement.setAttribute(EXECUTION_DURATION_ATTRIBUTE,
				nanoTimeToString(aResult.getExecutionTime()));
		tempResultCollectionElement.setAttribute(SUCCESS_COUNT_ATTRIBUTE,
				Integer.toString(aResult.getSubTestSuccessCount()));
		tempResultCollectionElement.setAttribute(FAILURE_COUNT_ATTRIBUTE,
				Integer.toString(aResult.getSubTestFailCount()));
		tempResultCollectionElement.setAttribute(EXCEPTION_COUNT_ATTRIBUTE,
				Integer.toString(aResult.getSubTestExceptionCount()));

		if (!isDryRun()) {
			if (isFork()) {
				sendElementToMaster(TestRunnerCallbackMethods.TABLE_TEST_FINISH, tempResultCollectionElement);
			}
			internalOnTableTestFinish(tempResultCollectionElement);
		}
	}

	protected void internalOnTableTestFinish(Element aResultCollectionElement) {
		currentElement.pop().addContent(aResultCollectionElement);
	}

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
			tempParameterElement.setAttribute(PARAMETER_VALUE_ATTRIBUTE,
					ParameterUtil.convertValueToString(tempEntry.getValue(), variableStorage, false));
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
			tempTestResultElement.setAttribute(RESULT_EXCEPTION_MESSAGE_ATTRIBUTE,
					((TestExceptionSubResult) aSubResult).getException().getMessage());
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

				tempComparisonResultElement.setAttribute(RESULT_EXPECTED_VALUE_ATTRIBUTE, ParameterUtil
						.convertValueToString(tempEntry.getValue().getExpectedValue(), variableStorage, false));
				if (tempEntry.getValue().getResult() != null) {
					tempComparisonResultElement.setAttribute(RESULT_REAL_VALUE_ATTRIBUTE, ParameterUtil
							.convertValueToString(tempEntry.getValue().getResult(), variableStorage, false));
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
		tempCallElement.setAttribute(CALL_NAME_ELEMENT, aCall.getDefinition().getName());
		try {
			tempCallElement.setAttribute(FIXTURE_DESCRIPTION_ATTRIBUTE,
					formatter.callToHumanReadableString(aCall, variableStorage));
		} catch (ClassNotFoundException exc) {
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
			tempParameterElement.setAttribute(PARAMETER_VALUE_ATTRIBUTE,
					ParameterUtil.convertValueToString(tempParameter.getValue(), variableStorage, false));

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
				tempCallResultElement.setAttribute(RESULT_REAL_VALUE_ATTRIBUTE,
						ParameterUtil.convertValueToString(aResult, variableStorage, false));
				if (tempResult.getTargetVariable() != null) {
					tempCallResultElement.setAttribute(VARIABLE_NAME_ATTRIBUTE, tempResult.getTargetVariable()
							.getName());
				}
			} else if (aResult instanceof de.gebit.integrity.runner.results.call.ExceptionResult) {
				tempCallResultElement.setAttribute(RESULT_TYPE_ATTRIBUTE, RESULT_TYPE_EXCEPTION);
				tempCallResultElement.setAttribute(RESULT_EXCEPTION_MESSAGE_ATTRIBUTE,
						((de.gebit.integrity.runner.results.call.ExceptionResult) aResult).getException().getMessage());
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

	protected void internalOnCallFinish(Element aCallResultElement) {
		if (aCallResultElement != null) {
			currentElement.peek().addContent(aCallResultElement);
		}

		currentElement.pop();
	}

	@Override
	public void onTearDownStart(SuiteDefinition aTearDownSuite) {
		Element tempTearDownElement = new Element(SUITE_ELEMENT);
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

	protected void internalOnTearDownStart(Element aTearDownElement) {
		currentElement.peek().getChild(TEARDOWN_COLLECTION_ELEMENT).addContent(aTearDownElement);
		currentElement.push(aTearDownElement);
	}

	@Override
	public void onTearDownFinish(SuiteDefinition aTearDownSuite, SuiteResult aResult) {
		Element tempSuiteResultElement = new Element(RESULT_ELEMENT);
		tempSuiteResultElement.setAttribute(EXECUTION_DURATION_ATTRIBUTE, nanoTimeToString(aResult.getExecutionTime()));
		tempSuiteResultElement.setAttribute(SUCCESS_COUNT_ATTRIBUTE, Integer.toString(aResult.getTestSuccessCount()));
		tempSuiteResultElement.setAttribute(FAILURE_COUNT_ATTRIBUTE, Integer.toString(aResult.getTestFailCount()));
		tempSuiteResultElement.setAttribute(EXCEPTION_COUNT_ATTRIBUTE,
				Integer.toString(aResult.getTestExceptionCount()));

		if (!isDryRun()) {
			if (isFork()) {
				sendElementToMaster(TestRunnerCallbackMethods.TEAR_DOWN_FINISH, tempSuiteResultElement);
			}
			internalOnTearDownFinish(tempSuiteResultElement);
		}
	}

	protected void internalOnTearDownFinish(Element aSuiteResultElement) {
		currentElement.pop().addContent(aSuiteResultElement);
	}

	@Override
	public void onSuiteFinish(Suite aSuite, SuiteResult aResult) {
		Element tempSuiteResultElement = new Element(RESULT_ELEMENT);
		tempSuiteResultElement.setAttribute(EXECUTION_DURATION_ATTRIBUTE, nanoTimeToString(aResult.getExecutionTime()));
		tempSuiteResultElement.setAttribute(SUCCESS_COUNT_ATTRIBUTE, Integer.toString(aResult.getTestSuccessCount()));
		tempSuiteResultElement.setAttribute(FAILURE_COUNT_ATTRIBUTE, Integer.toString(aResult.getTestFailCount()));
		tempSuiteResultElement.setAttribute(EXCEPTION_COUNT_ATTRIBUTE,
				Integer.toString(aResult.getTestExceptionCount()));

		if (!isDryRun()) {
			if (isFork()) {
				sendElementToMaster(TestRunnerCallbackMethods.SUITE_FINISH, tempSuiteResultElement);
			}
			internalOnSuiteFinish(tempSuiteResultElement);
		}
	}

	protected void internalOnSuiteFinish(Element aSuiteResultElement) {
		currentElement.pop().addContent(aSuiteResultElement);
	}

	@Override
	public void onExecutionFinish(TestModel aModel, SuiteResult aResult) {
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

	@Override
	public void onVariableDefinition(VariableEntity aDefinition, SuiteDefinition aSuite, Object anInitialValue) {
		Element tempVariableElement = new Element(VARIABLE_ELEMENT);
		tempVariableElement.setAttribute(VARIABLE_NAME_ATTRIBUTE,
				IntegrityDSLUtil.getQualifiedGlobalVariableName(aDefinition));
		if (anInitialValue != null) {
			tempVariableElement.setAttribute(VARIABLE_VALUE_ATTRIBUTE,
					ParameterUtil.convertValueToString(anInitialValue, variableStorage, false));
		}

		if (!isDryRun()) {
			if (isFork()) {
				sendElementToMaster(TestRunnerCallbackMethods.VARIABLE_DEFINITION, tempVariableElement);
			}
			internalOnVariableDefinition(tempVariableElement);
		}
	}

	protected void internalOnVariableDefinition(Element aVariableElement) {
		Element tempCollectionElement = currentElement.peek().getChild(VARIABLE_DEFINITION_COLLECTION_ELEMENT);
		tempCollectionElement.addContent(aVariableElement);
	}

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

	protected static String nanoTimeToString(long aNanosecondValue) {
		return EXECUTION_TIME_FORMAT.format(((double) aNanosecondValue) / 1000000.0);
	}

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
		default:
			return;
		}
	}
}

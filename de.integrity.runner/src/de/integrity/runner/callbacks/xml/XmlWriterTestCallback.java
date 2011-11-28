package de.integrity.runner.callbacks.xml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Stack;

import org.jdom.DocType;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.ProcessingInstruction;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import de.integrity.dsl.Call;
import de.integrity.dsl.Parameter;
import de.integrity.dsl.Suite;
import de.integrity.dsl.SuiteDefinition;
import de.integrity.dsl.Test;
import de.integrity.dsl.Variable;
import de.integrity.dsl.VariableEntity;
import de.integrity.runner.TestModel;
import de.integrity.runner.callbacks.TestRunnerCallback;
import de.integrity.runner.results.SuiteResult;
import de.integrity.runner.results.call.CallResult;
import de.integrity.runner.results.test.ExceptionResult;
import de.integrity.runner.results.test.FailureResult;
import de.integrity.runner.results.test.SuccessResult;
import de.integrity.runner.results.test.TestResult;
import de.integrity.utils.IntegrityDSLUtil;
import de.integrity.utils.ParameterUtil;
import de.integrity.utils.TestFormatter;

public class XmlWriterTestCallback implements TestRunnerCallback {

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

	private static final String CALL_ELEMENT = "call";

	private static final String RESULT_ELEMENT = "result";

	private static final String VARIABLE_NAME_ATTRIBUTE = "name";

	private static final String VARIABLE_ELEMENT = "variable";

	private static final String PARAMETER_COLLECTION_ELEMENT = "parameters";

	private static final String PARAMETER_ELEMENT = "parameter";

	private static final String PARAMETER_NAME_ATTRIBUTE = "name";

	private static final String PARAMETER_VALUE_ATTRIBUTE = "value";

	private static final String PARAMETER_VARIABLE_ATTRIBUTE = "variable";

	private static final String VARIABLE_VALUE_ATTRIBUTE = "value";

	private static final String RESULT_EXPECTED_VALUE_ATTRIBUTE = "expectedValue";

	private static final String RESULT_VARIABLE_ATTRIBUTE = "variable";

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

	private static final String FIXTURE_DESCRIPTION_ELEMENT = "description";

	private static final String TEST_NAME_ELEMENT = "name";

	private static final String CALL_NAME_ELEMENT = "name";

	private static final String FIXTURE_METHOD_ELEMENT = "fixture";

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
		try {
			outputFile.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onExecutionStart(TestModel aModel, Map<VariableEntity, Object> aVariableMap) {
		Element rootElement = new Element(ROOT_ELEMENT);
		rootElement.addContent(new Element(VARIABLE_DEFINITION_COLLECTION_ELEMENT));
		rootElement.setAttribute(TEST_RUN_NAME_ATTRIBUTE, title);
		rootElement.setAttribute(TEST_RUN_TIMESTAMP, DATE_FORMAT.format(new Date()));
		document = new Document(rootElement);
		currentElement.push(rootElement);

		if (embedXhtmlTransform) {
			try {
				Document transform = new SAXBuilder().build(getClass().getClassLoader().getResourceAsStream(
						"static/xhtml.xslt"));
				rootElement.addContent(0, transform.getRootElement().detach());

				DocType docType = new DocType("doc");
				docType.setInternalSubset("<!ATTLIST xsl:stylesheet\nid ID #REQUIRED>");
				document.setDocType(docType);

				HashMap<String, String> processingInstructionMap = new HashMap<String, String>(2);
				processingInstructionMap.put("type", "text/xsl");
				processingInstructionMap.put("href", "#xhtmltransform");
				ProcessingInstruction processingInstruction = new ProcessingInstruction("xml-stylesheet",
						processingInstructionMap);
				document.addContent(0, processingInstruction);
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

		Element tempParentStatementElement = currentElement.peek().getChild(STATEMENT_COLLECTION_ELEMENT);
		if (tempParentStatementElement == null) {
			currentElement.peek().addContent(tempSuiteElement);
		} else {
			tempParentStatementElement.addContent(tempSuiteElement);
		}

		currentElement.push(tempSuiteElement);
	}

	@Override
	public void onSetupStart(SuiteDefinition aSetupSuite) {
		Element tempSetupElement = new Element(SUITE_ELEMENT);
		tempSetupElement.setAttribute(SUITE_NAME_ATTRIBUTE, IntegrityDSLUtil.getQualifiedSuiteName(aSetupSuite));
		tempSetupElement.addContent(new Element(VARIABLE_DEFINITION_COLLECTION_ELEMENT));
		tempSetupElement.addContent(new Element(STATEMENT_COLLECTION_ELEMENT));

		currentElement.peek().getChild(SETUP_COLLECTION_ELEMENT).addContent(tempSetupElement);
		currentElement.push(tempSetupElement);
	}

	@Override
	public void onSetupFinish(SuiteDefinition aSetupSuite, SuiteResult aResult) {
		Element tempSuiteResultElement = new Element(RESULT_ELEMENT);
		tempSuiteResultElement.setAttribute(EXECUTION_DURATION_ATTRIBUTE, nanoTimeToString(aResult.getExecutionTime()));
		tempSuiteResultElement.setAttribute(SUCCESS_COUNT_ATTRIBUTE, aResult.getTestSuccessCount().toString());
		tempSuiteResultElement.setAttribute(FAILURE_COUNT_ATTRIBUTE, aResult.getTestFailCount().toString());
		tempSuiteResultElement.setAttribute(EXCEPTION_COUNT_ATTRIBUTE, aResult.getTestExceptionCount().toString());

		currentElement.pop().addContent(tempSuiteResultElement);
	}

	@Override
	public void onTestStart(Test aTest) {
		Element tempTestElement = new Element(TEST_ELEMENT);
		tempTestElement.setAttribute(TEST_NAME_ELEMENT, aTest.getDefinition().getName());
		try {
			tempTestElement.setAttribute(FIXTURE_DESCRIPTION_ELEMENT,
					formatter.testToHumanReadableString(aTest, variableStorage));
		} catch (ClassNotFoundException e) {
			tempTestElement.setAttribute(FIXTURE_DESCRIPTION_ELEMENT, e.getMessage());
			e.printStackTrace();
		}
		tempTestElement.setAttribute(FIXTURE_METHOD_ELEMENT,
				IntegrityDSLUtil.getQualifiedNameOfFixtureMethod(aTest.getDefinition().getFixtureMethod()));

		Element parameterCollectionElement = new Element(PARAMETER_COLLECTION_ELEMENT);
		for (Parameter parameter : aTest.getParameters()) {
			Element parameterElement = new Element(PARAMETER_ELEMENT);
			parameterElement.setAttribute(PARAMETER_NAME_ATTRIBUTE,
					IntegrityDSLUtil.getParamNameFromAnnotation(parameter.getName()));
			parameterElement.setAttribute(PARAMETER_VALUE_ATTRIBUTE,
					ParameterUtil.convertValueToString(parameter.getValue(), variableStorage));
			if (parameter.getValue() instanceof Variable) {
				parameterElement.setAttribute(PARAMETER_VARIABLE_ATTRIBUTE, ((Variable) parameter.getValue()).getName()
						.getName());
			}

			parameterCollectionElement.addContent(parameterElement);
		}
		tempTestElement.addContent(parameterCollectionElement);

		Element tempCollectionElement = currentElement.peek().getChild(STATEMENT_COLLECTION_ELEMENT);
		tempCollectionElement.addContent(tempTestElement);
		currentElement.push(tempTestElement);
	}

	@Override
	public void onTestFinish(Test aTest, TestResult aResult) {
		Element tempTestResultElement = new Element(RESULT_ELEMENT);
		tempTestResultElement.setAttribute(EXECUTION_DURATION_ATTRIBUTE, nanoTimeToString(aResult.getExecutionTime()));
		tempTestResultElement.setAttribute(RESULT_EXPECTED_VALUE_ATTRIBUTE,
				ParameterUtil.convertValueToString(aTest.getResult(), variableStorage));
		if (aTest.getResult() instanceof Variable) {
			tempTestResultElement.setAttribute(RESULT_VARIABLE_ATTRIBUTE, ((Variable) aTest.getResult()).getName()
					.getName());
		}
		if (aResult.getResult() != null) {
			tempTestResultElement.setAttribute(RESULT_REAL_VALUE_ATTRIBUTE,
					ParameterUtil.convertValueToString(aResult.getResult(), variableStorage));
		}

		if (aResult instanceof SuccessResult) {
			tempTestResultElement.setAttribute(RESULT_TYPE_ATTRIBUTE, RESULT_TYPE_SUCCESS);
		} else if (aResult instanceof FailureResult) {
			tempTestResultElement.setAttribute(RESULT_TYPE_ATTRIBUTE, RESULT_TYPE_FAILURE);
		} else if (aResult instanceof ExceptionResult) {
			tempTestResultElement.setAttribute(RESULT_TYPE_ATTRIBUTE, RESULT_TYPE_EXCEPTION);
			tempTestResultElement.setAttribute(RESULT_EXCEPTION_MESSAGE_ATTRIBUTE, ((ExceptionResult) aResult)
					.getException().getMessage());
			tempTestResultElement.setAttribute(RESULT_EXCEPTION_TRACE_ATTRIBUTE,
					stackTraceToString(((ExceptionResult) aResult).getException()));
		}

		currentElement.pop().addContent(tempTestResultElement);
	}

	@Override
	public void onCallStart(Call aCall) {
		Element tempCallElement = new Element(CALL_ELEMENT);
		tempCallElement.setAttribute(CALL_NAME_ELEMENT, aCall.getDefinition().getName());
		try {
			tempCallElement.setAttribute(FIXTURE_DESCRIPTION_ELEMENT,
					formatter.callToHumanReadableString(aCall, variableStorage));
		} catch (ClassNotFoundException e) {
			tempCallElement.setAttribute(FIXTURE_DESCRIPTION_ELEMENT, e.getMessage());
			e.printStackTrace();
		}
		tempCallElement.setAttribute(FIXTURE_METHOD_ELEMENT,
				IntegrityDSLUtil.getQualifiedNameOfFixtureMethod(aCall.getDefinition().getFixtureMethod()));

		Element parameterCollectionElement = new Element(PARAMETER_COLLECTION_ELEMENT);
		for (Parameter parameter : aCall.getParameters()) {
			Element parameterElement = new Element(PARAMETER_ELEMENT);
			parameterElement.setAttribute(PARAMETER_NAME_ATTRIBUTE,
					IntegrityDSLUtil.getParamNameFromAnnotation(parameter.getName()));
			parameterElement.setAttribute(PARAMETER_VALUE_ATTRIBUTE,
					ParameterUtil.convertValueToString(parameter.getValue(), variableStorage));
			if (parameter.getValue() instanceof Variable) {
				parameterElement.setAttribute(PARAMETER_VARIABLE_ATTRIBUTE, ((Variable) parameter.getValue()).getName()
						.getName());
			}

			parameterCollectionElement.addContent(parameterElement);
		}
		tempCallElement.addContent(parameterCollectionElement);

		Element tempCollectionElement = currentElement.peek().getChild(STATEMENT_COLLECTION_ELEMENT);
		tempCollectionElement.addContent(tempCallElement);
		currentElement.push(tempCallElement);
	}

	@Override
	public void onCallFinish(Call aCall, CallResult aResult) {
		if (aResult != null) {
			Element tempCallResultElement = new Element(RESULT_ELEMENT);
			tempCallResultElement.setAttribute(EXECUTION_DURATION_ATTRIBUTE,
					nanoTimeToString(aResult.getExecutionTime()));

			if (aResult instanceof de.integrity.runner.results.call.SuccessResult) {
				tempCallResultElement.setAttribute(RESULT_TYPE_ATTRIBUTE, RESULT_TYPE_SUCCESS);
				de.integrity.runner.results.call.SuccessResult result = (de.integrity.runner.results.call.SuccessResult) aResult;
				tempCallResultElement.setAttribute(RESULT_REAL_VALUE_ATTRIBUTE,
						ParameterUtil.convertValueToString(aResult, variableStorage));
				if (result.getTargetVariable() != null) {
					tempCallResultElement.setAttribute(VARIABLE_NAME_ATTRIBUTE, result.getTargetVariable().getName());
				}
			} else if (aResult instanceof de.integrity.runner.results.call.ExceptionResult) {
				tempCallResultElement.setAttribute(RESULT_TYPE_ATTRIBUTE, RESULT_TYPE_EXCEPTION);
				tempCallResultElement.setAttribute(RESULT_EXCEPTION_MESSAGE_ATTRIBUTE,
						((de.integrity.runner.results.call.ExceptionResult) aResult).getException().getMessage());
				tempCallResultElement
						.setAttribute(RESULT_EXCEPTION_TRACE_ATTRIBUTE,
								stackTraceToString(((de.integrity.runner.results.call.ExceptionResult) aResult)
										.getException()));
			}
			currentElement.peek().addContent(tempCallResultElement);
		}

		currentElement.pop();
	}

	@Override
	public void onTearDownStart(SuiteDefinition aTearDownSuite) {
		Element tempTearDownElement = new Element(SUITE_ELEMENT);
		tempTearDownElement.setAttribute(SUITE_NAME_ATTRIBUTE, IntegrityDSLUtil.getQualifiedSuiteName(aTearDownSuite));
		tempTearDownElement.addContent(new Element(VARIABLE_DEFINITION_COLLECTION_ELEMENT));
		tempTearDownElement.addContent(new Element(STATEMENT_COLLECTION_ELEMENT));

		currentElement.peek().getChild(TEARDOWN_COLLECTION_ELEMENT).addContent(tempTearDownElement);
		currentElement.push(tempTearDownElement);
	}

	@Override
	public void onTearDownFinish(SuiteDefinition aTearDownSuite, SuiteResult aResult) {
		Element tempSuiteResultElement = new Element(RESULT_ELEMENT);
		tempSuiteResultElement.setAttribute(EXECUTION_DURATION_ATTRIBUTE, nanoTimeToString(aResult.getExecutionTime()));
		tempSuiteResultElement.setAttribute(SUCCESS_COUNT_ATTRIBUTE, aResult.getTestSuccessCount().toString());
		tempSuiteResultElement.setAttribute(FAILURE_COUNT_ATTRIBUTE, aResult.getTestFailCount().toString());
		tempSuiteResultElement.setAttribute(EXCEPTION_COUNT_ATTRIBUTE, aResult.getTestExceptionCount().toString());

		currentElement.pop().addContent(tempSuiteResultElement);
	}

	@Override
	public void onSuiteFinish(Suite aSuite, SuiteResult aResult) {
		Element tempSuiteResultElement = new Element(RESULT_ELEMENT);
		tempSuiteResultElement.setAttribute(EXECUTION_DURATION_ATTRIBUTE, nanoTimeToString(aResult.getExecutionTime()));
		tempSuiteResultElement.setAttribute(SUCCESS_COUNT_ATTRIBUTE, aResult.getTestSuccessCount().toString());
		tempSuiteResultElement.setAttribute(FAILURE_COUNT_ATTRIBUTE, aResult.getTestFailCount().toString());
		tempSuiteResultElement.setAttribute(EXCEPTION_COUNT_ATTRIBUTE, aResult.getTestExceptionCount().toString());

		currentElement.pop().addContent(tempSuiteResultElement);
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
		XMLOutputter serializer = new XMLOutputter(Format.getPrettyFormat());
		try {
			serializer.output(document, tempOutputStream);
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
		Element tempCollectionElement = currentElement.peek().getChild(VARIABLE_DEFINITION_COLLECTION_ELEMENT);
		Element tempVariableElement = new Element(VARIABLE_ELEMENT);
		tempVariableElement.setAttribute(VARIABLE_NAME_ATTRIBUTE,
				IntegrityDSLUtil.getQualifiedGlobalVariableName(aDefinition));
		if (anInitialValue != null) {
			tempVariableElement.setAttribute(VARIABLE_VALUE_ATTRIBUTE,
					ParameterUtil.convertValueToString(anInitialValue, variableStorage));
		}
		tempCollectionElement.addContent(tempVariableElement);
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
				if (tempPrintWriter != null)
					tempPrintWriter.close();
				if (tempStringWriter != null)
					tempStringWriter.close();
			} catch (IOException exc) {
			}
		}
		return tempResult;
	}

	protected static String nanoTimeToString(long aNanosecondValue) {
		return EXECUTION_TIME_FORMAT.format(((double) aNanosecondValue) / 1000000.0);
	}
}

/*******************************************************************************
 * Copyright (c) 2017 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.docgen.html;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;
import java.util.StringJoiner;

import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmVoid;

import com.google.inject.Inject;

import de.gebit.integrity.classloading.IntegrityClassLoader;
import de.gebit.integrity.docgen.IntegrityPackage;
import de.gebit.integrity.dsl.CallDefinition;
import de.gebit.integrity.dsl.ConstantDefinition;
import de.gebit.integrity.dsl.DocumentationComment;
import de.gebit.integrity.dsl.MethodReference;
import de.gebit.integrity.dsl.SuiteDefinition;
import de.gebit.integrity.dsl.SuiteParameterDefinition;
import de.gebit.integrity.dsl.TestDefinition;
import de.gebit.integrity.dsl.ValueOrEnumValueOrOperation;
import de.gebit.integrity.dsl.ValueOrEnumValueOrOperationCollection;
import de.gebit.integrity.dsl.VariantDefinition;
import de.gebit.integrity.dsl.VariantValue;
import de.gebit.integrity.modelsource.ModelSourceExplorer;
import de.gebit.integrity.operations.UnexecutableException;
import de.gebit.integrity.parameter.conversion.ConversionContext;
import de.gebit.integrity.parameter.conversion.UnresolvableVariable;
import de.gebit.integrity.parameter.conversion.UnresolvableVariableHandling;
import de.gebit.integrity.parameter.conversion.ValueConverter;
import de.gebit.integrity.parameter.resolving.ParameterResolver;
import de.gebit.integrity.runner.TestModel;
import de.gebit.integrity.utils.CountsOfThingsStringJoiner;
import de.gebit.integrity.utils.CountsOfThingsStringJoiner.StringSegment;
import de.gebit.integrity.utils.IntegrityDSLUtil;
import de.gebit.integrity.utils.JavaTypeUtil;
import de.gebit.integrity.utils.ParamAnnotationTypeTriplet;
import de.gebit.integrity.utils.ParsedDocumentationComment;
import de.gebit.integrity.utils.ParsedDocumentationComment.ParseException;
import de.gebit.integrity.utils.ResultFieldTuple;
import htmlflow.HtmlWriterComposite;
import htmlflow.elements.HtmlA;
import htmlflow.elements.HtmlAnchor;
import htmlflow.elements.HtmlBody;
import htmlflow.elements.HtmlDiv;
import htmlflow.elements.HtmlP;
import htmlflow.elements.HtmlTable;
import htmlflow.elements.HtmlTd;
import htmlflow.elements.HtmlTr;

/**
 * HTML view of an Integrity package, containing a number of suites.
 *
 * @author Rene Schneider - initial API and implementation
 *
 */
public class PackageView extends IntegrityHtmlView<Entry<String, Collection<SuiteDefinition>>> {

	/**
	 * The {@link ValueConverter}.
	 */
	@Inject
	protected ValueConverter valueConverter;

	/**
	 * The {@link ParameterResolver}.
	 */
	@Inject
	protected ParameterResolver parameterResolver;

	/**
	 * The {@link ModelSourceExplorer}.
	 */
	@Inject
	protected ModelSourceExplorer modelSourceExplorer;

	/**
	 * The {@link IntegrityClassLoader}.
	 */
	@Inject
	protected IntegrityClassLoader classLoader;

	/**
	 * This holds the div that contains the main content of the package view.
	 */
	protected HtmlDiv<?> mainContent;

	/**
	 * Constructor.
	 * 
	 * @param anEntry
	 * @throws ParseException
	 */
	public PackageView(IntegrityPackage aPackage, TestModel aModel, PackageTreeView aTreeView) throws ParseException {
		aModel.getInjector().injectMembers(this);

		head().linkCss("../resources/css/main.css").title("Package " + aPackage.getName());
		head().scriptLink("../resources/js/mark.js");
		head().scriptLink("../resources/js/package.js");

		HtmlBody<?> tempBody = body();

		// The content for the tree view is basically just copied over
		HtmlDiv<?> tempTreeContainerDiv = tempBody.div().idAttr("treecontainer");
		tempTreeContainerDiv.addChild(aTreeView.getTreeRootElement());

		// This generates the actual content (documentation of the package)
		mainContent = tempBody.div().idAttr("maincontainer");
		mainContent.div().classAttr("title").text("Package " + aPackage.getName());
		mainContent.hr();
		HtmlDiv<?> tempSummaryDiv = mainContent.div().classAttr("packagesummary");

		int tempConstantCount = processConstants(aPackage, mainContent);
		int tempCallCount = processCalls(aPackage, mainContent);
		int tempTestCount = processTests(aPackage, mainContent);
		int tempSuiteCount = processSuites(aPackage, mainContent);

		CountsOfThingsStringJoiner tempSummaryText = new CountsOfThingsStringJoiner(false);
		tempSummaryText.add(tempConstantCount, "Constant", "Constants", "constants");
		tempSummaryText.add(tempCallCount, "Call", "Calls", "calls");
		tempSummaryText.add(tempTestCount, "Test", "Tests", "tests");
		tempSummaryText.add(tempSuiteCount, "Suite", "Suites", "suites");
		List<StringSegment> tempSummaryParts = tempSummaryText.toStringSegments();
		tempSummaryDiv.text("Contains ");
		for (StringSegment tempSegment : tempSummaryParts) {
			if (tempSegment.hasLastDivider()) {
				tempSummaryDiv.text(tempSegment.getDivider());
			}
			HtmlA<?> tempSummaryLink = new HtmlA<>("#" + tempSegment.getData());
			tempSummaryLink.text(tempSegment.getContent()
					+ ((tempSegment.getNextSegment() != null && !tempSegment.getNextSegment().hasLastDivider())
							? tempSegment.getNextSegment().getDivider().replace(" ", "") : ""));
			tempSummaryDiv.addChild(tempSummaryLink);
		}
	}

	@Override
	protected HtmlWriterComposite<?, ?> getTextOnlyEntryNode() {
		return mainContent;
	}

	/**
	 * Processes all suites in a package.
	 * 
	 * @param anEntry
	 * @param aModelSourceExplorer
	 * @param aMainContainerDiv
	 * @throws ParseException
	 */
	protected int processSuites(IntegrityPackage aPackage, HtmlDiv<?> aMainContainerDiv) throws ParseException {
		if (aPackage.getSuites().size() == 0) {
			return 0;
		}

		HtmlAnchor<?> tempAnchor = new HtmlAnchor<>("suites");
		aMainContainerDiv.addChild(tempAnchor);
		HtmlDiv<?> tempMainDiv = aMainContainerDiv.div().classAttr("entitybox suites");
		tempMainDiv.div().classAttr("entitysummary suitesummary").text(aPackage.getSuites().size() + " Suites");

		for (SuiteDefinition tempSuite : aPackage.getSuites()) {
			HtmlDiv<?> tempSuiteDiv = tempMainDiv.div().classAttr("entity suite");
			HtmlDiv<?> tempSuiteHeaderDiv = tempSuiteDiv.div().classAttr("entityheader");
			tempSuiteHeaderDiv.div().classAttr("entityname").text(tempSuite.getName());
			String tempSuiteTitle = IntegrityDSLUtil.getSuiteTitle(tempSuite);
			if (tempSuiteTitle != null) {
				tempSuiteHeaderDiv.div().classAttr("entitytitle").text(tempSuiteTitle);
			}
			tempSuiteHeaderDiv.div().classAttr("fullentityname code")
					.text(IntegrityDSLUtil.getQualifiedSuiteName(tempSuite));

			if (tempSuite.getDocumentation() != null) {
				HtmlDiv<?> tempSuiteDetailsDiv = tempSuiteDiv.div().classAttr("entitydetails");
				if (tempSuite.getDocumentation() != null) {
					ParsedDocumentationComment tempParsedComment = new ParsedDocumentationComment(
							tempSuite.getDocumentation(),
							modelSourceExplorer.determineSourceInformation(tempSuite.getDocumentation()));
					tempSuiteDetailsDiv.div().classAttr("entitydescription")
							.text(tempParsedComment.getDocumentationText());

					if (tempSuite.getParameters().size() > 0) {
						HtmlDiv<?> tempSuiteParamsDiv = tempSuiteDetailsDiv.div().classAttr("entityparams");
						tempSuiteParamsDiv.div().classAttr("detailstitle").text("Parameters");
						HtmlTable<?> tempParamTable = tempSuiteParamsDiv.table();

						for (SuiteParameterDefinition tempParameter : tempSuite.getParameters()) {
							String tempParamDoc = tempParsedComment.getParameterDocumentationTexts()
									.get(tempParameter.getName().getName());
							HtmlTr<?> tempRow = tempParamTable.tr();
							tempRow.td().classAttr(CSSClasses.CODE).text(tempParameter.getName().getName());
							tempRow.td().text(tempParamDoc != null ? tempParamDoc : "");
						}
					}
				}
			}
		}

		return aPackage.getSuites().size();
	}

	/**
	 * Processes all constants in a package.
	 * 
	 * @param anEntry
	 * @param aModelSourceExplorer
	 * @param aMainContainerDiv
	 * @throws ParseException
	 */
	protected int processConstants(IntegrityPackage aPackage, HtmlDiv<?> aMainContainerDiv) throws ParseException {
		if (aPackage.getConstants().size() == 0) {
			return 0;
		}

		HtmlAnchor<?> tempAnchor = new HtmlAnchor<>("constants");
		aMainContainerDiv.addChild(tempAnchor);
		HtmlDiv<?> tempMainDiv = aMainContainerDiv.div().classAttr("entitybox constants");
		tempMainDiv.div().classAttr("entitysummary constantsummary")
				.text(aPackage.getConstants().size() + " Constants");

		HtmlTable<?> tempTable = tempMainDiv.table();
		HtmlTr<?> tempHeaderRow = tempTable.tr();
		tempHeaderRow.th().text("Type");
		tempHeaderRow.th().text("Name");
		tempHeaderRow.th().text("Value");
		tempHeaderRow.th().text("Description");

		for (ConstantDefinition tempConstant : aPackage.getConstants()) {
			HtmlTr<?> tempRow = tempTable.tr();

			String tempConstantDescription = "";
			if (tempConstant.getDocumentation() != null) {
				ParsedDocumentationComment tempParsedComment = new ParsedDocumentationComment(
						tempConstant.getDocumentation(),
						modelSourceExplorer.determineSourceInformation(tempConstant.getDocumentation()));
				tempConstantDescription = tempParsedComment.getDocumentationText();
			}

			StringJoiner tempTypes = new StringJoiner(" ");
			if (tempConstant.getPrivate() != null) {
				tempTypes.add(tempConstant.getPrivate());
			}
			if (tempConstant.getParameterized() != null) {
				tempTypes.add(tempConstant.getParameterized());
			}

			tempRow.td().text(tempTypes.toString());
			tempRow.td().classAttr(CSSClasses.CODE).text(tempConstant.getName().getName());
			HtmlTd<?> tempValueContainer = tempRow.td();

			if (tempConstant.getVariantValues().size() == 0) {
				// No variants case - this is easy!
				resolveValue(tempConstant.getValue()).forEach((anElement) -> {
					tempValueContainer.addChild(anElement);
				});
			} else {
				HtmlTable<?> tempVariantTable = new HtmlTable<>();
				if (tempConstant.getValue() != null) {
					HtmlTr<?> tempVariantRow = tempVariantTable.tr();
					tempVariantRow.td().text("no variant:");
					HtmlTd<?> tempVariantValueContainer = tempVariantRow.td();
					resolveValue(tempConstant.getValue()).forEach((anElement) -> {
						tempVariantValueContainer.addChild(anElement);
					});
				}

				for (VariantValue tempVariantValue : tempConstant.getVariantValues()) {
					HtmlTr<?> tempVariantRow = tempVariantTable.tr();
					StringJoiner tempJoiner = new StringJoiner(", ");
					for (VariantDefinition tempVariant : tempVariantValue.getNames()) {
						tempJoiner.add(IntegrityDSLUtil.getQualifiedVariantName(tempVariant));
					}
					tempVariantRow.td().text("in " + tempJoiner.toString() + ":");
					HtmlTd<?> tempVariantValueContainer = tempVariantRow.td();
					resolveValue(tempVariantValue.getValue()).forEach((anElement) -> {
						tempVariantValueContainer.addChild(anElement);
					});
				}

				tempValueContainer.addChild(tempVariantTable);
			}

			tempRow.td().text(tempConstantDescription);
		}

		return aPackage.getConstants().size();
	}

	/**
	 * Processes all call fixtures in a package.
	 * 
	 * @param anEntry
	 * @param aModelSourceExplorer
	 * @param aMainContainerDiv
	 * @throws ParseException
	 */
	protected int processCalls(IntegrityPackage aPackage, HtmlDiv<?> aMainContainerDiv) throws ParseException {
		if (aPackage.getCalls().size() == 0) {
			return 0;
		}

		HtmlAnchor<?> tempAnchor = new HtmlAnchor<>("calls");
		aMainContainerDiv.addChild(tempAnchor);
		HtmlDiv<?> tempMainDiv = aMainContainerDiv.div().classAttr("entitybox calls");
		tempMainDiv.div().classAttr("entitysummary callsummary").text(aPackage.getCalls().size() + " Call Fixtures");

		for (CallDefinition tempCall : aPackage.getCalls()) {
			tempMainDiv
					.addChild(createTestOrCallDiv(tempCall.getName(), IntegrityDSLUtil.getQualifiedCallName(tempCall),
							tempCall.getDocumentation(), tempCall.getFixtureMethod(), "call", "Returns"));
		}

		return aPackage.getCalls().size();
	}

	/**
	 * Processes all test fixtures in a package.
	 * 
	 * @param anEntry
	 * @param aModelSourceExplorer
	 * @param aMainContainerDiv
	 * @throws ParseException
	 */
	protected int processTests(IntegrityPackage aPackage, HtmlDiv<?> aMainContainerDiv) throws ParseException {
		if (aPackage.getTests().size() == 0) {
			return 0;
		}

		HtmlAnchor<?> tempAnchor = new HtmlAnchor<>("tests");
		aMainContainerDiv.addChild(tempAnchor);
		HtmlDiv<?> tempMainDiv = aMainContainerDiv.div().classAttr("entitybox tests");
		tempMainDiv.div().classAttr("entitysummary testsummary").text(aPackage.getTests().size() + " Test Fixtures");

		for (TestDefinition tempTest : aPackage.getTests()) {
			tempMainDiv
					.addChild(createTestOrCallDiv(tempTest.getName(), IntegrityDSLUtil.getQualifiedTestName(tempTest),
							tempTest.getDocumentation(), tempTest.getFixtureMethod(), "test", "Results"));
		}

		return aPackage.getTests().size();
	}

	/**
	 * Creates a single test/call documentation block.
	 * 
	 * @param aShortName
	 * @param aQualifiedName
	 * @param aDocComment
	 * @param aFixtureMethod
	 * @param anEntityName
	 * @param aReturnValueName
	 * @return
	 * @throws ParseException
	 */
	protected HtmlDiv<?> createTestOrCallDiv(String aShortName, String aQualifiedName, DocumentationComment aDocComment,
			MethodReference aFixtureMethod, String anEntityName, String aReturnValueName) throws ParseException {
		HtmlDiv<?> tempTestDiv = new HtmlDiv<>();
		tempTestDiv.classAttr("entity " + anEntityName);
		HtmlDiv<?> tempTestHeaderDiv = tempTestDiv.div().classAttr("entityheader");
		tempTestHeaderDiv.div().classAttr("entityname").text(aShortName);
		tempTestHeaderDiv.div().classAttr("fullentityname code").text(aQualifiedName);

		List<ParamAnnotationTypeTriplet> tempParams = IntegrityDSLUtil
				.getAllParamNamesFromFixtureMethod(aFixtureMethod);
		ParsedDocumentationComment tempParsedComment = (aDocComment != null ? new ParsedDocumentationComment(
				aDocComment, modelSourceExplorer.determineSourceInformation(aDocComment)) : null);

		if (tempParams.size() > 0 || tempParsedComment != null) {
			HtmlDiv<?> tempTestDetailsDiv = tempTestDiv.div().classAttr("entitydetails");
			if (tempParsedComment != null) {
				tempTestDetailsDiv.div().classAttr("entitydescription").text(tempParsedComment.getDocumentationText());
			}

			if (tempParams.size() > 0) {
				HtmlDiv<?> tempTestParamsDiv = tempTestDetailsDiv.div().classAttr("entityparams");
				tempTestParamsDiv.div().classAttr("detailstitle").text("Parameters");
				HtmlTable<?> tempParamTable = tempTestParamsDiv.table();

				for (ParamAnnotationTypeTriplet tempParameter : tempParams) {
					boolean tempMandatory = IntegrityDSLUtil
							.getParamMandatoryFlagFromAnnotation(tempParameter.getAnnotation());
					String tempParamName = tempParameter.getParamName();
					String tempParamDoc = (tempParsedComment != null
							? tempParsedComment.getParameterDocumentationTexts().get(tempParamName) : "");
					tempParamTable.addChild(createParameterRow(tempParamName, tempMandatory,
							tempParameter.getType().getType(), tempParamDoc));
				}
			}

			JvmType tempReturnType = aFixtureMethod.getMethod().getReturnType().getType();
			if (!(tempReturnType instanceof JvmVoid)) {
				HtmlDiv<?> tempCallResultsDiv = tempTestDetailsDiv.div().classAttr("entityparams");
				tempCallResultsDiv.div().classAttr("detailstitle").text(aReturnValueName);
				HtmlTable<?> tempResultsTable = tempCallResultsDiv.table();

				String tempDefaultResultDocumentation = null;
				boolean tempResultsHandled = false;
				if (tempParsedComment != null && tempParsedComment.getResultDocumentationTexts().size() > 0) {
					tempDefaultResultDocumentation = tempParsedComment.getResultDocumentationTexts().get(null);
					if (tempDefaultResultDocumentation == null) {
						// Must be named results then
						List<ResultFieldTuple> tempNamedResults = IntegrityDSLUtil
								.getAllResultNamesFromFixtureMethod(aFixtureMethod);

						for (ResultFieldTuple tempNamedResult : tempNamedResults) {
							String tempDocumentation = tempParsedComment.getResultDocumentationTexts()
									.get(tempNamedResult.getResultName());
							tempResultsTable.addChild(createParameterRow(tempNamedResult.getResultName(), false,
									tempNamedResult.getField().getType().getType(), tempDocumentation));
						}
						tempResultsHandled = true;
					}
				}
				if (!tempResultsHandled) {
					// This adds just a single line for our result
					tempResultsTable.addChild(createParameterRow(null, false,
							aFixtureMethod.getMethod().getReturnType().getType(), tempDefaultResultDocumentation));
				}
			}
		}

		return tempTestDiv;
	}

	/**
	 * Creates a {@link HtmlTr} documenting the provided parameter.
	 * 
	 * @param aParamName
	 * @param aMandatory
	 * @param aFullyQualifiedTypeName
	 * @param aParsedComment
	 * @return
	 */
	protected HtmlTr<?> createParameterRow(String aParamName, boolean aMandatory, JvmType aType,
			String aDocumentation) {
		String tempTypeName = JavaTypeUtil.getReadableJavaTypeName(aType);

		HtmlTr<?> tempRow = new HtmlTr<>();
		if (aParamName != null) {
			// Is null for the default result, which only has one line in the table
			tempRow.td().classAttr(CSSClasses.CODE + (aMandatory ? " " + CSSClasses.MANDATORY : "")).text(aParamName);
		}
		HtmlTd<?> tempTypeColumn = tempRow.td();
		HtmlP<?> tempTypeText = new HtmlP<>();
		tempTypeText.classAttr(CSSClasses.CODE).text(tempTypeName);
		tempTypeColumn.addChild(tempTypeText);
		if (tempTypeName.contains(".")) {
			// Only in this case it could be an enum
			try {
				Class<?> tempClass = classLoader.loadClass(aType);
				if (tempClass.isEnum()) {
					HtmlDiv<?> tempEnumValuesDiv = new HtmlDiv<>();
					tempEnumValuesDiv.classAttr("enumvalues " + CSSClasses.HIDDEN);
					tempEnumValuesDiv.div().classAttr("header").text("Possible enumeration values");
					HtmlDiv<?> tempEnumValuesContentDiv = tempEnumValuesDiv.div();
					tempEnumValuesContentDiv.classAttr("content");
					for (Object tempConstant : tempClass.getEnumConstants()) {
						tempEnumValuesContentDiv.div().classAttr(CSSClasses.CODE).text(tempConstant.toString());
					}
					tempTypeColumn.addChild(tempEnumValuesDiv);
					tempTypeText.classAttr(CSSClasses.CODE + " " + "enumtype");
					tempTypeText.addAttr("onclick", "toggleHiddenDiv(this.parentElement)");
				}
			} catch (ClassNotFoundException exc) {
				exc.printStackTrace();
			}
		}
		tempRow.td().text(aDocumentation != null ? aDocumentation : "");

		return tempRow;
	}

	/**
	 * Resolves a {@link ValueOrEnumValueOrOperationCollection} suitable for inclusion in the HTML page.
	 * 
	 * @param aValueCollection
	 * @return
	 */
	protected List<HtmlP<?>> resolveValue(ValueOrEnumValueOrOperationCollection aValueCollection) {
		if (aValueCollection instanceof ValueOrEnumValueOrOperationCollection) {
			if (aValueCollection.getMoreValues().size() > 0) {
				List<HtmlP<?>> tempElements = new ArrayList<HtmlP<?>>(aValueCollection.getMoreValues().size() + 1);
				for (ValueOrEnumValueOrOperation tempSingleValue : IntegrityDSLUtil
						.getAllValuesFromCollection(aValueCollection)) {
					tempElements.add(resolveSingleValue(tempSingleValue));
				}
				return tempElements;
			} else {
				return Collections.singletonList(resolveSingleValue(aValueCollection.getValue()));
			}
		} else {
			return Collections.singletonList(resolveSingleValue((ValueOrEnumValueOrOperation) aValueCollection));
		}
	}

	/**
	 * Resolves a single value to its actual value includable in an HTML page.
	 * 
	 * @param aValue
	 * @return
	 */
	protected HtmlP<?> resolveSingleValue(ValueOrEnumValueOrOperation aValue) {
		Object tempResult;
		try {
			tempResult = parameterResolver.resolveStatically(aValue, null);
		} catch (ClassNotFoundException | InstantiationException | UnexecutableException exc) {
			tempResult = UnresolvableVariable.getInstance();
		}

		HtmlP<?> tempP = new HtmlP<>();
		tempP.text(valueConverter.convertValueToString(tempResult, false, new ConversionContext()
				.withUnresolvableVariableHandlingPolicy(UnresolvableVariableHandling.RESOLVE_TO_UNRESOLVABLE_OBJECT))
				.toString());
		return tempP;
	}

}

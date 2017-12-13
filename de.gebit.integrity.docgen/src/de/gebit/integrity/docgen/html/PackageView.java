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
import de.gebit.integrity.dsl.ForkDefinition;
import de.gebit.integrity.dsl.ForkParameter;
import de.gebit.integrity.dsl.MethodReference;
import de.gebit.integrity.dsl.SuiteDefinition;
import de.gebit.integrity.dsl.SuiteParameterDefinition;
import de.gebit.integrity.dsl.SuiteReturnDefinition;
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
import htmlflow.elements.HtmlSpan;
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
	public PackageView(IntegrityPackage aPackage, TestModel aModel, PackageIndexView aTreeView) throws ParseException {
		aModel.getInjector().injectMembers(this);

		head().title("Package " + aPackage.getName());
		head().linkCss("../resources/css/main.css");
		head().linkCss("../resources/css/vtree.css");
		head().scriptLink("../resources/js/mark.js");
		head().scriptLink("../resources/js/package.js");
		head().scriptLink("../resources/js/vanillatree.js");
		head().scriptLink("../resources/js/vanillatree_integration.js");
		head().scriptLink("../resources/js/tree.js");

		HtmlBody<?> tempBody = body();
		HtmlDiv<?> tempTreeContainerDiv = tempBody.div().idAttr("treecontainer");
		HtmlDiv<?> tempTreeDiv = tempTreeContainerDiv.div().idAttr("packagetree");
		HtmlDiv<?> tempTreeIndexLinkDiv = tempTreeDiv.div().idAttr("treeindexlink");
		HtmlA<?> tempTreeIndexLink = new HtmlA<>("../index.html");
		tempTreeIndexLink.text("Package Index");
		tempTreeIndexLinkDiv.addChild(tempTreeIndexLink);

		// This generates the actual content (documentation of the package)
		mainContent = tempBody.div().idAttr("maincontainer");
		mainContent.div().classAttr("title").text("Package " + aPackage.getName());
		mainContent.hr();
		HtmlDiv<?> tempSummaryDiv = mainContent.div().classAttr("packagesummary");
		HtmlDiv<?> tempDocumentationDiv = mainContent.div().classAttr("packagedoc");

		int tempConstantCount = processConstants(aPackage, mainContent);
		int tempVariantCount = processVariants(aPackage, mainContent);
		int tempForkCount = processForks(aPackage, mainContent);
		int tempCallCount = processCalls(aPackage, mainContent);
		int tempTestCount = processTests(aPackage, mainContent);
		int tempSuiteCount = processSuites(aPackage, mainContent);

		CountsOfThingsStringJoiner tempSummaryText = new CountsOfThingsStringJoiner(false);
		tempSummaryText.add(tempConstantCount, "Constant", "Constants", "constants");
		tempSummaryText.add(tempVariantCount, "Variant", "Variants", "variants");
		tempSummaryText.add(tempForkCount, "Fork", "Forks", "forks");
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

		if (aPackage.getDocumentationComment() != null) {
			ParsedDocumentationComment tempParsedDoc = new ParsedDocumentationComment(
					aPackage.getDocumentationComment(),
					modelSourceExplorer.determineSourceInformation(aPackage.getDocumentationComment()));
			attachFormattedDocumentationText(tempDocumentationDiv, tempParsedDoc.getDocumentationTextElements());
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
		HtmlDiv<?> tempMainDiv = aMainContainerDiv.div().classAttr(CSSClasses.ENTITYBOX + " suites");
		tempMainDiv.div().classAttr(CSSClasses.ENTITYSUMMARY + " suitesummary")
				.text(aPackage.getSuites().size() + " Suites");

		for (SuiteDefinition tempSuite : aPackage.getSuites()) {
			HtmlDiv<?> tempSuiteDiv = tempMainDiv.div().classAttr(CSSClasses.ENTITY + " suite");
			HtmlDiv<?> tempSuiteHeaderDiv = tempSuiteDiv.div().classAttr(CSSClasses.ENTITYHEADER);
			tempSuiteHeaderDiv.div().classAttr(CSSClasses.ENTITYNAME).text(tempSuite.getName());
			String tempSuiteTitle = IntegrityDSLUtil.getSuiteTitle(tempSuite);
			if (tempSuiteTitle != null) {
				tempSuiteHeaderDiv.div().classAttr(CSSClasses.ENTITYTITLE).text(tempSuiteTitle);
			}
			tempSuiteHeaderDiv.div().classAttr(CSSClasses.FULLENTITYNAME + " " + CSSClasses.CODE)
					.text("suite " + IntegrityDSLUtil.getQualifiedSuiteName(tempSuite));

			if (tempSuite.getDocumentation() != null) {
				HtmlDiv<?> tempSuiteDetailsDiv = tempSuiteDiv.div().classAttr(CSSClasses.ENTITYDETAILS);
				ParsedDocumentationComment tempParsedComment = new ParsedDocumentationComment(
						tempSuite.getDocumentation(),
						modelSourceExplorer.determineSourceInformation(tempSuite.getDocumentation()), false);
				attachFormattedDocumentationText(tempSuiteDetailsDiv.div().classAttr(CSSClasses.ENTITYDESCRIPTION),
						tempParsedComment.getDocumentationTextElements());

				if (tempSuite.getParameters().size() > 0) {
					HtmlDiv<?> tempSuiteParamsDiv = tempSuiteDetailsDiv.div().classAttr(CSSClasses.ENTITYPARAMS);
					tempSuiteParamsDiv.div().classAttr(CSSClasses.DETAILSTITLE).text("Parameters");
					HtmlTable<?> tempParamTable = tempSuiteParamsDiv.table();

					for (SuiteParameterDefinition tempParameter : tempSuite.getParameters()) {
						String tempParamDoc = tempParsedComment.getParameterDocumentationTexts()
								.get(tempParameter.getName().getName());
						HtmlTr<?> tempRow = tempParamTable.tr();
						tempRow.td().classAttr(CSSClasses.CODE).text(tempParameter.getName().getName());
						tempRow.td().text(tempParamDoc != null ? tempParamDoc : "");
					}
				}

				if (tempSuite.getReturn().size() > 0) {
					HtmlDiv<?> tempSuiteResultsDiv = tempSuiteDetailsDiv.div().classAttr(CSSClasses.ENTITYPARAMS);
					tempSuiteResultsDiv.div().classAttr(CSSClasses.DETAILSTITLE).text("Returns");
					HtmlTable<?> tempResultsTable = tempSuiteResultsDiv.table();

					for (SuiteReturnDefinition tempReturn : tempSuite.getReturn()) {
						String tempName = tempReturn.getName().getName();

						String tempDocumentation = tempParsedComment == null ? null
								: tempParsedComment.getResultDocumentationTexts().getOrDefault(tempName, "");
						tempResultsTable.addChild(createParameterRow(tempName, false, null, tempDocumentation));
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
		HtmlDiv<?> tempMainDiv = aMainContainerDiv.div().classAttr(CSSClasses.ENTITYBOX + " constants");
		tempMainDiv.div().classAttr(CSSClasses.ENTITYSUMMARY + " constantsummary")
				.text(aPackage.getConstants().size() + " Constants");

		HtmlTable<?> tempTable = tempMainDiv.table().classAttr("constanttable");

		HtmlTr<?> tempHeaderRow = tempTable.tr();
		tempHeaderRow.th().classAttr(CSSClasses.SHRINK).text("Type");
		tempHeaderRow.th().classAttr(CSSClasses.SHRINK).text("Name");
		tempHeaderRow.th().classAttr(CSSClasses.EXPAND).text("Value");
		tempHeaderRow.th().classAttr(CSSClasses.EXPAND).text("Description");

		for (ConstantDefinition tempConstant : aPackage.getConstants()) {
			tempTable.addChild(createConstantRow(tempConstant, null, false));
		}

		return aPackage.getConstants().size();
	}

	/**
	 * Creates a table row describing the provided constant.
	 * 
	 * @param aConstant
	 * @return
	 * @throws ParseException
	 */
	protected HtmlTr<?> createConstantRow(ConstantDefinition aConstant, VariantDefinition aVariant,
			boolean aFullyQualifiedNameFlag) throws ParseException {
		HtmlTr<?> tempRow = new HtmlTr<>();

		String tempConstantDescription = "";
		if (aConstant.getDocumentation() != null) {
			ParsedDocumentationComment tempParsedComment = new ParsedDocumentationComment(aConstant.getDocumentation(),
					modelSourceExplorer.determineSourceInformation(aConstant.getDocumentation()));
			tempConstantDescription = tempParsedComment.getDocumentationText();
		}

		StringJoiner tempTypes = new StringJoiner(" ");
		if (aConstant.getPrivate() != null) {
			tempTypes.add(aConstant.getPrivate());
		}
		if (aConstant.getParameterized() != null) {
			tempTypes.add(aConstant.getParameterized());
		}

		tempRow.td().classAttr(CSSClasses.SHRINK).text(tempTypes.toString());
		tempRow.td().classAttr(CSSClasses.SHRINK + " " + CSSClasses.CODE)
				.text(aFullyQualifiedNameFlag
						? IntegrityDSLUtil.getQualifiedVariableEntityName(aConstant.getName(), true)
						: aConstant.getName().getName());
		HtmlTd<?> tempValueContainer = tempRow.td();
		tempValueContainer.classAttr(CSSClasses.EXPAND);

		if (aVariant == null) {
			// We shall print out all possible values of this constant
			if (aConstant.getVariantValues().size() == 0) {
				// No variants case - this is easy!
				resolveValue(aConstant.getValue()).forEach((anElement) -> {
					tempValueContainer.addChild(anElement);
				});
			} else {
				HtmlTable<?> tempVariantTable = new HtmlTable<>();
				if (aConstant.getValue() != null) {
					HtmlTr<?> tempVariantRow = tempVariantTable.tr();
					tempVariantRow.td().text("no variant:");
					HtmlTd<?> tempVariantValueContainer = tempVariantRow.td();
					resolveValue(aConstant.getValue()).forEach((anElement) -> {
						tempVariantValueContainer.addChild(anElement);
					});
				}

				for (VariantValue tempVariantValue : aConstant.getVariantValues()) {
					HtmlTr<?> tempVariantRow = tempVariantTable.tr();
					StringJoiner tempJoiner = new StringJoiner(", ");
					for (VariantDefinition tempVariant : tempVariantValue.getNames()) {
						tempJoiner.add(IntegrityDSLUtil.getQualifiedVariantName(tempVariant));
					}
					tempVariantRow.td().text("in " + tempJoiner.toString() + ":");
					HtmlTd<?> tempVariantValueContainer = tempVariantRow.td();
					resolveValue(tempVariantValue.getValue()).forEach(tempVariantValueContainer::addChild);
				}

				tempValueContainer.addChild(tempVariantTable);
			}
		} else {
			// A variant was provided, so we need to find out the value of this constant in this particular variant
			resolveValue(IntegrityDSLUtil.getInitialValueForConstant(aConstant, aVariant))
					.forEach(tempValueContainer::addChild);
		}

		tempRow.td().classAttr(CSSClasses.EXPAND).text(tempConstantDescription);

		return tempRow;
	}

	/**
	 * Processes all variants in a package.
	 * 
	 * @param anEntry
	 * @param aModelSourceExplorer
	 * @param aMainContainerDiv
	 * @throws ParseException
	 */
	protected int processVariants(IntegrityPackage aPackage, HtmlDiv<?> aMainContainerDiv) throws ParseException {
		if (aPackage.getVariants().size() == 0) {
			return 0;
		}

		HtmlAnchor<?> tempAnchor = new HtmlAnchor<>("variants");
		aMainContainerDiv.addChild(tempAnchor);
		HtmlDiv<?> tempMainDiv = aMainContainerDiv.div().classAttr(CSSClasses.ENTITYBOX + " variants");
		tempMainDiv.div().classAttr(CSSClasses.ENTITYSUMMARY + " variantsummary")
				.text(aPackage.getVariants().size() + " Variants");

		for (VariantDefinition tempVariant : aPackage.getVariants()) {
			HtmlDiv<?> tempVariantDiv = tempMainDiv.div().classAttr(CSSClasses.ENTITY + " variant");
			HtmlDiv<?> tempVariantHeaderDiv = tempVariantDiv.div().classAttr(CSSClasses.ENTITYHEADER);
			tempVariantHeaderDiv.div().classAttr(CSSClasses.ENTITYNAME).text(tempVariant.getName());
			if (tempVariant.getDescription() != null) {
				tempVariantHeaderDiv.div().classAttr(CSSClasses.ENTITYTITLE).text(tempVariant.getDescription());
			}
			tempVariantHeaderDiv.div().classAttr(CSSClasses.FULLENTITYNAME + " " + CSSClasses.CODE)
					.text(IntegrityDSLUtil.getQualifiedVariantName(tempVariant));

			if (tempVariant.getDocumentation() != null) {
				HtmlDiv<?> tempVariantDetailsDiv = tempVariantDiv.div().classAttr(CSSClasses.ENTITYDETAILS);
				ParsedDocumentationComment tempParsedComment = new ParsedDocumentationComment(
						tempVariant.getDocumentation(),
						modelSourceExplorer.determineSourceInformation(tempVariant.getDocumentation()));
				attachFormattedDocumentationText(tempVariantDetailsDiv.div().classAttr(CSSClasses.ENTITYDESCRIPTION),
						tempParsedComment.getDocumentationTextElements());
			}

			HtmlTable<?> tempTable = tempMainDiv.table().classAttr("constanttable");

			HtmlTr<?> tempHeaderRow = tempTable.tr();
			tempHeaderRow.th().classAttr(CSSClasses.SHRINK).text("Type");
			tempHeaderRow.th().classAttr(CSSClasses.SHRINK).text("Constant");
			tempHeaderRow.th().classAttr(CSSClasses.EXPAND).text("Value in Variant");
			tempHeaderRow.th().classAttr(CSSClasses.EXPAND).text("Description");

			for (ConstantDefinition tempConstant : aPackage.getConstantsInfluencedByVariant(tempVariant)) {
				tempTable.addChild(createConstantRow(tempConstant, tempVariant, true));
			}
		}

		return aPackage.getVariants().size();
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
		HtmlDiv<?> tempMainDiv = aMainContainerDiv.div().classAttr(CSSClasses.ENTITYBOX + " calls");
		tempMainDiv.div().classAttr(CSSClasses.ENTITYSUMMARY + " callsummary")
				.text(aPackage.getCalls().size() + " Call Fixtures");

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
		HtmlDiv<?> tempMainDiv = aMainContainerDiv.div().classAttr(CSSClasses.ENTITYBOX + " tests");
		tempMainDiv.div().classAttr(CSSClasses.ENTITYSUMMARY + " testsummary")
				.text(aPackage.getTests().size() + " Test Fixtures");

		for (TestDefinition tempTest : aPackage.getTests()) {
			tempMainDiv
					.addChild(createTestOrCallDiv(tempTest.getName(), IntegrityDSLUtil.getQualifiedTestName(tempTest),
							tempTest.getDocumentation(), tempTest.getFixtureMethod(), "test", "Results"));
		}

		return aPackage.getTests().size();
	}

	/**
	 * Processes all forks in a package.
	 * 
	 * @param aPackage
	 * @param aMainContainerDiv
	 * @return
	 * @throws ParseException
	 */
	protected int processForks(IntegrityPackage aPackage, HtmlDiv<?> aMainContainerDiv) throws ParseException {
		if (aPackage.getForks().size() == 0) {
			return 0;
		}

		HtmlAnchor<?> tempAnchor = new HtmlAnchor<>("forks");
		aMainContainerDiv.addChild(tempAnchor);
		HtmlDiv<?> tempMainDiv = aMainContainerDiv.div().classAttr(CSSClasses.ENTITYBOX + " forks");
		tempMainDiv.div().classAttr(CSSClasses.ENTITYSUMMARY + " forksummary")
				.text(aPackage.getForks().size() + " Forks");

		for (ForkDefinition tempFork : aPackage.getForks()) {
			HtmlDiv<?> tempVariantDiv = tempMainDiv.div().classAttr(CSSClasses.ENTITY + " fork");
			HtmlDiv<?> tempVariantHeaderDiv = tempVariantDiv.div().classAttr(CSSClasses.ENTITYHEADER);
			tempVariantHeaderDiv.div().classAttr(CSSClasses.ENTITYNAME).text(tempFork.getName());
			if (tempFork.getDescription() != null) {
				tempVariantHeaderDiv.div().classAttr(CSSClasses.ENTITYTITLE).text(tempFork.getDescription());
			}
			tempVariantHeaderDiv.div().classAttr(CSSClasses.FULLENTITYNAME + " " + CSSClasses.CODE)
					.text(IntegrityDSLUtil.getQualifiedForkName(tempFork));

			if (tempFork.getDocumentation() != null) {
				HtmlDiv<?> tempVariantDetailsDiv = tempVariantDiv.div().classAttr(CSSClasses.ENTITYDETAILS);
				ParsedDocumentationComment tempParsedComment = new ParsedDocumentationComment(
						tempFork.getDocumentation(),
						modelSourceExplorer.determineSourceInformation(tempFork.getDocumentation()));
				attachFormattedDocumentationText(tempVariantDetailsDiv.div().classAttr(CSSClasses.ENTITYDESCRIPTION),
						tempParsedComment.getDocumentationTextElements());

				if (tempFork.getParameters().size() > 0) {
					HtmlDiv<?> tempForkParamsDiv = tempVariantDetailsDiv.div().classAttr(CSSClasses.ENTITYPARAMS);
					tempForkParamsDiv.div().classAttr(CSSClasses.DETAILSTITLE).text("Parameters");
					HtmlTable<?> tempParamTable = tempForkParamsDiv.table();
					HtmlTr<?> tempHeaderRow = tempParamTable.tr();
					tempHeaderRow.th().classAttr(CSSClasses.SHRINK).text("Name");
					tempHeaderRow.th().classAttr(CSSClasses.SHRINK).text("Value");

					for (ForkParameter tempParameter : tempFork.getParameters()) {
						String tempParamName = IntegrityDSLUtil
								.getParamNameStringFromParameterName(tempParameter.getName());
						HtmlTr<?> tempRow = tempParamTable.tr();
						tempRow.td().classAttr(CSSClasses.CODE).text(tempParamName);
						tempRow.td().addChild(resolveSingleValue(tempParameter.getValue()));
					}
				}
			}
		}

		return aPackage.getForks().size();
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
		tempTestDiv.classAttr(CSSClasses.ENTITY + " " + anEntityName);
		HtmlDiv<?> tempTestHeaderDiv = tempTestDiv.div().classAttr(CSSClasses.ENTITYHEADER);
		tempTestHeaderDiv.div().classAttr(CSSClasses.ENTITYNAME).text(aShortName);
		tempTestHeaderDiv.div().classAttr(CSSClasses.FULLENTITYNAME + " " + CSSClasses.CODE)
				.text(anEntityName + " " + aQualifiedName);

		List<ParamAnnotationTypeTriplet> tempParams = IntegrityDSLUtil
				.getAllParamNamesFromFixtureMethod(aFixtureMethod);
		ParsedDocumentationComment tempParsedComment = (aDocComment != null ? new ParsedDocumentationComment(
				aDocComment, modelSourceExplorer.determineSourceInformation(aDocComment)) : null);

		if (tempParams.size() > 0 || tempParsedComment != null) {
			HtmlDiv<?> tempTestDetailsDiv = tempTestDiv.div().classAttr(CSSClasses.ENTITYDETAILS);
			if (tempParsedComment != null) {
				attachFormattedDocumentationText(tempTestDetailsDiv.div().classAttr(CSSClasses.ENTITYDESCRIPTION),
						tempParsedComment.getDocumentationTextElements());
			}

			if (tempParams.size() > 0) {
				HtmlDiv<?> tempTestParamsDiv = tempTestDetailsDiv.div().classAttr(CSSClasses.ENTITYPARAMS);
				tempTestParamsDiv.div().classAttr(CSSClasses.DETAILSTITLE).text("Parameters");
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
				HtmlDiv<?> tempCallResultsDiv = tempTestDetailsDiv.div().classAttr(CSSClasses.ENTITYPARAMS);
				tempCallResultsDiv.div().classAttr(CSSClasses.DETAILSTITLE).text(aReturnValueName);
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
		String tempTypeName = (aType != null ? JavaTypeUtil.getReadableJavaTypeName(aType) : "");

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
					tempTypeText.classAttr(CSSClasses.CODE + " " + "enumtype downtriangle");
					tempTypeText.addAttr("onclick", "toggleHiddenDiv(this.parentElement,this)");
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
	protected List<HtmlSpan<?>> resolveValue(ValueOrEnumValueOrOperationCollection aValueCollection) {
		if (aValueCollection instanceof ValueOrEnumValueOrOperationCollection) {
			if (aValueCollection.getMoreValues().size() > 0) {
				List<HtmlSpan<?>> tempElements = new ArrayList<HtmlSpan<?>>(
						aValueCollection.getMoreValues().size() + 1);
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
	protected HtmlSpan<?> resolveSingleValue(ValueOrEnumValueOrOperation aValue) {
		Object tempResult;
		try {
			tempResult = parameterResolver.resolveStatically(aValue, null);
		} catch (ClassNotFoundException | InstantiationException | UnexecutableException exc) {
			tempResult = UnresolvableVariable.getInstance();
		}

		HtmlSpan<?> tempP = new HtmlSpan<>();
		tempP.text(valueConverter.convertValueToString(tempResult, false, new ConversionContext()
				.withUnresolvableVariableHandlingPolicy(UnresolvableVariableHandling.RESOLVE_TO_UNRESOLVABLE_OBJECT))
				.toString());
		return tempP;
	}

}

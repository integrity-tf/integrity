/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.ui.highlighting;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator;

import com.google.inject.Inject;

import de.gebit.integrity.dsl.ArbitraryParameterOrResultName;
import de.gebit.integrity.dsl.BooleanValue;
import de.gebit.integrity.dsl.Call;
import de.gebit.integrity.dsl.DateAndTimeValue;
import de.gebit.integrity.dsl.DateValue;
import de.gebit.integrity.dsl.DecimalValue;
import de.gebit.integrity.dsl.EnumValue;
import de.gebit.integrity.dsl.FixedParameterName;
import de.gebit.integrity.dsl.FixedResultName;
import de.gebit.integrity.dsl.IntegerValue;
import de.gebit.integrity.dsl.JavaClassReference;
import de.gebit.integrity.dsl.MethodReference;
import de.gebit.integrity.dsl.NamedResult;
import de.gebit.integrity.dsl.NestedObject;
import de.gebit.integrity.dsl.NullValue;
import de.gebit.integrity.dsl.Operation;
import de.gebit.integrity.dsl.Parameter;
import de.gebit.integrity.dsl.ParameterName;
import de.gebit.integrity.dsl.ParameterTableHeader;
import de.gebit.integrity.dsl.RegexValue;
import de.gebit.integrity.dsl.ResultTableHeader;
import de.gebit.integrity.dsl.StringValue;
import de.gebit.integrity.dsl.SuiteParameter;
import de.gebit.integrity.dsl.TableTest;
import de.gebit.integrity.dsl.Test;
import de.gebit.integrity.dsl.TimeValue;
import de.gebit.integrity.dsl.Variable;
import de.gebit.integrity.services.DSLGrammarAccess;
import de.gebit.integrity.utils.IntegrityDSLUtil;

/**
 * The semantic highlight calculator is responsible for performing the more complex syntax highlighting.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class DSLSemanticHighlightingCalculator implements ISemanticHighlightingCalculator {

	/**
	 * The grammar access.
	 */
	@Inject
	private DSLGrammarAccess grammarAccess;

	@Override
	public void provideHighlightingFor(XtextResource aResource, IHighlightedPositionAcceptor anAcceptor) {
		if (aResource == null || aResource.getParseResult() == null) {
			return;
		}

		INode tempRoot = aResource.getParseResult().getRootNode();
		EObject tempLastSemanticElement = null;
		for (INode tempNode : tempRoot.getAsTreeIterable()) {
			EObject tempSemanticElement = tempNode.getSemanticElement();
			EObject tempGrammarElement = tempNode.getGrammarElement();
			if (tempGrammarElement instanceof CrossReference) {
				// There are different cross references which we want to highlight
				if (tempSemanticElement instanceof SuiteParameter) {
					anAcceptor.addPosition(tempNode.getOffset(), tempNode.getLength(),
							DSLHighlightingConfiguration.PARAMETER_NAME_ID);
				} else if (tempSemanticElement instanceof ParameterName) {
					anAcceptor.addPosition(tempNode.getOffset(), tempNode.getLength(),
							DSLHighlightingConfiguration.PARAMETER_NAME_ID);
				} else if (tempSemanticElement instanceof Test || tempSemanticElement instanceof Call
						|| tempSemanticElement instanceof TableTest) {
					int tempIndex = tempNode.getText().lastIndexOf('.');
					if (tempIndex >= 0) {
						anAcceptor.addPosition(tempNode.getOffset(), tempIndex,
								DSLHighlightingConfiguration.PACKAGE_PREFIX_ID);
					}
				} else if (tempSemanticElement instanceof Operation) {
					Boolean tempIsResult = IntegrityDSLUtil.isResult(tempSemanticElement);
					if (tempIsResult != null) {
						anAcceptor.addPosition(tempNode.getOffset(), tempNode.getLength(),
								tempIsResult ? DSLHighlightingConfiguration.RESULT_OPERATION_IDENTIFIER_ID
										: DSLHighlightingConfiguration.PARAMETER_OPERATION_IDENTIFIER_ID);
					}
				}
			} else if (tempGrammarElement == grammarAccess.getCustomOperationAccess().getWithKeyword_4_1()) {
				// Special case for the "with" keyword in operations
				Boolean tempIsResult = IntegrityDSLUtil.isResult(tempSemanticElement);
				if (tempIsResult != null) {
					anAcceptor.addPosition(tempNode.getOffset(), tempNode.getLength(),
							tempIsResult ? DSLHighlightingConfiguration.RESULT_OPERATION_IDENTIFIER_ID
									: DSLHighlightingConfiguration.PARAMETER_OPERATION_IDENTIFIER_ID);
				}
			} else if (tempGrammarElement == grammarAccess.getKeyValuePairAccess()
					.getIdentifierIDTerminalRuleCall_0_0_0()
					|| tempGrammarElement == grammarAccess.getKeyValuePairAccess()
							.getStringIdentifierSTRINGTerminalRuleCall_0_1_0()) {
				Boolean tempIsResult = IntegrityDSLUtil.isResult(tempSemanticElement);
				anAcceptor.addPosition(tempNode.getOffset(), tempNode.getLength(),
						tempIsResult == null ? DSLHighlightingConfiguration.NESTED_OBJECT_KEY_ID
								: (tempIsResult ? DSLHighlightingConfiguration.RESULT_NESTED_OBJECT_KEY_ID
										: DSLHighlightingConfiguration.PARAMETER_NESTED_OBJECT_KEY_ID));
			} else {
				// All other cases highlight entire semantic elements at once
				if (tempSemanticElement != null && tempLastSemanticElement != tempSemanticElement) {
					tempLastSemanticElement = tempSemanticElement;
					if (tempSemanticElement instanceof MethodReference) {
						anAcceptor.addPosition(tempNode.getOffset(), tempNode.getLength(),
								DSLHighlightingConfiguration.JAVA_CLASS_ID);
						int tempLastDotIndex = tempNode.getText().lastIndexOf('.');
						int tempHashIndex = tempNode.getText().lastIndexOf('#');
						if (tempLastDotIndex >= 0) {
							int tempStart = tempNode.getOffset() + tempLastDotIndex;
							int tempEnd = tempNode.getOffset()
									+ (tempHashIndex >= tempLastDotIndex ? tempHashIndex - 1 : tempNode.getLength());
							anAcceptor.addPosition(tempStart, tempEnd - tempStart,
									DSLHighlightingConfiguration.JAVA_CLASS_HIGHLIGHT_ID);
						}
						if (tempHashIndex >= 0) {
							int tempStart = tempNode.getOffset() + tempHashIndex;
							int tempEnd = tempNode.getOffset() + tempNode.getLength();
							anAcceptor.addPosition(tempStart, tempEnd - tempStart,
									DSLHighlightingConfiguration.JAVA_METHOD_HIGHLIGHT_ID);
						}
					} else if (tempSemanticElement instanceof JavaClassReference) {
						anAcceptor.addPosition(tempNode.getOffset(), tempNode.getLength(),
								DSLHighlightingConfiguration.JAVA_CLASS_ID);
						int tempLastDotIndex = tempNode.getText().lastIndexOf('.');
						if (tempLastDotIndex >= 0) {
							int tempStart = tempNode.getOffset() + tempLastDotIndex;
							int tempEnd = tempNode.getOffset() + tempNode.getLength();
							anAcceptor.addPosition(tempStart, tempEnd - tempStart,
									DSLHighlightingConfiguration.JAVA_CLASS_HIGHLIGHT_ID);
						}
					} else if (tempSemanticElement instanceof ArbitraryParameterOrResultName) {
						if (tempSemanticElement.eContainer() instanceof Parameter) {
							anAcceptor.addPosition(tempNode.getOffset(), tempNode.getLength(),
									DSLHighlightingConfiguration.PARAMETER_NAME_ID);
						} else if (tempSemanticElement.eContainer() instanceof ParameterTableHeader) {
							anAcceptor.addPosition(tempNode.getOffset(), tempNode.getLength(),
									DSLHighlightingConfiguration.PARAMETER_NAME_ID);
						} else if (tempSemanticElement.eContainer() instanceof ResultTableHeader) {
							anAcceptor.addPosition(tempNode.getOffset(), tempNode.getLength(),
									DSLHighlightingConfiguration.RESULT_NAME_ID);
						} else if (tempSemanticElement.eContainer() instanceof NamedResult) {
							anAcceptor.addPosition(tempNode.getOffset(), tempNode.getLength(),
									DSLHighlightingConfiguration.RESULT_NAME_ID);
						}
					} else if (tempSemanticElement instanceof FixedParameterName) {
						anAcceptor.addPosition(tempNode.getOffset(), tempNode.getLength(),
								DSLHighlightingConfiguration.PARAMETER_NAME_ID);
					} else if (tempSemanticElement instanceof FixedResultName) {
						anAcceptor.addPosition(tempNode.getOffset(), tempNode.getLength(),
								DSLHighlightingConfiguration.RESULT_NAME_ID);
					} else {
						if (tempSemanticElement instanceof IntegerValue
								|| tempSemanticElement instanceof DecimalValue) {
							Boolean tempIsResult = IntegrityDSLUtil.isResult(tempSemanticElement);
							if (tempIsResult != null) {
								anAcceptor.addPosition(tempNode.getOffset(), tempNode.getLength(),
										tempIsResult ? DSLHighlightingConfiguration.RESULT_NUMBER_ID
												: DSLHighlightingConfiguration.PARAMETER_NUMBER_ID);
							}
						} else if (tempSemanticElement instanceof StringValue) {
							Boolean tempIsResult = IntegrityDSLUtil.isResult(tempSemanticElement);
							if (tempIsResult != null) {
								anAcceptor.addPosition(tempNode.getOffset(), tempNode.getLength(),
										tempIsResult ? DSLHighlightingConfiguration.RESULT_STRING_ID
												: DSLHighlightingConfiguration.PARAMETER_STRING_ID);
							}
						} else if (tempSemanticElement instanceof RegexValue) {
							Boolean tempIsResult = IntegrityDSLUtil.isResult(tempSemanticElement);
							if (tempIsResult != null) {
								anAcceptor.addPosition(tempNode.getOffset(), tempNode.getLength(),
										tempIsResult ? DSLHighlightingConfiguration.RESULT_REGEX_ID
												: DSLHighlightingConfiguration.PARAMETER_REGEX_ID);
							}
						} else if (tempSemanticElement instanceof DateValue || tempSemanticElement instanceof TimeValue
								|| tempSemanticElement instanceof DateAndTimeValue) {
							Boolean tempIsResult = IntegrityDSLUtil.isResult(tempSemanticElement);
							if (tempIsResult != null) {
								anAcceptor.addPosition(tempNode.getOffset(), tempNode.getLength(),
										tempIsResult ? DSLHighlightingConfiguration.RESULT_DATE_TIME_ID
												: DSLHighlightingConfiguration.PARAMETER_DATE_TIME_ID);
							}
						} else if (tempSemanticElement instanceof Variable) {
							Boolean tempIsResult = IntegrityDSLUtil.isResult(tempSemanticElement);
							if (tempIsResult != null) {
								anAcceptor.addPosition(tempNode.getOffset(), tempNode.getLength(),
										tempIsResult ? DSLHighlightingConfiguration.RESULT_VARIABLE_VALUE_ID
												: DSLHighlightingConfiguration.PARAMETER_VARIABLE_VALUE_ID);
							}
						} else if (tempSemanticElement instanceof NullValue || tempSemanticElement instanceof EnumValue
								|| tempSemanticElement instanceof BooleanValue) {
							Boolean tempIsResult = IntegrityDSLUtil.isResult(tempSemanticElement);
							if (tempIsResult != null) {
								anAcceptor.addPosition(tempNode.getOffset(), tempNode.getLength(),
										tempIsResult ? DSLHighlightingConfiguration.RESULT_CONSTANT_VALUE_ID
												: DSLHighlightingConfiguration.PARAMETER_CONSTANT_VALUE_ID);
							}
						} else if (tempSemanticElement instanceof Operation) {
							Boolean tempIsResult = IntegrityDSLUtil.isResult(tempSemanticElement);
							if (tempIsResult != null) {
								anAcceptor.addPosition(tempNode.getOffset(), tempNode.getLength(),
										tempIsResult ? DSLHighlightingConfiguration.RESULT_OPERATION_ID
												: DSLHighlightingConfiguration.PARAMETER_OPERATION_ID);
							}
						} else if (tempSemanticElement instanceof NestedObject) {
							Boolean tempIsResult = IntegrityDSLUtil.isResult(tempSemanticElement);
							if (tempIsResult != null) {
								anAcceptor.addPosition(tempNode.getOffset(), tempNode.getLength(),
										tempIsResult ? DSLHighlightingConfiguration.RESULT_NESTED_OBJECT_ID
												: DSLHighlightingConfiguration.PARAMETER_NESTED_OBJECT_ID);
							}
						}
					}
				}
			}
		}
	}
}

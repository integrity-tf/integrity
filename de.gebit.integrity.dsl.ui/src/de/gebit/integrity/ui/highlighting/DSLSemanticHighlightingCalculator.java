/**
 * 
 */
package de.gebit.integrity.ui.highlighting;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator;

import de.gebit.integrity.dsl.ArbitraryParameterOrResultName;
import de.gebit.integrity.dsl.BooleanValue;
import de.gebit.integrity.dsl.Call;
import de.gebit.integrity.dsl.DecimalValue;
import de.gebit.integrity.dsl.EnumValue;
import de.gebit.integrity.dsl.FixedParameterName;
import de.gebit.integrity.dsl.FixedResultName;
import de.gebit.integrity.dsl.IntegerValue;
import de.gebit.integrity.dsl.JavaClassReference;
import de.gebit.integrity.dsl.MethodReference;
import de.gebit.integrity.dsl.NamedCallResult;
import de.gebit.integrity.dsl.NamedResult;
import de.gebit.integrity.dsl.NullValue;
import de.gebit.integrity.dsl.Parameter;
import de.gebit.integrity.dsl.ParameterName;
import de.gebit.integrity.dsl.ParameterTableHeader;
import de.gebit.integrity.dsl.ParameterTableValue;
import de.gebit.integrity.dsl.ResultTableHeader;
import de.gebit.integrity.dsl.StringValue;
import de.gebit.integrity.dsl.Suite;
import de.gebit.integrity.dsl.SuiteParameter;
import de.gebit.integrity.dsl.TableTest;
import de.gebit.integrity.dsl.TableTestRow;
import de.gebit.integrity.dsl.Test;
import de.gebit.integrity.dsl.ValueOrEnumValueCollection;
import de.gebit.integrity.dsl.Variable;

/**
 * The semantic highlight calculator is responsible for performing the more complex syntax highlighting.
 * 
 * @author Rene Schneider
 * 
 */
public class DSLSemanticHighlightingCalculator implements ISemanticHighlightingCalculator {

	@Override
	public void provideHighlightingFor(XtextResource aResource, IHighlightedPositionAcceptor anAcceptor) {
		if (aResource == null || aResource.getParseResult() == null) {
			return;
		}

		INode tempRoot = aResource.getParseResult().getRootNode();
		EObject tempLastSemanticElement = null;
		for (INode tempNode : tempRoot.getAsTreeIterable()) {
			EObject tempSemanticElement = tempNode.getSemanticElement();
			if (tempNode.getGrammarElement() instanceof CrossReference) {
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
				}
			} else {
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
						if (tempSemanticElement instanceof IntegerValue || tempSemanticElement instanceof DecimalValue) {
							Boolean tempIsResult = isResult(tempSemanticElement);
							if (tempIsResult != null) {
								anAcceptor.addPosition(tempNode.getOffset(), tempNode.getLength(),
										tempIsResult ? DSLHighlightingConfiguration.RESULT_NUMBER_ID
												: DSLHighlightingConfiguration.PARAMETER_NUMBER_ID);
							}
						} else if (tempSemanticElement instanceof StringValue) {
							Boolean tempIsResult = isResult(tempSemanticElement);
							if (tempIsResult != null) {
								anAcceptor.addPosition(tempNode.getOffset(), tempNode.getLength(),
										tempIsResult ? DSLHighlightingConfiguration.RESULT_STRING_ID
												: DSLHighlightingConfiguration.PARAMETER_STRING_ID);
							}
						} else if (tempSemanticElement instanceof Variable) {
							Boolean tempIsResult = isResult(tempSemanticElement);
							if (tempIsResult != null) {
								anAcceptor.addPosition(tempNode.getOffset(), tempNode.getLength(),
										tempIsResult ? DSLHighlightingConfiguration.RESULT_VARIABLE_VALUE_ID
												: DSLHighlightingConfiguration.PARAMETER_VARIABLE_VALUE_ID);
							}
						} else if (tempSemanticElement instanceof NullValue || tempSemanticElement instanceof EnumValue
								|| tempSemanticElement instanceof BooleanValue) {
							Boolean tempIsResult = isResult(tempSemanticElement);
							if (tempIsResult != null) {
								anAcceptor.addPosition(tempNode.getOffset(), tempNode.getLength(),
										tempIsResult ? DSLHighlightingConfiguration.RESULT_CONSTANT_VALUE_ID
												: DSLHighlightingConfiguration.PARAMETER_CONSTANT_VALUE_ID);
							}
						}
					}
				}
			}
		}
	}

	private Boolean isResult(EObject anObject) {
		if (anObject.eContainer() instanceof ValueOrEnumValueCollection) {
			ValueOrEnumValueCollection tempCollection = (ValueOrEnumValueCollection) anObject.eContainer();
			if (tempCollection.eContainer() instanceof Test) {
				return ((Test) tempCollection.eContainer()).getResult() == tempCollection;
			} else if (tempCollection.eContainer() instanceof Suite) {
				return false;
			} else if (tempCollection.eContainer() instanceof NamedResult) {
				NamedResult tempResult = (NamedResult) tempCollection.eContainer();
				if (tempResult.eContainer() instanceof Test || tempResult.eContainer() instanceof TableTest) {
					return true;
				}
			} else if (tempCollection.eContainer() instanceof ParameterTableValue) {
				ParameterTableValue tempParameter = (ParameterTableValue) tempCollection.eContainer();
				TableTestRow tempRow = (TableTestRow) tempParameter.eContainer();
				int tempColumnNumber = tempRow.getValues().indexOf(tempParameter);
				if (tempColumnNumber >= 0) {
					TableTest tempTest = (TableTest) tempRow.eContainer();
					return (tempColumnNumber >= tempTest.getParameterHeaders().size());
				}
			} else if (tempCollection.eContainer() instanceof Parameter) {
				Parameter tempParameter = (Parameter) tempCollection.eContainer();
				if (tempParameter.eContainer() instanceof Test || tempParameter.eContainer() instanceof Call
						|| tempParameter.eContainer() instanceof TableTest) {
					return false;
				}
			}
		} else if (anObject.eContainer() instanceof Call) {
			return ((Call) anObject.eContainer()).getResult() == anObject;
		} else if (anObject.eContainer() instanceof NamedCallResult) {
			return true;
		} else if (anObject.eContainer() instanceof SuiteParameter) {
			return false;
		}

		return null;
	}
}

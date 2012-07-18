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

import de.gebit.integrity.dsl.BooleanValue;
import de.gebit.integrity.dsl.Call;
import de.gebit.integrity.dsl.DecimalValue;
import de.gebit.integrity.dsl.EnumValue;
import de.gebit.integrity.dsl.IntegerValue;
import de.gebit.integrity.dsl.JavaClassReference;
import de.gebit.integrity.dsl.MethodReference;
import de.gebit.integrity.dsl.NullValue;
import de.gebit.integrity.dsl.ParameterName;
import de.gebit.integrity.dsl.StringValue;
import de.gebit.integrity.dsl.TableTest;
import de.gebit.integrity.dsl.Test;
import de.gebit.integrity.dsl.ValueOrEnumValueCollection;

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
				if (tempSemanticElement instanceof ParameterName) {
					anAcceptor.addPosition(tempNode.getOffset(), tempNode.getLength(),
							DSLHighlightingConfiguration.PARAMETER_ID);
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
					} else if (isTestResult(tempSemanticElement)) {
						if (tempSemanticElement instanceof IntegerValue || tempSemanticElement instanceof DecimalValue) {
							anAcceptor.addPosition(tempNode.getOffset(), tempNode.getLength(),
									DSLHighlightingConfiguration.RESULT_NUMBER_ID);
						} else if (tempSemanticElement instanceof StringValue) {
							anAcceptor.addPosition(tempNode.getOffset(), tempNode.getLength(),
									DSLHighlightingConfiguration.RESULT_STRING_ID);
						} else if (tempSemanticElement instanceof NullValue || tempSemanticElement instanceof EnumValue
								|| tempSemanticElement instanceof BooleanValue) {
							anAcceptor.addPosition(tempNode.getOffset(), tempNode.getLength(),
									DSLHighlightingConfiguration.RESULT_CONSTANT_VALUE_ID);
						}
					}
				}
			}
		}
	}

	private boolean isTestResult(EObject anObject) {
		if (anObject.eContainer() instanceof ValueOrEnumValueCollection) {
			ValueOrEnumValueCollection tempCollection = (ValueOrEnumValueCollection) anObject.eContainer();
			if (tempCollection.eContainer() instanceof Test) {
				return ((Test) tempCollection.eContainer()).getResult() == tempCollection;
			}
		}

		return false;
	}

}

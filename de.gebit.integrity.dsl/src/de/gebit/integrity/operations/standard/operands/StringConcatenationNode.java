/**
 * 
 */
package de.gebit.integrity.operations.standard.operands;


/**
 * 
 * 
 * @author Slartibartfast
 * 
 */
public class StringConcatenationNode extends OperatorNode<String, String> {

	public StringConcatenationNode(Object aLeftOperand, Object aRightOperand) {
		super(aLeftOperand, aRightOperand);
	}

	@Override
	protected Object evaluateInternal(String aLeftOperand, String aRightOperand) {
		return aLeftOperand + aRightOperand;
	}
}

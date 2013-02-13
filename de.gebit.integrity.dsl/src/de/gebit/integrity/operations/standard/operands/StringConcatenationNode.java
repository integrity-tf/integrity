/**
 * 
 */
package de.gebit.integrity.operations.standard.operands;

/**
 * Concatenates two strings.
 * 
 * @author Rene Schneider
 * 
 */
public class StringConcatenationNode extends OperatorNode<String, String> {

	/**
	 * Creates a new instance.
	 * 
	 * @param aLeftOperand
	 *            the left operand
	 * @param aRightOperand
	 *            the right operand
	 */
	public StringConcatenationNode(Object aLeftOperand, Object aRightOperand) {
		super(aLeftOperand, aRightOperand);
	}

	@Override
	protected Object evaluateInternal(String aLeftOperand, String aRightOperand) {
		String tempLeftOperand = aLeftOperand == null ? "null" : aLeftOperand;
		String tempRightOperand = aRightOperand == null ? "null" : aRightOperand;

		return tempLeftOperand + tempRightOperand;
	}
}

/**
 * 
 */
package de.gebit.integrity.operations.standard.operands;

import java.math.BigDecimal;

/**
 * Multiplies two numbers.
 * 
 * @author Rene Schneider
 * 
 */
public class MultiplicationNode extends OperatorNode<BigDecimal, BigDecimal> {

	/**
	 * Creates an instance.
	 * 
	 * @param aLeftOperand
	 * @param aRightOperand
	 */
	public MultiplicationNode(Object aLeftOperand, Object aRightOperand) {
		super(aLeftOperand, aRightOperand);
	}

	@Override
	protected Object evaluateInternal(BigDecimal aLeftOperand, BigDecimal aRightOperand) {
		return aLeftOperand.multiply(aRightOperand);
	}
}

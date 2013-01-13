/**
 * 
 */
package de.gebit.integrity.operations.standard.operands;

import java.math.BigDecimal;

/**
 * 
 * 
 * @author Slartibartfast
 * 
 */
public class MultiplicationNode extends OperatorNode<BigDecimal, BigDecimal> {

	public MultiplicationNode(Object aLeftOperand, Object aRightOperand) {
		super(aLeftOperand, aRightOperand);
	}

	@Override
	protected Object evaluateInternal(BigDecimal aLeftOperand, BigDecimal aRightOperand) {
		return aLeftOperand.multiply(aRightOperand);
	}
}

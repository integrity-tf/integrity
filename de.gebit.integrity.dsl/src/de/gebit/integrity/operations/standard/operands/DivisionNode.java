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
public class DivisionNode extends OperatorNode<BigDecimal, BigDecimal> {

	public DivisionNode(Object aLeftOperand, Object aRightOperand) {
		super(aLeftOperand, aRightOperand);
	}

	@Override
	protected Object evaluateInternal(BigDecimal aLeftOperand, BigDecimal aRightOperand) {
		// Conversion to double values is necessary because BigDecimal division fails hard in case of periodic results.
		return new BigDecimal(aLeftOperand.doubleValue() / aRightOperand.doubleValue());
	}
}

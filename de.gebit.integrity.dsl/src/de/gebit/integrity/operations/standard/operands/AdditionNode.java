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
public class AdditionNode extends OperatorNode<BigDecimal, BigDecimal> {

	public AdditionNode(Object aLeftOperand, Object aRightOperand) {
		super(aLeftOperand, aRightOperand);
	}

	@Override
	protected Object evaluateInternal(BigDecimal aLeftOperand, BigDecimal aRightOperand) {
		return aLeftOperand.add(aRightOperand);
	}
}

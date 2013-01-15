/**
 * 
 */
package de.gebit.integrity.operations.standard.operands;

import java.math.BigDecimal;

/**
 * Adds two values. Always uses BigDecimals since those can cover the whole range of values supported by Integrity.
 * 
 * @author Rene Schneider
 * 
 */
public class AdditionNode extends OperatorNode<BigDecimal, BigDecimal> {

	/**
	 * Constructs a new instance.
	 * 
	 * @param aLeftOperand
	 * @param aRightOperand
	 */
	public AdditionNode(Object aLeftOperand, Object aRightOperand) {
		super(aLeftOperand, aRightOperand);
	}

	@Override
	protected Object evaluateInternal(BigDecimal aLeftOperand, BigDecimal aRightOperand) {
		return aLeftOperand.add(aRightOperand);
	}
}

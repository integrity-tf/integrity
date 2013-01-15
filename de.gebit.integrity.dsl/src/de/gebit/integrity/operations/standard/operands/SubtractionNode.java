/**
 * 
 */
package de.gebit.integrity.operations.standard.operands;

import java.math.BigDecimal;

/**
 * Subtracts one value from the other.
 * 
 * @author Rene Schneider
 * 
 */
public class SubtractionNode extends OperatorNode<BigDecimal, BigDecimal> {

	/**
	 * Creates a new instance.
	 * 
	 * @param aLeftOperand
	 * @param aRightOperand
	 */
	public SubtractionNode(Object aLeftOperand, Object aRightOperand) {
		super(aLeftOperand, aRightOperand);
	}

	@Override
	protected Object evaluateInternal(BigDecimal aLeftOperand, BigDecimal aRightOperand) {
		return aLeftOperand.subtract(aRightOperand);
	}
}

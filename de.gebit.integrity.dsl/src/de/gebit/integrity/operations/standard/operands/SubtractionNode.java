/**
 * 
 */
package de.gebit.integrity.operations.standard.operands;

import java.math.BigDecimal;

import de.gebit.integrity.operations.UnexecutableException;

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
	protected Object evaluateInternal(BigDecimal aLeftOperand, BigDecimal aRightOperand) throws UnexecutableException {
		if (aLeftOperand == null) {
			throw new UnexecutableException("Cannot evaluate operation: left operand missing!");
		} else if (aRightOperand == null) {
			throw new UnexecutableException("Cannot evaluate operation: right operand missing!");
		}
		return aLeftOperand.subtract(aRightOperand);
	}
}

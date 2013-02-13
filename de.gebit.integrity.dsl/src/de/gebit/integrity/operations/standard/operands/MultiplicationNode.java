/**
 * 
 */
package de.gebit.integrity.operations.standard.operands;

import java.math.BigDecimal;

import de.gebit.integrity.operations.UnexecutableException;

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
	protected Object evaluateInternal(BigDecimal aLeftOperand, BigDecimal aRightOperand) throws UnexecutableException {
		if (aLeftOperand == null) {
			throw new UnexecutableException("Cannot evaluate operation: left operand missing!");
		} else if (aRightOperand == null) {
			throw new UnexecutableException("Cannot evaluate operation: right operand missing!");
		}
		return aLeftOperand.multiply(aRightOperand);
	}
}

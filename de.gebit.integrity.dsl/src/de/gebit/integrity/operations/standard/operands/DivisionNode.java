/**
 * 
 */
package de.gebit.integrity.operations.standard.operands;

import java.math.BigDecimal;

import de.gebit.integrity.operations.UnexecutableException;

/**
 * Divides two numbers. Uses double values as input since BigDecimals cannot always be divided, for example in case of
 * periodic results.
 * 
 * @author Rene Schneider
 * 
 */
public class DivisionNode extends OperatorNode<Double, Double> {

	/**
	 * Creates a new instance.
	 * 
	 * @param aLeftOperand
	 * @param aRightOperand
	 */
	public DivisionNode(Object aLeftOperand, Object aRightOperand) {
		super(aLeftOperand, aRightOperand);
	}

	@Override
	protected Object evaluateInternal(Double aLeftOperand, Double aRightOperand) throws UnexecutableException {
		if (aLeftOperand == null) {
			throw new UnexecutableException("Cannot evaluate operation: left operand missing!");
		} else if (aRightOperand == null) {
			throw new UnexecutableException("Cannot evaluate operation: right operand missing!");
		}
		return new BigDecimal(aLeftOperand / aRightOperand);
	}
}

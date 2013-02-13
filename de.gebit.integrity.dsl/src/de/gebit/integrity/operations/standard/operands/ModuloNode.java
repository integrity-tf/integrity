/**
 * 
 */
package de.gebit.integrity.operations.standard.operands;

import java.math.BigInteger;

import de.gebit.integrity.operations.UnexecutableException;

/**
 * Modulo calculation.
 * 
 * @author Rene Schneider
 * 
 */
public class ModuloNode extends OperatorNode<BigInteger, BigInteger> {

	/**
	 * Creates a new instance.
	 * 
	 * @param aLeftOperand
	 * @param aRightOperand
	 */
	public ModuloNode(Object aLeftOperand, Object aRightOperand) {
		super(aLeftOperand, aRightOperand);
	}

	@Override
	protected Object evaluateInternal(BigInteger aLeftOperand, BigInteger aRightOperand) throws UnexecutableException {
		if (aLeftOperand == null) {
			throw new UnexecutableException("Cannot evaluate operation: left operand missing!");
		} else if (aRightOperand == null) {
			throw new UnexecutableException("Cannot evaluate operation: right operand missing!");
		}
		return aLeftOperand.mod(aRightOperand);
	}
}

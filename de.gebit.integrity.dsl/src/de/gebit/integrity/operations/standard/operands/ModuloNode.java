/**
 * 
 */
package de.gebit.integrity.operations.standard.operands;

import java.math.BigInteger;

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
	protected Object evaluateInternal(BigInteger aLeftOperand, BigInteger aRightOperand) {
		return aLeftOperand.mod(aRightOperand);
	}
}

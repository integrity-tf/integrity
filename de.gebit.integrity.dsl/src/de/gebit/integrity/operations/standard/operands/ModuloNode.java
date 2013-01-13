/**
 * 
 */
package de.gebit.integrity.operations.standard.operands;

import java.math.BigInteger;

/**
 * 
 * 
 * @author Slartibartfast
 * 
 */
public class ModuloNode extends OperatorNode<BigInteger, BigInteger> {

	public ModuloNode(Object aLeftOperand, Object aRightOperand) {
		super(aLeftOperand, aRightOperand);
	}

	@Override
	protected Object evaluateInternal(BigInteger aLeftOperand, BigInteger aRightOperand) {
		return aLeftOperand.mod(aRightOperand);
	}
}

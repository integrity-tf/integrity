/**
 * 
 */
package de.gebit.integrity.operations.standard;

import de.gebit.integrity.operations.standard.operands.AdditionNode;
import de.gebit.integrity.operations.standard.operands.DivisionNode;
import de.gebit.integrity.operations.standard.operands.ModuloNode;
import de.gebit.integrity.operations.standard.operands.MultiplicationNode;
import de.gebit.integrity.operations.standard.operands.StringConcatenationNode;
import de.gebit.integrity.operations.standard.operands.SubtractionNode;

/**
 * 
 * 
 * @author Slartibartfast
 * 
 */
public class DefaultModularStandardOperationProcessor extends AbstractModularStandardOperationProcessor {

	protected void initializeOperatorInfo() {
		addOperatorInfo("+", AdditionNode.class);
		addOperatorInfo("-", SubtractionNode.class);
		addOperatorInfo("*", MultiplicationNode.class);
		addOperatorInfo("/", DivisionNode.class);
		addOperatorInfo("%", ModuloNode.class);
		addOperatorInfo("..", StringConcatenationNode.class);
	}

}

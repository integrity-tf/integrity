/**
 * 
 */
package de.gebit.integrity.operations.standard;

import de.gebit.integrity.dsl.StandardOperation;
import de.gebit.integrity.operations.UnexecutableException;

/**
 * 
 * 
 * @author Slartibartfast
 * 
 */
public interface StandardOperationProcessor {

	Object executeOperation(StandardOperation anOperation) throws UnexecutableException;

}

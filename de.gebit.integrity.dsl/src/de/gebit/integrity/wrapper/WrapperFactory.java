/**
 * 
 */
package de.gebit.integrity.wrapper;

import org.eclipse.xtext.common.types.JvmType;

import de.gebit.integrity.dsl.Operation;
import de.gebit.integrity.fixtures.FixtureWrapper;
import de.gebit.integrity.operations.OperationWrapper;

/**
 * 
 * 
 * @author Rene Schneider
 * 
 */
public interface WrapperFactory {

	FixtureWrapper<?> newFixtureWrapper(JvmType aFixtureType) throws ClassNotFoundException, InstantiationException,
			IllegalAccessException;

	OperationWrapper newOperationWrapper(Operation anOperation) throws ClassNotFoundException;

}

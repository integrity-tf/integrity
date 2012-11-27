/**
 * 
 */
package de.gebit.integrity.wrapper;

import org.eclipse.xtext.common.types.JvmType;

import de.gebit.integrity.dsl.Operation;
import de.gebit.integrity.fixtures.FixtureWrapper;
import de.gebit.integrity.operations.OperationWrapper;

/**
 * The wrapper factory is responsible for the actual creation of the {@link FixtureWrapper} and {@link OperationWrapper}
 * instances. This also includes instantiation of the fixture/operation classes.
 * 
 * @author Rene Schneider
 * 
 */
public interface WrapperFactory {

	/**
	 * Creates a new {@link FixtureWrapper} for the given {@link JvmType}.
	 * 
	 * @param aFixtureType
	 *            the fixture type to instantiate
	 * @return the {@link FixtureWrapper} instance
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	FixtureWrapper<?> newFixtureWrapper(JvmType aFixtureType) throws ClassNotFoundException, InstantiationException,
			IllegalAccessException;

	/**
	 * Creates a new {@link OperationWrapper} for the given {@link Operation}.
	 * 
	 * @param anOperation
	 *            the operation to instantiate
	 * @return the {@link OperationWrapper} instance
	 * @throws ClassNotFoundException
	 */
	OperationWrapper newOperationWrapper(Operation anOperation) throws ClassNotFoundException;

}

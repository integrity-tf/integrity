/**
 * 
 */
package de.gebit.integrity.runner.wrapper;

import org.eclipse.xtext.common.types.JvmType;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Singleton;

import de.gebit.integrity.dsl.Operation;
import de.gebit.integrity.fixtures.FixtureWrapper;
import de.gebit.integrity.operations.OperationWrapper;
import de.gebit.integrity.wrapper.WrapperFactory;

/**
 * 
 * 
 * @author Rene Schneider
 * 
 */
@Singleton
public class DefaultWrapperFactory implements WrapperFactory {

	/**
	 * The classloader to use.
	 */
	@Inject
	private ClassLoader classLoader;

	/**
	 * The {@link Injector} to use for injection of dependencies into the new wrapper.
	 */
	@Inject
	private Injector injector;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public FixtureWrapper<?> newFixtureWrapper(JvmType aFixtureType) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException {
		Class<?> tempClass = classLoader.loadClass(aFixtureType.getQualifiedName());
		FixtureWrapper<?> tempWrapper = new FixtureWrapper(tempClass);
		injector.injectMembers(tempWrapper);
		return tempWrapper;
	}

	@Override
	public OperationWrapper newOperationWrapper(Operation anOperation) throws ClassNotFoundException {
		OperationWrapper tempWrapper = new OperationWrapper(anOperation, classLoader);
		injector.injectMembers(tempWrapper);
		return tempWrapper;
	}
}

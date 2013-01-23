package de.gebit.integrity.runner.variables;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.google.inject.Singleton;

import de.gebit.integrity.dsl.ConstantEntity;
import de.gebit.integrity.dsl.VariableOrConstantEntity;
import de.gebit.integrity.parameter.variables.VariableManager;

/**
 * The simple, default variable manager which keeps variables in a map.
 * 
 * @author Rene Schneider
 * 
 */
@Singleton
public class DefaultVariableManager implements VariableManager {

	/**
	 * The map used to store variables.
	 */
	protected Map<VariableOrConstantEntity, Object> variableMap = new HashMap<VariableOrConstantEntity, Object>();

	@Override
	public Object get(VariableOrConstantEntity anEntity) {
		return variableMap.get(anEntity);
	}

	@Override
	public void set(VariableOrConstantEntity anEntity, Object aValue) {
		if (anEntity instanceof ConstantEntity) {
			if (variableMap.containsKey(anEntity)) {
				throw new RuntimeException("Illegal attempt to redefine a constant: " + anEntity.getName());
			}
		}
		variableMap.put(anEntity, aValue);
	}

	@Override
	public void unset(VariableOrConstantEntity anEntity) {
		variableMap.remove(anEntity);
	}

	@Override
	public Set<Entry<VariableOrConstantEntity, Object>> getAllEntries() {
		return variableMap.entrySet();
	}

	@Override
	public void clear(boolean aClearConstantsFlag) {
		if (aClearConstantsFlag) {
			variableMap.clear();
		} else {
			// Pick all non-constants out of the map, leave the constants untouched.
			Iterator<Entry<VariableOrConstantEntity, Object>> tempIterator = variableMap.entrySet().iterator();
			while (tempIterator.hasNext()) {
				if (!(tempIterator.next().getKey() instanceof ConstantEntity)) {
					tempIterator.remove();
				}
			}
		}
	}

}

package de.gebit.integrity.runner.variables;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.google.inject.Singleton;

import de.gebit.integrity.dsl.VariableEntity;
import de.gebit.integrity.parameter.variables.VariableManager;
import de.gebit.integrity.utils.IntegrityDSLUtil;

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
	protected Map<VariableEntity, Object> variableMap = new HashMap<VariableEntity, Object>();

	@Override
	public Object get(VariableEntity anEntity) {
		return variableMap.get(anEntity);
	}

	@Override
	public void set(VariableEntity anEntity, Object aValue) {
		variableMap.put(anEntity, aValue);
	}

	@Override
	public VariableEntity findEntity(String aQualifiedEntityName) {
		for (VariableEntity tempEntity : variableMap.keySet()) {
			if (IntegrityDSLUtil.getQualifiedVariableEntityName(tempEntity, true).equals(aQualifiedEntityName)) {
				return tempEntity;
			}
		}

		return null;
	}

	@Override
	public Set<Entry<VariableEntity, Object>> getAllEntries() {
		return variableMap.entrySet();
	}

	@Override
	public void clear() {
		variableMap.clear();
	}

}

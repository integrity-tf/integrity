package de.integrity.fixtures;

import java.util.Map;

public interface Fixture {

	Object execute(String aName, Map<String, Object> someParameters);

}

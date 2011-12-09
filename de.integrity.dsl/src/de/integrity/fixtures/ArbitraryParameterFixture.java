package de.integrity.fixtures;

import java.util.List;
import java.util.Map;

public abstract class ArbitraryParameterFixture extends Fixture {

	public abstract List<ArbitraryParameterDefinition> defineArbitraryParameters(String aFixtureName,
			Map<String, Object> someFixedParameters);

	public class ArbitraryParameterDefinition {

		private String name;

		private Class<?> type;

		private String description;

		public ArbitraryParameterDefinition(String aName, Class<?> aType, String aDescription) {
			name = aName;
			type = aType;
			description = aDescription;
		}

		public String getName() {
			return name;
		}

		public Class<?> getType() {
			return type;
		}

		public String getDescription() {
			return description;
		}

	}

}

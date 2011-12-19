package de.gebit.integrity.fixtures;

import java.util.List;
import java.util.Map;

import org.eclipse.jdt.core.IType;

public abstract class ArbitraryParameterFixture extends Fixture {

	public abstract List<ArbitraryParameterDefinition> defineArbitraryParameters(String aFixtureName,
			Map<String, Object> someFixedParameters, EclipseResourceProvider aResourceProvider);

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

	public static abstract interface EclipseResourceProvider {

		IType findCompilationUnitForClassName(String aClassName);

	}

}

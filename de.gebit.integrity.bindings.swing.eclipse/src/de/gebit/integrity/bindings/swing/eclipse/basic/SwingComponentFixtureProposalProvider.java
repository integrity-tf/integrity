package de.gebit.integrity.bindings.swing.eclipse.basic;

import java.awt.Component;
import java.util.List;
import java.util.Map;

import de.gebit.integrity.bindings.swing.eclipse.AbstractSwingFixtureAssist;
import de.gebit.integrity.fixtures.CustomProposalProvider;

public abstract class SwingComponentFixtureProposalProvider extends AbstractSwingFixtureAssist implements
		CustomProposalProvider {

	protected abstract Class<? extends Component> getComponentClass();

	@Override
	public List<CustomProposalDefinition> defineParameterProposals(String aFixtureMethodName, String aParameterName,
			Map<String, Object> someParameterValues) {
		if (COMPONENT_PATH_PARAMETER_NAME.equals(aParameterName)) {
			return requestProposals(getComponentClass());
		}

		return null;
	}

	@Override
	public List<CustomProposalDefinition> defineResultProposals(String aFixtureMethodName, String aResultName,
			Object aResultValue, Map<String, Object> someParameterValues) {
		return null;
	}

}

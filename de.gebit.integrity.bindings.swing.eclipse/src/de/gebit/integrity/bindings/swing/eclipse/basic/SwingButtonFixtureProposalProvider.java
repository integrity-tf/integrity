package de.gebit.integrity.bindings.swing.eclipse.basic;

import java.util.List;
import java.util.Map;

import javax.swing.JButton;

import de.gebit.integrity.bindings.swing.basic.SwingButtonFixture;
import de.gebit.integrity.bindings.swing.eclipse.AbstractSwingFixtureAssist;
import de.gebit.integrity.fixtures.CustomProposalProvider;
import de.gebit.integrity.fixtures.CustomProposalProvider.CustomProposalFixtureLink;

@CustomProposalFixtureLink(SwingButtonFixture.class)
public class SwingButtonFixtureProposalProvider extends AbstractSwingFixtureAssist implements CustomProposalProvider {

	@Override
	public List<CustomProposalDefinition> defineParameterProposals(String aFixtureMethodName, String aParameterName,
			Map<String, Object> someParameterValues) {
		if (COMPONENT_PATH_PARAMETER_NAME.equals(aParameterName)) {
			return requestProposals(JButton.class);
		}

		return null;
	}

	@Override
	public List<CustomProposalDefinition> defineResultProposals(String aFixtureMethodName, String aResultName,
			Object aResultValue, Map<String, Object> someParameterValues) {
		return null;
	}

}

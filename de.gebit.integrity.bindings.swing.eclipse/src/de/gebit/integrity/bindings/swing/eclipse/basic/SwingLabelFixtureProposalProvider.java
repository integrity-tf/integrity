/**
 * 
 */
package de.gebit.integrity.bindings.swing.eclipse.basic;

import java.awt.Component;

import javax.swing.JLabel;

import de.gebit.integrity.bindings.swing.basic.SwingLabelFixture;
import de.gebit.integrity.fixtures.CustomProposalProvider.CustomProposalFixtureLink;

/**
 * Proposal provider class for the {@link SwingLabelFixture}.
 * 
 * @author Slartibartfast
 * 
 */
@CustomProposalFixtureLink(SwingLabelFixture.class)
public class SwingLabelFixtureProposalProvider extends SwingComponentFixtureProposalProvider {

	@Override
	protected Class<? extends Component> getComponentClass() {
		return JLabel.class;
	}

}

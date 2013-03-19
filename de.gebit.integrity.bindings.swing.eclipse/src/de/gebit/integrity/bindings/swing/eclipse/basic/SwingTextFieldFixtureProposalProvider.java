/**
 * 
 */
package de.gebit.integrity.bindings.swing.eclipse.basic;

import java.awt.Component;

import javax.swing.JTextField;

import de.gebit.integrity.bindings.swing.basic.SwingTextFieldFixture;
import de.gebit.integrity.fixtures.CustomProposalProvider.CustomProposalFixtureLink;

/**
 * Proposal provider class for the {@link SwingTextFieldFixture}.
 * 
 * @author Slartibartfast
 * 
 */
@CustomProposalFixtureLink(SwingTextFieldFixture.class)
public class SwingTextFieldFixtureProposalProvider extends SwingComponentFixtureProposalProvider {

	@Override
	protected Class<? extends Component> getComponentClass() {
		return JTextField.class;
	}

}

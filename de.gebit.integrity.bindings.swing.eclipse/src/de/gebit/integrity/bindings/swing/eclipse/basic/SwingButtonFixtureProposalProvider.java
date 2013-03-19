/**
 * 
 */
package de.gebit.integrity.bindings.swing.eclipse.basic;

import java.awt.Component;

import javax.swing.JButton;

import de.gebit.integrity.bindings.swing.basic.SwingButtonFixture;
import de.gebit.integrity.fixtures.CustomProposalProvider.CustomProposalFixtureLink;

/**
 * 
 * 
 * @author Slartibartfast
 * 
 */
@CustomProposalFixtureLink(SwingButtonFixture.class)
public class SwingButtonFixtureProposalProvider extends SwingComponentFixtureProposalProvider {

	@Override
	protected Class<? extends Component> getComponentClass() {
		return JButton.class;
	}

}

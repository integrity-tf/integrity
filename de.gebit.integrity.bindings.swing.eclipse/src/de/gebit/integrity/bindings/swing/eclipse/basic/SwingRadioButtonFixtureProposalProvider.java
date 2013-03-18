/**
 * 
 */
package de.gebit.integrity.bindings.swing.eclipse.basic;

import java.awt.Component;

import javax.swing.JRadioButton;

import de.gebit.integrity.bindings.swing.basic.SwingRadioButtonFixture;
import de.gebit.integrity.fixtures.CustomProposalProvider.CustomProposalFixtureLink;

/**
 * 
 * 
 * @author Slartibartfast
 * 
 */
@CustomProposalFixtureLink(SwingRadioButtonFixture.class)
public class SwingRadioButtonFixtureProposalProvider extends SwingComponentFixtureProposalProvider {

	@Override
	protected Class<? extends Component> getComponentClass() {
		return JRadioButton.class;
	}

}

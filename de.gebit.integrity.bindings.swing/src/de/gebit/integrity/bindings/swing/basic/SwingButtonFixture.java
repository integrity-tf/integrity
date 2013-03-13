/**
 * 
 */
package de.gebit.integrity.bindings.swing.basic;

import javax.swing.JButton;

import de.gebit.integrity.bindings.swing.AbstractSwingFixture;
import de.gebit.integrity.bindings.swing.AmbiguousComponentPathException;
import de.gebit.integrity.bindings.swing.EventQueueTimeoutException;
import de.gebit.integrity.fixtures.CustomProposalFixture;
import de.gebit.integrity.fixtures.FixtureMethod;
import de.gebit.integrity.fixtures.FixtureParameter;

/**
 * 
 * 
 * @author Rene Schneider
 * 
 */
public class SwingButtonFixture extends AbstractSwingFixture implements CustomProposalFixture {

	@FixtureMethod(description = "Click the button $name$")
	public void clickButton(@FixtureParameter(name = COMPONENT_PATH_PARAMETER_NAME) String aComponentPath)
			throws AmbiguousComponentPathException, EventQueueTimeoutException {
		final JButton tempButton = (JButton) findComponentGuarded(aComponentPath, JButton.class, null);

		runOnEventQueueAndWait(new Runnable() {

			@Override
			public void run() {
				tempButton.doClick();
			}
		});
	}

}

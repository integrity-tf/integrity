/**
 * 
 */
package de.gebit.integrity.bindings.swing.basic;

import javax.swing.JRadioButton;

import de.gebit.integrity.bindings.swing.AbstractSwingFixture;
import de.gebit.integrity.bindings.swing.AmbiguousComponentPathException;
import de.gebit.integrity.bindings.swing.EventQueueTimeoutException;
import de.gebit.integrity.bindings.swing.InvalidComponentPathException;
import de.gebit.integrity.fixtures.CustomProposalFixture;
import de.gebit.integrity.fixtures.FixtureMethod;
import de.gebit.integrity.fixtures.FixtureParameter;

/**
 * 
 * 
 * @author Rene Schneider
 * 
 */
public class SwingRadioButtonFixture extends AbstractSwingFixture implements CustomProposalFixture {

	@FixtureMethod(descriptionCall = "Check the radio button '$name$'")
	public void checkRadioButton(@FixtureParameter(name = COMPONENT_PATH_PARAMETER_NAME) String aComponentPath)
			throws AmbiguousComponentPathException, EventQueueTimeoutException, InvalidComponentPathException {
		findComponentGuarded(aComponentPath, JRadioButton.class, null).doClick();
	}

	@FixtureMethod(descriptionCall = "Get the state of the radio button '$name$'", descriptionTest = "Check the state of the radio button '$name'")
	public boolean getRadioButtonState(@FixtureParameter(name = COMPONENT_PATH_PARAMETER_NAME) String aComponentPath)
			throws AmbiguousComponentPathException, EventQueueTimeoutException, InvalidComponentPathException {
		return findComponentGuarded(aComponentPath, JRadioButton.class, null).isSelected();
	}

}

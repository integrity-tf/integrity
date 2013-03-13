/**
 * 
 */
package de.gebit.integrity.bindings.swing.basic;

import javax.swing.JLabel;

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
public class SwingLabelFixture extends AbstractSwingFixture implements CustomProposalFixture {

	@FixtureMethod(descriptionCall = "Get the text displayed on label '$name$'", descriptionTest = "Check the text displayed on label '$name$'")
	public String labelText(@FixtureParameter(name = COMPONENT_PATH_PARAMETER_NAME) String aComponentPath)
			throws AmbiguousComponentPathException, EventQueueTimeoutException, InvalidComponentPathException {
		final JLabel tempLabel = (JLabel) findComponentGuarded(aComponentPath, JLabel.class, null);

		return tempLabel.getText();
	}

}

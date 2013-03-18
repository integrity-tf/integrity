/**
 * 
 */
package de.gebit.integrity.bindings.swing.basic;

import javax.swing.JTextField;

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
public class SwingTextFieldFixture extends AbstractSwingFixture implements
		CustomProposalFixture {

	@FixtureMethod(descriptionCall = "Get the text currently entered in text field '$name$'", descriptionTest = "Check the text currently entered in text field '$name$'")
	public String getTextFieldContent(
			@FixtureParameter(name = COMPONENT_PATH_PARAMETER_NAME) String aComponentPath)
			throws AmbiguousComponentPathException, EventQueueTimeoutException,
			InvalidComponentPathException {
		return findComponentGuarded(aComponentPath, JTextField.class, null)
				.getText();
	}

	@FixtureMethod(description = "Enter '$text$' in text field '$name$'")
	public void setTextFieldContent(
			@FixtureParameter(name = COMPONENT_PATH_PARAMETER_NAME) String aComponentPath,
			@FixtureParameter(name = "text") String aText)
			throws AmbiguousComponentPathException, EventQueueTimeoutException,
			InvalidComponentPathException {
		findComponentGuarded(aComponentPath, JTextField.class, null).setText(
				aText);
	}

}

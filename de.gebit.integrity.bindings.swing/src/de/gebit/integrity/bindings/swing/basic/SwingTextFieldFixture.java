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
 * This fixture provides access to {@link JTextField} instances.
 * 
 * @author Rene Schneider
 * 
 */
public class SwingTextFieldFixture extends AbstractSwingFixture implements CustomProposalFixture {

	/**
	 * Returns the current text in the given text field. Can be used either as a call fixture method to retrieve the
	 * text into a variable, or as a test fixture to check the text against a reference text.
	 * 
	 * @param aComponentPath
	 *            the path of the component
	 * @return the text in the text field
	 * @throws AmbiguousComponentPathException
	 * @throws EventQueueTimeoutException
	 * @throws InvalidComponentPathException
	 */
	@FixtureMethod(descriptionCall = "Get the text currently entered in text field '$name$'", descriptionTest = "Check the text currently entered in text field '$name$'")
	public String getTextFieldContent(@FixtureParameter(name = COMPONENT_PATH_PARAMETER_NAME) String aComponentPath)
			throws AmbiguousComponentPathException, EventQueueTimeoutException, InvalidComponentPathException {
		return findComponentGuarded(aComponentPath, JTextField.class, null).getText();
	}

	/**
	 * Enters the given text into the text field provided.
	 * 
	 * @param aComponentPath
	 *            the path of the component
	 * @param aText
	 *            the text in the text field
	 * @throws AmbiguousComponentPathException
	 * @throws EventQueueTimeoutException
	 * @throws InvalidComponentPathException
	 */
	@FixtureMethod(descriptionCall = "Enter '$text$' in text field '$name$'")
	public void setTextFieldContent(@FixtureParameter(name = COMPONENT_PATH_PARAMETER_NAME) String aComponentPath,
			@FixtureParameter(name = "text") String aText) throws AmbiguousComponentPathException,
			EventQueueTimeoutException, InvalidComponentPathException {
		findComponentGuarded(aComponentPath, JTextField.class, null).setText(aText);
	}

}

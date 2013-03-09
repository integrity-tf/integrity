/**
 * 
 */
package de.gebit.integrity.bindings.swing.basic;

import javax.swing.JButton;

import de.gebit.integrity.bindings.swing.AbstractSwingFixture;
import de.gebit.integrity.fixtures.FixtureMethod;
import de.gebit.integrity.fixtures.FixtureParameter;

/**
 * 
 * 
 * @author Rene Schneider
 * 
 */
public class SwingButtonFixture extends AbstractSwingFixture {

	@FixtureMethod(description = "Click the button $name$")
	public void clickButton(@FixtureParameter(name = "name") String aComponentPath) {
		JButton tempButton = (JButton) findComponentGuarded(aComponentPath, JButton.class);

		tempButton.doClick();

		// try {
		// Thread.sleep(1000);
		// } catch (InterruptedException exc) {
		// // TODO Auto-generated catch block
		// exc.printStackTrace();
		// }
	}

}

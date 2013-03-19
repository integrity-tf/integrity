/**
 * 
 */
package de.gebit.integrity.bindings.swing;

import java.awt.Component;
import java.awt.Window;
import java.util.List;

/**
 * Thrown if there are multiple components matching a given path. This exception contains very detailed, human-readable
 * information intended to help identifying the multiple matches.
 * 
 * @author Rene Schneider
 * 
 */
public class AmbiguousComponentPathException extends AbstractSwingComponentPathException {

	/**
	 * Serial Version.
	 */
	private static final long serialVersionUID = 4448538076639107014L;

	/**
	 * The components which were found.
	 */
	private List<Component> components;

	/**
	 * Creates a new instance.
	 * 
	 * @param aPath
	 *            the path which was matched
	 * @param someComponents
	 *            all components found
	 * @param aComponentHandler
	 *            the component handler
	 */
	public AmbiguousComponentPathException(String aPath, List<Component> someComponents,
			AbstractSwingComponentHandler aComponentHandler) {
		super(aPath, aComponentHandler, "Component path '" + aPath + "' is ambiguous (" + someComponents.size()
				+ " matches)");
		components = someComponents;
	}

	@Override
	protected void buildDetailString(StringBuilder aStringBuilder, AbstractSwingComponentHandler aComponentHandler) {
		int tempCount = 0;
		for (Component tempComponent : components) {
			tempCount++;
			aStringBuilder.append(tempCount + ": ");
			String tempPath = aComponentHandler.createComponentPath(tempComponent);
			String tempUniquifiedPath = aComponentHandler.createUniquifiedComponentPath(tempComponent);
			aStringBuilder.append(tempPath + " (" + tempUniquifiedPath + ")");
			aStringBuilder.append(NEWLINE);

			Component tempComponentInFocus = tempComponent.getParent();
			while (tempComponentInFocus != null) {
				aStringBuilder.append(PREFIX);
				aStringBuilder.append(aComponentHandler.getPrettyComponentDescription(tempComponentInFocus));
				aStringBuilder.append(NEWLINE);

				if (tempComponentInFocus instanceof Window) {
					break;
				}
				tempComponentInFocus = tempComponentInFocus.getParent();
			}
		}
	}

	public List<Component> getComponents() {
		return components;
	}

}

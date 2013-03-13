/**
 * 
 */
package de.gebit.integrity.bindings.swing;

import java.awt.Component;
import java.awt.Window;
import java.util.List;

/**
 * 
 * 
 * @author Rene Schneider
 * 
 */
public class AmbiguousComponentPathException extends AbstractSwingComponentPathException {

	/**
	 * Serial Version.
	 */
	private static final long serialVersionUID = 4448538076639107014L;

	private List<Component> components;

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

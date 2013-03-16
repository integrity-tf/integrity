/**
 * 
 */
package de.gebit.integrity.bindings.swing;

import java.awt.Component;
import java.awt.Container;
import java.awt.Window;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JRootPane;

/**
 * 
 * 
 * @author Rene Schneider
 * 
 */
public abstract class AbstractSwingComponentHandler {

	/**
	 * Used to fix broken JRootPane/JLayeredPane content default names. See
	 * http://bugs.sun.com/bugdatabase/view_bug.do?bug_id=4836615
	 */
	protected static final Set<String> IGNORED_JROOTPANE_CONTAINERS = new HashSet<String>();

	static {
		IGNORED_JROOTPANE_CONTAINERS.add("null.glassPane");
		IGNORED_JROOTPANE_CONTAINERS.add("null.contentPane");
		IGNORED_JROOTPANE_CONTAINERS.add("null.layeredPane");
	}

	protected static final String COMPONENT_PATH_PARAMETER_NAME = "name";

	protected static final Pattern UNIQUIFIED_PATH_PATTERN = Pattern.compile("(.+)#(\\d+)");

	public <C extends Component> List<C> findComponents(String aComponentPath, Class<C> aComponentClass,
			JFrame aFrameToIgnore) {
		List<C> tempComponents = new ArrayList<C>(1);

		for (Window tempWindow : Window.getWindows()) {
			if (tempWindow.isVisible()) {
				if (aFrameToIgnore == null || aFrameToIgnore != tempWindow) {
					tempComponents.addAll(findComponentsInContainer(tempWindow, aComponentPath, aComponentClass));
				}
			}
		}

		if (tempComponents.size() == 0) {
			Matcher tempMatcher = UNIQUIFIED_PATH_PATTERN.matcher(aComponentPath);
			if (tempMatcher.matches()) {
				String tempPath = tempMatcher.group(1);
				Integer tempNumber = Integer.parseInt(tempMatcher.group(2));

				tempComponents = findComponents(tempPath, aComponentClass, aFrameToIgnore);
				if (tempComponents.size() > tempNumber) {
					return Collections.singletonList(tempComponents.get(tempNumber));
				} else {
					return tempComponents;
				}
			}
		}

		return tempComponents;
	}

	protected <C extends Component> List<C> findComponentsInContainer(Container aContainer, String aComponentPath,
			Class<C> aComponentClass) {
		List<C> tempComponents = new ArrayList<C>(1);

		String[] tempPathParts = aComponentPath != null ? splitPath(aComponentPath) : null;
		recursiveFindComponentsInContainer(aContainer, tempPathParts, -1,
				resolveSwingComponentBaseClass(aComponentClass), tempComponents);

		return tempComponents;
	}

	@SuppressWarnings("unchecked")
	protected <C extends Component> void recursiveFindComponentsInContainer(Container aContainer,
			String[] somePathParts, int aPathPosition, Class<C> aComponentClass, List<C> aCollection) {
		if (somePathParts == null) {
			for (Component tempComponent : aContainer.getComponents()) {
				if (tempComponent instanceof Container) {
					recursiveFindComponentsInContainer((Container) tempComponent, somePathParts, 0, aComponentClass,
							aCollection);
				}
				if (aComponentClass == null || (aComponentClass.isAssignableFrom(tempComponent.getClass()))) {
					aCollection.add((C) tempComponent);
				}
			}
		} else {
			if (aPathPosition >= somePathParts.length) {
				return;
			} else if (aPathPosition == -1 && somePathParts.length > 0) {
				boolean tempIsLastPart = somePathParts.length == 1;
				String tempNameToFind = somePathParts[0];
				String tempContainerName = getComponentName(aContainer);
				if (tempContainerName != null && tempNameToFind.equals(tempContainerName)) {
					if (tempIsLastPart) {
						if (aComponentClass == null || aComponentClass.isAssignableFrom(aContainer.getClass())) {
							aCollection.add((C) aContainer);
						}
					} else {
						recursiveFindComponentsInContainer(aContainer, somePathParts, 1, aComponentClass, aCollection);
					}
				} else {
					recursiveFindComponentsInContainer(aContainer, somePathParts, 0, aComponentClass, aCollection);
				}
			} else {
				boolean tempIsLastPart = aPathPosition + 1 == somePathParts.length;
				String tempNameToFind = somePathParts[aPathPosition];
				for (Component tempComponent : aContainer.getComponents()) {
					String tempComponentName = getComponentName(tempComponent);

					if (tempComponentName == null) {
						// Unnamed containers are ignored; those are allowed gaps in the path
						if (tempComponent instanceof Container) {
							recursiveFindComponentsInContainer((Container) tempComponent, somePathParts, aPathPosition,
									aComponentClass, aCollection);
						}
						// ...but this could also be a generically named component! We'll just go on with that now.
						tempComponentName = getGenericComponentName(tempComponent);
						if (tempNameToFind.equals(tempComponentName)) {
							if (tempIsLastPart) {
								if (aComponentClass == null
										|| aComponentClass.isAssignableFrom(tempComponent.getClass())) {
									aCollection.add((C) tempComponent);
								}
							} else {
								if (tempComponent instanceof Container) {
									recursiveFindComponentsInContainer((Container) tempComponent, somePathParts,
											aPathPosition + 1, aComponentClass, aCollection);
								}
							}
						}
					} else {
						if (tempNameToFind.equals(tempComponentName)) {
							if (tempIsLastPart) {
								if (aComponentClass == null
										|| aComponentClass.isAssignableFrom(tempComponent.getClass())) {
									aCollection.add((C) tempComponent);
								}
							} else {
								if (tempComponent instanceof Container) {
									recursiveFindComponentsInContainer((Container) tempComponent, somePathParts,
											aPathPosition + 1, aComponentClass, aCollection);
								}
							}
						} else {
							if (tempComponent instanceof Container) {
								recursiveFindComponentsInContainer((Container) tempComponent, somePathParts, 0,
										aComponentClass, aCollection);
							}
						}
					}
				}
			}
		}
	}

	public <C extends Component> C findComponentGuarded(String aComponentPath, Class<C> aComponentClass,
			JFrame aFrameToIgnore) throws AmbiguousComponentPathException, InvalidComponentPathException {
		return filterComponentList(findComponents(aComponentPath, aComponentClass, aFrameToIgnore), aComponentPath);
	}

	protected <C extends Component> C findComponentInContainerGuarded(Container aContainer, String aComponentPath,
			Class<C> aComponentClass) throws AmbiguousComponentPathException, InvalidComponentPathException {
		return filterComponentList(findComponentsInContainer(aContainer, aComponentPath, aComponentClass),
				aComponentPath);
	}

	protected String getComponentName(Component aComponent) {
		String tempName = aComponent.getName();

		if (tempName == null) {
			return null;
		}

		if (((aComponent.getParent() instanceof JRootPane) || (aComponent.getParent() instanceof JLayeredPane))
				&& IGNORED_JROOTPANE_CONTAINERS.contains(tempName)) {
			return null;
		} else {
			return tempName.replace('.', '_');
		}
	}

	protected String getGenericComponentName(Component aComponent) {
		return resolveSwingComponentBaseClass(aComponent.getClass()).getSimpleName();
	}

	@SuppressWarnings("unchecked")
	protected <C extends Component> C filterComponentList(List<C> aComponentList, String aComponentPath)
			throws AmbiguousComponentPathException, InvalidComponentPathException {
		if (aComponentList.size() == 0) {
			throw new InvalidComponentPathException(aComponentPath, this);
		} else if (aComponentList.size() > 1) {
			throw new AmbiguousComponentPathException(aComponentPath, (List<Component>) aComponentList, this);
		} else {
			return aComponentList.get(0);
		}
	}

	public <C extends Component> boolean checkPathUniqueness(String aComponentPath, Class<C> aComponentClass) {
		List<C> tempMatches = findComponents(aComponentPath, aComponentClass, null);

		return (tempMatches.size() <= 1);
	}

	public String createComponentPath(Component aComponent) {
		List<String> aList = new ArrayList<String>();

		recursiveCreateComponentPath(aComponent, aList, 0);

		if (aList.size() == 0) {
			return null;
		} else {
			return serializeNameList(aList);
		}
	}

	public String createUniqueOnlyComponentPath(Component aComponent) {
		String tempPath = createComponentPath(aComponent);

		if (checkPathUniqueness(tempPath, aComponent.getClass())) {
			return tempPath;
		} else {
			return null;
		}
	}

	public String createUniquifiedComponentPath(Component aComponent) {
		String tempPath = createComponentPath(aComponent);

		@SuppressWarnings("unchecked")
		List<Component> tempMatches = (List<Component>) findComponents(tempPath, aComponent.getClass(), null);

		if (tempMatches.size() > 1) {
			for (int i = 0; i < tempMatches.size(); i++) {
				if (tempMatches.get(i) == aComponent) {
					return tempPath + "#" + i;
				}
			}
		}
		return tempPath;
	}

	public String createShortestComponentPath(Component aComponent) {
		List<String> aList = new ArrayList<String>();

		recursiveCreateComponentPath(aComponent, aList, 0);

		if (aList.size() == 0) {
			return null;
		} else {
			String tempShortestPath = null;
			while (aList.size() > 0) {
				String tempPath = serializeNameList(aList);
				if (checkPathUniqueness(tempPath, aComponent.getClass())) {
					tempShortestPath = tempPath;
					aList.remove(0);
				} else {
					break;
				}
			}
			return tempShortestPath;
		}
	}

	protected String serializeNameList(List<String> aList) {
		StringBuilder tempBuilder = new StringBuilder();

		for (String aName : aList) {
			if (tempBuilder.length() > 0) {
				tempBuilder.append('.');
			}
			tempBuilder.append(aName);
		}

		return tempBuilder.toString();
	}

	protected void recursiveCreateComponentPath(Component aComponent, List<String> aList, int aDepth) {
		String tempName = getComponentName(aComponent);

		if (tempName != null) {
			aList.add(0, tempName);
		} else {
			if (aDepth == 0) {
				// This is the first component, and it has no name, so we'll use its (Swing base) class instead
				aList.add(getGenericComponentName(aComponent));
			}
		}

		if (aComponent instanceof Window) {
			// This is a window, so we stop at this point.
			return;
		} else {
			Container tempParent = aComponent.getParent();
			if (tempParent != null) {
				recursiveCreateComponentPath(tempParent, aList, aDepth + 1);
			}
		}
	}

	protected String[] splitPath(String aPath) {
		return aPath.split("\\.");
	}

	@SuppressWarnings("unchecked")
	protected <C extends Component> Class<C> resolveSwingComponentBaseClass(Class<C> aClass) {
		Class<?> aClassInFocus = aClass;

		while (aClassInFocus != null
				&& !"javax.swing.".equals(aClassInFocus.getName().substring(0,
						aClassInFocus.getName().length() - aClassInFocus.getSimpleName().length()))) {
			aClassInFocus = aClassInFocus.getSuperclass();
		}

		if (aClassInFocus == null) {
			return aClass;
		} else {
			return (Class<C>) aClassInFocus;
		}
	}

	public String getPrettyComponentDescription(Component aComponent) {
		StringBuilder tempDescription = new StringBuilder(aComponent.getClass().getName() + " [");

		String tempName = getComponentName(aComponent);
		if (tempName != null) {
			tempDescription.append("name='" + tempName + "'");
		}

		if (aComponent.isEnabled()) {
			appendCommaIfNotFirst(tempDescription);
			tempDescription.append("enabled=" + aComponent.isEnabled());
		}

		if (aComponent instanceof JButton) {
			appendCommaIfNotFirst(tempDescription);
			tempDescription.append("text='" + ((JButton) aComponent).getText() + "'");
		}
		// add more special attributes for specific components here!

		if (tempDescription.charAt(tempDescription.length() - 1) != '[') {
			tempDescription.append("]");
			return tempDescription.toString();
		} else {
			return tempDescription.substring(0, tempDescription.length() - 2);
		}
	}

	private void appendCommaIfNotFirst(StringBuilder aStringBuilder) {
		if (aStringBuilder.charAt(aStringBuilder.length() - 1) != '[') {
			aStringBuilder.append(", ");
		}
	}
}

/**
 * 
 */
package de.gebit.integrity.bindings.swing;

import java.awt.Component;
import java.awt.Container;
import java.awt.Frame;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

	public List<Component> findComponents(String aComponentPath, Class<? extends Component> aComponentClass) {
		List<Component> tempComponents = new ArrayList<Component>(1);

		for (Frame tempFrame : Frame.getFrames()) {
			if (tempFrame.isVisible()) {
				if (tempFrame instanceof JFrame) {
					tempComponents.addAll(findComponentsInContainer(tempFrame, aComponentPath, aComponentClass));
				}
			}
		}

		return tempComponents;
	}

	public List<Component> findComponentsInContainer(Container aContainer, String aComponentPath,
			Class<? extends Component> aComponentClass) {
		List<Component> tempComponents = new ArrayList<Component>(1);

		String[] tempPathParts = splitPath(aComponentPath);
		recursiveFindComponentsInContainer(aContainer, tempPathParts, -1, aComponentClass, tempComponents);

		return tempComponents;
	}

	protected void recursiveFindComponentsInContainer(Container aContainer, String[] somePathParts, int aPathPosition,
			Class<? extends Component> aComponentClass, List<Component> aCollection) {
		if (aPathPosition >= somePathParts.length) {
			return;
		} else if (aPathPosition == -1 && somePathParts.length > 0) {
			boolean tempIsLastPart = somePathParts.length == 1;
			String tempNameToFind = somePathParts[0];
			String tempComponentName = aContainer.getName();
			if (tempComponentName != null && tempNameToFind.equals(tempComponentName)) {
				if (tempIsLastPart) {
					if (aComponentClass == null || aComponentClass.isAssignableFrom(aContainer.getClass())) {
						aCollection.add(aContainer);
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
					// Unnamed containers are ignored; those are allowed gaps in
					// the path
					if (tempComponent instanceof Container) {
						recursiveFindComponentsInContainer((Container) tempComponent, somePathParts, aPathPosition,
								aComponentClass, aCollection);
					}
				} else {
					if (tempNameToFind.equals(tempComponentName)) {
						if (tempIsLastPart) {
							if (aComponentClass == null || aComponentClass.isAssignableFrom(tempComponent.getClass())) {
								aCollection.add(tempComponent);
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

	public Component findComponentGuarded(String aComponentPath, Class<? extends Component> aComponentClass) {
		return filterComponentList(findComponents(aComponentPath, aComponentClass), aComponentPath);
	}

	public Component findComponentInContainerGuarded(Container aContainer, String aComponentPath,
			Class<? extends Component> aComponentClass) {
		return filterComponentList(findComponentsInContainer(aContainer, aComponentPath, aComponentClass),
				aComponentPath);
	}

	protected String getComponentName(Component aComponent) {
		String tempName = aComponent.getName();
		if (tempName != null
				&& ((aComponent.getParent() instanceof JRootPane) || (aComponent.getParent() instanceof JLayeredPane))
				&& IGNORED_JROOTPANE_CONTAINERS.contains(tempName)) {
			return null;
		} else {
			return tempName;
		}
	}

	protected Component filterComponentList(List<Component> aComponentList, String aComponentPath) {
		if (aComponentList.size() == 0) {
			throw new IllegalArgumentException("Component path '" + aComponentPath
					+ "' was not found in any visible frame.");
		} else if (aComponentList.size() > 1) {
			StringBuilder tempStringBuilder = new StringBuilder();

			for (Component tempComponent : aComponentList) {
				if (tempStringBuilder.length() > 0) {
					tempStringBuilder.append(", ");
				}
				tempStringBuilder.append(createComponentPath(tempComponent));
			}

			throw new IllegalArgumentException("Component path '" + aComponentPath + "' is ambiguous, "
					+ aComponentList.size() + " occurrences were found: " + tempStringBuilder.toString());
		} else {
			return aComponentList.get(0);
		}
	}

	public boolean checkPathUniqueness(String aComponentPath, Class<? extends Component> aComponentClass) {
		List<Component> tempMatches = findComponents(aComponentPath, aComponentClass);

		return (tempMatches.size() <= 1);
	}

	public String createComponentPath(Component aComponent) {
		List<String> aList = new ArrayList<String>();

		recursiveCreateComponentPath(aComponent, aList);

		if (aList.size() == 0) {
			return null;
		} else {
			return serializeNameList(aList);
		}
	}

	public String createShortestComponentPath(Component aComponent) {
		List<String> aList = new ArrayList<String>();

		recursiveCreateComponentPath(aComponent, aList);

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

	protected void recursiveCreateComponentPath(Component aComponent, List<String> aList) {
		String tempName = getComponentName(aComponent);

		if (tempName != null) {
			aList.add(0, tempName);
		} else {
			if (aList.size() == 0) {
				// This is the first component, and it has no name, so there's no path to it
				return;
			}
		}

		if (aComponent.getParent() != null) {
			recursiveCreateComponentPath(aComponent.getParent(), aList);
		}
	}

	// protected String getComponentName(Component aComponent) {
	// String tempName = aComponent.getName();
	// if (tempName == null) {
	// tempName = createGenericName(aComponent);
	// }
	//
	// return tempName;
	// }

	// protected String createGenericName(Component aComponent) {
	// String tempGenericName = genericNameCache.get(aComponent);
	//
	// if (tempGenericName == null) {
	// int tempNumber = 0;
	//
	// if (aComponent instanceof Frame) {
	// for (Frame tempFrame : Frame.getFrames()) {
	// tempNumber++;
	// if (tempFrame == aComponent) {
	// break;
	// }
	// }
	// } else {
	// for (Component tempComponent : aComponent.getParent().getComponents()) {
	// tempNumber++;
	// if (tempComponent == aComponent) {
	// break;
	// }
	// }
	// }
	//
	// tempGenericName = aComponent.getClass().getSimpleName() + "#" +
	// tempNumber;
	// genericNameCache.put(aComponent, tempGenericName);
	// }
	//
	// return tempGenericName;
	// }

	protected String[] splitPath(String aPath) {
		return aPath.split("\\.");
	}
}

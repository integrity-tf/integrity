/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
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
 * Abstract base class for working with Swing components, especially containing methods to identify components and work
 * with component paths.
 * 
 * @author Rene Schneider - initial API and implementation
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

	/**
	 * The parameter name for the component path parameter.
	 */
	protected static final String COMPONENT_PATH_PARAMETER_NAME = "name";

	/**
	 * The pattern to parse "uniquified" paths (such with numbers added at the end).
	 */
	protected static final Pattern UNIQUIFIED_PATH_PATTERN = Pattern.compile("(.+)#(\\d+)");

	/**
	 * Finds all components matching a given path and/or a given class in all open windows. A frame which is to be
	 * ignored can be provided.
	 * 
	 * @param aComponentPath
	 *            the path to find, or null if no path filtering shall be performed
	 * @param aComponentClass
	 *            the class to filter for, or null if no class filtering is to be done
	 * @param aFrameToIgnore
	 *            a frame whose contents need to be ignored
	 * @return all matching components
	 */
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

	/**
	 * Finds all components in a given container which match a given path and/or a provided class.
	 * 
	 * @param aContainer
	 *            the container in which to search
	 * @param aComponentPath
	 *            the path to match, or null if no path filtering shall be performed
	 * @param aComponentClass
	 *            the class to match, or null if no class filtering shall be performed
	 * @return
	 */
	protected <C extends Component> List<C> findComponentsInContainer(Container aContainer, String aComponentPath,
			Class<C> aComponentClass) {
		List<C> tempComponents = new ArrayList<C>(1);

		String[] tempPathParts = aComponentPath != null ? splitPath(aComponentPath) : null;
		recursiveFindComponentsInContainer(aContainer, tempPathParts, -1,
				resolveSwingComponentBaseClass(aComponentClass), tempComponents);

		return tempComponents;
	}

	@SuppressWarnings("unchecked")
	private <C extends Component> void recursiveFindComponentsInContainer(Container aContainer, String[] somePathParts,
			int aPathPosition, Class<C> aComponentClass, List<C> aCollection) {
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

	/**
	 * Finds a component matching the given path and/or class in all open windows. This method will return either one
	 * match or throw an exception.
	 * 
	 * @param aComponentPath
	 *            the component path to filter for, or null if no path filtering shall be done
	 * @param aComponentClass
	 *            the class to filter for, or null if no class filtering shall be done
	 * @param aFrameToIgnore
	 *            an optional frame which is to be ignored during the search
	 * @return a match
	 * @throws AmbiguousComponentPathException
	 *             if there are more than one matching components
	 * @throws InvalidComponentPathException
	 *             if there is not even a single matching component
	 */
	public <C extends Component> C findComponentGuarded(String aComponentPath, Class<C> aComponentClass,
			JFrame aFrameToIgnore) throws AmbiguousComponentPathException, InvalidComponentPathException {
		return filterComponentList(findComponents(aComponentPath, aComponentClass, aFrameToIgnore), aComponentPath);
	}

	/**
	 * Finds a component matching the given path and/or class in the given container. This method will return either one
	 * match or throw an exception.
	 * 
	 * @param aContainer
	 *            the container to search in
	 * @param aComponentPath
	 *            the component path to filter for, or null if no path filtering shall be done
	 * @param aComponentClass
	 *            the class to filter for, or null if no class filtering shall be done
	 * @return a match
	 * @throws AmbiguousComponentPathException
	 *             if there are more than one matching components
	 * @throws InvalidComponentPathException
	 *             if there is not even a single matching component
	 */
	protected <C extends Component> C findComponentInContainerGuarded(Container aContainer, String aComponentPath,
			Class<C> aComponentClass) throws AmbiguousComponentPathException, InvalidComponentPathException {
		return filterComponentList(findComponentsInContainer(aContainer, aComponentPath, aComponentClass),
				aComponentPath);
	}

	/**
	 * Determines the name of the given component.
	 * 
	 * @param aComponent
	 *            the component
	 * @return the name
	 */
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

	/**
	 * Creates a generic name for the given component.
	 * 
	 * @param aComponent
	 *            the component
	 * @return the generic name
	 */
	protected String getGenericComponentName(Component aComponent) {
		return resolveSwingComponentBaseClass(aComponent.getClass()).getSimpleName();
	}

	/**
	 * Returns either the single entry of the given list, or throws an {@link AmbiguousComponentPathException} or
	 * {@link InvalidComponentPathException}.
	 * 
	 * @param aComponentList
	 *            the list with the component(s)
	 * @param aComponentPath
	 *            the path which was selected
	 * @return the single component in the list
	 * @throws AmbiguousComponentPathException
	 *             if there are more than one matching components
	 * @throws InvalidComponentPathException
	 *             if there is not even a single matching component
	 */
	@SuppressWarnings("unchecked")
	private <C extends Component> C filterComponentList(List<C> aComponentList, String aComponentPath)
			throws AmbiguousComponentPathException, InvalidComponentPathException {
		if (aComponentList.size() == 0) {
			throw new InvalidComponentPathException(aComponentPath, this);
		} else if (aComponentList.size() > 1) {
			throw new AmbiguousComponentPathException(aComponentPath, (List<Component>) aComponentList, this);
		} else {
			return aComponentList.get(0);
		}
	}

	/**
	 * Checks whether the given path is unique and resolves to a single component.
	 * 
	 * @param aComponentPath
	 *            the path to check
	 * @param aComponentClass
	 *            a class to use for component filtering, or null if no class filtering is to be done
	 * @return true if there is at most a single match, false if there are multiple matches
	 */
	public <C extends Component> boolean checkPathUniqueness(String aComponentPath, Class<C> aComponentClass) {
		List<C> tempMatches = findComponents(aComponentPath, aComponentClass, null);

		return (tempMatches.size() <= 1);
	}

	/**
	 * Calculates the full path to the given component (doesn't need to be unique!).
	 * 
	 * @param aComponent
	 *            the component
	 * @return the full path to the component
	 */
	public String createComponentPath(Component aComponent) {
		List<String> tempList = new ArrayList<String>();

		recursiveCreateComponentPath(aComponent, tempList, 0);

		if (tempList.size() == 0) {
			return null;
		} else {
			return serializeNameList(tempList);
		}
	}

	/**
	 * Calculates the full path to the given component. Will not return a path if the created path would not be unique.
	 * 
	 * @param aComponent
	 *            the component
	 * @return the full unique path to the component, or null
	 */
	public String createUniqueOnlyComponentPath(Component aComponent) {
		String tempPath = createComponentPath(aComponent);

		if (checkPathUniqueness(tempPath, aComponent.getClass())) {
			return tempPath;
		} else {
			return null;
		}
	}

	/**
	 * Calculates a unique full path to the given component. The path may be enriched with numbers to make it unique.
	 * 
	 * @param aComponent
	 *            the component
	 * @return the full unique path to the component
	 */
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

	/**
	 * Calculates the shortest possible (but still unique) path to the given component.
	 * 
	 * @param aComponent
	 *            the component
	 * @return the shortest unique path or null if no unique path is found
	 */
	public String createShortestComponentPath(Component aComponent) {
		List<String> tempList = new ArrayList<String>();

		recursiveCreateComponentPath(aComponent, tempList, 0);

		if (tempList.size() == 0) {
			return null;
		} else {
			String tempShortestPath = null;
			while (tempList.size() > 0) {
				String tempPath = serializeNameList(tempList);
				if (checkPathUniqueness(tempPath, aComponent.getClass())) {
					tempShortestPath = tempPath;
					tempList.remove(0);
				} else {
					break;
				}
			}
			return tempShortestPath;
		}
	}

	private String serializeNameList(List<String> aList) {
		StringBuilder tempBuilder = new StringBuilder();

		for (String tempName : aList) {
			if (tempBuilder.length() > 0) {
				tempBuilder.append('.');
			}
			tempBuilder.append(tempName);
		}

		return tempBuilder.toString();
	}

	private void recursiveCreateComponentPath(Component aComponent, List<String> aList, int aDepth) {
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

	private String[] splitPath(String aPath) {
		return aPath.split("\\.");
	}

	@SuppressWarnings("unchecked")
	private <C extends Component> Class<C> resolveSwingComponentBaseClass(Class<C> aClass) {
		Class<?> tempClassInFocus = aClass;

		while (tempClassInFocus != null
				&& !"javax.swing.".equals(tempClassInFocus.getName().substring(0,
						tempClassInFocus.getName().length() - tempClassInFocus.getSimpleName().length()))) {
			tempClassInFocus = tempClassInFocus.getSuperclass();
		}

		if (tempClassInFocus == null) {
			return aClass;
		} else {
			return (Class<C>) tempClassInFocus;
		}
	}

	/**
	 * Generates a prettified component description, which contains just the interesting fields per component.
	 * 
	 * @param aComponent
	 *            the component to look at
	 * @return the description
	 */
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

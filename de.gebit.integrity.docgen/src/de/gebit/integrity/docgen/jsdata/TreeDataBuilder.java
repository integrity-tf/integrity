/*******************************************************************************
 * Copyright (c) 2017 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.docgen.jsdata;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.gebit.integrity.docgen.IntegrityPackage;

/**
 * Generates JSON data for the package tree.
 *
 * @author Rene Schneider - initial API and implementation
 *
 */
public class TreeDataBuilder {

	/**
	 * All the tree nodes.
	 */
	protected Collection<PackageTreeNode> packageTrees;

	/**
	 * Constructs a new instance.
	 * 
	 * @param somePackages
	 */
	public TreeDataBuilder(Collection<IntegrityPackage> somePackages) {
		packageTrees = buildPackageTrees(somePackages);
	}

	/**
	 * Builds the package tree JSON data file.
	 * 
	 * @param aTargetFile
	 * @throws IOException
	 */
	public void build(File aTargetFile) throws IOException {
		try (FileWriter tempWriter = new FileWriter(aTargetFile)) {
			createPackageTree(packageTrees, new PrintWriter(tempWriter));
		}
	}

	/**
	 * Creates a package tree. Entrance for recursive tree exploration.
	 * 
	 * @param someRootNodes
	 * @param aWriter
	 */
	protected void createPackageTree(Collection<PackageTreeNode> someRootNodes, PrintWriter aWriter) {
		aWriter.println("var treeData = [");

		Map<PackageTreeNode, Integer> tempPositionMap = new HashMap<>();
		for (PackageTreeNode tempRoot : someRootNodes) {
			addPackageTree(tempRoot, tempPositionMap, aWriter);
		}

		aWriter.println("];");
	}

	/**
	 * Recursively called to generate the output.
	 * 
	 * @param aNode
	 * @param aPositionMap
	 * @param aWriter
	 */
	protected void addPackageTree(PackageTreeNode aNode, Map<PackageTreeNode, Integer> aPositionMap,
			PrintWriter aWriter) {
		int tempId = aPositionMap.size();
		aWriter.println("\t{ label: " + jsonStringQuote(aNode.getName()) + ", parent: "
				+ (aNode.getParent() != null ? jsonStringQuote(Integer.toString(aPositionMap.get(aNode.getParent())))
						: "null")
				+ ", id: " + jsonStringQuote(Integer.toString(tempId)) + ", opened: false, selected: false, href: "
				+ (aNode.hasContent() ? jsonStringQuote(aNode.getQualifiedName()) : "null") + " },");
		aPositionMap.put(aNode, tempId);

		for (PackageTreeNode tempSubNode : aNode.getChildren()) {
			addPackageTree(tempSubNode, aPositionMap, aWriter);
		}
	}

	/**
	 * Takes a list of fully qualified package names and constructs a number of trees that fully represent the mentioned
	 * packages.
	 * 
	 * @param somePackages
	 * @return the package trees, with each node in the list being a tree root
	 */
	protected List<PackageTreeNode> buildPackageTrees(Collection<IntegrityPackage> somePackages) {
		PackageTreeNode tempRoot = new PackageTreeNode("", null);

		for (IntegrityPackage tempPackage : somePackages) {
			PackageTreeNode tempCurrentPackage = tempRoot;

			String[] tempParts = tempPackage.getName().split("\\.");
			for (String tempPart : tempParts) {
				PackageTreeNode tempNewPackage = tempCurrentPackage.getChild(tempPart);
				if (tempNewPackage == null) {
					tempNewPackage = new PackageTreeNode(tempPart, tempCurrentPackage);
				}
				tempCurrentPackage = tempNewPackage;
			}

			if (!tempPackage.isEmpty()) {
				tempCurrentPackage.setHasContent();
			}
		}

		List<PackageTreeNode> tempResult = tempRoot.getChildren();
		tempResult.forEach(PackageTreeNode::decoupleFromParent);
		return tempResult;
	}

	/**
	 * A node in the package tree.
	 *
	 *
	 * @author Rene Schneider - initial API and implementation
	 *
	 */
	protected static class PackageTreeNode implements Comparable<PackageTreeNode> {

		/**
		 * Package name.
		 */
		private String name;

		/**
		 * The children of this package.
		 */
		private Map<String, PackageTreeNode> children = new HashMap<String, PackageTreeNode>();

		/**
		 * The parent (or null if it's the root).
		 */
		private PackageTreeNode parent;

		/**
		 * Whether there are any documented entities (suites etc.) in this package.
		 */
		private boolean hasContent;

		/**
		 * Constructs a new instance.
		 * 
		 * @param aName
		 * @param aParent
		 */
		public PackageTreeNode(String aName, PackageTreeNode aParent) {
			name = aName;
			parent = aParent;
			if (aParent != null) {
				aParent.children.put(aName, this);
			}
		}

		public String getName() {
			return name;
		}

		/**
		 * Returns the children in a sorted-by-name fashion.
		 * 
		 * @return
		 */
		public List<PackageTreeNode> getChildren() {
			List<PackageTreeNode> tempList = new ArrayList<TreeDataBuilder.PackageTreeNode>(children.values());
			Collections.sort(tempList);

			return tempList;
		}

		/**
		 * Decouples this node from the parent.
		 */
		public void decoupleFromParent() {
			if (parent != null) {
				parent.children.remove(getName());
				parent = null;
			}
		}

		/**
		 * Returns a particular child, identified by its name.
		 * 
		 * @param aChildName
		 * @return
		 */
		public PackageTreeNode getChild(String aChildName) {
			return children.get(aChildName);
		}

		public PackageTreeNode getParent() {
			return parent;
		}

		/**
		 * Whether this package contains suites.
		 * 
		 * @return
		 */
		public boolean hasContent() {
			return hasContent;
		}

		/**
		 * Marks this package as containing suites.
		 * 
		 * @return
		 */
		public void setHasContent() {
			hasContent = true;
		}

		/**
		 * Returns the fully qualified name.
		 * 
		 * @return
		 */
		public String getQualifiedName() {
			if (parent != null) {
				return getParent().getQualifiedName() + "." + getName();
			} else {
				return getName();
			}
		}

		@Override
		public int compareTo(PackageTreeNode anOther) {
			return name.compareTo(anOther.name);
		}

	}

	/**
	 * Quotes JSON strings. Basically adapted from the Jettison JSON library.
	 * 
	 * @param aString
	 * @return
	 */
	protected static String jsonStringQuote(String aString) {
		if (aString == null || aString.length() == 0) {
			return "\"\"";
		}

		char tempChar = 0;
		int tempPos;
		int tempLen = aString.length();
		StringBuilder tempBuilder = new StringBuilder(tempLen + 4);
		String tempTempString;

		tempBuilder.append('"');
		for (tempPos = 0; tempPos < tempLen; tempPos += 1) {
			tempChar = aString.charAt(tempPos);
			switch (tempChar) {
			case '\\':
			case '"':
				tempBuilder.append('\\');
				tempBuilder.append(tempChar);
				break;
			case '/':
				tempBuilder.append('\\');
				tempBuilder.append(tempChar);
				break;
			case '\b':
				tempBuilder.append("\\b");
				break;
			case '\t':
				tempBuilder.append("\\t");
				break;
			case '\n':
				tempBuilder.append("\\n");
				break;
			case '\f':
				tempBuilder.append("\\f");
				break;
			case '\r':
				tempBuilder.append("\\r");
				break;
			default:
				if (tempChar < ' ') {
					tempTempString = "000" + Integer.toHexString(tempChar);
					tempBuilder.append("\\u" + tempTempString.substring(tempTempString.length() - 4));
				} else {
					tempBuilder.append(tempChar);
				}
			}
		}
		tempBuilder.append('"');
		return tempBuilder.toString();
	}

}

/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.tests.fixtures.basic.beans;

import java.util.TreeMap;

//SUPPRESS CHECKSTYLE LONG Javadoc
public class MapTestBeanWithTreeMap {

	private TreeMap<String, InnerBean> treeMapParameter = new TreeMap<>();

	public MapTestBeanWithTreeMap() {
		treeMapParameter.put("key1", new InnerBean("foo"));
		treeMapParameter.put("key2", new InnerBean("bar"));
	}

	public TreeMap<String, InnerBean> getTreeMapParameter() {
		return treeMapParameter;
	}

	public void setTreeMapParameter(TreeMap<String, InnerBean> treeMapParameter) {
		this.treeMapParameter = treeMapParameter;
	}

	public static class InnerBean {

		private String innerParameter;

		private InnerBean(String aParameter) {
			innerParameter = aParameter;
		}

		public String getInnerParameter() {
			return innerParameter;
		}

		public void setInnerParameter(String innerParameter) {
			this.innerParameter = innerParameter;
		}

	}

}

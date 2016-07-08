/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.tests.fixtures.basic.beans;

import java.util.HashMap;
import java.util.Map;

//SUPPRESS CHECKSTYLE LONG Javadoc
public class MapTestBeanWithMapInMap {

	private Map<String, Map<String, InnerBean>> mapInMapParameter = new HashMap<>();

	public MapTestBeanWithMapInMap() {
		Map<String, InnerBean> tempInnerMap = new HashMap<>();
		tempInnerMap.put("innerKey1", new InnerBean("foo"));
		tempInnerMap.put("innerKey2", new InnerBean("bar"));
		mapInMapParameter.put("outerKey1", tempInnerMap);

		tempInnerMap = new HashMap<>();
		tempInnerMap.put("innerKey1", new InnerBean("bar"));
		tempInnerMap.put("innerKey2", new InnerBean("foo"));
		mapInMapParameter.put("outerKey2", tempInnerMap);
	}

	public Map<String, Map<String, InnerBean>> getMapInMapParameter() {
		return mapInMapParameter;
	}

	public void setMapInMapParameter(Map<String, Map<String, InnerBean>> mapInMapParameter) {
		this.mapInMapParameter = mapInMapParameter;
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

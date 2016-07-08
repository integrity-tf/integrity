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
public class MapTestBean {

	private Map<String, InnerBean> mapParameter = new HashMap<>();

	public MapTestBean() {
		mapParameter.put("key1", new InnerBean("foo"));
		mapParameter.put("key2", new InnerBean("bar"));
	}

	public Map<String, InnerBean> getMapParameter() {
		return mapParameter;
	}

	public void setMapParameter(Map<String, InnerBean> mapParameter) {
		this.mapParameter = mapParameter;
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

/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.tests.fixtures.basic.beans;

import java.util.ArrayList;
import java.util.List;

//SUPPRESS CHECKSTYLE LONG Javadoc
public class NestedListTestBean {

	private List<SimpleTestBean> inner = new ArrayList<>();

	public NestedListTestBean() {
		inner.add(new SimpleTestBean("first", 2, null));
		inner.add(new SimpleTestBean("second", 3, null));
		inner.add(new SimpleTestBean("third", 4, null));
	}

	public List<SimpleTestBean> getInner() {
		return inner;
	}

}

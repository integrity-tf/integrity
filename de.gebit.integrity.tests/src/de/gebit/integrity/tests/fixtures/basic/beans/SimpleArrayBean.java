/*******************************************************************************
 * Copyright (c) 2017 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.tests.fixtures.basic.beans;

// SUPPRESS CHECKSTYLE LONG Javadoc
public class SimpleArrayBean {

	private SimpleTestBean[] elements = new SimpleTestBean[0];

	public SimpleArrayBean(SimpleTestBean[] someElements) {
		this.elements = someElements;
	}

	public void setElements(SimpleTestBean[] someElements) {
		this.elements = someElements;
	}

	public SimpleTestBean[] getElements() {
		return elements;
	}

}

/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.tests.fixtures.basic.beans;

import java.beans.Transient;

//SUPPRESS CHECKSTYLE LONG Javadoc
public class TransientTestBean {

	private String normalString = "foo";

	private String transientString = "bar";

	public String getNormalString() {
		return normalString;
	}

	public void setNormalString(String aNormalString) {
		this.normalString = aNormalString;
	}

	@Transient
	public String getTransientString() {
		return transientString;
	}

	public void setTransientString(String aTransientString) {
		this.transientString = aTransientString;
	}

}

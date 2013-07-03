/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.tests.fixtures.basic;

import de.gebit.integrity.fixtures.FixtureMethod;
import de.gebit.integrity.fixtures.FixtureParameter;

//SUPPRESS CHECKSTYLE LONG Javadoc
public class DateTypeCheckFixture {

	@FixtureMethod
	public boolean isDate(@FixtureParameter(name = "date") java.util.Date aDate) {
		return java.util.Date.class.getName().equals(aDate.getClass().getName());
	}

	@FixtureMethod
	public boolean isSQLDate(@FixtureParameter(name = "date") java.sql.Date aDate) {
		return java.sql.Date.class.getName().equals(aDate.getClass().getName());
	}

	@FixtureMethod
	public boolean isTimestamp(@FixtureParameter(name = "date") java.sql.Timestamp aDate) {
		return java.sql.Timestamp.class.getName().equals(aDate.getClass().getName());
	}

}

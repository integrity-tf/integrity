/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.tests.fixtures.basic.beans;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

//SUPPRESS CHECKSTYLE LONG Javadoc
public class DateContainingTestBean {

	private InnerBean singleParameter;

	private List<InnerBean> collectionParameter;

	public DateContainingTestBean() {
		super();
	}

	public DateContainingTestBean(InnerBean singleParameter, List<InnerBean> collectionParameter) {
		super();
		this.singleParameter = singleParameter;
		this.collectionParameter = collectionParameter;
	}

	public InnerBean getSingleParameter() {
		return singleParameter;
	}

	public List<InnerBean> getCollectionParameter() {
		return collectionParameter;
	}

	public static class InnerBean {

		private LocalDate localDate;

		private LocalTime localTime;

		private Date date;

		public InnerBean(LocalDate aDate, LocalTime aTime) {
			localDate = aDate;
			localTime = aTime;
		}

		public InnerBean(Date aDate) {
			date = aDate;
		}

		public LocalDate getLocalDate() {
			return localDate;
		}

		public LocalTime getLocalTime() {
			return localTime;
		}

		public Date getDate() {
			return date;
		}

	}

}

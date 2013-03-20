/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider (GEBIT Solutions GmbH) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.tests.fixtures.basic.beans;

import java.math.BigDecimal;

//SUPPRESS CHECKSTYLE LONG Javadoc
public class SimpleTestBean {

	private String firstParameter;

	private Integer secondParameter;

	private InnerBean thirdParameter;

	public String getFirstParameter() {
		return firstParameter;
	}

	public void setFirstParameter(String firstParameter) {
		this.firstParameter = firstParameter;
	}

	public Integer getSecondParameter() {
		return secondParameter;
	}

	public void setSecondParameter(Integer secondParameter) {
		this.secondParameter = secondParameter;
	}

	public InnerBean getThirdParameter() {
		return thirdParameter;
	}

	public void setThirdParameter(InnerBean thirdParameter) {
		this.thirdParameter = thirdParameter;
	}

	public static class InnerBean {

		private BigDecimal innerParameter;

		public BigDecimal getInnerParameter() {
			return innerParameter;
		}

		public void setInnerParameter(BigDecimal innerParameter) {
			this.innerParameter = innerParameter;
		}

	}

}

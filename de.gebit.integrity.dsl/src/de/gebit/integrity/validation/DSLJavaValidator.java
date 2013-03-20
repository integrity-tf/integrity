/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider (GEBIT Solutions GmbH) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.validation;

import java.text.ParseException;

import org.eclipse.xtext.validation.Check;

import de.gebit.integrity.dsl.DateAndTimeValue;
import de.gebit.integrity.dsl.DateValue;
import de.gebit.integrity.dsl.TimeValue;
import de.gebit.integrity.utils.DateUtil;

/**
 * These validators perform some more extensive validation on parts of the syntax tree.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class DSLJavaValidator extends AbstractDSLJavaValidator {

	/**
	 * Checks whether a given {@link DateValue} is actually correct (finds errors like days which don't exist in the
	 * given month).
	 * 
	 * @param aValue
	 */
	@Check
	public void checkIfDatesAreValid(DateValue aValue) {
		try {
			DateUtil.convertDateValue(aValue);
		} catch (ParseException exc) {
			error("The date entered is not valid!", null);
		}
	}

	/**
	 * Checks whether a given {@link TimeValue} is actually correct.
	 * 
	 * @param aValue
	 */
	@Check
	public void checkIfTimesAreValid(TimeValue aValue) {
		try {
			DateUtil.convertTimeValue(aValue);
		} catch (ParseException exc) {
			error("The time entered is not valid!", null);
		}
	}

	/**
	 * Checks whether a given {@link DateAndTimeValue} is actually correct.
	 * 
	 * @param aValue
	 */
	@Check
	public void checkIfDateAndTimesAreValid(DateAndTimeValue aValue) {
		try {
			DateUtil.convertDateAndTimeValue(aValue);
		} catch (ParseException exc) {
			error("The date and/or time entered is not valid!", null);
		}
	}

}

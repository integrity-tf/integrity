/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider (GEBIT Solutions GmbH) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.runner.operations;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import de.gebit.integrity.operations.custom.Operation;

/**
 * This operation formats a decimal number using a given format string. Meant to be used like:<br>
 * <br>
 * (123.5 formatted with "0.00")<br>
 * <br>
 * Optionally, you can also add a language identifier to the postfix param list in order to specify the locale to be
 * used for the conversion, like this:<br>
 * <br>
 * (123.5 formatted with "0.00", "de")<br>
 * or: (123.5 formatted with "0.00", "deDE")
 * 
 * 
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class DecimalFormatOperation implements Operation<BigDecimal, String[], String> {

	@Override
	public String execute(BigDecimal aNumber, String[] someFormatString) {
		String tempFormatString = someFormatString.length > 0 ? someFormatString[0] : null;
		String tempLocaleCode = someFormatString.length > 1 ? someFormatString[1] : null;

		if (aNumber == null || tempFormatString == null) {
			return null;
		}

		DecimalFormat tempFormat;
		if (tempLocaleCode == null) {
			tempFormat = new DecimalFormat(tempFormatString);
		} else {
			Locale tempLocale = null;
			if (tempLocaleCode.length() == 2) {
				tempLocale = new Locale(tempLocaleCode);
			} else if (tempLocaleCode.length() == 4) {
				tempLocale = new Locale(tempLocaleCode.substring(0, 2), tempLocaleCode.substring(2, 4));
			}

			if (tempLocale == null) {
				throw new IllegalArgumentException("Was unable to parse given locale identifier '" + tempLocaleCode
						+ "' into a valid locale!");
			}

			tempFormat = new DecimalFormat(tempFormatString, new DecimalFormatSymbols(tempLocale));
		}
		return tempFormat.format(aNumber);
	}
}

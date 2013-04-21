/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.string;

/**
 * Abstract base class for formatted string elements. These elements make up the formatted string.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public abstract class AbstractFormattedStringElement {

	/**
	 * Returns the elements' contents as a String without any formatting tokens.
	 * 
	 * @return the unformatted element contents
	 */
	public abstract String toUnformattedString();

	/**
	 * Returns the elements' contents as a String with all necessary formatting tokens.
	 * 
	 * @return the formatted element contents
	 */
	public abstract String toFormattedString();

	@Override
	public boolean equals(Object anOtherObject) {
		if (!(anOtherObject instanceof AbstractFormattedStringElement)) {
			return false;
		}

		String tempOtherFormattedText = ((AbstractFormattedStringElement) anOtherObject).toFormattedString();
		String tempFormattedText = toFormattedString();

		if (tempOtherFormattedText == null) {
			return tempFormattedText == null;
		} else {
			if (tempFormattedText == null) {
				return false;
			} else {
				return tempOtherFormattedText.equals(tempFormattedText);
			}
		}
	}

	@Override
	public int hashCode() {
		String tempFormattedText = toFormattedString();
		if (tempFormattedText != null) {
			return tempFormattedText.hashCode();
		} else {
			return 0;
		}
	}

}

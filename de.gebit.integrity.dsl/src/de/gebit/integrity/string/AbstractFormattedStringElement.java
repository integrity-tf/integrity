/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.string;

/**
 * 
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public abstract class AbstractFormattedStringElement {

	public abstract String getUnformattedText();

	public abstract String getFormattedText();

	@Override
	public boolean equals(Object anOtherObject) {
		if (!(anOtherObject instanceof AbstractFormattedStringElement)) {
			return false;
		}

		String tempOtherFormattedText = ((AbstractFormattedStringElement) anOtherObject).getFormattedText();
		String tempFormattedText = getFormattedText();

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
		String tempFormattedText = getFormattedText();
		if (tempFormattedText != null) {
			return tempFormattedText.hashCode();
		} else {
			return 0;
		}
	}

}

/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.ui.contentassist;

import org.eclipse.xtext.ui.editor.contentassist.FQNPrefixMatcher;

/**
 * This is a standrd {@link FQNPrefixMatcher} with a little change: if the value to match starts with a string delimiter
 * character, but the prefix doesn't, we'll add the delimiter to the prefix to make it match if the actual contents
 * inside match.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class IntegrityPrefixMatcher extends FQNPrefixMatcher {

	@Override
	public boolean isCandidateMatchingPrefix(String aName, String aPrefix) {
		if (aName.startsWith("\"") && !aPrefix.startsWith("\"")) {
			return super.isCandidateMatchingPrefix(aName, "\"" + aPrefix);
		} else {
			return super.isCandidateMatchingPrefix(aName, aPrefix);
		}
	}

}

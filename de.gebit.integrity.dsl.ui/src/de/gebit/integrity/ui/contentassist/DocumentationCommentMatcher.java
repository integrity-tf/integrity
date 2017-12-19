/*******************************************************************************
 * Copyright (c) 2017 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.ui.contentassist;

import org.eclipse.xtext.ui.editor.contentassist.PrefixMatcher;

/**
 * A special {@link PrefixMatcher} to be used to partially match documentation comments (IntegrityDoc).
 *
 * @author Rene Schneider - initial API and implementation
 *
 */
public class DocumentationCommentMatcher extends PrefixMatcher {

	@Override
	public boolean isCandidateMatchingPrefix(String aName, String aPrefix) {
		String[] tempParts = aName.split(" ");

		if (tempParts[0].startsWith("@")) {
			if (tempParts.length == 1 || tempParts[1].trim().isEmpty()) {
				return aName.startsWith(tempParts[0]);
			} else {
				return aName.startsWith(aPrefix);
			}
		}

		return false;
	}

}

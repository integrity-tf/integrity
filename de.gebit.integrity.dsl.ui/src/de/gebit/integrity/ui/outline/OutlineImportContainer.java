/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.ui.outline;

import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.impl.AbstractOutlineNode;

/**
 * Basic outline node which encapsulates the imports.
 * 
 * @author tilois - initial API and implementation
 */
// As there is no generic (non-abstract) outline node, we need to create specialized ones.
public class OutlineImportContainer extends AbstractOutlineNode {

	/**
	 * Creates an instance.
	 * 
	 * @param aParent
	 * @param anImage
	 * @param aText
	 * @param aLeafFlag
	 */
	protected OutlineImportContainer(IOutlineNode aParent, Image anImage, Object aText, boolean aLeafFlag) {
		super(aParent, anImage, aText, aLeafFlag);
	}

}

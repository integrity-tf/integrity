/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.ui.outline;

import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.impl.DocumentRootNode;

/**
 * Basic integrity root document. Extends the root node with a import container, which encapsulates all imports.
 * 
 * @author tilois - initial API and implementation
 */
public class IntegrityDocumentRoot extends DocumentRootNode {
	/** Import container node. */
	private IOutlineNode importContainer;

	/**
	 * Creates a new instance.
	 * 
	 * @param anImage
	 * @param aText
	 * @param aDocument
	 * @param aTreeProvider
	 */
	public IntegrityDocumentRoot(Image anImage, Object aText, IXtextDocument aDocument,
			DSLOutlineTreeProvider aTreeProvider) {
		super(anImage, aText, aDocument, aTreeProvider);
	}

	@Override
	public DSLOutlineTreeProvider getTreeProvider() {
		return (DSLOutlineTreeProvider) super.getTreeProvider();
	}

	/**
	 * Returns the import container, might delegate to the tree provider if not already computed.
	 * 
	 * @return Import container.
	 */
	public IOutlineNode getImportContainer() {
		if (importContainer == null) {
			importContainer = getTreeProvider().createOutlineContainer(this);
		}
		return importContainer;
	}

}

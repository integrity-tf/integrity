package de.gebit.integrity.ui.outline;

import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.impl.AbstractOutlineNode;

/**
 * Basic outline node which encapsulates the imports. 
 * @author tilois
 */
// As there is no generic (non-abstract) outline node, we need to create specialized ones.
public class OutlineImportContainer extends AbstractOutlineNode {

	protected OutlineImportContainer(IOutlineNode parent, Image image, Object text, boolean isLeaf) {
		super(parent, image, text, isLeaf);
	}

}

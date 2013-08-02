package de.gebit.integrity.ui.outline;

import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.impl.DocumentRootNode;

/**
 * Basic integrity root document.
 * Extends the root node with a import container, which encapsulates all imports.
 * 
 * @author tilois
 */
public class IntegrityDocumentRoot extends DocumentRootNode {
	/** Import container node. */
	private IOutlineNode importContainer;
	
	public IntegrityDocumentRoot(Image image, Object text, IXtextDocument document,
			DSLOutlineTreeProvider treeProvider) {
		super(image, text, document, treeProvider);
	}
	
	@Override
	public DSLOutlineTreeProvider getTreeProvider() {
		return (DSLOutlineTreeProvider) super.getTreeProvider();
	}
	
	/**
	 * Returns the import container, might delegate to the tree provider if not already computed.
	 * @return Import container.
	 */
	public IOutlineNode getImportContainer() {
		if (importContainer == null) {
			importContainer = getTreeProvider().createOutlineContainer(this);
		}
		return importContainer;
	}
	
}

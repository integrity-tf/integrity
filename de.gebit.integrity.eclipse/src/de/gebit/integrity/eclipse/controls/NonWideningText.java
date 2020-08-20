/*******************************************************************************
 * Copyright (c) 2020 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.eclipse.controls;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

/**
 * A {@link Text} subclass that changes its preferred size behavior such that it will not prefer to be large enough to
 * contain the longest single line of the text. This enables the embedding containers' layout provider to actually clamp
 * down on the final size of this widget, which is intended to be used with line wrapping.
 *
 * @author Rene Schneider - initial API and implementation
 *
 */
public class NonWideningText extends Text {

	/**
	 * Constructor.
	 * 
	 * @param aParent
	 *            the parent
	 * @param aStyle
	 *            the style
	 */
	public NonWideningText(Composite aParent, int aStyle) {
		super(aParent, aStyle);
	}

	@Override
	public Point computeSize(int aWidthHint, int aHeightHint, boolean aChangedFlag) {
		return new Point(0, 0);
	}

	@Override
	protected void checkSubclass() {
		// I take responsibility of this class potentially failing between SWT versions. Yeah, as if anyone could take
		// that responsibility off of me, really...
	}

}

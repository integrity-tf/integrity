/*******************************************************************************
 * Copyright (c) 2020 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.eclipse.controls;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

/**
 * A label containing an image that can toggle between two sizes: a smaller one limited to a given width, and the
 * original sized one.
 *
 * @author Rene Schneider - initial API and implementation
 *
 */
public class ScalableImageLabel extends Label {

	/**
	 * The full size image.
	 */
	private Image fullSizeImage;

	/**
	 * The smaller version of the image.
	 */
	private Image smallImage;

	/**
	 * The maximum width of the smaller one.
	 */
	private int maxWidth;

	/**
	 * Constructor.
	 * 
	 */
	public ScalableImageLabel(Composite aParent, int aStyle, Image anImage, int aMaxWidth) {
		super(aParent, aStyle);

		maxWidth = aMaxWidth;

		fullSizeImage = anImage;
		double tempScaleFactor = (double) maxWidth / (double) anImage.getImageData().width;

		if (tempScaleFactor >= 1.0) {
			setImage(fullSizeImage);
		} else {
			smallImage = new Image(anImage.getDevice(),
					anImage.getImageData().scaledTo(maxWidth, (int) (anImage.getImageData().height * tempScaleFactor)));
			setImage(smallImage);
		}

		setAlignment(SWT.CENTER);
	}

	public int getMinimumHeight() {
		return smallImage != null ? smallImage.getBounds().height : fullSizeImage.getBounds().height;
	}

	/**
	 * Toggles between the sizes.
	 */
	public void toggleImageSize() {
		if (smallImage == null) {
			return;
		}

		if (getImage() == fullSizeImage) {
			setImage(smallImage);
		} else {
			setImage(fullSizeImage);
		}
	}

	public int getWidth() {
		return getImage().getBounds().width;
	}

	public int getHeight() {
		return getImage().getBounds().height;
	}

	@Override
	protected void checkSubclass() {
		// I take responsibility of this class potentially failing between SWT versions. Yeah, as if anyone could take
		// that responsibility off of me, really...
	}

}

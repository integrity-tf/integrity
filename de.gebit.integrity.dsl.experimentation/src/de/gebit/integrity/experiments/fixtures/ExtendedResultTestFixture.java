/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.experiments.fixtures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import de.gebit.integrity.fixtures.ExtendedResultFixture;
import de.gebit.integrity.fixtures.FixtureMethod;
import de.gebit.integrity.fixtures.FixtureParameter;

/**
 * 
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class ExtendedResultTestFixture implements ExtendedResultFixture {

	int numberOfTexts;

	int numberOfImages;

	@FixtureMethod
	public void returnExtendedStuff(@FixtureParameter(name = "textCount") Integer aNumberOfTexts,
			@FixtureParameter(name = "imageCount") Integer aNumberOfImages) {
		numberOfTexts = aNumberOfTexts != null ? aNumberOfTexts : 0;
		numberOfImages = aNumberOfImages != null ? aNumberOfImages : 0;
	}

	@Override
	public List<ExtendedResult> provideExtendedResults() {
		List<ExtendedResult> tempList = new ArrayList<ExtendedResult>();

		for (int i = 0; i < numberOfTexts; i++) {
			tempList.add(new ExtendedResultText(
					"This is some stupid extended result text\nAnd it even has multiple lines!"));
		}

		for (int i = 0; i < numberOfImages; i++) {
			BufferedImage tempImage = new BufferedImage((int) (Math.random() * 600), (int) (Math.random() * 200),
					BufferedImage.TYPE_INT_ARGB);

			Graphics tempGraphics = tempImage.getGraphics();
			for (int x = 0; x < tempImage.getWidth(); x += 20) {
				for (int y = 0; y < tempImage.getHeight(); y += 20) {
					tempGraphics.setColor((x + y) % 2 == 0 ? Color.WHITE : Color.BLACK);
					tempGraphics.fillRect(x, y, x + 20 > tempImage.getWidth() ? tempImage.getWidth() - x : 20,
							y + 20 > tempImage.getHeight() ? tempImage.getHeight() - y : 20);
				}
			}
			tempGraphics.dispose();

			try {
				tempList.add(new ExtendedResultImage(tempImage));
			} catch (IOException exc) {
				exc.printStackTrace();
			}
		}

		return tempList;
	}

}

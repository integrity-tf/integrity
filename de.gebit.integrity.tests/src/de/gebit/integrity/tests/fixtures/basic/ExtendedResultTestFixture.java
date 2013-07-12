/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.tests.fixtures.basic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import de.gebit.integrity.fixtures.ExtendedResultFixture;
import de.gebit.integrity.fixtures.FixtureMethod;
import de.gebit.integrity.fixtures.FixtureParameter;

//SUPPRESS CHECKSTYLE LONG Javadoc
public class ExtendedResultTestFixture implements ExtendedResultFixture {

	int numberOfTexts;

	int numberOfImages;

	int numberOfHypertextSnippets;

	@FixtureMethod
	public boolean returnExtendedStuff(@FixtureParameter(name = "textCount", optional = true) Integer aNumberOfTexts,
			@FixtureParameter(name = "imageCount", optional = true) Integer aNumberOfImages,
			@FixtureParameter(name = "htmlCount", optional = true) Integer aNumberOfHypertextSnippets) {
		numberOfTexts = aNumberOfTexts != null ? aNumberOfTexts : 0;
		numberOfImages = aNumberOfImages != null ? aNumberOfImages : 0;
		numberOfHypertextSnippets = aNumberOfHypertextSnippets != null ? aNumberOfHypertextSnippets : 0;
		return true;
	}

	@Override
	public List<ExtendedResult> provideExtendedResults(FixtureInvocationResult aResult) {
		List<ExtendedResult> tempList = new ArrayList<ExtendedResult>();

		for (int i = 0; i < numberOfTexts; i++) {
			tempList.add(new ExtendedResultText(i % 2 == 0 ? null : "Text number " + i,
					"This is some stupid extended result text\nAnd it even has multiple lines!"));
		}

		for (int i = 0; i < numberOfImages; i++) {
			BufferedImage tempImage = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);

			Graphics tempGraphics = tempImage.getGraphics();
			for (int x = 0; x < tempImage.getWidth(); x += 20) {
				for (int y = 0; y < tempImage.getHeight(); y += 20) {
					tempGraphics.setColor(((x / 20 + y / 20) % 2) == 0 ? Color.WHITE : Color.BLACK);
					tempGraphics.fillRect(x, y, x + 20 > tempImage.getWidth() ? tempImage.getWidth() - x : 20,
							y + 20 > tempImage.getHeight() ? tempImage.getHeight() - y : 20);
				}
			}
			tempGraphics.dispose();

			try {
				tempList.add(new ExtendedResultImage(i % 2 == 0 ? null : "Image number " + i, tempImage));
			} catch (IOException exc) {
				exc.printStackTrace();
			}
		}

		for (int i = 0; i < numberOfHypertextSnippets; i++) {
			tempList.add(new ExtendedResultHTML(i % 2 == 0 ? null : "Hypertext snippet number " + i,
					"<p style=\"color: #FF0000;\">This is some stupid extended result text</p>"));
		}

		return tempList;
	}

}

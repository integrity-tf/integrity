/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.fixtures;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import javax.imageio.stream.MemoryCacheImageOutputStream;

/**
 * Fixtures can implement this optional interface to provide additional result information after the main fixture method
 * call(s) have been performed. The method {@link #provideExtendedResults()} is called once on each single fixture
 * instance, right after the fixture main method was invoked - even in case an exception was thrown in that method. For
 * tabletests, the method is invoked only once per tabletest statement, and NOT once per tabletest fixture method
 * invocation (which is invoked once per line).<br>
 * <br>
 * The method may return null or an empty list if no extended results shall be returned. Otherwise, an arbitrary number
 * of extended result instances - either {@link ExtendedResultText} for textual data or {@link ExtendedResultImage} for
 * images - may be returned, which will be integrated into the test results.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public interface ExtendedResultFixture {

	/**
	 * This method must determine the extended results to be integrated into the test results. The list may contain:
	 * <ul>
	 * <li>
	 * {@link ExtendedResultText} for textual results</li>
	 * <li>
	 * {@link ExtendedResultImage} for images</li>
	 * </ul>
	 * 
	 * @return the list of extended results, or null if no results are to be provided
	 */
	List<ExtendedResult> provideExtendedResults();

	/**
	 * Abstract base class for extended result types. You should NOT implement subclasses of this class, but instead use
	 * the provided subclasses:
	 * <ul>
	 * <li>
	 * {@link ExtendedResultText} for textual results</li>
	 * <li>
	 * {@link ExtendedResultImage} for images</li>
	 * </ul>
	 * 
	 * 
	 * @author Rene Schneider - initial API and implementation
	 * 
	 */
	public static abstract class ExtendedResult {

	}

	/**
	 * Encapsulates a textual extended result.
	 * 
	 * 
	 * @author Rene Schneider - initial API and implementation
	 * 
	 */
	public static final class ExtendedResultText extends ExtendedResult {

		/**
		 * The text.
		 */
		private String text;

		/**
		 * Creates an instance.
		 * 
		 * @param aText
		 *            the text of the result
		 */
		public ExtendedResultText(String aText) {
			text = aText;
		}

		public String getText() {
			return text;
		}

	}

	/**
	 * Encapsulates an image which is to be provided as extended result. The creator can optionally specify the
	 * preferred compression type to use when the image is encoded to integrate it into the results.
	 * 
	 * 
	 * @author Rene Schneider - initial API and implementation
	 * 
	 */
	public static final class ExtendedResultImage extends ExtendedResult {

		/**
		 * The compressed and encoded image.
		 */
		private byte[] encodedImage;

		/**
		 * The compression type to use when encoding the image.
		 */
		private ImageCompressionType type;

		/**
		 * The width of the image, in pixels.
		 */
		private int width;

		/**
		 * The height of the image, in pixels.
		 */
		private int height;

		/**
		 * Creates a new instance, using the default compression type (PNG).
		 * 
		 * @param anImage
		 *            the image to encapsulate
		 * @throws IOException
		 *             in case of compression/encoding errors
		 */
		public ExtendedResultImage(BufferedImage anImage) throws IOException {
			this(anImage, ImageCompressionType.PNG);
		}

		/**
		 * Creates a new instance, using the provided image and compression type.
		 * 
		 * @param anImage
		 *            the image to encapsulate
		 * @param aCompressionType
		 *            the preferred compression type to use when encoding the image for the results
		 * @throws IOException
		 *             in case of compression/encoding errors
		 */
		public ExtendedResultImage(BufferedImage anImage, ImageCompressionType aCompressionType) throws IOException {
			type = aCompressionType != null ? aCompressionType : ImageCompressionType.PNG;
			width = anImage.getWidth();
			height = anImage.getHeight();
			compress(anImage);
		}

		public byte[] getEncodedImage() {
			return encodedImage;
		}

		public ImageCompressionType getType() {
			return type;
		}

		public int getWidth() {
			return width;
		}

		public int getHeight() {
			return height;
		}

		/**
		 * This enum contains the supported image compression types, used when encoding the image for test results.
		 * 
		 * 
		 * @author Rene Schneider - initial API and implementation
		 * 
		 */
		public static enum ImageCompressionType {

			/**
			 * Stores the image as a PNG.
			 */
			PNG("image/png"),

			/**
			 * Stores the image as a JPEG with high quality setting (0.9).
			 */
			JPEG_HIGH("image/jpeg"),

			/**
			 * Stores the image as a JPEG with low quality setting (0.4).
			 */
			JPEG_LOW("image/jpeg");

			/**
			 * The mime type string.
			 */
			private String mimeType;

			private ImageCompressionType(String aMimeType) {
				mimeType = aMimeType;
			}

			public String getMimeType() {
				return mimeType;
			}

		}

		private void compress(BufferedImage anImage) throws IOException {
			ImageWriter tempWriter = ImageIO.getImageWritersByMIMEType(type.getMimeType()).next();
			ImageOutputStream tempImageOut = null;
			try {
				ImageWriteParam tempParam = tempWriter.getDefaultWriteParam();

				switch (type) {
				case JPEG_HIGH:
					tempParam.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
					tempParam.setCompressionQuality(0.9f);
					break;
				case JPEG_LOW:
					tempParam.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
					tempParam.setCompressionQuality(0.4f);
					break;
				default:
					// nothing to do
				}

				ByteArrayOutputStream tempBuffer = new ByteArrayOutputStream();
				tempImageOut = new MemoryCacheImageOutputStream(tempBuffer);
				tempWriter.setOutput(tempImageOut);
				tempWriter.write(null, new IIOImage(anImage, null, null), tempParam);
				tempImageOut.flush();
				encodedImage = tempBuffer.toByteArray();
			} finally {
				tempWriter.dispose();
				if (tempImageOut != null) {
					tempImageOut.close();
				}
			}
		}

	}

}

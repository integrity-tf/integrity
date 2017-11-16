/*******************************************************************************
 * Copyright (c) 2017 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * A {@link StringJoiner} variant that specifically optimizes creating comma-separated lists of counts of things (in
 * english language).
 *
 * @author Rene Schneider - initial API and implementation
 *
 */
public class CountsOfThingsStringJoiner {

	/**
	 * Is internally used to perform the string joining work.
	 */
	protected List<StringSegment> segments = new ArrayList<>();

	/**
	 * Whether to add counts of zero items.
	 */
	protected boolean addZeroCounts = true;

	/**
	 * The standard divider segment.
	 */
	protected static final String DIVIDER = ", ";

	/**
	 * The divider segment to use as the last divider.
	 */
	protected static final String DIVIDER_LAST = " and ";

	/**
	 * Constructor.
	 */
	public CountsOfThingsStringJoiner() {
		// default values
	}

	/**
	 * Constructor.
	 * 
	 * @param anAddZeroCountsFlag
	 *            whether to add anything at all for counts of 0 objects
	 */
	public CountsOfThingsStringJoiner(boolean anAddZeroCountsFlag) {
		addZeroCounts = anAddZeroCountsFlag;
	}

	/**
	 * Adds the specified count of things.
	 * 
	 * @param aCount
	 *            the count to add
	 * @param aSingularObjectName
	 *            the object to be counted in its singular form
	 * @param aPluralObjectName
	 *            the object to be counted in plural form
	 */
	public void add(long aCount, String aSingularObjectName, String aPluralObjectName) {
		add(aCount, aSingularObjectName, aPluralObjectName, null);
	}

	/**
	 * Adds the specified count of things.
	 * 
	 * @param aCount
	 *            the count to add
	 * @param aSingularObjectName
	 *            the object to be counted in its singular form
	 * @param aPluralObjectName
	 *            the object to be counted in plural form
	 * @param aDataObject
	 *            Optional data object to associate with this segment
	 */
	public void add(long aCount, String aSingularObjectName, String aPluralObjectName, Object aDataObject) {
		if (aCount == 0 && !addZeroCounts) {
			return;
		}

		if (aCount != 1) {
			segments.add(new StringSegment(aCount + " " + aPluralObjectName, (segments.size() > 0 ? true : null),
					aDataObject));
		} else {
			segments.add(new StringSegment(aCount + " " + aSingularObjectName, (segments.size() > 0 ? true : null),
					aDataObject));
		}
	}

	@Override
	public String toString() {
		StringBuilder tempBuilder = new StringBuilder();

		for (int i = 0; i < segments.size(); i++) {
			StringSegment tempSegment = segments.get(i);

			// Replace last divider with DIVIDER_LAST
			if (i + 1 >= segments.size()) {
				tempBuilder.append(DIVIDER_LAST);
			} else if (tempSegment.getDivider() != null) {
				tempBuilder.append(tempSegment.getDivider());
			}

			tempBuilder.append(tempSegment.getContent());
		}

		return tempBuilder.toString();
	}

	/**
	 * Returns a list with the individual string segments that make up the final joined string (as returned by
	 * {@link #toString()}).
	 * 
	 * @return
	 */
	public List<StringSegment> toStringSegments() {
		ArrayList<StringSegment> tempResult = new ArrayList<>(segments.size());

		for (int i = 0; i < segments.size(); i++) {
			StringSegment tempNewSegment = new StringSegment(segments.get(i), (i + 1 == segments.size()));
			if (i > 0) {
				tempResult.get(i - 1).setNextSegment(tempNewSegment);
				tempNewSegment.setPreviousSegment(tempResult.get(i - 1));
			}
			tempResult.add(tempNewSegment);
		}

		return tempResult;
	}

	/**
	 * Represents a string segment of this joiner.
	 *
	 *
	 * @author Rene Schneider - initial API and implementation
	 *
	 */
	public static class StringSegment {

		/**
		 * The actual content. Mandatory.
		 */
		private String content;

		/**
		 * The divider BEFORE the content. Is optional, since at the beginning of the string there is no divider. Does
		 * not store the divider as text, but only which to use.
		 */
		private Boolean divider;

		/**
		 * Optional data associated with this segment.
		 */
		private Object data;

		/**
		 * Links to the following {@link StringSegment}. Null if no following segment.
		 */
		private StringSegment nextSegment;

		/**
		 * Links to the previous {@link StringSegment}. Null if no previous segment.
		 */
		private StringSegment previousSegment;

		/**
		 * Constructs an instance.
		 * 
		 * @param aContent
		 * @param aDivider
		 * @param aDataObject
		 */
		public StringSegment(String aContent, Boolean aDividerFlag, Object aDataObject) {
			content = aContent;
			divider = aDividerFlag;
			data = aDataObject;
		}

		/**
		 * Private constructor, used to clone segments.
		 * 
		 * @param aSegmentToClone
		 * @param aReplaceDividerFlag
		 * @param aPreviousSegment
		 * @param aNextSegment
		 */
		protected StringSegment(StringSegment aSegmentToClone, boolean aReplaceDividerFlag) {
			content = aSegmentToClone.content;
			divider = aSegmentToClone.divider;
			data = aSegmentToClone.data;
			if (aReplaceDividerFlag && divider != null) {
				divider = false;
			}
		}

		/**
		 * Sets the previous segment.
		 * 
		 * @param aSegment
		 */
		protected void setPreviousSegment(StringSegment aSegment) {
			previousSegment = aSegment;
		}

		/**
		 * Sets the next segment.
		 * 
		 * @param aSegment
		 */
		protected void setNextSegment(StringSegment aSegment) {
			nextSegment = aSegment;
		}

		public String getContent() {
			return content;
		}

		/**
		 * Gets the divider as string to use (if any).
		 * 
		 * @return
		 */
		public String getDivider() {
			if (divider != null) {
				if (divider) {
					return DIVIDER;
				} else {
					return DIVIDER_LAST;
				}
			}

			return null;
		}

		public Object getData() {
			return data;
		}

		public StringSegment getPreviousSegment() {
			return previousSegment;
		}

		public StringSegment getNextSegment() {
			return nextSegment;
		}

		/**
		 * Whether this segment has a divider at all.
		 * 
		 * @return
		 */
		public boolean hasDivider() {
			return divider != null;
		}

		/**
		 * Whether this segment begins with the standard divider.
		 * 
		 * @return
		 */
		public boolean hasStandardDivider() {
			return (divider != null && Boolean.TRUE.equals(divider));
		}

		/**
		 * Whether this segment begins with the last-segment divider.
		 * 
		 * @return
		 */
		public boolean hasLastDivider() {
			return (divider != null && Boolean.FALSE.equals(divider));
		}

		@Override
		public String toString() {
			return (divider != null ? getDivider() : "") + content;
		}

	}

}

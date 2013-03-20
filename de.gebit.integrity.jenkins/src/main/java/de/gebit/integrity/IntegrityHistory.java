/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider (GEBIT Solutions GmbH) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity;

import hudson.model.AbstractBuild;
import hudson.tasks.test.TestResult;
import hudson.util.ChartUtil;
import hudson.util.ColorPalette;
import hudson.util.DataSetBuilder;
import hudson.util.Graph;
import hudson.util.ShiftedCategoryAxis;
import hudson.util.StackedAreaRenderer2;

import java.awt.Color;
import java.awt.Paint;
import java.util.ArrayList;
import java.util.List;

import jenkins.model.Jenkins;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.StackedAreaRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.ui.RectangleInsets;
import org.kohsuke.stapler.Stapler;

/**
 * The history graph view for Integrity result history. Heavily based on the standard test history view in Jenkins,
 * which isn't that well-suited for customization, thus a some of the code was duplicated.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class IntegrityHistory {

	/**
	 * The test result used as base for the graph.
	 */
	private final IntegrityCompoundTestResult testResult;

	/**
	 * Creates a new instance.
	 * 
	 * @param aTestResult
	 *            the test result
	 */
	public IntegrityHistory(IntegrityCompoundTestResult aTestResult) {
		this.testResult = aTestResult;
	}

	public IntegrityCompoundTestResult getTestResult() {
		return testResult;
	}

	/**
	 * Checks whether a history is available at all.
	 * 
	 * @return true if available, false otherwise
	 */
	public boolean historyAvailable() {
		return testResult.getOwner().getParent().getBuilds().size() > 1;
	}

	/**
	 * Fetches test results in a certain build number interval.
	 * 
	 * @param aStart
	 *            the start build
	 * @param anEnd
	 *            the end build
	 * @return the test results
	 */
	public List<TestResult> getList(int aStart, int anEnd) {
		List<TestResult> tempList = new ArrayList<TestResult>();
		int tempEnd = Math.min(anEnd, testResult.getOwner().getParent().getBuilds().size());
		for (AbstractBuild<?, ?> tempBuild : testResult.getOwner().getParent().getBuilds().subList(aStart, tempEnd)) {
			if (tempBuild.isBuilding()) {
				continue;
			}
			TestResult tempResult = testResult.getResultInBuild(tempBuild);
			if (tempResult != null) {
				tempList.add(tempResult);
			}
		}
		return tempList;
	}

	public List<TestResult> getList() {
		return getList(0, testResult.getOwner().getParent().getBuilds().size());
	}

	/**
	 * Returns a graph of test results (# successful, failed etc.) over time.
	 * 
	 * @return
	 */
	public Graph getCountGraph() {
		return new GraphImpl("") {
			protected DataSetBuilder<String, ChartLabel> createDataSet() {
				DataSetBuilder<String, ChartLabel> tempData = new DataSetBuilder<String, ChartLabel>();

				List<TestResult> tempResultList;
				try {
					tempResultList = getList(Integer.parseInt(Stapler.getCurrentRequest().getParameter("start")),
							Integer.parseInt(Stapler.getCurrentRequest().getParameter("end")));
				} catch (NumberFormatException exc) {
					tempResultList = getList();
				}

				for (TestResult tempResult : tempResultList) {
					tempData.add(tempResult.getPassCount(), "2Passed", new ChartLabel(tempResult));
					tempData.add(tempResult.getFailCount(), "1Failed", new ChartLabel(tempResult));
					tempData.add(tempResult.getSkipCount(), "0Skipped", new ChartLabel(tempResult));
				}

				return tempData;
			}
		};
	}

	private abstract class GraphImpl extends Graph {

		/**
		 * The label displayed at the y axis.
		 */
		private final String yLabel;

		protected GraphImpl(String anYLabel) {
			super(-1, 500, 200);
			this.yLabel = anYLabel;
		}

		protected abstract DataSetBuilder<String, ChartLabel> createDataSet();

		protected JFreeChart createGraph() {
			final CategoryDataset dataset = createDataSet().build();

			final JFreeChart chart = ChartFactory.createStackedAreaChart(null, null, yLabel, dataset,
					PlotOrientation.VERTICAL, false, true, false);

			chart.setBackgroundPaint(Color.white);

			final CategoryPlot plot = chart.getCategoryPlot();

			// plot.setAxisOffset(new Spacer(Spacer.ABSOLUTE, 5.0, 5.0, 5.0, 5.0));
			plot.setBackgroundPaint(Color.WHITE);
			plot.setOutlinePaint(null);
			plot.setForegroundAlpha(0.8f);
			plot.setRangeGridlinesVisible(true);
			plot.setRangeGridlinePaint(Color.BLACK);

			CategoryAxis tempDomainAxis = new ShiftedCategoryAxis(null);
			plot.setDomainAxis(tempDomainAxis);
			tempDomainAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_90);
			tempDomainAxis.setLowerMargin(0.0);
			tempDomainAxis.setUpperMargin(0.0);
			tempDomainAxis.setCategoryMargin(0.0);

			final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
			ChartUtil.adjustChebyshev(dataset, rangeAxis);
			rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
			rangeAxis.setAutoRange(true);

			StackedAreaRenderer tempAreaRenderer = new StackedAreaRenderer2() {

				/**
				 * The serialization version.
				 */
				private static final long serialVersionUID = 2284582320567360791L;

				@Override
				public Paint getItemPaint(int aRow, int aColumn) {
					ChartLabel tempKey = (ChartLabel) dataset.getColumnKey(aColumn);
					if (tempKey.getColor() != null) {
						return tempKey.getColor();
					}
					return super.getItemPaint(aRow, aColumn);
				}

				@Override
				public String generateURL(CategoryDataset aDataset, int aRow, int aColumn) {
					ChartLabel tempLabel = (ChartLabel) aDataset.getColumnKey(aColumn);
					return tempLabel.getUrl();
				}

				@Override
				public String generateToolTip(CategoryDataset aDataset, int aRow, int aColumn) {
					ChartLabel tempLabel = (ChartLabel) aDataset.getColumnKey(aColumn);
					TestResult tempResult = tempLabel.result;
					return tempResult.getOwner().getDisplayName() + ": " + tempResult.getPassCount()
							+ " successful tests, " + tempResult.getFailCount() + " failures, "
							+ tempResult.getSkipCount() + " exceptions during tests";
				}
			};
			plot.setRenderer(tempAreaRenderer);
			tempAreaRenderer.setSeriesPaint(0, ColorPalette.YELLOW); // Failures.
			tempAreaRenderer.setSeriesPaint(1, ColorPalette.RED); // Skips.
			tempAreaRenderer.setSeriesPaint(2, ColorPalette.BLUE); // Total.

			// crop extra space around the graph
			plot.setInsets(new RectangleInsets(0, 0, 0, 5.0));

			return chart;
		}
	}

	private class ChartLabel implements Comparable<ChartLabel> {

		/**
		 * The test result.
		 */
		private TestResult result;

		/**
		 * The URL where this label is to be linked.
		 */
		private String url;

		public ChartLabel(TestResult aResult) {
			this.result = aResult;
			this.url = null;
		}

		public String getUrl() {
			if (url == null) {
				generateUrl();
			}
			return url;
		}

		private void generateUrl() {
			AbstractBuild<?, ?> tempBuild = result.getOwner();
			String tempBuildLink = tempBuild.getUrl();
			String tempActionUrl = IntegrityTestResultAction.ACTION_URL;
			this.url = Jenkins.getInstance().getRootUrl() + tempBuildLink + tempActionUrl + result.getUrl();
		}

		public int compareTo(ChartLabel anOtherLabel) {
			return this.result.getOwner().number - anOtherLabel.result.getOwner().number;
		}

		@Override
		public boolean equals(Object anOtherObject) {
			if (!(anOtherObject instanceof ChartLabel)) {
				return false;
			}
			ChartLabel tempOtherObject = (ChartLabel) anOtherObject;
			return this.result == tempOtherObject.result;
		}

		public Color getColor() {
			return null;
		}

		@Override
		public int hashCode() {
			return result.hashCode();
		}

		@Override
		public String toString() {
			String tempLabel = result.getOwner().getDisplayName();
			String tempBuiltOn = result.getOwner().getBuiltOnStr();
			if (tempBuiltOn != null) {
				tempLabel += ' ' + tempBuiltOn;
			}
			return tempLabel;
		}

	}
}

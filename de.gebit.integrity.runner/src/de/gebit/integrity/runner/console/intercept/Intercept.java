/**
 * 
 */
package de.gebit.integrity.runner.console.intercept;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a single interception job of the {@link ConsoleInterceptionAggregator}.
 * 
 * 
 * @author Rene Schneider
 * 
 */
public class Intercept {

	/**
	 * The intercepted lines.
	 */
	private List<InterceptedLine> lines = new ArrayList<InterceptedLine>();

	/**
	 * The time at which this job was started.
	 */
	private long startTimestamp = System.currentTimeMillis();

	/**
	 * The time at which this job ended.
	 */
	private long endTimestamp;

	/**
	 * Sets the end timestamp to the current time.
	 */
	public void setEndTimestamp() {
		endTimestamp = System.currentTimeMillis();
	}

	public List<InterceptedLine> getLines() {
		return lines;
	}

	public long getStartTimestamp() {
		return startTimestamp;
	}

	public long getEndTimestamp() {
		return endTimestamp;
	}

	public boolean isEmpty() {
		return lines.size() == 0;
	}

	/**
	 * Adds the given line.
	 * 
	 * @param aLine
	 *            the line to add
	 */
	protected void addLine(InterceptedLine aLine) {
		lines.add(aLine);
	}

}
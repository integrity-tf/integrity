/**
 * 
 */
package de.gebit.integrity.runner.console.intercept;

/**
 * The implementation of this interface aggregates lines captured on stdout and stderr into "interception jobs". These
 * combine lines from both streams in one historical order.
 * 
 * @author Rene Schneider
 * 
 */
public interface ConsoleInterceptionAggregator {

	/**
	 * Starts interception. Must be called at least once. May be called repeatedly without any effect.
	 */
	void startIntercept();

	/**
	 * Stops interception. Must be called at some point in time if an interception has been started! Can be called
	 * repeatedly without any effect.
	 */
	void stopIntercept();

	/**
	 * Pauses interception. Streams are kept hooked; this command can thus be called often without negative effects on
	 * performance.
	 */
	void pauseIntercept();

	/**
	 * Resumes a paused interception.
	 */
	void resumeIntercept();

	/**
	 * Returns a single interception job. This automatically starts a new interception job.
	 * 
	 * @return the intercept job
	 */
	Intercept retrieveIntercept();

}

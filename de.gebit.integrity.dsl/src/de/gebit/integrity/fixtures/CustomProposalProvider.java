/**
 * 
 */
package de.gebit.integrity.fixtures;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;
import java.util.Map;

/**
 * Implementations of this interface are used by Integrity inside Eclipse to determine proposals for parameter values.
 * Link implementations to their respective fixture classes by means of {@link CustomProposalFixtureLink}.
 * 
 * @author Rene Schneider
 * 
 */
public interface CustomProposalProvider {

	/**
	 * Returns a list of proposals to be offered to the user for a given fixture method and parameter name.
	 * 
	 * @param aFixtureMethodName
	 *            the name of the fixture method that is being used
	 * @param aParameterName
	 *            the parameter for which the user has requested proposals
	 * @param someParameterValues
	 *            all known parameter values (this includes already defined params as well as any - potentially
	 *            incomplete - information already entered for the currently edited parameter, if available)
	 * @return
	 */
	List<CustomProposalDefinition> defineParameterProposals(String aFixtureMethodName, String aParameterName,
			Map<String, Object> someParameterValues);

	/**
	 * Returns a list of proposals to be offered to the user for a given fixture method and result name.
	 * 
	 * @param aFixtureMethodName
	 *            the name of the fixture method that is being used
	 * @param aResultName
	 *            the result for which the user has requested proposals (may be null if the default result is meant)
	 * @param aResultValue
	 *            the (partially typed) result value, or null if the user hasn't yet entered anything
	 * @param someParameterValues
	 *            all known parameter values
	 * @return
	 */
	List<CustomProposalDefinition> defineResultProposals(String aFixtureMethodName, String aResultName,
			Object aResultValue, Map<String, Object> someParameterValues);

	/**
	 * A container for the definition of one proposal.
	 * 
	 * @author Rene Schneider
	 * 
	 */
	public class CustomProposalDefinition {

		/**
		 * The actual value that will be inserted when the user accepts the proposal.
		 */
		private String value;

		/**
		 * The value displayed to the user in the proposal list. Is optional; if not present, the value from
		 * {@link #value} is used.
		 */
		private String displayValue;

		/**
		 * The longer description / help text which will appear in the content assist window. This is entirely optional.
		 */
		private String description;

		/**
		 * Whether a full-fledged browser shall be used to display the description (if possible). In that case, you can
		 * use pretty much all the possibilities of HTML to style your description. The simpler display component used
		 * if this is false only supports simple text and a few basic tags.
		 */
		private boolean useBrowserForDescription;

		/**
		 * The priority of this proposal. This defines the sorting of proposals. Higher priority is listed higher. 0 is
		 * the default priority.
		 */
		private int priority;

		/**
		 * Whether this proposal shall be subject to prefix filtering (uses the {@link #value} and the input from the
		 * user to filter non-matching proposals out, like when the user typed "gr", the proposal "great" would be
		 * valid, but "bad" wouldn't). Defaults to true.
		 */
		private boolean doPrefixFiltering = true;

		/**
		 * Creates a new instance.
		 * 
		 * @param aValue
		 *            The actual value that will be inserted when the user accepts the proposal
		 * @param aDisplayValue
		 *            The value displayed to the user in the proposal list. Is optional; if not present, the value from
		 *            {@link #value} is used.
		 * @param aDescription
		 *            The longer description / help text which will appear in the content assist window. This is
		 *            entirely optional.
		 * @param aUseBrowserForDescriptionFlag
		 *            Whether a full-fledged browser shall be used to display the description (if possible).
		 * @param aDoPrefixFilteringFlag
		 *            Whether this proposal shall be subject to prefix filtering (uses the {@link #value} and the input
		 *            from the user to filter non-matching proposals out, like when the user typed "gr", the proposal
		 *            "great" would be valid, but "bad" wouldn't). Defaults to true.
		 */
		public CustomProposalDefinition(String aValue, String aDisplayValue, String aDescription,
				boolean aUseBrowserForDescriptionFlag, Integer aPriority, Boolean aDoPrefixFilteringFlag) {
			value = aValue;
			displayValue = aDisplayValue;
			description = aDescription;
			useBrowserForDescription = aUseBrowserForDescriptionFlag;
			if (aPriority != null) {
				priority = aPriority;
			}
			if (aDoPrefixFilteringFlag != null) {
				doPrefixFiltering = aDoPrefixFilteringFlag;
			}
		}

		/**
		 * Creates a new instance.
		 * 
		 * @param aValue
		 *            The actual value that will be inserted when the user accepts the proposal
		 * @param aDisplayValue
		 *            The value displayed to the user in the proposal list. Is optional; if not present, the value from
		 *            {@link #value} is used.
		 * @param aDescription
		 *            The longer description / help text which will appear in the content assist window. This is
		 *            entirely optional.
		 * @param aDoPrefixFilteringFlag
		 *            Whether this proposal shall be subject to prefix filtering (uses the {@link #value} and the input
		 *            from the user to filter non-matching proposals out, like when the user typed "gr", the proposal
		 *            "great" would be valid, but "bad" wouldn't). Defaults to true.
		 */
		public CustomProposalDefinition(String aValue, String aDisplayValue, String aDescription, Integer aPriority,
				Boolean aDoPrefixFilteringFlag) {
			this(aValue, aDisplayValue, aDescription, false, aPriority, aDoPrefixFilteringFlag);
		}

		/**
		 * Creates a new instance.
		 * 
		 * @param aValue
		 *            The actual value that will be inserted when the user accepts the proposal
		 * @param aDisplayValue
		 *            The value displayed to the user in the proposal list. Is optional; if not present, the value from
		 *            {@link #value} is used.
		 * @param aDoPrefixFilteringFlag
		 *            Whether this proposal shall be subject to prefix filtering (uses the {@link #value} and the input
		 *            from the user to filter non-matching proposals out, like when the user typed "gr", the proposal
		 *            "great" would be valid, but "bad" wouldn't). Defaults to true.
		 */
		public CustomProposalDefinition(String aValue, String aDisplayValue, Integer aPriority,
				Boolean aDoPrefixFilteringFlag) {
			this(aValue, aDisplayValue, null, false, aPriority, aDoPrefixFilteringFlag);
		}

		public String getValue() {
			return value;
		}

		public String getDisplayValue() {
			return displayValue;
		}

		public String getDescription() {
			return description;
		}

		public int getPriority() {
			return priority;
		}

		public boolean getDoPrefixFiltering() {
			return doPrefixFiltering;
		}

		public boolean isUseBrowserForDescription() {
			return useBrowserForDescription;
		}

	}

	/**
	 * This annotation is used to link a {@link CustomProposalProvider} to an implementation of
	 * {@link CustomProposalFixture}, for which it will provide the parameter value proposals.
	 * 
	 * 
	 * @author Rene Schneider
	 * 
	 */
	@Target(ElementType.TYPE)
	@Retention(RetentionPolicy.CLASS)
	public @interface CustomProposalFixtureLink {

		/**
		 * The class that this {@link CustomProposalProvider} is linked to.
		 * 
		 * @return
		 */
		Class<? extends CustomProposalFixture>[] value();

	}

}

/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.runner.console;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * A very simple command line parser.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class SimpleCommandLineParser {

	/**
	 * Prefix for short params.
	 */
	private static final String SHORT_PARAMETER_PREFIX = "-";

	/**
	 * Prefix for long params.
	 */
	private static final String LONG_PARAMETER_PREFIX = "--";

	/**
	 * All available command-line options.
	 */
	private List<Option> options = new ArrayList<Option>();

	/**
	 * Add one or more options.
	 * 
	 * @param someOptions
	 */
	public void addOptions(Option... someOptions) {
		for (Option tempOption : someOptions) {
			options.add(tempOption);
		}
	}

	/**
	 * Parses the given parameters and returns all parameters that could not be matched.
	 * 
	 * @param someParameters
	 *            the parameters to parse
	 * @return the remaining unmatched parameters
	 * @throws IllegalArgumentException
	 */
	public String[] parseAndReturnRemaining(String[] someParameters) throws IllegalArgumentException {
		List<String> tempRemainingParams = new ArrayList<String>();

		outer: for (int i = 0; i < someParameters.length; i++) {
			for (Option tempOption : options) {
				if (tempOption.matches(someParameters[i])) {
					if (tempOption instanceof ValueOption) {
						i++;
						if (i < someParameters.length) {
							((ValueOption<?>) tempOption).addValue(someParameters[i]);
						} else {
							throw new IllegalArgumentException(
									"A value is required for parameter '" + someParameters[i - 1] + "'");
						}
					}
					continue outer;
				}
			}

			tempRemainingParams.add(someParameters[i]);
		}

		return tempRemainingParams.toArray(new String[0]);
	}

	/**
	 * Creates a help message to print out on the command line, based on the command line options registered.
	 * 
	 * @param aRemainingParamsHelp
	 *            the text to attach at the end of the "command line"
	 * @return the help message string
	 */
	public String getHelp(String aRemainingParamsHelp) {
		StringBuffer tempBuffer = new StringBuffer();

		tempBuffer.append("Parameters:");
		for (Option tempOption : options) {
			String tempCommandLine = tempOption.getCommandLine();
			if (tempCommandLine != null) {
				tempBuffer.append(" ");
				tempBuffer.append(tempCommandLine);
			}
		}
		tempBuffer.append(aRemainingParamsHelp);

		tempBuffer.append(System.getProperty("line.separator"));
		tempBuffer.append(System.getProperty("line.separator"));

		for (Option tempOption : options) {
			tempBuffer.append(tempOption.getHelpLine());
			tempBuffer.append(System.getProperty("line.separator"));
		}

		return tempBuffer.toString();
	}

	/**
	 * Base class for command line options.
	 * 
	 * 
	 * @author Rene Schneider - initial API and implementation
	 * 
	 */
	public static abstract class Option {

		/**
		 * The short name of the option. Usually just one character.
		 */
		private String shortName;

		/**
		 * The long name of the option, generally a comprehendable, but not-too-long string.
		 */
		private String longName;

		/**
		 * The command line help string for this option.
		 */
		private String commandLine;

		/**
		 * The description for the help.
		 */
		private String description;

		/**
		 * Creates a new Option.
		 * 
		 * @param aShortName
		 *            The short name of the option. Usually just one character.
		 * @param aLongName
		 *            The long name of the option, generelly a comprehendable, but not-too-long string.
		 * @param aDescription
		 *            The command line help string for this option.
		 * @param aCommandLine
		 *            The description for the help.
		 */
		protected Option(String aShortName, String aLongName, String aDescription, String aCommandLine) {
			if (aShortName == null && aLongName == null) {
				throw new IllegalArgumentException("You must provide either a short or long name!");
			}

			shortName = aShortName;
			longName = aLongName;
			description = aDescription;
			commandLine = aCommandLine;
		}

		/**
		 * Checks whether this matches a given parameter.
		 * 
		 * @param aParameter
		 *            the parameter
		 * @return true if a match is found, false otherwise
		 */
		protected boolean matches(String aParameter) {
			return (shortName != null && aParameter.length() > 1 && aParameter.startsWith(SHORT_PARAMETER_PREFIX)
					&& shortName.equals(aParameter.substring(1)))
					| (longName != null && aParameter.length() > 2 && aParameter.startsWith(LONG_PARAMETER_PREFIX)
							&& longName.equals(aParameter.substring(2)));
		}

		public String getShortName() {
			return shortName;
		}

		public String getLongName() {
			return longName;
		}

		public String getDescription() {
			return description;
		}

		public String getCommandLine() {
			return commandLine;
		}

		/**
		 * Returns the line for the parameter help.
		 */
		public String getHelpLine() {
			StringBuilder tempLine = new StringBuilder();

			if (shortName != null) {
				tempLine.append(SHORT_PARAMETER_PREFIX + shortName);
				if (longName != null) {
					tempLine.append(" or " + LONG_PARAMETER_PREFIX + longName);
				}
			} else if (longName != null) {
				tempLine.append(LONG_PARAMETER_PREFIX + longName);
			}
			if (description != null) {
				tempLine.append(": ");
				tempLine.append(description);
			}

			return tempLine.toString();
		}

	}

	/**
	 * A boolean command line option.
	 * 
	 * 
	 * @author Rene Schneider - initial API and implementation
	 * 
	 */
	public static class BooleanOption extends Option {

		/**
		 * The value.
		 */
		private boolean value;

		/**
		 * Creates a new boolean option.
		 * 
		 * @param aShortName
		 *            The short name of the option. Usually just one character.
		 * @param aLongName
		 *            The long name of the option, generelly a comprehendable, but not-too-long string.
		 */
		public BooleanOption(String aShortName, String aLongName) {
			this(aShortName, aLongName, null);
		}

		/**
		 * Creates a new boolean option.
		 * 
		 * @param aShortName
		 *            The short name of the option. Usually just one character.
		 * @param aLongName
		 *            The long name of the option, generelly a comprehendable, but not-too-long string.
		 */
		public BooleanOption(String aShortName, String aLongName, String aDescription) {
			this(aShortName, aLongName, aDescription, null);
		}

		/**
		 * Creates a new boolean option.
		 * 
		 * @param aShortName
		 *            The short name of the option. Usually just one character.
		 * @param aLongName
		 *            The long name of the option, generelly a comprehendable, but not-too-long string.
		 * @param aDescription
		 *            The command line help string for this option.
		 * @param aCommandLine
		 *            The description for the help.
		 */
		public BooleanOption(String aShortName, String aLongName, String aDescription, String aCommandLine) {
			super(aShortName, aLongName, aDescription, aCommandLine);
		}

		@Override
		protected boolean matches(String aParameter) {
			if (super.matches(aParameter)) {
				value = true;
				return true;
			} else {
				return false;
			}
		}

		public boolean isSet() {
			return value;
		}

	}

	/**
	 * A base class for an option that has one or more values. Generally, all options can have multiple values, with the
	 * first one defined being returned if only one result is requested.
	 * 
	 * 
	 * @author Rene Schneider - initial API and implementation
	 * 
	 * @param <X>
	 */
	public static abstract class ValueOption<X extends Object> extends Option {

		/**
		 * The value.
		 */
		private List<X> values = new ArrayList<X>();

		/**
		 * Creates a new value option.
		 * 
		 * @param aShortName
		 *            The short name of the option. Usually just one character.
		 * @param aLongName
		 *            The long name of the option, generelly a comprehendable, but not-too-long string.
		 * @param aDescription
		 *            The command line help string for this option.
		 * @param aCommandLine
		 *            The description for the help.
		 */
		protected ValueOption(String aShortName, String aLongName, String aDescription, String aCommandLine) {
			super(aShortName, aLongName, aDescription, aCommandLine);
		}

		public X getValue() {
			return (values.size() > 0 ? values.get(0) : null);
		}

		/**
		 * Returns the value found in the parameters from the user.
		 * 
		 * @param aDefault
		 *            the default to return if the param is not set
		 * @return the value from the user or the default
		 */
		public X getValue(X aDefault) {
			if (values.size() == 0) {
				return aDefault;
			} else {
				return values.get(0);
			}
		}

		/**
		 * Returns all the values found in the parameters from the user.
		 * 
		 * @return the values from the user (may be an empty list if none were given)
		 */
		public List<X> getValues() {
			return values;
		}

		/**
		 * Sets the value.
		 * 
		 * @param aValue
		 *            the value
		 */
		protected abstract void addValue(String aValue);

		/**
		 * Adds the given value internally to the list of values.
		 * 
		 * @param aValue
		 *            the value to add
		 */
		protected void addValueInternal(X aValue) {
			values.add(aValue);
		}

	}

	/**
	 * String option.
	 * 
	 * 
	 * @author Rene Schneider - initial API and implementation
	 * 
	 */
	public static class StringOption extends ValueOption<String> {

		/**
		 * Creates a new String option.
		 * 
		 * @param aShortName
		 *            The short name of the option. Usually just one character.
		 * @param aLongName
		 *            The long name of the option, generelly a comprehendable, but not-too-long string.
		 */
		public StringOption(String aShortName, String aLongName) {
			this(aShortName, aLongName, null);
		}

		/**
		 * Creates a new String option.
		 * 
		 * @param aShortName
		 *            The short name of the option. Usually just one character.
		 * @param aLongName
		 *            The long name of the option, generelly a comprehendable, but not-too-long string.
		 * @param aDescription
		 *            The command line help string for this option.
		 */
		public StringOption(String aShortName, String aLongName, String aDescription) {
			this(aShortName, aLongName, aDescription, null);
		}

		/**
		 * Creates a new String option.
		 * 
		 * @param aShortName
		 *            The short name of the option. Usually just one character.
		 * @param aLongName
		 *            The long name of the option, generelly a comprehendable, but not-too-long string.
		 * @param aDescription
		 *            The command line help string for this option.
		 * @param aCommandLine
		 *            The description for the help.
		 */
		public StringOption(String aShortName, String aLongName, String aDescription, String aCommandLine) {
			super(aShortName, aLongName, aDescription, aCommandLine);
		}

		/**
		 * Sets a value.
		 */
		@Override
		protected void addValue(String aValue) {
			addValueInternal(aValue);
		}

	}

	/**
	 * Integer option.
	 * 
	 * 
	 * @author Rene Schneider - initial API and implementation
	 * 
	 */
	public static class IntegerOption extends ValueOption<Integer> {

		/**
		 * Creates an integer option.
		 * 
		 * @param aShortName
		 *            The short name of the option. Usually just one character.
		 * @param aLongName
		 *            The long name of the option, generelly a comprehendable, but not-too-long string.
		 */
		public IntegerOption(String aShortName, String aLongName) {
			this(aShortName, aLongName, null);
		}

		/**
		 * Creates a new integer option.
		 * 
		 * @param aShortName
		 *            The short name of the option. Usually just one character.
		 * @param aLongName
		 *            The long name of the option, generelly a comprehendable, but not-too-long string.
		 * @param aDescription
		 *            The command line help string for this option.
		 */
		public IntegerOption(String aShortName, String aLongName, String aDescription) {
			this(aShortName, aLongName, aDescription, null);
		}

		/**
		 * Creates a new integer option.
		 * 
		 * @param aShortName
		 *            The short name of the option. Usually just one character.
		 * @param aLongName
		 *            The long name of the option, generelly a comprehendable, but not-too-long string.
		 * @param aDescription
		 *            The command line help string for this option.
		 * @param aCommandLine
		 *            The description for the help.
		 */
		public IntegerOption(String aShortName, String aLongName, String aDescription, String aCommandLine) {
			super(aShortName, aLongName, aDescription, aCommandLine);
		}

		/**
		 * Sets a value.
		 */
		@Override
		protected void addValue(String aValue) {
			addValueInternal(Integer.parseInt(aValue));
		}

	}

	/**
	 * Decimal option.
	 * 
	 * 
	 * @author Rene Schneider - initial API and implementation
	 * 
	 */
	public static class DecimalOption extends ValueOption<BigDecimal> {

		/**
		 * Creates a new decimal option.
		 * 
		 * @param aShortName
		 *            The short name of the option. Usually just one character.
		 * @param aLongName
		 *            The long name of the option, generelly a comprehendable, but not-too-long string.
		 */
		public DecimalOption(String aShortName, String aLongName) {
			this(aShortName, aLongName, null);
		}

		/**
		 * Creates a new decimal option.
		 * 
		 * @param aShortName
		 *            The short name of the option. Usually just one character.
		 * @param aLongName
		 *            The long name of the option, generelly a comprehendable, but not-too-long string.
		 * @param aDescription
		 *            The command line help string for this option.
		 */
		public DecimalOption(String aShortName, String aLongName, String aDescription) {
			this(aShortName, aLongName, aDescription, null);
		}

		/**
		 * Creates a new decimal option.
		 * 
		 * @param aShortName
		 *            The short name of the option. Usually just one character.
		 * @param aLongName
		 *            The long name of the option, generelly a comprehendable, but not-too-long string.
		 * @param aDescription
		 *            The command line help string for this option.
		 * @param aCommandLine
		 *            The description for the help.
		 */
		public DecimalOption(String aShortName, String aLongName, String aDescription, String aCommandLine) {
			super(aShortName, aLongName, aDescription, aCommandLine);
		}

		/**
		 * Sets a value.
		 */
		@Override
		protected void addValue(String aValue) {
			addValueInternal(new BigDecimal(aValue));
		}
	}

	/**
	 * Long option.
	 * 
	 * 
	 * @author Rene Schneider - initial API and implementation
	 * 
	 */
	public static class LongOption extends ValueOption<Long> {

		/**
		 * Creates a long option.
		 * 
		 * @param aShortName
		 *            The short name of the option. Usually just one character.
		 * @param aLongName
		 *            The long name of the option, generelly a comprehendable, but not-too-long string.
		 */
		public LongOption(String aShortName, String aLongName) {
			this(aShortName, aLongName, null);
		}

		/**
		 * Creates a new integer option.
		 * 
		 * @param aShortName
		 *            The short name of the option. Usually just one character.
		 * @param aLongName
		 *            The long name of the option, generelly a comprehendable, but not-too-long string.
		 * @param aDescription
		 *            The command line help string for this option.
		 */
		public LongOption(String aShortName, String aLongName, String aDescription) {
			this(aShortName, aLongName, aDescription, null);
		}

		/**
		 * Creates a new integer option.
		 * 
		 * @param aShortName
		 *            The short name of the option. Usually just one character.
		 * @param aLongName
		 *            The long name of the option, generelly a comprehendable, but not-too-long string.
		 * @param aDescription
		 *            The command line help string for this option.
		 * @param aCommandLine
		 *            The description for the help.
		 */
		public LongOption(String aShortName, String aLongName, String aDescription, String aCommandLine) {
			super(aShortName, aLongName, aDescription, aCommandLine);
		}

		/**
		 * Sets a value.
		 */
		@Override
		protected void addValue(String aValue) {
			addValueInternal(Long.parseLong(aValue));
		}

	}

}

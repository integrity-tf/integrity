/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.runner.forking;

import java.math.BigDecimal;
import java.time.temporal.TemporalUnit;
import java.util.Date;
import java.util.List;

import org.eclipse.xtext.util.Pair;

/**
 * Callback to deliver events from a fork to the parent.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public interface ForkCallback {

	/**
	 * If the fork sets variables, it will sync them to the parent using this method.
	 * 
	 * @param aQualifiedVariableName
	 *            the variable name
	 * @param aValue
	 *            the new value
	 * @param aDoSendUpdateFlag
	 *            whether updates should be distributed to other remoting clients
	 */
	void onSetVariableValue(String aQualifiedVariableName, Object aValue, boolean aDoSendUpdateFlag);

	/**
	 * If the fork unsets variables, it will sync them to the parent using this method.
	 * 
	 * @param aQualifiedVariableName
	 *            the variable name
	 * @param aDoSendUpdateFlag
	 *            whether updates should be distributed to other remoting clients
	 */
	void onUnsetVariableValue(String aQualifiedVariableName, boolean aDoSendUpdateFlag);

	/**
	 * If the fork wants to perform a time sync, it sends a respective message to the parent, containing a list of all
	 * target forks of this timesync. The master then relays the message to these forks (and processes it for himself if
	 * requested).
	 * 
	 * @param aStartDate
	 * @param aDiffTime
	 * @param aProgressionFactor
	 * @param someTargetedForks
	 */
	void onTimeSync(Date aStartDate, List<Pair<Long, TemporalUnit>> aDiffTime, BigDecimal aProgressionFactor,
			String[] someTargetedForks, Fork aResultTarget);

	/**
	 * Called when the fork exits.
	 * 
	 * @param aFork
	 *            the fork
	 */
	void onForkExit(Fork aFork);

}

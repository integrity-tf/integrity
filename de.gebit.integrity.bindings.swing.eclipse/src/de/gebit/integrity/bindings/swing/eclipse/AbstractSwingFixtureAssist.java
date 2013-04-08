/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.bindings.swing.eclipse;

import java.awt.Component;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import de.gebit.integrity.bindings.swing.AbstractSwingComponentHandler;
import de.gebit.integrity.bindings.swing.authorassist.SwingAuthorAssistServer;
import de.gebit.integrity.fixtures.CustomProposalProvider.CustomProposalDefinition;

/**
 * Abstract base class for providing content assist features to Swing fixtures. This basic functionality mostly covers
 * the identification of components (= assistance while filling the "name" parameter).
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class AbstractSwingFixtureAssist extends AbstractSwingComponentHandler {

	/**
	 * This pattern is used to parse data lines received from the {@link SwingAuthorAssistServer}.
	 */
	protected static final Pattern SUGGESTION_PATTERN = Pattern.compile("(.+?)\\|\\|(.*?)\\|\\|(.*?)\\|\\|(.*)");

	/**
	 * Creates a socket for communication with the {@link SwingAuthorAssistServer}.
	 * 
	 * @return the initialized and connected socket
	 * @throws UnknownHostException
	 * @throws IOException
	 */
	protected Socket createSocket() throws UnknownHostException, IOException {
		return new Socket(SwingAuthorAssistServer.DEFAULT_HOST, SwingAuthorAssistServer.DEFAULT_PORT);
	}

	/**
	 * Requests all proposals from the {@link SwingAuthorAssistServer} for the given component class. The proposals
	 * which are returned are parsed and converted into {@link CustomProposalDefinition} instances as well.
	 * 
	 * @param aComponentClass
	 *            the component class to filter for
	 * @return the list of proposals (may be empty or null in case of no proposals/errors)
	 */
	protected List<CustomProposalDefinition> requestProposals(Class<? extends Component> aComponentClass) {
		Socket tempSocket = null;
		try {
			tempSocket = createSocket();

			PrintWriter tempWriter = new PrintWriter(tempSocket.getOutputStream());
			tempWriter.println(aComponentClass.getName());
			tempWriter.flush();
			BufferedReader tempReader = new BufferedReader(new InputStreamReader(tempSocket.getInputStream()));
			List<CustomProposalDefinition> tempList = new ArrayList<CustomProposalDefinition>();

			String tempLine = tempReader.readLine();
			while (tempLine != null) {
				Matcher tempMatcher = SUGGESTION_PATTERN.matcher(tempLine);
				if (tempMatcher.matches()) {
					String tempLongPath = tempMatcher.group(1);
					String tempShortPath = tempMatcher.group(2);
					String tempHTMLDetails = tempMatcher.group(3);
					String tempPlainDetails = tempMatcher.group(4);

					if (tempHTMLDetails.length() == 0) {
						tempHTMLDetails = null;
					}
					if (tempPlainDetails.length() == 0) {
						tempPlainDetails = null;
					} else {
						tempPlainDetails = tempPlainDetails.replace(SwingAuthorAssistServer.COMPONENT_LINE_NEWLINE,
								"\n");
					}

					boolean tempHasShortPath = tempShortPath.length() > 0 && !tempShortPath.equals(tempLongPath);

					tempList.add(new CustomProposalDefinition('"' + tempLongPath + '"', tempLongPath, tempHTMLDetails,
							tempPlainDetails, tempHasShortPath ? 0 : 1, true));
					if (tempShortPath.length() > 0 && !tempShortPath.equals(tempLongPath)) {
						tempList.add(new CustomProposalDefinition('"' + tempShortPath + '"', tempShortPath,
								tempHTMLDetails, tempPlainDetails, 2, true));
					}
				} else {
					System.err.println("Suggestion line not parseable: '" + tempLine + "'");
				}
				tempLine = tempReader.readLine();
			}

			return tempList;
		} catch (UnknownHostException exc) {
			exc.printStackTrace();
		} catch (IOException exc) {
			exc.printStackTrace();
		} finally {
			if (tempSocket != null) {
				try {
					tempSocket.close();
				} catch (IOException exc) {
					exc.printStackTrace();
				}
			}
		}

		return null;
	}
}

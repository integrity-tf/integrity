/**
 * 
 */
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
import de.gebit.integrity.fixtures.CustomProposalProvider.CustomProposalDefinition;

/**
 * 
 * 
 * @author Rene Schneider
 * 
 */
public class AbstractSwingFixtureAssist extends AbstractSwingComponentHandler {

	public static final int DEFAULT_PORT = 61432;

	public static final String DEFAULT_HOST = "127.0.0.1";

	protected static final Pattern SUGGESTION_PATTERN = Pattern
			.compile("(.+?)\\|\\|\\|(\\d)(?:\\|\\|\\|(.*))?");

	protected Socket createSocket() throws UnknownHostException, IOException {
		return new Socket(DEFAULT_HOST, DEFAULT_PORT);
	}

	protected List<CustomProposalDefinition> requestProposals(
			Class<? extends Component> aComponentClass) {
		Socket tempSocket = null;
		try {
			tempSocket = createSocket();

			PrintWriter tempWriter = new PrintWriter(
					tempSocket.getOutputStream());
			tempWriter.println(aComponentClass.getName());
			tempWriter.flush();
			BufferedReader tempReader = new BufferedReader(
					new InputStreamReader(tempSocket.getInputStream()));
			List<CustomProposalDefinition> tempList = new ArrayList<CustomProposalDefinition>();

			String tempLine = tempReader.readLine();
			while (tempLine != null) {
				Matcher tempMatcher = SUGGESTION_PATTERN.matcher(tempLine);
				if (tempMatcher.matches()) {
					String tempPath = tempMatcher.group(1);
					Integer tempPriority = Integer.parseInt(tempMatcher
							.group(2));
					String tempDetails = (tempMatcher.groupCount() >= 3 ? tempMatcher
							.group(3) : null);
					if (tempDetails != null) {
						// tempDetails = tempDetails.replace(
						// SwingAuthorAssistServer.COMPONENT_LINE_NEWLINE,
						// "\n");
						System.out.println(tempDetails);
					}
					tempList.add(new CustomProposalDefinition(
							'"' + tempPath + '"', tempPath, tempDetails, true,
							tempPriority, true));
				} else {
					System.err.println("Suggestion line not parseable: '"
							+ tempLine + "'");
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

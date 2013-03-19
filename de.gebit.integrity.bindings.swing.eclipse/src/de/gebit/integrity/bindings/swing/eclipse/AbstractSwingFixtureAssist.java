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

	protected static final Pattern SUGGESTION_PATTERN = Pattern.compile("(.+?)\\|\\|(.*?)\\|\\|(.*?)\\|\\|(.*)");

	protected Socket createSocket() throws UnknownHostException, IOException {
		return new Socket(DEFAULT_HOST, DEFAULT_PORT);
	}

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

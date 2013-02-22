/**
 * 
 */
package de.gebit.integrity.runner.exceptions;

import java.io.PrintStream;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;

import de.gebit.integrity.runner.AmbiguousDefinition;
import de.gebit.integrity.utils.ModelSourceUtil;

/**
 * Thrown during model loading if ambiguous definitions (variables, constants, suites, variants, forks) were found.
 * 
 * @author Rene Schneider
 * 
 */
public class ModelAmbiguousException extends ModelLoadException {

	/**
	 * The serial version.
	 */
	private static final long serialVersionUID = 1276709580125035568L;
	/**
	 * The ambiguous definitions which were found.
	 */
	private Set<AmbiguousDefinition> ambiguousDefinitions;

	/**
	 * Creates an instance.
	 * 
	 * @param aMessage
	 *            a string message
	 * @param someAmbiguousDefinitions
	 *            the ambiguous definitions
	 */
	public ModelAmbiguousException(String aMessage, Set<AmbiguousDefinition> someAmbiguousDefinitions) {
		super(aMessage);
		ambiguousDefinitions = someAmbiguousDefinitions;
	}

	public Set<AmbiguousDefinition> getDuplicateDefinitions() {
		return ambiguousDefinitions;
	}

	/**
	 * Prints a readable list of all ambiguous definitions to {@link System.err}.
	 */
	public void printAmbiguousDefinitions() {
		printAmbiguousDefinitions(System.err);
	}

	/**
	 * Prints a readable list of all ambiguous definitions to the given stream.
	 * 
	 * @param aTargetStream
	 *            the target stream
	 */
	public void printAmbiguousDefinitions(PrintStream aTargetStream) {
		for (AmbiguousDefinition tempDefinition : ambiguousDefinitions) {
			aTargetStream.println("Ambiguous definition: " + tempDefinition.getType() + " '"
					+ tempDefinition.getQualifiedName() + "' is defined in");
			for (EObject tempObject : tempDefinition.getDefinitions()) {
				ICompositeNode tempNode = NodeModelUtils.getNode(tempObject);
				if (tempNode != null) {
					String tempFile = ModelSourceUtil.getSourceFilePathForINode(tempNode);
					int tempLine = tempNode.getStartLine();
					aTargetStream.println("  " + tempFile + " on line " + tempLine);
				}
			}
		}
	}

}

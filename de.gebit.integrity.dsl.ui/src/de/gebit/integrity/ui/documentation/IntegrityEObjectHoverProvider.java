/**
 * 
 */
package de.gebit.integrity.ui.documentation;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.util.jdt.IJavaElementFinder;
import org.eclipse.xtext.ui.editor.hover.html.DefaultEObjectHoverProvider;

import com.google.inject.Inject;

import de.gebit.integrity.dsl.CallDefinition;
import de.gebit.integrity.dsl.TestDefinition;
import de.gebit.integrity.utils.JavadocUtil;

/**
 * The custom hover provider.
 * 
 * @author Rene Schneider
 * 
 */
public class IntegrityEObjectHoverProvider extends DefaultEObjectHoverProvider {

	/**
	 * The element finder.
	 */
	@Inject
	IJavaElementFinder elementFinder;

	@Override
	protected boolean hasHover(EObject anObject) {
		if (anObject instanceof TestDefinition) {
			TestDefinition tempTestDefinition = (TestDefinition) anObject;
			if (tempTestDefinition.getFixtureMethod() != null
					&& tempTestDefinition.getFixtureMethod().getMethod() != null) {
				String tempJavadoc = JavadocUtil.getMethodJavadoc(tempTestDefinition.getFixtureMethod().getMethod(),
						elementFinder);
				return tempJavadoc != null;
			}
		} else if (anObject instanceof CallDefinition) {
			CallDefinition tempCallDefinition = (CallDefinition) anObject;
			if (tempCallDefinition.getFixtureMethod() != null
					&& tempCallDefinition.getFixtureMethod().getMethod() != null) {
				String tempJavadoc = JavadocUtil.getMethodJavadoc(tempCallDefinition.getFixtureMethod().getMethod(),
						elementFinder);
				return tempJavadoc != null;
			}
		}

		return false;
	}

}

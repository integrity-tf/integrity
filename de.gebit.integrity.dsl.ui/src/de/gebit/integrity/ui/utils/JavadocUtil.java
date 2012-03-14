package de.gebit.integrity.ui.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IField;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.AbstractTypeDeclaration;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.Javadoc;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.TagElement;
import org.eclipse.jdt.core.dom.TextElement;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.util.jdt.IJavaElementFinder;

/**
 * This utility class contains various helper functions to aid in the exploration of Javadoc data attached to classes.
 * Only for use inside Eclipse!
 * 
 * @author Rene Schneider
 * 
 */
public final class JavadocUtil {

	private JavadocUtil() {
		// nothing to do
	}

	/**
	 * The options to use when parsing a Java Abstract Syntax Tree.
	 */
	@SuppressWarnings("rawtypes")
	private static final Map ASTPARSER_OPTIONS = JavaCore.getDefaultOptions();

	private static MethodDeclaration getMethodDeclaration(JvmOperation aMethod, IJavaElementFinder anElementFinder) {
		IJavaElement tempSourceMethod = (IJavaElement) anElementFinder.findElementFor(aMethod);
		ICompilationUnit tempCompilationUnit = (ICompilationUnit) tempSourceMethod.getParent().getParent();

		AbstractTypeDeclaration tempType = parseCompilationUnit(tempCompilationUnit);

		if (tempType instanceof TypeDeclaration) {
			for (MethodDeclaration tempMethod : ((TypeDeclaration) tempType).getMethods()) {
				// We only check the plain method name and omit the full
				// signature check here because fixture method names are
				// required to be unique per class
				if (aMethod.getSimpleName().equals(tempMethod.getName().getFullyQualifiedName())) {
					return tempMethod;
				}
			}
		}

		return null;
	}

	/**
	 * Returns a map of parameter names to Javadoc descriptions for a given Java method. This explores the @param
	 * Javadoc parameter. Parameters which don't have such an information attached will not be put into the resulting
	 * map.
	 * 
	 * @param aMethod
	 *            the Java method to explore
	 * @param anElementFinder
	 *            the element finder to use for locating the {@link IJavaElement} to the given method
	 * @return the result map, or null if there is no readable Javadoc at all
	 */
	public static Map<String, String> getMethodParamJavadoc(JvmOperation aMethod, IJavaElementFinder anElementFinder) {
		MethodDeclaration tempMethodDeclaration = getMethodDeclaration(aMethod, anElementFinder);

		if (tempMethodDeclaration == null) {
			return null;
		}

		Javadoc tempJavaDoc = tempMethodDeclaration.getJavadoc();
		if (tempJavaDoc != null) {
			Map<String, String> tempResultMap = new HashMap<String, String>();
			for (Object tempTagObject : tempJavaDoc.tags()) {
				TagElement tempTag = (TagElement) tempTagObject;
				if (TagElement.TAG_PARAM.equals(tempTag.getTagName())) {
					if (tempTag.fragments().size() >= 2) {
						Object tempSimpleNameElement = tempTag.fragments().get(0);
						Object tempTextElement = tempTag.fragments().get(1);
						if ((tempSimpleNameElement instanceof SimpleName) && (tempTextElement instanceof TextElement)) {
							tempResultMap.put(((SimpleName) tempSimpleNameElement).getFullyQualifiedName(),
									((TextElement) tempTextElement).getText());
						}
					}
				}
			}
			return tempResultMap;
		}

		return null;
	}

	/**
	 * Returns the Javadoc text attached to a given Java Method.
	 * 
	 * @param aMethod
	 *            the method to explore
	 * @param anElementFinder
	 *            the element finder to use for locating the {@link IJavaElement} for the given method
	 * @return the Javadoc text, or null if none is available
	 */
	public static String getMethodJavadoc(JvmOperation aMethod, IJavaElementFinder anElementFinder) {
		MethodDeclaration tempMethodDeclaration = getMethodDeclaration(aMethod, anElementFinder);

		if (tempMethodDeclaration == null) {
			return null;
		}

		Javadoc tempJavaDoc = tempMethodDeclaration.getJavadoc();
		if (tempJavaDoc != null) {
			return getJavadocMainText(tempJavaDoc);
		}

		return null;
	}

	/**
	 * Returns the Javadoc description attached to a given {@link IField}.
	 * 
	 * @param aField
	 *            the field to explore
	 * @return the Javadoc String, or null if there is none
	 */
	public static String getFieldJavadoc(IField aField) {
		ICompilationUnit tempCompilationUnit = aField.getCompilationUnit();
		AbstractTypeDeclaration tempType = parseCompilationUnit(tempCompilationUnit);

		if (tempType instanceof TypeDeclaration) {
			for (FieldDeclaration tempField : ((TypeDeclaration) tempType).getFields()) {
				if (compareFields(tempField, aField)) {
					Javadoc tempJavadoc = tempField.getJavadoc();
					if (tempJavadoc != null) {
						return getJavadocMainText(tempJavadoc);
					} else {
						break;
					}
				}
			}
		}

		return null;
	}

	/**
	 * Returns the main text part from the given Javadoc.
	 * 
	 * @param aJavadoc
	 *            the Javadoc object to explore
	 * @return the text, or null if there is none
	 */
	protected static String getJavadocMainText(Javadoc aJavadoc) {
		for (Object tempTagObject : aJavadoc.tags()) {
			TagElement tempTag = (TagElement) tempTagObject;
			if (tempTag.getTagName() == null) {
				StringBuffer tempText = new StringBuffer();
				for (Object tempPossibleTextElement : tempTag.fragments()) {
					if (tempPossibleTextElement instanceof TextElement) {
						tempText.append(((TextElement) tempPossibleTextElement).getText());
						tempText.append(' ');
					}
				}
				if (tempText.length() > 0) {
					return tempText.toString();
				}
			}
		}

		return null;
	}

	/**
	 * This checks whether a given {@link FieldDeclaration} and {@link IField} refer to the same field.
	 * 
	 * @param aFieldDeclaration
	 *            the field declaration
	 * @param aField
	 *            the field
	 * @return true if both refer to the same field, false otherwise
	 */
	protected static boolean compareFields(FieldDeclaration aFieldDeclaration, IField aField) {
		@SuppressWarnings("unchecked")
		List<VariableDeclarationFragment> tempFragments = aFieldDeclaration.fragments();
		for (VariableDeclarationFragment tempVariableDeclarationFragment : tempFragments) {
			if (tempVariableDeclarationFragment.getName().getIdentifier().equals(aField.getElementName())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns the {@link AbstractTypeDeclaration} for the given {@link ICompilationUnit}. This basically parses the
	 * given compilation unit into an Abstract Syntax Tree, using the parser provided by the JDT for the job.
	 * 
	 * @param aCompilationUnit
	 *            the compilation unit to parse
	 * @return the AST
	 */
	protected static AbstractTypeDeclaration parseCompilationUnit(ICompilationUnit aCompilationUnit) {
		ASTParser tempParser = ASTParser.newParser(AST.JLS3);
		tempParser.setSource(aCompilationUnit);
		tempParser.setIgnoreMethodBodies(true);
		tempParser.setKind(ASTParser.K_COMPILATION_UNIT);
		tempParser.setCompilerOptions(ASTPARSER_OPTIONS);
		CompilationUnit tempNode = (CompilationUnit) tempParser.createAST(null);

		return (AbstractTypeDeclaration) tempNode.types().get(0);
	}

}
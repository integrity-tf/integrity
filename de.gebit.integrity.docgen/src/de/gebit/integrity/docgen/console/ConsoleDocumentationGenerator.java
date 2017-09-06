/*******************************************************************************
 * Copyright (c) 2017 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.docgen.console;

/**
 * This is a console wrapper of the documentation generator.
 *
 * @author Rene Schneider - initial API and implementation
 *
 */
public class ConsoleDocumentationGenerator {

	/**
	 * Main method to be run by JRE.
	 * 
	 * @param someArgs
	 */
	public static void main(String[] someArgs) {
		ConsoleDocumentationGenerator tempGenerator = new ConsoleDocumentationGenerator();

		int tempResult = tempGenerator.run(someArgs);

		System.exit(tempResult);
	}

	/**
	 * The root method.
	 * 
	 * @param someArgs
	 * @return
	 */
	public int run(String[] someArgs) {

		return 0;
	}

}

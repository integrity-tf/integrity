/*******************************************************************************
 * Copyright (c) 2017 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.docgen;

import java.io.File;
import java.io.IOException;

import de.gebit.integrity.runner.TestModel;

/**
 * The documentation generator is responsible for parsing Integrity files and generating documentation.
 *
 * @author Rene Schneider - initial API and implementation
 *
 */
public interface DocumentationGenerator {

	/**
	 * Initializes the documentation generator with a provided {@link TestModel} containing all the resources for which
	 * documentation shall be generated.
	 * 
	 * @param aModel
	 *            the model to parse
	 */
	void initialize(TestModel aModel);

	/**
	 * Executes the actual generation.
	 * 
	 * @param aTargetDirectory
	 *            the target directory for the documentation results
	 * @throws IOException
	 */
	void run(File aTargetDirectory) throws IOException;

}

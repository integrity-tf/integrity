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

	void initialize(TestModel aModel);

	void run(File aTargetDirectory) throws IOException;

}

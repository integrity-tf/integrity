/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity;

import java.nio.charset.Charset;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.parser.IEncodingProvider;

/**
 * Provides the encoding for .integrity script files. This allows to override the default encoding by specifying an
 * encoding via a system property.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class IntegrityRuntimeEncodingProvider implements IEncodingProvider {

	/**
	 * The system property name for script encoding configuration.
	 */
	public static final String SYSPARAM_SCRIPT_ENCODING = "integrity.script.encoding";

	@Override
	public String getEncoding(URI aUri) {
		String tempEncoding = System.getProperty(SYSPARAM_SCRIPT_ENCODING);
		if (tempEncoding != null) {
			return tempEncoding;
		} else {
			return Charset.defaultCharset().name();
		}
	}

}

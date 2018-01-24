/*******************************************************************************
 * Copyright (c) 2017 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.ui;

import org.eclipse.core.resources.IncrementalProjectBuilder;

import com.google.inject.AbstractModule;

/**
 * This overrides the actual builder.
 *
 * @author Rene Schneider - initial API and implementation
 *
 */
public class IntegrityBuilderModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(IncrementalProjectBuilder.class).to(IntegrityBuilder.class);
	}

}

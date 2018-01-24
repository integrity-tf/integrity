/*******************************************************************************
 * Copyright (c) 2017 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.ui;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.xtext.builder.impl.XtextBuilder;

import de.gebit.integrity.scoping.DSLScopeProvider;

/**
 * An override of the {@link XtextBuilder}.
 *
 * @author Rene Schneider - initial API and implementation
 *
 */
@SuppressWarnings("restriction")
public class IntegrityBuilder extends XtextBuilder {

	@Override
	protected void fullBuild(IProgressMonitor aMonitor, boolean anIsRecoveryBuild) throws CoreException {
		DSLScopeProvider.startFullBuildCycle();

		try {
			super.fullBuild(aMonitor, anIsRecoveryBuild);
		} finally {
			DSLScopeProvider.endFullBuildCycle();
		}
	}

}

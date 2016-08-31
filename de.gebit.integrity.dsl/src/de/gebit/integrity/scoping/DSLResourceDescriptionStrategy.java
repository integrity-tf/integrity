/*******************************************************************************
 * Copyright (c) 2016 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.scoping;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.resource.IDefaultResourceDescriptionStrategy;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionStrategy;
import org.eclipse.xtext.util.IAcceptor;

import de.gebit.integrity.utils.IntegrityDSLUtil;

/**
 * Custom {@link IDefaultResourceDescriptionStrategy} implementation which filters out private stuff.
 *
 * @author Rene Schneider - initial API and implementation
 *
 */
public class DSLResourceDescriptionStrategy extends DefaultResourceDescriptionStrategy {

	@Override
	public boolean createEObjectDescriptions(EObject anObject, IAcceptor<IEObjectDescription> anAcceptor) {
		if (IntegrityDSLUtil.isPrivateInsideSuite(anObject)) {
			return false;
		}

		return super.createEObjectDescriptions(anObject, anAcceptor);
	}

}

/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.xtend.impl;

import org.eclipse.xtext.common.types.JvmVisibility;

/**
 * An anonymous class is never abstract. An anonymous class is never static. An anonymous class is always implicitly
 * final. An anonymous class is always an inner class.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class AnonymousClassImplCustom extends AnonymousClassImpl {

	@Override
	public boolean isAnonymous() {
		return true;
	}

	@Override
	public boolean isStatic() {
		return false;
	}

	@Override
	public boolean isFinal() {
		return true;
	}

	@Override
	public JvmVisibility getDeclaredVisibility() {
		return JvmVisibility.DEFAULT;
	}

	@Override
	public JvmVisibility getVisibility() {
		return JvmVisibility.DEFAULT;
	}

	@Override
	public boolean isLocal() {
		return true;
	}
}

/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.server

interface ISessionStore {
	
	def <T> T get(Object key)
	
	def <T> T get(Object key, ()=>T factory)
	
	def void put(Object key, Object value)
	
	def void remove(Object key)
	
	static class NullImpl implements ISessionStore {
		override <T> get(Object key) {}
		override <T> get(Object key, ()=>T factory) {}
		override put(Object key, Object value) {}
		override remove(Object key) {}
	}
	
}
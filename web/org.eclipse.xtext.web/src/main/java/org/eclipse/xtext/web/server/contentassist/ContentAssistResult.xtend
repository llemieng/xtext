/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.server.contentassist

import java.util.ArrayList
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtend.lib.annotations.EqualsHashCode
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtend.lib.annotations.ToString
import org.eclipse.xtext.web.server.IServiceResult

@Accessors
@ToString(skipNulls = true)
class ContentAssistResult implements IServiceResult {
	
	public static val KEYWORD = 'keyword'
	public static val PARSER_RULE = 'parser-rule'
	public static val FEATURE = 'feature'
	public static val TERMINAL = 'terminal'
	public static val CROSSREF = 'cross-ref'
	
	String stateId
	
	val entries = new ArrayList<Entry>
	
	@Accessors
	@FinalFieldsConstructor
	@ToString(skipNulls = true)
	@EqualsHashCode
	static class Entry {
		/** One of the constants defined in {@link ContentAssistResult} */
		val String type
		val String prefix
		String proposal
		String name
		String description
		/** Available styles: 'default', 'emphasis', 'noemphasis', 'hr' */
		String style
		int escapePosition
		val textReplacements = new ArrayList<TextReplacement>
		val editPositions = new ArrayList<EditPosition>
	}
	
	@Data
	static class TextReplacement {
		String text
		int offset
		int length
	}
	
	@Data
	static class EditPosition {
		int offset
		int length
	}
	
}

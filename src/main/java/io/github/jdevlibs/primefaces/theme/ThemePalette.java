/*  ---------------------------------------------------------------------------
 *  * Copyright 2023 the original author or authors.
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *      https://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *  ---------------------------------------------------------------------------
 */

package io.github.jdevlibs.primefaces.theme;

import java.io.Serializable;

/**
* @author supot.jdev
* @version 1.0
*/
public class ThemePalette implements Serializable {
	private static final long serialVersionUID = 1L;

	private ThemeColor menuColor;
	private ThemeColor menuTheme;
	private ThemeColor topbarTheme;
	private ThemeColor componentTheme;

	public ThemePalette() {
		
	}
	
    public ThemePalette(ThemeColor menuColor, ThemeColor menuTheme, ThemeColor topbarTheme, ThemeColor componentTheme) {
        this.menuColor = menuColor;
        this.menuTheme = menuTheme;
        this.topbarTheme = topbarTheme;
        this.componentTheme = componentTheme;
    }

	public ThemeColor getMenuColor() {
		return menuColor;
	}

	public void setMenuColor(ThemeColor menuColor) {
		this.menuColor = menuColor;
	}

	public ThemeColor getMenuTheme() {
		return menuTheme;
	}

	public void setMenuTheme(ThemeColor menuTheme) {
		this.menuTheme = menuTheme;
	}

	public ThemeColor getTopbarTheme() {
		return topbarTheme;
	}

	public void setTopbarTheme(ThemeColor topbarTheme) {
		this.topbarTheme = topbarTheme;
	}

	public ThemeColor getComponentTheme() {
		return componentTheme;
	}

	public void setComponentTheme(ThemeColor componentTheme) {
		this.componentTheme = componentTheme;
	}
    
}
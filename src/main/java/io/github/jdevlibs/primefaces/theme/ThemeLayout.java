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

public class ThemeLayout implements Serializable {
	private static final long serialVersionUID = 1L;

    private String name;
    private String file;
    private boolean special = false;
    private String color;

    public ThemeLayout() {
    	
    }
    
    public ThemeLayout(String name, String file, String color) {
        this.name = name;
        this.file = file;
        this.color = color;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public boolean isSpecial() {
		return special;
	}

	public void setSpecial(boolean special) {
		this.special = special;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
    
}

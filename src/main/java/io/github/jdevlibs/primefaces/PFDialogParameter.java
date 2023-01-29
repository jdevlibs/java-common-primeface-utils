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

package io.github.jdevlibs.primefaces;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
* @author supot.jdev
* @version 1.0
*/
public class PFDialogParameter implements Serializable {
	private static final long serialVersionUID = 1L;

	private Map<String, Object> params = null;
	
	public void add(String key, Object value) {
		getParams().put(key, value);
	}
	
	@SuppressWarnings("unchecked")
	public <T> T get(String key) {
		Object value = getParams().get(key);
		if (value == null) {
			return null;
		}
		
		return (T) value;
	}
	
	public Set<String> getKeySet() {
		return getParams().keySet();
	}
	
	public boolean isEmpty() {
		return (params == null || params.isEmpty());
	}
	
	private Map<String, Object> getParams() {
		if (params == null) {
			params = new HashMap<>();
		}
		
		return params;
	}
}

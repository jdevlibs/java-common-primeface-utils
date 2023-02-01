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
package io.github.jdevlibs.faces.resource;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * @author Supot Saelao
 * @version 1.0
 */
public abstract class ClassPathResourceBundle extends ResourceBundle {

    private final List<String> bundleNames;
    private Map<String, Object> resourceMap;

    protected ClassPathResourceBundle(List<String> bundleNames) {
        this.bundleNames = bundleNames;
    }

    @Override
    protected Object handleGetObject(String key) {
        if (key == null) {
            throw new NullPointerException();
        }

        this.loadAndMergeBundles();

        return resourceMap.get(key);
    }

    @Override
    public Enumeration<String> getKeys() {
        this.loadAndMergeBundles();

        ResourceBundle parent = this.parent;
        Enumeration<String> keys = (parent != null) ? parent.getKeys() : null;

        return new ResourceBundleEnumeration(resourceMap.keySet(), keys);
    }

    private void loadAndMergeBundles() {
        if (resourceMap != null) {
            return;
        }

        resourceMap = new HashMap<>(512);
        for (String bundleName : bundleNames) {
            ResourceBundle bundle = ResourceBundle.getBundle(bundleName, getLocale());
            Enumeration<String> keys = bundle.getKeys();
            while (keys.hasMoreElements()) {
                String key = keys.nextElement();
                resourceMap.put(key, bundle.getObject(key));
            }
        }
    }
}

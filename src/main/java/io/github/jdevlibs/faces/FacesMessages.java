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
package io.github.jdevlibs.faces;

import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * @author supot.jdev
 * @version 1.0
 */
public final class FacesMessages {
    private static final String BUNDLE_CONF_VAR = "msg";

    private FacesMessages() {
    }

    public static String getMessage(String key) {
        return getValue(key, null);
    }

    public static String getMessage(String key, Object... params) {
        return getValue(key, params);
    }

    private static String getValue(String key, Object[] params) {
        String msg;
        try {
            msg = getBundle().getString(key);
            if (JSFValidators.isEmpty(msg)) {
                return msg;
            }

            if (JSFValidators.isNotEmpty(params)) {
                msg = MessageFormat.format(msg, toString(params));
            }
        } catch (MissingResourceException | IllegalArgumentException ex) {
            msg = key;
        }

        return msg;
    }

    private static Object[] toString(Object ... params) {
        if (JSFValidators.isEmpty(params)) {
            return params;
        }

        for (int i = 0; i < params.length; i++) {
            if (!(params[i] instanceof String)) {
                params[i] = String.valueOf(params[i]);
            } else if(params[i] == null) {
                params[i] = "";
            }
        }
        return params;
    }

    private static ResourceBundle getBundle() {
        String varMsg = System.getProperty("faces.bundle.var", BUNDLE_CONF_VAR);
        return FacesUtils.getResourceBundle(varMsg);
    }
}

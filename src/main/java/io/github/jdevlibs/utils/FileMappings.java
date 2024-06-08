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
package io.github.jdevlibs.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author supot.jdev
 * @version 1.0
 */
public final class FileMappings {
    private static final Map<String, String> fileIcons;
    static {
        fileIcons = new HashMap<>();
        fileIcons.put("file", "fa-solid fa-file");
        fileIcons.put("xlsx", "fa-solid fa-file-excel text-green-500");
        fileIcons.put("xls", "fa-solid fa-file-excel text-green-500");
        fileIcons.put("docx", "fa-solid fa-file-word text-blue-500");
        fileIcons.put("doc", "fa-solid fa-file-word text-blue-500");
        fileIcons.put("pptx", "fa-solid fa-file-powerpoint text-orange-500");
        fileIcons.put("ppt", "fa-solid fa-file-powerpoint text-orange-500");
        fileIcons.put("pdf", "fa-solid fa-file-pdf text-red-500");
        fileIcons.put("csv", "fa-solid fa-file-csv text-green-500");
        fileIcons.put("png", "fa-solid fa-file-image");
        fileIcons.put("jpg", "fa-solid fa-file-image");
        fileIcons.put("gif", "fa-solid fa-file-image");
        fileIcons.put("jpeg", "fa-solid fa-file-image");
        fileIcons.put("txt", "fa-solid fa-file-lines");
        fileIcons.put("zip", "fa-solid fa-file-zipper");
        fileIcons.put("7z", "fa-solid fa-file-zipper");
        fileIcons.put("rar", "fa-solid fa-file-zipper");
    }

    private FileMappings() {
    }

    public static String getFileCssIcon(String ext) {
        if (ext == null || ext.isEmpty()) {
            return fileIcons.get("file");
        }
        String css = fileIcons.get(ext.toLowerCase());
        return (css == null || css.isEmpty() ? "fa-solid fa-file" : css);
    }
}

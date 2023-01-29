/*  ---------------------------------------------------------------------------
 *  * Copyright 2020-2021 the original author or authors.
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
import java.util.HashMap;
import java.util.Map;

/**
 * Utilities class for mapping file MimeType
 * @author Supot Saelao
 * @version 1.0
 */
public final class JSFMimeTypes {
	private static final String ATTACHMENT = "attachment; filename=\"{0}\"";
	private static final String DEF_TYPE = "application/octet-stream";	
	private static final Map<String, String> MAPS;
	
	static {
		// Ref http://reference.sitepoint.com/html/mime-types-full
		MAPS = new HashMap<>(785);
		MAPS.put("7z", "application/x-7z-compressed");
		MAPS.put("afp", "application/vndibmmodcap");
		MAPS.put("ai", "application/postscript");
		MAPS.put("aifc", "audio/x-aiff");
		MAPS.put("aiff", "audio/x-aiff");
		MAPS.put("apk", "application/vndandroidpackage-archive");
		MAPS.put("application", "application/x-ms-application");
		MAPS.put("asf", "video/x-ms-asf");
		MAPS.put("asr", "video/x-ms-asf");
		MAPS.put("asx", "video/x-ms-asf");
		MAPS.put("atom", "application/atom+xml");
		MAPS.put("au", "audio/basic");
		MAPS.put("avi", "video/x-msvideo");
		MAPS.put("bas", "text/plain");
		MAPS.put("bmp", "image/bmp");
		MAPS.put("btif", "image/prsbtif");
		MAPS.put("bz", "application/x-bzip");
		MAPS.put("bz2", "application/x-bzip2");
		MAPS.put("c", "text/x-c");
		MAPS.put("cgm", "image/cgm");
		MAPS.put("cmx", "image/x-cmx");
		MAPS.put("css", "text/css");
		MAPS.put("csv", "text/csv");
		MAPS.put("doc", "application/msword");
		MAPS.put("docm", "application/vndms-worddocumentmacroenabled12");
		MAPS.put("docx", "application/vndopenxmlformats-officedocumentwordprocessingmldocument");
		MAPS.put("dot", "application/msword");
		MAPS.put("dotm", "application/vndms-wordtemplatemacroenabled12");
		MAPS.put("dotx", "application/vndopenxmlformats-officedocumentwordprocessingmltemplate");
		MAPS.put("fpx", "image/vndfpx");
		MAPS.put("fst", "image/vndfst");
		MAPS.put("g3", "image/g3fax");
		MAPS.put("gif", "image/gif");
		MAPS.put("gz", "application/x-gzip");
		MAPS.put("h", "text/plain");
		MAPS.put("h261", "video/h261");
		MAPS.put("h263", "video/h263");
		MAPS.put("h264", "video/h264");
		MAPS.put("htm", "text/html");
		MAPS.put("html", "text/html");
		MAPS.put("ico", "image/x-icon");
		MAPS.put("ics", "text/calendar");
		MAPS.put("ief", "image/ief");
		MAPS.put("jar", "application/java-archive");
		MAPS.put("java", "text/x-java-source");
		MAPS.put("jpe", "image/jpeg");
		MAPS.put("jpeg", "image/jpeg");
		MAPS.put("jpg", "image/jpeg");
		MAPS.put("jpgv", "video/jpeg");
		MAPS.put("jpm", "video/jpm");
		MAPS.put("js", "application/x-javascript");
		MAPS.put("json", "application/json");
		MAPS.put("latex", "application/x-latex");
		MAPS.put("m3u", "audio/x-mpegurl");
		MAPS.put("m4v", "video/x-m4v");
		MAPS.put("mht", "message/rfc822");
		MAPS.put("mhtml", "message/rfc822");
		MAPS.put("mov", "video/quicktime");
		MAPS.put("movie", "video/x-sgi-movie");
		MAPS.put("mp2", "video/mpeg");
		MAPS.put("mp3", "audio/mpeg");
		MAPS.put("mp4", "video/mp4");
		MAPS.put("mp4a", "audio/mp4");
		MAPS.put("mpa", "video/mpeg");
		MAPS.put("mpe", "video/mpeg");
		MAPS.put("mpeg", "video/mpeg");
		MAPS.put("mpg", "video/mpeg");
		MAPS.put("mpga", "audio/mpeg");
		MAPS.put("mpv2", "video/mpeg");
		MAPS.put("oga", "audio/ogg");
		MAPS.put("ogv", "video/ogg");
		MAPS.put("p", "text/x-pascal");
		MAPS.put("pbm", "image/x-portable-bitmap");
		MAPS.put("pcx", "image/x-pcx");
		MAPS.put("pdf", "application/pdf");
		MAPS.put("pgm", "image/x-portable-graymap");
		MAPS.put("pic", "image/x-pict");
		MAPS.put("png", "image/png");
		MAPS.put("pnm", "image/x-portable-anymap");
		MAPS.put("pot", "application/vndms-powerpoint");
		MAPS.put("potm", "application/vndms-powerpointtemplatemacroenabled12");
		MAPS.put("potx", "application/vndopenxmlformats-officedocumentpresentationmltemplate");
		MAPS.put("ppam", "application/vndms-powerpointaddinmacroenabled12");
		MAPS.put("ppm", "image/x-portable-pixmap");
		MAPS.put("pps", "application/vndms-powerpoint");
		MAPS.put("ppsm", "application/vndms-powerpointslideshowmacroenabled12");
		MAPS.put("ppsx", "application/vndopenxmlformats-officedocumentpresentationmlslideshow");
		MAPS.put("ppt", "application/vndms-powerpoint");
		MAPS.put("pptm", "application/vndms-powerpointpresentationmacroenabled12");
		MAPS.put("pptx", "application/vndopenxmlformats-officedocumentpresentationmlpresentation");
		MAPS.put("prc", "application/x-mobipocket-ebook");
		MAPS.put("pre", "application/vndlotus-freelance");
		MAPS.put("prf", "application/pics-rules");
		MAPS.put("ps", "application/postscript");
		MAPS.put("psb", "application/vnd3gpppic-bw-small");
		MAPS.put("psd", "image/vndadobephotoshop");
		MAPS.put("rgb", "image/x-rgb");
		MAPS.put("rs", "application/rls-services+xml");
		MAPS.put("rsd", "application/rsd+xml");
		MAPS.put("rss", "application/rss+xml");
		MAPS.put("rtf", "application/rtf");
		MAPS.put("rtx", "text/richtext");
		MAPS.put("svg", "image/svg+xml");
		MAPS.put("tex", "application/x-tex");
		MAPS.put("tgz", "application/x-compressed");
		MAPS.put("tif", "image/tiff");
		MAPS.put("tiff", "image/tiff");
		MAPS.put("torrent", "application/x-bittorrent");
		MAPS.put("tpl", "application/vndgroove-tool-template");
		MAPS.put("tpt", "application/vndtridtpt");
		MAPS.put("ttf", "application/x-font-ttf");
		MAPS.put("ttl", "text/turtle");
		MAPS.put("txf", "application/vndmobiustxf");
		MAPS.put("txt", "text/plain");
		MAPS.put("weba", "audio/webm");
		MAPS.put("webm", "video/webm");
		MAPS.put("webp", "image/webp");
		MAPS.put("xhtml", "application/xhtml+xml");
		MAPS.put("xif", "image/vndxiff");
		MAPS.put("xla", "application/vndms-excel");
		MAPS.put("xlam", "application/vndms-exceladdinmacroenabled12");
		MAPS.put("xlc", "application/vndms-excel");
		MAPS.put("xlm", "application/vndms-excel");
		MAPS.put("xls", "application/vndms-excel");
		MAPS.put("xlsb", "application/vndms-excelsheetbinarymacroenabled12");
		MAPS.put("xlsm", "application/vndms-excelsheetmacroenabled12");
		MAPS.put("xlsx", "application/vndopenxmlformats-officedocumentspreadsheetmlsheet");
		MAPS.put("xlt", "application/vndms-excel");
		MAPS.put("xltm", "application/vndms-exceltemplatemacroenabled12");
		MAPS.put("xltx", "application/vndopenxmlformats-officedocumentspreadsheetmltemplate");
		MAPS.put("xlw", "application/vndms-excel");
		MAPS.put("xml", "application/xml");
		MAPS.put("zip", "application/zip");
	}
	
	private JSFMimeTypes(){}
	
	public static String getMimeType(final String fileName) {
		String contentType = MAPS.get(getExtension(fileName));
		if (JSFValidators.isEmpty(contentType)) {
			return DEF_TYPE;
		}

		return contentType;
	}
	
	public static String getAttachment(final String fileName) {
		return MessageFormat.format(ATTACHMENT, fileName);
	}
	
	private static String getExtension(String fileName) {
		if (JSFValidators.isEmpty(fileName)) {
			return null;
		}

		String[] names = fileName.split("[.]");
		if (JSFValidators.isEmpty(names)) {
			return null;
		}

		return names[names.length - 1];
	}
}

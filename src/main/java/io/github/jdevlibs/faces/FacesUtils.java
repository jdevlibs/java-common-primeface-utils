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

import jakarta.faces.application.Application;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.application.FacesMessage.Severity;
import jakarta.faces.component.UIComponent;
import jakarta.faces.component.UIViewRoot;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.FacesEvent;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.*;

/**
* @author supot.jdev
* @version 1.0
*/
public final class FacesUtils {
	private static final int DEF_FILE_BUFFER_SIZE 	= 10240;
	private static final String FILE_ENCODE 		= "UTF-8";
	private static final String USER_AGENT 			= "user-agent";
	private static final String CONTENT_DISP 		= "Content-Disposition";
	private static final String SLASH 				= "/";
	private static final String FACE_REDIRECT		= "faces-redirect=true";
	private static final String FIREFOX 			= "Firefox";
	private static final String CHROME				= "Chrome";
	private static final String SAFARI 				= "Safari";
	private static final String MS_EDGE 			= "Edge";
	private static final String DOWNLOAD_COOKIE 	= "primefaces.download";
	
	private FacesUtils() {
	}

	public static boolean isLangThai() {
		return "th".equalsIgnoreCase(getLanguage()) 
				|| "th_TH".equalsIgnoreCase(getLanguage());
	}

	public static boolean isLangEng() {
		return !isLangThai();
	}
	
	public static FacesContext getContext() {
		return FacesContext.getCurrentInstance();
	}

	public static UIViewRoot getViewRoot() {
		return getContext().getViewRoot();
	}

	@SuppressWarnings("unchecked")
	public static <T> T getRequestAttribute(FacesContext context, String name) {
		Map<String, Object> reqMaps = getRequestMap(context);
		return (T) reqMaps.get(name);
	}

	public static void setRequestAttribute(FacesContext context, String name, Object value) {
		getRequestMap(context).put(name, value);
	}

	public static InputStream getResourceAsStream(String path) {
		if (JSFValidators.isEmpty(path)) {
			return null;
		}

		return getExternalContext().getResourceAsStream(path);
	}

	public static URL getResource(String path) {
		try {
			if (JSFValidators.isEmpty(path)) {
				return null;
			}

			return getExternalContext().getResource(path);
		} catch (MalformedURLException ex) {
			return null;
		}
	}

	public static Severity getMaximumSeverity() {
		return getContext().getMaximumSeverity();
	}

	public static void setResponseComplete() {
		getContext().responseComplete();
	}

	public static ExternalContext getExternalContext() {
		return FacesContext.getCurrentInstance().getExternalContext();
	}

	public static Application getApplication() {
		return getContext().getApplication();
	}

	public static ResourceBundle getResourceBundle(String bundleVar) {
		return getApplication().getResourceBundle(getContext(), bundleVar);
	}

	public static HttpServletResponse getResponse() {
		return (HttpServletResponse) getExternalContext().getResponse();
	}

	public static HttpServletResponse getResponse(String fileName) {
		HttpServletResponse resp = getResponse();
		resp.setContentType(JSFMimeTypes.getMimeType(fileName));
		resp.setHeader(CONTENT_DISP, JSFMimeTypes.getAttachment(fileName));
		return resp;
	}

	public static HttpServletRequest getRequest() {
		return (HttpServletRequest) getExternalContext().getRequest();
	}

    public static HttpSession getSession() {
        return (HttpSession) getExternalContext().getSession(true);
    }

    public static Map<String, Object> getSessionMap() {
        return getExternalContext().getSessionMap();
    }

    public static void addSession(String key, Object value) {
    	getSessionMap().put(key, value);
    }
    
	@SuppressWarnings("unchecked")
	public static <T> T getSessionValue(String key) {
		return (T) getSessionMap().get(key);
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T getAttributes(UIComponent comp, String name) {
		if (JSFValidators.isNull(comp) || JSFValidators.isEmpty(name)) {
			return null;
		}
		
		return (T) comp.getAttributes().get(name);
	}

	public static void removeSession(String key) {
		try {
			getSessionMap().remove(key);
		} catch (Exception ex) {
			// Ignore exception
		}
	}
    
	public static void createCookie(String name, String value) {
		createCookie(name, value, 0);
	}
	
	public static void createCookie(String name, String value, int expireMinute) {
		if (JSFValidators.isEmpty(name)) {
			return;
		}
		Cookie cookie = new Cookie(name, value);
		if (expireMinute <= 0) {
			// 30 days
			expireMinute = (30 * 86400);
		}
		
		cookie.setMaxAge(expireMinute);
		
		HttpServletResponse resp = getResponse();
		resp.addCookie(cookie);
	}
	
	public static String getCookie(String name) {
		try {
			if (JSFValidators.isEmpty(name)) {
				return null;
			}
			
			HttpServletRequest request = getRequest();
			Cookie[] cookies = request.getCookies();
			if (JSFValidators.isEmpty(cookies)) {
				return null;
			}

			Optional<String> value = Arrays.stream(cookies)
					.filter(c -> name.equals(c.getName()))
					.map(Cookie::getValue).findAny();
			return (value.orElse(null));
		} catch (Exception ex) {
			//Skip
		}
		
		return null;
	}
	
	public static String getContextPath() {
		return getExternalContext().getRequestContextPath();
	}

	public static String getRequestPath() {
		HttpServletRequest request = getRequest();
		StringBuilder requestURL = new StringBuilder(request.getRequestURL().toString());
		String queryString = request.getQueryString();

		if (queryString == null) {
			return requestURL.toString();
		} else {
			return requestURL.append('?').append(queryString).toString();
		}
	}
	
	public static String getRequestUrl() {
		HttpServletRequest request = getRequest();
		return getFullUrl(request);
	}
	
	public static List<Locale> getSupportedLocales() {
		Iterator<Locale> its = getApplication().getSupportedLocales();
		if (JSFValidators.isEmpty(its)) {
			return new ArrayList<>(0);
		}

		List<Locale> locales = new ArrayList<>();
		while (its.hasNext()) {
			locales.add(its.next());
		}

		return locales;
	}

	public static void setLocale(String locale) {
		if (JSFValidators.isEmpty(locale)) {
			return;
		}
		setLocale(new Locale(locale));
	}
	
	public static void setLocale(Locale locale) {
		if (JSFValidators.isNull(locale)) {
			return;
		}
		
		getContext().getViewRoot().setLocale(locale);
	}

	public static Locale getLocale() {
		return getContext().getViewRoot().getLocale();
	}

	public static String getLanguage() {
		return getContext().getViewRoot().getLocale().getLanguage();
	}

	public static Map<String, String> getReqParameterMap() {
		Map<String, String> params = getExternalContext().getRequestParameterMap();
		if (JSFValidators.isNull(params)) {
			params = new HashMap<>();
		}
		return params;
	}
	
	public static Map<String, Object> getRequestMap(FacesContext context) {
		return context.getExternalContext().getRequestMap();
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T getParameter(String key) {
		return (T) getReqParameterMap().get(key);
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T getParameter(FacesEvent event, String name) {
		if (JSFValidators.isNull(event) || JSFValidators.isEmpty(name)) {
			return null;
		}
		
		Object value = event.getComponent().getAttributes().get(name);
		if (JSFValidators.isNull(value)) {
			return null;
		}
		return (T) value;
	}
	
	public static void invalidateSession() {
		getExternalContext().invalidateSession();
	}

	/**
	 * Redirect to current application page (.xhtml page)
	 * @param page Page/Url on current application
	 */
	public static void redirectToPage(String page) {
		if (JSFValidators.isEmpty(page)) {
			return;
		}

		String url = getContextPath();
		if (page.indexOf(SLASH) != 0) {
			url += SLASH + page;
		} else {
			url += page;
		}
		try {
			getExternalContext().redirect(url);
		} catch (IOException ex) {
			//Skip
		}
	}

	public static void redirectToUrl(String url) throws IOException {
		if (JSFValidators.isEmpty(url)) {
			return;
		}
		getExternalContext().redirect(url);
	}
	
    public static String redirectToOutcome(String outcome) {
        if (outcome == null || outcome.isEmpty()) {
            return null;
        }

        if (outcome.indexOf('?') >= 1) {
            return outcome + "&" + FACE_REDIRECT;
        } else {
            return outcome + "?" + FACE_REDIRECT;
        }
    }

	public static String concatPath(String path){
		if (JSFValidators.isEmpty(path)) {
			return path;
		}

		String url = getContextPath();
		if (path.indexOf(SLASH) != 0) {
			url += SLASH + path;
		} else {
			url += path;
		}
		
		return url;
	}
	
    public static String getCurrentViewId() {
        if (JSFValidators.isNotNull(getContext().getViewRoot())) {
            return getContext().getViewRoot().getViewId();
        }

        return null;
    }
    
    public static String getUserAgent() {
		return getRequest().getHeader(USER_AGENT);
    }
    
	public static void responseComplete() {
		getContext().responseComplete();
	}
	
	public static void responseCompleteWithMonitor() {
		getExternalContext().setResponseStatus(200);
		getContext().responseComplete();
	}
	
	public static boolean isValidationFailed() {
		return getContext().isValidationFailed();
	}
	
    public static boolean isEmptyError() {
        return JSFValidators.isEmpty(getContext().getMessageList());
    }

    public static boolean isPostback() {
        return getContext().isPostback();
    }
    
	public static boolean isBrowserFirefox() {
		String userAgent = getUserAgent();
		if (JSFValidators.isEmpty(userAgent)) {
			return false;
		}

		return userAgent.contains(FIREFOX);
	}
    
	public static boolean isBrowserChrome() {
		String userAgent = getUserAgent();
		if (JSFValidators.isEmpty(userAgent)) {
			return false;
		}

		return (userAgent.contains(CHROME) && !userAgent.contains(MS_EDGE));
	}
	
	public static boolean isBrowserMsEdge() {
		String userAgent = getUserAgent();
		if (JSFValidators.isEmpty(userAgent)) {
			return false;
		}

		return (userAgent.contains(SAFARI) && userAgent.contains(MS_EDGE));
	}
	
	public static void validationFailed() {
	    getContext().validationFailed();
	}
	
	public static void clearError() {
	    getContext().getMessageList().clear();
	    getContext().getMessages().remove();
	}
	
	public static UIComponent findComponent(String compId) {
		return getViewRoot().findComponent(compId);
	}
    
	public static FacesMessage createInfoMessage(String summary) {
		return createInfoMessage(summary, null);
	}

	public static FacesMessage createInfoMessage(String summary, String detail) {
		return createFacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
	}

	public static FacesMessage createWarnMessage(String summary) {
		return createWarnMessage(summary, null);
	}

	public static FacesMessage createWarnMessage(String summary, String detail) {
		return createFacesMessage(FacesMessage.SEVERITY_WARN, summary, detail);
	}

	public static FacesMessage createErrorMessage(String summary) {
		return createErrorMessage(summary, null);
	}

	public static FacesMessage createErrorMessage(String summary, String detail) {
		return createFacesMessage(FacesMessage.SEVERITY_ERROR, summary, detail);
	}

	public static FacesMessage createFaltalMessage(String summary) {
		return createFaltalMessage(summary, null);
	}

	public static FacesMessage createFaltalMessage(String summary, String detail) {
		return createFacesMessage(FacesMessage.SEVERITY_FATAL, summary, detail);
	}

	public static void addInforMessage(String message) {
		addMessage(FacesMessage.SEVERITY_INFO, message);
	}

	public static void addInforMessage(String inputId, String message) {
		addMessage(FacesMessage.SEVERITY_INFO, inputId, message);
	}

	public static void addInforMessage(String inputId, String title, String message) {
		addMessage(FacesMessage.SEVERITY_INFO, inputId, title, message);
	}
	
	public static void addWarnMessage(String message) {
		addMessage(FacesMessage.SEVERITY_WARN, message);
	}

	public static void addWarnMessage(String inputId, String message) {
		addMessage(FacesMessage.SEVERITY_WARN, inputId, message);
	}

	public static void addWarnMessage(String inputId, String title, String message) {
		addMessage(FacesMessage.SEVERITY_WARN, inputId, title, message);
	}
	
	public static void addErrorMessage(String message) {
		addMessage(FacesMessage.SEVERITY_ERROR, message);
		getContext().validationFailed();
	}

	public static void addErrorMessage(String inputId, String message) {
		addMessage(FacesMessage.SEVERITY_ERROR, inputId, message);
		getContext().validationFailed();
	}

	public static void addErrorMessage(String inputId, String title, String message) {
		addMessage(FacesMessage.SEVERITY_ERROR, inputId, title, message);
		getContext().validationFailed();
	}
	
	public static void addFatalMessage(String message) {
		addMessage(FacesMessage.SEVERITY_FATAL, message);
		getContext().validationFailed();
	}

	public static void addFatalMessage(String inputId, String message) {
		addMessage(FacesMessage.SEVERITY_FATAL, inputId, message);
		getContext().validationFailed();
	}
	
	public static String encodeURL(String string) {
		if (string == null) {
			return null;
		}

		try {
			return URLEncoder.encode(string, FILE_ENCODE);
		} catch (UnsupportedEncodingException e) {
			return null;
		}
	}
	
	public static void setMonitorDownloadResponse(String fileName) {
		setMonitorDownloadResponse(fileName, true);
	}
	
	public static void setMonitorDownloadResponse(String fileName, boolean attachment) {
		ExternalContext ctx = getExternalContext();
		HttpServletRequest req = getRequest();

		setFileResponseHeader(ctx, fileName, attachment);
		if (req.isSecure()) {
			setSecureResponseHeader(ctx);
		}
		
		getExternalContext().setResponseStatus(200);
		getContext().responseComplete();
	}
	
	public static OutputStream createFileOutputStream(String fileName) throws IOException {
		return createFileOutputStream(fileName, true);
	}
	
	public static OutputStream createFileOutputStream(String fileName, boolean attachment) throws IOException {

		ExternalContext ctx = getExternalContext();
		HttpServletRequest req = getRequest();
		
		setFileResponseHeader(ctx, fileName, attachment);
		if (req.isSecure()) {
			setSecureResponseHeader(ctx);
		}

		return ctx.getResponseOutputStream();
	}
	
	public static void downloadFile(File file) throws IOException {
		downloadFile(new FileInputStream(file), file.getName(), file.length(), true);
	}
	
	public static void downloadFile(File file, String outputName) throws IOException {
		downloadFile(new FileInputStream(file), outputName, file.length(), true);
	}
	
	public static void downloadFile(File file, boolean attachment) throws IOException {
		downloadFile(new FileInputStream(file), file.getName(), file.length(), attachment);
	}

	public static void downloadFile(byte[] content, String filename) throws IOException {
		downloadFile(new ByteArrayInputStream(content), filename, content.length, true);
	}

	public static void downloadFile(byte[] content, String filename, boolean attachment)
			throws IOException {
		downloadFile(new ByteArrayInputStream(content), filename, content.length, attachment);
	}

	public static void downloadFile(InputStream content, String filename)
			throws IOException {
		downloadFile(content, filename, -1, true);
	}
	
	public static void downloadFile(InputStream content, String filename, boolean attachment)
			throws IOException {
		downloadFile(content, filename, -1, attachment);
	}
	
	private static void downloadFile(InputStream input, String filename, long contentLength,
			boolean attachment) throws IOException {
		
		ExternalContext ctx = getExternalContext();
		HttpServletRequest req = getRequest();
		
		setFileResponseHeader(ctx, filename, attachment);
		if (req.isSecure()) {
			setSecureResponseHeader(ctx);
		}
		
		if (contentLength != -1) {
			ctx.setResponseHeader("Content-Length", String.valueOf(contentLength));
		}
		
		long fileSize = stream(input, ctx.getResponseOutputStream());
		
		// This may be on time for files smaller than the default buffer size
		if (contentLength == -1) {
			ctx.setResponseHeader("Content-Length", String.valueOf(fileSize));
		}
		
		getExternalContext().setResponseStatus(200);
		getContext().responseComplete();
	}
	
	private static long stream(InputStream input, OutputStream output) throws IOException {
		ReadableByteChannel inputChannel = null;
		WritableByteChannel outputChannel = null;
		try {
			inputChannel = Channels.newChannel(input);
			outputChannel = Channels.newChannel(output);
			ByteBuffer buffer = ByteBuffer.allocateDirect(DEF_FILE_BUFFER_SIZE);
			long size = 0;
			while (inputChannel.read(buffer) != -1) {
				buffer.flip();
				size += outputChannel.write(buffer);
				buffer.clear();
			}

			return size;
		} finally {
			close(outputChannel);
			close(inputChannel);
		}
	}
	
	private static void setFileResponseHeader(ExternalContext ctx, String fileName, boolean attachment) {
		fileName = encodeURL(fileName);
		String contentDisp = (attachment ? "attachment" : "inline") + ";filename=\"" + fileName + "\"";
		if (isBrowserFirefox()) {
			contentDisp = (attachment ? "attachment" : "inline") + ";filename*='UTF-8'" + fileName;
		}

		ctx.setResponseBufferSize(DEF_FILE_BUFFER_SIZE);
		ctx.setResponseContentType(JSFMimeTypes.getMimeType(fileName));
		ctx.setResponseCharacterEncoding(FILE_ENCODE);
		ctx.addResponseHeader(CONTENT_DISP, contentDisp);
		ctx.addResponseHeader("language", "th-TH");
		ctx.addResponseCookie(DOWNLOAD_COOKIE, "true", new HashMap<>(0));
	}
	
	private static void setSecureResponseHeader(ExternalContext ctx) {
		// Not exactly mandatory, but this fixes at least a MSIE link: 
		// http://support.microsoft.com/kb/316431
		ctx.addResponseHeader("Cache-Control", "public");
		ctx.addResponseHeader("Pragma", "public");
	}
	
	private static void close(Closeable resource) {
		if (resource != null) {
			try {
				resource.close();
			} catch (IOException ex) {
				//Ignore exception
			}
		}
	}
	
	private static void addMessage(Severity severity, String message) {
		getContext().addMessage(null, new FacesMessage(severity, message, null));
	}

	private static void addMessage(Severity severity, String clientId, String message) {
		getContext().addMessage(clientId, new FacesMessage(severity, message, null));
	}
	
	private static void addMessage(Severity messageType, String clientId, String title, String message) {
		getContext().addMessage(clientId, new FacesMessage(messageType, title, message));
	}
	
	private static FacesMessage createFacesMessage(Severity severity,  String summary, String detail) {
		return new FacesMessage(severity, summary, detail);
	}
	
	private static String getFullUrl(HttpServletRequest req) {

		String scheme = req.getScheme(); // http
		String serverName = req.getServerName(); // hostname.com
		int serverPort = req.getServerPort(); // 80
		String contextPath = req.getContextPath(); // /mywebapp
		String servletPath = req.getServletPath(); // /servlet/MyServlet
		String pathInfo = req.getPathInfo(); // /a/b;c=123
		String queryString = req.getQueryString(); // d=789

		// Reconstruct original requesting URL
		StringBuilder url = new StringBuilder();
		url.append(scheme).append("://").append(serverName);

		if (serverPort > 0 && serverPort != 80 && serverPort != 443) {
			url.append(":").append(serverPort);
		}

		url.append(contextPath).append(servletPath);

		if (pathInfo != null) {
			url.append(pathInfo);
		}
		if (queryString != null) {
			url.append("?").append(queryString);
		}
		return url.toString();
	}
}

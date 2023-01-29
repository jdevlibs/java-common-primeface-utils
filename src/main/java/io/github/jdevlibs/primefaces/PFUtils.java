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

import java.util.Map;

import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;

import jakarta.faces.application.FacesMessage;
import io.github.jdevlibs.faces.FacesUtils;
import io.github.jdevlibs.faces.JSFValidators;

/**
* @author supot.jdev
* @version 1.0
*/
public final class PFUtils {
	private static final String CMD_DIALOG = "PF('%s').show();";
	private static final String PARAM_KEY = "PFD_KEY_";

	
	private PFUtils() {
	}

	/**
	 * Open Dynamic by url default width 900px
	 * @param pageUrl The popup .xhtml path
	 */
	public static void openDialog(String pageUrl) {
		openDialog(pageUrl, null, null);
	}

	/**
	 * Open Dynamic by url
	 * @param pageUrl The popup .xhtml path
	 * @param params The pass parameter value
	 */
	public static void openDialog(String pageUrl, PFDialogParameter params) {
		openDialog(pageUrl, null, params);
	}

	public static void openDialog(String pageUrl, PFDialogOption options) {
		openDialog(pageUrl, options, null);
	}

	/**
	 * Open Dynamic by url
	 * @param pageUrl The popup .xhtml path
	 * @param options Dialog option
	 * @param params The pass parameter value
	 */
	public static void openDialog(String pageUrl, PFDialogOption options, PFDialogParameter params) {
		if (JSFValidators.isEmpty(pageUrl)) {
			return;
		}

		setDialogParameter(params);

		if (JSFValidators.isNull(options)) {
			PrimeFaces.current().dialog().openDynamic(pageUrl);
		} else {
			PrimeFaces.current().dialog().openDynamic(pageUrl, options.getOptions(), null);
		}
	}
	
	public static void closeDialog() {
		closeDialog(null);
	}

	public static void closeDialog(Object obj) {
		clearDialogParameter();
		PrimeFaces.current().dialog().closeDynamic(obj);
	}

	/**
	 * Return Dialog value (If cannot cast return null)
	 * @param event Dialog select event
	 * @return null if cannot cast to object
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getDialogReturn(SelectEvent<?> event) {
		if (JSFValidators.isNull(event) || JSFValidators.isNull(event.getObject())) {
			return null;
		}

		try {
			return (T) event.getObject();
		} catch (ClassCastException ex) {
			return null;
		}
	}

	public static <T> T getParameter(String key) {
		return FacesUtils.getSessionValue(PARAM_KEY + key);
	}

	public static void showDialog(String widgetVar) {
		if (JSFValidators.isEmpty(widgetVar)) {
			return;
		}
		showDialog(widgetVar, null);
	}

	public static void showDialog(String widgetVar, String clientId) {
		if (JSFValidators.isEmpty(widgetVar)) {
			return;
		}

		if (JSFValidators.isNotEmpty(clientId)) {
			PrimeFaces.current().ajax().update(clientId);
		}

		String command = String.format(CMD_DIALOG, widgetVar);
		PrimeFaces.current().executeScript(command);
	}

	public static void showMessage(FacesMessage message) {
		if (JSFValidators.isNull(message)) {
			return;
		}

		if (message.getSeverity() == FacesMessage.SEVERITY_ERROR
				|| message.getSeverity() == FacesMessage.SEVERITY_FATAL) {
			FacesUtils.validationFailed();
		}
		PrimeFaces.current().dialog().showMessageDynamic(message);
	}

	public static void showMessageInfo(String title, String message) {
		PrimeFaces.current().dialog().showMessageDynamic(FacesUtils.createInfoMessage(title, message));
	}

	public static void showMessageWarning(String title, String message) {
		PrimeFaces.current().dialog().showMessageDynamic(FacesUtils.createWarnMessage(title, message));
	}

	public static void showMessageError(String title, String message) {
		FacesUtils.validationFailed();
		PrimeFaces.current().dialog().showMessageDynamic(FacesUtils.createErrorMessage(title, message));
	}

	public static boolean isAjaxRequest() {
		return PrimeFaces.current().isAjaxRequest();
	}

	public static void execute(String command) {
		PrimeFaces.current().executeScript(command);
	}

	public static void update(String ... clientId) {
		PrimeFaces.current().ajax().update(clientId);
	}

	public static void scrollTo(String clientId) {
		if (JSFValidators.isNotEmpty(clientId)) {
			PrimeFaces.current().scrollTo(clientId);
		}
	}

	public static void scrollToTopPage() {
		PrimeFaces.current().scrollTo("window.scrollTo(0,0);");
	}

	public static void scrollTop() {
		PrimeFaces instance = PrimeFaces.current();
		instance.executeScript("window.scrollTo(0,0);");
	}
	
	public static void resetInput(String... clientId) {
		if (JSFValidators.isEmpty(clientId)) {
			return;
		}
		PrimeFaces.current().resetInputs(clientId);
	}

	private static void setDialogParameter(PFDialogParameter params) {
		if (JSFValidators.isNull(params) || params.isEmpty()) {
			return;
		}

		for (String key : params.getKeySet()) {
			String paramKey = PARAM_KEY + key;
			FacesUtils.addSession(paramKey, params.get(key));
		}
	}

	private static void clearDialogParameter() {
		Map<String, Object> maps = FacesUtils.getSessionMap();
		if (JSFValidators.isEmpty(maps)) {
			return;
		}

		for (Map.Entry<String, Object> map : maps.entrySet()) {
			if (JSFValidators.isEmpty(map.getKey())) {
				continue;
			}

			if (map.getKey().startsWith(PARAM_KEY)) {
				FacesUtils.removeSession(map.getKey());
			}
		}
	}

}

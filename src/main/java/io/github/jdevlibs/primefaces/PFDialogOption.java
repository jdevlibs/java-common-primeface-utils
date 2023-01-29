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

import org.primefaces.model.DialogFrameworkOptions;

/**
* @author supot.jdev
* @version 1.0
*/
public class PFDialogOption implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private final DialogFrameworkOptions options;
	
	public PFDialogOption() {
			options = DialogFrameworkOptions.builder()
                .modal(true)
                .fitViewport(true)
                .responsive(true)
                .width("900px")
                .height("800px")
                .contentWidth("100%")
                .contentHeight("100%")
                .resizeObserverCenter(true)
                .resizable(false)
                .styleClass("max-w-screen")
                .iframeStyleClass("max-w-screen")
                .hideEffect("fade")
                .showEffect("fade")
                .build();
	}
	
    /**
     * Custom widgetVar of the dialog, if not declared it will be automatically created as "id+dlgWidget".
     * @param widgetVar Custom widgetVar of the dialog
     */
    public PFDialogOption widgetVar(String widgetVar) {
        options.setWidgetVar(widgetVar);
        return this;
    }
    
    /**
     * Controls modality of the dialog.
     * @param modal true/false
     */
	public PFDialogOption modal(boolean modal) {
		options.setModal(modal);
		return this;
	}
	
    /**
     * Width of the dialog content. NOTE: 'auto' cannot be used because the dialog is displayed in an IFrame.
     * @param contentWidth Width of the dialog content.
     */
	public PFDialogOption contentWidth(String contentWidth) {
		options.setContentWidth(contentWidth);
		return this;
	}
	
	
    /**
     * Height of the dialog content.
     * @param contentHeight Height of the dialog content.
     */
	public PFDialogOption contentHeight(String contentHeight) {
		options.setContentHeight(contentHeight);
		return this;
	}
	
    /**
     * When enabled, makes dialog resizable.
     * @param resizable makes dialog resizable.
     */
	public PFDialogOption resizable(boolean resizable) {
		options.setResizable(resizable);
		return this;
	}
	
    /**
     * When enabled, makes dialog draggable.
     * @param draggable makes dialog draggable.
     */
    public PFDialogOption draggable(boolean draggable) {
        options.setDraggable(draggable);
        return this;
    }
    
    /**
     * Whether the dialog can be closed or not.
     * @param closable the dialog can be closed or not.
     */
    public PFDialogOption closable(boolean closable) {
        options.setClosable(closable);
        return this;
    }
    
    /**
     * Client id of the element to display inside header.
     * @param headerElement Client id of header.
     */
    public PFDialogOption headerElement(String headerElement) {
        options.setHeaderElement(headerElement);
        return this;
    }
    
    /**
     * Makes dialog minimizable.
     * @param minimizable dialog minimizable.
     */
    public PFDialogOption minimizable(boolean minimizable) {
        options.setMinimizable(minimizable);
        return this;
    }

    public PFDialogOption maximizable(boolean maximizable) {
        options.setMaximizable(maximizable);
        return this;
    }
    
    /**
     * Whether the dialog can be closed with escape key.
     * @param closeOnEscape closed with escape key.
     */
    public PFDialogOption closeOnEscape(boolean closeOnEscape) {
        options.setCloseOnEscape(closeOnEscape);
        return this;
    }

    /**
     * Minimum width of a resizable dialog.
     * @param minWidth Minimum width
     */
    public PFDialogOption minWidth(Integer minWidth) {
        options.setMinWidth(minWidth);
        return this;
    }

    /**
     * Minimum height of a resizable dialog.
     * @param minHeight Minimum height
     */
    public PFDialogOption minHeight(Integer minHeight) {
        options.setMinHeight(minHeight);
        return this;
    }
    
    /**
     * Enables lazy loading of the content with ajax.
     * @param dynamic lazy loading of the content
     */
    public PFDialogOption dynamic(boolean dynamic) {
        options.setDynamic(dynamic);
        return this;
    }

    /**
     * Dialog size might exceed viewport if content is bigger than viewport in terms of height.
     * fitViewport option automatically adjusts height to fit dialog within the viewport.
     * @param fitViewport automatically adjusts height
     */    
	public PFDialogOption fitViewport(boolean fitViewport) {
		options.setFitViewport(fitViewport);
		return this;
	}
	
    /**
     * Can be used together with resizeObserver = true.
     * Centers the dialog again after it was resized to ensure the whole dialog is visible onscreen.
     * @param resizeObserver Centers the dialog again after it was resized
     */
	public PFDialogOption resizeObserver(boolean resizeObserver) {
		options.setResizeObserver(resizeObserver);
		return this;
	}
	
    /**
     * Width of the dialog. [default 900px]
     * @param width Width of the dialog.
     */
	public PFDialogOption width(String width) {
		options.setWidth(width);
		return this;
	}
	
    /**
     * Height of the dialog. [default 800px]
     * @param height Height of the dialog.
     */
	public PFDialogOption height(String height) {
		options.setHeight(height);
		return this;
	}
	
    /**
     * One or more CSS classes for the dialog.
     * @param styleClass CSS classes (If more xx,yy)
     */
	public PFDialogOption styleClass(String styleClass) {
		options.setStyleClass(styleClass);
		return this;
	}
	
    /**
     * One or more CSS classes for the iframe within the dialog.
     * @param iframeStyleClass CSS classes for the iframe
     */
	public PFDialogOption iframeStyleClass(String iframeStyleClass) {
		options.setIframeStyleClass(iframeStyleClass);
		return this;
	}
	
	public DialogFrameworkOptions getOptions() {
		return options;
	}
}

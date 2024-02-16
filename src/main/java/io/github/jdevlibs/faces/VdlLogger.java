package io.github.jdevlibs.faces;

import jakarta.faces.component.UIViewRoot;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewDeclarationLanguage;
import jakarta.faces.view.ViewDeclarationLanguageWrapper;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * @author supot.jdev
 * @version 1.0
 */
@Slf4j
public class VdlLogger extends ViewDeclarationLanguageWrapper {
    private final ViewDeclarationLanguage wrapped;

    public VdlLogger(ViewDeclarationLanguage wrapped) {
        super(wrapped);
        this.wrapped = wrapped;
    }

    @Override
    public UIViewRoot createView(FacesContext context, String viewId) {
        long start = System.nanoTime();
        UIViewRoot view = super.createView(context, viewId);
        long end = System.nanoTime();
        log.info("Create View[{}] : {} ms", view.getViewId(), calculateTime(start, end));
        return view;
    }

    @Override
    public void buildView(FacesContext context, UIViewRoot view) throws IOException {
        long start = System.nanoTime();
        super.buildView(context, view);
        long end = System.nanoTime();
        log.info("Build View[{}] : {} ms", view.getViewId(), calculateTime(start, end));
    }

    @Override
    public void renderView(FacesContext context, UIViewRoot view) throws IOException {
        long start = System.nanoTime();
        super.renderView(context, view);
        long end = System.nanoTime();
        log.info("Render View[{}] : {} ms", view.getViewId(), calculateTime(start, end));
    }

    @Override
    public ViewDeclarationLanguage getWrapped() {
        return wrapped;
    }

    private double calculateTime(long start , long end) {
        return (end - start) / 1e6;
    }
}

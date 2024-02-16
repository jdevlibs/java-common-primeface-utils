package io.github.jdevlibs.faces;

import jakarta.faces.view.ViewDeclarationLanguage;
import jakarta.faces.view.ViewDeclarationLanguageFactory;

/**
 * @author supot.jdev
 * @version 1.0
 */
public class VdlLoggerFactory extends ViewDeclarationLanguageFactory {
    private final ViewDeclarationLanguageFactory wrapped;

    @Deprecated
    public VdlLoggerFactory(ViewDeclarationLanguageFactory wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public ViewDeclarationLanguage getViewDeclarationLanguage(String viewId) {
        return new VdlLogger(wrapped.getViewDeclarationLanguage(viewId));
    }

    @Override
    public ViewDeclarationLanguageFactory getWrapped() {
        return wrapped;
    }
}
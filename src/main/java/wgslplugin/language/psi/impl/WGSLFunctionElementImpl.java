package wgslplugin.language.psi.impl;

import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;
import wgslplugin.language.psi.WGSLFunctionElement;

public abstract class WGSLFunctionElementImpl extends WGSLNamedElementImpl implements WGSLFunctionElement {
    public WGSLFunctionElementImpl(@NotNull ASTNode node) {
        super(node);
    }
}

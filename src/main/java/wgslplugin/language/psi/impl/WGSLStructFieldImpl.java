package wgslplugin.language.psi.impl;

import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;
import wgslplugin.language.psi.WGSLFunctionElement;

public abstract class WGSLStructFieldImpl extends WGSLNamedElementImpl implements WGSLFunctionElement {
    public WGSLStructFieldImpl(@NotNull ASTNode node) {
        super(node);
    }
}

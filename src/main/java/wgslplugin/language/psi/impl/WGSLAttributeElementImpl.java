package wgslplugin.language.psi.impl;

import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;
import wgslplugin.language.psi.WGSLFunctionElement;

public abstract class WGSLAttributeElementImpl extends WGSLNamedElementImpl implements WGSLFunctionElement {
    public WGSLAttributeElementImpl(@NotNull ASTNode node) {
        super(node);
    }

}

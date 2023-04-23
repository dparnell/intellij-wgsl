package wgslplugin.language.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import wgslplugin.language.psi.WGSLNamedElement;

public abstract class WGSLNamedElementImpl extends ASTWrapperPsiElement implements WGSLNamedElement {
    public WGSLNamedElementImpl(@NotNull ASTNode node) {
        super(node);
    }
}

package wgslplugin.language.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;
import com.intellij.psi.PsiElement;

import wgslplugin.language.psi.WGSLNamedElement;

public abstract class WGSLNamedElementImpl extends ASTWrapperPsiElement implements WGSLNamedElement {
    private String name;

    public WGSLNamedElementImpl(@NotNull ASTNode node) {
        super(node);
    }

    @Override
    public PsiElement setName(String name) {
        this.name = name;

        return this;
    }

    @Override
    public String getName() {
        return name;
    }
}

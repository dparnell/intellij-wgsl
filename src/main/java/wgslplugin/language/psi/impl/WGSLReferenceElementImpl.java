package wgslplugin.language.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import wgslplugin.language.WGSLReference;
import wgslplugin.language.psi.WGSLNamedElement;
import wgslplugin.language.psi.WGSLReferenceElement;

public abstract class WGSLReferenceElementImpl extends ASTWrapperPsiElement implements WGSLReferenceElement {

    public WGSLReferenceElementImpl(@NotNull ASTNode node) {
        super(node);
    }

    @Override
    public PsiReference getReference() {
        String myName = WGSLPsiImplUtil.getName(this);
        if(myName == null) {
            return null;
        }

        PsiElement[] names = PsiTreeUtil.collectElements(getContainingFile(), e -> e instanceof WGSLNamedElement ? myName.equals(((WGSLNamedElement) e).getName()) : false);
        if(names.length == 0) {
            return null;
        }

        return new WGSLReference(this);
    }

}

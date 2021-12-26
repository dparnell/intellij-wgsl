package wgslplugin.language.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiReference;
import org.jetbrains.annotations.NotNull;
import wgslplugin.language.WGSLReference;
import wgslplugin.language.BuiltInFunctions;
import wgslplugin.language.psi.WGSLFunctionCallElement;
import wgslplugin.language.psi.WGSLFunctionDecl;

public class WGSLFunctionCallElementImpl extends WGSLReferenceElementImpl implements WGSLFunctionCallElement {
    public WGSLFunctionCallElementImpl(@NotNull ASTNode node) {
        super(node);
    }

    @Override
    public PsiReference getReference() {
        WGSLFunctionDecl builtin = BuiltInFunctions.INSTANCE.get(this);
        if(builtin == null) {
            return super.getReference();
        }

        return new WGSLReference(this, builtin);
    }
}

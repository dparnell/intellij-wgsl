package wgslplugin.language.psi;

import com.intellij.psi.PsiNameIdentifierOwner;

public interface WGSLNamedElement extends PsiNameIdentifierOwner {
    String getName();
}

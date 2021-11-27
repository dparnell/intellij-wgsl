package wgslplugin.language.psi;

import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import wgslplugin.language.WGSLLanguage;

public class WGSLElementType extends IElementType {
    public WGSLElementType(@NonNls @NotNull String debugName) {
        super(debugName, WGSLLanguage.INSTANCE);
    }
}

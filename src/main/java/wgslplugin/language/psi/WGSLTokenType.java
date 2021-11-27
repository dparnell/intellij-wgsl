package wgslplugin.language.psi;

import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import wgslplugin.language.WGSLLanguage;

public class WGSLTokenType  extends IElementType {
    public WGSLTokenType(@NotNull @NonNls String debugName) {
        super(debugName, WGSLLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "WGSLTokenType." + super.toString();
    }
}

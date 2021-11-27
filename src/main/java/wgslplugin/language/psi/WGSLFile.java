package wgslplugin.language.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;
import wgslplugin.language.WGSLFileType;
import wgslplugin.language.WGSLLanguage;

public class WGSLFile extends PsiFileBase {

    public WGSLFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, WGSLLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return WGSLFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "WGSL File";
    }
}

package wgslplugin.language;

import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.openapi.util.NlsContexts;
import com.intellij.openapi.util.NlsSafe;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class WGSLFileType extends LanguageFileType {

    public static final WGSLFileType INSTANCE = new WGSLFileType();

    protected WGSLFileType() {
        super(WGSLLanguage.INSTANCE);
    }

    @Override
    public @NonNls @NotNull String getName() {
        return "WGSL File";
    }

    @Override
    public @NlsContexts.Label @NotNull String getDescription() {
        return "WGSL Shader File";
    }

    @Override
    public @NlsSafe @NotNull String getDefaultExtension() {
        return "wgsl";
    }

    @Override
    public @Nullable Icon getIcon() {
        return WGSLIcons.FILE;
    }
}

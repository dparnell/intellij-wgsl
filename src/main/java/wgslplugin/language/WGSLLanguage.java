package wgslplugin.language;

import com.intellij.lang.Language;

public class WGSLLanguage extends Language {
    public static final WGSLLanguage INSTANCE = new WGSLLanguage();

    private WGSLLanguage() {
        super("WGSL", "text/wgsl", "application/wgsl");
    }

}
package wgslplugin.language;

import com.intellij.lexer.FlexAdapter;

public class WGSLLexerAdapter extends FlexAdapter {
    public WGSLLexerAdapter() {
        super(new _WgslLexer(null));
    }
}

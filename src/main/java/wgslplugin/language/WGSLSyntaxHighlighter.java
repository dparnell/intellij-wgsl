package wgslplugin.language;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
import wgslplugin.language.psi.WGSLTypes;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;


public class WGSLSyntaxHighlighter  extends SyntaxHighlighterBase {

    public static final TextAttributesKey COMMENT =
            createTextAttributesKey("WGSL_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey BAD_CHARACTER =
            createTextAttributesKey("WGSL_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);
    public static final TextAttributesKey NUMBER =
            createTextAttributesKey("WGSL_NUMBER", DefaultLanguageHighlighterColors.NUMBER);
    public static final TextAttributesKey IDENT =
            createTextAttributesKey("WGSL_IDENTIFIER", DefaultLanguageHighlighterColors.IDENTIFIER);


    private static final TextAttributesKey[] NUMBER_KEYS = new TextAttributesKey[]{NUMBER};
    private static final TextAttributesKey[] IDENTIFIER_KEYS = new TextAttributesKey[]{IDENT};
    private static final TextAttributesKey[] BAD_CHAR_KEYS = new TextAttributesKey[]{BAD_CHARACTER};
    private static final TextAttributesKey[] COMMENT_KEYS = new TextAttributesKey[]{COMMENT};
    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new WGSLLexerAdapter();
    }

    @Override
    public TextAttributesKey @NotNull [] getTokenHighlights(IElementType tokenType) {
        if (tokenType.equals(WGSLTypes.INT_LITERAL) || tokenType.equals(WGSLTypes.UINT_LITERAL) || tokenType.equals(WGSLTypes.DECIMAL_FLOAT_LITERAL) || tokenType.equals(WGSLTypes.HEX_FLOAT_LITERAL)) {
            return NUMBER_KEYS;
        }
        if(tokenType.equals(WGSLTypes.IDENT)) {
            return IDENTIFIER_KEYS;
        }
        if (tokenType.equals(WGSLTypes.LINE_COMMENT) || tokenType.equals(WGSLTypes.BLOCK_COMMENT)) {
            return COMMENT_KEYS;
        }
        if (tokenType.equals(TokenType.BAD_CHARACTER)) {
            return BAD_CHAR_KEYS;
        }
        return EMPTY_KEYS;
    }
}

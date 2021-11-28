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
    public static final TextAttributesKey KEYWORD =
            createTextAttributesKey("WGSL_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey TYPE =
            createTextAttributesKey("WGSL_TYPE", DefaultLanguageHighlighterColors.KEYWORD);

    private static final TextAttributesKey[] NUMBER_KEYS = new TextAttributesKey[]{NUMBER};
    private static final TextAttributesKey[] IDENTIFIER_KEYS = new TextAttributesKey[]{IDENT};
    private static final TextAttributesKey[] KEYWORD_KEYS = new TextAttributesKey[]{KEYWORD};
    private static final TextAttributesKey[] TYPE_KEYS = new TextAttributesKey[]{TYPE};
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
        if(tokenType.equals(WGSLTypes.ARRAY) || tokenType.equals(WGSLTypes.ATOMIC) || tokenType.equals(WGSLTypes.BOOL) || tokenType.equals(WGSLTypes.FLOAT32)
                || tokenType.equals(WGSLTypes.INT32) || tokenType.equals(WGSLTypes.MAT2X2) || tokenType.equals(WGSLTypes.MAT2X3) || tokenType.equals(WGSLTypes.MAT2X4)
                || tokenType.equals(WGSLTypes.MAT3X2) || tokenType.equals(WGSLTypes.MAT3X3) || tokenType.equals(WGSLTypes.MAT3X4) || tokenType.equals(WGSLTypes.MAT4X2)
                || tokenType.equals(WGSLTypes.MAT4X3) || tokenType.equals(WGSLTypes.MAT4X4) || tokenType.equals(WGSLTypes.POINTER) || tokenType.equals(WGSLTypes.SAMPLER)
                || tokenType.equals(WGSLTypes.SAMPLER_COMPARISON) || tokenType.equals(WGSLTypes.STRUCT) || tokenType.equals(WGSLTypes.TEXTURE_1D) || tokenType.equals(WGSLTypes.TEXTURE_2D)
                || tokenType.equals(WGSLTypes.TEXTURE_3D) || tokenType.equals(WGSLTypes.TEXTURE_CUBE) || tokenType.equals(WGSLTypes.TEXTURE_CUBE_ARRAY) || tokenType.equals(WGSLTypes.TEXTURE_MULTISAMPLED_2D)
                || tokenType.equals(WGSLTypes.TEXTURE_STORAGE_1D) || tokenType.equals(WGSLTypes.TEXTURE_STORAGE_2D) || tokenType.equals(WGSLTypes.TEXTURE_STORAGE_2D_ARRAY)
                || tokenType.equals(WGSLTypes.TEXTURE_STORAGE_3D) || tokenType.equals(WGSLTypes.TEXTURE_DEPTH_2D) || tokenType.equals(WGSLTypes.TEXTURE_DEPTH_CUBE)
                || tokenType.equals(WGSLTypes.TEXTURE_DEPTH_CUBE_ARRAY) || tokenType.equals(WGSLTypes.TEXTURE_DEPTH_MULTISAMPLED_2D)
                || tokenType.equals(WGSLTypes.UINT32) || tokenType.equals(WGSLTypes.VEC2) || tokenType.equals(WGSLTypes.VEC3) || tokenType.equals(WGSLTypes.VEC4)) {
            return TYPE_KEYS;
        }
        if(tokenType.equals(WGSLTypes.BITCAST) || tokenType.equals(WGSLTypes.BLOCK) || tokenType.equals(WGSLTypes.BREAK)
                || tokenType.equals(WGSLTypes.CASE) || tokenType.equals(WGSLTypes.CONTINUE) || tokenType.equals(WGSLTypes.CONTINUING)
                || tokenType.equals(WGSLTypes.DEFAULT) || tokenType.equals(WGSLTypes.DISCARD) || tokenType.equals(WGSLTypes.ELSE)
                || tokenType.equals(WGSLTypes.ENABLE) || tokenType.equals(WGSLTypes.FALLTHROUGH) || tokenType.equals(WGSLTypes.FALSE)
                || tokenType.equals(WGSLTypes.FN) || tokenType.equals(WGSLTypes.FOR) || tokenType.equals(WGSLTypes.FUNCTION)
                || tokenType.equals(WGSLTypes.IF) || tokenType.equals(WGSLTypes.LET) || tokenType.equals(WGSLTypes.LOOP)
                || tokenType.equals(WGSLTypes.READ) || tokenType.equals(WGSLTypes.READ_WRITE) || tokenType.equals(WGSLTypes.RETURN)
                || tokenType.equals(WGSLTypes.STORAGE) || tokenType.equals(WGSLTypes.SWITCH) || tokenType.equals(WGSLTypes.TRUE)
                || tokenType.equals(WGSLTypes.TYPE) || tokenType.equals(WGSLTypes.UNIFORM) || tokenType.equals(WGSLTypes.VAR)
                || tokenType.equals(WGSLTypes.WORKGROUP) || tokenType.equals(WGSLTypes.WRITE)) {
            return KEYWORD_KEYS;
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

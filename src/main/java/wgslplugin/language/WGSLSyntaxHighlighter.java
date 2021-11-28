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

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

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
    public static final TextAttributesKey STORAGE =
            createTextAttributesKey("WGSL_STORAGE", DefaultLanguageHighlighterColors.IDENTIFIER);
    public static final TextAttributesKey KEYWORD =
            createTextAttributesKey("WGSL_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey TYPE =
            createTextAttributesKey("WGSL_TYPE", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey PAREN =
            createTextAttributesKey("WGSL_PAREN", DefaultLanguageHighlighterColors.PARENTHESES);
    public static final TextAttributesKey BRACE =
            createTextAttributesKey("WGSL_BRACE", DefaultLanguageHighlighterColors.BRACES);
    public static final TextAttributesKey BRACKET =
            createTextAttributesKey("WGSL_BRACKET", DefaultLanguageHighlighterColors.BRACKETS);


    private static final TextAttributesKey[] NUMBER_KEYS = new TextAttributesKey[]{NUMBER};
    private static final TextAttributesKey[] IDENTIFIER_KEYS = new TextAttributesKey[]{IDENT};
    private static final TextAttributesKey[] KEYWORD_KEYS = new TextAttributesKey[]{KEYWORD};
    private static final TextAttributesKey[] TYPE_KEYS = new TextAttributesKey[]{TYPE};
    private static final TextAttributesKey[] STORAGE_KEYS = new TextAttributesKey[]{STORAGE};
    private static final TextAttributesKey[] BAD_CHAR_KEYS = new TextAttributesKey[]{BAD_CHARACTER};
    private static final TextAttributesKey[] COMMENT_KEYS = new TextAttributesKey[]{COMMENT};
    private static final TextAttributesKey[] PAREN_KEYS = new TextAttributesKey[]{PAREN};
    private static final TextAttributesKey[] BRACE_KEYS = new TextAttributesKey[]{BRACE};
    private static final TextAttributesKey[] BRACKET_KEYS = new TextAttributesKey[]{BRACKET};
    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

    private static final Set<IElementType> NUMBER_TOKENS = tokens(
              WGSLTypes.INT_LITERAL, WGSLTypes.UINT_LITERAL, WGSLTypes.DECIMAL_FLOAT_LITERAL
            , WGSLTypes.HEX_FLOAT_LITERAL
    );

    private static final Set<IElementType> CORE_TYPE_TOKENS = tokens(
              WGSLTypes.ARRAY , WGSLTypes.ATOMIC , WGSLTypes.BOOL , WGSLTypes.FLOAT32
            , WGSLTypes.INT32 , WGSLTypes.MAT2X2 , WGSLTypes.MAT2X3 , WGSLTypes.MAT2X4
            , WGSLTypes.MAT3X2 , WGSLTypes.MAT3X3 , WGSLTypes.MAT3X4 , WGSLTypes.MAT4X2
            , WGSLTypes.MAT4X3 , WGSLTypes.MAT4X4 , WGSLTypes.POINTER , WGSLTypes.SAMPLER
            , WGSLTypes.SAMPLER_COMPARISON , WGSLTypes.STRUCT , WGSLTypes.TEXTURE_1D , WGSLTypes.TEXTURE_2D
            , WGSLTypes.TEXTURE_3D , WGSLTypes.TEXTURE_CUBE , WGSLTypes.TEXTURE_CUBE_ARRAY , WGSLTypes.TEXTURE_MULTISAMPLED_2D
            , WGSLTypes.TEXTURE_STORAGE_1D , WGSLTypes.TEXTURE_STORAGE_2D , WGSLTypes.TEXTURE_STORAGE_2D_ARRAY
            , WGSLTypes.TEXTURE_STORAGE_3D , WGSLTypes.TEXTURE_DEPTH_2D , WGSLTypes.TEXTURE_DEPTH_CUBE
            , WGSLTypes.TEXTURE_DEPTH_CUBE_ARRAY , WGSLTypes.TEXTURE_DEPTH_MULTISAMPLED_2D
            , WGSLTypes.UINT32 , WGSLTypes.VEC2 , WGSLTypes.VEC3 , WGSLTypes.VEC4
    );

    private static final Set<IElementType> KEYWORD_TOKENS = tokens(
              WGSLTypes.BITCAST , WGSLTypes.BREAK
            , WGSLTypes.CASE , WGSLTypes.CONTINUE , WGSLTypes.CONTINUING
            , WGSLTypes.DEFAULT , WGSLTypes.DISCARD , WGSLTypes.ELSE
            , WGSLTypes.ENABLE , WGSLTypes.FALLTHROUGH , WGSLTypes.FALSE
            , WGSLTypes.FN , WGSLTypes.FOR
            , WGSLTypes.IF , WGSLTypes.LET , WGSLTypes.LOOP
            , WGSLTypes.READ , WGSLTypes.READ_WRITE , WGSLTypes.RETURN
            , WGSLTypes.SWITCH , WGSLTypes.TRUE
            , WGSLTypes.TYPE , WGSLTypes.VAR
            , WGSLTypes.WRITE
    );

    private static final Set<IElementType> STORAGE_TOKENS = tokens(
            WGSLTypes.STORAGE, WGSLTypes.UNIFORM, WGSLTypes.WORKGROUP, WGSLTypes.FUNCTION, WGSLTypes.PRIVATE,WGSLTypes.PUSH_CONSTANT
    );

    private static final Set<String> TYPE_NAMES = names("");

    private static Set<IElementType> tokens(IElementType ... types) {
        return Arrays.stream(types).collect(Collectors.toSet());
    }

    private static Set<String> names(String ... names) {
        return Arrays.stream(names).collect(Collectors.toSet());
    }

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new WGSLLexerAdapter();
    }

    @Override
    public TextAttributesKey @NotNull [] getTokenHighlights(IElementType tokenType) {
        if (NUMBER_TOKENS.contains(tokenType)) {
            return NUMBER_KEYS;
        }

        if(tokenType.equals(WGSLTypes.IDENT)) {
            return IDENTIFIER_KEYS;
        }

        if(CORE_TYPE_TOKENS.contains(tokenType)) {
            return TYPE_KEYS;
        }

        if(KEYWORD_TOKENS.contains(tokenType)) {
            return KEYWORD_KEYS;
        }

        if(STORAGE_TOKENS.contains(tokenType)) {
            return STORAGE_KEYS;
        }

        if (tokenType.equals(WGSLTypes.LINE_COMMENT) || tokenType.equals(WGSLTypes.BLOCK_COMMENT)) {
            return COMMENT_KEYS;
        }

        if (tokenType.equals(TokenType.BAD_CHARACTER)) {
            return BAD_CHAR_KEYS;
        }

        if (tokenType.equals(WGSLTypes.PAREN_LEFT) || tokenType.equals(WGSLTypes.PAREN_RIGHT)) {
            return PAREN_KEYS;
        }
        if (tokenType.equals(WGSLTypes.BRACE_LEFT) || tokenType.equals(WGSLTypes.BRACE_RIGHT)) {
            return BRACE_KEYS;
        }
        if (tokenType.equals(WGSLTypes.BRACKET_LEFT) || tokenType.equals(WGSLTypes.BRACKET_RIGHT) || tokenType.equals(WGSLTypes.ATTR_LEFT) || tokenType.equals(WGSLTypes.ATTR_RIGHT)) {
            return BRACKET_KEYS;
        }
        return EMPTY_KEYS;
    }
}

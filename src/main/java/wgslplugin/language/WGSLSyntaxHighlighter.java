package wgslplugin.language;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
import wgslplugin.language.psi.WGSLTypes;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class WGSLSyntaxHighlighter  extends SyntaxHighlighterBase {

    private static final TextAttributesKey[] NUMBER_KEYS = new TextAttributesKey[]{WGSLColours.NUMBER.attributes()};
    private static final TextAttributesKey[] IDENTIFIER_KEYS = new TextAttributesKey[]{WGSLColours.IDENTIFIER.attributes()};
    private static final TextAttributesKey[] KEYWORD_KEYS = new TextAttributesKey[]{WGSLColours.KEYWORD.attributes()};
    private static final TextAttributesKey[] TYPE_KEYS = new TextAttributesKey[]{WGSLColours.BUILTIN_TYPE.attributes()};
    private static final TextAttributesKey[] STORAGE_KEYS = new TextAttributesKey[]{WGSLColours.STORAGE.attributes()};
    private static final TextAttributesKey[] BAD_CHAR_KEYS = new TextAttributesKey[]{WGSLColours.BAD_CHARACTER.attributes()};
    private static final TextAttributesKey[] LINE_COMMENT_KEYS = new TextAttributesKey[]{WGSLColours.LINE_COMMENT.attributes()};
    private static final TextAttributesKey[] BLOCK_COMMENT_KEYS = new TextAttributesKey[]{WGSLColours.BLOCK_COMMENT.attributes()};
    private static final TextAttributesKey[] DOC_COMMENT_KEYS = new TextAttributesKey[]{WGSLColours.DOC_COMMENT.attributes()};
    private static final TextAttributesKey[] PAREN_KEYS = new TextAttributesKey[]{WGSLColours.PARENTHESIS.attributes()};
    private static final TextAttributesKey[] BRACE_KEYS = new TextAttributesKey[]{WGSLColours.BRACES.attributes()};
    private static final TextAttributesKey[] BRACKET_KEYS = new TextAttributesKey[]{WGSLColours.BRACKETS.attributes()};
    private static final TextAttributesKey[] ATTRIBUTE_KEYS = new TextAttributesKey[]{WGSLColours.ATTRIBUTE.attributes()};
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
            , WGSLTypes.SAMPLER_COMPARISON , WGSLTypes.TEXTURE_1D , WGSLTypes.TEXTURE_2D
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
            , WGSLTypes.RETURN
            , WGSLTypes.STRUCT , WGSLTypes.SWITCH , WGSLTypes.TRUE
            , WGSLTypes.TYPE , WGSLTypes.VAR
    );

    private static final Set<IElementType> STORAGE_TOKENS = tokens(
            WGSLTypes.STORAGE, WGSLTypes.UNIFORM, WGSLTypes.WORKGROUP, WGSLTypes.FUNCTION, WGSLTypes.PRIVATE,WGSLTypes.PUSH_CONSTANT
    );

    private static Set<IElementType> tokens(IElementType ... types) {
        return Arrays.stream(types).collect(Collectors.toSet());
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

        if (tokenType.equals(WGSLTypes.LINE_COMMENT)) {
            return LINE_COMMENT_KEYS;
        }

        if (tokenType.equals(WGSLTypes.BLOCK_COMMENT)) {
            return BLOCK_COMMENT_KEYS;
        }

        if(tokenType.equals(WGSLTypes.DOC_COMMENT)) {
            return DOC_COMMENT_KEYS;
        }

        if (tokenType.equals(WGSLTypes.PAREN_LEFT) || tokenType.equals(WGSLTypes.PAREN_RIGHT)) {
            return PAREN_KEYS;
        }

        if (tokenType.equals(WGSLTypes.BRACE_LEFT) || tokenType.equals(WGSLTypes.BRACE_RIGHT)) {
            return BRACE_KEYS;
        }

        if (tokenType.equals(WGSLTypes.BRACKET_LEFT) || tokenType.equals(WGSLTypes.BRACKET_RIGHT)) {
            return BRACKET_KEYS;
        }

        if (tokenType.equals(TokenType.BAD_CHARACTER)) {
            return BAD_CHAR_KEYS;
        }

        if(tokenType.equals(WGSLTypes.AT) || tokenType.equals(WGSLTypes.ATTR_LEFT) || tokenType.equals(WGSLTypes.ATTR_RIGHT) || tokenType.equals(WGSLTypes.ATTRIBUTE_NAME)) {
            return ATTRIBUTE_KEYS;
        }

        return EMPTY_KEYS;
    }
}

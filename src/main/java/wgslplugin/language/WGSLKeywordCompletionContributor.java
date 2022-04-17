package wgslplugin.language;

import static com.intellij.codeInsight.completion.AddSpaceInsertHandler.INSTANCE_WITH_AUTO_POPUP;

import com.intellij.codeInsight.completion.CompletionContributor;
import com.intellij.codeInsight.completion.CompletionParameters;
import com.intellij.codeInsight.completion.CompletionResultSet;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.psi.PsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;

public class WGSLKeywordCompletionContributor extends CompletionContributor {
    private final Set<LookupElement> KEYWORDS = Set.of(
            // https://www.w3.org/TR/WGSL/#type-defining-keywords
            createKeywordWithSpace("array"),
            createKeyword("atomic"),
            createKeyword("bool"),
            createKeyword("float32"),
            createKeyword("float16"),
            createKeyword("int32"),
            createKeyword("mat2x2"),
            createKeyword("mat2x3"),
            createKeyword("mat2x4"),
            createKeyword("mat3x2"),
            createKeyword("mat3x3"),
            createKeyword("mat3x4"),
            createKeyword("mat4x2"),
            createKeyword("mat4x3"),
            createKeyword("mat4x4"),
            createKeywordWithSpace("override"),
            createKeywordWithSpace("pointer"),
            createKeyword("sampler"),
            createKeywordWithSpace("sampler_comparison"),
            createKeywordWithSpace("struct"),
            createKeyword("texture_1d"),
            createKeyword("texture_2d"),
            createKeyword("texture_2d_array"),
            createKeyword("texture_3d"),
            createKeyword("texture_cube"),
            createKeyword("texture_cube_array"),
            createKeyword("texture_multisampled_2d"),
            createKeyword("texture_storage_1d"),
            createKeyword("texture_storage_2d"),
            createKeyword("texture_storage_2d_array"),
            createKeyword("texture_storage_3d"),
            createKeyword("texture_depth_2d"),
            createKeyword("texture_depth_2d_array"),
            createKeyword("texture_depth_cube"),
            createKeyword("texture_depth_cube_array"),
            createKeyword("texture_depth_multisampled_2d"),
            createKeyword("uint32"),
            createKeyword("vec2"),
            createKeyword("vec3"),
            createKeyword("vec4"),

            // https://www.w3.org/TR/WGSL/#other-keywords
            createKeywordWithSpace("bitcast"),
            createKeyword("break"),
            createKeywordWithSpace("case"),
            createKeywordWithSpace("const"),
            createKeyword("continue"),
            createKeywordWithSpace("continuing"),
            createKeywordWithSpace("default"),
            createKeywordWithSpace("discard"),
            createKeywordWithSpace("else"),
            createKeywordWithSpace("enable"),
            createKeywordWithSpace("fallthrough"),
            createKeyword("false"),
            createKeywordWithSpace("fn"),
            createKeywordWithSpace("for"),
            createKeywordWithSpace("function"),
            createKeywordWithSpace("if"),
            createKeywordWithSpace("let"),
            createKeywordWithSpace("loop"),
            createKeyword("private"),
            createKeywordWithSpace("return"),
            createKeywordWithSpace("switch"),
            createKeyword("true"),
            createKeywordWithSpace("type"),
            createKeyword("uniform"),
            createKeywordWithSpace("var"),
            createKeywordWithSpace("while"),
            createKeyword("workgroup")
    );


    @Override
    public void fillCompletionVariants(@NotNull CompletionParameters parameters, @NotNull CompletionResultSet result) {
        var keywords = getKeywords(parameters.getPosition());
        result.addAllElements(keywords);
    }

    private Set<LookupElement> getKeywords(PsiElement element) {
        var prev = PsiTreeUtil.prevLeaf(element);
        if (prev == null) {
            return new HashSet<>();
        }
        // This way we can check and return a different set of keywords for completion.
        /*if (prev instanceof PsiWhiteSpace && prev.getText().contains("\n")) {
            return KEYWORDS;
        }*/
        return KEYWORDS;
    }

    private LookupElement createKeyword(String keyword) {
        return LookupElementBuilder.create(keyword).bold();
    }

    private LookupElement createKeywordWithSpace(String keyword) {
        return LookupElementBuilder.create(keyword).withInsertHandler(INSTANCE_WITH_AUTO_POPUP).bold();
    }

}

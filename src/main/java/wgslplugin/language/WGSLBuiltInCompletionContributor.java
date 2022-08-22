package wgslplugin.language;

import static com.intellij.codeInsight.completion.util.ParenthesesInsertHandler.WITH_PARAMETERS;

import com.intellij.codeInsight.completion.CompletionContributor;
import com.intellij.codeInsight.completion.CompletionParameters;
import com.intellij.codeInsight.completion.CompletionResultSet;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.icons.AllIcons;
import com.intellij.psi.PsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.ui.LayeredIcon;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WGSLBuiltInCompletionContributor extends CompletionContributor {

    public WGSLBuiltInCompletionContributor() {
        super();
    }


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

        BuiltInFunctions.INSTANCE.get(element);
        return BuiltInFunctions.INSTANCE.functions.values().stream()
                .map(x -> {
                    var name = x.getFunctionHeader().getFunctionName().getName();
                    var params = x.getFunctionHeader().getParamList().getParamList().stream().map(y ->
                            y.getVariableIdentDecl().getName() + ": " + y.getVariableIdentDecl().getTypeDecl().getText()
                    ).collect(Collectors.toList());
                    return createStaticMethod(name, params);

                }).collect(Collectors.toSet());
    }

    private LookupElement createStaticMethod(String name, List<String> arguments) {
        // System.out.println("Static: " + name);
        return LookupElementBuilder.create(name)
                .withIcon(new LayeredIcon(AllIcons.Nodes.Method, AllIcons.Nodes.StaticMark))
                .withTailText("(" + String.join(", ", arguments) + ")")
                .withInsertHandler(WITH_PARAMETERS);
    }

}

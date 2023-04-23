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
import wgslplugin.language.psi.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

        Predicate<? super WGSLFunctionDecl> funcFilter = (x) ->
                x.getFunctionHeader().getFunctionName().getName() != null && x.getFunctionHeader().getParamList() != null;

        Predicate<? super WGSLGlobalConstantDecl> constFilter = (x) ->
                x.getVariableIdentDecl().getName() != null && x.getVariableIdentDecl().getTypeDecl() != null;

        Predicate<? super WGSLGlobalVariableDecl> variableFilter = (x) ->
                x.getVariableDecl().getVariableIdentDecl().getName() != null && x.getVariableDecl().getVariableIdentDecl().getTypeDecl() != null;

        Predicate<? super WGSLStructDecl> structFilter = (x) ->
                x.getNode().findChildByType(WGSLTypes.IDENT) != null;

        Function<WGSLFunctionDecl, LookupElement> staticFuncMapper = (x) -> {
            var name = x.getFunctionHeader().getFunctionName().getName();
            var params = x.getFunctionHeader().getParamList().getParamList().stream()
                    .filter(y -> y.getVariableIdentDecl().getTypeDecl() != null)
                    .map(y -> y.getVariableIdentDecl().getName() + ": " + y.getVariableIdentDecl().getTypeDecl().getText()
                    ).collect(Collectors.toList());
            return createStaticMethod(name, params);
        };

        Function<WGSLFunctionDecl, LookupElement> regularFuncMapper = (x) -> {
            var name = x.getFunctionHeader().getFunctionName().getName();
            var params = x.getFunctionHeader().getParamList().getParamList().stream()
                    .filter(y -> y.getVariableIdentDecl().getTypeDecl() != null)
                    .map(y -> y.getVariableIdentDecl().getName() + ": " + y.getVariableIdentDecl().getTypeDecl().getText()
                    ).collect(Collectors.toList());
            return createRegularMethod(name, params);
        };

        Function<WGSLGlobalConstantDecl, LookupElement> globalConstMapper = (x) -> {
            var name = x.getVariableIdentDecl().getName();
            var type = x.getVariableIdentDecl().getTypeDecl().getText();
            return createGlobalConstant(name, type);
        };

        Function<WGSLGlobalVariableDecl, LookupElement> globalVariableMapper = (x) -> {
            var name = x.getVariableDecl().getVariableIdentDecl().getName();
            var type = x.getVariableDecl().getVariableIdentDecl().getTypeDecl().getText();
            return createGlobalVariable(name, type);
        };

        Function<WGSLStructDecl, LookupElement> structMapper = (x) -> {
            var name = x.getNode().findChildByType(WGSLTypes.IDENT).getText();
            return createStruct(name);
        };

        BuiltInFunctions.INSTANCE.get(element);
        WGSLCustomImportsFetcher.INSTANCE.get(element);

        return Stream.of(
                BuiltInFunctions.INSTANCE.functions.values().stream()
                        .filter(funcFilter)
                        .map(staticFuncMapper).collect(Collectors.toSet())
                        .stream()
                , WGSLCustomImportsFetcher.INSTANCE.functions.values().stream()
                        .filter(funcFilter)
                        .map(regularFuncMapper).collect(Collectors.toSet())
                        .stream()
                , WGSLCustomImportsFetcher.INSTANCE.constants.values().stream()
                        .filter(constFilter)
                        .map(globalConstMapper).collect(Collectors.toSet())
                        .stream()
                , WGSLCustomImportsFetcher.INSTANCE.variables.values().stream()
                        .filter(variableFilter)
                        .map(globalVariableMapper).collect(Collectors.toSet())
                        .stream()
                , WGSLCustomImportsFetcher.INSTANCE.structs.values().stream()
                        .filter(structFilter)
                        .map(structMapper).collect(Collectors.toSet())
                        .stream()
        ).flatMap(i -> i).collect(Collectors.toSet());
    }

    private LookupElement createStaticMethod(String name, List<String> arguments) {
        return LookupElementBuilder.create(name)
                .withIcon(new LayeredIcon(AllIcons.Nodes.Method, AllIcons.Nodes.StaticMark))
                .withTailText("(" + String.join(", ", arguments) + ")")
                .withInsertHandler(WITH_PARAMETERS);
    }

    private LookupElement createRegularMethod(String name, List<String> arguments) {
        return LookupElementBuilder.create(name)
                .withIcon(new LayeredIcon(AllIcons.Nodes.Method))
                .withTailText("(" + String.join(", ", arguments) + ")")
                .withInsertHandler(WITH_PARAMETERS);
    }

    private LookupElement createGlobalConstant(String name, String type) {
        return LookupElementBuilder.create(name)
                .withIcon(new LayeredIcon(AllIcons.Nodes.Constant))
                .withTailText(":" + type);
    }

    private LookupElement createGlobalVariable(String name, String type) {
        return LookupElementBuilder.create(name)
                .withIcon(new LayeredIcon(AllIcons.Nodes.Variable))
                .withTailText(":" + type);
    }

    private LookupElement createStruct(String name) {
        return LookupElementBuilder.create(name)
                .withIcon(new LayeredIcon(AllIcons.Nodes.Class, AllIcons.Nodes.StaticMark));
    }

}

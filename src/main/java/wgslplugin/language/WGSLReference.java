package wgslplugin.language;

import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wgslplugin.language.psi.WGSLVariableIdentDecl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class WGSLReference extends PsiReferenceBase<PsiElement> implements PsiPolyVariantReference {
    private final String key;

    public WGSLReference(@NotNull PsiElement element, TextRange textRange) {
        super(element, textRange);
        key = element.getText().substring(textRange.getStartOffset(), textRange.getEndOffset());
    }

    @Override
    public ResolveResult @NotNull [] multiResolve(boolean incompleteCode) {
        PsiFile file = myElement.getContainingFile();
        List<ResolveResult> results = new ArrayList<>();
        if(file != null) {
            @NotNull Collection<WGSLVariableIdentDecl> variables = PsiTreeUtil.findChildrenOfType(file, WGSLVariableIdentDecl.class);
            results.addAll(variables.stream().map(v -> new PsiElementResolveResult(v)).collect(Collectors.toList()));
        }

        return results.toArray(new ResolveResult[results.size()]);
    }

    @Nullable
    @Override
    public PsiElement resolve() {
        ResolveResult[] resolveResults = multiResolve(false);
        return resolveResults.length == 1 ? resolveResults[0].getElement() : null;
    }

    @Override
    public Object @NotNull [] getVariants() {
        List<LookupElement> variants = new ArrayList<>();
        PsiFile file = myElement.getContainingFile();
        if(file != null) {
            @NotNull Collection<WGSLVariableIdentDecl> variables = PsiTreeUtil.findChildrenOfType(file, WGSLVariableIdentDecl.class);
            for(WGSLVariableIdentDecl variable : variables) {
                String n = variable.getName();
                if(n != null && !n.isEmpty()) {
                    variants.add(LookupElementBuilder.create(variable).withIcon(WGSLIcons.FILE).withTypeText(file.getName()));
                }
            }
        }

        return variants.toArray();
    }
}

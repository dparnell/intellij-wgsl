package wgslplugin.language;

import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wgslplugin.language.psi.WGSLNamedElement;
import wgslplugin.language.psi.impl.WGSLPsiImplUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class WGSLReference extends PsiReferenceBase<PsiElement> implements PsiPolyVariantReference {
    private final PsiElement resolvesTo;

    public WGSLReference(@NotNull PsiElement element) {
        super(element, new TextRange(0, element.getTextLength()));
        resolvesTo = null;
    }
    public WGSLReference(@NotNull PsiElement element, PsiElement resolvesTo) {
        super(element, new TextRange(0, element.getTextLength()));
        this.resolvesTo = resolvesTo;
    }

    @Override
    public ResolveResult @NotNull [] multiResolve(boolean incompleteCode) {
        if(resolvesTo == null) {
            PsiFile file = myElement.getContainingFile();
            List<ResolveResult> results = new ArrayList<>();
            if (file != null) {
                String name = getValue();
                PsiElement[] names = PsiTreeUtil.collectElements(file, e -> e instanceof WGSLNamedElement ? name.equals(((WGSLNamedElement) e).getName()) : false);

                results.addAll(Arrays.stream(names).map(v -> new PsiElementResolveResult(v)).collect(Collectors.toList()));
            }

            return results.toArray(new ResolveResult[results.size()]);
        }

        return new ResolveResult[] { new PsiElementResolveResult(resolvesTo)};
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
            @NotNull Collection<WGSLNamedElement> variables = PsiTreeUtil.findChildrenOfType(file, WGSLNamedElement.class);
            for(WGSLNamedElement variable : variables) {
                String n = variable.getName();
                if(n != null && !n.isEmpty()) {
                    variants.add(LookupElementBuilder.create(variable).withIcon(WGSLIcons.FILE).withTypeText(file.getName()));
                }
            }
        }

        return variants.toArray();
    }

    @Override
    public PsiElement handleElementRename(@NotNull String newElementName) throws IncorrectOperationException {
        return WGSLPsiImplUtil.setName(myElement, newElementName);
    }
}

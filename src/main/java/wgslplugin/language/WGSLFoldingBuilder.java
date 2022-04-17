package wgslplugin.language;

import static wgslplugin.language.psi.WGSLTypes.BLOCK_COMMENT;

import com.intellij.lang.ASTNode;
import com.intellij.lang.folding.CustomFoldingBuilder;
import com.intellij.lang.folding.FoldingDescriptor;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.progress.ProgressManager;
import com.intellij.openapi.project.DumbAware;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiComment;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiRecursiveVisitor;
import org.jetbrains.annotations.NotNull;
import wgslplugin.language.psi.WGSLArrayTypeDecl;
import wgslplugin.language.psi.WGSLCompoundStatement;
import wgslplugin.language.psi.WGSLFile;
import wgslplugin.language.psi.WGSLStructBodyDecl;
import wgslplugin.language.psi.WGSLVisitor;

import java.util.List;

public class WGSLFoldingBuilder extends CustomFoldingBuilder implements DumbAware {
    @Override
    protected void buildLanguageFoldRegions(@NotNull List<FoldingDescriptor> descriptors, @NotNull PsiElement root, @NotNull Document document, boolean quick) {
        if (!(root instanceof WGSLFile)) {
            return;
        }

        var visitor = new WGSLFoldingVisitor(descriptors);
        root.accept(visitor);
    }

    @Override
    protected String getLanguagePlaceholderText(@NotNull ASTNode node, @NotNull TextRange range) {
        if (node.getPsi() instanceof PsiComment) {
            return "/* ... */";
        }
        return "{...}";
    }

    @Override
    protected boolean isRegionCollapsedByDefault(@NotNull ASTNode node) {
        return false;
    }
}

class WGSLFoldingVisitor extends WGSLRecursiveVisitor {
    private final List<FoldingDescriptor> descriptors;

    public WGSLFoldingVisitor(List<FoldingDescriptor> descriptors) {
        this.descriptors = descriptors;
    }

    @Override
    public void visitArrayTypeDecl(@NotNull WGSLArrayTypeDecl o) {
        super.visitArrayTypeDecl(o);
    }

    @Override
    public void visitStructBodyDecl(@NotNull WGSLStructBodyDecl o) {
        if (!o.getStructMemberList().isEmpty()) {
            fold(o);
        }
        super.visitStructBodyDecl(o);
    }

    @Override
    public void visitComment(@NotNull PsiComment comment) {
        if (comment.getTokenType() == BLOCK_COMMENT) {
            fold(comment);
        }
        super.visitComment(comment);
    }

    @Override
    public void visitCompoundStatement(@NotNull WGSLCompoundStatement o) {
        if (!o.getStatementList().isEmpty()) {
            fold(o);
        }
        super.visitCompoundStatement(o);
    }

    private void fold(PsiElement element) {
        this.descriptors.add(new FoldingDescriptor(element.getNode(), element.getTextRange()));
    }
}

class WGSLRecursiveVisitor extends WGSLVisitor implements PsiRecursiveVisitor {
    @Override
    public void visitElement(@NotNull PsiElement element) {
        ProgressManager.checkCanceled();
        element.acceptChildren(this);
    }
}

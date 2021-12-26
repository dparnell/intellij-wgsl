package wgslplugin.language.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.Nullable;
import wgslplugin.language.psi.WGSLElementFactory;
import wgslplugin.language.psi.WGSLNamedElement;
import wgslplugin.language.psi.WGSLTypes;
import wgslplugin.language.psi.WGSLVariableIdentDecl;

public class WGSLPsiImplUtil {
    public static String getName(PsiElement element) {
        ASTNode identNode = element.getNode().findChildByType(WGSLTypes.IDENT);
        if(identNode != null) {
            return identNode.getText();
        }

        return null;
    }

    public static PsiElement setName(PsiElement element, String newName) {
        ASTNode identNode = element.getNode().findChildByType(WGSLTypes.IDENT);
        if (identNode != null) {
            WGSLVariableIdentDecl variable = WGSLElementFactory.createVariable(element.getProject(), newName);
            ASTNode newIdentNode = findElement(variable, WGSLTypes.IDENT);

            element.getNode().replaceChild(identNode, newIdentNode);
        }
        return element;
    }

    public static ASTNode findElement(PsiElement root, IElementType type) {
        @Nullable ASTNode n = root.getNode().findChildByType(type);
        if(n == null) {
            for(PsiElement e : root.getChildren()) {
                n = findElement(e, type);
                if(n != null) {
                    break;
                }
            }
        }

        return n;
    }

    public static PsiElement getNameIdentifier(WGSLNamedElement element) {
        ASTNode keyNode = element.getNode().findChildByType(WGSLTypes.IDENT);
        if (keyNode != null) {
            return keyNode.getPsi();
        } else {
            return null;
        }
    }

}

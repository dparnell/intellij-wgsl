// This is a generated file. Not intended for manual editing.
package wgslplugin.language.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static wgslplugin.language.psi.WGSLTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import wgslplugin.language.psi.*;

public class WGSLGlobalVariableDeclImpl extends ASTWrapperPsiElement implements WGSLGlobalVariableDecl {

  public WGSLGlobalVariableDeclImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull WGSLVisitor visitor) {
    visitor.visitGlobalVariableDecl(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof WGSLVisitor) accept((WGSLVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<WGSLAttributeList> getAttributeListList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, WGSLAttributeList.class);
  }

  @Override
  @Nullable
  public WGSLConstExpression getConstExpression() {
    return findChildByClass(WGSLConstExpression.class);
  }

  @Override
  @NotNull
  public WGSLVariableDecl getVariableDecl() {
    return findNotNullChildByClass(WGSLVariableDecl.class);
  }

}

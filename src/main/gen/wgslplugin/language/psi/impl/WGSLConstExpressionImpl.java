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

public class WGSLConstExpressionImpl extends ASTWrapperPsiElement implements WGSLConstExpression {

  public WGSLConstExpressionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull WGSLVisitor visitor) {
    visitor.visitConstExpression(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof WGSLVisitor) accept((WGSLVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<WGSLConstExpression> getConstExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, WGSLConstExpression.class);
  }

  @Override
  @Nullable
  public WGSLConstLiteral getConstLiteral() {
    return findChildByClass(WGSLConstLiteral.class);
  }

  @Override
  @Nullable
  public WGSLTypeDecl getTypeDecl() {
    return findChildByClass(WGSLTypeDecl.class);
  }

}

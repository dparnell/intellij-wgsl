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

public class WGSLArrayTypeDeclImpl extends ASTWrapperPsiElement implements WGSLArrayTypeDecl {

  public WGSLArrayTypeDeclImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull WGSLVisitor visitor) {
    visitor.visitArrayTypeDecl(this);
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
  public WGSLElementCountExpression getElementCountExpression() {
    return findChildByClass(WGSLElementCountExpression.class);
  }

  @Override
  @NotNull
  public WGSLTypeDecl getTypeDecl() {
    return findNotNullChildByClass(WGSLTypeDecl.class);
  }

}

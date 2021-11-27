// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static wgslplugin.language.psi.WGSLTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import org.intellij.sdk.language.psi.*;

public class WGSLForHeaderImpl extends ASTWrapperPsiElement implements WGSLForHeader {

  public WGSLForHeaderImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull WGSLVisitor visitor) {
    visitor.visitForHeader(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof WGSLVisitor) accept((WGSLVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<WGSLAssignmentStatement> getAssignmentStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, WGSLAssignmentStatement.class);
  }

  @Override
  @Nullable
  public WGSLExpression getExpression() {
    return findChildByClass(WGSLExpression.class);
  }

  @Override
  @NotNull
  public List<WGSLFuncCallStatement> getFuncCallStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, WGSLFuncCallStatement.class);
  }

  @Override
  @Nullable
  public WGSLVariableStatement getVariableStatement() {
    return findChildByClass(WGSLVariableStatement.class);
  }

}

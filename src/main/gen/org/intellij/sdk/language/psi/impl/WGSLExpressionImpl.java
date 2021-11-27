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

public class WGSLExpressionImpl extends ASTWrapperPsiElement implements WGSLExpression {

  public WGSLExpressionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull WGSLVisitor visitor) {
    visitor.visitExpression(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof WGSLVisitor) accept((WGSLVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public WGSLBinaryAndExpression getBinaryAndExpression() {
    return findChildByClass(WGSLBinaryAndExpression.class);
  }

  @Override
  @Nullable
  public WGSLBinaryOrExpression getBinaryOrExpression() {
    return findChildByClass(WGSLBinaryOrExpression.class);
  }

  @Override
  @Nullable
  public WGSLBinaryXorExpression getBinaryXorExpression() {
    return findChildByClass(WGSLBinaryXorExpression.class);
  }

  @Override
  @Nullable
  public WGSLRelationalExpression getRelationalExpression() {
    return findChildByClass(WGSLRelationalExpression.class);
  }

  @Override
  @Nullable
  public WGSLShortCircuitAndExpression getShortCircuitAndExpression() {
    return findChildByClass(WGSLShortCircuitAndExpression.class);
  }

  @Override
  @Nullable
  public WGSLShortCircuitOrExpression getShortCircuitOrExpression() {
    return findChildByClass(WGSLShortCircuitOrExpression.class);
  }

  @Override
  @Nullable
  public WGSLUnaryExpression getUnaryExpression() {
    return findChildByClass(WGSLUnaryExpression.class);
  }

}

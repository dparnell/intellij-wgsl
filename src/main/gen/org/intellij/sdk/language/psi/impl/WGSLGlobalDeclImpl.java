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

public class WGSLGlobalDeclImpl extends ASTWrapperPsiElement implements WGSLGlobalDecl {

  public WGSLGlobalDeclImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull WGSLVisitor visitor) {
    visitor.visitGlobalDecl(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof WGSLVisitor) accept((WGSLVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public WGSLFunctionDecl getFunctionDecl() {
    return findChildByClass(WGSLFunctionDecl.class);
  }

  @Override
  @Nullable
  public WGSLGlobalConstantDecl getGlobalConstantDecl() {
    return findChildByClass(WGSLGlobalConstantDecl.class);
  }

  @Override
  @Nullable
  public WGSLGlobalVariableDecl getGlobalVariableDecl() {
    return findChildByClass(WGSLGlobalVariableDecl.class);
  }

  @Override
  @Nullable
  public WGSLStructDecl getStructDecl() {
    return findChildByClass(WGSLStructDecl.class);
  }

  @Override
  @Nullable
  public WGSLTypeAliasDecl getTypeAliasDecl() {
    return findChildByClass(WGSLTypeAliasDecl.class);
  }

}

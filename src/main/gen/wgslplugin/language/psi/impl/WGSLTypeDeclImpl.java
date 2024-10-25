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

public class WGSLTypeDeclImpl extends ASTWrapperPsiElement implements WGSLTypeDecl {

  public WGSLTypeDeclImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull WGSLVisitor visitor) {
    visitor.visitTypeDecl(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof WGSLVisitor) accept((WGSLVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public WGSLAccessMode getAccessMode() {
    return findChildByClass(WGSLAccessMode.class);
  }

  @Override
  @Nullable
  public WGSLArrayTypeDecl getArrayTypeDecl() {
    return findChildByClass(WGSLArrayTypeDecl.class);
  }

  @Override
  @Nullable
  public WGSLBuiltinTypeAlias getBuiltinTypeAlias() {
    return findChildByClass(WGSLBuiltinTypeAlias.class);
  }

  @Override
  @Nullable
  public WGSLElementCountExpression getElementCountExpression() {
    return findChildByClass(WGSLElementCountExpression.class);
  }

  @Override
  @Nullable
  public WGSLMatPrefix getMatPrefix() {
    return findChildByClass(WGSLMatPrefix.class);
  }

  @Override
  @Nullable
  public WGSLStorageClass getStorageClass() {
    return findChildByClass(WGSLStorageClass.class);
  }

  @Override
  @Nullable
  public WGSLTextureSamplerTypes getTextureSamplerTypes() {
    return findChildByClass(WGSLTextureSamplerTypes.class);
  }

  @Override
  @Nullable
  public WGSLTypeDecl getTypeDecl() {
    return findChildByClass(WGSLTypeDecl.class);
  }

  @Override
  @Nullable
  public WGSLVecPrefix getVecPrefix() {
    return findChildByClass(WGSLVecPrefix.class);
  }

}

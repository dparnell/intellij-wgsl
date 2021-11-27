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

public class WGSLTextureSamplerTypesImpl extends ASTWrapperPsiElement implements WGSLTextureSamplerTypes {

  public WGSLTextureSamplerTypesImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull WGSLVisitor visitor) {
    visitor.visitTextureSamplerTypes(this);
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
  public WGSLDepthTextureType getDepthTextureType() {
    return findChildByClass(WGSLDepthTextureType.class);
  }

  @Override
  @Nullable
  public WGSLMultisampledTextureType getMultisampledTextureType() {
    return findChildByClass(WGSLMultisampledTextureType.class);
  }

  @Override
  @Nullable
  public WGSLSampledTextureType getSampledTextureType() {
    return findChildByClass(WGSLSampledTextureType.class);
  }

  @Override
  @Nullable
  public WGSLSamplerType getSamplerType() {
    return findChildByClass(WGSLSamplerType.class);
  }

  @Override
  @Nullable
  public WGSLStorageTextureType getStorageTextureType() {
    return findChildByClass(WGSLStorageTextureType.class);
  }

  @Override
  @Nullable
  public WGSLTexelFormat getTexelFormat() {
    return findChildByClass(WGSLTexelFormat.class);
  }

  @Override
  @Nullable
  public WGSLTypeDecl getTypeDecl() {
    return findChildByClass(WGSLTypeDecl.class);
  }

}

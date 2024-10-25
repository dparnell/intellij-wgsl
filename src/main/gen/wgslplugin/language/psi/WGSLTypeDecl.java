// This is a generated file. Not intended for manual editing.
package wgslplugin.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface WGSLTypeDecl extends PsiElement {

  @Nullable
  WGSLAccessMode getAccessMode();

  @Nullable
  WGSLArrayTypeDecl getArrayTypeDecl();

  @Nullable
  WGSLBuiltinTypeAlias getBuiltinTypeAlias();

  @Nullable
  WGSLElementCountExpression getElementCountExpression();

  @Nullable
  WGSLMatPrefix getMatPrefix();

  @Nullable
  WGSLStorageClass getStorageClass();

  @Nullable
  WGSLTextureSamplerTypes getTextureSamplerTypes();

  @Nullable
  WGSLTypeDecl getTypeDecl();

  @Nullable
  WGSLVecPrefix getVecPrefix();

}

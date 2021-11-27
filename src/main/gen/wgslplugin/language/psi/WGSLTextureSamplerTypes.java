// This is a generated file. Not intended for manual editing.
package wgslplugin.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface WGSLTextureSamplerTypes extends PsiElement {

  @Nullable
  WGSLAccessMode getAccessMode();

  @Nullable
  WGSLDepthTextureType getDepthTextureType();

  @Nullable
  WGSLMultisampledTextureType getMultisampledTextureType();

  @Nullable
  WGSLSampledTextureType getSampledTextureType();

  @Nullable
  WGSLSamplerType getSamplerType();

  @Nullable
  WGSLStorageTextureType getStorageTextureType();

  @Nullable
  WGSLTexelFormat getTexelFormat();

  @Nullable
  WGSLTypeDecl getTypeDecl();

}

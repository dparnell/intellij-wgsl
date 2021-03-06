// This is a generated file. Not intended for manual editing.
package wgslplugin.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface WGSLGlobalDecl extends PsiElement {

  @Nullable
  WGSLFunctionDecl getFunctionDecl();

  @Nullable
  WGSLGlobalConstantDecl getGlobalConstantDecl();

  @Nullable
  WGSLGlobalVariableDecl getGlobalVariableDecl();

  @Nullable
  WGSLStructDecl getStructDecl();

  @Nullable
  WGSLTypeAliasDecl getTypeAliasDecl();

}

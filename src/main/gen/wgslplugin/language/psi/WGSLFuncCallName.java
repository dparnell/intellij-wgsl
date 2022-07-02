// This is a generated file. Not intended for manual editing.
package wgslplugin.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface WGSLFuncCallName extends WGSLFunctionCallElement {

  @Nullable
  WGSLMatPrefix getMatPrefix();

  @Nullable
  WGSLVecPrefix getVecPrefix();

  String getName();

  PsiElement setName(String newName);

}

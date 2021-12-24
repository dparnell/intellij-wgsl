// This is a generated file. Not intended for manual editing.
package wgslplugin.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface WGSLForUpdate extends PsiElement {

  @Nullable
  WGSLAssignmentStatement getAssignmentStatement();

  @Nullable
  WGSLDecrementStatement getDecrementStatement();

  @Nullable
  WGSLFuncCallStatement getFuncCallStatement();

  @Nullable
  WGSLIncrementStatement getIncrementStatement();

}

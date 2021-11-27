// This is a generated file. Not intended for manual editing.
package wgslplugin.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface WGSLGlobalVariableDecl extends PsiElement {

  @NotNull
  List<WGSLAttributeList> getAttributeListList();

  @Nullable
  WGSLConstExpression getConstExpression();

  @NotNull
  WGSLVariableDecl getVariableDecl();

}

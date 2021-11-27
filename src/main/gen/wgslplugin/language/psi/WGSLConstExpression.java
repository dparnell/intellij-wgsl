// This is a generated file. Not intended for manual editing.
package wgslplugin.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface WGSLConstExpression extends PsiElement {

  @NotNull
  List<WGSLConstExpression> getConstExpressionList();

  @Nullable
  WGSLConstLiteral getConstLiteral();

  @Nullable
  WGSLTypeDecl getTypeDecl();

}

// This is a generated file. Not intended for manual editing.
package wgslplugin.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface WGSLPrimaryExpression extends PsiElement {

  @Nullable
  WGSLArgumentExpressionList getArgumentExpressionList();

  @Nullable
  WGSLConstLiteral getConstLiteral();

  @Nullable
  WGSLFuncCallStatement getFuncCallStatement();

  @Nullable
  WGSLParenExpression getParenExpression();

  @Nullable
  WGSLTypeDecl getTypeDecl();

}

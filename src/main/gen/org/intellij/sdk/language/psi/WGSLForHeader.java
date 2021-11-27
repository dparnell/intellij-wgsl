// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface WGSLForHeader extends PsiElement {

  @NotNull
  List<WGSLAssignmentStatement> getAssignmentStatementList();

  @Nullable
  WGSLExpression getExpression();

  @NotNull
  List<WGSLFuncCallStatement> getFuncCallStatementList();

  @Nullable
  WGSLVariableStatement getVariableStatement();

}

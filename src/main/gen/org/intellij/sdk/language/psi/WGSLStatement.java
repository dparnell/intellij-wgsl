// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface WGSLStatement extends PsiElement {

  @Nullable
  WGSLAssignmentStatement getAssignmentStatement();

  @Nullable
  WGSLBreakStatement getBreakStatement();

  @Nullable
  WGSLCompoundStatement getCompoundStatement();

  @Nullable
  WGSLContinueStatement getContinueStatement();

  @Nullable
  WGSLForStatement getForStatement();

  @Nullable
  WGSLFuncCallStatement getFuncCallStatement();

  @Nullable
  WGSLIfStatement getIfStatement();

  @Nullable
  WGSLLoopStatement getLoopStatement();

  @Nullable
  WGSLReturnStatement getReturnStatement();

  @Nullable
  WGSLSwitchStatement getSwitchStatement();

  @Nullable
  WGSLVariableStatement getVariableStatement();

}

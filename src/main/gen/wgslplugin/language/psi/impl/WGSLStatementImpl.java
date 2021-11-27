// This is a generated file. Not intended for manual editing.
package wgslplugin.language.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static wgslplugin.language.psi.WGSLTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import wgslplugin.language.psi.*;

public class WGSLStatementImpl extends ASTWrapperPsiElement implements WGSLStatement {

  public WGSLStatementImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull WGSLVisitor visitor) {
    visitor.visitStatement(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof WGSLVisitor) accept((WGSLVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public WGSLAssignmentStatement getAssignmentStatement() {
    return findChildByClass(WGSLAssignmentStatement.class);
  }

  @Override
  @Nullable
  public WGSLBreakStatement getBreakStatement() {
    return findChildByClass(WGSLBreakStatement.class);
  }

  @Override
  @Nullable
  public WGSLCompoundStatement getCompoundStatement() {
    return findChildByClass(WGSLCompoundStatement.class);
  }

  @Override
  @Nullable
  public WGSLContinueStatement getContinueStatement() {
    return findChildByClass(WGSLContinueStatement.class);
  }

  @Override
  @Nullable
  public WGSLForStatement getForStatement() {
    return findChildByClass(WGSLForStatement.class);
  }

  @Override
  @Nullable
  public WGSLFuncCallStatement getFuncCallStatement() {
    return findChildByClass(WGSLFuncCallStatement.class);
  }

  @Override
  @Nullable
  public WGSLIfStatement getIfStatement() {
    return findChildByClass(WGSLIfStatement.class);
  }

  @Override
  @Nullable
  public WGSLLoopStatement getLoopStatement() {
    return findChildByClass(WGSLLoopStatement.class);
  }

  @Override
  @Nullable
  public WGSLReturnStatement getReturnStatement() {
    return findChildByClass(WGSLReturnStatement.class);
  }

  @Override
  @Nullable
  public WGSLSwitchStatement getSwitchStatement() {
    return findChildByClass(WGSLSwitchStatement.class);
  }

  @Override
  @Nullable
  public WGSLVariableStatement getVariableStatement() {
    return findChildByClass(WGSLVariableStatement.class);
  }

}

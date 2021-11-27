// This is a generated file. Not intended for manual editing.
package wgslplugin.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface WGSLExpression extends PsiElement {

  @Nullable
  WGSLBinaryAndExpression getBinaryAndExpression();

  @Nullable
  WGSLBinaryOrExpression getBinaryOrExpression();

  @Nullable
  WGSLBinaryXorExpression getBinaryXorExpression();

  @Nullable
  WGSLRelationalExpression getRelationalExpression();

  @Nullable
  WGSLShortCircuitAndExpression getShortCircuitAndExpression();

  @Nullable
  WGSLShortCircuitOrExpression getShortCircuitOrExpression();

  @Nullable
  WGSLUnaryExpression getUnaryExpression();

}

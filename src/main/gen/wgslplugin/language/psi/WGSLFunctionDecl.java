// This is a generated file. Not intended for manual editing.
package wgslplugin.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface WGSLFunctionDecl extends PsiElement {

  @Nullable
  WGSLAttributeList getAttributeList();

  @NotNull
  WGSLCompoundStatement getCompoundStatement();

  @Nullable
  WGSLDocs getDocs();

  @NotNull
  WGSLFunctionHeader getFunctionHeader();

}

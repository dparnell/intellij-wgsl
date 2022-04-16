// This is a generated file. Not intended for manual editing.
package wgslplugin.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface WGSLStructFieldIdentDecl extends WGSLStructFieldElement {

  @NotNull
  WGSLTypeDecl getTypeDecl();

  String getName();

  PsiElement setName(String newName);

  PsiElement getNameIdentifier();

}

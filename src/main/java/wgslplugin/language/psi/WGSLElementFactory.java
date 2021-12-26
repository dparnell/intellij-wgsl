package wgslplugin.language.psi;

import com.intellij.openapi.project.Project;
import com.intellij.psi.*;
import com.intellij.psi.util.PsiTreeUtil;
import wgslplugin.language.WGSLFileType;

public class WGSLElementFactory {
    public static WGSLVariableIdentDecl createVariable(Project project, String name) {
        final WGSLFile file = createFile(project, "var " + name + ";");
        PsiElement[] idents = PsiTreeUtil.collectElements(file, e -> e instanceof WGSLVariableIdentDecl);

        return (WGSLVariableIdentDecl) idents[0];
    }

    public static WGSLFile createFile(Project project, String text) {
        String name = "dummy.wgsl";
        return (WGSLFile) PsiFileFactory.getInstance(project).
                createFileFromText(name, WGSLFileType.INSTANCE, text);
    }
}

package wgslplugin.language.psi;

import com.intellij.openapi.project.Project;
import com.intellij.psi.*;
import com.intellij.psi.util.PsiTreeUtil;
import wgslplugin.language.WGSLFileType;

public class WGSLElementFactory {
    public static WGSLVariableIdentDecl createVariable(Project project, String name) {
        final WGSLFile file = createFile(project, "var " + name + ": dummy;");
        WGSLVariableIdentDecl ident = PsiTreeUtil.findChildOfType(file, WGSLVariableIdentDecl.class);
        assert ident != null;

        return ident;
    }

    public static WGSLFile createFile(Project project, String text) {
        String name = "dummy.wgsl";
        return (WGSLFile) PsiFileFactory.getInstance(project).
                createFileFromText(name, WGSLFileType.INSTANCE, text);
    }
}

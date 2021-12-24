package wgslplugin.language.psi;

import com.intellij.openapi.project.Project;
import com.intellij.psi.*;
import org.jetbrains.annotations.NotNull;
import wgslplugin.language.WGSLFileType;

public class WGSLElementFactory {
    public static WGSLVariableIdentDecl createVariable(Project project, String name) {
        final WGSLFile file = createFile(project, "var " + name + ";");
        final WGSLVariableIdentDecl[] result = new WGSLVariableIdentDecl[1];
        file.getFirstChild().accept(new WGSLVisitor() {
            @Override
            public void visitVariableIdentDecl(@NotNull WGSLVariableIdentDecl o) {
                result[0] = o;
                super.visitVariableIdentDecl(o);
            }
        });

        return result[0];
    }

    public static WGSLFile createFile(Project project, String text) {
        String name = "dummy.wgsl";
        return (WGSLFile) PsiFileFactory.getInstance(project).
                createFileFromText(name, WGSLFileType.INSTANCE, text);
    }
}

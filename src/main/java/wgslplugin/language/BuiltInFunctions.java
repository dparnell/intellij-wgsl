package wgslplugin.language;

import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import wgslplugin.language.psi.WGSLElementFactory;
import wgslplugin.language.psi.WGSLFunctionDecl;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class BuiltInFunctions {
    public static final BuiltInFunctions INSTANCE = new BuiltInFunctions();

    private PsiFile builtInFunctionsFile = null;
    public Map<String, WGSLFunctionDecl> functions = new HashMap<>();
    private PsiElement[] allBuiltinFunctions;

    public synchronized WGSLFunctionDecl get(PsiElement element) {
        if(builtInFunctionsFile == null) {
            Project proj = element.getProject();
            if(proj == null) {
                // this should never happen, but just in case
                System.out.println("project is null");
            } else {
                try (InputStream s = BuiltInFunctions.class.getResourceAsStream("BuiltInFunctions.wgsl")) {

                    ByteArrayOutputStream bos = new ByteArrayOutputStream();
                    byte[] buf = new byte[16384];
                    int L = s.read(buf);
                    while (L > 0) {
                        bos.write(buf, 0, L);
                        L = s.read(buf);
                    }
                    builtInFunctionsFile = WGSLElementFactory.createFile(proj, bos.toString(StandardCharsets.UTF_8));

                    allBuiltinFunctions = PsiTreeUtil.collectElements(builtInFunctionsFile, e -> e instanceof WGSLFunctionDecl);
                    for (PsiElement func : allBuiltinFunctions) {
                        WGSLFunctionDecl f = (WGSLFunctionDecl) func;
                        String name = f.getFunctionHeader().getFunctionName().getName();
                        if(!functions.containsKey(name)) {
                            functions.put(name, f);
                        }
                    }
                } catch (Throwable e) {
                    // something went wrong trying to read in the builtin functions
                    e.printStackTrace();
                    return null;
                }
            }

        }

        return functions.get(element.getText());
    }
}

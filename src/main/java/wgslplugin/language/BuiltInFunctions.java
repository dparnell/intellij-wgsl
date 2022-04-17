package wgslplugin.language;

import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.util.PsiTreeUtil;
import wgslplugin.language.psi.WGSLElementFactory;
import wgslplugin.language.psi.WGSLFunctionDecl;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class BuiltInFunctions {
    public static final BuiltInFunctions INSTANCE = new BuiltInFunctions();

    private PsiFile builtInFunctionsFile = null;
    public Map<String, WGSLFunctionDecl> functions = new HashMap<>();
    private PsiElement[] allBuiltinFunctions;

    public synchronized WGSLFunctionDecl get(PsiElement element) {
        if(builtInFunctionsFile == null) {
            InputStream s = BuiltInFunctions.class.getResourceAsStream("BuiltInFunctions.wgsl");

            try {
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                byte[] buf = new byte[16384];
                int L = s.read(buf);
                while(L>0) {
                    bos.write(buf, 0, L);
                    L = s.read(buf);
                }
                builtInFunctionsFile = WGSLElementFactory.createFile(element.getProject(), bos.toString("UTF-8"));

                allBuiltinFunctions = PsiTreeUtil.collectElements(builtInFunctionsFile, e -> e instanceof WGSLFunctionDecl);
                for(PsiElement func : allBuiltinFunctions) {
                    WGSLFunctionDecl f = (WGSLFunctionDecl) func;
                    if(f.getDocs() != null) {
                        String name = f.getFunctionHeader().getFunctionName().getName();
                        functions.put(name, f);
                    }
                }
            } catch (Throwable e) {
                // something went wrong trying to read in the builtin functions
                e.printStackTrace();
                return null;
            }

        }

        return functions.get(element.getText());
    }
}

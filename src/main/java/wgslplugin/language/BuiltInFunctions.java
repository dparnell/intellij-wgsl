package wgslplugin.language;

import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.util.PsiTreeUtil;
import wgslplugin.language.psi.WGSLElementFactory;
import wgslplugin.language.psi.WGSLFunctionCallElement;
import wgslplugin.language.psi.WGSLFunctionDecl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class BuiltInFunctions {
    public static final BuiltInFunctions INSTANCE = new BuiltInFunctions();

    private PsiFile builtInFunctionsFile = null;
    private Map<String, WGSLFunctionDecl> functions = new HashMap<>();

    public synchronized WGSLFunctionDecl get(WGSLFunctionCallElement element) {
        if(builtInFunctionsFile == null) {
            InputStream s = BuiltInFunctions.class.getClassLoader().getResourceAsStream("/doc/builtInFunctions.wgsl");
            try {
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                byte[] buf = new byte[16384];
                int L = s.read(buf);
                while(L>0) {
                    bos.write(buf, 0, L);
                    L = s.read(buf);
                }
                builtInFunctionsFile = WGSLElementFactory.createFile(element.getProject(), bos.toString("UTF-8"));

                PsiElement[] funcs = PsiTreeUtil.collectElements(builtInFunctionsFile, e -> e instanceof WGSLFunctionDecl);
                for(PsiElement func : funcs) {
                    WGSLFunctionDecl f = (WGSLFunctionDecl) func;
                    String name = f.getFunctionHeader().getFunctionName().getName();
                    functions.put(name, f);
                }
            } catch (IOException e) {
                // something went wrong trying to read in the builtin functions
                e.printStackTrace();
                builtInFunctionsFile = WGSLElementFactory.createFile(element.getProject(), "var dummy;");
            }

        }


        return functions.get(element.getText());
    }
}

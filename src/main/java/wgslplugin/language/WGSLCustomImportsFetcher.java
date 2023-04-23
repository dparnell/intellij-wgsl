package wgslplugin.language;

import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.util.PsiTreeUtil;
import wgslplugin.language.psi.*;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WGSLCustomImportsFetcher {
    public static final WGSLCustomImportsFetcher INSTANCE = new WGSLCustomImportsFetcher();
    private final List<PsiFile> dummyFiles = new ArrayList<>();
    private final List<String> customImportsCached = new ArrayList<>();
    public Map<String, WGSLFunctionDecl> functions = new HashMap<>();
    public Map<String, WGSLGlobalConstantDecl> constants = new HashMap<>();
    public Map<String, WGSLGlobalVariableDecl> variables = new HashMap<>();
    public Map<String, WGSLStructDecl> structs = new HashMap<>();

    public synchronized WGSLFunctionDecl get(PsiElement element) {
        List<String> customImports = WGSLSettingsState.getInstance(element.getProject()).customImports;

        if (!customImportsCached.equals(customImports)) {
            customImportsCached.addAll(customImports);
            dummyFiles.clear();
            functions.clear();
            constants.clear();
            variables.clear();
            structs.clear();
        }

        if (dummyFiles.isEmpty()) {
            for (String customImport : customImports) {
                try
                {
                    URL url = new URL(customImport);
                    URLConnection urlConnection = url.openConnection();
                    InputStream inputStream = urlConnection.getInputStream();

                    ByteArrayOutputStream bos = new ByteArrayOutputStream();
                    byte[] buf = new byte[16384];
                    int L = inputStream.read(buf);
                    while(L>0) {
                        bos.write(buf, 0, L);
                        L = inputStream.read(buf);
                    }
                    PsiFile dummyFile = WGSLElementFactory.createFile(element.getProject(), bos.toString("UTF-8"));
                    dummyFiles.add(dummyFile);

                    PsiElement[] customFunctions = PsiTreeUtil.collectElements(dummyFile, e -> e instanceof WGSLFunctionDecl);
                    for(PsiElement func : customFunctions) {
                        WGSLFunctionDecl f = (WGSLFunctionDecl) func;
                        String name = f.getFunctionHeader().getFunctionName().getName();
                        functions.put(name, f);
                    }

                    PsiElement[] customConstants = PsiTreeUtil.collectElements(dummyFile, e -> e instanceof WGSLGlobalConstantDecl);
                    for(PsiElement constant : customConstants) {
                        WGSLGlobalConstantDecl c = (WGSLGlobalConstantDecl) constant;
                        String name = c.getVariableIdentDecl().getName();
                        constants.put(name, c);
                    }

                    PsiElement[] customVariables = PsiTreeUtil.collectElements(dummyFile, e -> e instanceof WGSLGlobalVariableDecl);
                    for(PsiElement variable : customVariables) {
                        WGSLGlobalVariableDecl v = (WGSLGlobalVariableDecl) variable;
                        String name = v.getVariableDecl().getVariableIdentDecl().getName();
                        variables.put(name, v);
                    }

                    PsiElement[] customStructs = PsiTreeUtil.collectElements(dummyFile, e -> e instanceof WGSLStructDecl);
                    for(PsiElement struct : customStructs) {
                        WGSLStructDecl s = (WGSLStructDecl) struct;
                        String name = s.getNode().findChildByType(WGSLTypes.IDENT).getText(); // FIXME: extend WGSLStructDecl with getName()
                        structs.put(name, s);
                    }
                } catch (Throwable e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }

        return functions.get(element.getText());
    }
}

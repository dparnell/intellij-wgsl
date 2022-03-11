package wgslplugin.language;

import com.intellij.lang.documentation.AbstractDocumentationProvider;
import com.intellij.lang.documentation.DocumentationMarkup;
import com.intellij.openapi.util.NlsSafe;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import org.intellij.plugins.markdown.ui.preview.html.MarkdownUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wgslplugin.language.psi.*;

public class WGSLDocumentationProvider extends AbstractDocumentationProvider {

    @Override
    public @Nullable @NlsSafe String generateDoc(PsiElement element, @Nullable PsiElement originalElement) {
        // System.out.println(element);
        if (element instanceof WGSLFunctionName) {
            element = element.getParent();
        }
        if (element instanceof WGSLFunctionHeader) {
            element = element.getParent();
        }

        if (element instanceof WGSLFunctionDecl) {
            WGSLFunctionDecl func = (WGSLFunctionDecl) element;

            @Nullable WGSLAttributeList atts = func.getAttributeList();
            @NotNull WGSLFunctionHeader header = func.getFunctionHeader();
            StringBuilder b = new StringBuilder();
            PsiElement e = originalElement == null ? element : originalElement;

            b.append(DocumentationMarkup.CONTENT_START);
            String fn = "```wgsl\n";
            if (atts != null) {
                fn = fn + atts.getText() + " ";
            }
            fn = fn + header.getText() + "\n```";
            b.append(generateHTML(e, fn));
            b.append(DocumentationMarkup.CONTENT_END);
            b.append("<hr/>");

            @Nullable WGSLDocs docs = func.getDocs();
            if (docs != null) {
                b.append(DocumentationMarkup.CONTENT_START);
                String text = docs.getText();
                text = text.substring(3, text.length() - 2);
                String html = generateHTML(e, text);
                b.append(html);
                b.append(DocumentationMarkup.CONTENT_END);
            }
            return b.toString();
        }

        return null;
    }

    private String safe(String text) {
        return text.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;");
    }

    private String generateHTML(PsiElement element, String md) {
        VirtualFile file = element.getContainingFile().getVirtualFile();
        return MarkdownUtil.INSTANCE.generateMarkdownHtml(file, md, element.getProject());
    }
}

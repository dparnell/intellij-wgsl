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

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Pattern;

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

        PsiElement e = originalElement == null ? element : originalElement;

        if (element instanceof WGSLFunctionDecl) {
            WGSLFunctionDecl func = (WGSLFunctionDecl) element;

            @Nullable WGSLAttributeList atts = func.getAttributeList();
            @NotNull WGSLFunctionHeader header = func.getFunctionHeader();
            StringBuilder b = new StringBuilder();

            b.append(DocumentationMarkup.CONTENT_START);
            String fn = "```wgsl\n";
            if (atts != null) {
                fn = fn + atts.getText() + " ";
            }
            fn = fn + header.getText() + "\n```";
            b.append(generateHTML(e, fn));
            b.append(DocumentationMarkup.CONTENT_END);

            @Nullable WGSLDocs docs = func.getDocs();
            if (docs != null) {
                b.append("<hr/>");
                b.append(DocumentationMarkup.CONTENT_START);
                String text = docs.getText();
                text = text.substring(3, text.length() - 2);
                String html = generateHTML(e, text);
                b.append(html);
                b.append(DocumentationMarkup.CONTENT_END);
            }
            return b.toString();
        } else if(element instanceof WGSLAttributeName) {
            String attrName = ((WGSLAttributeName)element).getName();
            String markdown = getResource("attributes/" + attrName + ".md");
            if(markdown != null) {
                return DocumentationMarkup.CONTENT_START + generateHTML(e, markdown.replace("\r", "")) + DocumentationMarkup.CONTENT_END;
            }
        }

        return null;
    }

    private String safe(String text) {
        return text.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;");
    }

    private String generateHTML(PsiElement element, String md) {
        VirtualFile file = element.getContainingFile().getVirtualFile();
        return clean(MarkdownUtil.INSTANCE.generateMarkdownHtml(file, md, element.getProject()));
    }

    private static final Pattern IMG_TAG = Pattern.compile("<img[^>]+>");
    private static final Pattern DIV_TAG = Pattern.compile("<\\/?div[^>]*>");
    private String clean(String html) {
        return DIV_TAG.matcher(IMG_TAG.matcher(html).replaceAll("")).replaceAll("");
    }

    private static String getResource(String name) {
        InputStream s = WGSLDocumentationProvider.class.getResourceAsStream(name);
        if(s == null) {
            return null;
        }
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf = new byte[16384];
            int L = s.read(buf);
            while (L > 0) {
                bos.write(buf, 0, L);
                L = s.read(buf);
            }

            return bos.toString();
        } catch (IOException e) {
            return null;
        }
    }
}

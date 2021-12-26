package wgslplugin.language;

import com.intellij.lang.documentation.AbstractDocumentationProvider;
import com.intellij.lang.documentation.DocumentationMarkup;
import com.intellij.openapi.util.NlsSafe;
import com.intellij.psi.PsiElement;
import com.intellij.util.text.MarkdownUtil;
import com.petebevin.markdown.MarkdownProcessor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wgslplugin.language.psi.*;


public class WGSLDocumentationProvider extends AbstractDocumentationProvider {

    @Override
    public @Nullable @NlsSafe String generateDoc(PsiElement element, @Nullable PsiElement originalElement) {
        // System.out.println(element);
        if(element instanceof WGSLFunctionName) {
            element = element.getParent();
        }
        if(element instanceof WGSLFunctionHeader) {
            element = element.getParent();
        }

        if(element instanceof WGSLFunctionDecl) {
            WGSLFunctionDecl func = (WGSLFunctionDecl) element;

            @Nullable WGSLAttributeList atts = func.getAttributeList();
            @NotNull WGSLFunctionHeader header = func.getFunctionHeader();
            StringBuilder b = new StringBuilder();
            b.append(DocumentationMarkup.DEFINITION_START);
            if(atts != null) {
                b.append(atts.getText());
                b.append(" ");
            }
            b.append(header.getText());
            b.append(DocumentationMarkup.DEFINITION_END);

            @Nullable WGSLDocs docs = func.getDocs();
            if(docs != null) {
                b.append(DocumentationMarkup.CONTENT_START);
                String text = docs.getText();
                text = text.substring(3, text.length() - 5);
                MarkdownProcessor md = new MarkdownProcessor();
                b.append(md.markdown(text));
                b.append(DocumentationMarkup.CONTENT_END);
            }
            return b.toString();
        }

        return null;
    }

}

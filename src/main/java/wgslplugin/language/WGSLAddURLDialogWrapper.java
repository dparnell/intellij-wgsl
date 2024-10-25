package wgslplugin.language;

import com.intellij.openapi.ui.ComponentValidator;
import com.intellij.openapi.ui.DialogPanel;
import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.openapi.ui.ValidationInfo;
import com.intellij.openapi.util.text.StringUtil;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class WGSLAddURLDialogWrapper extends DialogWrapper {
    protected JTextField textField = new JTextField();
    protected String getFieldData() {
        return textField.getText();
    }
    protected ComponentValidator componentValidator = new ComponentValidator(getDisposable())
            .withValidator(() -> {
                String pt = textField.getText();
                if (StringUtil.isNotEmpty(pt)) {
                    try {
                        if (!URI.create(pt).toURL().getFile().endsWith(".wgsl")) throw new MalformedURLException();
                    } catch (MalformedURLException e) {
                        return new ValidationInfo("Specify correct URL with file extension", textField);
                    }
                    return null;
                } else {
                    return new ValidationInfo("URL cannot be a blank string", textField);
                }
            });

    public WGSLAddURLDialogWrapper() {
        super(true);
        setTitle("Add Source URL");
        textField.setText("");
        textField.setPreferredSize(new Dimension(300, textField.getHeight()));
        init();
    }

    public WGSLAddURLDialogWrapper(String defaultText) {
        super(true);
        setTitle("Add Source URL");
        textField.setText(defaultText);
        textField.setPreferredSize(new Dimension(300, textField.getHeight()));
        init();
    }

    @Nullable
    @Override
    protected JComponent createCenterPanel() {
        DialogPanel dialogPanel = new DialogPanel(new BorderLayout());

        dialogPanel.add(textField, BorderLayout.CENTER);
        dialogPanel.setPreferredFocusedComponent(textField);

        return dialogPanel;
    }

    @Nullable
    protected ValidationInfo doValidate() {
        componentValidator.revalidate();
        return componentValidator.getValidationInfo();
    }
}

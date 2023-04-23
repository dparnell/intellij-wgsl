package wgslplugin.language;

import com.intellij.ui.*;
import com.intellij.ui.components.JBList;
import com.intellij.util.ui.FormBuilder;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.util.List;

public class WGSLSettingsComponent {
    private final JPanel myMainPanel;
    private final CollectionListModel<String> myCustomImports = new CollectionListModel<>();
    private final JBList<String> myList = new JBList<>(myCustomImports);

    public WGSLSettingsComponent() {
        ToolbarDecorator myToolbar = ToolbarDecorator.createDecorator(myList);
        myToolbar.disableUpDownActions();
        ColoredListCellRenderer<String> cellRenderer = new ColoredListCellRenderer<>() {
            @Override
            protected void customizeCellRenderer(
                    @NotNull JList<? extends String> list, String value,
                    int index, boolean selected, boolean hasFocus
            ) {
                append(value, SimpleTextAttributes.LINK_PLAIN_ATTRIBUTES);
            }
        };
        myList.setCellRenderer(cellRenderer);
        AnActionButtonRunnable addAction = (AnActionButton actionButton) -> {
            WGSLAddURLDialogWrapper dialogWrapper = new WGSLAddURLDialogWrapper();
            if (dialogWrapper.showAndGet()) {
                myCustomImports.add(
                        myCustomImports.getSize(),
                        dialogWrapper.getFieldData()
                );
            }
        };
        myToolbar.setAddAction(addAction);
        AnActionButtonRunnable editAction = (AnActionButton actionButton) -> {
            WGSLAddURLDialogWrapper dialogWrapper =
                    new WGSLAddURLDialogWrapper(myList.getSelectedValue());
            if (dialogWrapper.showAndGet()) {
                myCustomImports.setElementAt(
                        dialogWrapper.getFieldData(),
                        myList.getSelectedIndex()
                );
            }
        };
        myToolbar.setEditAction(editAction);

        myMainPanel = FormBuilder.createFormBuilder()
                .addLabeledComponentFillVertically("Custom import URLs:", myToolbar.createPanel())
                .getPanel();
    }

    public JPanel getPanel() {
        return myMainPanel;
    }

    @NotNull
    public List<String> getCustomImports() {
        return myCustomImports.getItems();
    }

    public void setCustomImports(List<String> customImports) {
        for (String item : customImports) {
            myCustomImports.add(myCustomImports.getSize(), item);
        }
    }
}

package wgslplugin.language;

import com.intellij.openapi.options.Configurable;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class WGSLSettingsConfigurable implements Configurable, Configurable.VariableProjectAppLevel, Configurable.NoScroll {
    private final Project project;
    private WGSLSettingsComponent mySettingsComponent;

    WGSLSettingsConfigurable(Project project) {
        this.project = project;
    }

    @Nls(capitalization = Nls.Capitalization.Title)
    @Override
    public String getDisplayName() {
        return "WGSL";
    }

    @Nullable
    @Override
    public JComponent createComponent() {
        mySettingsComponent = new WGSLSettingsComponent();
        return mySettingsComponent.getPanel();
    }

    @Override
    public boolean isModified() {
        WGSLSettingsState settings = WGSLSettingsState.getInstance(project);
        return !mySettingsComponent.getCustomImports().equals(settings.customImports);
    }

    @Override
    public void apply() {
        WGSLSettingsState settings = WGSLSettingsState.getInstance(project);
        settings.customImports = mySettingsComponent.getCustomImports();
    }

    @Override
    public void reset() {
        WGSLSettingsState settings = WGSLSettingsState.getInstance(project);
        mySettingsComponent.setCustomImports(settings.customImports);
    }

    @Override
    public void disposeUIResources() {
        mySettingsComponent = null;
    }

    @Override
    public boolean isProjectLevel() {
        return true;
    }
}


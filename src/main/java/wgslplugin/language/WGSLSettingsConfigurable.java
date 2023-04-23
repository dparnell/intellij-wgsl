package wgslplugin.language;

import com.intellij.openapi.options.Configurable;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class WGSLSettingsConfigurable implements Configurable, Configurable.VariableProjectAppLevel, Configurable.NoScroll {
    private WGSLSettingsComponent mySettingsComponent;

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
        WGSLSettingsState settings = WGSLSettingsState.getInstance();
        return !mySettingsComponent.getCustomImports().equals(settings.customImports);
    }

    @Override
    public void apply() {
        WGSLSettingsState settings = WGSLSettingsState.getInstance();
        settings.customImports = mySettingsComponent.getCustomImports();
    }

    @Override
    public void reset() {
        WGSLSettingsState settings = WGSLSettingsState.getInstance();
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


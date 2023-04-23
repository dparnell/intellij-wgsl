package wgslplugin.language;

import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.util.xmlb.XmlSerializerUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

@State(
        name = "wgslplugin.language.WGSLSettingsState",
        storages = @Storage("SdkSettingsPlugin.xml")
)
public class WGSLSettingsState implements PersistentStateComponent<WGSLSettingsState> {
    public List<String> customImports = new ArrayList<>();

    public static WGSLSettingsState getInstance() {
        return ApplicationManager.getApplication().getService(WGSLSettingsState.class);
    }

    @Nullable
    @Override
    public WGSLSettingsState getState() {
        return this;
    }

    @Override
    public void loadState(@NotNull WGSLSettingsState state) {
        XmlSerializerUtil.copyBean(state, this);
    }
}

package wgslplugin.language;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.openapi.project.Project;
import com.intellij.util.xmlb.XmlSerializerUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

@State(
        name = "wgslplugin.language.WGSLSettingsState",
        storages = @Storage("WGSLSettingsPlugin.xml")
)
public class WGSLSettingsState implements PersistentStateComponent<WGSLSettingsState> {
    public List<String> customImports = new ArrayList<>();

    public static WGSLSettingsState getInstance(Project project) {
        return project.getService(WGSLSettingsState.class);
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

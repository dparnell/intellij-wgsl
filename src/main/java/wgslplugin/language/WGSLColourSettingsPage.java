package wgslplugin.language;

import com.intellij.openapi.editor.colors.ColorKey;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import com.intellij.openapi.util.NlsContexts;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class WGSLColourSettingsPage implements ColorSettingsPage {
    @Override
    public @Nullable Icon getIcon() {
        return WGSLIcons.FILE;
    }

    @Override
    public @NotNull SyntaxHighlighter getHighlighter() {
        return new WGSLSyntaxHighlighter();
    }

    @Override
    public @NonNls @NotNull String getDemoText() {
        return "struct VertexOutput {\n" +
                "    [[location(0)]] tex_coord: vec2<f32>;\n" +
                "    [[builtin(position)]] position: vec4<f32>;\n" +
                "};\n" +
                "\n" +
                "[[block]]\n" +
                "struct Locals {\n" +
                "    transform: mat4x4<f32>;\n" +
                "};\n" +
                "[[group(0), binding(0)]]\n" +
                "var<uniform> r_locals: Locals;\n" +
                "\n" +
                "[[stage(vertex)]]\n" +
                "fn vs_main(\n" +
                "    [[location(0)]] position: vec4<f32>,\n" +
                "    [[location(1)]] tex_coord: vec2<f32>,\n" +
                ") -> VertexOutput {\n" +
                "    var out: VertexOutput;\n" +
                "    out.tex_coord = tex_coord;\n" +
                "    out.position = r_locals.transform * position;\n" +
                "    return out;\n" +
                "}\n" +
                "\n" +
                "[[group(0), binding(1)]]\n" +
                "var r_color: texture_2d<u32>;\n" +
                "\n" +
                "[[stage(fragment)]]\n" +
                "fn <FUNCTION_NAME>fs_main</FUNCTION_NAME>(in: VertexOutput) -> [[location(0)]] vec4<f32> {\n" +
                "    let tex = textureLoad(r_color, vec2<i32>(in.tex_coord * 256.0), 0);\n" +
                "    let v = f32(tex.x) / 255.0;\n" +
                "    return vec4<f32>(1.0 - (v * 5.0), 1.0 - (v * 15.0), 1.0 - (v * 50.0), 1.0);\n" +
                "}\n" +
                "\n" +
                "[[stage(fragment)]]\n" +
                "fn fs_wire() -> [[location(0)]] vec4<f32> {\n" +
                "    return vec4<f32>(0.0, 0.5, 0.0, 0.5);\n" +
                "}";
    }

    @Override
    public @Nullable Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
        return Map.of(WGSLColours.FUNCTION_NAME.name(), WGSLColours.FUNCTION_NAME.attributes());
    }

    @Override
    public AttributesDescriptor @NotNull [] getAttributeDescriptors() {
        return Arrays.stream(WGSLColours.values()).map(c -> new AttributesDescriptor(c.description(), c.attributes()) ).toArray(AttributesDescriptor[]::new);
    }

    @Override
    public ColorDescriptor @NotNull [] getColorDescriptors() {
        return new ColorDescriptor[0];
    }

    @Override
    public @NotNull @NlsContexts.ConfigurableName String getDisplayName() {
        return "WGSL Shader";
    }
}

package wgslplugin.language;

import com.intellij.lang.ASTNode;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiWhiteSpace;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wgslplugin.language.psi.*;
import wgslplugin.language.psi.impl.WGSLPsiImplUtil;
import wgslplugin.language.psi.impl.WGSLStructFieldImpl;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class WGSLAnnotator implements Annotator {

    public static final Set<String> FRAGMENT_SHADER_ONLY_BUILTINS = Set.of(
            "dpdx", "dpdxCoarse", "dpdxFine", "dpdy", "dpdyCoarse", "dpdyFine", "fwidth", "fwidthCoarse", "fwidthFine"
    );

    public static final Set<String> ATTRIBUTE_NAMES = Set.of(
            "align", "binding", "builtin", "const", "group", "id", "interpolate", "invariant", "location", "size", "workgroup_size"
    );

    public static final Set<String> DEPRECATED_ATTRIBUTE_NAMES = Set.of(
            "stage"
    );

    public static final Set<String> STAGE_NAMES = Set.of(
            "compute", "fragment", "vertex"
    );

    public static final Set<String> RESERVED_KEYWORDS = Set.of(
        "AppendStructuredBuffer", "BlendState", "Buffer", "ByteAddressBuffer", "CompileShader", "ComputeShader", "ConsumeStructuredBuffer", "DepthStencilState", 
        "DepthStencilView", "DomainShader", "GeometryShader", "Hullshader", "InputPatch", "LineStream", "NULL", "OutputPatch", "PixelShader", "PointStream", 
        "RWBuffer", "RWByteAddressBuffer", "RWStructuredBuffer", "RWTexture1D", "RWTexture1DArray", "RWTexture2D", "RWTexture2DArray", "RWTexture3D", 
        "RasterizerState", "RenderTargetView", "SamplerComparisonState", "SamplerState", "Self", "StructuredBuffer", "Texture1D", "Texture1DArray", 
        "Texture2D", "Texture2DArray", "Texture2DMS", "Texture2DMSArray", "Texture3D", "TextureCube", "TextureCubeArray", "TriangleStream", "VertexShader", 
        "abstract", "active", "alignas", "alignof", "array", "as", "asm", "asm_fragment", "async", "atomic", "atomic_uint", "attribute", "auto", "await", 
        "become", "bf16", "binding_array", "bitcast", "bool", "break", "case", "cast", "catch", "cbuffer", "centroid", "char", "class", "co_await", 
        "co_return", "co_yield", "coherent", "column_major", "common", "compile", "compile_fragment", "concept", "const_cast", "consteval",
        "constexpr", "constinit", "continue", "continuing", "crate", "debugger", "decltype", "default", "delete", "demote", "demote_to_helper", "discard", 
        "do", "dword", "dynamic_cast", "else", "enable", "enum", "explicit", "export", "extends", "extern", "external", "f16", "f32", "f64", "fallthrough", 
        "false", "filter", "final", "finally", "fixed", "flat", "fn", "for", "friend", "from", "function", "fvec2", "fvec3", "fvec4", "fxgroup", "get", 
        "goto", "groupshared", "handle", "highp", "hvec2", "hvec3", "hvec4", "i16", "i32", "i64", "i8", "if", "iimage1D", "iimage1DArray", "iimage2D", 
        "iimage2DArray", "iimage2DMS", "iimage2DMSArray", "iimage2DRect", "iimage3D", "iimageBuffer", "iimageCube", "iimageCubeArray", "image1D", 
        "image1DArray", "image2D", "image2DArray", "image2DMS", "image2DMSArray", "image2DRect", "image3D", "imageBuffer", "imageCube", "imageCubeArray", 
        "impl", "implements", "import", "inline", "inout", "instanceof", "interface", "invariant", "isampler1D", "isampler1DArray", "isampler2D", 
        "isampler2DArray", "isampler2DMS", "isampler2DMSArray", "isampler2DRect", "isampler3D", "isamplerBuffer", "isamplerCube", "isamplerCubeArray", 
        "isubpassInput", "isubpassInputMS", "itexture1D", "itexture1DArray", "itexture2D", "itexture2DArray", "itexture2DMS", "itexture2DMSArray", 
        "itexture2DRect", "itexture3D", "itextureBuffer", "itextureCube", "itextureCubeArray", "layout", "let", "line", "lineadj", "linear", "loop", 
        "lowp", "macro", "macro_rules", "mat", "mat2x2", "mat2x3", "mat2x4", "mat3x2", "mat3x3", "mat3x4", "mat4x2", "mat4x3", "mat4x4", "match", "matrix", 
        "mediump", "meta", "mod", "module", "move", "mut", "mutable", "namespace", "new", "nil", "noexcept", "noinline", "nointerpolation", "noperspective", 
        "null", "nullptr", "of", "operator", "override", "package", "packoffset", "partition", "pass", "patch", "pixelfragment", "point", "precise", "precision", 
        "premerge", "priv", "private", "protected", "ptr", "pub", "public", "readonly", "ref", "regardless", "register", "reinterpret_cast", "requires", 
        "resource", "restrict", "return", "row_major", "samper", "sample", "sampler", "sampler1D", "sampler1DArray", "sampler1DArrayShadow", "sampler1DShadow", 
        "sampler2D", "sampler2DArray", "sampler2DArrayShadow", "sampler2DMS", "sampler2DMSArray", "sampler2DRect", "sampler2DRectShadow", "sampler2DShadow", 
        "sampler3D", "sampler3DRect", "samplerBuffer", "samplerCube", "samplerCubeArray", "samplerCubeArrayShadow", "samplerCubeShadow", "samplerShadow", 
        "sampler_comparison", "self", "set", "shared", "signed", "sizeof", "smooth", "snorm", "stateblock", "stateblock_state", "static", "static_assert", 
        "static_cast", "std", "storage", "string", "struct", "subpassInput", "subpassInputMS", "subroutine", "super", "superp", "switch", "target", "tbuffer", 
        "technique", "technique10", "technique11", "template", "texture1D", "texture1DArray", "texture2D", "texture2DArray", "texture2DMS", "texture2DMSArray", 
        "texture2DRect", "texture3D", "textureBuffer", "textureCube", "textureCubeArray", "texture_1d", "texture_2d", "texture_2d_array", "texture_3d", 
        "texture_cube", "texture_cube_array", "texture_depth_2d", "texture_depth_2d_array", "texture_depth_cube", "texture_depth_cube_array", 
        "texture_depth_multisampled_2d", "texture_multisampled_2d", "texture_storage_1d", "texture_storage_2d", "texture_storage_2d_array", "texture_storage_3d", 
        "this", "thread_local", "throw", "trait", "triangle", "triangleadj", "true", "try", "type", "typedef", "typeid", "typename", "typeof", "u16", "u32", "u64", 
        "u8", "uimage1D", "uimage1DArray", "uimage2D", "uimage2DArray", "uimage2DMS", "uimage2DMSArray", "uimage2DRect", "uimage3D", "uimageBuffer", "uimageCube", 
        "uimageCubeArray", "uniform", "union", "unless", "unorm", "unsafe", "unsigned", "unsized", "usampler1D", "usampler1DArray", "usampler2D", "usampler2DArray", 
        "usampler2DMS", "usampler2DMSArray", "usampler2DRect", "usampler3D", "usamplerBuffer", "usamplerCube", "usamplerCubeArray", "use", "using", "usubpassInput", 
        "usubpassInputMS", "utexture1D", "utexture1DArray", "utexture2D", "utexture2DArray", "utexture2DMS", "utexture2DMSArray", "utexture2DRect", "utexture3D", 
        "utextureBuffer", "utextureCube", "utextureCubeArray", "var", "varying", "vec", "vec2", "vec3", "vec4", "vector", "vertexfragment", "virtual", "void", 
        "volatile", "wchar_t", "wgsl", "where", "while", "with", "workgroup", "writeonly", "yield"
    );

    @Override
    public void annotate(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {

        if(element instanceof WGSLNamedElement) {
            var named = (WGSLNamedElement) element;
            if (RESERVED_KEYWORDS.contains(named.getName())) {
                holder.newAnnotation(HighlightSeverity.ERROR, "'" + named.getName() + "' is a reserved keyword").range(element).create();
            }
        }

        if(element instanceof WGSLFuncCallStatement) {
            var fragment_shader = false;

            @Nullable ASTNode call_name = element.getNode().findChildByType(WGSLTypes.FUNC_CALL_NAME);
            if(call_name != null) {
                @Nullable ASTNode name = call_name.findChildByType(WGSLTypes.IDENT);

                // Get the parent all the way to the function declaration
                var parent = element.getParent();
                while (parent != null && !(parent instanceof WGSLFunctionDecl)) {
                    parent = parent.getParent();
                }

                if (name != null) {
                    String txt = name.getText();

                    if (FRAGMENT_SHADER_ONLY_BUILTINS.contains(txt)) {
                        // If we have a parent that was a function declaration we get the attribute list and
                        // check if it contains the attribute 'stage(fragment)'
                        if (parent != null) {
                            var attributes = ((WGSLFunctionDecl) parent).getAttributeList();
                            if (attributes != null) {
                                for (var i : attributes.getAttributeList()) {
                                    String t = i.getText();
                                    fragment_shader |= (t.equals("fragment") || t.equals("stage(fragment)"));
                                }
                            }
                        }

                        if (fragment_shader) {
                            holder.newSilentAnnotation(HighlightSeverity.INFORMATION).range(name).textAttributes(WGSLColours.BUILTIN_FUNCTION.attributes()).create();
                        } else {
                            holder.newAnnotation(HighlightSeverity.ERROR, "This built-in is only allowed in fragment shader functions").range(name).create();
                        }
                    } else if (BuiltInFunctions.INSTANCE.get(name.getPsi()) != null) {
                        holder.newSilentAnnotation(HighlightSeverity.INFORMATION).range(name).textAttributes(WGSLColours.BUILTIN_FUNCTION.attributes()).create();
                    } else {
                    }
                }
            }
        } else if(element instanceof WGSLFunctionName) {
            holder.newSilentAnnotation(HighlightSeverity.INFORMATION).range(element).textAttributes(WGSLColours.FUNCTION_NAME.attributes()).create();
        } else if(element instanceof WGSLFieldIdent) {
            holder.newSilentAnnotation(HighlightSeverity.INFORMATION).range(element).textAttributes(WGSLColours.FIELD.attributes()).create();
        } else if(element instanceof WGSLAttributeName) {
            String name = WGSLPsiImplUtil.getName(element);
            if(ATTRIBUTE_NAMES.contains(name) || STAGE_NAMES.contains(name)) {
                holder.newSilentAnnotation(HighlightSeverity.INFORMATION).range(element).textAttributes(WGSLColours.ATTRIBUTE.attributes()).create();
                // TODO: implement validations for attribute values
            } else {
                if(DEPRECATED_ATTRIBUTE_NAMES.contains(name)) {
                    if(annotationEnabled(element, "old-attributes")) {
                        holder.newAnnotation(HighlightSeverity.WARNING, "Deprecated attribute").range(element).create();
                    }
                } else {
                    holder.newAnnotation(HighlightSeverity.ERROR, "Unknown attribute").range(element).create();
                }
            }
        } else if(element instanceof WGSLStructMember) {
            PsiElement e = element.getLastChild();
            if(e != null) {
                @NotNull IElementType et = e.getNode().getElementType();
                if (et == WGSLTypes.SEMICOLON) {
                    if(annotationEnabled(element, "old-struct-syntax")) {
                        holder.newAnnotation(HighlightSeverity.WARNING, "Semicolon is deprecated, replace with comma").range(e).create();
                    }
                }

                PsiElement sib = element.getNextSibling();
                while(sib != null && sib instanceof PsiWhiteSpace) {
                    sib = sib.getNextSibling();
                }
                if(sib instanceof WGSLStructMember) {
                    // handle the case where there is no comma between struct members
                    if(et != WGSLTypes.SEMICOLON && et != WGSLTypes.COMMA) {
                        holder.newAnnotation(HighlightSeverity.ERROR, "Comma expected").range(element).create();
                    }
                }
            }
        } else if(element instanceof WGSLAttributeList) {
            if(element.getFirstChild().getNode().getElementType() == WGSLTypes.ATTR_LEFT) {
                if(annotationEnabled(element, "old-attribute-syntax")) {
                    holder.newAnnotation(HighlightSeverity.WARNING, "Deprecated attribute syntax").range(element).create();
                }
            }
        } else if(element instanceof WGSLGlobalConstantDecl) {
            for(ASTNode node : element.getNode().getChildren(null)) {
                if(node.getElementType() == WGSLTypes.LET) {
                    if(annotationEnabled(element, "old-global-constant-decl")) {
                        holder.newAnnotation(HighlightSeverity.WARNING, "Deprecated global constant syntax").range(element).create();
                    }
                    break;
                }
            }
        }
    }

    private boolean annotationEnabled(PsiElement element, String name) {
        PsiFile file = element.getContainingFile();
        if(file != null) {
            PsiElement first = file.getFirstChild();
            if(first != null) {
                ASTNode node = first.getNode();
                if (node.getElementType() == WGSLTypes.LINE_COMMENT) {
                    String txt = node.getText();
                    if(txt != null && txt.startsWith("//+")) {
                        return !txt.contains(name);
                    }
                }
            }
        }
        return true;
    }
}

package wgslplugin.language;

import com.intellij.lang.ASTNode;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wgslplugin.language.psi.*;
import wgslplugin.language.psi.impl.WGSLPsiImplUtil;
import wgslplugin.language.psi.impl.WGSLStructFieldImpl;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class WGSLAnnotator implements Annotator {

    public static final Set<String> BUILT_IN_FUNCTION_NAMES = names(
            // logical builtins
              "all", "any", "select"
            // array builtins
            , "arrayLength"
            // float builtins
            , "abs", "acos", "asin", "atan", "atan2", "ceil", "clamp", "cos", "cosh", "cross"
            , "distance", "exp", "exp2", "faceForward", "floor", "fma", "fract", "frexp"
            , "frexp", "inverseSqrt", "ldexp", "length", "log", "log2", "max", "min", "mix"
            , "modf", "normalize", "pow", "quantizeToF16", "reflect", "refract", "round"
            , "sign", "sin", "sinh", "smoothStep", "sqrt", "step", "tan", "tanh", "trunc"
            // integer builtins
            , "countOneBits", "reverseBits"
            // matrix builtins
            , "determinant", "transpose"
            // vector builtins
            , "dot"
            // texture builtins
            , "textureDimensions", "textureLoad", "textureNumLayers", "textureNumLevels", "textureNumSamples"
            , "textureSample", "textureSampleBias", "textureSampleCompare", "textureSampleCompareLevel"
            , "textureSampleGrad", "textureSampleLevel", "textureStore"
            // atomic builtins
            , "atomicLoad", "atomicStore"
            , "atomicAdd", "atomicSub", "atomicMax", "atomicMin", "atomicAnd", "atomicOr", "atomicXor"
            , "atomicExchange", "atomicCompareExchangeWeak"
            // data packing builtins
            , "pack4x8snorm", "pack4x8unorm", "pack2x16snorm", "pack2x16unorm", "pack2x16float"
            , "unpack4x8snorm", "unpack4x8unorm", "unpack2x16snorm", "unpack2x16unorm", "unpack2x16float"
            // synchronization builtins
            , "storageBarrier", "workgroupBarrier"
    );

    public static final Set<String> FRAGMENT_SHADER_ONLY_BUILTINS = names(
            "dpdx", "dpdxCoarse", "dpdxFine", "dpdy", "dpdyCoarse", "dpdyFine", "fwidth", "fwidthCoarse", "fwidthFine"
    );

    public static final Set<String> TEXEL_FORMATS = names(
            "r8unorm", "r8snorm", "r8uint", "r8sint", "r16uint", "r16sint", "r16float", "rg8unorm", "rg8snorm", "rg8uint",
            "rg8sint", "r32uint", "r32sint", "r32float", "rg16uint", "rg16sint", "rg16float", "rgba8unorm", "rgba8unorm_srgb",
            "rgba8snorm", "rgba8uint", "rgba8sint", "bgra8unorm", "bgra8unorm_srgb", "rgb10a2unorm", "rg11b10float", "rg32uint",
            "rg32sint", "rg32float", "rgba16uint", "rgba16sint", "rgba16float", "rgba32uint", "rgba32sint", "rgba32float"
    );

    public static final Set<String> ACCESS_MODES = names("read", "write", "read_write");

    public static final Set<String> ATTRIBUTE_NAMES = names(
            "align", "binding", "builtin", "group", "id", "interpolate", "invariant", "location", "size", "stage", "workgroup_size"
    );

    public static final Set<String> RESERVED_KEYWORDS = names(
            "AppendStructuredBuffer", "BlendState", "Buffer", "ByteAddressBuffer", "CompileShader", "ComputeShader", "ConsumeStructuredBuffer", "DepthStencilState", "DepthStencilView",
            "DomainShader", "GeometryShader", "Hullshader", "InputPatch", "LineStream", "NULL", "OutputPatch", "PixelShader", "PointStream", "RWBuffer", "RWByteAddressBuffer", "RWStructuredBuffer", "RWTexture1D", "RWTexture1DArray", "RWTexture2D", "RWTexture2DArray", "RWTexture3D", "RasterizerState", "RenderTargetView", "SamplerComparisonState", "SamplerState",
            "Self", "StructuredBuffer", "Texture1D", "Texture1DArray", "Texture2D", "Texture2DArray", "Texture2DMS", "Texture2DMSArray", "Texture3D", "TextureCube", "TextureCubeArray", "TriangleStream", "VertexShader", "abstract", "active", "alignas", "alignof", "as", "asm", "asm_fragment", "async", "atomic_uint", "attribute",
            "auto", "await", "become", "bf16", "buffer", "cast", "catch", "cbuffer", "centroid", "char", "class", "co_await", "co_return", "co_yield", "coherent", "column_major", "common", "compile", "compile_fragment", "concept", "const_cast", "consteval", "constexpr", "constinit", "crate", "debugger", "decltype",
            "delete", "demote", "demote_to_helper", "do", "dword", "dynamic_cast", "enum", "explicit", "export", "extends", "extern", "external", "f64", "filter", "final", "finally", "fixed", "flat", "friend", "from",
            "fvec2", "fvec3", "fvec4", "fxgroup", "get", "goto", "groupshared", "handle", "highp", "hvec2", "hvec3", "hvec4", "i16", "i64", "i8", "iimage1D", "iimage1DArray", "iimage2D", "iimage2DArray", "iimage2DMS", "iimage2DMSArray", "iimage2DRect", "iimage3D", "iimageBuffer",
            "iimageCube", "iimageCubeArray", "image1D", "image1DArray", "image2D", "image2DArray", "image2DMS", "image2DMSArray", "image2DRect", "image3D", "imageBuffer", "imageCube", "imageCubeArray", "impl", "implements", "import", "in", "inline", "inout", "input",
            "instanceof", "interface", "invariant", "isampler1D", "isampler1DArray", "isampler2D", "isampler2DArray", "isampler2DMS", "isampler2DMSArray", "isampler2DRect", "isampler3D", "isamplerBuffer", "isamplerCube", "isamplerCubeArray", "isubpassInput", "isubpassInputMS", "itexture1D", "itexture1DArray", "itexture2D", "itexture2DArray",
            "itexture2DMS", "itexture2DMSArray", "itexture2DRect", "itexture3D", "itextureBuffer", "itextureCube", "itextureCubeArray", "layout", "line", "lineadj", "linear", "lowp", "macro", "macro_rules", "mat", "match", "matrix", "mediump", "meta", "mod",
            "module", "move", "mut", "mutable", "namespace", "new", "nil", "noexcept", "noinline", "nointerpolation", "noperspective", "null", "nullptr", "of", "operator", "out", "output", "package", "packoffset", "partition", "pass", "patch", "pixelfragment", "point",
            "precise", "precision", "premerge", "priv", "protected", "pub", "public", "readonly", "ref", "regardless", "register", "reinterpret_cast", "requires", "resource", "restrict", "row_major", "samper", "sample", "sampler1D", "sampler1DArray", "sampler1DArrayShadow",
            "sampler1DShadow", "sampler2D", "sampler2DArray", "sampler2DArrayShadow", "sampler2DMS", "sampler2DMSArray", "sampler2DRect", "sampler2DRectShadow", "sampler2DShadow", "sampler3D", "sampler3DRect", "samplerBuffer", "samplerCube", "samplerCubeArray", "samplerCubeArrayShadow", "samplerCubeShadow", "samplerShadow", "self", "set",
            "shared", "signed", "sizeof", "smooth", "snorm", "stateblock", "stateblock_state", "static", "static_assert", "static_cast", "std", "string", "subpassInput", "subpassInputMS", "subroutine", "super", "superp", "target", "tbuffer",
            "technique", "technique10", "technique11", "template", "texture", "texture1D", "texture1DArray", "texture2D", "texture2DArray", "texture2DMS", "texture2DMSArray", "texture2DRect", "texture3D", "textureBuffer", "textureCube", "textureCubeArray", "this", "thread_local", "throw",
            "trait", "triangle", "triangleadj", "try", "typedef", "typeid", "typename", "typeof", "u16", "u64", "u8", "uimage1D", "uimage1DArray", "uimage2D", "uimage2DArray", "uimage2DMS", "uimage2DMSArray", "uimage2DRect", "uimage3D",
            "uimageBuffer", "uimageCube", "uimageCubeArray", "union", "unless", "unorm", "unsafe", "unsigned", "unsized", "usampler1D", "usampler1DArray", "usampler2D", "usampler2DArray", "usampler2DMS", "usampler2DMSArray", "usampler2DRect", "usampler3D", "usamplerBuffer", "usamplerCube",
            "usamplerCubeArray", "use", "using", "usubpassInput", "usubpassInputMS", "utexture1D", "utexture1DArray", "utexture2D", "utexture2DArray", "utexture2DMS", "utexture2DMSArray", "utexture2DRect", "utexture3D", "utextureBuffer", "utextureCube", "utextureCubeArray", "varying",
            "vec", "vector", "vertexfragment", "virtual", "void", "volatile", "wchar_t", "wgsl", "where", "with", "writeonly", "yield"
    );

    private static Set<String> names(String ... names) {
        return Arrays.stream(names).collect(Collectors.toSet());
    }

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
            @Nullable ASTNode name = call_name.findChildByType(WGSLTypes.IDENT);

            // Get the parent all the way to the function declaration
            var parent = element.getParent();
            while (parent != null && !(parent instanceof WGSLFunctionDecl)) {
                parent = parent.getParent();
            }

            // If we have a parent that was a function declaration we get the attribute list and
            // check if it contains the attribute 'stage(fragment)'
            if (parent != null) {
                var attributes = ((WGSLFunctionDecl) parent).getAttributeList();
                if(attributes != null) {
                    for (var i : attributes.getAttributeList()) {
                        fragment_shader |= (i.getText().equals("stage(fragment)"));
                    }
                }
            }

            if(name != null) {
                String txt = name.getText();
                if (BUILT_IN_FUNCTION_NAMES.contains(txt)) {
                    holder.newSilentAnnotation(HighlightSeverity.INFORMATION).range(name).textAttributes(WGSLColours.BUILTIN_FUNCTION.attributes()).create();
                } else if (FRAGMENT_SHADER_ONLY_BUILTINS.contains(txt)) {
                    if (fragment_shader) {
                        holder.newSilentAnnotation(HighlightSeverity.INFORMATION).range(name).textAttributes(WGSLColours.BUILTIN_FUNCTION.attributes()).create();
                    } else {
                        holder.newAnnotation(HighlightSeverity.ERROR, "This build-in is only allowed in fragment shader functions").range(name).create();
                    }
                }
            }
        } else if(element instanceof WGSLFunctionName) {
            holder.newSilentAnnotation(HighlightSeverity.INFORMATION).range(element).textAttributes(WGSLColours.FUNCTION_NAME.attributes()).create();
        } else if(element instanceof WGSLFieldIdent) {
            holder.newSilentAnnotation(HighlightSeverity.INFORMATION).range(element).textAttributes(WGSLColours.FIELD.attributes()).create();
        } else if(element instanceof WGSLTexelFormat) {
            String name = WGSLPsiImplUtil.getName(element);
            if(TEXEL_FORMATS.contains(name)) {
                holder.newSilentAnnotation(HighlightSeverity.INFORMATION).range(element).textAttributes(WGSLColours.TEXEL_FORMAT.attributes()).create();
            } else {
                holder.newAnnotation(HighlightSeverity.ERROR, "Invalid texel format").range(element).create();
            }
        } else if(element instanceof WGSLAccessMode) {
            String name = WGSLPsiImplUtil.getName(element);
            if(ACCESS_MODES.contains(name)) {
                holder.newSilentAnnotation(HighlightSeverity.INFORMATION).range(element).textAttributes(WGSLColours.KEYWORD.attributes()).create();
            } else {
                holder.newAnnotation(HighlightSeverity.ERROR, "Invalid access mode").range(element).create();
            }
        } else if(element instanceof WGSLAttributeName) {
            String name = WGSLPsiImplUtil.getName(element);
            if(ATTRIBUTE_NAMES.contains(name)) {
                holder.newSilentAnnotation(HighlightSeverity.INFORMATION).range(element).textAttributes(WGSLColours.ATTRIBUTE.attributes()).create();
                // TODO: implement validations for attribute values
            } else {
                holder.newAnnotation(HighlightSeverity.ERROR, "Unknown attribute").range(element).create();
            }
        }
    }
}

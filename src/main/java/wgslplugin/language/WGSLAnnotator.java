package wgslplugin.language;

import com.intellij.lang.ASTNode;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wgslplugin.language.psi.WGSLFuncCallStatement;
import wgslplugin.language.psi.WGSLTypes;

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

    private static Set<String> names(String ... names) {
        return Arrays.stream(names).collect(Collectors.toSet());
    }

    @Override
    public void annotate(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
        if(element instanceof WGSLFuncCallStatement) {
            @Nullable ASTNode name = element.getNode().findChildByType(WGSLTypes.IDENT);

            if(name != null) {
                String txt = name.getText();
                if (BUILT_IN_FUNCTION_NAMES.contains(txt)) {
                    holder.newSilentAnnotation(HighlightSeverity.INFORMATION).range(name).textAttributes(WGSLColours.BUILTIN_FUNCTION.attributes()).create();
                } else if (FRAGMENT_SHADER_ONLY_BUILTINS.contains(txt)) {
                    // TODO: determine if we are in a fragment shader
                    holder.newSilentAnnotation(HighlightSeverity.INFORMATION).range(name).textAttributes(WGSLColours.BUILTIN_FUNCTION.attributes()).create();
                }
            }
        }
    }
}

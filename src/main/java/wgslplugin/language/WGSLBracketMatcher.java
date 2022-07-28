package wgslplugin.language;

import static wgslplugin.language.psi.WGSLTypes.*;

import com.intellij.lang.BracePair;
import com.intellij.lang.PairedBraceMatcher;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class WGSLBracketMatcher implements PairedBraceMatcher {
    private static final BracePair[] PAIRS = new BracePair[]{
            new BracePair(ATTR_LEFT, ATTR_RIGHT, true),
            new BracePair(BRACE_LEFT, BRACE_RIGHT, true),
            new BracePair(BRACKET_LEFT, BRACKET_RIGHT, true),
            new BracePair(PAREN_LEFT, PAREN_RIGHT, true),
            new BracePair(LESS_THAN, GREATER_THAN, false),
    };

    @Override
    public BracePair @NotNull [] getPairs() {
        return PAIRS;
    }

    @Override
    public boolean isPairedBracesAllowedBeforeType(@NotNull IElementType lbraceType, @Nullable IElementType contextType) {
        return true;
    }

    @Override
    public int getCodeConstructStart(PsiFile file, int openingBraceOffset) {
        return openingBraceOffset;
    }
}

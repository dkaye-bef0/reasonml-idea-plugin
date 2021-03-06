package com.reason.ide.match;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import com.intellij.lang.BracePair;
import com.intellij.lang.PairedBraceMatcher;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import com.reason.lang.ocaml.OclTypes;

public class OclPairedBraceMatcher implements PairedBraceMatcher {
    private static BracePair[] PAIRS = new BracePair[]{//
            new BracePair(OclTypes.INSTANCE.LBRACE, OclTypes.INSTANCE.RBRACE, true), //
            new BracePair(OclTypes.INSTANCE.STRUCT, OclTypes.INSTANCE.END, true),//
            new BracePair(OclTypes.INSTANCE.SIG, OclTypes.INSTANCE.END, true), //
            new BracePair(OclTypes.INSTANCE.LPAREN, OclTypes.INSTANCE.RPAREN, true),
            new BracePair(OclTypes.INSTANCE.LBRACKET, OclTypes.INSTANCE.RBRACKET, true),
            new BracePair(OclTypes.INSTANCE.LARRAY, OclTypes.INSTANCE.RARRAY, true),};

    @NotNull
    @Override
    public BracePair[] getPairs() {
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

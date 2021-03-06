package com.reason.lang.core;

import com.intellij.openapi.util.TextRange;
import com.intellij.openapi.util.io.FileUtilRt;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiWhiteSpace;
import com.intellij.psi.tree.IElementType;
import com.reason.lang.core.psi.PsiNamedElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Locale;

public class PsiUtil {

    private PsiUtil() {
    }

    @NotNull
    public static String fileNameToModuleName(@NotNull PsiFile file) {
        return fileNameToModuleName(file.getName());
    }

    @NotNull
    static String moduleNameToFileName(@NotNull String name) {
        if (name.isEmpty()) {
            return name;
        }
        return name.substring(0, 1).toLowerCase(Locale.getDefault()) + name.substring(1);
    }

    @NotNull
    public static String fileNameToModuleName(@NotNull String filename) {
        String nameWithoutExtension = FileUtilRt.getNameWithoutExtension(filename);
        if (nameWithoutExtension.isEmpty()) {
            return "";
        }
        return nameWithoutExtension.substring(0, 1).toUpperCase(Locale.getDefault()) + nameWithoutExtension.substring(1);
    }

    @NotNull
    public static TextRange getTextRangeForReference(@NotNull PsiNamedElement name) {
        PsiElement nameIdentifier = name.getNameIdentifier();
        return rangeInParent(name.getTextRange(), nameIdentifier == null ? TextRange.EMPTY_RANGE : name.getTextRange());
    }

    @Nullable
    public static PsiElement nextSiblingWithTokenType(@NotNull PsiElement root, @NotNull IElementType elementType) {
        PsiElement found = null;

        PsiElement sibling = root.getNextSibling();
        while (sibling != null) {
            if (sibling.getNode().getElementType() == elementType) {
                found = sibling;
                sibling = null;
            } else {
                sibling = sibling.getNextSibling();
            }
        }

        return found;
    }

    public static String getTextUntilTokenType(@NotNull PsiElement root, @NotNull IElementType elementType) {
        String text = root.getText();

        PsiElement sibling = root.getNextSibling();
        while (sibling != null) {
            if (sibling.getNode().getElementType() == elementType) {
                sibling = null;
            } else {
                text += sibling.getText();
                sibling = sibling.getNextSibling();
            }
        }

        return text;
    }

    @NotNull
    private static TextRange rangeInParent(@NotNull TextRange parent, @NotNull TextRange child) {
        int start = child.getStartOffset() - parent.getStartOffset();
        if (start < 0) {
            return TextRange.EMPTY_RANGE;
        }

        return TextRange.create(start, start + child.getLength());
    }

    @Nullable
    public static PsiElement nextSibling(@NotNull PsiElement element) {
        PsiElement nextSibling = element.getNextSibling();
        while (nextSibling instanceof PsiWhiteSpace) {
            nextSibling = nextSibling.getNextSibling();
        }
        return nextSibling;
    }

    @Nullable
    public static <T> T nextSiblingOfClass(@NotNull PsiElement element, @NotNull Class<T> clazz) {
        PsiElement nextSibling = element.getNextSibling();
        while (nextSibling != null && !(nextSibling.getClass().isAssignableFrom(clazz))) {
            nextSibling = nextSibling.getNextSibling();
        }
        return nextSibling != null && nextSibling.getClass().isAssignableFrom(clazz) ? (T) nextSibling : null;
    }
}

package com.reason.ide.insight.provider;

import com.intellij.codeInsight.completion.CompletionParameters;
import com.intellij.codeInsight.completion.CompletionProvider;
import com.intellij.codeInsight.completion.CompletionResultSet;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiWhiteSpace;
import com.intellij.psi.tree.IElementType;
import com.intellij.util.ProcessingContext;
import com.intellij.util.PsiIconUtil;
import com.reason.Platform;
import com.reason.icons.Icons;
import com.reason.ide.files.OclFile;
import com.reason.lang.MlTypes;
import com.reason.lang.core.ModulePath;
import com.reason.lang.core.RmlPsiUtil;
import com.reason.lang.core.psi.PsiModule;
import com.reason.lang.core.psi.PsiModuleName;
import com.reason.lang.core.psi.PsiOpen;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static com.reason.lang.core.MlFileType.implementationOnly;

public class ModuleCompletionProvider extends CompletionProvider<CompletionParameters> {
    private final MlTypes m_types;

    public ModuleCompletionProvider(MlTypes types) {
        m_types = types;
    }

    @Override
    protected void addCompletions(@NotNull CompletionParameters parameters, ProcessingContext context, @NotNull CompletionResultSet resultSet) {
        Project project = parameters.getOriginalFile().getProject();
        PsiElement originalPosition = parameters.getOriginalPosition();

        PsiElement cursorElement = originalPosition;

        // PsiWhite after a DOT
        if (originalPosition instanceof PsiWhiteSpace) {
            PsiElement prevSibling = originalPosition.getPrevSibling();
            if (prevSibling instanceof PsiOpen) {
                cursorElement = prevSibling.getLastChild();
            }
        }
        // from VALUE_NAME to PsiName
        else if (originalPosition != null && originalPosition.getNode().getElementType() == m_types.VALUE_NAME) {
            cursorElement = originalPosition.getParent();
        }

        // Compute module path (all module names before the last dot)
        List<PsiModuleName> moduleNames = new ArrayList<>();
        PsiElement previousSibling = cursorElement == null ? null : cursorElement.getPrevSibling();
        if (previousSibling != null) {
            IElementType previousElementType = previousSibling.getNode().getElementType();
            while (previousElementType == m_types.DOT || previousElementType == m_types.MODULE_NAME) {
                if (previousSibling instanceof PsiModuleName) {
                    moduleNames.add((PsiModuleName) previousSibling);
                }
                previousSibling = previousSibling.getPrevSibling();
                previousElementType = previousSibling == null ? null : previousSibling.getNode().getElementType();
            }
        }
        Collections.reverse(moduleNames);
        ModulePath modulePath = new ModulePath(moduleNames);

        if (modulePath.isEmpty()) {
            // First module to complete, use the list of files
            List<PsiModule> modules = RmlPsiUtil.findFileModules(project);
            if (!modules.isEmpty()) {
                for (PsiModule module : modules) {
                    resultSet.addElement(
                            LookupElementBuilder.create(module).
                                    withTypeText(Platform.removeProjectDir(project, module.getContainingFile().getVirtualFile())).
                                    withIcon(module.getContainingFile() instanceof OclFile ? Icons.OCL_FILE : Icons.RML_FILE)
                    );
                }
            }
        } else {
            String latestModuleName = modulePath.getLatest();
            Collection<PsiModule> modules = RmlPsiUtil.findModules(project, latestModuleName, implementationOnly);
            if (!modules.isEmpty()) {
                for (PsiModule module : modules) {
                    for (PsiModule expression : module.getModules()) {
                        resultSet.addElement(
                                LookupElementBuilder.create(expression).
                                        withIcon(PsiIconUtil.getProvidersIcon(expression, 0))
                        );
                    }
                }
            }
        }

    }
}
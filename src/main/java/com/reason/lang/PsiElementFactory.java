package com.reason.lang;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.IElementType;
import com.reason.lang.core.psi.*;
import com.reason.lang.core.psi.impl.*;
import com.reason.lang.core.psi.type.MlTypes;

public class PsiElementFactory {
    private PsiElementFactory() {
    }

    public static PsiElement createElement(MlTypes types, ASTNode node) {
        IElementType type = node.getElementType();

        if (type == types.EXTERNAL_STMT) {
            return new PsiExternalImpl(types, node);
        } else if (type == types.EXCEPTION_EXPR) {
            return new PsiExceptionImpl(node);
        } else if (type == types.OPEN_STMT) {
            return new PsiOpenImpl(types, node);
        } else if (type == types.INCLUDE_STMT) {
            return new PsiIncludeImpl(types, node);
        } else if (type == types.EXP_TYPE) {
            return new PsiTypeImpl(node);
        } else if (type == types.ASSERT_STMT) {
            return new PsiAssert(node);
        } else if (type == types.IF_STMT) {
            return new PsiIfStatement(node);
        } else if (type == types.BIN_CONDITION) {
            return new PsiBinaryCondition(node);
        } else if (type == types.TYPE_CONSTR_NAME) {
            return new PsiTypeConstrName(node);
        } else if (type == types.TYPE_BINDING) {
            return new PsiTypeBinding(node);
        } else if (type == types.MODULE_STMT) {
            return new PsiModuleImpl(node, types);
        } else if (type == types.MODULE_PATH) {
            return new PsiModulePath(node);
        } else if (type == types.LET_STMT) {
            return new PsiLetImpl(types, node);
        } else if (type == types.VAL_EXPR) {
            return new PsiValImpl(types, node);
        } else if (type == types.ANNOTATION_EXPR) {
            return new PsiAnnotation(node);
        } else if (type == types.LET_BINDING) {
            return new PsiLetBinding(node);
        } else if (type == types.FUN_PARAMS) {
            return new PsiParametersImpl(types, node);
        } else if (type == types.MACRO_NAME) {
            return new PsiMacroName(node);
        } else if (type == types.SCOPED_EXPR) {
            return new PsiScopedExpr(node);
        } else if (type == types.LOCAL_OPEN) {
            return new PsiLocalOpen(node, types);
        } else if (type == types.PATTERN_MATCH_EXPR) {
            return new PsiPatternMatch(node);
        } else if (type == types.RECORD_EXPR) {
            return new PsiRecord(node);
        } else if (type == types.RECORD_FIELD) {
            return new PsiRecordField(node);
        } else if (type == types.INTERPOLATION_EXPR) {
            return new PsiInterpolation(node);
        } else if (type == types.SIG_SCOPE) {
            return new PsiSignatureImpl(node);
        } else if (type == types.TAG_START) {
            return new PsiTagStartImpl(node);
        } else if (type == types.TAG_PROPERTY) {
            return new PsiTagPropertyImpl(types, node);
        } else if (type == types.TAG_CLOSE) {
            return new PsiTagClose(node);
        } else if (type == types.UPPER_SYMBOL) {
            return new PsiUpperSymbolImpl(types, node);
        } else if (type == types.LOWER_SYMBOL) {
            return new PsiLowerSymbolImpl(types, node);
        } else if (type == types.NAMED_SYMBOL) {
            return new PsiNamedSymbol(node);
        } else if (type == types.TRY_EXPR) {
            return new PsiTry(types, node);
        } else if (type == types.SWITCH_EXPR || type == types.MATCH_EXPR) {
            return new PsiSwitch(node);
        } else if (type == types.FUN_EXPR) {
            return new PsiFunction(node);
        } else if (type == types.FUN_BODY) {
            return new PsiFunctionBody(node);
        } else if (type == types.STRUCT_EXPR) {
            return new PsiStruct(node);
        }

        return new PsiToken(node);
    }
}

package com.reason.lang.ocaml;

import com.intellij.psi.PsiFile;
import com.intellij.psi.util.PsiTreeUtil;
import com.reason.BaseParsingTestCase;
import com.reason.lang.core.psi.PsiIfStatement;
import com.reason.lang.core.psi.PsiScopedExpr;

import java.util.ArrayList;
import java.util.List;

public class IfParsingTest extends BaseParsingTestCase {
    public IfParsingTest() {
        super("", "re", new OclParserDefinition());
    }

    public void testBasicIfParsing() {
        PsiFile psiFile = parseCode("let _ = if x then ()", true);
        PsiIfStatement e = firstOfType(psiFile, PsiIfStatement.class);

        assertNotNull(e);
        assertNotNull(e.getBinaryCondition());
        PsiScopedExpr ifScope = PsiTreeUtil.findChildOfType(e, PsiScopedExpr.class);
        assertNotNull(ifScope);
        assertEquals("()", ifScope.getText());
    }

    public void testBasicIfElseParsing() {
        PsiFile psiFile = parseCode("let _ = if x then 1 else 2");
        PsiIfStatement e = firstOfType(psiFile, PsiIfStatement.class);

        assertNotNull(e);
        assertNotNull(e.getBinaryCondition());
        List<PsiScopedExpr> scopes = new ArrayList<>(PsiTreeUtil.findChildrenOfType(e, PsiScopedExpr.class));
        assertEquals(2, scopes.size());
        assertEquals("1", scopes.get(0).getText());
        assertEquals("2", scopes.get(1).getText());
    }

    public void testIfWithIn() {
        PsiFile file = parseCode("let _ =  if x then let init = y in let data = z", true);

        assertEquals(1, letExpressions(file).size());
        assertNotNull(firstOfType(file, PsiIfStatement.class));
    }

}

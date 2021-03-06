package com.reason.lang.ocaml;

import com.reason.BaseParsingTestCase;
import com.reason.lang.core.psi.PsiLet;

public class BeginParsingTest extends BaseParsingTestCase {
    public BeginParsingTest() {
        super("", "ml", new OclParserDefinition());
    }

    public void testBasic() {
        PsiLet exp = (PsiLet) first(expressions(parseCode("let _ = begin end", true)));

        assertNotNull(exp);
        assertEquals("begin end", exp.getBinding().getText());
    }

}

package com.reason.lang.reason;

import com.intellij.psi.PsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import com.reason.BaseParsingTestCase;
import com.reason.lang.core.psi.*;

import java.util.Collection;
import java.util.Iterator;

public class JsxParsingTest extends BaseParsingTestCase {
    public JsxParsingTest() {
        super("", "re", new RmlParserDefinition());
    }

    public void testOptionAsTag() {
        // option here is not a ReasonML keyword
        PsiLet let = first(letExpressions(parseCode("let _ = <option className/>")));

        PsiTagStart jsx = first(PsiTreeUtil.findChildrenOfType(let, PsiTagStart.class));
        assertNotNull(jsx);
    }

    public void testTagNameWithDot() {
        // option here is not a ReasonML keyword
        PsiLet let = first(letExpressions(parseCode("let _ = <Container.Test></Container.Test>")));

        PsiTagStart tagStart = first(PsiTreeUtil.findChildrenOfType(let, PsiTagStart.class));
        PsiElement nextSibling = tagStart.getFirstChild().getNextSibling();
        assertEquals(RmlTypes.INSTANCE.TAG_NAME, nextSibling.getFirstChild().getNode().getElementType());
        nextSibling = nextSibling.getNextSibling().getNextSibling();
        assertEquals(RmlTypes.INSTANCE.TAG_NAME, nextSibling.getFirstChild().getNode().getElementType());

        PsiTagClose tagClose = first(PsiTreeUtil.findChildrenOfType(let, PsiTagClose.class));
        nextSibling = tagClose.getFirstChild().getNextSibling();
        assertEquals(RmlTypes.INSTANCE.TAG_NAME, nextSibling.getFirstChild().getNode().getElementType());
        nextSibling = nextSibling.getNextSibling().getNextSibling();
        assertEquals(RmlTypes.INSTANCE.TAG_NAME, nextSibling.getFirstChild().getNode().getElementType());
    }

    public void testTagPropWithParen() {
        PsiTagStart tag = (PsiTagStart) firstElement(parseCode("<div style=(x) onFocus=a11y.onFocus/>", true));

        Collection<PsiTagProperty> properties = PsiTreeUtil.findChildrenOfType(tag, PsiTagProperty.class);
        assertEquals(2, properties.size());
        Iterator<PsiTagProperty> itProperties = properties.iterator();
        assertEquals("style=(x)", itProperties.next().getText());
        assertEquals("onFocus=a11y.onFocus", itProperties.next().getText());
    }

    public void testTagPropsWithDot() {
        PsiElement psiElement = firstElement(parseCode("<a className=Styles.link href=h download=d>"));

        Collection<PsiTagProperty> props = PsiTreeUtil.findChildrenOfType(psiElement, PsiTagProperty.class);
        assertEquals(3, props.size());
    }

    public void testTagChaining() {
        Collection<PsiModule> psiModules = moduleExpressions(parseCode("module GalleryItem = { let make = () => { let x = <div/>; }; };\nmodule GalleryContainer = {};"));
        assertEquals(2, psiModules.size());
    }
}

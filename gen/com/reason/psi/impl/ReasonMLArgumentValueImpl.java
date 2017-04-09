// This is a generated file. Not intended for manual editing.
package com.reason.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.reason.psi.ReasonMLTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.reason.psi.*;

public class ReasonMLArgumentValueImpl extends ASTWrapperPsiElement implements ReasonMLArgumentValue {

  public ReasonMLArgumentValueImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ReasonMLVisitor visitor) {
    visitor.visitArgumentValue(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ReasonMLVisitor) accept((ReasonMLVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public ReasonMLField getField() {
    return findChildByClass(ReasonMLField.class);
  }

  @Override
  @Nullable
  public ReasonMLUntypedObject getUntypedObject() {
    return findChildByClass(ReasonMLUntypedObject.class);
  }

  @Override
  @NotNull
  public ReasonMLValueName getValueName() {
    return findNotNullChildByClass(ReasonMLValueName.class);
  }

}
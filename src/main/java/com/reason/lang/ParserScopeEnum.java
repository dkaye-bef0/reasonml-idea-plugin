package com.reason.lang;

public enum ParserScopeEnum {
    file,

    open,
    include,

    localOpen,
    localOpenScope,

    external,
    externalNamed,
    externalNamedSignature,

    type,
    typeConstrName,
    typeNamed,
    typeNamedEq,
    typeNamedEqVariant,

    module,
    moduleNamed,
    moduleNamedEq,
    moduleNamedColon,
    moduleNamedSignature,
    moduleSignature,
    moduleBinding,

    modulePath,

    let,
    letNamed,
    letNamedEq,
    letNamedParametersEq,
    letNamedSignature,
    letNamedBinding,

    function,
    parameters,
    functionBody,

    val,
    valNamed,
    valNamedSignature,

    startTag,
    closeTag,
    tagProperty,
    tagPropertyEq,

    annotation,
    annotationName,
    macro,
    macroName,

    maybeRecord,
    recordBinding,
    recordField,
    recordSignature,

    paren,
    brace,
    bracket,

    jsObject,

    exception,
    exceptionNamed,

    if_,
    binaryCondition,
    ifThenStatement,
    match,
    matchBinaryCondition,
    matchWith,
    switch_,
    switchBinaryCondition,
    switchBody,
    patternMatchBody,

    try_,
    tryScope,
    tryBinaryCondition,

    patternMatch,

    multilineStart,
    interpolationStart,
    interpolationString,

    namedSymbol,
    namedSymbolSignature,

    genericExpression,

    assert_,
    assertScope,

    sexpr,
    library,
    executable,
    maybeLetFunction,
    maybeLetFunctionParameters,
    valNamedSymbol, struct, matchException, beginScope, ifElseStatement, bracketGt, moduleDeclaration, moduleInstanciation, tryWith, moduleNamedColonWith, moduleNamedWithType, doLoop, tryWithScope, letBinding, scope, moduleNamedSignatureEq, array, signature, name
}

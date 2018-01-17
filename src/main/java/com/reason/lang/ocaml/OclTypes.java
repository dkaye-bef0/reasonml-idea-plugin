package com.reason.lang.ocaml;

import com.intellij.psi.tree.IElementType;
import com.reason.lang.MlTypes;
import com.reason.lang.core.stub.type.ModuleStubElementType;
import com.reason.lang.core.stub.type.PsiLetStubElementType;
import com.reason.lang.core.stub.type.PsiTypeElementType;

public class OclTypes extends MlTypes {

    public static final OclTypes INSTANCE = new OclTypes();

    private OclTypes() {
        FILE_MODULE = new IElementType("FILE_MODULE", OclLanguage.INSTANCE);

        ANNOTATION_EXPRESSION = new OclElementType("ANNOTATION_EXPRESSION");
        EXTERNAL_EXPRESSION = new OclElementType("EXTERNAL_EXPRESSION");
        EXCEPTION_EXPRESSION = new OclElementType("EXCEPTION_EXPRESSION");
        EXCEPTION_NAME = new OclElementType("EXCEPTION_NAME");
        INCLUDE_EXPRESSION = new OclElementType("INCLUDE_EXPRESSION");
        LET_EXPRESSION = new PsiLetStubElementType("LET_EXPRESSION", OclLanguage.INSTANCE);
        MACRO_EXPRESSION = new OclElementType("MACRO_EXPRESSION");
        MACRO_NAME = new OclElementType("MACRO_NAME");
        MODULE_EXPRESSION = new ModuleStubElementType("MODULE_EXPRESSION", OclLanguage.INSTANCE);
        MODULE_NAME = new OclElementType("MODULE_NAME");
        MODULE_PATH = new OclElementType("MODULE_PATH");
        OPEN_EXPRESSION = new OclElementType("OPEN_EXPRESSION");
        TYPE_EXPRESSION = new PsiTypeElementType("TYPE_EXPRESSION", OclLanguage.INSTANCE, OclTypes.INSTANCE);
        VAL_EXPRESSION = new PsiLetStubElementType("VAL_EXPRESSION", OclLanguage.INSTANCE);

        LET_FUN_PARAMS = new OclElementType("LET_FUN_PARAMS");
        LET_BINDING = new OclElementType("LET_BINDING");
        TYPE_CONSTR_NAME = new OclElementType("TYPE_CONSTR_NAME");
        PATTERN_MATCH_EXPR = new OclElementType("PATTERN_MATCH_EXPR");
        OBJECT_EXPR = new OclElementType("OBJECT_EXPR");
        SCOPED_EXPR = new OclElementType("SCOPED_EXPR");
        SIG_SCOPE = new OclElementType("SIG_SCOPE");
        VALUE_NAME = new OclElementType("VALUE_NAME");
        PROPERTY_NAME = new OclElementType("PROPERTY_NAME");
        FUNCTOR_PARAMS = new OclElementType("FUNCTOR_PARAMS");

        AND = new OclTokenType("AND");
        ANDAND = new OclTokenType("ANDAND");
        ARROBASE = new OclTokenType("ARROBASE");
        ARROW = new OclTokenType("ARROW");
        ASSERT = new OclTokenType("ASSERT");
        AS = new OclTokenType("AS");
        BACKTICK = new OclTokenType("BACKTICK");
        BEGIN = new OclTokenType("BEGIN");
        CARRET = new OclTokenType("CARRET");
        COLON = new OclTokenType("COLON");
        COMMA = new OclTokenType("COMMA");
        COMMENT = new OclTokenType("COMMENT");
        DIFF = new OclTokenType("DIFF");
        DOLLAR = new OclTokenType("DOLLAR");
        DOT = new OclTokenType("DOT");
        DOTDOTDOT = new OclTokenType("DOTDOTDOT");
        DO = new OclTokenType("DO");
        DONE = new OclTokenType("DONE");
        ELSE = new OclTokenType("ELSE");
        END = new OclTokenType("END");
        NOT_EQ = new OclTokenType("EQ");
        NOT_EQEQ = new OclTokenType("EQEQ");
        EQ = new OclTokenType("EQ");
        EQEQ = new OclTokenType("EQEQ");
        EQEQEQ = new OclTokenType("EQEQEQ");
        EXCEPTION = new OclTokenType("EXCEPTION");
        EXCLAMATION_MARK = new OclTokenType("EXCLAMATION_MARK");
        EXTERNAL = new OclTokenType("EXTERNAL");
        FALSE = new OclTokenType("FALSE");
        FLOAT = new OclTokenType("FLOAT");
        CHAR = new OclElementType("CHAR");
        FOR = new OclElementType("FOR");
        FUN = new OclTokenType("FUN");
        FUN_PARAMS = new OclTokenType("FUN_PARAMS");
        FUN_BODY = new OclTokenType("FUN_BODY");
        FUNCTION = new OclTokenType("FUNCTION");
        TYPE_ARGUMENT = new OclTokenType("TYPE_ARGUMENT");
        GT = new OclTokenType("GT");
        IF = new OclTokenType("IF");
        BIN_CONDITION = new OclTokenType("BIN_CONDITION");
        IN = new OclElementType("IN");
        LAZY = new OclElementType("LAZY");
        INCLUDE = new OclTokenType("INCLUDE");
        INT = new OclTokenType("INT");
        LARRAY = new OclTokenType("LARRAY");
        LBRACE = new OclTokenType("LBRACE");
        LBRACKET = new OclTokenType("LBRACKET");
        LET = new OclTokenType("LET");
        LIDENT = new OclTokenType("LIDENT");
        LIST = new OclTokenType("LIST");
        LPAREN = new OclTokenType("LPAREN");
        LT = new OclTokenType("LT");
        MATCH = new OclTokenType("MATCH");
        MINUS = new OclTokenType("MINUS");
        MINUSDOT = new OclTokenType("MINUSDOT");
        MODULE = new OclTokenType("MODULE");
        MUTABLE = new OclTokenType("MUTABLE");
        NONE = new OclTokenType("NONE");
        OBJECT = new OclElementType("OBJECT");
        OF = new OclElementType("OF");
        OPEN = new OclTokenType("OPEN");
        OPTION = new OclTokenType("OPTION");
        POLY_VARIANT = new OclTokenType("POLY_VARIANT");
        PIPE = new OclTokenType("PIPE");
        PIPE_FORWARD = new OclTokenType("PIPE_FORWARD");
        PLUS = new OclTokenType("PLUS");
        PERCENT = new OclTokenType("PERCENT");
        PLUSDOT = new OclTokenType("PLUSDOT");
        QUESTION_MARK = new OclTokenType("QUESTION_MARK");
        QUOTE = new OclTokenType("QUOTE");
        RAISE = new OclElementType("RAISE");
        RARRAY = new OclTokenType("RARRAY");
        RBRACE = new OclTokenType("RBRACE");
        RBRACKET = new OclTokenType("RBRACKET");
        REC = new OclTokenType("REC");
        REF = new OclTokenType("REF");
        RPAREN = new OclTokenType("RPAREN");
        SEMI = new OclTokenType("SEMI");
        SIG = new OclTokenType("SIG");
        SIMPLE_ARROW = new OclTokenType("SIMPLE_ARROW");
        SHARP = new OclTokenType("SHARP");
        SHORTCUT = new OclTokenType("SHORTCUT");
        SLASH = new OclTokenType("SLASH");
        SLASHDOT = new OclTokenType("SLASHDOT");
        SOME = new OclTokenType("SOME");
        STAR = new OclTokenType("STAR");
        STARDOT = new OclTokenType("STARDOT");
        STRING = new OclTokenType("STRING");
        STRUCT = new OclTokenType("STRUCT");
        SWITCH = new OclTokenType("SWITCH");
        TAG_AUTO_CLOSE = new OclTokenType("TAG_AUTO_CLOSE");
        TAG_START = new OclTokenType("TAG_START");
        TAG_CLOSE = new OclTokenType("TAG_CLOSE");
        TAG_NAME = new OclTokenType("TAG_NAME");
        TAG_PROPERTY = new OclTokenType("TAG_PROPERTY");
        TAG_LT = new OclTokenType("TAG_LT");
        TAG_GT = new OclTokenType("TAG_GT");
        TILDE = new OclElementType("TILDE");
        TO = new OclElementType("TO");
        THEN = new OclTokenType("THEN");
        TRUE = new OclTokenType("TRUE");
        TRY = new OclTokenType("TRY");
        TYPE = new OclTokenType("TYPE");
        UIDENT = new OclTokenType("UIDENT");
        UNIT = new OclTokenType("UNIT");
        VAL = new OclTokenType("VAL");
        VAR_NAME = new OclTokenType("VAR_NAME");
        WHEN = new OclTokenType("WHEN");
        WHILE = new OclTokenType("WHILE");
        WITH = new OclTokenType("WITH");
    }

}

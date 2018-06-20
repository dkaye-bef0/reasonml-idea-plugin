package com.reason.lang.ocaml;

import com.reason.lang.MlTypes;
import com.reason.lang.core.stub.type.*;

public class OclTypes extends MlTypes {

    public static final OclTypes INSTANCE = new OclTypes();

    private OclTypes() {
        FILE_MODULE = new ModuleStubElementType("FILE_MODULE", OclLanguage.INSTANCE);

        ANNOTATION_EXPRESSION = new OclElementType("ANNOTATION_EXPRESSION");
        EXTERNAL_EXPRESSION = new PsiExternalStubElementType("EXTERNAL_EXPRESSION", OclLanguage.INSTANCE);
        EXCEPTION_EXPRESSION = new OclElementType("EXCEPTION_EXPRESSION");
        EXCEPTION_NAME = new OclElementType("EXCEPTION_NAME");
        INCLUDE_EXPRESSION = new OclElementType("INCLUDE_EXPRESSION");
        LET_EXPRESSION = new PsiLetStubElementType("LET_EXPRESSION", OclLanguage.INSTANCE);
        MACRO_EXPRESSION = new OclElementType("MACRO_EXPRESSION");
        MACRO_NAME = new OclElementType("MACRO_NAME");
        MODULE_EXPRESSION = new ModuleStubElementType("MODULE_EXPRESSION", OclLanguage.INSTANCE);
        UPPER_SYMBOL = new OclElementType("UPPER_SYMBOL");
        MODULE_PATH = new OclElementType("MODULE_PATH");
        OPEN_EXPRESSION = new OclElementType("OPEN_EXPRESSION");
        TYPE_EXPRESSION = new PsiTypeElementType("TYPE_EXPRESSION", OclLanguage.INSTANCE);
        VAL_EXPRESSION = new PsiValStubElementType("VAL_EXPRESSION", OclLanguage.INSTANCE);

        BOOL = new OclTokenType("BOOL");
        STRING = new OclTokenType("STRING");
        FLOAT = new OclTokenType("FLOAT");
        CHAR = new OclElementType("CHAR");
        INT = new OclTokenType("INT");

        BOOL_VALUE = new OclTokenType("BOOL_VALUE");
        STRING_VALUE = new OclTokenType("STRING_VALUE");
        FLOAT_VALUE = new OclTokenType("FLOAT_VALUE");
        CHAR_VALUE = new OclElementType("CHAR_VALUE");
        INT_VALUE = new OclTokenType("INT_VALUE");

        FUN = new OclTokenType("FUN");
        FUNCTION = new OclTokenType("FUNCTION");
        FUN_PARAMS = new OclElementType("FUN_PARAMS");
        FUN_BODY = new OclElementType("FUN_BODY");

        FUNCTOR = new OclTokenType("FUNCTOR");
        FUNCTOR_PARAMS = new OclElementType("FUNCTOR_PARAMS");

        LET_BINDING = new OclElementType("LET_BINDING");
        TYPE_CONSTR_NAME = new OclElementType("TYPE_CONSTR_NAME");
        TYPE_BINDING = new OclElementType("TYPE_BINDING");
        PATTERN_MATCH_EXPR = new OclElementType("PATTERN_MATCH_EXPR");
        SCOPED_EXPR = new OclElementType("SCOPED_EXPR");
        LOCAL_OPEN = new OclElementType("LOCAL_OPEN");
        SIG_SCOPE = new OclElementType("SIG_SCOPE");
        PROPERTY_NAME = new OclElementType("PROPERTY_NAME");
        NAMED_SYMBOL = new OclElementType("NAMED_SYMBOL");

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
        LT_OR_EQUAL = new OclTokenType("LT_OR_EQUAL");
        GT_OR_EQUAL = new OclTokenType("GT_OR_EQUAL");
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
        FOR = new OclElementType("FOR");
        TYPE_ARGUMENT = new OclTokenType("TYPE_ARGUMENT");
        GT = new OclTokenType("GT");
        IF = new OclTokenType("IF");
        BIN_CONDITION = new OclTokenType("BIN_CONDITION");
        IN = new OclElementType("IN");
        LAZY = new OclElementType("LAZY");
        INCLUDE = new OclTokenType("INCLUDE");
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
        OF = new OclElementType("OF");
        OPEN = new OclTokenType("OPEN");
        OPTION = new OclTokenType("OPTION");
        POLY_VARIANT = new OclTokenType("POLY_VARIANT");
        VARIANT = new OclTokenType("VARIANT");
        VARIANT_NAME = new OclTokenType("VARIANT_NAME");
        PIPE = new OclTokenType("PIPE");
        PIPE_FORWARD = new OclTokenType("PIPE_FORWARD");
        PIPE_FIRST = new OclTokenType("PIPE_FIRST");
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
        SHARP = new OclTokenType("SHARP");
        SHARPSHARP = new OclTokenType("SHARPSHARP");
        SHORTCUT = new OclTokenType("SHORTCUT");
        SLASH = new OclTokenType("SLASH");
        SLASHDOT = new OclTokenType("SLASHDOT");
        SOME = new OclTokenType("SOME");
        STAR = new OclTokenType("STAR");
        STARDOT = new OclTokenType("STARDOT");
        STRUCT = new OclTokenType("STRUCT");
        SWITCH = new OclTokenType("SWITCH");
        TAG_AUTO_CLOSE = new OclTokenType("TAG_AUTO_CLOSE");
        TAG_START = new OclTokenType("TAG_START");
        TAG_CLOSE = new OclTokenType("TAG_CLOSE");
        TAG_NAME = new OclTokenType("TAG_NAME");
        TAG_PROPERTY = new OclTokenType("TAG_PROPERTY");
        TAG_LT = new OclTokenType("TAG_LT");
        TAG_LT_SLASH = new OclTokenType("TAG_LT_SLASH");
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
        PUB = new OclTokenType("PUB");
        LOWER_SYMBOL = new OclTokenType("LOWER_SYMBOL");
        WHEN = new OclTokenType("WHEN");
        WHILE = new OclTokenType("WHILE");
        WITH = new OclTokenType("WITH");

        ASR = new OclTokenType("ASR");
        CLASS = new OclTokenType("CLASS");
        CONSTRAINT = new OclTokenType("CONSTRAINT");
        DOWNTO = new OclTokenType("DOWNTO");
        INHERIT = new OclTokenType("INHERIT");
        INITIALIZER = new OclTokenType("INITIALIZER");
        LAND = new OclTokenType("LAND");
        LOR = new OclTokenType("LOR");
        LSL = new OclTokenType("LSL");
        LSR = new OclTokenType("LSR");
        LXOR = new OclTokenType("LXOR");
        METHOD = new OclTokenType("METHOD");
        MOD = new OclTokenType("MOD");
        NEW = new OclTokenType("NEW");
        NONREC = new OclTokenType("NONREC");
        OR = new OclTokenType("OR");
        PRIVATE = new OclTokenType("PRIVATE");
        VIRTUAL = new OclTokenType("VIRTUAL");

        COLON_EQ = new OclTokenType("COLON_EQ");
        COLON_GT = new OclTokenType("COLON_GT");
        DOTDOT = new OclTokenType("DOTDOT");
        SEMISEMI = new OclTokenType("SEMISEMI");
        GT_BRACKET = new OclTokenType("GT_BRACKET");
        GT_BRACE = new OclTokenType("GT_BRACE");
        LEFT_ARROW = new OclTokenType("LEFT_ARROW");
        RIGHT_ARROW = new OclTokenType("RIGHT_ARROW");

        OBJECT = new OclElementType("OBJECT");
        OBJECT_FIELD = new OclElementType("OBJECT_FIELD");

        AMPERSAND = new OclTokenType("AMPERSAND");
        BRACKET_GT = new OclTokenType("BRACKET_GT");
        BRACKET_LT = new OclTokenType("BRACKET_LT");
        BRACE_LT = new OclTokenType("BRACE_LT");

        ML_STRING_OPEN = new OclTokenType("ML_STRING_OPEN");
        ML_STRING_CLOSE = new OclTokenType("ML_STRING_CLOSE");
        JS_STRING_OPEN = new OclTokenType("JS_STRING_OPEN");
        JS_STRING_CLOSE = new OclTokenType("JS_STRING_CLOSE");
        INTERPOLATION = new OclTokenType("INTERPOLATION");
    }

}

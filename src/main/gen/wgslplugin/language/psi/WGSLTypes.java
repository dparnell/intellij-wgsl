// This is a generated file. Not intended for manual editing.
package wgslplugin.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import wgslplugin.language.psi.impl.*;

public interface WGSLTypes {

  IElementType ACCESS_MODE = new WGSLElementType("ACCESS_MODE");
  IElementType ARGUMENT_EXPRESSION_LIST = new WGSLElementType("ARGUMENT_EXPRESSION_LIST");
  IElementType ARRAY_TYPE_DECL = new WGSLElementType("ARRAY_TYPE_DECL");
  IElementType ASSIGNMENT_STATEMENT = new WGSLElementType("ASSIGNMENT_STATEMENT");
  IElementType ATTRIBUTE = new WGSLElementType("ATTRIBUTE");
  IElementType ATTRIBUTE_LIST = new WGSLElementType("ATTRIBUTE_LIST");
  IElementType ATTRIBUTE_NAME = new WGSLElementType("ATTRIBUTE_NAME");
  IElementType BREAK_STATEMENT = new WGSLElementType("BREAK_STATEMENT");
  IElementType CASE_BODY = new WGSLElementType("CASE_BODY");
  IElementType CASE_SELECTORS = new WGSLElementType("CASE_SELECTORS");
  IElementType COMPOUND_ASSIGNMENT_OPERATOR = new WGSLElementType("COMPOUND_ASSIGNMENT_OPERATOR");
  IElementType COMPOUND_STATEMENT = new WGSLElementType("COMPOUND_STATEMENT");
  IElementType CONST_EXPRESSION = new WGSLElementType("CONST_EXPRESSION");
  IElementType CONST_LITERAL = new WGSLElementType("CONST_LITERAL");
  IElementType CONTINUE_STATEMENT = new WGSLElementType("CONTINUE_STATEMENT");
  IElementType CONTINUING_STATEMENT = new WGSLElementType("CONTINUING_STATEMENT");
  IElementType CORE_LHS_EXPRESSION = new WGSLElementType("CORE_LHS_EXPRESSION");
  IElementType DECREMENT_STATEMENT = new WGSLElementType("DECREMENT_STATEMENT");
  IElementType DEPTH_TEXTURE_TYPE = new WGSLElementType("DEPTH_TEXTURE_TYPE");
  IElementType DOCS = new WGSLElementType("DOCS");
  IElementType ELEMENT_COUNT_EXPRESSION = new WGSLElementType("ELEMENT_COUNT_EXPRESSION");
  IElementType ELSE_STATEMENT = new WGSLElementType("ELSE_STATEMENT");
  IElementType ENABLE_DIRECTIVE = new WGSLElementType("ENABLE_DIRECTIVE");
  IElementType EXPRESSION = new WGSLElementType("EXPRESSION");
  IElementType FIELD = new WGSLElementType("FIELD");
  IElementType FIELD_IDENT = new WGSLElementType("FIELD_IDENT");
  IElementType FLOAT_LITERAL = new WGSLElementType("FLOAT_LITERAL");
  IElementType FOR_HEADER = new WGSLElementType("FOR_HEADER");
  IElementType FOR_INIT = new WGSLElementType("FOR_INIT");
  IElementType FOR_STATEMENT = new WGSLElementType("FOR_STATEMENT");
  IElementType FOR_UPDATE = new WGSLElementType("FOR_UPDATE");
  IElementType FUNCTION_DECL = new WGSLElementType("FUNCTION_DECL");
  IElementType FUNCTION_HEADER = new WGSLElementType("FUNCTION_HEADER");
  IElementType FUNCTION_NAME = new WGSLElementType("FUNCTION_NAME");
  IElementType FUNC_CALL_NAME = new WGSLElementType("FUNC_CALL_NAME");
  IElementType FUNC_CALL_STATEMENT = new WGSLElementType("FUNC_CALL_STATEMENT");
  IElementType GLOBAL_CONSTANT_DECL = new WGSLElementType("GLOBAL_CONSTANT_DECL");
  IElementType GLOBAL_CONST_INITIALIZER = new WGSLElementType("GLOBAL_CONST_INITIALIZER");
  IElementType GLOBAL_DECL = new WGSLElementType("GLOBAL_DECL");
  IElementType GLOBAL_DIRECTIVE = new WGSLElementType("GLOBAL_DIRECTIVE");
  IElementType GLOBAL_VARIABLE_DECL = new WGSLElementType("GLOBAL_VARIABLE_DECL");
  IElementType IF_STATEMENT = new WGSLElementType("IF_STATEMENT");
  IElementType INCREMENT_STATEMENT = new WGSLElementType("INCREMENT_STATEMENT");
  IElementType LHS_EXPRESSION = new WGSLElementType("LHS_EXPRESSION");
  IElementType LITERAL_OR_IDENT = new WGSLElementType("LITERAL_OR_IDENT");
  IElementType LOOP_STATEMENT = new WGSLElementType("LOOP_STATEMENT");
  IElementType MAT_PREFIX = new WGSLElementType("MAT_PREFIX");
  IElementType MULTISAMPLED_TEXTURE_TYPE = new WGSLElementType("MULTISAMPLED_TEXTURE_TYPE");
  IElementType PARAM = new WGSLElementType("PARAM");
  IElementType PARAM_LIST = new WGSLElementType("PARAM_LIST");
  IElementType PAREN_EXPRESSION = new WGSLElementType("PAREN_EXPRESSION");
  IElementType POSTFIX_EXPRESSION = new WGSLElementType("POSTFIX_EXPRESSION");
  IElementType PRIMARY_EXPRESSION = new WGSLElementType("PRIMARY_EXPRESSION");
  IElementType RETURN_STATEMENT = new WGSLElementType("RETURN_STATEMENT");
  IElementType SAMPLED_TEXTURE_TYPE = new WGSLElementType("SAMPLED_TEXTURE_TYPE");
  IElementType SAMPLER_TYPE = new WGSLElementType("SAMPLER_TYPE");
  IElementType SINGULAR_EXPRESSION = new WGSLElementType("SINGULAR_EXPRESSION");
  IElementType STATEMENT = new WGSLElementType("STATEMENT");
  IElementType STATIC_ASSERT_STATEMENT = new WGSLElementType("STATIC_ASSERT_STATEMENT");
  IElementType STORAGE_CLASS = new WGSLElementType("STORAGE_CLASS");
  IElementType STORAGE_TEXTURE_TYPE = new WGSLElementType("STORAGE_TEXTURE_TYPE");
  IElementType STRUCT_BODY_DECL = new WGSLElementType("STRUCT_BODY_DECL");
  IElementType STRUCT_DECL = new WGSLElementType("STRUCT_DECL");
  IElementType STRUCT_MEMBER = new WGSLElementType("STRUCT_MEMBER");
  IElementType SWITCH_BODY = new WGSLElementType("SWITCH_BODY");
  IElementType SWITCH_STATEMENT = new WGSLElementType("SWITCH_STATEMENT");
  IElementType TEXEL_FORMAT = new WGSLElementType("TEXEL_FORMAT");
  IElementType TEXTURE_SAMPLER_TYPES = new WGSLElementType("TEXTURE_SAMPLER_TYPES");
  IElementType TYPE_ALIAS_DECL = new WGSLElementType("TYPE_ALIAS_DECL");
  IElementType TYPE_DECL = new WGSLElementType("TYPE_DECL");
  IElementType UNARY_EXPRESSION = new WGSLElementType("UNARY_EXPRESSION");
  IElementType VARIABLE_DECL = new WGSLElementType("VARIABLE_DECL");
  IElementType VARIABLE_IDENT_DECL = new WGSLElementType("VARIABLE_IDENT_DECL");
  IElementType VARIABLE_QUALIFIER = new WGSLElementType("VARIABLE_QUALIFIER");
  IElementType VARIABLE_REFERENCE = new WGSLElementType("VARIABLE_REFERENCE");
  IElementType VARIABLE_STATEMENT = new WGSLElementType("VARIABLE_STATEMENT");
  IElementType VEC_PREFIX = new WGSLElementType("VEC_PREFIX");
  IElementType WHILE_STATEMENT = new WGSLElementType("WHILE_STATEMENT");

  IElementType AND = new WGSLTokenType("AND");
  IElementType AND_AND = new WGSLTokenType("AND_AND");
  IElementType AND_EQUAL = new WGSLTokenType("AND_EQUAL");
  IElementType ARRAY = new WGSLTokenType("ARRAY");
  IElementType ARROW = new WGSLTokenType("ARROW");
  IElementType AT = new WGSLTokenType("AT");
  IElementType ATOMIC = new WGSLTokenType("ATOMIC");
  IElementType ATTR_LEFT = new WGSLTokenType("ATTR_LEFT");
  IElementType ATTR_RIGHT = new WGSLTokenType("ATTR_RIGHT");
  IElementType BANG = new WGSLTokenType("BANG");
  IElementType BGRA8UNORM = new WGSLTokenType("BGRA8UNORM");
  IElementType BGRA8UNORM_SRGB = new WGSLTokenType("BGRA8UNORM_SRGB");
  IElementType BITCAST = new WGSLTokenType("BITCAST");
  IElementType BLOCK_COMMENT = new WGSLTokenType("BLOCK_COMMENT");
  IElementType BOOL = new WGSLTokenType("BOOL");
  IElementType BRACE_LEFT = new WGSLTokenType("BRACE_LEFT");
  IElementType BRACE_RIGHT = new WGSLTokenType("BRACE_RIGHT");
  IElementType BRACKET_LEFT = new WGSLTokenType("BRACKET_LEFT");
  IElementType BRACKET_RIGHT = new WGSLTokenType("BRACKET_RIGHT");
  IElementType BREAK = new WGSLTokenType("BREAK");
  IElementType CASE = new WGSLTokenType("CASE");
  IElementType COLON = new WGSLTokenType("COLON");
  IElementType COMMA = new WGSLTokenType("COMMA");
  IElementType CONST = new WGSLTokenType("CONST");
  IElementType CONTINUE = new WGSLTokenType("CONTINUE");
  IElementType CONTINUING = new WGSLTokenType("CONTINUING");
  IElementType DECIMAL_FLOAT_LITERAL = new WGSLTokenType("DECIMAL_FLOAT_LITERAL");
  IElementType DEFAULT = new WGSLTokenType("DEFAULT");
  IElementType DISCARD = new WGSLTokenType("DISCARD");
  IElementType DIVISION_EQUAL = new WGSLTokenType("DIVISION_EQUAL");
  IElementType DOC_COMMENT = new WGSLTokenType("DOC_COMMENT");
  IElementType ELSE = new WGSLTokenType("ELSE");
  IElementType ENABLE = new WGSLTokenType("ENABLE");
  IElementType EQUAL = new WGSLTokenType("EQUAL");
  IElementType EQUAL_EQUAL = new WGSLTokenType("EQUAL_EQUAL");
  IElementType FALLTHROUGH = new WGSLTokenType("FALLTHROUGH");
  IElementType FALSE = new WGSLTokenType("FALSE");
  IElementType FLOAT32 = new WGSLTokenType("FLOAT32");
  IElementType FN = new WGSLTokenType("FN");
  IElementType FOR = new WGSLTokenType("FOR");
  IElementType FORWARD_SLASH = new WGSLTokenType("FORWARD_SLASH");
  IElementType FUNCTION = new WGSLTokenType("FUNCTION");
  IElementType GREATER_THAN = new WGSLTokenType("GREATER_THAN");
  IElementType GREATER_THAN_EQUAL = new WGSLTokenType("GREATER_THAN_EQUAL");
  IElementType HEX_FLOAT_LITERAL = new WGSLTokenType("HEX_FLOAT_LITERAL");
  IElementType IDENT = new WGSLTokenType("IDENT");
  IElementType IF = new WGSLTokenType("IF");
  IElementType INT32 = new WGSLTokenType("INT32");
  IElementType INT_LITERAL = new WGSLTokenType("INT_LITERAL");
  IElementType LESS_THAN = new WGSLTokenType("LESS_THAN");
  IElementType LESS_THAN_EQUAL = new WGSLTokenType("LESS_THAN_EQUAL");
  IElementType LET = new WGSLTokenType("LET");
  IElementType LINE_COMMENT = new WGSLTokenType("LINE_COMMENT");
  IElementType LOOP = new WGSLTokenType("LOOP");
  IElementType MAT2X2 = new WGSLTokenType("MAT2X2");
  IElementType MAT2X3 = new WGSLTokenType("MAT2X3");
  IElementType MAT2X4 = new WGSLTokenType("MAT2X4");
  IElementType MAT3X2 = new WGSLTokenType("MAT3X2");
  IElementType MAT3X3 = new WGSLTokenType("MAT3X3");
  IElementType MAT3X4 = new WGSLTokenType("MAT3X4");
  IElementType MAT4X2 = new WGSLTokenType("MAT4X2");
  IElementType MAT4X3 = new WGSLTokenType("MAT4X3");
  IElementType MAT4X4 = new WGSLTokenType("MAT4X4");
  IElementType MINUS = new WGSLTokenType("MINUS");
  IElementType MINUS_EQUAL = new WGSLTokenType("MINUS_EQUAL");
  IElementType MINUS_MINUS = new WGSLTokenType("MINUS_MINUS");
  IElementType MODULO = new WGSLTokenType("MODULO");
  IElementType MODULO_EQUAL = new WGSLTokenType("MODULO_EQUAL");
  IElementType NOT_EQUAL = new WGSLTokenType("NOT_EQUAL");
  IElementType OR = new WGSLTokenType("OR");
  IElementType OR_EQUAL = new WGSLTokenType("OR_EQUAL");
  IElementType OR_OR = new WGSLTokenType("OR_OR");
  IElementType OVERRIDE = new WGSLTokenType("OVERRIDE");
  IElementType PAREN_LEFT = new WGSLTokenType("PAREN_LEFT");
  IElementType PAREN_RIGHT = new WGSLTokenType("PAREN_RIGHT");
  IElementType PERIOD = new WGSLTokenType("PERIOD");
  IElementType PLUS = new WGSLTokenType("PLUS");
  IElementType PLUS_EQUAL = new WGSLTokenType("PLUS_EQUAL");
  IElementType PLUS_PLUS = new WGSLTokenType("PLUS_PLUS");
  IElementType POINTER = new WGSLTokenType("POINTER");
  IElementType PREPROCESSOR_DECLARATION = new WGSLTokenType("PREPROCESSOR_DECLARATION");
  IElementType PRIVATE = new WGSLTokenType("PRIVATE");
  IElementType PUSH_CONSTANT = new WGSLTokenType("PUSH_CONSTANT");
  IElementType R16FLOAT = new WGSLTokenType("R16FLOAT");
  IElementType R16SINT = new WGSLTokenType("R16SINT");
  IElementType R16UINT = new WGSLTokenType("R16UINT");
  IElementType R32FLOAT = new WGSLTokenType("R32FLOAT");
  IElementType R32SINT = new WGSLTokenType("R32SINT");
  IElementType R32UINT = new WGSLTokenType("R32UINT");
  IElementType R8SINT = new WGSLTokenType("R8SINT");
  IElementType R8SNORM = new WGSLTokenType("R8SNORM");
  IElementType R8UINT = new WGSLTokenType("R8UINT");
  IElementType R8UNORM = new WGSLTokenType("R8UNORM");
  IElementType READ = new WGSLTokenType("READ");
  IElementType READ_WRITE = new WGSLTokenType("READ_WRITE");
  IElementType RETURN = new WGSLTokenType("RETURN");
  IElementType RG11B10FLOAT = new WGSLTokenType("RG11B10FLOAT");
  IElementType RG16FLOAT = new WGSLTokenType("RG16FLOAT");
  IElementType RG16SINT = new WGSLTokenType("RG16SINT");
  IElementType RG16UINT = new WGSLTokenType("RG16UINT");
  IElementType RG32FLOAT = new WGSLTokenType("RG32FLOAT");
  IElementType RG32SINT = new WGSLTokenType("RG32SINT");
  IElementType RG32UINT = new WGSLTokenType("RG32UINT");
  IElementType RG8SINT = new WGSLTokenType("RG8SINT");
  IElementType RG8SNORM = new WGSLTokenType("RG8SNORM");
  IElementType RG8UINT = new WGSLTokenType("RG8UINT");
  IElementType RG8UNORM = new WGSLTokenType("RG8UNORM");
  IElementType RGB10A2UNORM = new WGSLTokenType("RGB10A2UNORM");
  IElementType RGBA16FLOAT = new WGSLTokenType("RGBA16FLOAT");
  IElementType RGBA16SINT = new WGSLTokenType("RGBA16SINT");
  IElementType RGBA16UINT = new WGSLTokenType("RGBA16UINT");
  IElementType RGBA32FLOAT = new WGSLTokenType("RGBA32FLOAT");
  IElementType RGBA32SINT = new WGSLTokenType("RGBA32SINT");
  IElementType RGBA32UINT = new WGSLTokenType("RGBA32UINT");
  IElementType RGBA8SINT = new WGSLTokenType("RGBA8SINT");
  IElementType RGBA8SNORM = new WGSLTokenType("RGBA8SNORM");
  IElementType RGBA8UINT = new WGSLTokenType("RGBA8UINT");
  IElementType RGBA8UNORM = new WGSLTokenType("RGBA8UNORM");
  IElementType RGBA8UNORM_SRGB = new WGSLTokenType("RGBA8UNORM_SRGB");
  IElementType SAMPLER = new WGSLTokenType("SAMPLER");
  IElementType SAMPLER_COMPARISON = new WGSLTokenType("SAMPLER_COMPARISON");
  IElementType SEMICOLON = new WGSLTokenType("SEMICOLON");
  IElementType SHIFT_LEFT = new WGSLTokenType("SHIFT_LEFT");
  IElementType SHIFT_LEFT_EQUAL = new WGSLTokenType("SHIFT_LEFT_EQUAL");
  IElementType SHIFT_RIGHT = new WGSLTokenType("SHIFT_RIGHT");
  IElementType SHIFT_RIGHT_EQUAL = new WGSLTokenType("SHIFT_RIGHT_EQUAL");
  IElementType STAR = new WGSLTokenType("STAR");
  IElementType STATIC_ASSERT = new WGSLTokenType("STATIC_ASSERT");
  IElementType STORAGE = new WGSLTokenType("STORAGE");
  IElementType STRUCT = new WGSLTokenType("STRUCT");
  IElementType SWITCH = new WGSLTokenType("SWITCH");
  IElementType TEXTURE_1D = new WGSLTokenType("TEXTURE_1D");
  IElementType TEXTURE_2D = new WGSLTokenType("TEXTURE_2D");
  IElementType TEXTURE_2D_ARRAY = new WGSLTokenType("TEXTURE_2D_ARRAY");
  IElementType TEXTURE_3D = new WGSLTokenType("TEXTURE_3D");
  IElementType TEXTURE_CUBE = new WGSLTokenType("TEXTURE_CUBE");
  IElementType TEXTURE_CUBE_ARRAY = new WGSLTokenType("TEXTURE_CUBE_ARRAY");
  IElementType TEXTURE_DEPTH_2D = new WGSLTokenType("TEXTURE_DEPTH_2D");
  IElementType TEXTURE_DEPTH_2D_ARRAY = new WGSLTokenType("TEXTURE_DEPTH_2D_ARRAY");
  IElementType TEXTURE_DEPTH_CUBE = new WGSLTokenType("TEXTURE_DEPTH_CUBE");
  IElementType TEXTURE_DEPTH_CUBE_ARRAY = new WGSLTokenType("TEXTURE_DEPTH_CUBE_ARRAY");
  IElementType TEXTURE_DEPTH_MULTISAMPLED_2D = new WGSLTokenType("TEXTURE_DEPTH_MULTISAMPLED_2D");
  IElementType TEXTURE_MULTISAMPLED_2D = new WGSLTokenType("TEXTURE_MULTISAMPLED_2D");
  IElementType TEXTURE_STORAGE_1D = new WGSLTokenType("TEXTURE_STORAGE_1D");
  IElementType TEXTURE_STORAGE_2D = new WGSLTokenType("TEXTURE_STORAGE_2D");
  IElementType TEXTURE_STORAGE_2D_ARRAY = new WGSLTokenType("TEXTURE_STORAGE_2D_ARRAY");
  IElementType TEXTURE_STORAGE_3D = new WGSLTokenType("TEXTURE_STORAGE_3D");
  IElementType TILDE = new WGSLTokenType("TILDE");
  IElementType TIMES_EQUAL = new WGSLTokenType("TIMES_EQUAL");
  IElementType TRUE = new WGSLTokenType("TRUE");
  IElementType TYPE = new WGSLTokenType("TYPE");
  IElementType TYPE_GREATER_THAN = new WGSLTokenType("TYPE_GREATER_THAN");
  IElementType TYPE_LESS_THAN = new WGSLTokenType("TYPE_LESS_THAN");
  IElementType UINT32 = new WGSLTokenType("UINT32");
  IElementType UINT_LITERAL = new WGSLTokenType("UINT_LITERAL");
  IElementType UNDERSCORE = new WGSLTokenType("UNDERSCORE");
  IElementType UNIFORM = new WGSLTokenType("UNIFORM");
  IElementType VAR = new WGSLTokenType("VAR");
  IElementType VEC2 = new WGSLTokenType("VEC2");
  IElementType VEC3 = new WGSLTokenType("VEC3");
  IElementType VEC4 = new WGSLTokenType("VEC4");
  IElementType WHILE = new WGSLTokenType("WHILE");
  IElementType WORKGROUP = new WGSLTokenType("WORKGROUP");
  IElementType WRITE = new WGSLTokenType("WRITE");
  IElementType XOR = new WGSLTokenType("XOR");
  IElementType XOR_EQUAL = new WGSLTokenType("XOR_EQUAL");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ACCESS_MODE) {
        return new WGSLAccessModeImpl(node);
      }
      else if (type == ARGUMENT_EXPRESSION_LIST) {
        return new WGSLArgumentExpressionListImpl(node);
      }
      else if (type == ARRAY_TYPE_DECL) {
        return new WGSLArrayTypeDeclImpl(node);
      }
      else if (type == ASSIGNMENT_STATEMENT) {
        return new WGSLAssignmentStatementImpl(node);
      }
      else if (type == ATTRIBUTE) {
        return new WGSLAttributeImpl(node);
      }
      else if (type == ATTRIBUTE_LIST) {
        return new WGSLAttributeListImpl(node);
      }
      else if (type == ATTRIBUTE_NAME) {
        return new WGSLAttributeNameImpl(node);
      }
      else if (type == BREAK_STATEMENT) {
        return new WGSLBreakStatementImpl(node);
      }
      else if (type == CASE_BODY) {
        return new WGSLCaseBodyImpl(node);
      }
      else if (type == CASE_SELECTORS) {
        return new WGSLCaseSelectorsImpl(node);
      }
      else if (type == COMPOUND_ASSIGNMENT_OPERATOR) {
        return new WGSLCompoundAssignmentOperatorImpl(node);
      }
      else if (type == COMPOUND_STATEMENT) {
        return new WGSLCompoundStatementImpl(node);
      }
      else if (type == CONST_EXPRESSION) {
        return new WGSLConstExpressionImpl(node);
      }
      else if (type == CONST_LITERAL) {
        return new WGSLConstLiteralImpl(node);
      }
      else if (type == CONTINUE_STATEMENT) {
        return new WGSLContinueStatementImpl(node);
      }
      else if (type == CONTINUING_STATEMENT) {
        return new WGSLContinuingStatementImpl(node);
      }
      else if (type == CORE_LHS_EXPRESSION) {
        return new WGSLCoreLhsExpressionImpl(node);
      }
      else if (type == DECREMENT_STATEMENT) {
        return new WGSLDecrementStatementImpl(node);
      }
      else if (type == DEPTH_TEXTURE_TYPE) {
        return new WGSLDepthTextureTypeImpl(node);
      }
      else if (type == DOCS) {
        return new WGSLDocsImpl(node);
      }
      else if (type == ELEMENT_COUNT_EXPRESSION) {
        return new WGSLElementCountExpressionImpl(node);
      }
      else if (type == ELSE_STATEMENT) {
        return new WGSLElseStatementImpl(node);
      }
      else if (type == ENABLE_DIRECTIVE) {
        return new WGSLEnableDirectiveImpl(node);
      }
      else if (type == EXPRESSION) {
        return new WGSLExpressionImpl(node);
      }
      else if (type == FIELD) {
        return new WGSLFieldImpl(node);
      }
      else if (type == FIELD_IDENT) {
        return new WGSLFieldIdentImpl(node);
      }
      else if (type == FLOAT_LITERAL) {
        return new WGSLFloatLiteralImpl(node);
      }
      else if (type == FOR_HEADER) {
        return new WGSLForHeaderImpl(node);
      }
      else if (type == FOR_INIT) {
        return new WGSLForInitImpl(node);
      }
      else if (type == FOR_STATEMENT) {
        return new WGSLForStatementImpl(node);
      }
      else if (type == FOR_UPDATE) {
        return new WGSLForUpdateImpl(node);
      }
      else if (type == FUNCTION_DECL) {
        return new WGSLFunctionDeclImpl(node);
      }
      else if (type == FUNCTION_HEADER) {
        return new WGSLFunctionHeaderImpl(node);
      }
      else if (type == FUNCTION_NAME) {
        return new WGSLFunctionNameImpl(node);
      }
      else if (type == FUNC_CALL_NAME) {
        return new WGSLFuncCallNameImpl(node);
      }
      else if (type == FUNC_CALL_STATEMENT) {
        return new WGSLFuncCallStatementImpl(node);
      }
      else if (type == GLOBAL_CONSTANT_DECL) {
        return new WGSLGlobalConstantDeclImpl(node);
      }
      else if (type == GLOBAL_CONST_INITIALIZER) {
        return new WGSLGlobalConstInitializerImpl(node);
      }
      else if (type == GLOBAL_DECL) {
        return new WGSLGlobalDeclImpl(node);
      }
      else if (type == GLOBAL_DIRECTIVE) {
        return new WGSLGlobalDirectiveImpl(node);
      }
      else if (type == GLOBAL_VARIABLE_DECL) {
        return new WGSLGlobalVariableDeclImpl(node);
      }
      else if (type == IF_STATEMENT) {
        return new WGSLIfStatementImpl(node);
      }
      else if (type == INCREMENT_STATEMENT) {
        return new WGSLIncrementStatementImpl(node);
      }
      else if (type == LHS_EXPRESSION) {
        return new WGSLLhsExpressionImpl(node);
      }
      else if (type == LITERAL_OR_IDENT) {
        return new WGSLLiteralOrIdentImpl(node);
      }
      else if (type == LOOP_STATEMENT) {
        return new WGSLLoopStatementImpl(node);
      }
      else if (type == MAT_PREFIX) {
        return new WGSLMatPrefixImpl(node);
      }
      else if (type == MULTISAMPLED_TEXTURE_TYPE) {
        return new WGSLMultisampledTextureTypeImpl(node);
      }
      else if (type == PARAM) {
        return new WGSLParamImpl(node);
      }
      else if (type == PARAM_LIST) {
        return new WGSLParamListImpl(node);
      }
      else if (type == PAREN_EXPRESSION) {
        return new WGSLParenExpressionImpl(node);
      }
      else if (type == POSTFIX_EXPRESSION) {
        return new WGSLPostfixExpressionImpl(node);
      }
      else if (type == PRIMARY_EXPRESSION) {
        return new WGSLPrimaryExpressionImpl(node);
      }
      else if (type == RETURN_STATEMENT) {
        return new WGSLReturnStatementImpl(node);
      }
      else if (type == SAMPLED_TEXTURE_TYPE) {
        return new WGSLSampledTextureTypeImpl(node);
      }
      else if (type == SAMPLER_TYPE) {
        return new WGSLSamplerTypeImpl(node);
      }
      else if (type == SINGULAR_EXPRESSION) {
        return new WGSLSingularExpressionImpl(node);
      }
      else if (type == STATEMENT) {
        return new WGSLStatementImpl(node);
      }
      else if (type == STATIC_ASSERT_STATEMENT) {
        return new WGSLStaticAssertStatementImpl(node);
      }
      else if (type == STORAGE_CLASS) {
        return new WGSLStorageClassImpl(node);
      }
      else if (type == STORAGE_TEXTURE_TYPE) {
        return new WGSLStorageTextureTypeImpl(node);
      }
      else if (type == STRUCT_BODY_DECL) {
        return new WGSLStructBodyDeclImpl(node);
      }
      else if (type == STRUCT_DECL) {
        return new WGSLStructDeclImpl(node);
      }
      else if (type == STRUCT_MEMBER) {
        return new WGSLStructMemberImpl(node);
      }
      else if (type == SWITCH_BODY) {
        return new WGSLSwitchBodyImpl(node);
      }
      else if (type == SWITCH_STATEMENT) {
        return new WGSLSwitchStatementImpl(node);
      }
      else if (type == TEXEL_FORMAT) {
        return new WGSLTexelFormatImpl(node);
      }
      else if (type == TEXTURE_SAMPLER_TYPES) {
        return new WGSLTextureSamplerTypesImpl(node);
      }
      else if (type == TYPE_ALIAS_DECL) {
        return new WGSLTypeAliasDeclImpl(node);
      }
      else if (type == TYPE_DECL) {
        return new WGSLTypeDeclImpl(node);
      }
      else if (type == UNARY_EXPRESSION) {
        return new WGSLUnaryExpressionImpl(node);
      }
      else if (type == VARIABLE_DECL) {
        return new WGSLVariableDeclImpl(node);
      }
      else if (type == VARIABLE_IDENT_DECL) {
        return new WGSLVariableIdentDeclImpl(node);
      }
      else if (type == VARIABLE_QUALIFIER) {
        return new WGSLVariableQualifierImpl(node);
      }
      else if (type == VARIABLE_REFERENCE) {
        return new WGSLVariableReferenceImpl(node);
      }
      else if (type == VARIABLE_STATEMENT) {
        return new WGSLVariableStatementImpl(node);
      }
      else if (type == VEC_PREFIX) {
        return new WGSLVecPrefixImpl(node);
      }
      else if (type == WHILE_STATEMENT) {
        return new WGSLWhileStatementImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}

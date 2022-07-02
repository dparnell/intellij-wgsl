// This is a generated file. Not intended for manual editing.
package wgslplugin.language.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static wgslplugin.language.psi.WGSLTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class WgslParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return translation_unit(b, l + 1);
  }

  /* ********************************************************** */
  // IDENT
  public static boolean access_mode(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "access_mode")) return false;
    if (!nextTokenIs(b, IDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENT);
    exit_section_(b, m, ACCESS_MODE, r);
    return r;
  }

  /* ********************************************************** */
  // PAREN_LEFT ( ( expression COMMA )* expression COMMA? )? PAREN_RIGHT
  public static boolean argument_expression_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument_expression_list")) return false;
    if (!nextTokenIs(b, PAREN_LEFT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PAREN_LEFT);
    r = r && argument_expression_list_1(b, l + 1);
    r = r && consumeToken(b, PAREN_RIGHT);
    exit_section_(b, m, ARGUMENT_EXPRESSION_LIST, r);
    return r;
  }

  // ( ( expression COMMA )* expression COMMA? )?
  private static boolean argument_expression_list_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument_expression_list_1")) return false;
    argument_expression_list_1_0(b, l + 1);
    return true;
  }

  // ( expression COMMA )* expression COMMA?
  private static boolean argument_expression_list_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument_expression_list_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = argument_expression_list_1_0_0(b, l + 1);
    r = r && expression(b, l + 1);
    r = r && argument_expression_list_1_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( expression COMMA )*
  private static boolean argument_expression_list_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument_expression_list_1_0_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!argument_expression_list_1_0_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "argument_expression_list_1_0_0", c)) break;
    }
    return true;
  }

  // expression COMMA
  private static boolean argument_expression_list_1_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument_expression_list_1_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expression(b, l + 1);
    r = r && consumeToken(b, COMMA);
    exit_section_(b, m, null, r);
    return r;
  }

  // COMMA?
  private static boolean argument_expression_list_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument_expression_list_1_0_2")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // attribute_list* ARRAY LESS_THAN type_decl ( COMMA element_count_expression )? GREATER_THAN
  public static boolean array_type_decl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_type_decl")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ARRAY_TYPE_DECL, "<array type decl>");
    r = array_type_decl_0(b, l + 1);
    r = r && consumeTokens(b, 0, ARRAY, LESS_THAN);
    r = r && type_decl(b, l + 1);
    r = r && array_type_decl_4(b, l + 1);
    r = r && consumeToken(b, GREATER_THAN);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // attribute_list*
  private static boolean array_type_decl_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_type_decl_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!attribute_list(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "array_type_decl_0", c)) break;
    }
    return true;
  }

  // ( COMMA element_count_expression )?
  private static boolean array_type_decl_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_type_decl_4")) return false;
    array_type_decl_4_0(b, l + 1);
    return true;
  }

  // COMMA element_count_expression
  private static boolean array_type_decl_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_type_decl_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && element_count_expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ( lhs_expression | UNDERSCORE ) EQUAL expression
  public static boolean assignment_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignment_statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ASSIGNMENT_STATEMENT, "<assignment statement>");
    r = assignment_statement_0(b, l + 1);
    r = r && consumeToken(b, EQUAL);
    r = r && expression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // lhs_expression | UNDERSCORE
  private static boolean assignment_statement_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignment_statement_0")) return false;
    boolean r;
    r = lhs_expression(b, l + 1);
    if (!r) r = consumeToken(b, UNDERSCORE);
    return r;
  }

  /* ********************************************************** */
  // attribute_name PAREN_LEFT ( literal_or_ident COMMA )* literal_or_ident PAREN_RIGHT
  //     | attribute_name
  public static boolean attribute(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attribute")) return false;
    if (!nextTokenIs(b, IDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = attribute_0(b, l + 1);
    if (!r) r = attribute_name(b, l + 1);
    exit_section_(b, m, ATTRIBUTE, r);
    return r;
  }

  // attribute_name PAREN_LEFT ( literal_or_ident COMMA )* literal_or_ident PAREN_RIGHT
  private static boolean attribute_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attribute_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = attribute_name(b, l + 1);
    r = r && consumeToken(b, PAREN_LEFT);
    r = r && attribute_0_2(b, l + 1);
    r = r && literal_or_ident(b, l + 1);
    r = r && consumeToken(b, PAREN_RIGHT);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( literal_or_ident COMMA )*
  private static boolean attribute_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attribute_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!attribute_0_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "attribute_0_2", c)) break;
    }
    return true;
  }

  // literal_or_ident COMMA
  private static boolean attribute_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attribute_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = literal_or_ident(b, l + 1);
    r = r && consumeToken(b, COMMA);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ATTR_LEFT ( attribute COMMA )* attribute ATTR_RIGHT
  //     | ( AT attribute )+
  public static boolean attribute_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attribute_list")) return false;
    if (!nextTokenIs(b, "<attribute list>", AT, ATTR_LEFT)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ATTRIBUTE_LIST, "<attribute list>");
    r = attribute_list_0(b, l + 1);
    if (!r) r = attribute_list_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ATTR_LEFT ( attribute COMMA )* attribute ATTR_RIGHT
  private static boolean attribute_list_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attribute_list_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ATTR_LEFT);
    r = r && attribute_list_0_1(b, l + 1);
    r = r && attribute(b, l + 1);
    r = r && consumeToken(b, ATTR_RIGHT);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( attribute COMMA )*
  private static boolean attribute_list_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attribute_list_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!attribute_list_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "attribute_list_0_1", c)) break;
    }
    return true;
  }

  // attribute COMMA
  private static boolean attribute_list_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attribute_list_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = attribute(b, l + 1);
    r = r && consumeToken(b, COMMA);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( AT attribute )+
  private static boolean attribute_list_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attribute_list_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = attribute_list_1_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!attribute_list_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "attribute_list_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // AT attribute
  private static boolean attribute_list_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attribute_list_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, AT);
    r = r && attribute(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IDENT
  public static boolean attribute_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attribute_name")) return false;
    if (!nextTokenIs(b, IDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENT);
    exit_section_(b, m, ATTRIBUTE_NAME, r);
    return r;
  }

  /* ********************************************************** */
  // BREAK
  public static boolean break_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "break_statement")) return false;
    if (!nextTokenIs(b, BREAK)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BREAK);
    exit_section_(b, m, BREAK_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // statement case_body?
  //     | FALLTHROUGH SEMICOLON
  public static boolean case_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "case_body")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CASE_BODY, "<case body>");
    r = case_body_0(b, l + 1);
    if (!r) r = parseTokens(b, 0, FALLTHROUGH, SEMICOLON);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // statement case_body?
  private static boolean case_body_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "case_body_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = statement(b, l + 1);
    r = r && case_body_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // case_body?
  private static boolean case_body_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "case_body_0_1")) return false;
    case_body(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // const_literal ( COMMA const_literal )* COMMA?
  public static boolean case_selectors(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "case_selectors")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CASE_SELECTORS, "<case selectors>");
    r = const_literal(b, l + 1);
    r = r && case_selectors_1(b, l + 1);
    r = r && case_selectors_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ( COMMA const_literal )*
  private static boolean case_selectors_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "case_selectors_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!case_selectors_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "case_selectors_1", c)) break;
    }
    return true;
  }

  // COMMA const_literal
  private static boolean case_selectors_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "case_selectors_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && const_literal(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COMMA?
  private static boolean case_selectors_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "case_selectors_2")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // BRACE_LEFT statement* BRACE_RIGHT
  public static boolean compound_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "compound_statement")) return false;
    if (!nextTokenIs(b, BRACE_LEFT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BRACE_LEFT);
    r = r && compound_statement_1(b, l + 1);
    r = r && consumeToken(b, BRACE_RIGHT);
    exit_section_(b, m, COMPOUND_STATEMENT, r);
    return r;
  }

  // statement*
  private static boolean compound_statement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "compound_statement_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!statement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "compound_statement_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // type_decl PAREN_LEFT ( ( const_expression COMMA )* const_expression COMMA? )? PAREN_RIGHT
  //     | const_literal
  public static boolean const_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "const_expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONST_EXPRESSION, "<const expression>");
    r = const_expression_0(b, l + 1);
    if (!r) r = const_literal(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // type_decl PAREN_LEFT ( ( const_expression COMMA )* const_expression COMMA? )? PAREN_RIGHT
  private static boolean const_expression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "const_expression_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = type_decl(b, l + 1);
    r = r && consumeToken(b, PAREN_LEFT);
    r = r && const_expression_0_2(b, l + 1);
    r = r && consumeToken(b, PAREN_RIGHT);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( ( const_expression COMMA )* const_expression COMMA? )?
  private static boolean const_expression_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "const_expression_0_2")) return false;
    const_expression_0_2_0(b, l + 1);
    return true;
  }

  // ( const_expression COMMA )* const_expression COMMA?
  private static boolean const_expression_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "const_expression_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = const_expression_0_2_0_0(b, l + 1);
    r = r && const_expression(b, l + 1);
    r = r && const_expression_0_2_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( const_expression COMMA )*
  private static boolean const_expression_0_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "const_expression_0_2_0_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!const_expression_0_2_0_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "const_expression_0_2_0_0", c)) break;
    }
    return true;
  }

  // const_expression COMMA
  private static boolean const_expression_0_2_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "const_expression_0_2_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = const_expression(b, l + 1);
    r = r && consumeToken(b, COMMA);
    exit_section_(b, m, null, r);
    return r;
  }

  // COMMA?
  private static boolean const_expression_0_2_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "const_expression_0_2_0_2")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // INT_LITERAL
  //     | UINT_LITERAL
  //     | float_literal
  //     | TRUE
  //     | FALSE
  public static boolean const_literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "const_literal")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONST_LITERAL, "<const literal>");
    r = consumeToken(b, INT_LITERAL);
    if (!r) r = consumeToken(b, UINT_LITERAL);
    if (!r) r = float_literal(b, l + 1);
    if (!r) r = consumeToken(b, TRUE);
    if (!r) r = consumeToken(b, FALSE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // CONTINUE
  public static boolean continue_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "continue_statement")) return false;
    if (!nextTokenIs(b, CONTINUE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CONTINUE);
    exit_section_(b, m, CONTINUE_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // CONTINUING compound_statement
  public static boolean continuing_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "continuing_statement")) return false;
    if (!nextTokenIs(b, CONTINUING)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CONTINUING);
    r = r && compound_statement(b, l + 1);
    exit_section_(b, m, CONTINUING_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // variable_reference
  //     | PAREN_LEFT lhs_expression PAREN_RIGHT
  public static boolean core_lhs_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "core_lhs_expression")) return false;
    if (!nextTokenIs(b, "<core lhs expression>", IDENT, PAREN_LEFT)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CORE_LHS_EXPRESSION, "<core lhs expression>");
    r = variable_reference(b, l + 1);
    if (!r) r = core_lhs_expression_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // PAREN_LEFT lhs_expression PAREN_RIGHT
  private static boolean core_lhs_expression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "core_lhs_expression_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PAREN_LEFT);
    r = r && lhs_expression(b, l + 1);
    r = r && consumeToken(b, PAREN_RIGHT);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // lhs_expression MINUS_MINUS
  public static boolean decrement_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "decrement_statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DECREMENT_STATEMENT, "<decrement statement>");
    r = lhs_expression(b, l + 1);
    r = r && consumeToken(b, MINUS_MINUS);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // TEXTURE_DEPTH_2D
  //     | TEXTURE_DEPTH_2D_ARRAY
  //     | TEXTURE_DEPTH_CUBE
  //     | TEXTURE_DEPTH_CUBE_ARRAY
  //     | TEXTURE_DEPTH_MULTISAMPLED_2D
  public static boolean depth_texture_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "depth_texture_type")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DEPTH_TEXTURE_TYPE, "<depth texture type>");
    r = consumeToken(b, TEXTURE_DEPTH_2D);
    if (!r) r = consumeToken(b, TEXTURE_DEPTH_2D_ARRAY);
    if (!r) r = consumeToken(b, TEXTURE_DEPTH_CUBE);
    if (!r) r = consumeToken(b, TEXTURE_DEPTH_CUBE_ARRAY);
    if (!r) r = consumeToken(b, TEXTURE_DEPTH_MULTISAMPLED_2D);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // DOC_COMMENT
  public static boolean docs(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "docs")) return false;
    if (!nextTokenIs(b, DOC_COMMENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DOC_COMMENT);
    exit_section_(b, m, DOCS, r);
    return r;
  }

  /* ********************************************************** */
  // INT_LITERAL
  //     | UINT_LITERAL
  //     | IDENT
  public static boolean element_count_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "element_count_expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ELEMENT_COUNT_EXPRESSION, "<element count expression>");
    r = consumeToken(b, INT_LITERAL);
    if (!r) r = consumeToken(b, UINT_LITERAL);
    if (!r) r = consumeToken(b, IDENT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // compound_statement
  //     | if_statement
  public static boolean else_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "else_statement")) return false;
    if (!nextTokenIs(b, "<else statement>", BRACE_LEFT, IF)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ELSE_STATEMENT, "<else statement>");
    r = compound_statement(b, l + 1);
    if (!r) r = if_statement(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ENABLE IDENT SEMICOLON
  public static boolean enable_directive(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enable_directive")) return false;
    if (!nextTokenIs(b, ENABLE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ENABLE, IDENT, SEMICOLON);
    exit_section_(b, m, ENABLE_DIRECTIVE, r);
    return r;
  }

  /* ********************************************************** */
  // unary_expression ((STAR | FORWARD_SLASH | MODULO | PLUS | MINUS | SHIFT_LEFT | SHIFT_RIGHT | LESS_THAN | LESS_THAN_EQUAL | GREATER_THAN | GREATER_THAN_EQUAL | EQUAL_EQUAL | NOT_EQUAL | OR_OR | AND_AND | OR | AND | XOR) expression)?
  public static boolean expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPRESSION, "<expression>");
    r = unary_expression(b, l + 1);
    r = r && expression_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ((STAR | FORWARD_SLASH | MODULO | PLUS | MINUS | SHIFT_LEFT | SHIFT_RIGHT | LESS_THAN | LESS_THAN_EQUAL | GREATER_THAN | GREATER_THAN_EQUAL | EQUAL_EQUAL | NOT_EQUAL | OR_OR | AND_AND | OR | AND | XOR) expression)?
  private static boolean expression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_1")) return false;
    expression_1_0(b, l + 1);
    return true;
  }

  // (STAR | FORWARD_SLASH | MODULO | PLUS | MINUS | SHIFT_LEFT | SHIFT_RIGHT | LESS_THAN | LESS_THAN_EQUAL | GREATER_THAN | GREATER_THAN_EQUAL | EQUAL_EQUAL | NOT_EQUAL | OR_OR | AND_AND | OR | AND | XOR) expression
  private static boolean expression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expression_1_0_0(b, l + 1);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // STAR | FORWARD_SLASH | MODULO | PLUS | MINUS | SHIFT_LEFT | SHIFT_RIGHT | LESS_THAN | LESS_THAN_EQUAL | GREATER_THAN | GREATER_THAN_EQUAL | EQUAL_EQUAL | NOT_EQUAL | OR_OR | AND_AND | OR | AND | XOR
  private static boolean expression_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_1_0_0")) return false;
    boolean r;
    r = consumeToken(b, STAR);
    if (!r) r = consumeToken(b, FORWARD_SLASH);
    if (!r) r = consumeToken(b, MODULO);
    if (!r) r = consumeToken(b, PLUS);
    if (!r) r = consumeToken(b, MINUS);
    if (!r) r = consumeToken(b, SHIFT_LEFT);
    if (!r) r = consumeToken(b, SHIFT_RIGHT);
    if (!r) r = consumeToken(b, LESS_THAN);
    if (!r) r = consumeToken(b, LESS_THAN_EQUAL);
    if (!r) r = consumeToken(b, GREATER_THAN);
    if (!r) r = consumeToken(b, GREATER_THAN_EQUAL);
    if (!r) r = consumeToken(b, EQUAL_EQUAL);
    if (!r) r = consumeToken(b, NOT_EQUAL);
    if (!r) r = consumeToken(b, OR_OR);
    if (!r) r = consumeToken(b, AND_AND);
    if (!r) r = consumeToken(b, OR);
    if (!r) r = consumeToken(b, AND);
    if (!r) r = consumeToken(b, XOR);
    return r;
  }

  /* ********************************************************** */
  // field_ident COLON type_decl
  public static boolean field(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field")) return false;
    if (!nextTokenIs(b, IDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = field_ident(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && type_decl(b, l + 1);
    exit_section_(b, m, FIELD, r);
    return r;
  }

  /* ********************************************************** */
  // IDENT
  public static boolean field_ident(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_ident")) return false;
    if (!nextTokenIs(b, IDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENT);
    exit_section_(b, m, FIELD_IDENT, r);
    return r;
  }

  /* ********************************************************** */
  // DECIMAL_FLOAT_LITERAL
  //     | HEX_FLOAT_LITERAL
  public static boolean float_literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "float_literal")) return false;
    if (!nextTokenIs(b, "<float literal>", DECIMAL_FLOAT_LITERAL, HEX_FLOAT_LITERAL)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FLOAT_LITERAL, "<float literal>");
    r = consumeToken(b, DECIMAL_FLOAT_LITERAL);
    if (!r) r = consumeToken(b, HEX_FLOAT_LITERAL);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // for_init ? SEMICOLON expression ? SEMICOLON for_update ?
  public static boolean for_header(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "for_header")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FOR_HEADER, "<for header>");
    r = for_header_0(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    r = r && for_header_2(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    r = r && for_header_4(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // for_init ?
  private static boolean for_header_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "for_header_0")) return false;
    for_init(b, l + 1);
    return true;
  }

  // expression ?
  private static boolean for_header_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "for_header_2")) return false;
    expression(b, l + 1);
    return true;
  }

  // for_update ?
  private static boolean for_header_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "for_header_4")) return false;
    for_update(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // variable_statement | assignment_statement | func_call_statement
  public static boolean for_init(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "for_init")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FOR_INIT, "<for init>");
    r = variable_statement(b, l + 1);
    if (!r) r = assignment_statement(b, l + 1);
    if (!r) r = func_call_statement(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // FOR PAREN_LEFT for_header PAREN_RIGHT compound_statement
  public static boolean for_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "for_statement")) return false;
    if (!nextTokenIs(b, FOR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, FOR, PAREN_LEFT);
    r = r && for_header(b, l + 1);
    r = r && consumeToken(b, PAREN_RIGHT);
    r = r && compound_statement(b, l + 1);
    exit_section_(b, m, FOR_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // increment_statement | decrement_statement | assignment_statement | func_call_statement
  public static boolean for_update(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "for_update")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FOR_UPDATE, "<for update>");
    r = increment_statement(b, l + 1);
    if (!r) r = decrement_statement(b, l + 1);
    if (!r) r = assignment_statement(b, l + 1);
    if (!r) r = func_call_statement(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // vec_prefix
  //     | mat_prefix
  //     | IDENT
  public static boolean func_call_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_call_name")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FUNC_CALL_NAME, "<func call name>");
    r = vec_prefix(b, l + 1);
    if (!r) r = mat_prefix(b, l + 1);
    if (!r) r = consumeToken(b, IDENT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // func_call_name argument_expression_list
  public static boolean func_call_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_call_statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FUNC_CALL_STATEMENT, "<func call statement>");
    r = func_call_name(b, l + 1);
    r = r && argument_expression_list(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // docs? attribute_list? function_header compound_statement
  public static boolean function_decl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_decl")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FUNCTION_DECL, "<function decl>");
    r = function_decl_0(b, l + 1);
    r = r && function_decl_1(b, l + 1);
    r = r && function_header(b, l + 1);
    r = r && compound_statement(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // docs?
  private static boolean function_decl_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_decl_0")) return false;
    docs(b, l + 1);
    return true;
  }

  // attribute_list?
  private static boolean function_decl_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_decl_1")) return false;
    attribute_list(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // FN function_name PAREN_LEFT param_list? PAREN_RIGHT ( ARROW attribute_list* type_decl )?
  public static boolean function_header(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_header")) return false;
    if (!nextTokenIs(b, FN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FN);
    r = r && function_name(b, l + 1);
    r = r && consumeToken(b, PAREN_LEFT);
    r = r && function_header_3(b, l + 1);
    r = r && consumeToken(b, PAREN_RIGHT);
    r = r && function_header_5(b, l + 1);
    exit_section_(b, m, FUNCTION_HEADER, r);
    return r;
  }

  // param_list?
  private static boolean function_header_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_header_3")) return false;
    param_list(b, l + 1);
    return true;
  }

  // ( ARROW attribute_list* type_decl )?
  private static boolean function_header_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_header_5")) return false;
    function_header_5_0(b, l + 1);
    return true;
  }

  // ARROW attribute_list* type_decl
  private static boolean function_header_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_header_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ARROW);
    r = r && function_header_5_0_1(b, l + 1);
    r = r && type_decl(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // attribute_list*
  private static boolean function_header_5_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_header_5_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!attribute_list(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "function_header_5_0_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // IDENT
  public static boolean function_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_name")) return false;
    if (!nextTokenIs(b, IDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENT);
    exit_section_(b, m, FUNCTION_NAME, r);
    return r;
  }

  /* ********************************************************** */
  // EQUAL const_expression
  public static boolean global_const_initializer(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "global_const_initializer")) return false;
    if (!nextTokenIs(b, EQUAL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EQUAL);
    r = r && const_expression(b, l + 1);
    exit_section_(b, m, GLOBAL_CONST_INITIALIZER, r);
    return r;
  }

  /* ********************************************************** */
  // attribute_list* LET variable_ident_decl global_const_initializer?
  public static boolean global_constant_decl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "global_constant_decl")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, GLOBAL_CONSTANT_DECL, "<global constant decl>");
    r = global_constant_decl_0(b, l + 1);
    r = r && consumeToken(b, LET);
    r = r && variable_ident_decl(b, l + 1);
    r = r && global_constant_decl_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // attribute_list*
  private static boolean global_constant_decl_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "global_constant_decl_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!attribute_list(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "global_constant_decl_0", c)) break;
    }
    return true;
  }

  // global_const_initializer?
  private static boolean global_constant_decl_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "global_constant_decl_3")) return false;
    global_const_initializer(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // SEMICOLON
  //     | global_variable_decl SEMICOLON
  //     | global_constant_decl SEMICOLON
  //     | type_alias_decl SEMICOLON
  //     | struct_decl SEMICOLON?
  //     | function_decl
  public static boolean global_decl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "global_decl")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, GLOBAL_DECL, "<global decl>");
    r = consumeToken(b, SEMICOLON);
    if (!r) r = global_decl_1(b, l + 1);
    if (!r) r = global_decl_2(b, l + 1);
    if (!r) r = global_decl_3(b, l + 1);
    if (!r) r = global_decl_4(b, l + 1);
    if (!r) r = function_decl(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // global_variable_decl SEMICOLON
  private static boolean global_decl_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "global_decl_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = global_variable_decl(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, null, r);
    return r;
  }

  // global_constant_decl SEMICOLON
  private static boolean global_decl_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "global_decl_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = global_constant_decl(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, null, r);
    return r;
  }

  // type_alias_decl SEMICOLON
  private static boolean global_decl_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "global_decl_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = type_alias_decl(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, null, r);
    return r;
  }

  // struct_decl SEMICOLON?
  private static boolean global_decl_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "global_decl_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = struct_decl(b, l + 1);
    r = r && global_decl_4_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // SEMICOLON?
  private static boolean global_decl_4_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "global_decl_4_1")) return false;
    consumeToken(b, SEMICOLON);
    return true;
  }

  /* ********************************************************** */
  // enable_directive
  public static boolean global_directive(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "global_directive")) return false;
    if (!nextTokenIs(b, ENABLE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = enable_directive(b, l + 1);
    exit_section_(b, m, GLOBAL_DIRECTIVE, r);
    return r;
  }

  /* ********************************************************** */
  // attribute_list* variable_decl ( EQUAL const_expression )?
  public static boolean global_variable_decl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "global_variable_decl")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, GLOBAL_VARIABLE_DECL, "<global variable decl>");
    r = global_variable_decl_0(b, l + 1);
    r = r && variable_decl(b, l + 1);
    r = r && global_variable_decl_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // attribute_list*
  private static boolean global_variable_decl_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "global_variable_decl_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!attribute_list(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "global_variable_decl_0", c)) break;
    }
    return true;
  }

  // ( EQUAL const_expression )?
  private static boolean global_variable_decl_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "global_variable_decl_2")) return false;
    global_variable_decl_2_0(b, l + 1);
    return true;
  }

  // EQUAL const_expression
  private static boolean global_variable_decl_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "global_variable_decl_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EQUAL);
    r = r && const_expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IF paren_expression compound_statement ( ELSE else_statement )?
  public static boolean if_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_statement")) return false;
    if (!nextTokenIs(b, IF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IF);
    r = r && paren_expression(b, l + 1);
    r = r && compound_statement(b, l + 1);
    r = r && if_statement_3(b, l + 1);
    exit_section_(b, m, IF_STATEMENT, r);
    return r;
  }

  // ( ELSE else_statement )?
  private static boolean if_statement_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_statement_3")) return false;
    if_statement_3_0(b, l + 1);
    return true;
  }

  // ELSE else_statement
  private static boolean if_statement_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_statement_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELSE);
    r = r && else_statement(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // lhs_expression PLUS_PLUS
  public static boolean increment_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "increment_statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INCREMENT_STATEMENT, "<increment statement>");
    r = lhs_expression(b, l + 1);
    r = r && consumeToken(b, PLUS_PLUS);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ( STAR | AND )* core_lhs_expression postfix_expression?
  public static boolean lhs_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lhs_expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LHS_EXPRESSION, "<lhs expression>");
    r = lhs_expression_0(b, l + 1);
    r = r && core_lhs_expression(b, l + 1);
    r = r && lhs_expression_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ( STAR | AND )*
  private static boolean lhs_expression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lhs_expression_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!lhs_expression_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "lhs_expression_0", c)) break;
    }
    return true;
  }

  // STAR | AND
  private static boolean lhs_expression_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lhs_expression_0_0")) return false;
    boolean r;
    r = consumeToken(b, STAR);
    if (!r) r = consumeToken(b, AND);
    return r;
  }

  // postfix_expression?
  private static boolean lhs_expression_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lhs_expression_2")) return false;
    postfix_expression(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // float_literal
  //     | INT_LITERAL
  //     | UINT_LITERAL
  //     | IDENT
  public static boolean literal_or_ident(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "literal_or_ident")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LITERAL_OR_IDENT, "<literal or ident>");
    r = float_literal(b, l + 1);
    if (!r) r = consumeToken(b, INT_LITERAL);
    if (!r) r = consumeToken(b, UINT_LITERAL);
    if (!r) r = consumeToken(b, IDENT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // LOOP BRACE_LEFT statement * continuing_statement ? BRACE_RIGHT
  public static boolean loop_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "loop_statement")) return false;
    if (!nextTokenIs(b, LOOP)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, LOOP, BRACE_LEFT);
    r = r && loop_statement_2(b, l + 1);
    r = r && loop_statement_3(b, l + 1);
    r = r && consumeToken(b, BRACE_RIGHT);
    exit_section_(b, m, LOOP_STATEMENT, r);
    return r;
  }

  // statement *
  private static boolean loop_statement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "loop_statement_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!statement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "loop_statement_2", c)) break;
    }
    return true;
  }

  // continuing_statement ?
  private static boolean loop_statement_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "loop_statement_3")) return false;
    continuing_statement(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // MAT2X2
  //     | MAT2X3
  //     | MAT2X4
  //     | MAT3X2
  //     | MAT3X3
  //     | MAT3X4
  //     | MAT4X2
  //     | MAT4X3
  //     | MAT4X4
  public static boolean mat_prefix(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mat_prefix")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MAT_PREFIX, "<mat prefix>");
    r = consumeToken(b, MAT2X2);
    if (!r) r = consumeToken(b, MAT2X3);
    if (!r) r = consumeToken(b, MAT2X4);
    if (!r) r = consumeToken(b, MAT3X2);
    if (!r) r = consumeToken(b, MAT3X3);
    if (!r) r = consumeToken(b, MAT3X4);
    if (!r) r = consumeToken(b, MAT4X2);
    if (!r) r = consumeToken(b, MAT4X3);
    if (!r) r = consumeToken(b, MAT4X4);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // TEXTURE_MULTISAMPLED_2D
  public static boolean multisampled_texture_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multisampled_texture_type")) return false;
    if (!nextTokenIs(b, TEXTURE_MULTISAMPLED_2D)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TEXTURE_MULTISAMPLED_2D);
    exit_section_(b, m, MULTISAMPLED_TEXTURE_TYPE, r);
    return r;
  }

  /* ********************************************************** */
  // attribute_list? variable_ident_decl
  public static boolean param(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "param")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PARAM, "<param>");
    r = param_0(b, l + 1);
    r = r && variable_ident_decl(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // attribute_list?
  private static boolean param_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "param_0")) return false;
    attribute_list(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // param (COMMA param)* COMMA?
  public static boolean param_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "param_list")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PARAM_LIST, "<param list>");
    r = param(b, l + 1);
    r = r && param_list_1(b, l + 1);
    r = r && param_list_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (COMMA param)*
  private static boolean param_list_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "param_list_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!param_list_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "param_list_1", c)) break;
    }
    return true;
  }

  // COMMA param
  private static boolean param_list_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "param_list_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && param(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COMMA?
  private static boolean param_list_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "param_list_2")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // PAREN_LEFT expression PAREN_RIGHT
  public static boolean paren_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "paren_expression")) return false;
    if (!nextTokenIs(b, PAREN_LEFT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PAREN_LEFT);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, PAREN_RIGHT);
    exit_section_(b, m, PAREN_EXPRESSION, r);
    return r;
  }

  /* ********************************************************** */
  // BRACKET_LEFT expression BRACKET_RIGHT postfix_expression?
  //     | PERIOD IDENT postfix_expression?
  public static boolean postfix_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "postfix_expression")) return false;
    if (!nextTokenIs(b, "<postfix expression>", BRACKET_LEFT, PERIOD)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, POSTFIX_EXPRESSION, "<postfix expression>");
    r = postfix_expression_0(b, l + 1);
    if (!r) r = postfix_expression_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // BRACKET_LEFT expression BRACKET_RIGHT postfix_expression?
  private static boolean postfix_expression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "postfix_expression_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BRACKET_LEFT);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, BRACKET_RIGHT);
    r = r && postfix_expression_0_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // postfix_expression?
  private static boolean postfix_expression_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "postfix_expression_0_3")) return false;
    postfix_expression(b, l + 1);
    return true;
  }

  // PERIOD IDENT postfix_expression?
  private static boolean postfix_expression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "postfix_expression_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, PERIOD, IDENT);
    r = r && postfix_expression_1_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // postfix_expression?
  private static boolean postfix_expression_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "postfix_expression_1_2")) return false;
    postfix_expression(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // func_call_statement
  //     | variable_reference
  //     | type_decl argument_expression_list
  //     | const_literal
  //     | paren_expression
  //     | BITCAST LESS_THAN type_decl GREATER_THAN paren_expression
  public static boolean primary_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primary_expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PRIMARY_EXPRESSION, "<primary expression>");
    r = func_call_statement(b, l + 1);
    if (!r) r = variable_reference(b, l + 1);
    if (!r) r = primary_expression_2(b, l + 1);
    if (!r) r = const_literal(b, l + 1);
    if (!r) r = paren_expression(b, l + 1);
    if (!r) r = primary_expression_5(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // type_decl argument_expression_list
  private static boolean primary_expression_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primary_expression_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = type_decl(b, l + 1);
    r = r && argument_expression_list(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // BITCAST LESS_THAN type_decl GREATER_THAN paren_expression
  private static boolean primary_expression_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primary_expression_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, BITCAST, LESS_THAN);
    r = r && type_decl(b, l + 1);
    r = r && consumeToken(b, GREATER_THAN);
    r = r && paren_expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // RETURN expression?
  public static boolean return_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "return_statement")) return false;
    if (!nextTokenIs(b, RETURN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RETURN);
    r = r && return_statement_1(b, l + 1);
    exit_section_(b, m, RETURN_STATEMENT, r);
    return r;
  }

  // expression?
  private static boolean return_statement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "return_statement_1")) return false;
    expression(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // TEXTURE_1D
  //     | TEXTURE_2D
  //     | TEXTURE_2D_ARRAY
  //     | TEXTURE_3D
  //     | TEXTURE_CUBE
  //     | TEXTURE_CUBE_ARRAY
  public static boolean sampled_texture_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sampled_texture_type")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SAMPLED_TEXTURE_TYPE, "<sampled texture type>");
    r = consumeToken(b, TEXTURE_1D);
    if (!r) r = consumeToken(b, TEXTURE_2D);
    if (!r) r = consumeToken(b, TEXTURE_2D_ARRAY);
    if (!r) r = consumeToken(b, TEXTURE_3D);
    if (!r) r = consumeToken(b, TEXTURE_CUBE);
    if (!r) r = consumeToken(b, TEXTURE_CUBE_ARRAY);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // SAMPLER
  //     | SAMPLER_COMPARISON
  public static boolean sampler_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sampler_type")) return false;
    if (!nextTokenIs(b, "<sampler type>", SAMPLER, SAMPLER_COMPARISON)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SAMPLER_TYPE, "<sampler type>");
    r = consumeToken(b, SAMPLER);
    if (!r) r = consumeToken(b, SAMPLER_COMPARISON);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // primary_expression postfix_expression?
  public static boolean singular_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "singular_expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SINGULAR_EXPRESSION, "<singular expression>");
    r = primary_expression(b, l + 1);
    r = r && singular_expression_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // postfix_expression?
  private static boolean singular_expression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "singular_expression_1")) return false;
    postfix_expression(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // SEMICOLON
  //  | return_statement SEMICOLON
  //  | if_statement
  //  | switch_statement
  //  | loop_statement
  //  | for_statement
  //  | while_statement
  //  | func_call_statement SEMICOLON
  //  | variable_statement SEMICOLON
  //  | break_statement SEMICOLON
  //  | continue_statement SEMICOLON
  //  | DISCARD SEMICOLON
  //  | assignment_statement SEMICOLON
  //  | compound_statement
  //  | increment_statement SEMICOLON
  //  | decrement_statement SEMICOLON
  //  | static_assert_statement SEMICOLON
  public static boolean statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STATEMENT, "<statement>");
    r = consumeToken(b, SEMICOLON);
    if (!r) r = statement_1(b, l + 1);
    if (!r) r = if_statement(b, l + 1);
    if (!r) r = switch_statement(b, l + 1);
    if (!r) r = loop_statement(b, l + 1);
    if (!r) r = for_statement(b, l + 1);
    if (!r) r = while_statement(b, l + 1);
    if (!r) r = statement_7(b, l + 1);
    if (!r) r = statement_8(b, l + 1);
    if (!r) r = statement_9(b, l + 1);
    if (!r) r = statement_10(b, l + 1);
    if (!r) r = parseTokens(b, 0, DISCARD, SEMICOLON);
    if (!r) r = statement_12(b, l + 1);
    if (!r) r = compound_statement(b, l + 1);
    if (!r) r = statement_14(b, l + 1);
    if (!r) r = statement_15(b, l + 1);
    if (!r) r = statement_16(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // return_statement SEMICOLON
  private static boolean statement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = return_statement(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, null, r);
    return r;
  }

  // func_call_statement SEMICOLON
  private static boolean statement_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_7")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = func_call_statement(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, null, r);
    return r;
  }

  // variable_statement SEMICOLON
  private static boolean statement_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_8")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = variable_statement(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, null, r);
    return r;
  }

  // break_statement SEMICOLON
  private static boolean statement_9(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_9")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = break_statement(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, null, r);
    return r;
  }

  // continue_statement SEMICOLON
  private static boolean statement_10(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_10")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = continue_statement(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, null, r);
    return r;
  }

  // assignment_statement SEMICOLON
  private static boolean statement_12(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_12")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = assignment_statement(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, null, r);
    return r;
  }

  // increment_statement SEMICOLON
  private static boolean statement_14(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_14")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = increment_statement(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, null, r);
    return r;
  }

  // decrement_statement SEMICOLON
  private static boolean statement_15(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_15")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = decrement_statement(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, null, r);
    return r;
  }

  // static_assert_statement SEMICOLON
  private static boolean statement_16(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_16")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = static_assert_statement(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // STATIC_ASSERT expression
  public static boolean static_assert_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "static_assert_statement")) return false;
    if (!nextTokenIs(b, STATIC_ASSERT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, STATIC_ASSERT);
    r = r && expression(b, l + 1);
    exit_section_(b, m, STATIC_ASSERT_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // FUNCTION
  //     | PRIVATE
  //     | WORKGROUP
  //     | UNIFORM
  //     | STORAGE
  //     | PUSH_CONSTANT
  public static boolean storage_class(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "storage_class")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STORAGE_CLASS, "<storage class>");
    r = consumeToken(b, FUNCTION);
    if (!r) r = consumeToken(b, PRIVATE);
    if (!r) r = consumeToken(b, WORKGROUP);
    if (!r) r = consumeToken(b, UNIFORM);
    if (!r) r = consumeToken(b, STORAGE);
    if (!r) r = consumeToken(b, PUSH_CONSTANT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // TEXTURE_STORAGE_1D
  //     | TEXTURE_STORAGE_2D
  //     | TEXTURE_STORAGE_2D_ARRAY
  //     | TEXTURE_STORAGE_3D
  public static boolean storage_texture_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "storage_texture_type")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STORAGE_TEXTURE_TYPE, "<storage texture type>");
    r = consumeToken(b, TEXTURE_STORAGE_1D);
    if (!r) r = consumeToken(b, TEXTURE_STORAGE_2D);
    if (!r) r = consumeToken(b, TEXTURE_STORAGE_2D_ARRAY);
    if (!r) r = consumeToken(b, TEXTURE_STORAGE_3D);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // BRACE_LEFT struct_member* BRACE_RIGHT
  public static boolean struct_body_decl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "struct_body_decl")) return false;
    if (!nextTokenIs(b, BRACE_LEFT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BRACE_LEFT);
    r = r && struct_body_decl_1(b, l + 1);
    r = r && consumeToken(b, BRACE_RIGHT);
    exit_section_(b, m, STRUCT_BODY_DECL, r);
    return r;
  }

  // struct_member*
  private static boolean struct_body_decl_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "struct_body_decl_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!struct_member(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "struct_body_decl_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // attribute_list * STRUCT IDENT struct_body_decl
  public static boolean struct_decl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "struct_decl")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STRUCT_DECL, "<struct decl>");
    r = struct_decl_0(b, l + 1);
    r = r && consumeTokens(b, 0, STRUCT, IDENT);
    r = r && struct_body_decl(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // attribute_list *
  private static boolean struct_decl_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "struct_decl_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!attribute_list(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "struct_decl_0", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // attribute_list* field (SEMICOLON | COMMA?)
  public static boolean struct_member(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "struct_member")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STRUCT_MEMBER, "<struct member>");
    r = struct_member_0(b, l + 1);
    r = r && field(b, l + 1);
    r = r && struct_member_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // attribute_list*
  private static boolean struct_member_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "struct_member_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!attribute_list(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "struct_member_0", c)) break;
    }
    return true;
  }

  // SEMICOLON | COMMA?
  private static boolean struct_member_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "struct_member_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SEMICOLON);
    if (!r) r = struct_member_2_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COMMA?
  private static boolean struct_member_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "struct_member_2_1")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // CASE case_selectors COLON BRACE_LEFT case_body? BRACE_RIGHT
  //     | DEFAULT COLON BRACE_LEFT case_body? BRACE_RIGHT
  public static boolean switch_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "switch_body")) return false;
    if (!nextTokenIs(b, "<switch body>", CASE, DEFAULT)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SWITCH_BODY, "<switch body>");
    r = switch_body_0(b, l + 1);
    if (!r) r = switch_body_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // CASE case_selectors COLON BRACE_LEFT case_body? BRACE_RIGHT
  private static boolean switch_body_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "switch_body_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CASE);
    r = r && case_selectors(b, l + 1);
    r = r && consumeTokens(b, 0, COLON, BRACE_LEFT);
    r = r && switch_body_0_4(b, l + 1);
    r = r && consumeToken(b, BRACE_RIGHT);
    exit_section_(b, m, null, r);
    return r;
  }

  // case_body?
  private static boolean switch_body_0_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "switch_body_0_4")) return false;
    case_body(b, l + 1);
    return true;
  }

  // DEFAULT COLON BRACE_LEFT case_body? BRACE_RIGHT
  private static boolean switch_body_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "switch_body_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, DEFAULT, COLON, BRACE_LEFT);
    r = r && switch_body_1_3(b, l + 1);
    r = r && consumeToken(b, BRACE_RIGHT);
    exit_section_(b, m, null, r);
    return r;
  }

  // case_body?
  private static boolean switch_body_1_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "switch_body_1_3")) return false;
    case_body(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // SWITCH paren_expression BRACE_LEFT switch_body+ BRACE_RIGHT
  public static boolean switch_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "switch_statement")) return false;
    if (!nextTokenIs(b, SWITCH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SWITCH);
    r = r && paren_expression(b, l + 1);
    r = r && consumeToken(b, BRACE_LEFT);
    r = r && switch_statement_3(b, l + 1);
    r = r && consumeToken(b, BRACE_RIGHT);
    exit_section_(b, m, SWITCH_STATEMENT, r);
    return r;
  }

  // switch_body+
  private static boolean switch_statement_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "switch_statement_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = switch_body(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!switch_body(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "switch_statement_3", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IDENT
  public static boolean texel_format(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "texel_format")) return false;
    if (!nextTokenIs(b, IDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENT);
    exit_section_(b, m, TEXEL_FORMAT, r);
    return r;
  }

  /* ********************************************************** */
  // sampler_type
  //     | depth_texture_type
  //     | sampled_texture_type LESS_THAN type_decl GREATER_THAN
  //     | multisampled_texture_type LESS_THAN type_decl GREATER_THAN
  //     | storage_texture_type LESS_THAN texel_format COMMA access_mode GREATER_THAN
  public static boolean texture_sampler_types(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "texture_sampler_types")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TEXTURE_SAMPLER_TYPES, "<texture sampler types>");
    r = sampler_type(b, l + 1);
    if (!r) r = depth_texture_type(b, l + 1);
    if (!r) r = texture_sampler_types_2(b, l + 1);
    if (!r) r = texture_sampler_types_3(b, l + 1);
    if (!r) r = texture_sampler_types_4(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // sampled_texture_type LESS_THAN type_decl GREATER_THAN
  private static boolean texture_sampler_types_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "texture_sampler_types_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = sampled_texture_type(b, l + 1);
    r = r && consumeToken(b, LESS_THAN);
    r = r && type_decl(b, l + 1);
    r = r && consumeToken(b, GREATER_THAN);
    exit_section_(b, m, null, r);
    return r;
  }

  // multisampled_texture_type LESS_THAN type_decl GREATER_THAN
  private static boolean texture_sampler_types_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "texture_sampler_types_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = multisampled_texture_type(b, l + 1);
    r = r && consumeToken(b, LESS_THAN);
    r = r && type_decl(b, l + 1);
    r = r && consumeToken(b, GREATER_THAN);
    exit_section_(b, m, null, r);
    return r;
  }

  // storage_texture_type LESS_THAN texel_format COMMA access_mode GREATER_THAN
  private static boolean texture_sampler_types_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "texture_sampler_types_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = storage_texture_type(b, l + 1);
    r = r && consumeToken(b, LESS_THAN);
    r = r && texel_format(b, l + 1);
    r = r && consumeToken(b, COMMA);
    r = r && access_mode(b, l + 1);
    r = r && consumeToken(b, GREATER_THAN);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // global_directive* global_decl*
  static boolean translation_unit(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "translation_unit")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = translation_unit_0(b, l + 1);
    r = r && translation_unit_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // global_directive*
  private static boolean translation_unit_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "translation_unit_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!global_directive(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "translation_unit_0", c)) break;
    }
    return true;
  }

  // global_decl*
  private static boolean translation_unit_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "translation_unit_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!global_decl(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "translation_unit_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // TYPE IDENT EQUAL type_decl
  public static boolean type_alias_decl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_alias_decl")) return false;
    if (!nextTokenIs(b, TYPE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, TYPE, IDENT, EQUAL);
    r = r && type_decl(b, l + 1);
    exit_section_(b, m, TYPE_ALIAS_DECL, r);
    return r;
  }

  /* ********************************************************** */
  // IDENT
  //     | BOOL
  //     | FLOAT32
  //     | INT32
  //     | UINT32
  //     | vec_prefix LESS_THAN type_decl GREATER_THAN
  //     | POINTER LESS_THAN storage_class COMMA type_decl ( COMMA access_mode )? GREATER_THAN
  //     | array_type_decl
  //     | mat_prefix LESS_THAN type_decl GREATER_THAN
  //     | ATOMIC LESS_THAN type_decl GREATER_THAN
  //     | texture_sampler_types
  public static boolean type_decl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_decl")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE_DECL, "<type decl>");
    r = consumeToken(b, IDENT);
    if (!r) r = consumeToken(b, BOOL);
    if (!r) r = consumeToken(b, FLOAT32);
    if (!r) r = consumeToken(b, INT32);
    if (!r) r = consumeToken(b, UINT32);
    if (!r) r = type_decl_5(b, l + 1);
    if (!r) r = type_decl_6(b, l + 1);
    if (!r) r = array_type_decl(b, l + 1);
    if (!r) r = type_decl_8(b, l + 1);
    if (!r) r = type_decl_9(b, l + 1);
    if (!r) r = texture_sampler_types(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // vec_prefix LESS_THAN type_decl GREATER_THAN
  private static boolean type_decl_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_decl_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = vec_prefix(b, l + 1);
    r = r && consumeToken(b, LESS_THAN);
    r = r && type_decl(b, l + 1);
    r = r && consumeToken(b, GREATER_THAN);
    exit_section_(b, m, null, r);
    return r;
  }

  // POINTER LESS_THAN storage_class COMMA type_decl ( COMMA access_mode )? GREATER_THAN
  private static boolean type_decl_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_decl_6")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, POINTER, LESS_THAN);
    r = r && storage_class(b, l + 1);
    r = r && consumeToken(b, COMMA);
    r = r && type_decl(b, l + 1);
    r = r && type_decl_6_5(b, l + 1);
    r = r && consumeToken(b, GREATER_THAN);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( COMMA access_mode )?
  private static boolean type_decl_6_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_decl_6_5")) return false;
    type_decl_6_5_0(b, l + 1);
    return true;
  }

  // COMMA access_mode
  private static boolean type_decl_6_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_decl_6_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && access_mode(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // mat_prefix LESS_THAN type_decl GREATER_THAN
  private static boolean type_decl_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_decl_8")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = mat_prefix(b, l + 1);
    r = r && consumeToken(b, LESS_THAN);
    r = r && type_decl(b, l + 1);
    r = r && consumeToken(b, GREATER_THAN);
    exit_section_(b, m, null, r);
    return r;
  }

  // ATOMIC LESS_THAN type_decl GREATER_THAN
  private static boolean type_decl_9(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_decl_9")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ATOMIC, LESS_THAN);
    r = r && type_decl(b, l + 1);
    r = r && consumeToken(b, GREATER_THAN);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // singular_expression
  //     | MINUS unary_expression
  //     | BANG unary_expression
  //     | TILDE unary_expression
  //     | STAR unary_expression
  //     | AND unary_expression
  public static boolean unary_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unary_expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, UNARY_EXPRESSION, "<unary expression>");
    r = singular_expression(b, l + 1);
    if (!r) r = unary_expression_1(b, l + 1);
    if (!r) r = unary_expression_2(b, l + 1);
    if (!r) r = unary_expression_3(b, l + 1);
    if (!r) r = unary_expression_4(b, l + 1);
    if (!r) r = unary_expression_5(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // MINUS unary_expression
  private static boolean unary_expression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unary_expression_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MINUS);
    r = r && unary_expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // BANG unary_expression
  private static boolean unary_expression_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unary_expression_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BANG);
    r = r && unary_expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // TILDE unary_expression
  private static boolean unary_expression_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unary_expression_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TILDE);
    r = r && unary_expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // STAR unary_expression
  private static boolean unary_expression_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unary_expression_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, STAR);
    r = r && unary_expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // AND unary_expression
  private static boolean unary_expression_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unary_expression_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, AND);
    r = r && unary_expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // VAR variable_qualifier? variable_ident_decl
  public static boolean variable_decl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_decl")) return false;
    if (!nextTokenIs(b, VAR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, VAR);
    r = r && variable_decl_1(b, l + 1);
    r = r && variable_ident_decl(b, l + 1);
    exit_section_(b, m, VARIABLE_DECL, r);
    return r;
  }

  // variable_qualifier?
  private static boolean variable_decl_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_decl_1")) return false;
    variable_qualifier(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // IDENT (COLON type_decl)?
  public static boolean variable_ident_decl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_ident_decl")) return false;
    if (!nextTokenIs(b, IDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENT);
    r = r && variable_ident_decl_1(b, l + 1);
    exit_section_(b, m, VARIABLE_IDENT_DECL, r);
    return r;
  }

  // (COLON type_decl)?
  private static boolean variable_ident_decl_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_ident_decl_1")) return false;
    variable_ident_decl_1_0(b, l + 1);
    return true;
  }

  // COLON type_decl
  private static boolean variable_ident_decl_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_ident_decl_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && type_decl(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LESS_THAN storage_class ( COMMA access_mode )? GREATER_THAN
  public static boolean variable_qualifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_qualifier")) return false;
    if (!nextTokenIs(b, LESS_THAN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LESS_THAN);
    r = r && storage_class(b, l + 1);
    r = r && variable_qualifier_2(b, l + 1);
    r = r && consumeToken(b, GREATER_THAN);
    exit_section_(b, m, VARIABLE_QUALIFIER, r);
    return r;
  }

  // ( COMMA access_mode )?
  private static boolean variable_qualifier_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_qualifier_2")) return false;
    variable_qualifier_2_0(b, l + 1);
    return true;
  }

  // COMMA access_mode
  private static boolean variable_qualifier_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_qualifier_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && access_mode(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IDENT
  public static boolean variable_reference(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_reference")) return false;
    if (!nextTokenIs(b, IDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENT);
    exit_section_(b, m, VARIABLE_REFERENCE, r);
    return r;
  }

  /* ********************************************************** */
  // variable_decl (EQUAL expression)?
  //     | LET variable_ident_decl EQUAL expression
  public static boolean variable_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_statement")) return false;
    if (!nextTokenIs(b, "<variable statement>", LET, VAR)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VARIABLE_STATEMENT, "<variable statement>");
    r = variable_statement_0(b, l + 1);
    if (!r) r = variable_statement_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // variable_decl (EQUAL expression)?
  private static boolean variable_statement_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_statement_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = variable_decl(b, l + 1);
    r = r && variable_statement_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (EQUAL expression)?
  private static boolean variable_statement_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_statement_0_1")) return false;
    variable_statement_0_1_0(b, l + 1);
    return true;
  }

  // EQUAL expression
  private static boolean variable_statement_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_statement_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EQUAL);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LET variable_ident_decl EQUAL expression
  private static boolean variable_statement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_statement_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LET);
    r = r && variable_ident_decl(b, l + 1);
    r = r && consumeToken(b, EQUAL);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // VEC2
  //     | VEC3
  //     | VEC4
  public static boolean vec_prefix(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vec_prefix")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VEC_PREFIX, "<vec prefix>");
    r = consumeToken(b, VEC2);
    if (!r) r = consumeToken(b, VEC3);
    if (!r) r = consumeToken(b, VEC4);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // WHILE expression compound_statement
  public static boolean while_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "while_statement")) return false;
    if (!nextTokenIs(b, WHILE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, WHILE);
    r = r && expression(b, l + 1);
    r = r && compound_statement(b, l + 1);
    exit_section_(b, m, WHILE_STATEMENT, r);
    return r;
  }

}

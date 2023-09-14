package wgslplugin.language;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import java.util.*;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static wgslplugin.language.psi.WGSLTypes.*;

%%

%{
  private static final class State {
    final int state;

    private State(int state) {
      this.state = state;
    }
  }

  protected final Stack<State> myStateStack = new Stack<>();

  private void pushState(int state) {
    myStateStack.push(new State(yystate()));
    yybegin(state);
  }

  private void popState() {
    State state = myStateStack.pop();
    yybegin(state.state);
  }

  public _WgslLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class _WgslLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

%state TYPE_SPEC
%state BIND_SPEC
%state ATTRIBUTE

// note: newlines are parsed separately to allow leading whitespace on a preprocessor declaration line
WHITE_SPACE=[^\S\r\n]+
NEWLINE=[\r\n]+

LINE_COMMENT             = "//"[^\r\n]*
DOC_COMMENT              = "/**"([^"*"]|("*"+[^"*""/"]))*("*"+"/")?
BLOCK_COMMENT            = "/*"([^"*"]|("*"+[^"*""/"]))*("*"+"/")?
INT_LITERAL              = -?0x[0-9a-fA-F]+|0|-?[1-9][0-9]*
UINT_LITERAL             = 0x[0-9a-fA-F]+u|0u|[1-9][0-9]*u
DECIMAL_FLOAT_LITERAL    = ((-?[0-9]*\.[0-9]+|-?[0-9]+\.[0-9]*)((e|E)(\+|-)?[0-9]+)?f?)|(-?[0-9]+(e|E)(\+|-)?[0-9]+f?)
HEX_FLOAT_LITERAL        = -?0x((([0-9a-fA-F]*\.[0-9a-fA-F]+|[0-9a-fA-F]+\.[0-9a-fA-F]*)((p|P)(\+|-)?[0-9]+f?)?)|([0-9a-fA-F]+(p|P)(\+|-)?[0-9]+f?))
PREPROCESSOR_DECLARATION = "#"[^\r\n]*

IDENT = ([a-zA-Z_][0-9a-zA-Z_][0-9a-zA-Z_]*)|([a-zA-Z][0-9a-zA-Z_]*)

%%

<YYINITIAL>  ^\s*{PREPROCESSOR_DECLARATION}         { return PREPROCESSOR_DECLARATION; }
<YYINITIAL, TYPE_SPEC, BIND_SPEC, ATTRIBUTE>  {WHITE_SPACE}    { return WHITE_SPACE; }
<YYINITIAL, TYPE_SPEC, BIND_SPEC, ATTRIBUTE>  {NEWLINE}        { return WHITE_SPACE; }
<YYINITIAL, TYPE_SPEC, BIND_SPEC, ATTRIBUTE>  {LINE_COMMENT}   { return LINE_COMMENT; }
<YYINITIAL, TYPE_SPEC, BIND_SPEC, ATTRIBUTE>  {BLOCK_COMMENT}  { return BLOCK_COMMENT; }
<YYINITIAL, TYPE_SPEC, BIND_SPEC, ATTRIBUTE>  {INT_LITERAL}    { return INT_LITERAL; }
<YYINITIAL, TYPE_SPEC, BIND_SPEC, ATTRIBUTE>  {UINT_LITERAL}   { return UINT_LITERAL; }
<YYINITIAL, ATTRIBUTE>  "true"                      { return TRUE; }
<YYINITIAL, ATTRIBUTE>  "false"                     { return FALSE; }
<YYINITIAL, ATTRIBUTE>  {DECIMAL_FLOAT_LITERAL}     { return DECIMAL_FLOAT_LITERAL; }
<YYINITIAL, ATTRIBUTE>  {HEX_FLOAT_LITERAL}         { return HEX_FLOAT_LITERAL; }
<YYINITIAL>  "[["                                   { pushState(ATTRIBUTE); return ATTR_LEFT; }
<YYINITIAL, TYPE_SPEC, ATTRIBUTE>  ","              { return COMMA; }
<ATTRIBUTE>  "]]"                                   { popState(); return ATTR_RIGHT; }
<YYINITIAL, ATTRIBUTE>  "("                         { return PAREN_LEFT; }
<TYPE_SPEC>  "("                                    { popState(); return PAREN_LEFT; }
<YYINITIAL, ATTRIBUTE>  ")"                         { return PAREN_RIGHT; }
<YYINITIAL>  "array"                            { pushState(TYPE_SPEC); return ARRAY; }
<YYINITIAL>  "<"                                { return LESS_THAN; }
<TYPE_SPEC, BIND_SPEC>  "<"                     { return TYPE_LESS_THAN; }
<YYINITIAL>  ">"                                { return GREATER_THAN; }
<TYPE_SPEC, BIND_SPEC>  ">"                     { popState(); return TYPE_GREATER_THAN; }
<YYINITIAL>  "struct"                           { return STRUCT; }
<YYINITIAL>  "{"                                { return BRACE_LEFT; }
<YYINITIAL>  "}"                                { return BRACE_RIGHT; }
<YYINITIAL>  ";"                                { return SEMICOLON; }
<YYINITIAL>  "@"                                { return AT; }

<TYPE_SPEC>  "function"                         { return FUNCTION; }
<TYPE_SPEC>  "private"                          { return PRIVATE; }
<TYPE_SPEC>  "workgroup"                        { return WORKGROUP; }
<TYPE_SPEC>  "uniform"                          { return UNIFORM; }
<TYPE_SPEC>  "storage"                          { return STORAGE; }
<TYPE_SPEC>  "push_constant"                    { return PUSH_CONSTANT; }

<TYPE_SPEC>  "read"                             { return READ; }
<TYPE_SPEC>  "write"                            { return WRITE; }
<TYPE_SPEC>  "read_write"                       { return READ_WRITE; }

<YYINITIAL>  "sampler"                          { return SAMPLER; }
<YYINITIAL>  "sampler_comparison"               { return SAMPLER_COMPARISON; }

<YYINITIAL, BIND_SPEC>  "texture_1d"                       { pushState(TYPE_SPEC); return TEXTURE_1D; }
<YYINITIAL, BIND_SPEC>  "texture_2d"                       { pushState(TYPE_SPEC); return TEXTURE_2D; }
<YYINITIAL, BIND_SPEC>  "texture_2d_array"                 { pushState(TYPE_SPEC); return TEXTURE_2D_ARRAY; }
<YYINITIAL, BIND_SPEC>  "texture_3d"                       { pushState(TYPE_SPEC); return TEXTURE_3D; }
<YYINITIAL, BIND_SPEC>  "texture_cube"                     { pushState(TYPE_SPEC); return TEXTURE_CUBE; }
<YYINITIAL, BIND_SPEC>  "texture_cube_array"               { pushState(TYPE_SPEC); return TEXTURE_CUBE_ARRAY; }
<YYINITIAL, BIND_SPEC>  "texture_multisampled_2d"          { pushState(TYPE_SPEC); return TEXTURE_MULTISAMPLED_2D; }
<YYINITIAL, BIND_SPEC>  "texture_storage_1d"               { pushState(TYPE_SPEC); return TEXTURE_STORAGE_1D; }
<YYINITIAL, BIND_SPEC>  "texture_storage_2d"               { pushState(TYPE_SPEC); return TEXTURE_STORAGE_2D; }
<YYINITIAL, BIND_SPEC>  "texture_storage_2d_array"         { pushState(TYPE_SPEC); return TEXTURE_STORAGE_2D_ARRAY; }
<YYINITIAL, BIND_SPEC>  "texture_storage_3d"               { pushState(TYPE_SPEC); return TEXTURE_STORAGE_3D; }

<YYINITIAL, BIND_SPEC>  "texture_depth_2d"                 { return TEXTURE_DEPTH_2D; }
<YYINITIAL, BIND_SPEC>  "texture_depth_2d_array"           { return TEXTURE_DEPTH_2D_ARRAY; }
<YYINITIAL, BIND_SPEC>  "texture_depth_cube"               { return TEXTURE_DEPTH_CUBE; }
<YYINITIAL, BIND_SPEC>  "texture_depth_cube_array"         { return TEXTURE_DEPTH_CUBE_ARRAY; }
<YYINITIAL, BIND_SPEC>  "texture_depth_multisampled_2d"    { return TEXTURE_DEPTH_MULTISAMPLED_2D; }

<YYINITIAL>  "type"                             { return TYPE; }
<YYINITIAL>  "="                                { return EQUAL; }
<TYPE_SPEC>  "="                                { popState(); return EQUAL; }
<YYINITIAL, TYPE_SPEC, BIND_SPEC>  "bool"                  { return BOOL; }
<YYINITIAL, TYPE_SPEC, BIND_SPEC>  "f32"                   { return FLOAT32; }
<YYINITIAL, TYPE_SPEC, BIND_SPEC>  "i32"                   { return INT32; }
<YYINITIAL, TYPE_SPEC, BIND_SPEC>  "u32"                   { return UINT32; }

<YYINITIAL, TYPE_SPEC, BIND_SPEC>  "vec2"                  { pushState(TYPE_SPEC); return VEC2; }
<YYINITIAL, TYPE_SPEC, BIND_SPEC>  "vec3"                  { pushState(TYPE_SPEC); return VEC3; }
<YYINITIAL, TYPE_SPEC, BIND_SPEC>  "vec4"                  { pushState(TYPE_SPEC); return VEC4; }
<YYINITIAL, TYPE_SPEC, BIND_SPEC>  "ptr"                   { pushState(TYPE_SPEC); return POINTER; }
<YYINITIAL, TYPE_SPEC, BIND_SPEC>  "mat2x2"                { pushState(TYPE_SPEC); return MAT2X2; }
<YYINITIAL, TYPE_SPEC, BIND_SPEC>  "mat2x3"                { pushState(TYPE_SPEC); return MAT2X3; }
<YYINITIAL, TYPE_SPEC, BIND_SPEC>  "mat2x4"                { pushState(TYPE_SPEC); return MAT2X4; }
<YYINITIAL, TYPE_SPEC, BIND_SPEC>  "mat3x2"                { pushState(TYPE_SPEC); return MAT3X2; }
<YYINITIAL, TYPE_SPEC, BIND_SPEC>  "mat3x3"                { pushState(TYPE_SPEC); return MAT3X3; }
<YYINITIAL, TYPE_SPEC, BIND_SPEC>  "mat3x4"                { pushState(TYPE_SPEC); return MAT3X4; }
<YYINITIAL, TYPE_SPEC, BIND_SPEC>  "mat4x2"                { pushState(TYPE_SPEC); return MAT4X2; }
<YYINITIAL, TYPE_SPEC, BIND_SPEC>  "mat4x3"                { pushState(TYPE_SPEC); return MAT4X3; }
<YYINITIAL, TYPE_SPEC, BIND_SPEC>  "mat4x4"                { pushState(TYPE_SPEC); return MAT4X4; }
<YYINITIAL, TYPE_SPEC, BIND_SPEC>  "atomic"                { pushState(TYPE_SPEC); return ATOMIC; }
<YYINITIAL>  "let"                              { return LET; }
<YYINITIAL>  "var"                              { pushState(TYPE_SPEC); return VAR; }
<YYINITIAL>  "const"                            { pushState(TYPE_SPEC); return CONST; }
<YYINITIAL>  "override"                         { return OVERRIDE; }
<YYINITIAL>  ":"                                { return COLON; }
<TYPE_SPEC>  ":"                                { popState(); return COLON; }
<YYINITIAL>  "bitcast"                          { pushState(TYPE_SPEC); return BITCAST; }
<YYINITIAL>  "["                                { return BRACKET_LEFT; }
<YYINITIAL>  "]"                                { return BRACKET_RIGHT; }
<YYINITIAL>  "."                                { return PERIOD; }
<YYINITIAL>  "--"                               { return MINUS_MINUS; }
<YYINITIAL>  "-"                                { return MINUS; }
<YYINITIAL>  "!"                                { return BANG; }
<YYINITIAL>  "~"                                { return TILDE; }
<YYINITIAL>  "*"                                { return STAR; }
<YYINITIAL>  "&"                                { return AND; }
<YYINITIAL>  "/"                                { return FORWARD_SLASH; }
<YYINITIAL>  "%"                                { return MODULO; }
<YYINITIAL>  "++"                               { return PLUS_PLUS; }
<YYINITIAL>  "+"                                { return PLUS; }
<YYINITIAL>  "<<"                               { return SHIFT_LEFT; }
<YYINITIAL>  ">>"                               { return SHIFT_RIGHT; }
<YYINITIAL>  "<="                               { return LESS_THAN_EQUAL; }
<YYINITIAL>  ">="                               { return GREATER_THAN_EQUAL; }
<YYINITIAL>  "=="                               { return EQUAL_EQUAL; }
<YYINITIAL>  "!="                               { return NOT_EQUAL; }
<YYINITIAL>  "&&"                               { return AND_AND; }
<YYINITIAL>  "||"                               { return OR_OR; }
<YYINITIAL>  "|"                                { return OR; }
<YYINITIAL>  "^"                                { return XOR; }
<YYINITIAL>  "_"                                { return UNDERSCORE; }
<YYINITIAL>  "if"                               { return IF; }
<YYINITIAL>  "else"                             { return ELSE; }
<YYINITIAL>  "switch"                           { return SWITCH; }
<YYINITIAL>  "case"                             { return CASE; }
<YYINITIAL>  "default"                          { return DEFAULT; }
<YYINITIAL>  "fallthrough"                      { return FALLTHROUGH; }
<YYINITIAL>  "loop"                             { return LOOP; }
<YYINITIAL>  "for"                              { return FOR; }
<YYINITIAL>  "break"                            { return BREAK; }
<YYINITIAL>  "continue"                         { return CONTINUE; }
<YYINITIAL>  "continuing"                       { return CONTINUING; }
<YYINITIAL>  "return"                           { return RETURN; }
<YYINITIAL>  "discard"                          { return DISCARD; }
<YYINITIAL>  "fn"                               { return FN; }
<YYINITIAL>  "->"                               { return ARROW; }
<YYINITIAL>  "enable"                           { return ENABLE; }
<YYINITIAL>  "while"                            { return WHILE; }
<YYINITIAL>  "staticAssert"                     { return STATIC_ASSERT; }
<YYINITIAL>  "+="                               { return PLUS_EQUAL; }
<YYINITIAL>  "-="                               { return MINUS_EQUAL; }
<YYINITIAL>  "*="                               { return TIMES_EQUAL; }
<YYINITIAL>  "/="                               { return DIVISION_EQUAL; }
<YYINITIAL>  "%="                               { return MODULO_EQUAL; }
<YYINITIAL>  "&="                               { return AND_EQUAL; }
<YYINITIAL>  "|="                               { return OR_EQUAL; }
<YYINITIAL>  "^="                               { return XOR_EQUAL; }
<YYINITIAL>  ">>="                              { return SHIFT_RIGHT_EQUAL; }
<YYINITIAL>  "<<="                              { return SHIFT_LEFT_EQUAL; }

<YYINITIAL> "binding_array"          { pushState(BIND_SPEC); return BINDING_ARRAY; }


<TYPE_SPEC>  "r8unorm"                          { return R8UNORM; }
<TYPE_SPEC>  "r8snorm"                          { return R8SNORM; }
<TYPE_SPEC>  "r8uint"                           { return R8UINT; }
<TYPE_SPEC>  "r8sint"                           { return R8SINT; }
<TYPE_SPEC>  "r16uint"                          { return R16UINT; }
<TYPE_SPEC>  "r16sint"                          { return R16SINT; }
<TYPE_SPEC>  "r16float"                         { return R16FLOAT; }
<TYPE_SPEC>  "rg8unorm"                         { return RG8UNORM; }
<TYPE_SPEC>  "rg8snorm"                         { return RG8SNORM; }
<TYPE_SPEC>  "rg8uint"                          { return RG8UINT; }
<TYPE_SPEC>  "rg8sint"                          { return RG8SINT; }
<TYPE_SPEC>  "r32uint"                          { return R32UINT; }
<TYPE_SPEC>  "r32sint"                          { return R32SINT; }
<TYPE_SPEC>  "r32float"                         { return R32FLOAT; }
<TYPE_SPEC>  "rg16uint"                         { return RG16UINT; }
<TYPE_SPEC>  "rg16sint"                         { return RG16SINT; }
<TYPE_SPEC>  "rg16float"                        { return RG16FLOAT; }
<TYPE_SPEC>  "rgba8unorm"                       { return RGBA8UNORM; }
<TYPE_SPEC>  "rgba8unorm_srgb"                  { return RGBA8UNORM_SRGB; }
<TYPE_SPEC>  "rgba8snorm"                       { return RGBA8SNORM; }
<TYPE_SPEC>  "rgba8uint"                        { return RGBA8UINT; }
<TYPE_SPEC>  "rgba8sint"                        { return RGBA8SINT; }
<TYPE_SPEC>  "bgra8unorm"                       { return BGRA8UNORM; }
<TYPE_SPEC>  "bgra8unorm_srgb"                  { return BGRA8UNORM_SRGB; }
<TYPE_SPEC>  "rgb10a2unorm"                     { return RGB10A2UNORM; }
<TYPE_SPEC>  "rg11b10float"                     { return RG11B10FLOAT; }
<TYPE_SPEC>  "rg32uint"                         { return RG32UINT; }
<TYPE_SPEC>  "rg32sint"                         { return RG32SINT; }
<TYPE_SPEC>  "rg32float"                        { return RG32FLOAT; }
<TYPE_SPEC>  "rgba16uint"                       { return RGBA16UINT; }
<TYPE_SPEC>  "rgba16sint"                       { return RGBA16SINT; }
<TYPE_SPEC>  "rgba16float"                      { return RGBA16FLOAT; }
<TYPE_SPEC>  "rgba32uint"                       { return RGBA32UINT; }
<TYPE_SPEC>  "rgba32sint"                       { return RGBA32SINT; }
<TYPE_SPEC>  "rgba32float"                      { return RGBA32FLOAT; }

<YYINITIAL, TYPE_SPEC, BIND_SPEC, ATTRIBUTE>  {IDENT}      { return IDENT; }

[^] { return BAD_CHARACTER; }

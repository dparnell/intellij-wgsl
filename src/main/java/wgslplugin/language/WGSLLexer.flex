package wgslplugin.language;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static wgslplugin.language.psi.WGSLTypes.*;

%%

%{
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
<YYINITIAL> {
  ^\s*{PREPROCESSOR_DECLARATION}     { return PREPROCESSOR_DECLARATION; }
  {WHITE_SPACE}                      { return WHITE_SPACE; }
  {NEWLINE}                          { return WHITE_SPACE; }
  {LINE_COMMENT}                     { return LINE_COMMENT; }
  {DOC_COMMENT}                      { return DOC_COMMENT; }
  {BLOCK_COMMENT}                    { return BLOCK_COMMENT; }
  {INT_LITERAL}                      { return INT_LITERAL; }
  {UINT_LITERAL}                     { return UINT_LITERAL; }
  "true"                             { return TRUE; }
  "false"                            { return FALSE; }
  {DECIMAL_FLOAT_LITERAL}            { return DECIMAL_FLOAT_LITERAL; }
  {HEX_FLOAT_LITERAL}                { return HEX_FLOAT_LITERAL; }
  "[["                               { return ATTR_LEFT; }
  ","                                { return COMMA; }
  "]]"                               { return ATTR_RIGHT; }
  "("                                { return PAREN_LEFT; }
  ")"                                { return PAREN_RIGHT; }
  "array"                            { return ARRAY; }
  "<"                                { return LESS_THAN; }
  ">"                                { return GREATER_THAN; }
  "struct"                           { return STRUCT; }
  "{"                                { return BRACE_LEFT; }
  "}"                                { return BRACE_RIGHT; }
  ";"                                { return SEMICOLON; }
  "@"                                { return AT; }

/*
  "read"                             { return READ; }
  "write"                            { return WRITE; }
  "read_write"                       { return READ_WRITE; }
 */
  "function"                         { return FUNCTION; }
  "private"                          { return PRIVATE; }
  "workgroup"                        { return WORKGROUP; }
  "uniform"                          { return UNIFORM; }
  "storage"                          { return STORAGE; }
  "push_constant"                    { return PUSH_CONSTANT; }
  "sampler"                          { return SAMPLER; }
  "sampler_comparison"               { return SAMPLER_COMPARISON; }
  "texture_1d"                       { return TEXTURE_1D; }
  "texture_2d"                       { return TEXTURE_2D; }
  "texture_2d_array"                 { return TEXTURE_2D_ARRAY; }
  "texture_3d"                       { return TEXTURE_3D; }
  "texture_cube"                     { return TEXTURE_CUBE; }
  "texture_cube_array"               { return TEXTURE_CUBE_ARRAY; }
  "texture_multisampled_2d"          { return TEXTURE_MULTISAMPLED_2D; }
  "texture_storage_1d"               { return TEXTURE_STORAGE_1D; }
  "texture_storage_2d"               { return TEXTURE_STORAGE_2D; }
  "texture_storage_2d_array"         { return TEXTURE_STORAGE_2D_ARRAY; }
  "texture_storage_3d"               { return TEXTURE_STORAGE_3D; }
  "texture_depth_2d"                 { return TEXTURE_DEPTH_2D; }
  "texture_depth_2d_array"           { return TEXTURE_DEPTH_2D_ARRAY; }
  "texture_depth_cube"               { return TEXTURE_DEPTH_CUBE; }
  "texture_depth_cube_array"         { return TEXTURE_DEPTH_CUBE_ARRAY; }
  "texture_depth_multisampled_2d"    { return TEXTURE_DEPTH_MULTISAMPLED_2D; }
/*
  "r8unorm"                          { return R8UNORM; }
  "r8snorm"                          { return R8SNORM; }
  "r8uint"                           { return R8UINT; }
  "r8sint"                           { return R8SINT; }
  "r16uint"                          { return R16UINT; }
  "r16sint"                          { return R16SINT; }
  "r16float"                         { return R16FLOAT; }
  "rg8unorm"                         { return RG8UNORM; }
  "rg8snorm"                         { return RG8SNORM; }
  "rg8uint"                          { return RG8UINT; }
  "rg8sint"                          { return RG8SINT; }
  "r32uint"                          { return R32UINT; }
  "r32sint"                          { return R32SINT; }
  "r32float"                         { return R32FLOAT; }
  "rg16uint"                         { return RG16UINT; }
  "rg16sint"                         { return RG16SINT; }
  "rg16float"                        { return RG16FLOAT; }
  "rgba8unorm"                       { return RGBA8UNORM; }
  "rgba8unorm_srgb"                  { return RGBA8UNORM_SRGB; }
  "rgba8snorm"                       { return RGBA8SNORM; }
  "rgba8uint"                        { return RGBA8UINT; }
  "rgba8sint"                        { return RGBA8SINT; }
  "bgra8unorm"                       { return BGRA8UNORM; }
  "bgra8unorm_srgb"                  { return BGRA8UNORM_SRGB; }
  "rgb10a2unorm"                     { return RGB10A2UNORM; }
  "rg11b10float"                     { return RG11B10FLOAT; }
  "rg32uint"                         { return RG32UINT; }
  "rg32sint"                         { return RG32SINT; }
  "rg32float"                        { return RG32FLOAT; }
  "rgba16uint"                       { return RGBA16UINT; }
  "rgba16sint"                       { return RGBA16SINT; }
  "rgba16float"                      { return RGBA16FLOAT; }
  "rgba32uint"                       { return RGBA32UINT; }
  "rgba32sint"                       { return RGBA32SINT; }
  "rgba32float"                      { return RGBA32FLOAT; }
 */
  "type"                             { return TYPE; }
  "="                                { return EQUAL; }
  "bool"                             { return BOOL; }
  "f32"                              { return FLOAT32; }
  "i32"                              { return INT32; }
  "u32"                              { return UINT32; }
  "vec2"                             { return VEC2; }
  "vec3"                             { return VEC3; }
  "vec4"                             { return VEC4; }
  "ptr"                              { return POINTER; }
  "mat2x2"                           { return MAT2X2; }
  "mat2x3"                           { return MAT2X3; }
  "mat2x4"                           { return MAT2X4; }
  "mat3x2"                           { return MAT3X2; }
  "mat3x3"                           { return MAT3X3; }
  "mat3x4"                           { return MAT3X4; }
  "mat4x2"                           { return MAT4X2; }
  "mat4x3"                           { return MAT4X3; }
  "mat4x4"                           { return MAT4X4; }
  "atomic"                           { return ATOMIC; }
  "let"                              { return LET; }
  "var"                              { return VAR; }
  ":"                                { return COLON; }
  "bitcast"                          { return BITCAST; }
  "["                                { return BRACKET_LEFT; }
  "]"                                { return BRACKET_RIGHT; }
  "."                                { return PERIOD; }
  "--"                               { return MINUS_MINUS; }
  "-"                                { return MINUS; }
  "!"                                { return BANG; }
  "~"                                { return TILDE; }
  "*"                                { return STAR; }
  "&"                                { return AND; }
  "/"                                { return FORWARD_SLASH; }
  "%"                                { return MODULO; }
  "++"                               { return PLUS_PLUS; }
  "+"                                { return PLUS; }
  "<<"                               { return SHIFT_LEFT; }
  ">>"                               { return SHIFT_RIGHT; }
  "<="                               { return LESS_THAN_EQUAL; }
  ">="                               { return GREATER_THAN_EQUAL; }
  "=="                               { return EQUAL_EQUAL; }
  "!="                               { return NOT_EQUAL; }
  "&&"                               { return AND_AND; }
  "||"                               { return OR_OR; }
  "|"                                { return OR; }
  "^"                                { return XOR; }
  "_"                                { return UNDERSCORE; }
  "if"                               { return IF; }
  "else"                             { return ELSE; }
  "switch"                           { return SWITCH; }
  "case"                             { return CASE; }
  "default"                          { return DEFAULT; }
  "fallthrough"                      { return FALLTHROUGH; }
  "loop"                             { return LOOP; }
  "for"                              { return FOR; }
  "break"                            { return BREAK; }
  "continue"                         { return CONTINUE; }
  "continuing"                       { return CONTINUING; }
  "return"                           { return RETURN; }
  "discard"                          { return DISCARD; }
  "fn"                               { return FN; }
  "->"                               { return ARROW; }
  "enable"                           { return ENABLE; }
  "while"                            { return WHILE; }
  "staticAssert"                     { return STATIC_ASSERT; }
  {IDENT}                            { return IDENT; }

}

[^] { return BAD_CHARACTER; }

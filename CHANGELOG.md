<!-- Keep a Changelog guide -> https://keepachangelog.com -->

# wgsl plugin Changelog

## [Unreleased]
### Added
- Fixed null pointer exception in the annotator

## [0.0.9]
### Added
- Changes from HolgerGottChristensen
  - Initial code folding implementation
  - A bracket matcher that matches common bracket types
  - Updated annotator to annotate reserved keywords
  - Added keyword completion contributor that allows for completing all built-in keywords.
  - Added built-in completion handler that completes all built-in functions.

## [0.0.8]
### Added
- Changes from HolgerGottChristensen
  - Updated the colour for built in types to be Keyword rather than class name
  - Colour struct fields
  - Colour attributes
  - Colour built in functions
  - Add error when a fragment only function is used outside of a fragment stage
  - Colour function declarations

## [0.0.7]
### Added
- support for proposed new `@attribute` syntax
- hover documentation for attributes

## [0.6.0]
### Added
- updated max build number

## [0.0.5]
### Added
- another attempt at fixing the hover docs in a production build

## [0.0.4]
### Added
- fixed hover doc code. Weird that it works in dev mode but not in the real thing

## [0.0.3]
### Added
- added hover documentation for functions and some help for the builtin functions
- added doc comment support for functions
- implemented rename refactor for variables and references
- better `++` and `--` in the parser

## [0.0.2]
### Added
- added increment `++` and  decrement `--` syntax support

## 0.0.1
### Added
- Colour settings page
- Syntax highlighting using the output from the parser
- Lexer and parser for WGSL
- Initial scaffold created from [IntelliJ Platform Plugin Template](https://github.com/JetBrains/intellij-platform-plugin-template)
<!-- Keep a Changelog guide -> https://keepachangelog.com -->

# wgsl plugin Changelog

## [Unreleased]
### Added
- fix for nested types - #37

## [0.0.17]
### Added
- increase maximum build number for IntelliJ platform to 222 - #36

## [0.0.16]
### Added
- added support for compound assignment operators - see issue #34

## [0.0.15]
### Added
- updating grammar to handle the latest spec changes
  - while
  - staticAssert
  - vec and mat without type when used as a constructor see #32

## [0.0.14]
### Added
- reserved words list update from vibernation
- IDE comment action support
- preprocessor changes from Arc-blroth

## [0.0.13]
### Added
- Added missing attribute docs
- Added simple support for Bevy WGSL preprocessor declarations

## [0.0.12]
### Added
- All currently defined attributes are supported
- Added warnings for deprecated stage attribute
- Added hover documentation for all defined attributes
- Added warnings for deprecated attribute syntax

## [0.0.11]
### Added
- Updated to support comma instead of semicolon in struct definitions
- Updated syntax highlighting example to use more modern syntax

## [0.0.10]
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
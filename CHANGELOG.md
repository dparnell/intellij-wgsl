<!-- Keep a Changelog guide -> https://keepachangelog.com -->

# wgsl plugin Changelog

## [Unreleased]
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
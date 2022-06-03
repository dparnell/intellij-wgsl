```wgsl
@stage(s)
```

`compute`, `vertex`, or `fragment`

Must only be applied to a function declaration.
Declares an entry point by specifying its pipeline stage.

Deprecated, use `@compute`, `@fragment` or `@vertex` attribute instead